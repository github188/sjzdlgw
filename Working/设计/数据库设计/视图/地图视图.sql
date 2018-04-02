/*==============================================================*/
/* View: v_Geom_TunnelSection                                   */
/*==============================================================*/
CREATE OR REPLACE VIEW v_Geom_TunnelSection as(
SELECT TO_CHAR(SDO_GEOMETRY.GET_WKT(gts.Geom)) as GeomStr, gts.Geom, gts.SectionNum, ts.AssetNum, pt.AssetName, pt.VoltageLevelID, pt.TunnelStructureTypeID, ts.OrderNum, pltc.LevelTunnelName,pt.OperationCode, pt.AssetCode,pltc.ShowColor,pltc.LineWidth
  FROM Geom_TunnelSection gts INNER JOIN TunnelSection ts ON ts.SectionNum = gts.SectionNum
         INNER JOIN PowerTunnel pt ON pt.AssetNum = ts.AssetNum
         INNER JOIN PowerLevelTunnelColor pltc ON pltc.TunnelStructureTypeID = pt.TunnelStructureTypeID and pltc.VoltageLevelID = pt.VoltageLevelID
);
/*==============================================================*/
/* View: v_Geom_Manhole                                         */
/*==============================================================*/
CREATE OR REPLACE VIEW v_Geom_Manhole as(
SELECT  TO_CHAR(SDO_GEOMETRY.GET_WKT(mg.Geom)) as GeomStr, mg.Geom, mg.AssetNum, COALESCE(m.Tunnel_AssetNum, -1) AS Tunnel_AssetNum, 
         (CASE WHEN mkt.ManholeTypeID = 4 THEN COALESCE(m.AssetName, m.AssetCode) ELSE m.AssetCode END) AS AssetCodeOrName, 
         m.OperationCode, mkt.ManholeTypeID, m.ManholeKindTypeID,m.AssetCode, m.AssetName ,mkt.ManholeKindTypeName
   FROM Geom_Manhole mg INNER JOIN Manhole m ON m.AssetNum = mg.AssetNum
      INNER JOIN ManholeKindType mkt ON mkt.ManholeKindTypeID = m.ManholeKindTypeID
);
/*==============================================================*/
/* View: v_Geom_Substation                                         */
/*==============================================================*/
CREATE OR REPLACE VIEW v_Geom_Substation as(
SELECT TO_CHAR(SDO_GEOMETRY.GET_WKT(gs.Geom)) as GeomStr,gs.Geom, gs.BaseFacilityNum,bf.BaseFacilityName, bf.AssetCode
    FROM Geom_Substation gs INNER JOIN BaseFacility bf ON bf.BaseFacilityNum = gs.BaseFacilityNum
);