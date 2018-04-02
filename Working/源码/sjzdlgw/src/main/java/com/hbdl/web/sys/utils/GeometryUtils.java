package com.hbdl.web.sys.utils;

import java.util.ArrayList;
import java.util.List;

import org.geotools.geometry.jts.JTS;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.geotools.referencing.CRS;
import org.opengis.geometry.MismatchedDimensionException;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;
import org.opengis.referencing.operation.TransformException;

import com.vividsolutions.jts.algorithm.Angle;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

/**
 * 地理处理工具
 * 
 * @author zhangqian
 *
 */
public class GeometryUtils {

	private static GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory();
	private static WKTReader reader = new WKTReader(geometryFactory);

	/**
	 * 从wkt读取到Geoemtry
	 * 
	 * @param wkt
	 * @return
	 * @throws ParseException
	 */
	public static Geometry readWKT(String wkt) throws ParseException {
		return reader.read(wkt);
	}

	/**
	 * 数据坐标系转换
	 * 
	 * @param geometry
	 * @param srcCRS
	 * @param targetCRS
	 * @return
	 * @throws NoSuchAuthorityCodeException
	 * @throws FactoryException
	 * @throws MismatchedDimensionException
	 * @throws TransformException
	 */
	public static Geometry transformCRS(Geometry geometry, Integer srcCRS, Integer targetCRS)
			throws NoSuchAuthorityCodeException, FactoryException, MismatchedDimensionException, TransformException {
		CoordinateReferenceSystem source = CRS.decode("EPSG:" + srcCRS, true);
		// 一个true决定了Wkt格式转出后的先后顺序 true表示经度在前。默认为false
		CoordinateReferenceSystem target = CRS.decode("EPSG:" + targetCRS, true);
		MathTransform transform = CRS.findMathTransform(source, target);
		return JTS.transform(geometry, transform);
	}

	private static void test() {
		try {
			// 使用WKT格式数据创建2个点数据
			Point p1 = (Point) reader.read("POINT (108 34)");
			Point p2 = (Point) reader.read("POINT (108.3 35.765)");

			// 将点的坐标信息保存为数组，作为以点画线的参数
			Coordinate[] coords = new Coordinate[] { p1.getCoordinate(), p2.getCoordinate() };

			// 创建线数据
			LineString line = geometryFactory.createLineString(coords);

			// 打印线数据的WKT格式数据
			System.out.println(line.toText());

			// 使用Angle角度分析对象获取两点画线的弧度
			double arc = Angle.angle(p1.getCoordinate(), p2.getCoordinate());
			// 将弧度转换为角度
			System.out.println(Angle.toDegrees(arc));

		} catch (ParseException e) {
			// 读取WKT字符串格式错误时抛出此异常
			System.err.println(e.getMessage());
		}
	}

	public static Point createPoint(Double x, Double y) {
		Coordinate coordinate = new Coordinate(x, y);
		Point point = geometryFactory.createPoint(coordinate);
		return point;
	}

	public static Polygon createPolygon(Point... plist) {
		List<Coordinate> coords = new ArrayList<>();
		for (Point p : plist) {
			coords.add(p.getCoordinate());
		}
		Coordinate[] cs = new Coordinate[coords.size()];
		coords.toArray(cs);
		return geometryFactory.createPolygon(cs);
	}

}
