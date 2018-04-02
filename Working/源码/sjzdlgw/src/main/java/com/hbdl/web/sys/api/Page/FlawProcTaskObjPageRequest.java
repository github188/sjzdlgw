package com.hbdl.web.sys.api.Page;

/**
 * Created by GalaIO on 2016/12/7.
 */
public class FlawProcTaskObjPageRequest {

    /**
     * objFlawNum : 568
     * flawProcAcceptTypeID : 1
     * memo : 123
     * flawPrcoDescription : 444444
     * flawProcObj : 643
     */
    private int objFlawNum;
    private int flawProcAcceptTypeID;
    private String memo;
    private String flawPrcoDescription;
    private int flawProcObj;
    private String account;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setObjFlawNum(int objFlawNum) {
        this.objFlawNum = objFlawNum;
    }

    public void setFlawProcAcceptTypeID(int flawProcAcceptTypeID) {
        this.flawProcAcceptTypeID = flawProcAcceptTypeID;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public void setFlawPrcoDescription(String flawPrcoDescription) {
        this.flawPrcoDescription = flawPrcoDescription;
    }

    public void setFlawProcObj(int flawProcObj) {
        this.flawProcObj = flawProcObj;
    }

    public int getObjFlawNum() {
        return objFlawNum;
    }

    public int getFlawProcAcceptTypeID() {
        return flawProcAcceptTypeID;
    }

    public String getMemo() {
        return memo;
    }

    public String getFlawPrcoDescription() {
        return flawPrcoDescription;
    }

    public int getFlawProcObj() {
        return flawProcObj;
    }
}
