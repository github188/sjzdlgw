package com.hbdl.web.sys.controller.page;

import java.math.BigDecimal;

/**
 * Created by long on 2016/11/8.
 */
public class ManholeSatisticsByKindPage {
	private BigDecimal manholeTypeID;
    private String manholeKindTypeName;
    private BigDecimal count;

    
    public BigDecimal getManholeTypeID() {
		return manholeTypeID;
	}

	public void setManholeTypeID(BigDecimal manholeTypeID) {
		this.manholeTypeID = manholeTypeID;
	}

	public String getManholeKindTypeName() {
        return manholeKindTypeName;
    }

    public void setManholeKindTypeName(String manholeKindTypeName) {
        this.manholeKindTypeName = manholeKindTypeName;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }
}
