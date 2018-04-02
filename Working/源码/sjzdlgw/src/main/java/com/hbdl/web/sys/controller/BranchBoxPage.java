package com.hbdl.web.sys.controller;

import java.math.BigDecimal;

/**
 * Created by zgq on 2016/10/7.
 */
public class BranchBoxPage implements java.io.Serializable{

    private String assetName;

    private String assetCode;

    private String baseFacilityNum;

    private String baseFacilityName;

    private String modelNum;

    private String modelName;
    
    private String voltageLevelID;
    
    private String voltageLevelName;
    
    public String getVoltageLevelID() {
		return voltageLevelID;
	}

	public void setVoltageLevelID(String voltageLevelID) {
		this.voltageLevelID = voltageLevelID;
	}


	public String getVoltageLevelName() {
		return voltageLevelName;
	}

	public void setVoltageLevelName(String voltageLevelName) {
		this.voltageLevelName = voltageLevelName;
	}

	

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public String getBaseFacilityNum() {
        return baseFacilityNum;
    }

    public void setBaseFacilityNum(String baseFacilityNum) {
        this.baseFacilityNum = baseFacilityNum;
    }

    public String getModelNum() {
        return modelNum;
    }

    public void setModelNum(String modelNum) {
        this.modelNum = modelNum;
    }

    public String getBaseFacilityName() {
        return baseFacilityName;
    }

    public void setBaseFacilityName(String baseFacilityName) {
        this.baseFacilityName = baseFacilityName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public BranchBoxPage() {
    }
}
