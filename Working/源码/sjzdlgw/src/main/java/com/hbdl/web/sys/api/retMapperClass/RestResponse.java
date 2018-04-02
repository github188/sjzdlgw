package com.hbdl.web.sys.api.retMapperClass;

/**
 * Created by long on 2016/11/29.
 */
public class RestResponse {
    public String fun;
    public Object data;

    public RestResponse() {

    }
    public RestResponse(String fun, Object data) {
        this.fun = fun;
        this.data = data;
    }

    public String getFun() {
        return fun;
    }

    public void setFun(String fun) {
        this.fun = fun;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
