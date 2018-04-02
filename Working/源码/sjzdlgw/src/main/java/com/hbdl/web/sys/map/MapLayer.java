package com.hbdl.web.sys.map;

import java.util.List;

/**
 * Created by zgq on 2016/11/19.
 */
public class MapLayer implements java.io.Serializable{

    /**
     * 图层名称
     * 唯一标识
     */
    private String name;
    /**
     * 图标
     */
    private String image;
    /**
     * 图层类型：点线面
     */
    private String type;
    /**
     * 图标显示级别
     */
    private String image_level;
    /**
     * 名字显示级别
     */
    private String name_level;
    /**
     * 权值多个图层相互叠加优先显示
     * 显示权值高的；
     * 从0开始
     */
    private String weight;
    /**
     * 聚合步长
     */
    private String distance;
    /**
     * 图层GIS数据
     */
    private List<GeomMap> geomMapList;

    public MapLayer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage_level() {
        return image_level;
    }

    public void setImage_level(String image_level) {
        this.image_level = image_level;
    }

    public String getName_level() {
        return name_level;
    }

    public void setName_level(String name_level) {
        this.name_level = name_level;
    }

    public List<GeomMap> getGeomMapList() {
        return geomMapList;
    }

    public void setGeomMapList(List<GeomMap> geomMapList) {
        this.geomMapList = geomMapList;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }


    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
