package com.hbdl.common.utils;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by wiipu on 2016/10/15.
 */

public class FileUploadUtils {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static String FILE_DIR="/FILE/";
    /**
     * 删除文件
     * @param filePath 文件在base目录下相对路径
     * @return
     */
    public boolean deleteFile(String filePath) {
        return StringUtils.isEmpty(filePath)
                || FileUtils.deleteFile(FILE_DIR + filePath);
    }
    public FileUploadUtils(String fileDir) {
        if (StringUtils.isNoneEmpty(fileDir)){
            FILE_DIR=fileDir;
        }
        File file=new File(FILE_DIR);
        if (!file.exists()){
            if(file.mkdirs()){
                logger.info("创建根文件夹成功"+file.getAbsolutePath());
            }else{
                logger.error("FILE_DIR===="+FILE_DIR);
                logger.error("创建根文件夹"+FILE_DIR+"失败，");
            }
            FILE_DIR=file.getAbsolutePath()+"/";
        }

    }
    public FileUploadUtils(){
        String baseDir=System.getProperty("user.dir");
        File file=new File(baseDir+"/"+FILE_DIR);
        if (!file.exists()){
            file.mkdir();
            FILE_DIR=file.getAbsolutePath()+"/";
        }
    }
    public boolean dele(String path){
        File file = new File(path);
        if(file.exists()){
            try {
                file.delete();
            }catch (Exception e){
                logger.error(e.getMessage());
            }
            return true;
        }
        return false;
    }

    /**
     * 上传文件、返回相对路径名
     * @param file
     * @param fileName
     * @return strings[0]绝对路径，strings[1]文件名称
     * 使用方法：filename传入要存放的路径+文件名，文件后缀会根据传入的file参数自动生成后缀
     */
    public String[] tacleUpload(MultipartFile file,String filePath, String fileName){
        //得到实际的物理地址
        String path=FILE_DIR+filePath;
        File savePath=new File(path);
        if(!savePath.exists()){
            logger.info("save path "+path+" not exists");
            if(savePath.mkdirs()){
                logger.info("创建文件夹成功"+savePath.getAbsolutePath());
            }else {
                logger.error("创建子文件夹失败："+path);
            }

//            savePath.delete();
            path=savePath.getAbsolutePath();
        }
        logger.debug("save path======="+path);
      //  String attachmentType=null;
        if(file!=null){
            if(file.getSize()!=0){
                String timestamp=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//                String filePathA=timestamp + file.getOriginalFilename();
                Pattern p= Pattern.compile("^.*\\.(.*)$");
                Matcher m=p.matcher(file.getOriginalFilename());
                String suffix ="";
                if(m.find())
                {
                    suffix=m.group(1);
                }
                String filePathA=fileName+timestamp + "."+suffix;
                String logoImageName = path+"/" +filePathA;

                File FILE1 = new File(logoImageName);
                if (!file.isEmpty()) {
                    try {
                        file.transferTo(FILE1);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
                String[] strings={FILE1.getAbsolutePath(),FILE1.getName()};
                return strings;
            }
        }
        return null;
    }
    //二级目录 用户自定义，自己的栏目，，，三级目录文件类型，四级别目录文档编号，
    public static  String tacleUpload(MultipartFile file,String rootDir ,String secondeDir,String thirdDirectory,String forthDirectory, HttpServletRequest request) throws IOException {
        //得到实际的物理地址
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(rootDir).append(secondeDir).append(thirdDirectory).append(forthDirectory);
       // String path=secondeDir+thirdDirectory+forthDirectory;
       // String commentRealPath=request.getSession().getServletContext().getRealPath(stringBuilder.toString());//得到根目录保存地址
        File savePath=new File(stringBuilder.toString());
        if(!savePath.exists()){
            savePath.mkdirs();
        }
        //  String attachmentType=null;
        if(file!=null){
            if(file.getSize()!=0){
                //获得文件扩展名
                String fileExtendName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                String timestap=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String logoImageName = stringBuilder.toString() + File.separator +"_"+timestap + fileExtendName;
                File FILE1 = new File(logoImageName);
                if (!file.isEmpty()) {
                    file.transferTo(FILE1);
                }
                return secondeDir+thirdDirectory+forthDirectory+timestap + fileExtendName;
            }
            else
            {
                return null;
            }
        }
        else {
            return null;
        }

    }

}
