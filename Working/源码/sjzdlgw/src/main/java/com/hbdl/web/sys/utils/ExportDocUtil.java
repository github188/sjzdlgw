package com.hbdl.web.sys.utils;

import com.hbdl.web.sys.controller.page.InspectTaskPage;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.ui.ModelMap;

import java.io.*;
import java.util.*;


/**
 * Created by tanrong.ltr on 16/10/21.
 */
public class ExportDocUtil {
    public static void main(String[] args){

//      String t=Thread.currentThread().getContextClassLoader().getResource("").getPath();
//
//        String destFile="/templates/SafeTemplate.dotx";
//        Map<String,String> map=new HashMap<>();
//        map.put("${workBillsCode}","11");
//        map.put("${taskEmployeeName}","王五");
//        map.put("${workUserList}","张三");
//        map.put("${name}","巡视");
//        ExportDocUtil util=new ExportDocUtil();
//
//        XWPFDocument document=util.replaceDoc(destFile,map);
//
//        try {
//            OutputStream os = new FileOutputStream("./SafeTemplate.doc");
//            document.write(os);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        DocUtil docUtil = new DocUtil();
        InspectTaskPage inspectTaskPage = new InspectTaskPage();
        inspectTaskPage.setWorkBillsCode("1234");
        inspectTaskPage.setTaskName("qqqq");
        inspectTaskPage.setTask_EmployeeName("wwwww");
        inspectTaskPage.setWorkUserList("a,a,2,e");
        ModelMap map=new ModelMap();
        map.put("inspectTaskPage", inspectTaskPage);
//        docUtil.createDoc(map, "QualityTemplate", "./a.doc");
        byte[] bytes = docUtil.createDoc(map, "SafeTemplate");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("./b.doc");
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
            fileOutputStream.close();
        }catch (Exception ex){

        }

    }
    /**
     *将文本直接导出为word
     * @param destFile
     * @param fileCon
     */
    public void exportDoc(String destFile,String fileCon){
        try {
            //doc content
            ByteArrayInputStream bais = new ByteArrayInputStream(fileCon.getBytes());
            POIFSFileSystem fs = new POIFSFileSystem();
            DirectoryEntry directory = fs.getRoot();
            directory.createDocument("WordDocument", bais);
            FileOutputStream ostream = new FileOutputStream(destFile);
            fs.writeFilesystem(ostream);
            bais.close();
            ostream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 读取word模板并替换变量
     * @param srcPath
     * @param map
     * @return
     */
    public  XWPFDocument replaceDoc(String srcPath, Map<String, String> map) {
        // 替换段落中的指定文字
        try {
            String path=this.getClass().getResource(srcPath).getPath();
            File file=new File(path);
            if (!file.exists()){
                System.out.println("file not exist");
            }
            InputStream inputStream=new FileInputStream(file);
            XWPFDocument document=new XWPFDocument(inputStream);

            Iterator<XWPFParagraph> itPara = document.getParagraphsIterator();
            while (itPara.hasNext()) {
                XWPFParagraph paragraph = (XWPFParagraph) itPara.next();
                //String s = paragraph.getParagraphText();
                Set<String> set = map.keySet();
                for (String key : set) {
                    List<XWPFRun> run = paragraph.getRuns();
                    for (int i = 0; i < run.size(); i++) {
                        if (run.get(i).getText(run.get(i).getTextPosition()) != null
                                && run.get(i).getText(run.get(i).getTextPosition()).equals(key)) {
                            /**参数0表示生成的文字是要从哪一个地方开始放置,设置文字从位置0开始
                             * 就可以把原来的文字全部替换掉了
                             * */
                            run.get(i).setText(map.get(key), 0);
                        }
                    }
                }
            }
            return document.getXWPFDocument();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
