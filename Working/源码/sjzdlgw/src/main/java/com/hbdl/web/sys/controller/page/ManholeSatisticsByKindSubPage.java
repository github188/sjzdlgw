package com.hbdl.web.sys.controller.page;

import java.math.BigDecimal;

/**
 * Created by long on 2016/11/8.
 */
public class ManholeSatisticsByKindSubPage {
	private BigDecimal manholeTypeID;
	private String manholeTypeName;
    private String manholeKindTypeName;
    private BigDecimal count;
    
    

    public BigDecimal getManholeTypeID() {
		return manholeTypeID;
	}

	public void setManholeTypeID(BigDecimal manholeTypeID) {
		this.manholeTypeID = manholeTypeID;
	}

	public String getManholeTypeName() {
		return manholeTypeName;
	}

	public void setManholeTypeName(String manholeTypeName) {
		this.manholeTypeName = manholeTypeName;
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
