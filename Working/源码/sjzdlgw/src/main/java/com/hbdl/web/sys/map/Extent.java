/**
 * 
 */
package com.hbdl.web.sys.map;

import com.hbdl.web.sys.utils.GeometryUtils;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

/**
 * 范围对象
 * 
 * @author zhangqian
 *
 */
public class Extent {

	private static final String SIMPLE_POLYGON_WKT = "POLYGON((%s,%s,%s,%s,%s))";

	private SpatialReference spatialReference;

	private Double xmax;

	private Double xmin;

	private Double ymax;

	private Double ymin;

	/**
	 * @return the spatialReference
	 */
	public SpatialReference getSpatialReference() {
		return spatialReference;
	}

	/**
	 * @param spatialReference
	 *            the spatialReference to set
	 */
	public void setSpatialReference(SpatialReference spatialReference) {
		this.spatialReference = spatialReference;
	}

	/**
	 * @return the xmax
	 */
	public Double getXmax() {
		return xmax;
	}

	/**
	 * @param xmax
	 *            the xmax to set
	 */
	public void setXmax(Double xmax) {
		this.xmax = xmax;
	}

	/**
	 * @return the xmin
	 */
	public Double getXmin() {
		return xmin;
	}

	/**
	 * @param xmin
	 *            the xmin to set
	 */
	public void setXmin(Double xmin) {
		this.xmin = xmin;
	}

	/**
	 * @return the ymax
	 */
	public Double getYmax() {
		return ymax;
	}

	/**
	 * @param ymax
	 *            the ymax to set
	 */
	public void setYmax(Double ymax) {
		this.ymax = ymax;
	}

	/**
	 * @return the ymin
	 */
	public Double getYmin() {
		return ymin;
	}

	/**
	 * @param ymin
	 *            the ymin to set
	 */
	public void setYmin(Double ymin) {
		this.ymin = ymin;
	}

	public Polygon toPolygon() {
		Point p1 = GeometryUtils.createPoint(this.xmin, this.ymax);
		Point p2 = GeometryUtils.createPoint(this.xmax, this.ymax);
		Point p3 = GeometryUtils.createPoint(this.xmax, this.ymin);
		Point p4 = GeometryUtils.createPoint(this.xmin, this.ymin);
		return GeometryUtils.createPolygon(p1, p2, p3, p4, p1);
	}

}
