package com.hbdl.web.sys.utils;

import com.hbdl.web.sys.model.Manhole;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringEscapeUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zgq on 2016/10/1.
 */
public class Test {


    public static void main(String[] args) {

        System.out.println(DigestUtils.md5Hex("123456"));

        String sql="1' or '1'=1'";
        String string_zh="更新/保存ManholeKindType时出错！";
        System.out.println(StringEscapeUtils.escapeSql(sql));
        System.out.println(StringEscapeUtils.escapeJava(string_zh));
        String ll="114.521134969096";
        BigDecimal b1=new BigDecimal(ll);
        Double d=new Double(ll);
//        BigDecimal b2=new BigDecimal(1l);
//        b1=b1.add(b2);
        Manhole manhole=new Manhole();

        manhole.setAreaNum(new BigDecimal(11));
        List<Manhole> manholeList=new ArrayList<Manhole>();
        manholeList.add(manhole);

//      for (Manhole m:manholeList){
//          m.setManholeKindTypeName("dddd");
//      }
//
//        System.out.println(manholeList.get(0).getManholeKindTypeName());
    }

}
