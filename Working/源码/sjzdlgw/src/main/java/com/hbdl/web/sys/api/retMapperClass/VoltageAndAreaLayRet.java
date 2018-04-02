package com.hbdl.web.sys.api.retMapperClass;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by long on 2016/12/23.
 */
public class VoltageAndAreaLayRet {
    public VoltageAndAreaLayRet(List<AreaBean> area, List<PowerCableLevelBean> powerCableLevel) {
        this.area = area;
        PowerCableLevel = powerCableLevel;
    }

    private List<AreaBean> area;
    private List<PowerCableLevelBean> PowerCableLevel;

    public List<AreaBean> getArea() {
        return area;
    }

    public void setArea(List<AreaBean> area) {
        this.area = area;
    }

    public List<PowerCableLevelBean> getPowerCableLevel() {
        return PowerCableLevel;
    }

    public void setPowerCableLevel(List<PowerCableLevelBean> PowerCableLevel) {
        this.PowerCableLevel = PowerCableLevel;
    }

    public static class AreaBean {
        /**
         * areaNum : 1234
         * AreaName : xxx
         */

        private BigDecimal areaNum;
        private String AreaName;

        public BigDecimal getAreaNum() {
            return areaNum;
        }

        public void setAreaNum(BigDecimal areaNum) {
            this.areaNum = areaNum;
        }

        public String getAreaName() {
            return AreaName;
        }

        public void setAreaName(String AreaName) {
            this.AreaName = AreaName;
        }
    }

    public static class PowerCableLevelBean {
        /**
         * VoltageLevelID : 123
         * VoltageLevelName : xxx
         */

        private BigDecimal VoltageLevelID;
        private String VoltageLevelName;

        public BigDecimal getVoltageLevelID() {
            return VoltageLevelID;
        }

        public void setVoltageLevelID(BigDecimal VoltageLevelID) {
            this.VoltageLevelID = VoltageLevelID;
        }

        public String getVoltageLevelName() {
            return VoltageLevelName;
        }

        public void setVoltageLevelName(String VoltageLevelName) {
            this.VoltageLevelName = VoltageLevelName;
        }
    }
}
