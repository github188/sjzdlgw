package com.hbdl.web.sys.utils;

import com.hbdl.common.utils.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tanrong.ltr on 16/10/22.
 */
public class FileUploadUtil {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    private final String FILE_DOT=".";
    private String baseDir;

    public FileUploadUtil(String baseDi) {
        if (StringUtils.isNoneEmpty(baseDi)){
            if (!baseDi.endsWith("/")){
                baseDi=baseDi+"/";
            }
            File file=new File(baseDi);
            if (!file.exists()){
                boolean f=file.mkdir();
                logger.info("mkdir "+ baseDi+" "+f);
            }
            baseDir=baseDi;

        }else {
            logger.error("input base dir is empty");
        }
    }

    /**
     * 上传file到
     * @param file 文件本身
     * @param fileDir 文件目录
     * @param fileName 文件名称
     * @return
     */
    public String uploadFile(MultipartFile file, String fileDir, String fileName){
        if (file==null)return null;
        String relativeFilePath;
        if (StringUtils.isEmpty(fileDir)){
            relativeFilePath="";
        }else if (fileDir.endsWith("/")){
            relativeFilePath=fileDir;
        }else {
            relativeFilePath=fileDir+"/";
        }
        File relativeFile=new File(baseDir+relativeFilePath);
        if (!relativeFile.exists()){
            logger.info("mkdir "+relativeFilePath+" "+relativeFile.mkdir());
        }
        String timestamp=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String toFilePath=relativeFilePath+cleanStr(fileName)+timestamp+FILE_DOT+getExtensionName(file.getOriginalFilename());
        File toFile=new File(baseDir+toFilePath);
        try {
            file.transferTo(toFile);
            return toFilePath;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 删除文件
     * @param filePath 文件在base目录下相对路径
     * @return
     */
    public boolean deleteFile(String filePath) {
        return StringUtils.isEmpty(filePath)
                || FileUtils.deleteFile(baseDir + filePath);
    }


    public String getCompleteFilePath(String filePath){
        if (StringUtils.isEmpty(filePath)) return null;
        return baseDir+filePath;
    }

    /**
     * Java文件操作 获取文件扩展名
     * @param filename
     * @return
     */
    private static String getExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot >-1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return filename;
    }
    /**
     * Java文件操作 获取不带扩展名的文件名
     * @param filename
     * @return
     */
    private static String getFileNameNoEx(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot >-1) && (dot < (filename.length()))) {
                return filename.substring(0, dot);
            }
        }
        return filename;
    }

    /**
     * 清除字符串中所有特殊字符
     * @param str
     * @return
     */
    private static String cleanStr(String str){
        String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }
}
