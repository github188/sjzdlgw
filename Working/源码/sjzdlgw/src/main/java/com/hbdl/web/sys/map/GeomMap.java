package com.hbdl.web.sys.map;

/**
 * Created by zgq on 2016/10/25.
 */
public class GeomMap implements java.io.Serializable{

    /**
     *  电网资源ID
     */
    private String id;
    /**
     *  电网资源名称
     */
    private String name;
    /**
     * 类型
     */
    private String type;
    /**
     *  电网资源GIS数据
     */
    private String geomStr;

    public GeomMap() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGeomStr() {
        return geomStr;
    }

    public void setGeomStr(String geomStr) {
        this.geomStr = geomStr;
    }
}
