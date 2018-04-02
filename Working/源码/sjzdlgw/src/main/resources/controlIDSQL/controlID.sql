
--说明---------------------------------------------------------------------------------------------------------------
--大家先在mindManger里面整理好标签的ID和路径，然后再在这里面添加sql语句-----
---------------------------------------------------------------------------------------------------------------------
--ApplicationModuleID该功能ID号
--ParentModuleID 父ID号
--ApplicationModuleName该功能名称
--Context描述信息
--IsDisplay是否可见,一般都是可见的
--FunctionPath功能路径，一般指<a href="/test">标签的href后的路径
truncate table ROLEFUNCTIONS;
truncate table ACCESSFUNCTION;
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--地图
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2000,null,'地图服务',null,1,'/tree/map');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (1001,2000,'要素查看',null,1,'/tree/map');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2000,null,'地图',null,1,'/tree/map');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2000,null,'地图',null,1,'/tree/map');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2000,null,'地图',null,1,'/tree/map');

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--管网
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3000,null,'管网',null,1,'/sidebar_guangwang');

--------管网台账和附属设施--------------------------------------------------------------------------------------------------------------------------------------------------------

insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2100,3000,'管网台账',null,1,'/test');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2010,2100,'通道档案',null,1,'/Ledger/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2009,2010,'查看',null,1,'/Ledger/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2001,2010,'添加、编辑',null,1,'/Ledger/add/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2002,2010,'删除',null,1,'/Ledger/delete/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2003,2010,'文档附件',null,1,'/Ledger/uploadTunnelArchivesFile/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2004,2010,'下发档案',null,1,'/Ledger/pullToAduit/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2005,2010,'打印封面',null,1,'/Ledger/downloadCover/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2006,2010,'查询导出',null,1,'/Ledger/Export/excel/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2020,2100,'通道台账',null,1,'/PowerTunnel/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2019,2020,'查看',null,1,'/PowerTunnel/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2011,2020,'添加、编辑',null,1,'/PowerTunnel/add/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2012,2020,'删除',null,1,'/PowerTunnel/delete/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2013,2020,'查询导出',null,1,'/PowerTunnel/Export/excel');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2030,2100,'通道内工井',null,1,'/ManholeLaborWell/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2029,2030,'查看',null,1,'/ManholeLaborWell/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2021,2030,'添加、编辑',null,1,'/ManholeLaborWell/add/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2022,2030,'删除',null,1,'/ManholeLaborWell/delete/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2023,2030,'查询导出',null,1,'/ManholeLaborWell/Export/excel');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2040,2100,'通道段',null,1,'/TunnelSection/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2031,2040,'查看',null,1,'/TunnelSection/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2032,2040,'修改',null,1,'/test');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2033,2040,'定位',null,1,'/test');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2034,2040,'3d敷设',null,1,'/3dPage');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2200,3000,'附属设施',null,1,'/test');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2110,2200,'防火墙',null,1,'/FireWall/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2101,2110,'查看',null,1,'/FireWall/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2102,2110,'添加、编辑',null,1,'/FireWall/add/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2103,2110,'删除',null,1,'/FireWall/delete/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2104,2110,'查询导出',null,1,'/FireWall/Export/excel');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2120,2200,'灭火装置',null,1,'/Extinguisher/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2111,2120,'查看',null,1,'/Extinguisher/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2112,2120,'添加、编辑',null,1,'/Extinguisher/add/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2113,2120,'删除',null,1,'/Extinguisher/delete/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2114,2120,'查询导出',null,1,'/Extinguisher/Export/excel');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2130,2200,'工作井',null,1,'/test');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2121,2130,'查看',null,1,'/test');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2122,2130,'添加、编辑',null,1,'/test');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2123,2130,'删除',null,1,'/test');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2124,2130,'查询导出',null,1,'/test');


--------业务管理--------------------------------------------------------------------------------------------------------------------------------------------------------
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2820,3000,'验收管理',null,1,'/TunnelAduit/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2801,2820,'查看',null,1,'/TunnelAduit/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2802,2820,'删除',null,1,'/TunnelAduit/delete');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2803,2820,'新建计划',null,1,'/TunnelAduit/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2804,2820,'确定计划',null,1,'/TunnelAduit/append');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2805,2820,'完成计划',null,1,'/TunnelAduit/aduit');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2806,2820,'审核验收',null,1,'/TunnelAduit/check');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2807,2820,'完成验收',null,1,'/TunnelAduit/view');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2808,2820,'查看附件列表',null,1,'/TunnelAduit/FileView');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2809,2820,'添加、编辑',null,1,'/TunnelAduit/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2810,2820,'打印封面',null,1,'/TunnelAduit/downloadCover');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2811,2820,'编辑档案',null,1,'/Ledger/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2812,2820,'文档附件',null,1,'/Ledger/uploadTunnelArchivesFile');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2813,2820,'下发档案',null,1,'/Ledger/pullToAduit');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2840,3000,'巡视管理',null,1,'/InspectTask/1/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2821,2840,'查看',null,1,'/InspectTask/1/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2822,2840,'删除',null,1,'/InspectTask/1/delete');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2823,2840,'发起任务',null,1,'/InspectTask/1/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2824,2840,'确定任务',null,1,'/InspectTask/1/assign');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2825,2840,'录入任务',null,1,'/InspectTask/1/append');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2826,2840,'完成任务',null,1,'/InspectTask/1/view');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2827,2840,'安全控制卡',null,1,'/InspectTask/1/downloadSafe');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2828,2840,'质量控制卡',null,1,'/InspectTask/1/downloadQuality');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2829,2840,'查看附件列表',null,1,'/InspectObjFlaw/1/FileView');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2830,2840,'添加、编辑',null,1,'/InspectTask/1/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2860,3000,'消缺管理',null,1,'/FlawProcTask/1/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2841,2860,'查看',null,1,'/FlawProcTask/1/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2842,2860,'删除',null,1,'/FlawProcTask/1/delete');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2843,2860,'发起任务',null,1,'/FlawProcTask/1/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2844,2860,'确定任务',null,1,'/FlawProcTask/1/assign');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2845,2860,'录入任务',null,1,'/FlawProcTask/1/append');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2846,2860,'完成任务',null,1,'/FlawProcTask/1/view');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2847,2860,'安全控制卡',null,1,'/FlawProcTask/1/downloadSafe');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2848,2860,'质量控制卡',null,1,'/FlawProcTask/1/downloadQuality');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2849,2860,'查看附件列表',null,1,'/FlawProcTask/1/FileView');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2850,2860,'添加、编辑',null,1,'/FlawProcTask/1/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2880,3000,'缺陷管理',null,1,'/InspectObjFlaw/1/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2861,2880,'查看',null,1,'/InspectObjFlaw/1/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2862,2880,'添加、编辑',null,1,'/InspectObjFlaw/1/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2863,2880,'删除',null,1,'/InspectObjFlaw/1/delete');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2864,2880,'缺陷审核',null,1,'/InspectObjFlaw/1/Aduit');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (2865,2880,'附件',null,1,'/InspectObjFlaw/1/File');
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--输电
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4000,null,'输电',null,1,'/sidebar_shudian');
-------线路段台账------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3010,4000,'线路',null,1,'/CablePath/1/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3001,3010,'查看',null,1,'/CablePath/1/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3002,3010,'添加、编辑',null,1,'/CablePath/1/add/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3003,3010,'删除',null,1,'/CablePath/1/delete/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3004,3010,'导出',null,1,'/CablePath/1/Export/excel');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3020,4000,'线路段',null,1,'/PathSection/1/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3011,3020,'查看',null,1,'/PathSection/1/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3012,3020,'添加、编辑',null,1,'/PathSection/1/edit/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3013,3020,'删除',null,1,'/PathSection/1/delete/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3014,3020,'导出',null,1,'/CablePathSecetions/1/export/excel');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3015,3020,'停运',null,1,'/PathSection/1/charge/outage');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3016,3020,'启用',null,1,'/PathSection/1/charge/recover');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3017,3020,'退运',null,1,'/PathSection/1/charge/returned');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3030,4000,'回路',null,1,'/PowerLoop/1/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3021,3030,'查看',null,1,'/PowerLoop/1/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3022,3030,'添加、编辑',null,1,'/PowerLoop/1/edit/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3023,3030,'删除',null,1,'/PowerLoop/1/delete/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3040,4000,'电缆',null,1,'/PathCable/1/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3031,3040,'查看',null,1,'/PathCable/1/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3032,3040,'添加、编辑',null,1,'/PathCable/1/edit');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3050,4000,'接地箱附属设备',null,1,'/LoopEarthBox/1/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3041,3050,'查看',null,1,'/LoopEarthBox/1/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3042,3050,'添加、编辑',null,1,'/LoopEarthBox/1/edit');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3043,3050,'删除',null,1,'/LoopEarthBox/1/delete');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3060,4000,'附属设备',null,1,'/AttachmentOfCable/1/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3051,3060,'查看',null,1,'/AttachmentOfCable/1/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3052,3060,'添加、编辑',null,1,'/AttachmentOfCable/1/edit');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3053,3060,'删除',null,1,'/AttachmentOfCable/1/delete');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3820,4000,'验收管理',null,1,'/CableInspecteManage/1/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3801,3820,'查看',null,1,'/CableInspecteManage/1/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3802,3820,'删除',null,1,'/CableInspecteManage/1/delete');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3803,3820,'新建计划',null,1,'/CableInspecteManage/1/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3804,3820,'确定计划',null,1,'/CableInspecteManage/1/append');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3805,3820,'完成计划',null,1,'/CableInspecteManage/1/aduit');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3806,3820,'审核验收',null,1,'/CableInspecteManage/1/check');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3807,3820,'完成验收',null,1,'/CableInspecteManage/1/view');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3808,3820,'查看附件列表',null,1,'/CableInspecteManage/1/FileView');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3809,3820,'添加、编辑',null,1,'/CableInspecteManage/1/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3810,3820,'编辑档案',null,1,'/CableDeviceLedger/1/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3811,3820,'文档附件',null,1,'/CableDeviceLedger/1/uploadCableDeviceLegerAttament/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3812,3820,'下发档案',null,1,'/CableDeviceLeger/1/pullToAduit');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3840,4000,'巡视管理',null,1,'/InspectTask/2/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3821,3840,'查看',null,1,'/InspectTask/2/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3822,3840,'删除',null,1,'/InspectTask/2/delete');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3823,3840,'发起任务',null,1,'/InspectTask/2/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3824,3840,'确定任务',null,1,'/InspectTask/2/assign');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3825,3840,'录入任务',null,1,'/InspectTask/2/append');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3826,3840,'完成任务',null,1,'/InspectTask/2/view');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3827,3840,'安全控制卡',null,1,'/InspectTask/2/downloadSafe');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3828,3840,'质量控制卡',null,1,'/InspectTask/2/downloadQuality');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3829,3840,'查看附件列表',null,1,'/InspectObjFlaw/2/FileView');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3830,3840,'添加、编辑',null,1,'/InspectTask/2/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3860,4000,'消缺管理',null,1,'/FlawProcTask/2/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3841,3860,'查看',null,1,'/FlawProcTask/2/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3842,3860,'删除',null,1,'/FlawProcTask/2/delete');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3843,3860,'发起任务',null,1,'/FlawProcTask/2/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3844,3860,'确定任务',null,1,'/FlawProcTask/2/assign');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3845,3860,'录入任务',null,1,'/FlawProcTask/2/append');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3846,3860,'完成任务',null,1,'/FlawProcTask/2/view');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3847,3860,'安全控制卡',null,1,'/FlawProcTask/2/downloadSafe');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3848,3860,'质量控制卡',null,1,'/FlawProcTask/2/downloadQuality');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3849,3860,'查看附件列表',null,1,'/FlawProcTask/2/FileView');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3850,3860,'添加、编辑',null,1,'/FlawProcTask/2/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3880,4000,'缺陷管理',null,1,'/InspectObjFlaw/2/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3861,3880,'查看',null,1,'/InspectObjFlaw/2/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3862,3880,'添加、编辑',null,1,'/InspectObjFlaw/2/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3863,3880,'删除',null,1,'/InspectObjFlaw/2/delete');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3864,3880,'缺陷审核',null,1,'/InspectObjFlaw/2/Aduit');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3865,3880,'附件',null,1,'/InspectObjFlaw/2/File');
-------设施档案------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3300,4000,'设施档案',null,1,'/CableDeviceLedger/transmission/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3210,3300,'查看',null,1,'/CableDeviceLedger/transmission/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3220,3300,'添加编辑',null,1,'/CableDeviceLedger/transmission/add/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3230,3300,'删除',null,1,'/CableDeviceLeger/transmission/delete/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3240,3300,'导出',null,1,'/CableDeviceLedger/transmission/exportExcels');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3250,3300,'文档附件',null,1,'/CableDeviceLedger/transmission/uploadCableDeviceLegerAttament/');
-------本体台账------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3400,4000,'本体台账',null,1,'/CableAttachment/transmission/section/index/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3310,3400,'查看',null,1,'/CableAttachment/transmission/section/index/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3320,3400,'添加编辑',null,1,'/CableAttachment/transmission/section/index/add/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3330,3400,'删除',null,1,'/CableAttachment/transmission/section/index/delete/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3340,3400,'导出',null,1,'/CableAttachment/transmission/section/index/Export/excel');
------终端台账-------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3500,4000,'终端台账',null,1,'/CableAttachment/transmission/terminal/index/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3410,3500,'查看',null,1,'/CableAttachment/transmission/terminal/index/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3420,3500,'添加编辑',null,1,'/CableAttachment/transmission/terminal/index/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3430,3500,'删除',null,1,'/CableAttachment/transmission/terminal/index/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3440,3500,'导出',null,1,'/CableAttachment/transmission/terminal/index/index');
------接头台账-------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3600,4000,'接头台账',null,1,'/CableAttachment/transmission/connector/index/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3510,3600,'查看',null,1,'/CableAttachment/transmission/connector/index/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3520,3600,'添加编辑',null,1,'/CableAttachment/transmission/connector/index/add/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3530,3600,'删除',null,1,'/CableAttachment/transmission/connector/index/delete/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3540,3600,'导出',null,1,'/CableAttachment/transmission/connector/index/Export/excel');
------接地箱-------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3700,4000,'接地箱',null,1,'/CableAttachment/transmission/EarthBox/index/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3610,3700,'查看',null,1,'/CableAttachment/transmission/EarthBox/index/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3620,3700,'添加编辑',null,1,'/CableAttachment/transmission/EarthBox/index/add/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3630,3700,'删除',null,1,'/CableAttachment/transmission/EarthBox/index/delete/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (3640,3700,'导出',null,1,'/CableAttachment/transmission/EarthBox/index/Export/excel');

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--配电
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (5000,null,'配电',null,1,'/sidebar_shudian');
-------线路段台账-------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4010,5000,'线路',null,1,'/CablePath/2/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4001,4010,'查看',null,1,'/CablePath/2/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4002,4010,'添加、编辑',null,1,'/CablePath/2/add/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4003,4010,'删除',null,1,'/CablePath/2/delete/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4004,4010,'导出',null,1,'/CablePath/2/Export/excel');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4020,5000,'线路段',null,1,'/PathSection/2/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4011,4020,'查看',null,1,'/PathSection/2/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4012,4020,'添加、编辑',null,1,'/PathSection/2/edit/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4013,4020,'删除',null,1,'/PathSection/2/delete/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4014,4020,'导出',null,1,'/CablePathSecetions/2/export/excel');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4015,4020,'停运',null,1,'/PathSection/2/charge/outage');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4016,4020,'启用',null,1,'/PathSection/2/charge/recover');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4017,4020,'退运',null,1,'/PathSection/2/charge/returned');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4030,5000,'回路',null,1,'/PowerLoop/2/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4021,4030,'查看',null,1,'/PowerLoop/2/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4022,4030,'添加、编辑',null,1,'/PowerLoop/2/edit/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4023,4030,'删除',null,1,'/PowerLoop/2/delete/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4040,5000,'电缆',null,1,'/PathCable/2/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4031,4040,'查看',null,1,'/PathCable/2/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4032,4040,'添加、编辑',null,1,'/PathCable/2/edit');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4050,5000,'接地箱附属设备',null,1,'/LoopEarthBox/2/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4041,4050,'查看',null,1,'/LoopEarthBox/2/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4042,4050,'添加、编辑',null,1,'/LoopEarthBox/2/edit');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4043,4050,'删除',null,1,'/LoopEarthBox/2/delete');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4060,5000,'附属设备',null,1,'/AttachmentOfCable/2/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4051,4060,'查看',null,1,'/AttachmentOfCable/2/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4052,4060,'添加、编辑',null,1,'/AttachmentOfCable/2/edit');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4053,4060,'删除',null,1,'/AttachmentOfCable/2/delete');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4820,5000,'验收管理',null,1,'/CableInspecteManage/2/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4801,4820,'查看',null,1,'/CableInspecteManage/2/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4802,4820,'删除',null,1,'/CableInspecteManage/2/delete');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4803,4820,'新建计划',null,1,'/CableInspecteManage/2/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4804,4820,'确定计划',null,1,'/CableInspecteManage/2/append');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4805,4820,'完成计划',null,1,'/CableInspecteManage/2/aduit');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4806,4820,'审核验收',null,1,'/CableInspecteManage/2/check');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4807,4820,'完成验收',null,1,'/CableInspecteManage/2/view');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4808,4820,'查看附件列表',null,1,'/CableInspecteManage/2/FileView');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4809,4820,'添加、编辑',null,1,'/CableInspecteManage/2/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4810,4820,'编辑档案',null,1,'/CableDeviceLedger/2/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4811,4820,'文档附件',null,1,'/CableDeviceLedger/2/uploadCableDeviceLegerAttament/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4812,4820,'下发档案',null,1,'/CableDeviceLeger/2/pullToAduit');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4840,5000,'巡视管理',null,1,'/InspectTask/3/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4821,4840,'查看',null,1,'/InspectTask/3/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4822,4840,'删除',null,1,'/InspectTask/3/delete');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4823,4840,'发起任务',null,1,'/InspectTask/3/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4824,4840,'确定任务',null,1,'/InspectTask/3/assign');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4825,4840,'录入任务',null,1,'/InspectTask/3/append');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4826,4840,'完成任务',null,1,'/InspectTask/3/view');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4827,4840,'安全控制卡',null,1,'/InspectTask/3/downloadSafe');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4828,4840,'质量控制卡',null,1,'/InspectTask/3/downloadQuality');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4829,4840,'查看附件列表',null,1,'/InspectObjFlaw/3/FileView');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4830,4840,'添加、编辑',null,1,'/InspectTask/3/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4860,5000,'消缺管理',null,1,'/FlawProcTask/3/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4841,4860,'查看',null,1,'/FlawProcTask/3/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4842,4860,'删除',null,1,'/FlawProcTask/3/delete');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4843,4860,'发起任务',null,1,'/FlawProcTask/3/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4844,4860,'确定任务',null,1,'/FlawProcTask/3/assign');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4845,4860,'录入任务',null,1,'/FlawProcTask/3/append');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4846,4860,'完成任务',null,1,'/FlawProcTask/3/view');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4847,4860,'安全控制卡',null,1,'/FlawProcTask/3/downloadSafe');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4848,4860,'质量控制卡',null,1,'/FlawProcTask/3/downloadQuality');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4849,4860,'查看附件列表',null,1,'/FlawProcTask/3/FileView');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4850,4860,'添加、编辑',null,1,'/FlawProcTask/3/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4880,5000,'缺陷管理',null,1,'/InspectObjFlaw/3/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4861,4880,'查看',null,1,'/InspectObjFlaw/3/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4862,4880,'添加、编辑',null,1,'/InspectObjFlaw/3/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4863,4880,'删除',null,1,'/InspectObjFlaw/3/delete');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4864,4880,'缺陷审核',null,1,'/InspectObjFlaw/3/Aduit');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4865,4880,'附件',null,1,'/InspectObjFlaw/3/File');
-------设施档案-------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4300,5000,'设施档案',null,1,'/CableDeviceLedger/distribution/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4210,4300,'查看',null,1,'/CableDeviceLedger/distribution/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4220,4300,'添加编辑',null,1,'/CableDeviceLedger/distribution/add/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4230,4300,'删除',null,1,'/CableDeviceLeger/distribution/delete/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4240,4300,'导出',null,1,'/CableDeviceLedger/distribution/exportExcels');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4250,4300,'文档附件',null,1,'/CableDeviceLedger/distribution/uploadCableDeviceLegerAttament/');
-------本体台账-----------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4400,5000,'本体台账',null,1,'/CableAttachment/distribution/section/index/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4310,4400,'查看',null,1,'/CableAttachment/distribution/section/index/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4320,4400,'添加编辑',null,1,'/CableAttachment/distribution/section/index/add/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4330,4400,'删除',null,1,'/CableAttachment/distribution/section/index/delete/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4340,4400,'导出',null,1,'/CableAttachment/distribution/section/index/Export/excel');
------终端台账-----------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4500,5000,'终端台账',null,1,'/CableAttachment/distribution/terminal/index/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4410,4500,'查看',null,1,'/CableAttachment/distribution/terminal/index/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4420,4500,'添加编辑',null,1,'/CableAttachment/distribution/terminal/index/add/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4430,4500,'删除',null,1,'/CableAttachment/distribution/terminal/index/delete/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4440,4500,'导出',null,1,'/CableAttachment/distribution/terminal/index/Export/excel');
------接头台账-----------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4600,5000,'接头台账',null,1,'/CableAttachment/distribution/connector/index/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4510,4600,'查看',null,1,'/CableAttachment/distribution/connector/index/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4520,4600,'添加编辑',null,1,'/CableAttachment/distribution/connector/index/add/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4530,4600,'删除',null,1,'/CableAttachment/distribution/connector/index/delete/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4540,4600,'导出',null,1,'/CableAttachment/distribution/connector/index/Export/excel');



-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--终端管理
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (6000,null,'终端管理',null,1,'/sidebar_zhongduanguanli');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (5100,6000,'变电站',null,1,'/BaseFacility/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (5001,5100,'查看',null,1,'/BaseFacility/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (5002,5100,'添加编辑',null,1,'/BaseFacility/add/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (5003,5100,'删除',null,1,'/BaseFacility/delete/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (5004,5100,'导出',null,1,'/BaseFacility/Export/excel');

insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (5200,6000,'终端设施',null,1,'/Manhole/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (5101,5200,'查看',null,1,'/Manhole/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (5102,5200,'添加编辑',null,1,'/Manhole/add/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (5103,5200,'删除',null,1,'/Manhole/delete/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (5104,5200,'导出',null,1,'/Manhole/Export/excel');

insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (5300,6000,'分接箱',null,1,'/BranchBox/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (5201,5300,'查看',null,1,'/BranchBox/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (5202,5300,'添加编辑',null,1,'/BranchBox/add/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (5203,5300,'删除',null,1,'/BranchBox/delete/');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (5204,5300,'导出',null,1,'/BranchBox/Export/excel');

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--决策分析
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7000,null,'决策分析',null,1,'/sidebar_jueceguanli');
------------档案分析---------------------------------------------------------------------------------------------------------------------------
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (6100,7000,'档案分析',null,1,'/LedgerStatistics/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (6010,6100,'查看',null,1,'/LedgerStatistics/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (6020,6100,'导出',null,1,'/LedgerStatistics/Export/excel');

----------通道分析----------------------------------------------------------------------------------------------------------------------------------
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (6200,7000,'通道分析',null,1,'/PowerTunnelStatistics/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (6110,6200,'查看',null,1,'/PowerTunnelStatistics/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (6120,6200,'导出',null,1,'/PowerTunnelStatistics/Export/excel');

----------工井/终端分析--------------------------------------------------------------------------------------------------------------------------------
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (6300,7000,'工井/终端分析',null,1,'/ManholeLaborWellAnalysis/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (6210,6300,'查看',null,1,'/ManholeLaborWellAnalysis/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (6220,6300,'导出',null,1,'/ManholeLaborWellAnalysis/Export/excel');

-----------通道长度统计------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (6400,7000,'通道长度统计',null,1,'/LedgerStatistics/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (6310,6400,'查看',null,1,'/LedgerStatistics/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (6320,6400,'导出',null,1,'/LedgerStatistics/Export/excel');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (6330,6400,'地图框选',null,1,'');



------------工井/终端统计------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (6500,7000,'工井/终端统计',null,1,'/ManholeAndTerminalStatistics/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (6410,6500,'查看',null,1,'/ManholeAndTerminalStatistics/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (6420,6500,'导出',null,1,'/ManholeAndTerminalStatistics/Export/excel');

------------分接箱统计------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (6600,7000,'分接箱统计',null,1,'/BranchBoxStatistics/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (6510,6600,'查看',null,1,'/BranchBoxStatistics/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (6520,6600,'导出',null,1,'/BranchBoxStatistics/Export/excel');
------------回路统计统计------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (6700,7000,'回路统计',null,1,'/PowerLoopStatistics/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (6610,6700,'查看',null,1,'/PowerLoopStatistics/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (6620,6700,'导出',null,1,'/PowerLoopStatistics/Export/excel');

------------敷设占用统计------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (6800,7000,'敷设占用统计',null,1,'/LayingOccupationStatistics/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (6710,6800,'查看',null,1,'/LayingOccupationStatistics/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (6720,6800,'导出',null,1,'/LayingOccupationStatistics/Export/excel');



-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--系统
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (8000,null,'系统',null,1,'/sidebar_xitong');
------------基础类型------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7100,8000,'基础类型',null,1,'');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7010,7100,'电压等级',null,1,'/PowerCableLevel/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7001,7010,'查看',null,1,'/PowerCableLevel/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7002,7010,'添加编辑',null,1,'/PowerCableLevel/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7003,7010,'删除',null,1,'/PowerCableLevel/delete');

insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7050,7100,'区域信息',null,1,'');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7020,7050,'市区、县区、片区',null,1,'/Area/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7011,7020,'查看',null,1,'/Area/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7012,7020,'添加编辑',null,1,'/Area/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7013,7020,'删除',null,1,'/Area/delete');

------------单位/部门------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7200,8000,'单位部门',null,1,'/Organization/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7101,7200,'查看',null,1,'/Organization/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7102,7200,'添加编辑',null,1,'/Organization/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7103,7200,'删除',null,1,'/Organization/delete');


------------管网配置------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7300,8000,'管网配置',null,1,'');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7230,7300,'通道',null,1,'');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7204,7230,'档案附件类型',null,1,'/ArchivesFileType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7201,7204,'查看',null,1,'/ArchivesFileType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7202,7204,'添加编辑',null,1,'/ArchivesFileType/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7203,7204,'删除',null,1,'/ArchivesFileType/delete');

insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7208,7230,'资产分界',null,1,'/AssetBorderType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7205,7208,'查看',null,1,'/AssetBorderType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7206,7208,'添加编辑',null,1,'/AssetBorderType/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7207,7208,'删除',null,1,'/AssetBorderType/delete');

insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7212,7230,'通道类型',null,1,'/TunnelStructureType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7209,7212,'查看',null,1,'/TunnelStructureType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7210,7212,'添加编辑',null,1,'/TunnelStructureType/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7211,7212,'删除',null,1,'/TunnelStructureType/delete');

insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7216,7230,'通道材质',null,1,'/TunnelStuffType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7213,7216,'查看',null,1,'/TunnelStuffType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7214,7216,'添加编辑',null,1,'/TunnelStuffType/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7215,7216,'删除',null,1,'/TunnelStuffType/delete');

insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7220,7230,'支架材质',null,1,'/TrestleStuffType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7217,7220,'查看',null,1,'/TrestleStuffType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7218,7220,'添加编辑',null,1,'/TrestleStuffType/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7219,7220,'删除',null,1,'/TrestleStuffType/delete');

insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7225,7230,'排管规格',null,1,'/RowTubeType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7221,7225,'查看',null,1,'/RowTubeType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7222,7225,'添加编辑',null,1,'/RowTubeType/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7223,7225,'删除',null,1,'/RowTubeType/delete');

insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7229,7230,'通道样式配置',null,1,'/PowerLevelTunnelColor/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7226,7229,'查看',null,1,'/PowerLevelTunnelColor/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7227,7229,'添加编辑',null,1,'/PowerLevelTunnelColor/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7228,7229,'删除',null,1,'/PowerLevelTunnelColor/delete');



insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7250,7300,'工井',null,1,'');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7235,7250,'工井类型',null,1,'/ManholeKindType2/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7231,7235,'查看',null,1,'/ManholeKindType2/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7232,7235,'添加编辑',null,1,'/ManholeKindType2/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7233,7235,'删除',null,1,'/ManholeKindType2/delete');

insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7240,7250,'设施形状',null,1,'/ManholeShapeType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7236,7240,'查看',null,1,'/ManholeShapeType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7237,7240,'添加编辑',null,1,'/ManholeShapeType/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7238,7240,'删除',null,1,'/ManholeShapeType/delete');

insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7245,7250,'设施材质',null,1,'/CoverStuffType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7241,7245,'查看',null,1,'/CoverStuffType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7242,7245,'添加编辑',null,1,'/CoverStuffType/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7243,7245,'删除',null,1,'/CoverStuffType/delete');


insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7270,7300,'防火墙',null,1,'');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7255,7270,'防火墙材质',null,1,'/FireWallStuffType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7251,7255,'查看',null,1,'/FireWallStuffType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7252,7255,'添加编辑',null,1,'/FireWallStuffType/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7253,7255,'删除',null,1,'/FireWallStuffType/delete');

insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7260,7270,'防火门材质',null,1,'/DoorStuffType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7256,7260,'查看',null,1,'/DoorStuffType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7257,7260,'添加编辑',null,1,'/DoorStuffType/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7258,7260,'删除',null,1,'/DoorStuffType/delete');

insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7265,7270,'防火墙类型',null,1,'/FireWallType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7261,7265,'查看',null,1,'/FireWallType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7262,7265,'添加编辑',null,1,'/FireWallType/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7263,7265,'删除',null,1,'/FireWallType/delete');


insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7280,7300,'灭火装置',null,1,'');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7275,7280,'灭火装置类型',null,1,'/ExtinguisherType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7271,7275,'查看',null,1,'/ExtinguisherType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7272,7275,'添加编辑',null,1,'/ExtinguisherType/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7273,7275,'删除',null,1,'/ExtinguisherType/delete');


------------线路配置------------------------------------------------------------------------------------------------------------------------------------------------------------------

insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7400,8000,'线路配置',null,1,'');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7310,7400,'档案附件类型',null,1,'/PathArchivesFileType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7301,7310,'查看',null,1,'/PathArchivesFileType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7302,7310,'添加编辑',null,1,'/PathArchivesFileType/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7303,7310,'删除',null,1,'/PathArchivesFileType/delete');

insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7320,7400,'工程性质',null,1,'/ProjectType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7311,7320,'查看',null,1,'/ProjectType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7312,7320,'添加编辑',null,1,'/ProjectType/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7313,7320,'删除',null,1,'/ProjectType/delete');

insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7330,7400,'接地方式',null,1,'/SafeEarthType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7321,7330,'查看',null,1,'/SafeEarthType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7322,7330,'添加编辑',null,1,'/SafeEarthType/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7323,7330,'删除',null,1,'/SafeEarthType/delete');

insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7340,7400,'敷设方式',null,1,'/InstallType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7331,7340,'查看',null,1,'/InstallType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7332,7340,'添加编辑',null,1,'/InstallType/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7333,7340,'删除',null,1,'/InstallType/delete');

insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7350,7400,'设备规格',null,1,'/AttachmentModelType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7341,7350,'查看',null,1,'/AttachmentModelType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7342,7350,'添加编辑',null,1,'/AttachmentModelType/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7343,7350,'删除',null,1,'/AttachmentModelType/delete');

insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7360,7400,'防爆盒类型',null,1,'/SafeBoxType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7351,7360,'查看',null,1,'/SafeBoxType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7352,7360,'添加编辑',null,1,'/SafeBoxType/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7353,7360,'删除',null,1,'/SafeBoxType/delete');

insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7370,7400,'故障指示器',null,1,'/FaultIndicatorType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7361,7370,'查看',null,1,'/FaultIndicatorType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7362,7370,'添加编辑',null,1,'/FaultIndicatorType/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7363,7370,'删除',null,1,'/FaultIndicatorType/delete');


------------终端设施------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7500,8000,'终端设施',null,1,'');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7410,7500,'终端实施类型',null,1,'/ManholeKindType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7401,7410,'查看',null,1,'/ManholeKindType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7402,7410,'添加编辑',null,1,'/ManholeKindType/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7403,7410,'删除',null,1,'/ManholeKindType/delete');

insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7420,7500,'分接箱规格类型',null,1,'/BranchBoxModel/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7411,7420,'查看',null,1,'/BranchBoxModel/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7412,7420,'添加编辑',null,1,'/BranchBoxModel/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7413,7420,'删除',null,1,'/BranchBoxModel/delete');


------------缺陷管理------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7600,8000,'缺陷管理',null,1,'');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7510,7600,'缺陷类型',null,1,'/FlawType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7501,7510,'查看',null,1,'/FlawType/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7502,7510,'添加编辑',null,1,'/FlawType/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7503,7510,'删除',null,1,'/FlawType/delete');

insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7530,7600,'缺陷审核类型',null,1,'/FlawAduitStatus/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7521,7530,'查看',null,1,'/FlawAduitStatus/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7522,7530,'添加编辑',null,1,'/FlawAduitStatus/FlawType/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7523,7530,'删除',null,1,'/FlawAduitStatus/delete');


--------------------------------------------------相关厂家:监理单位，施工单位，生产厂家，电缆厂家，电缆敷设厂家-------------------------------------------------------------
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7700,8000,'相关厂家',null,1,'');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7610,7700,'监理单位，施工单位，生产厂家，电缆厂家，电缆敷设厂家',null,1,'/Company/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7601,7610,'查看',null,1,'/Company/index');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7602,7610,'添加编辑',null,1,'/Company/add');
insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (7603,7610,'删除',null,1,'/Company/delete');
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4510,5000,'查看',null,1,'');
--insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4520,3600,'添加编辑',null,1,'');
--insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4530,3600,'删除',null,1,'');
--insert into AccessFunction (ApplicationModuleID,ParentModuleID,ApplicationModuleName,Context,IsDisplay,FunctionPath) values (4540,3600,'导出',null,1,'');
------------------------------------------------------------------------------------------------------------------------------------------------------------------------