package com.hbdl.web.sys.api.retMapperClass;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by long on 2016/12/5.
 */
public class TunnelDetail3D {


    /**
     * powerTunnel : {"assetNum":54,"archivesCode":"08-021","assetCode":"08-D0023","operationCode":"DLSD 10005","baseFacilityName":"南郊站","areaName":"东4","tunnelStructureTypeName":"隧道","voltageLevelName":"10kV","startStopDescription":"石栾路向东第二个井处进向东进南郊站","positionDescription":"建设大街与石栾路之间，南郊站南侧，孙村小路北侧","frontTopHeight":4.2,"tunnelWidth":1.8,"tunnelHeight":2.2,"tunnelSectionNum":1,"tunnelSection":{"sectionNum":10668,"orderNum":1,"tunnleTowardTypeName":"北","tunnleTowardTypeID":4,"length":74.47,"trestleLayer":[{"trestleLayerNum":584,"memo":"","height":0.25,"layer":1,"voltageLevelName":"10KV","voltageLevelID":4,"trestleStuffTypeID":1,"trestleStuffTypeName":"玻璃钢","trestlePositionTypeID":1,"trestlePositionTypeName":"左侧支架","trestleLength":0.4,"rowTube":[{"rowTubeNum":300,"rowTubeTypeID":5,"rowTubeTypeName":"xx型号","rowTubeDiameter":1.2}],"pathCable":[{"layerCableNum":52359,"cableNum":5797,"orderNum":1,"placeType":1,"isTempCable":false,"rowTubeNum":300,"baseFacilityNum":4,"baseFacilityName":"南郊站","loopLenght":0.62,"voltageLevelName":"10KV","voltageLevelID":4,"modelTypeNum":61,"modelTypeName":"YJLV22-3*240","loopNum":5535,"loopName":"南毛一线716-1-2回","runDate":"2001-6-18","pathSectionNum":4053,"pathSectionName":"南毛一线","pathSectionCode":"716-1","runCode":""}]}]}}
     */

    private PowerTunnelBean powerTunnel;

    public PowerTunnelBean getPowerTunnel() {
        return powerTunnel;
    }

    public void setPowerTunnel(PowerTunnelBean powerTunnel) {
        this.powerTunnel = powerTunnel;
    }

    public static class PowerTunnelBean {
        /**
         * assetNum : 54
         * archivesCode : 08-021
         * assetCode : 08-D0023
         * operationCode : DLSD 10005
         * baseFacilityName : 南郊站
         * areaName : 东4
         * tunnelStructureTypeName : 隧道
         * voltageLevelName : 10kV
         * startStopDescription : 石栾路向东第二个井处进向东进南郊站
         * positionDescription : 建设大街与石栾路之间，南郊站南侧，孙村小路北侧
         * frontTopHeight : 4.2
         * tunnelWidth : 1.8
         * tunnelHeight : 2.2
         * tunnelSectionNum : 1
         * tunnelSection : {"sectionNum":10668,"orderNum":1,"tunnleTowardTypeName":"北","tunnleTowardTypeID":4,"length":74.47,"trestleLayer":[{"trestleLayerNum":584,"memo":"","height":0.25,"layer":1,"voltageLevelName":"10KV","voltageLevelID":4,"trestleStuffTypeID":1,"trestleStuffTypeName":"玻璃钢","trestlePositionTypeID":1,"trestlePositionTypeName":"左侧支架","trestleLength":0.4,"rowTube":[{"rowTubeNum":300,"rowTubeTypeID":5,"rowTubeTypeName":"xx型号","rowTubeDiameter":1.2}],"pathCable":[{"layerCableNum":52359,"cableNum":5797,"orderNum":1,"placeType":1,"isTempCable":false,"rowTubeNum":300,"baseFacilityNum":4,"baseFacilityName":"南郊站","loopLenght":0.62,"voltageLevelName":"10KV","voltageLevelID":4,"modelTypeNum":61,"modelTypeName":"YJLV22-3*240","loopNum":5535,"loopName":"南毛一线716-1-2回","runDate":"2001-6-18","pathSectionNum":4053,"pathSectionName":"南毛一线","pathSectionCode":"716-1","runCode":""}]}]}
         */

        private BigDecimal assetNum;
        private String archivesCode;
        private String assetCode;
        private String operationCode;
        private String baseFacilityName;
        private String areaName;
        private String tunnelStructureTypeName;
        private BigDecimal tunnelStructureTypeID;
        private String voltageLevelName;
        private String startStopDescription;
        private String positionDescription;
        private double frontTopHeight;
        private double tunnelWidth;
        private double tunnelHeight;
        private BigDecimal tunnelSectionNum;
        private TunnelSectionBean tunnelSection;

        private BigDecimal tunnelStuffTypeID;  /*沟道材质类型*/
        private String tunnelStuffTypeName;  /*沟道材质名称*/
        private Double tunnelLength;  /*通道长度，单位米*/
        private Double tailTopHeight;  /*末端覆土深度*/

        public BigDecimal getTunnelStuffTypeID() {
            return tunnelStuffTypeID;
        }

        public void setTunnelStuffTypeID(BigDecimal tunnelStuffTypeID) {
            this.tunnelStuffTypeID = tunnelStuffTypeID;
        }

        public String getTunnelStuffTypeName() {
            return tunnelStuffTypeName;
        }

        public void setTunnelStuffTypeName(String tunnelStuffTypeName) {
            this.tunnelStuffTypeName = tunnelStuffTypeName;
        }

        public Double getTunnelLength() {
            return tunnelLength;
        }

        public void setTunnelLength(Double tunnelLength) {
            this.tunnelLength = tunnelLength;
        }

        public Double getTailTopHeight() {
            return tailTopHeight;
        }

        public void setTailTopHeight(Double tailTopHeight) {
            this.tailTopHeight = tailTopHeight;
        }

        public BigDecimal getTunnelStructureTypeID() {
            return tunnelStructureTypeID;
        }

        public void setTunnelStructureTypeID(BigDecimal tunnelStructureTypeID) {
            this.tunnelStructureTypeID = tunnelStructureTypeID;
        }

        public BigDecimal getAssetNum() {
            return assetNum;
        }

        public void setAssetNum(BigDecimal assetNum) {
            this.assetNum = assetNum;
        }

        public String getArchivesCode() {
            return archivesCode;
        }

        public void setArchivesCode(String archivesCode) {
            this.archivesCode = archivesCode;
        }

        public String getAssetCode() {
            return assetCode;
        }

        public void setAssetCode(String assetCode) {
            this.assetCode = assetCode;
        }

        public String getOperationCode() {
            return operationCode;
        }

        public void setOperationCode(String operationCode) {
            this.operationCode = operationCode;
        }

        public String getBaseFacilityName() {
            return baseFacilityName;
        }

        public void setBaseFacilityName(String baseFacilityName) {
            this.baseFacilityName = baseFacilityName;
        }

        public String getAreaName() {
            return areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }

        public String getTunnelStructureTypeName() {
            return tunnelStructureTypeName;
        }

        public void setTunnelStructureTypeName(String tunnelStructureTypeName) {
            this.tunnelStructureTypeName = tunnelStructureTypeName;
        }

        public String getVoltageLevelName() {
            return voltageLevelName;
        }

        public void setVoltageLevelName(String voltageLevelName) {
            this.voltageLevelName = voltageLevelName;
        }

        public String getStartStopDescription() {
            return startStopDescription;
        }

        public void setStartStopDescription(String startStopDescription) {
            this.startStopDescription = startStopDescription;
        }

        public String getPositionDescription() {
            return positionDescription;
        }

        public void setPositionDescription(String positionDescription) {
            this.positionDescription = positionDescription;
        }

        public double getFrontTopHeight() {
            return frontTopHeight;
        }

        public void setFrontTopHeight(double frontTopHeight) {
            this.frontTopHeight = frontTopHeight;
        }

        public double getTunnelWidth() {
            return tunnelWidth;
        }

        public void setTunnelWidth(double tunnelWidth) {
            this.tunnelWidth = tunnelWidth;
        }

        public double getTunnelHeight() {
            return tunnelHeight;
        }

        public void setTunnelHeight(double tunnelHeight) {
            this.tunnelHeight = tunnelHeight;
        }

        public BigDecimal getTunnelSectionNum() {
            return tunnelSectionNum;
        }

        public void setTunnelSectionNum(BigDecimal tunnelSectionNum) {
            this.tunnelSectionNum = tunnelSectionNum;
        }

        public TunnelSectionBean getTunnelSection() {
            return tunnelSection;
        }

        public void setTunnelSection(TunnelSectionBean tunnelSection) {
            this.tunnelSection = tunnelSection;
        }

        public static class TunnelSectionBean {
            /**
             * sectionNum : 10668
             * orderNum : 1
             * tunnleTowardTypeName : 北
             * tunnleTowardTypeID : 4
             * length : 74.47
             * trestleLayer : [{"trestleLayerNum":584,"memo":"","height":0.25,"layer":1,"voltageLevelName":"10KV","voltageLevelID":4,"trestleStuffTypeID":1,"trestleStuffTypeName":"玻璃钢","trestlePositionTypeID":1,"trestlePositionTypeName":"左侧支架","trestleLength":0.4,"rowTube":[{"rowTubeNum":300,"rowTubeTypeID":5,"rowTubeTypeName":"xx型号","rowTubeDiameter":1.2}],"pathCable":[{"layerCableNum":52359,"cableNum":5797,"orderNum":1,"placeType":1,"isTempCable":false,"rowTubeNum":300,"baseFacilityNum":4,"baseFacilityName":"南郊站","loopLenght":0.62,"voltageLevelName":"10KV","voltageLevelID":4,"modelTypeNum":61,"modelTypeName":"YJLV22-3*240","loopNum":5535,"loopName":"南毛一线716-1-2回","runDate":"2001-6-18","pathSectionNum":4053,"pathSectionName":"南毛一线","pathSectionCode":"716-1","runCode":""}]}]
             */

            private BigDecimal sectionNum;
            private BigDecimal orderNum;
            private String tunnleTowardTypeName;
            private BigDecimal tunnleTowardTypeID;
            private double length;
            private List<TrestleLayerBean> trestleLayer;

            public BigDecimal getSectionNum() {
                return sectionNum;
            }

            public void setSectionNum(BigDecimal sectionNum) {
                this.sectionNum = sectionNum;
            }

            public BigDecimal getOrderNum() {
                return orderNum;
            }

            public void setOrderNum(BigDecimal orderNum) {
                this.orderNum = orderNum;
            }

            public String getTunnleTowardTypeName() {
                return tunnleTowardTypeName;
            }

            public void setTunnleTowardTypeName(String tunnleTowardTypeName) {
                this.tunnleTowardTypeName = tunnleTowardTypeName;
            }

            public BigDecimal getTunnleTowardTypeID() {
                return tunnleTowardTypeID;
            }

            public void setTunnleTowardTypeID(BigDecimal tunnleTowardTypeID) {
                this.tunnleTowardTypeID = tunnleTowardTypeID;
            }

            public double getLength() {
                return length;
            }

            public void setLength(double length) {
                this.length = length;
            }

            public List<TrestleLayerBean> getTrestleLayer() {
                return trestleLayer;
            }

            public void setTrestleLayer(List<TrestleLayerBean> trestleLayer) {
                this.trestleLayer = trestleLayer;
            }

            public static class TrestleLayerBean {
                /**
                 * trestleLayerNum : 584
                 * memo : 
                 * height : 0.25
                 * layer : 1
                 * voltageLevelName : 10KV
                 * voltageLevelID : 4
                 * trestleStuffTypeID : 1
                 * trestleStuffTypeName : 玻璃钢
                 * trestlePositionTypeID : 1
                 * trestlePositionTypeName : 左侧支架
                 * trestleLength : 0.4
                 * rowTube : [{"rowTubeNum":300,"rowTubeTypeID":5,"rowTubeTypeName":"xx型号","rowTubeDiameter":1.2}]
                 * pathCable : [{"layerCableNum":52359,"cableNum":5797,"orderNum":1,"placeType":1,"isTempCable":false,"rowTubeNum":300,"baseFacilityNum":4,"baseFacilityName":"南郊站","loopLenght":0.62,"voltageLevelName":"10KV","voltageLevelID":4,"modelTypeNum":61,"modelTypeName":"YJLV22-3*240","loopNum":5535,"loopName":"南毛一线716-1-2回","runDate":"2001-6-18","pathSectionNum":4053,"pathSectionName":"南毛一线","pathSectionCode":"716-1","runCode":""}]
                 */

                private BigDecimal trestleLayerNum;
                private String memo;
                private double height;
                private BigDecimal layer;
                private String voltageLevelName;
                private BigDecimal voltageLevelID;
                private BigDecimal trestleStuffTypeID;
                private String trestleStuffTypeName;
                private BigDecimal trestlePositionTypeID;
                private String trestlePositionTypeName;
                private double trestleLength;
                private List<RowTubeBean> rowTube;
                private List<PathCableBean> pathCable;

                public BigDecimal getTrestleLayerNum() {
                    return trestleLayerNum;
                }

                public void setTrestleLayerNum(BigDecimal trestleLayerNum) {
                    this.trestleLayerNum = trestleLayerNum;
                }

                public String getMemo() {
                    return memo;
                }

                public void setMemo(String memo) {
                    this.memo = memo;
                }

                public double getHeight() {
                    return height;
                }

                public void setHeight(double height) {
                    this.height = height;
                }

                public BigDecimal getLayer() {
                    return layer;
                }

                public void setLayer(BigDecimal layer) {
                    this.layer = layer;
                }

                public String getVoltageLevelName() {
                    return voltageLevelName;
                }

                public void setVoltageLevelName(String voltageLevelName) {
                    this.voltageLevelName = voltageLevelName;
                }

                public BigDecimal getVoltageLevelID() {
                    return voltageLevelID;
                }

                public void setVoltageLevelID(BigDecimal voltageLevelID) {
                    this.voltageLevelID = voltageLevelID;
                }

                public BigDecimal getTrestleStuffTypeID() {
                    return trestleStuffTypeID;
                }

                public void setTrestleStuffTypeID(BigDecimal trestleStuffTypeID) {
                    this.trestleStuffTypeID = trestleStuffTypeID;
                }

                public String getTrestleStuffTypeName() {
                    return trestleStuffTypeName;
                }

                public void setTrestleStuffTypeName(String trestleStuffTypeName) {
                    this.trestleStuffTypeName = trestleStuffTypeName;
                }

                public BigDecimal getTrestlePositionTypeID() {
                    return trestlePositionTypeID;
                }

                public void setTrestlePositionTypeID(BigDecimal trestlePositionTypeID) {
                    this.trestlePositionTypeID = trestlePositionTypeID;
                }

                public String getTrestlePositionTypeName() {
                    return trestlePositionTypeName;
                }

                public void setTrestlePositionTypeName(String trestlePositionTypeName) {
                    this.trestlePositionTypeName = trestlePositionTypeName;
                }

                public double getTrestleLength() {
                    return trestleLength;
                }

                public void setTrestleLength(double trestleLength) {
                    this.trestleLength = trestleLength;
                }

                public List<RowTubeBean> getRowTube() {
                    return rowTube;
                }

                public void setRowTube(List<RowTubeBean> rowTube) {
                    this.rowTube = rowTube;
                }

                public List<PathCableBean> getPathCable() {
                    return pathCable;
                }

                public void setPathCable(List<PathCableBean> pathCable) {
                    this.pathCable = pathCable;
                }

                public static class RowTubeBean {
                    /**
                     * rowTubeNum : 300
                     * rowTubeTypeID : 5
                     * rowTubeTypeName : xx型号
                     * rowTubeDiameter : 1.2
                     */

                    private BigDecimal rowTubeNum;
                    private BigDecimal rowTubeTypeID;
                    private String rowTubeTypeName;
                    private double rowTubeDiameter;
                    private BigDecimal rowTubeOrder;

                    public BigDecimal getRowTubeOrder() {
                        return rowTubeOrder;
                    }

                    public void setRowTubeOrder(BigDecimal rowTubeOrder) {
                        this.rowTubeOrder = rowTubeOrder;
                    }

                    public BigDecimal getRowTubeNum() {
                        return rowTubeNum;
                    }

                    public void setRowTubeNum(BigDecimal rowTubeNum) {
                        this.rowTubeNum = rowTubeNum;
                    }

                    public BigDecimal getRowTubeTypeID() {
                        return rowTubeTypeID;
                    }

                    public void setRowTubeTypeID(BigDecimal rowTubeTypeID) {
                        this.rowTubeTypeID = rowTubeTypeID;
                    }

                    public String getRowTubeTypeName() {
                        return rowTubeTypeName;
                    }

                    public void setRowTubeTypeName(String rowTubeTypeName) {
                        this.rowTubeTypeName = rowTubeTypeName;
                    }

                    public double getRowTubeDiameter() {
                        return rowTubeDiameter;
                    }

                    public void setRowTubeDiameter(double rowTubeDiameter) {
                        this.rowTubeDiameter = rowTubeDiameter;
                    }
                }

                public static class PathCableBean {
                    /**
                     * layerCableNum : 52359
                     * cableNum : 5797
                     * orderNum : 1
                     * placeType : 1
                     * isTempCable : false
                     * rowTubeNum : 300
                     * baseFacilityNum : 4
                     * baseFacilityName : 南郊站
                     * loopLenght : 0.62
                     * voltageLevelName : 10KV
                     * voltageLevelID : 4
                     * modelTypeNum : 61
                     * modelTypeName : YJLV22-3*240
                     * loopNum : 5535
                     * loopName : 南毛一线716-1-2回
                     * runDate : 2001-6-18
                     * pathSectionNum : 4053
                     * pathSectionName : 南毛一线
                     * pathSectionCode : 716-1
                     * runCode : 
                     */

                    private BigDecimal layerCableNum;
                    private BigDecimal cableNum;
                    private BigDecimal orderNum;
                    private BigDecimal placeType;
                    private boolean isTempCable;
                    private BigDecimal rowTubeNum;
                    private BigDecimal baseFacilityNum;
                    private String baseFacilityName;
                    private double loopLenght;
                    private String voltageLevelName;
                    private BigDecimal voltageLevelID;
                    private BigDecimal modelTypeNum;
                    private String modelTypeName;
                    private BigDecimal loopNum;
                    private String loopName;
                    private String runDate;
                    private BigDecimal pathSectionNum;
                    private String pathSectionName;
                    private String pathSectionCode;
                    private String runCode;
                    private String placeInfo;
                    private String placeInfo2;

                    public String getPlaceInfo() {
                        return placeInfo;
                    }

                    public void setPlaceInfo(String placeInfo) {
                        this.placeInfo = placeInfo;
                    }

                    public String getPlaceInfo2() {
                        return placeInfo2;
                    }

                    public void setPlaceInfo2(String placeInfo2) {
                        this.placeInfo2 = placeInfo2;
                    }

                    public BigDecimal getLayerCableNum() {
                        return layerCableNum;
                    }

                    public void setLayerCableNum(BigDecimal layerCableNum) {
                        this.layerCableNum = layerCableNum;
                    }

                    public BigDecimal getCableNum() {
                        return cableNum;
                    }

                    public void setCableNum(BigDecimal cableNum) {
                        this.cableNum = cableNum;
                    }

                    public BigDecimal getOrderNum() {
                        return orderNum;
                    }

                    public void setOrderNum(BigDecimal orderNum) {
                        this.orderNum = orderNum;
                    }

                    public BigDecimal getPlaceType() {
                        return placeType;
                    }

                    public void setPlaceType(BigDecimal placeType) {
                        this.placeType = placeType;
                    }

                    public boolean isIsTempCable() {
                        return isTempCable;
                    }

                    public void setIsTempCable(boolean isTempCable) {
                        this.isTempCable = isTempCable;
                    }

                    public BigDecimal getRowTubeNum() {
                        return rowTubeNum;
                    }

                    public void setRowTubeNum(BigDecimal rowTubeNum) {
                        this.rowTubeNum = rowTubeNum;
                    }

                    public BigDecimal getBaseFacilityNum() {
                        return baseFacilityNum;
                    }

                    public void setBaseFacilityNum(BigDecimal baseFacilityNum) {
                        this.baseFacilityNum = baseFacilityNum;
                    }

                    public String getBaseFacilityName() {
                        return baseFacilityName;
                    }

                    public void setBaseFacilityName(String baseFacilityName) {
                        this.baseFacilityName = baseFacilityName;
                    }

                    public double getLoopLenght() {
                        return loopLenght;
                    }

                    public void setLoopLenght(double loopLenght) {
                        this.loopLenght = loopLenght;
                    }

                    public String getVoltageLevelName() {
                        return voltageLevelName;
                    }

                    public void setVoltageLevelName(String voltageLevelName) {
                        this.voltageLevelName = voltageLevelName;
                    }

                    public BigDecimal getVoltageLevelID() {
                        return voltageLevelID;
                    }

                    public void setVoltageLevelID(BigDecimal voltageLevelID) {
                        this.voltageLevelID = voltageLevelID;
                    }

                    public BigDecimal getModelTypeNum() {
                        return modelTypeNum;
                    }

                    public void setModelTypeNum(BigDecimal modelTypeNum) {
                        this.modelTypeNum = modelTypeNum;
                    }

                    public String getModelTypeName() {
                        return modelTypeName;
                    }

                    public void setModelTypeName(String modelTypeName) {
                        this.modelTypeName = modelTypeName;
                    }

                    public BigDecimal getLoopNum() {
                        return loopNum;
                    }

                    public void setLoopNum(BigDecimal loopNum) {
                        this.loopNum = loopNum;
                    }

                    public String getLoopName() {
                        return loopName;
                    }

                    public void setLoopName(String loopName) {
                        this.loopName = loopName;
                    }

                    public String getRunDate() {
                        return runDate;
                    }

                    public void setRunDate(String runDate) {
                        this.runDate = runDate;
                    }

                    public BigDecimal getPathSectionNum() {
                        return pathSectionNum;
                    }

                    public void setPathSectionNum(BigDecimal pathSectionNum) {
                        this.pathSectionNum = pathSectionNum;
                    }

                    public String getPathSectionName() {
                        return pathSectionName;
                    }

                    public void setPathSectionName(String pathSectionName) {
                        this.pathSectionName = pathSectionName;
                    }

                    public String getPathSectionCode() {
                        return pathSectionCode;
                    }

                    public void setPathSectionCode(String pathSectionCode) {
                        this.pathSectionCode = pathSectionCode;
                    }

                    public String getRunCode() {
                        return runCode;
                    }

                    public void setRunCode(String runCode) {
                        this.runCode = runCode;
                    }
                }
            }
        }
    }
}
