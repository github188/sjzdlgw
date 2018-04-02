package com.hbdl.web.sys.api.Page;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 巡视任务上传对象
 * Created by zgq on 2017-02-22.
 */
public class InspectTaskUploadData implements java.io.Serializable{

    /**
     * 记录编号
     */
    private BigDecimal objFlawNum;
    /**
     * 缺陷分类ID
     */
    private BigDecimal flawTypeID;
    /**
     * 缺陷等级ID
     */
    private BigDecimal flawLevelTypeID;
    /**
     * 缺陷描述
     */
    private String flawDescription;
    /**
     * 缺陷记录时间
     */
    private Date flawDate;
    /**
     * 缺陷上传图片base64
     * 多个图片用","隔开
     */
    private String pictureList;

    public BigDecimal getObjFlawNum() {
        return objFlawNum;
    }

    public void setObjFlawNum(BigDecimal objFlawNum) {
        this.objFlawNum = objFlawNum;
    }

    public BigDecimal getFlawTypeID() {
        return flawTypeID;
    }

    public void setFlawTypeID(BigDecimal flawTypeID) {
        this.flawTypeID = flawTypeID;
    }

    public BigDecimal getFlawLevelTypeID() {
        return flawLevelTypeID;
    }

    public void setFlawLevelTypeID(BigDecimal flawLevelTypeID) {
        this.flawLevelTypeID = flawLevelTypeID;
    }

    public String getFlawDescription() {
        return flawDescription;
    }

    public void setFlawDescription(String flawDescription) {
        this.flawDescription = flawDescription;
    }

    public Date getFlawDate() {
        return flawDate;
    }

    public void setFlawDate(Date flawDate) {
        this.flawDate = flawDate;
    }

    public String getPictureList() {
        return pictureList;
    }

    public void setPictureList(String pictureList) {
        this.pictureList = pictureList;
    }
}
