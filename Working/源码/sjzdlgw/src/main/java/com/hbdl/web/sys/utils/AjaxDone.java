package com.hbdl.web.sys.utils;

/**
 * Created by zgq on 2016/9/29.
 */
public class AjaxDone implements java.io.Serializable{

    /**
     * 200正常
     * 300错误
     * 301超时
     */
    private String statusCode="200";

    /**
     * 显示给用户的信息
     */
    private String message="\u64cd\u4f5c\u6210\u529f";

    private String navTabId="";

    private String rel="";

    private String callbackType="";
    /**
     * 显示给用户的信息
     */
    private String forwardUrl="";
    /**
     * 页面需要的数据
     */
    private Object objData;

    /**
     * 确认框中的信息
     */
    private String confirmMsg="";

    public AjaxDone() {
    }

    public AjaxDone(String statusCode) {
        this.statusCode = statusCode;
    }

    public AjaxDone(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = toUnicode(message);
    }

    public AjaxDone(String statusCode, String message, String navTabId, String rel, String callbackType, String forwardUrl, Object objData, String confirmMsg) {
        this.statusCode = statusCode;
        this.message = toUnicode(message);
        this.navTabId = navTabId;
        this.rel = rel;
        this.callbackType = callbackType;
        this.forwardUrl = forwardUrl;
        this.objData = objData;
        this.confirmMsg = confirmMsg;
    }

    public AjaxDone(String statusCode, String message, Object objData) {
        this.statusCode = statusCode;
        this.message = toUnicode(message);
        this.objData = objData;
    }

    public AjaxDone(String statusCode, String message, String forwardUrl) {
        this.statusCode = statusCode;
        this.message = toUnicode(message);
        this.forwardUrl = forwardUrl;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = toUnicode(message);
    }

    public String getNavTabId() {
        return navTabId;
    }

    public void setNavTabId(String navTabId) {
        this.navTabId = navTabId;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getCallbackType() {
        return callbackType;
    }

    public void setCallbackType(String callbackType) {
        this.callbackType = callbackType;
    }

    public String getForwardUrl() {
        return forwardUrl;
    }

    public void setForwardUrl(String forwardUrl) {
        this.forwardUrl = forwardUrl;
    }

    public Object getObjData() {
        return objData;
    }

    public void setObjData(Object objData) {
        this.objData = objData;
    }

    public String getConfirmMsg() {
        return confirmMsg;
    }

    public void setConfirmMsg(String confirmMsg) {
        this.confirmMsg = toUnicode(confirmMsg);
    }

    private String toUnicode(String str)
    {
        StringBuilder sbStr = new StringBuilder(str.length());
        char[] arChar = str.toCharArray();
        int iValue = 0;
        for (int i = 0; i < arChar.length; i++)
        {
            iValue = str.charAt(i);
            if (iValue <= 256)
            {
                sbStr.append("\\u00").append(Integer.toHexString(iValue));
            }
            else
            {
                sbStr.append("\\u").append(Integer.toHexString(iValue));
            }
        }
        return sbStr.toString();
    }
}
