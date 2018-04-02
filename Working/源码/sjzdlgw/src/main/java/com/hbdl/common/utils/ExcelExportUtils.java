package com.hbdl.common.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.*;

/**
 * Created by zdf on 2016/10/14.
 * Excel数据通用导出工具类
 */
public class ExcelExportUtils<T> {
    /*
     * 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定
     * 条件的数据以EXCEL 的形式输出
     *
     * @param flielName
     *            表格标题名  --需要导出的文件的文件名，命名规范约定为导出的信息+当天日期
     * @param headersName
     *            表格属性列名数组  和 fieldName一一对应 ps:请严格按照顺序写
     * @param fieldName
     *            表格填充对象所对应的字段   需要导出那个按照顺序填写即可
     * @param dtoList
     *            需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象
     * @param out
     *            与输出设备联的流对象，可以将EXCEL文档导出到本地文件或者网络中
     */
    public  ResponseEntity<byte[]> ExportExcel(HttpServletRequest request,String path,
                                               String[] headerName, String[] fieldName
            , List<T> dtoList, String flielName){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
       // String path=request.getSession().getServletContext().getRealPath("/TemplateExcel");
        String path1=request.getSession().getServletContext().getRealPath("/");
       // String path1= ExcelExportUtils.class.getClassLoader().getResource(".."+path).getPath();
        //System.out.println(path1);
        File file=new File(path1+path);

        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"");

        Map<Integer,String> map = new HashMap();
        int key=0;
        for(int i=0;i<headerName.length;i++)
        {
            if(headerName[i]!=null){
                map.put(key,headerName[i]);
                key++;
            }
        }
        //字段
        Map<Integer,String> Zmap = new HashMap();
        int value=0;
        for (int i = 0; i < fieldName.length; i++) {
            if (!fieldName[i].equals(null)) {
                Zmap.put(value, fieldName[i]);
                value++;
            }
        }
        // 声明一个工作薄
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet();
        // 生成一个样式
        HSSFCellStyle style = wb.createCellStyle();
        HSSFRow row = sheet.createRow(0);//获得第一行---用于写表格字段描述
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFCell cell;
        Collection c = map.values();
        Iterator<String> it = c.iterator();
        //根据选择的字段生成表头
        int size = 0;
        while (it.hasNext()) {
            cell = row.createCell(size);
            cell.setCellValue(it.next().toString());
            cell.setCellStyle(style);
            size++;
        }
        //字段
        Collection zdC = Zmap.values();  //需要输出的属性的字段
        Iterator<T> labIt = dtoList.iterator();
        int zdRow =0;
        while (labIt.hasNext()) {
            int zdCell = 0;
            zdRow++;
            row = sheet.createRow(zdRow);
            T l =  labIt.next();
            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            Field[] fields = l.getClass().getDeclaredFields();
            for (short i = 0; i < fields.length; i++) {
                Field field = fields[i];
                String fieldNam = field.getName();
                Iterator<String> zdIt = zdC.iterator();
                while (zdIt.hasNext()) {//遍历所有字段，和需要输出的字段作比较，有的话，就对应找到其get方法，读取到，
                    if (zdIt.next().equals(fieldNam)) {
                        String getMethodName = "get"
                                + fieldNam.substring(0, 1).toUpperCase()
                                + fieldNam.substring(1);
                        Class tCls = l.getClass();
                        try {
                            Method getMethod = tCls.getMethod(getMethodName,
                                    new Class[] {});
                            Object val = getMethod.invoke(l, new Object[] {});
                            String textVal = null;
                            if (val!= null) {
                                textVal = val.toString();
                            }else{
                                textVal = null;
                            }
                            row.createCell(zdCell).setCellValue(textVal);
                            zdCell++;
                        } catch (SecurityException e) {
                            e.printStackTrace();
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }

        try {
            //FileOutputStream xls = new FileOutputStream("D:\\backup\\Pictures\\"+Title+".xls");
            FileOutputStream fileOutputStream=new FileOutputStream(file);//转换成字节流
            BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
            wb.write(bufferedOutputStream);
            bufferedOutputStream.flush();
            fileOutputStream.close();
            bufferedOutputStream.close();
            String fileExtendName = file.getName().substring(file.getName().lastIndexOf("."));
            //根据不同浏览器进行编码设置
            String finalName;
            if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {
                finalName = URLEncoder.encode(flielName, "gb2312");
            } else {
                finalName = new String(flielName.getBytes("gb2312"), "ISO8859-1");
            }
            headers.setContentDispositionFormData("attachment", finalName+fileExtendName);
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);

        } catch (FileNotFoundException e) {

            e.printStackTrace();
            return null;
        } catch (IOException e) {
            return null;
        }
    }
    //根据用户提供的模板来渲染数据

    /**
     *   建议使用方法2
     * @param request
     * @param temPlateNamePath  在资源文件里面加以配置 设置好文件模板的路径
     * @param fieldName
     * @param dtoList
     * @param flielName
     * @return
     */
    public  ResponseEntity<byte[]> ExportExcel2(HttpServletRequest request, String temPlateNamePath, String[] fieldName
            , List<T> dtoList, String flielName) throws IOException, InvalidFormatException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
       // String path=request.getSession().getServletContext().getRealPath("/TemplateExcel");
        File file=new File(temPlateNamePath+".xls");
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"");
        Workbook hssfWorkbook= WorkbookFactory.create(new FileInputStream(file));
        Sheet sheet1=hssfWorkbook.getSheetAt(0);
        String taleTile[]=new String[fieldName.length];
        Row row1=sheet1.getRow(0);

        for(int index=0;index<fieldName.length;index++){
            taleTile[index]=row1.getCell(index).getStringCellValue();
        }
        Map<Integer,String> map = new HashMap();
        int key=0;
        for(int i=0;i<taleTile.length;i++)
        {
            if(taleTile[i]!=null){
                map.put(key,taleTile[i]);
                key++;
            }
        }
        Collection c = map.values();
        Iterator<String> it = c.iterator();
        //根据选择的字段生成表头
        short size = 0;
        Cell cell1;
        while (it.hasNext()) {
            cell1 = row1.createCell(size);
            cell1.setCellValue(it.next().toString());
          //  cell1.setCellStyle(style);
            size++;
        }
        //字段
        Map<Integer,String> Zmap = new HashMap();
        int value=0;
        for (int i = 0; i < fieldName.length; i++) {
            if (!fieldName[i].equals(null)) {
                Zmap.put(value, fieldName[i]);
                value++;
            }
        }
        /*
          正式的文件
         */
        // 声明一个工作薄
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet();
        // 生成一个样式
        HSSFCellStyle style = wb.createCellStyle();
        HSSFRow row = sheet.createRow(0);//获得第一行---用于写表格字段描述
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFCell cell;
        //字段
        Collection zdC = Zmap.values();  //需要输出的属性的字段
        Iterator<T> labIt = dtoList.iterator();
        int zdRow =0;

        while (labIt.hasNext()) {
            int zdCell = 0;
            zdRow++;
            row = sheet.createRow(zdRow);
            T l =  labIt.next();
            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            Field[] fields = l.getClass().getDeclaredFields();
            for (short i = 0; i < fields.length; i++) {
                Field field = fields[i];
                String fieldNam = field.getName();
                Iterator<String> zdIt = zdC.iterator();
                while (zdIt.hasNext()) {//遍历所有字段，和需要输出的字段作比较，有的话，就对应找到其get方法，读取到，
                    if (zdIt.next().equals(fieldNam)) {
                        String getMethodName = "get"
                                + fieldNam.substring(0, 1).toUpperCase()
                                + fieldNam.substring(1);
                        Class tCls = l.getClass();
                        try {
                            Method getMethod = tCls.getMethod(getMethodName,
                                    new Class[] {});
                            Object val = getMethod.invoke(l, new Object[] {});
                            String textVal = null;
                            if (val!= null) {
                                textVal = val.toString();
                            }else{
                                textVal = null;
                            }
                            row.createCell(zdCell).setCellValue(textVal);
                            zdCell++;
                        } catch (SecurityException e) {
                            e.printStackTrace();
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }

        try {
            //FileOutputStream xls = new FileOutputStream("D:\\backup\\Pictures\\"+Title+".xls");
            FileOutputStream fileOutputStream=new FileOutputStream(file);//转换成字节流
            BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
            wb.write(bufferedOutputStream);
            bufferedOutputStream.flush();
            fileOutputStream.close();
            bufferedOutputStream.close();
            String fileExtendName = file.getName().substring(file.getName().lastIndexOf("."));
            String finalName=  new String(flielName.getBytes("utf-8"), "ISO-8859-1");
            headers.setContentDispositionFormData("attachment", finalName+fileExtendName);
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);

        } catch (FileNotFoundException e) {

            e.printStackTrace();
            return null;
        } catch (IOException e) {
            return null;
        }
    }

}
