package com.hbdl.web.sys.controller.page;

import com.hbdl.common.utils.DateUtils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by tanrong.ltr on 16/10/15.
 */
public class BusinessProcessInstantiatePage {
    private BigDecimal instantiateID;
    private BigDecimal templateID;
    private String userAID;
    private String userBID;
    private String userCID;
    private String userDID;
    private String userEID;
    private Date ctime;

    private String templateName;
    private String userAName;
    private String userBName;
    private String userCName;
    private String userDName;
    private String userEName;
    private String ctimeStr;

    public BigDecimal getInstantiateID() {
        return instantiateID;
    }

    public void setInstantiateID(BigDecimal instantiateID) {
        this.instantiateID = instantiateID;
    }

    public BigDecimal getTemplateID() {
        return templateID;
    }

    public void setTemplateID(BigDecimal templateID) {
        this.templateID = templateID;
    }

    public String getUserAID() {
        return userAID;
    }

    public void setUserAID(String userAID) {
        this.userAID = userAID;
    }

    public String getUserBID() {
        return userBID;
    }

    public void setUserBID(String userBID) {
        this.userBID = userBID;
    }

    public String getUserCID() {
        return userCID;
    }

    public void setUserCID(String userCID) {
        this.userCID = userCID;
    }

    public String getUserDID() {
        return userDID;
    }

    public void setUserDID(String userDID) {
        this.userDID = userDID;
    }

    public String getUserEID() {
        return userEID;
    }

    public void setUserEID(String userEID) {
        this.userEID = userEID;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        if (ctime!=null)
            ctimeStr= DateUtils.formatDate(ctime);
        this.ctime = ctime;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getUserAName() {
        return userAName;
    }

    public void setUserAName(String userAName) {
        this.userAName = userAName;
    }

    public String getUserBName() {
        return userBName;
    }

    public void setUserBName(String userBName) {
        this.userBName = userBName;
    }

    public String getUserCName() {
        return userCName;
    }

    public void setUserCName(String userCName) {
        this.userCName = userCName;
    }

    public String getUserDName() {
        return userDName;
    }

    public void setUserDName(String userDName) {
        this.userDName = userDName;
    }

    public String getUserEName() {
        return userEName;
    }

    public void setUserEName(String userEName) {
        this.userEName = userEName;
    }

    public String getCtimeStr() {
        return ctimeStr;
    }

    public void setCtimeStr(String ctimeStr) {
        this.ctimeStr = ctimeStr;
    }
}
