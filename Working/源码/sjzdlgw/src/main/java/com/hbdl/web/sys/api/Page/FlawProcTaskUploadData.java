package com.hbdl.web.sys.api.Page;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 消缺任务上传对象
 * Created by zgq on 2017-02-22.
 */
public class FlawProcTaskUploadData implements java.io.Serializable{

    /**
     * 消缺对象记录编号
     */
    private BigDecimal flawProcObj;
    /**
     * 处理确认类型ID
     */
    private BigDecimal flawProcAcceptTypeID;
    /**
     * 消缺处理说明
     */
    private String flawPrcoDescription;
    /**
     * 消缺处理时间
     */
    private Date flawProcDate;
    /**
     * 消缺上传图片base64
     * 多个图片用","隔开
     */
    private String pictureList;

    public BigDecimal getFlawProcObj() {
        return flawProcObj;
    }

    public void setFlawProcObj(BigDecimal flawProcObj) {
        this.flawProcObj = flawProcObj;
    }

    public BigDecimal getFlawProcAcceptTypeID() {
        return flawProcAcceptTypeID;
    }

    public void setFlawProcAcceptTypeID(BigDecimal flawProcAcceptTypeID) {
        this.flawProcAcceptTypeID = flawProcAcceptTypeID;
    }

    public String getFlawPrcoDescription() {
        return flawPrcoDescription;
    }

    public void setFlawPrcoDescription(String flawPrcoDescription) {
        this.flawPrcoDescription = flawPrcoDescription;
    }

    public Date getFlawProcDate() {
        return flawProcDate;
    }

    public void setFlawProcDate(Date flawProcDate) {
        this.flawProcDate = flawProcDate;
    }

    public String getPictureList() {
        return pictureList;
    }

    public void setPictureList(String pictureList) {
        this.pictureList = pictureList;
    }
}
