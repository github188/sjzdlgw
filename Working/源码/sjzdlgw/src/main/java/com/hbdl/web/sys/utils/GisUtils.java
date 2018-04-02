package com.hbdl.web.sys.utils;

/**
 * Created by zgq on 2016/10/18.
 */
public class GisUtils {

    private static final  double EARTH_RADIUS = 6378137;//赤道半径

    private static double rad(double d){
        return d * Math.PI / 180.0;
    }

    public static double GetDistance(double lon1,double lat1,double lon2, double lat2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lon1) - rad(lon2);
        double s = 2 *Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2)+Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
        s = s * EARTH_RADIUS;
        return s;//单位米
    }

    public static void main(String[] args) {


        System.out.println(GetDistance(114.4969163542970,38.0219920029220,114.4961077054250,38.0219814091371));
    }
}
