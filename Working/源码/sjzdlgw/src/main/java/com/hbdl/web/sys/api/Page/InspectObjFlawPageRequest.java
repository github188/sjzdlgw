package com.hbdl.web.sys.api.Page;

/**
 * Created by GalaIO on 2016/12/7.
 */
public class InspectObjFlawPageRequest {

    /**
     * flawLevelTypeID : 1
     * flawDescription : 444444
     * objFlawNum : 568
     * flawSourceTypeID : 1
     * flawTypeID : 1
     */
    private int flawLevelTypeID;
    private String flawDescription;
    private int objFlawNum;
    private int flawSourceTypeID;
    private int flawTypeID;
    private String account;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setFlawLevelTypeID(int flawLevelTypeID) {
        this.flawLevelTypeID = flawLevelTypeID;
    }

    public void setFlawDescription(String flawDescription) {
        this.flawDescription = flawDescription;
    }

    public void setObjFlawNum(int objFlawNum) {
        this.objFlawNum = objFlawNum;
    }

    public void setFlawSourceTypeID(int flawSourceTypeID) {
        this.flawSourceTypeID = flawSourceTypeID;
    }

    public void setFlawTypeID(int flawTypeID) {
        this.flawTypeID = flawTypeID;
    }

    public int getFlawLevelTypeID() {
        return flawLevelTypeID;
    }

    public String getFlawDescription() {
        return flawDescription;
    }

    public int getObjFlawNum() {
        return objFlawNum;
    }

    public int getFlawSourceTypeID() {
        return flawSourceTypeID;
    }

    public int getFlawTypeID() {
        return flawTypeID;
    }
}
