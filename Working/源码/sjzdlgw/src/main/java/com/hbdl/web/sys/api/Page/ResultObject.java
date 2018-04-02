package com.hbdl.web.sys.api.Page;

/**
 * 移动巡检返回对象
 * Created by zgq on 2017-02-20.
 */
public class ResultObject implements java.io.Serializable{

    /**
     * 状态码
     */
    private String code;
    /**
     * 返回信息
     */
    private String mesg;
    /**
     * 返回数据
     */
    private Object data;

    public ResultObject(String code, String mesg, Object data) {
        this.code = code;
        this.mesg = mesg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMesg() {
        return mesg;
    }

    public void setMesg(String mesg) {
        this.mesg = mesg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    
}
