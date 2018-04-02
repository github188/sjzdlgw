<%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2016/9/29
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>
<c:set var="staticPath" value="${pageContext.request.contextPath}/static"/>

<div class="accordion" fillSpace="sidebar">
    <div class="accordionContent">
        <ul class="ztree" id="xitongTree_pageId"></ul>
    </div>
</div>
<script>
    var setting = {
        view: {
            dblClickExpand: false,
            showLine: true,
            selectedMulti: false,
            addDiyDom: addDiyDom
        },
        async: {
            enable: true,
            url:"${ctxPath}/tree/system/UserManager",
            autoParam:["id","level"]
        },
        data: {
            simpleData: {
                enable:true,
                idKey: "id",
                pIdKey: "pId",
                rootPId: ""
            }
        },
        callback: {
            onClick: function (event, treeId, treeNode) {
                var rel=treeNode.rel;
                if (rel!=""){
                    rel='${ctxPath}'+rel;
                    navTab.openTab(rel,rel, {title:treeNode.name, fresh:true,data:{"idNum":treeNode.id}});
                }
            }
        }
    };
    var zNodes =[
        { id:100, pId:0, name:"基础类型",rel:"",controlID:"7100"},
        { id:101, pId:100, name:"电压等级",rel:"/PowerCableLevel/index",controlID:"7010"},
        { id:102, pId:100, name:"区域信息",rel:"",controlID:"7050"},
        { id:103, pId:102, name:"市区",rel:"/Area/index?type=1",controlID:"7020"},
        { id:104, pId:102, name:"县区",rel:"/Area/index?type=2",controlID:"7020"},
        { id:105, pId:102, name:"片区",rel:"/Area/index?type=3",controlID:"7020"},
        { id:110, pId:0, name:"单位/部门",rel:"/Organization/index",controlID:"7200"},
        { id:120, pId:0, name:"管网配置",rel:"",controlID:"7300"},
        { id:121, pId:120, name:"通道",rel:"",controlID:"7230"},
        { id:122, pId:121, name:"档案附件类型",rel:"/ArchivesFileType/index",controlID:"7204"},
        { id:123, pId:121, name:"资产分界",rel:"/AssetBorderType/index",controlID:"7208"},
        { id:124, pId:121, name:"通道类型",rel:"/TunnelStructureType/index",controlID:"7212"},
        { id:125, pId:121, name:"通道材质",rel:"/TunnelStuffType/index",controlID:"7216"},
        { id:126, pId:121, name:"支架材质",rel:"/TrestleStuffType/index",controlID:"7220"},
        { id:127, pId:121, name:"排管规格",rel:"/RowTubeType/index",controlID:"7225"},
        { id:128, pId:121, name:"通道样式配置",rel:"/PowerLevelTunnelColor/index",controlID:"7229"},
        { id:129, pId:120, name:"工井",rel:"",controlID:"7250"},
        { id:130, pId:129, name:"工井类型",rel:"/ManholeKindType2/index",controlID:"7235"},
        { id:131, pId:129, name:"设施形状",rel:"/ManholeShapeType/index",controlID:"7240"},
        { id:132, pId:129, name:"设施材质",rel:"/CoverStuffType/index",controlID:"7245"},
        { id:133, pId:120, name:"防火墙",rel:"",controlID:"7270"},
        { id:134, pId:133, name:"防火墙材质",rel:"/FireWallStuffType/index",controlID:"7255"},
        { id:135, pId:133, name:"防火门材质",rel:"/DoorStuffType/index",controlID:"7260"},
        { id:136, pId:133, name:"防火墙类型",rel:"/FireWallType/index",controlID:"7265"},
        { id:137, pId:120, name:"灭火装置",rel:"",controlID:"7280"},
        { id:138, pId:137, name:"灭火装置类型",rel:"/ExtinguisherType/index",controlID:"7275"},
        { id:140, pId:0, name:"线路配置",rel:"",controlID:"7400"},
        { id:141, pId:140, name:"档案附件类型",rel:"/PathArchivesFileType/index",controlID:"7310"},
        { id:142, pId:140, name:"工程性质",rel:"/ProjectType/index",controlID:"7320"},
        { id:143, pId:140, name:"接地方式",rel:"/SafeEarthType/index",controlID:"7330"},
        { id:144, pId:140, name:"敷设方式",rel:"/InstallType/index",controlID:"7340"},
        { id:145, pId:140, name:"设备规格",rel:"/AttachmentModelType/index",controlID:"7350"},
        { id:146, pId:140, name:"防爆盒类型",rel:"/SafeBoxType/index",controlID:"7360"},
        { id:147, pId:140, name:"故障指示器类型",rel:"/FaultIndicatorType/index",controlID:"7370"},
        { id:150, pId:0, name:"终端设施",rel:"",controlID:"7500"},
        { id:151, pId:150, name:"终端设施类型",rel:"/ManholeKindType/index",controlID:"7510"},
        { id:152, pId:150, name:"分接箱规格类型",rel:"/BranchBoxModel/index",controlID:"75200"},
        { id:160, pId:0, name:"缺陷管理",rel:"",controlID:"7600"},
        { id:161, pId:160, name:"缺陷类型",rel:"/FlawType/index",controlID:"7610"},
        { id:162, pId:160, name:"缺陷审核状态",rel:"/FlawAduitStatus/index",controlID:"7620"},
        { id:170, pId:0, name:"相关厂家",rel:"",controlID:"7700"},
        { id:171, pId:170, name:"监理单位",rel:"/Company/index?type=1",controlID:"7610"},
        { id:172, pId:170, name:"施工单位",rel:"/Company/index?type=2",controlID:"7610"},
        { id:173, pId:170, name:"生产厂家",rel:"/Company/index?type=3",controlID:"7610"},
        { id:174, pId:170, name:"电缆厂家",rel:"/Company/index?type=4",controlID:"7610"},
        { id:175, pId:170, name:"电缆附件厂家",rel:"/Company/index?type=5",controlID:"7610"},
        { id:180, pId:0, name:"权限配置",rel:""},
        { id:181, pId:180, name:"菜单功能",rel:"/Function/index"},
        { id:182, pId:180, name:"角色管理",rel:"/Role/index"},
        { id:183, pId:180, name:"用户管理",rel:"",isParent:true},///User/index
    ]
    $(document).ready(function(){
        $.fn.zTree.init($("#xitongTree_pageId"), setting, zNodes);
        removeNotHaveAuthNode();
    });

</script>