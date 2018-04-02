package com.hbdl.web.sys.service;

import com.hbdl.web.sys.map.*;
import com.hbdl.web.sys.utils.PinYinUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by zgq on 2016/10/21.
 */
@Service
public class MapService{


    @Autowired
    private ManholeService manholeService;

    @Autowired
    private BaseFacilityService baseFacilityService;

    @Autowired
    private TunnelSectionService tunnelSectionService;
                                              //1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16,17,18,19,20,21,22,23
    private static final int[] mapTypes_level={17,16,16,16,16,16,16,16,16,18,17,17,17,17,16,16,16,16,16,16,16,16,14};
    /**
     * 查询地图数据
     * @param map
     * @param ctxPath
     * @return
     */
    public List<MapLayer> selectMapPowerData(Map<String,List> map,String ctxPath,String sqlExtent,int zoom){
        List<MapLayer> mapLayerList=new ArrayList<>();
        if (map!=null && StringUtils.isNotEmpty(sqlExtent)){
            //查询GeomManhole
            List<BigDecimal> manholeKindTypeIDList=map.get("manhole");
            manholeKindTypeIDList=procesMapLevel(manholeKindTypeIDList,zoom);
            if (manholeKindTypeIDList!=null && manholeKindTypeIDList.size()>0){
                GeomManhole geomManhole=new GeomManhole();
                geomManhole.setManholeKindTypeIDs(manholeKindTypeIDList);
                geomManhole.setSqlExtent(sqlExtent);//按区域加载
                List<GeomManhole> geomManholeList=manholeService.selectGeomManhole(geomManhole);
                HashMap<BigDecimal,MapLayer> manholeKindTypeMap=new HashMap<>();
                if (geomManholeList!=null && geomManholeList.size()>0){
                    //构造不同类型图层
                    for (GeomManhole gm:geomManholeList) {
                        MapLayer mapLayer=manholeKindTypeMap.get(gm.getManholeKindTypeID());
                         if (mapLayer==null) {//创建
                             mapLayer=new MapLayer();
                             mapLayer.setName(gm.getManholeTypeID()+"_"+gm.getManholeKindTypeID()+"_"+gm.getManholeKindTypeName());
                             mapLayer.setType("point");
                             if (gm.getManholeKindTypeName().equals("四通井")){
                                 mapLayer.setImage(ctxPath+"/static/website/images/16/SSTJ.png");
                             }else {
                                 mapLayer.setImage(ctxPath+"/static/website/images/16/"+ PinYinUtils.getPinYinFistSpell(gm.getManholeKindTypeName())+".png");
                             }
                             int mapLevel=mapTypes_level[gm.getManholeKindTypeID().intValue()-1];
                             mapLayer.setImage_level(new Integer(mapLevel).toString());
                             if(gm.getManholeKindTypeID().intValue()==1 || gm.getManholeKindTypeID().intValue()==2){
                                 mapLayer.setName_level(new Integer(mapLevel+1).toString());
                             }else{
                                 mapLayer.setName_level(new Integer(mapLevel).toString());
                             }
                             mapLayer.setWeight(new Integer(mapLevel).toString());
                             mapLayer.setDistance("60");
                             List<GeomMap> geomMaps=new ArrayList<>();
                             mapLayer.setGeomMapList(geomMaps);
                             manholeKindTypeMap.put(gm.getManholeKindTypeID(),mapLayer);
                         }
                             GeomMap geomMap=new GeomMap();
                             geomMap.setId(gm.getAssetNum().toString());
                             geomMap.setName(gm.getAssetCodeOrName()+"@"+gm.getOperationCode());
                             geomMap.setType(gm.getManholeTypeID()+"_"+gm.getManholeKindTypeID());
                             geomMap.setGeomStr(gm.getGeomStr());
                             mapLayer.getGeomMapList().add(geomMap);
                    }
                }
                Iterator iterator= manholeKindTypeMap.entrySet().iterator();
                while (iterator.hasNext()){
                    Map.Entry<BigDecimal,MapLayer> entry= (Map.Entry) iterator.next();
                    MapLayer mapLayer=entry.getValue();
                    mapLayerList.add(mapLayer);
                }
            }
            //查询GeomSubstation
            if (map.get("basefacility")!=null && (zoom>=mapTypes_level[21])){
                List<GeomSubstation> geomSubstationList=baseFacilityService.selectGeomSubstation(sqlExtent);
                if (geomSubstationList!=null && geomSubstationList.size()>0){
                    MapLayer mapLayer=new MapLayer();
                    mapLayer.setName("basefacility");
                    mapLayer.setType("geometric");
                    mapLayer.setImage(ctxPath+"/static/website/images/16/BDZ.png");
                    mapLayer.setImage_level(new Integer(mapTypes_level[21]).toString());
                    mapLayer.setName_level(new Integer(mapTypes_level[21]).toString());
                    mapLayer.setWeight(new Integer(mapTypes_level[21]).toString());
                    mapLayer.setDistance("60");
                    List<GeomMap> gmbf=new ArrayList<GeomMap>();
                    for (GeomSubstation gs:geomSubstationList) {
                        GeomMap gm=new GeomMap();
                        gm.setId(gs.getBaseFacilityNum().toString());
                        gm.setName(gs.getBaseFacilityName());
                        gm.setGeomStr(gs.getGeomStr());
                        gm.setType("geometric");
                        gmbf.add(gm);
                    }
                    mapLayer.setGeomMapList(gmbf);
                    mapLayerList.add(mapLayer);
                }
            }
            //查询GeomTunnelSection
            List<BigDecimal> voltageLevelIDList=map.get("tunnelSection1");
            List<BigDecimal> tunnelStructureTypeIDList=map.get("tunnelSection2");
            if (voltageLevelIDList!=null && voltageLevelIDList.size()>0 && tunnelStructureTypeIDList!=null && tunnelStructureTypeIDList.size()>0 && (zoom>=mapTypes_level[22])){
                GeomTunnelSection geomTunnelSection=new GeomTunnelSection();
                geomTunnelSection.setVoltageLevelIDs(voltageLevelIDList);
                geomTunnelSection.setTunnelStructureTypeIDs(tunnelStructureTypeIDList);
                geomTunnelSection.setSqlExtent(sqlExtent);
                List<GeomTunnelSection> geomTunnelSectionList=tunnelSectionService.selectGeomTunnelSection(geomTunnelSection);
                HashMap<String,MapLayer> mapLayerHashMap=new HashMap<>();
                if (geomTunnelSectionList!=null && geomTunnelSectionList.size()>0){
                    for (GeomTunnelSection gts:geomTunnelSectionList) {
                        String key=gts.getVoltageLevelID()+"_"+gts.getTunnelStructureTypeID();
                        MapLayer mapLayer=mapLayerHashMap.get(key);
                        if (mapLayer==null){
                            mapLayer=new MapLayer();
                            mapLayer.setName("line_"+key);
                            mapLayer.setType("line");
                            mapLayer.setImage(gts.getShowColor()+"_"+gts.getLineWidth());
                            mapLayer.setImage_level(new Integer(mapTypes_level[22]).toString());
                            mapLayer.setName_level("20");
                            mapLayer.setWeight("30");
                            mapLayer.setDistance("-1");
                            List<GeomMap> geomMaps=new ArrayList<>();
                            mapLayer.setGeomMapList(geomMaps);
                            mapLayerHashMap.put(key,mapLayer);
                        }
                            GeomMap gm=new GeomMap();
                            gm.setId(gts.getAssetNum()+"_"+gts.getSectionNum());
                            gm.setName(gts.getAssetCode()+"@"+gts.getOperationCode());
                            gm.setType("line");
                            gm.setGeomStr(gts.getGeomStr());
                            mapLayer.getGeomMapList().add(gm);
                    }
                }
                Iterator iterator= mapLayerHashMap.entrySet().iterator();
                while (iterator.hasNext()){
                    Map.Entry<BigDecimal,MapLayer> entry= (Map.Entry) iterator.next();
                    MapLayer mapLayer=entry.getValue();
                    mapLayerList.add(mapLayer);
                }
            }
        }
        return mapLayerList;
    }


    private List<BigDecimal> procesMapLevel(List<BigDecimal> ids,int zoom){
        List<BigDecimal> newIds=new ArrayList<BigDecimal>();
        if (ids!=null && ids.size()>0){
            for (BigDecimal id:ids){
                int zm=mapTypes_level[id.intValue()-1];
                if (zoom>=zm){
                    newIds.add(id);
                }
            }
        }
        return newIds;
    }
}
