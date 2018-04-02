package com.hbdl.common.utils;

/**
 * Created by GalaIO on 2016/12/6.
 */
public class HttpClientUtilTest {
    public static void main(String[] args) {
        String testResponse = HttpClientUtil.httoPostRequest("http://115.159.104.25:8080/api/business/login", "{\"account\":\"su\", \"password\":\"123456\"}", HttpClientUtil.MIME_TYPE_JSON);
        System.out.println(testResponse);
    }
}
