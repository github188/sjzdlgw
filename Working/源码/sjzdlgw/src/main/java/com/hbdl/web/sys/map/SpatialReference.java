/**
 * 
 */
package com.hbdl.web.sys.map;

/**
 * 坐标系定义
 * 
 * @author zhangqian
 *
 */
public class SpatialReference {

	private Integer wkid = 3857; // DEFAULT by Google Web Mecator

	/**
	 * @return the wkid
	 */
	public Integer getWkid() {
		return wkid;
	}

	/**
	 * @param wkid
	 *            the wkid to set
	 */
	public void setWkid(Integer wkid) {
		this.wkid = wkid;
	}

}
