package com.hbdl.web.sys.utils.constants;

/**
 * Created by tanrong.ltr on 16/10/22.
 */
public interface TableConstants {

    /*
     * manhole type
     */
    Integer ManholeType_dianlanjing = 0x01;
    Integer ManholeType_xunijing = 0x02;
    Integer ManholeType_biandianzhanchuxianjing = 0x03;
    Integer ManholeType_zhongduansheshi = 0x04;

    /*
     *PowerLoop status
     */
    Integer PowerLoopStatus_yuzhanwei = 0x01;
    Integer PowerLoopStatus_zaiyun = 0x02;
    Integer PowerLoopStatus_tingyun = 0x03;
    Integer PowerLoopStatus_tuiyun = 0x04;
    Integer PowerLoopPathCableType_sanxiangdian = 0x03;
    Integer PowerLoopPathCableType_peidianORmix = 0x01;

    /*
      pathcbale phase
     */
    Integer PathCablePhaseID_A=0x01;
    Integer PathCablePhaseID_B=0x02;
    Integer PathCablePhaseID_C=0x03;
    Integer PathCablePhaseID_GND=0x04;
    Integer PathCablePhaseID_MIX=0x05;

    /**
     * flawAduitStatusID
     */

    Integer FlawAduitStatus_BANZHANG=1;
    Integer FlawAduitStatus_ZHANZE=2;
    Integer FlawAduitStatus_ZHUREN=3;
    Integer FlawAduitStatus_ZANBUCHULI=4;
    Integer FlawAduitStatus_BUCHULI=5;
    Integer FlawAduitStatus_CHULI=6;
    Integer FlawAduitStatus_CHULIZHONG=7;
    Integer FlawAduitStatus_YIXIAOQUE=8;


    /**
     * flawSourceTypeID
     */

    Integer FlawSourceType_XIANCHANGXUNLUO=1;
    Integer FlawSourceType_DIANLIREXIAN=2;
    Integer FlawSourceType_QITA=3;


    /**
     * flawLevelTypeID
     */

    Integer FlawLevelType_YIBAN=1;
    Integer FlawLevelType_YANZHONG=2;
    Integer FlawLevelType_WEIJI=3;


    /**
     * FlawAduitWay
     */

    Integer FlawAduitWay_ZANBUCHULI=1;
    Integer FlawAduitWay_CHULI=2;
    Integer FlawAduitWay_WUXUCHULI=3;
    Integer FlawAduitWay_SHANBAO=4;


    /**
     * TaskStatusType
     */

    Integer TaskStatusType_JIHUA=1;
    Integer TaskStatusType_ZHIXING=2;
    Integer TaskStatusType_JIESHU=3;

    /**
     * JSP CONSTANTS
     */
    Integer Accept_PASS=1;
    Integer Accept_Fail=2;
    Integer Accept_PASS_ONLY=3;

    /**
     * JSP CHECK status
     */
    Integer Check_Pass=1;
    Integer Check_Pass_BUT_NO_FILE=2;
    Integer Check_Fail=3;


    /**
     * FlawProcAcceptType
     */

    Integer FlawProcAcceptType_YIXIAOQUE=1;
    Integer FlawProcAcceptType_WEIWANQUANXIAOQUE=2;
    Integer FlawProcAcceptType_WEIXIAOQUE=3;


    /**
     * AttachmentTypeID
     */
    public static Integer AttachmentTypeID_benti=1;
    public static Integer AttachmentTypeID_jietou=2;
    public static Integer AttachmentTypeID_zhongduan=3;
    public static Integer AttachmentTypeID_jiedixiang=4;
    /**
     * PathTypeID
     */
    public static Integer PathTypeID_biandian=1;
    public static Integer PathTypeID_shudian=2;
    public static Integer PathTypeID_peidian=3;
    /**
     * companytype
     */
    public static Integer CompanyTypeID_shengchanchangjia=3;
    public static Integer CompanyTypeID_dianlanchangjia=4;

    /**
     * AcceptStatusType
     */
    Integer AcceptStatusType_CAOGAO=1;
    Integer AcceptStatusType_DAIYAN=2;
    Integer AcceptStatusType_YANSHOUJIHUAZHONG=3;
    Integer AcceptStatusType_YANSHOUZHONG=4;
    Integer AcceptStatusType_SHENGHEZHUANGTAI=5;
    Integer AcceptStatusType_SHENGHETONGGUO=6;
    Integer AcceptStatusType_SHENGHUOTONGGUO_ZILIAOBUQUAN=7;
    Integer AcceptStatusType_GUIHUAZHONG=8;

    /**
     * 行政级别
     * 0组员
     * 1班长
     * 2专责
     * 3主任
     * 4书记
     */
    public static Integer UserGrade_zuyuan=0;
    public static Integer UserGrade_banzhang=1;
    public static Integer UserGrade_zhuanze=2;
    public static Integer UserGrade_zhuren=3;
    public static Integer UserGrade_shuji=4;
    public static String StrUserGrade_zuyuan="组员";
    public static String StrUserGrade_banzhang="班长";
    public static String StrUserGrade_zhuanze="专责";
    public static String StrUserGrade_zhuren="主任";
    public static String StrUserGrade_shuji="书记";

    /*
     *
     *teamtypeid
     * 通道 1
     * 输电 2
     * 配电 3
     *
     */
    public static Integer TeamTypeID_tongdao = 1;
    public static Integer TeamTypeID_shudian = 2;
    public static Integer TeamTypeID_peidian = 3;

    /*
     *
     * 业务管理
     *
     */
    public static Integer Manage_yanshou = 1;
    public static Integer Manage_xunshi = 2;
    public static Integer Manage_quexian = 3;
    public static Integer Manage_xiaoque = 4;

    public static Integer TunnleTowardType_east=1;
    public static Integer TunnleTowardType_south=2;
    public static Integer TunnleTowardType_west=3;
    public static Integer TunnleTowardType_north=4;

}
