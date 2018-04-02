package com.hbdl.web.sys.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.util.Map;

/**
 * Created by GalaIO on 2016/11/24.
 */
public class DocUtil {
    public Configuration configure=null;

    public DocUtil(){
        configure=new Configuration();
        configure.setDefaultEncoding("utf-8");
    }
    /**
     * 根据Doc模板生成word文件
     * @param dataMap 需要填入模板的数据
     * @param downloadType 文件名称
     */
    public byte[] createDoc(Map<String,Object> dataMap, String downloadType){
        byte[] bytes = null;
        try {
            //加载需要装填的模板
            Template template=null;
            //设置模板装置方法和路径，FreeMarker支持多种模板装载方法。可以重servlet，classpath,数据库装载。
            //加载模板文件，放在templates下
            configure.setClassForTemplateLoading(this.getClass(), "/templates/");
            //设置对象包装器
//            configure.setObjectWrapper(new DefaultObjectWrapper());
            //设置异常处理器
            configure.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
            //定义Template对象，注意模板类型名字与downloadType要一致
            template=configure.getTemplate(downloadType+".ftl");
            Writer out=null;
            ByteArrayOutputStream outBytes = new ByteArrayOutputStream();
            out=new BufferedWriter(new OutputStreamWriter(outBytes, "utf-8"));
            template.process(dataMap, out);
            bytes = outBytes.toByteArray();
            outBytes.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return bytes;
    }

}