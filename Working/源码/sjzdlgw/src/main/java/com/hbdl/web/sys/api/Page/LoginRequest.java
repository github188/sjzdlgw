package com.hbdl.web.sys.api.Page;

/**
 * Created by GalaIO on 2016/12/5.
 */
public class LoginRequest {
    private String account;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
