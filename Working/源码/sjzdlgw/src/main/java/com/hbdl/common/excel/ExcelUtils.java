package com.hbdl.common.excel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;

import com.hbdl.common.excel.template.PoiTemplate;
import com.hbdl.common.excel.template.utils.PoiUtil;
import com.hbdl.common.utils.FileUtils;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class ExcelUtils {

	/**
	 * 导出excel,普通形式(流的形式直接下载)
	 * @param response
	 * @param fileName 下载的excel文件名
	 * @param data 数据
	 * @param titleMap (key:"列名",value = "属性名")
	 */
	public static void exportExcel(HttpServletResponse response,
			String fileName, List<?> data, Map titleMap) throws Exception {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PoiUtil.writeExcel(data, os, titleMap);
		os.flush();
		byte[] buf = os.toByteArray();
		InputStream is = new ByteArrayInputStream(buf, 0, buf.length);
		FileUtils.downloadFile(response, is, fileName);
		is.close();
		os.close();
	}

	/**
	 * 导出excel,普通形式(先保存一份到服务器，之后从服务器下载)
	 * @param response
	 * @param filePath 在服务器中导出的excel文件路径
	 * @param fileName 下载的excel名字
	 * @param data 数据
	 * @param titleMap (key:"列名",value = "属性名")
	 */
	public static void exportExcel(HttpServletResponse response,
			String filePath, String fileName, List<?> data, Map titleMap)
			throws Exception {
		FileOutputStream fos = new FileOutputStream(new File(filePath));
		PoiUtil.writeExcel(data, fos, titleMap);
		fos.close();
		FileUtils.downloadFile(response, filePath, fileName);
	}

	/**
	 * 导出excel,模板形式(流方式直接下载)
	 * @param response
	 * @param templatePath 模板excel的路径
	 * @param fileName 导出excel文件名
	 * @param data 数据map
	 */
	public static void exportExcel(HttpServletResponse response,
			String templatePath,String fileName, Map data) throws Exception {
		ByteArrayOutputStream os = new ByteArrayOutputStream();;
		PoiTemplate template = new PoiTemplate(templatePath,os);
		template.addMap(data);
		template.writeExcel();
		os.flush();
		byte[] buf = os.toByteArray();
		InputStream is = new ByteArrayInputStream(buf, 0, buf.length);
		FileUtils.downloadFile(response, is, fileName);
		is.close();
		os.close();
	}
	
	/**
	 * 导出excel,模板形式(先保存一份到服务器，之后从服务器下载)
	 * @param response
	 * @param templatePath 模板excel的路径
	 * @param outPath 保存到服务器的位置
	 * @param fileName 导出excel文件名
	 * @param data 数据map
	 */
	public static void exportExcel(HttpServletResponse response,
			String templatePath,String outPath,String fileName, Map data) throws Exception{
		PoiTemplate template = new PoiTemplate(templatePath,outPath);
		template.addMap(data);
		template.writeExcel();
		FileUtils.downloadFile(response, outPath, fileName);
	}

	/**
	 * 导出Excel
	 * @param request
	 * @param response
	 * @param title
	 * @param reList 要导出的对象集合
	 * @param obj 要导出的对象，即添加有Excel注解的entity
	 */
	public static void exportExcel(HttpServletRequest request, HttpServletResponse response, String title, List reList, Object obj,String fisrttitle, String secondTitle) {
		
		// 生成提示信息，
		response.setContentType("application/vnd.ms-excel");
		response.setCharacterEncoding("UTF-8");
		OutputStream fOut = null;
		try {
			// 根据浏览器进行转码，使其支持中文文件名
			String browse = BrowserUtils.checkBrowse(request);
			if ("MSIE".equalsIgnoreCase(browse.substring(0, 4))) {
				response.setHeader(
						"content-disposition",
						"attachment;filename="
								+ java.net.URLEncoder.encode(title, "UTF-8")
								+ ".xls");
			} else {
				String newtitle = new String(title.getBytes("UTF-8"), "ISO8859-1");
				response.setHeader("content-disposition",
						"attachment;filename=" + newtitle + ".xls");
			}
			// 产生工作簿对象
			Workbook workbook = null;
			workbook = ExcelExportUtil.exportExcel(new ExportParams(fisrttitle, secondTitle, title), obj.getClass(), reList);
			fOut = response.getOutputStream();
			workbook.write(fOut);
		} catch (UnsupportedEncodingException e1) {
			
		} catch (Exception e) {
			
		} finally {
			try {
				fOut.flush();
				fOut.close();
			} catch (IOException e) {
				
			}
		}
	}
}
