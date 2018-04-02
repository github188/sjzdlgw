package com.hbdl.web.sys.controller.page;

import java.math.BigDecimal;

/**
 * Created by long on 2016/11/8.
 */
public class ManholeSatisticsByflPage {
    private String area;
    private String type;
    private BigDecimal count;

   
    public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }
}
