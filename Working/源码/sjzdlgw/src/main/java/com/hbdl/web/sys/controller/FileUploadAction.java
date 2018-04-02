package com.hbdl.web.sys.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hbdl.common.base.UploadFile;
import com.hbdl.common.utils.FileUtils;
import com.hbdl.common.utils.PMSUtils;
import com.hbdl.common.utils.ResultUtil;

/**
 * 文件上传
 * @author ql
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
@RequestMapping("upload")
public class FileUploadAction {

	@RequestMapping(value = "uploadFile")
	public @ResponseBody Map uploadFile(@RequestParam Map reqMap, HttpServletRequest request) {

		Map resultMap = null;
		try {
			Map data = new HashMap();

			/* 获取保存的路径 */
			String savePath = "/upload/tmp/";
			if(!PMSUtils.isEmpty(reqMap.get("savePath"))){
				savePath = PMSUtils.isNull(reqMap.get("savePath"));
			}
			String fileName = PMSUtils.isNull(reqMap.get("name"));
			data.put("fileOrgName", fileName);
			
			fileName = PMSUtils.getUUID();						// 这里随机数 防止重名
			data.put("fileSaveName", fileName);					// 图片存储名称
			String realPath = request.getSession().getServletContext()	.getRealPath(savePath)+ File.separator;
			
			List<UploadFile> list = FileUtils.multipleUploadFile(realPath, fileName, request);
			UploadFile upfile = list.get(0);
			
			String src = savePath + "/" + fileName + "."+upfile.getFileSurfix();
			data.put("realPath", realPath);
			data.put("src", src);	// 根据项目部署路径取，数据库只存文件项目路径下
			
			resultMap =  ResultUtil.getSuccessResult(data);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap = ResultUtil.getErrorResult();
		}

		return resultMap;
	}
	
}
