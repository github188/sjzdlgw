	alter table AccessFunction
   drop constraint FK_ACCESSFU_R_113_ACCESSFU;

	alter table AccessList
   drop constraint FK_ACCESSLI_RELATIONS_EMPLOYEE;

	alter table Area
   drop constraint FK_AREA_RELATIONS_AREATYPE;

	alter table AttachmentModelType
   drop constraint FK_ATTACHME_R_118_PATHTYPE;

	alter table AttachmentModelType
   drop constraint FK_ATTACHME_R_78_CABLEATT;

	alter table AttachmentOfCable
   drop constraint FK_ATTACHME_R_120_PATHCABL;

	alter table AttachmentOfCable
   drop constraint FK_ATTACHME_R_CABLEATT;

	alter table AttachmentOfCable
   drop constraint FK_ATTACHME_RE_CABLEATT;

	alter table AttachmentOfCable
   drop constraint FK_ATTACHME_RELATIONS_CABLEATT;

	alter table BaseFacility
   drop constraint FK_BASEFACI_RELATIONS_AREA;

	alter table BranchBox
   drop constraint FK_BRANCHBO_R_142_POWERCAB;

	alter table BranchBox
   drop constraint FK_BRANCHBO_RELATIONS_MANHOLE;

	alter table BranchBox
   drop constraint FK_BRANCHBO_RELATIONS_BRANCHBO;

	alter table BusinessProcessInstantiate
   drop constraint FK_BUSINESS_RELATIONS_BUSINESS;

	alter table BusinessProcessTemplate
   drop constraint FK_BUSINESS_RELATIONS_ROLES;

	alter table CableAttachment
   drop constraint FK_CABLEATT_R_110_PATHTYPE;

	alter table CableAttachment
   drop constraint FK_CABLEATT_R_180_CABLEDEV;

	alter table CableAttachment
   drop constraint FK_CABLEATT_R_91_ATTACHME;

	alter table CableAttachment
   drop constraint FK_CABLEATT_RE_CABLEDEV;

	alter table CableAttachment
   drop constraint FK_CABLEATT_RELATIONS_FAULTIND;

	alter table CableAttachment
   drop constraint FK_CABLEATT_RELATIONS_SAFEBOXT;

	alter table CableAttachment
   drop constraint FK_CABLEATT_RELATIONS_ATTACHME;

	alter table CableAttachment
   drop constraint FK_CABLEATT_RELATIONS_CABLEDEV;

	alter table CableAttachment
   drop constraint FK_CABLEATT_RELATIONS_CABLEATT;

	alter table CableAttachment
   drop constraint FK_CABLEATT_RELATIONS_COMPANY;

	alter table CableDeviceLedger
   drop constraint FK_CABLEDEV_R_135_POWERCAB;

	alter table CableDeviceLedger
   drop constraint FK_CABLEDEV_R_136_PROJECTT;

	alter table CableDeviceLedger
   drop constraint FK_CABLEDEV_RELATIONS_PATHTYPE;

	alter table CableDeviceLedger
   drop constraint FK_CABLEDEV_RELATIONS_ACCEPTST;

	alter table CableDeviceLedger
   drop constraint FK_CABLEDEV_RELATIONS_EMPLOYEE;

	alter table CableDeviceStyle
   drop constraint FK_CABLEDEV__CABLEATT;

	alter table CableDeviceStyle
   drop constraint FK_CABLEDEV_R_PATHTYPE;

	alter table CableDeviceType
   drop constraint FK_CABLEDEV_RELATIONS_CABLEATT;

	alter table CableDeviceType
   drop constraint FK_CABLEDEV_PATHTYPE;

	alter table CableOfSection
   drop constraint FK_CABLEOFS_R_99_ROWTUBE;

	alter table CableOfSection
   drop constraint FK_CABLEOFS_RELATIONS_PATHCABL;

	alter table CableOfSection
   drop constraint FK_CABLEOFS_RELATIONS_TRESTLEL;

	alter table CableOfSection
   drop constraint FK_CABLEOFS_RELATIONS_TUNNELSE;

	alter table CablePath
   drop constraint FK_CABLEPAT_RELATIONS_ORGANIZA;

	alter table CablePath
   drop constraint FK_CABLEPAT_RELATIONS_AREA;

	alter table CablePath
   drop constraint FK_CABLEPAT_RELATIONS_BASEFACI;

	alter table CablePath
   drop constraint FK_CABLEPAT_RELATIONS_PATHTYPE;

	alter table CablePath
   drop constraint FK_CABLEPAT_RELATIONS_POWERCAB;

	alter table CableSectionArrt
   drop constraint FK_CABLESEC_R_119_CABLEATT;

	alter table Company
   drop constraint FK_COMPANY_COMPANYT_COMPANYT;

	alter table CoverStuffType
   drop constraint FK_COVERSTU_RELATIONS_MANHOLEC;

	alter table Employee
   drop constraint FK_EMPLOYEE_RELATIONS_ORGANIZA;

	alter table Extinguisher
   drop constraint FK_EXTINGUI_R_COMPANY;

	alter table Extinguisher
   drop constraint FK_EXTINGUI_RELATIONS_COMPANY;

	alter table Extinguisher
   drop constraint FK_EXTINGUI_RELATIONS_EMPLOYEE;

	alter table Extinguisher
   drop constraint FK_EXTINGUI_RELATIONS_EXTINGUI;

	alter table Extinguisher
   drop constraint FK_EXTINGUI_RELATIONS_POWERTUN;

	alter table FileAttachment
   drop constraint FK_FILEATTA_R_114_BASEFACI;

	alter table FileAttachment
   drop constraint FK_FILEATTA_R_115_EMPLOYEE;

	alter table FireWall
   drop constraint FK_FIREWALL_RELATIONS_EMPLOYEE;

	alter table FireWall
   drop constraint FK_FIREWALL_RE_COMPANY;

	alter table FireWall
   drop constraint FK_FIREWALL_RELATIONS_COMPANY;

	alter table FireWall
   drop constraint FK_FIREWALL_RELATIONS_POWERTUN;

	alter table FireWall
   drop constraint FK_FIREWALL_RE_FIREWALL;

	alter table FireWall
   drop constraint FK_FIREWALLCOMPANY;

	alter table FireWall
   drop constraint FK_FIREWALL_RELATIONS_DOORSTUF;

	alter table FireWall
   drop constraint FK_FIREWALL_RELATIONS_FIREWALL;

	alter table FlawAdjunctFile
   drop constraint FK_FLAWADJU_RELATIONS_INSPECTO;

	alter table FlawAdjunctFile
   drop constraint FK_FLAWADJU_RELATIONS_EMPLOYEE;

	alter table FlawAduitRecord
   drop constraint FK_FLAWADUI_R_162_INSPECTO;

	alter table FlawAduitRecord
   drop constraint FK_FLAWADUI_RELATIONS_FLAWADUI;

	alter table FlawAduitRecord
   drop constraint FK_FLAWADUI_RELATIONS_EMPLOYEE;

	alter table FlawProcFile
   drop constraint FK_FLAWPROC_R_163_FLAWPROC;

	alter table FlawProcFile
   drop constraint FK_FLAWPROC_R_EMPLOYEE;

	alter table FlawProcTask
   drop constraint FK_FLAWPROC_R_168_TASKSTAT;

	alter table FlawProcTask
   drop constraint FK_FLAWPROC_RE_EMPLOYEE;

	alter table FlawProcTask
   drop constraint FK_FLAWPROC_EMPLOYEE;

	alter table FlawProcTaskObj
   drop constraint FK_FLAWPROC_R_166_INSPECTO;

	alter table FlawProcTaskObj
   drop constraint FK_FLAWPROC_RELATIONS_FLAWPROC;

	alter table FlawProcTaskObj
   drop constraint FK_FLAWPROC_RELAT_FLAWPROC;

	alter table InspectObjFlaw
   drop constraint FK_INSPECTO_R_155_INSPECTT;

	alter table InspectObjFlaw
   drop constraint FK_INSPECTO_RELATIONS_FLAWSOUR;

	alter table InspectObjFlaw
   drop constraint FK_INSPECTO_RELATIONS_FLAWTYPE;

	alter table InspectObjFlaw
   drop constraint FK_INSPECTO_RELATIONS_FLAWLEVE;

	alter table InspectObjFlaw
   drop constraint FK_INSPECTO_RELATIONS_FLAWADUI;

	alter table InspectTask
   drop constraint FK_INSPECTT_RELATIONS_TASKSTAT;

	alter table InspectTask
   drop constraint FK_INSPECTT_RELATIONS_TEAMTYPE;

	alter table InspectTask
   drop constraint FK_INSPECTT_RE_EMPLOYEE;

	alter table InspectTask
   drop constraint FK_INSPECTT_RELATIONS_EMPLOYEE;

	alter table Ledger
   drop constraint FK_LEDGER_R_116_ASSETBOR;

	alter table Ledger
   drop constraint FK_LEDGER_RELATIONS_ACCEPTST;

	alter table Ledger
   drop constraint FK_LEDGER_RELATIONS_COMPANY;

	alter table Ledger
   drop constraint FK_LEDGER_COMPANY;

	alter table Ledger
   drop constraint FK_LEDGER_RELATIONS_BASEFACI;

	alter table Ledger
   drop constraint FK_LEDGER_RELATIONS_EMPLOYEE;

	alter table LoopEarthBox
   drop constraint FK_LOOPEART_RELATIONS_CABLEATT;

	alter table LoopEarthBox
   drop constraint FK_LOOPEART_RELATIONS_POWERLOO;

	alter table Manhole
   drop constraint FK_MANHOLE_RELATIONS_AREA;

	alter table Manhole
   drop constraint FK_MANHOLE_RELATIONS_BASEFACI;

	alter table Manhole
   drop constraint FK_HOLE_COMPANY;

	alter table Manhole
   drop constraint FK_MANHOLE_RELATIONS_EMPLOYEE;

	alter table Manhole
   drop constraint FK_MANHOLE_RELATIONS_COMPANY;

	alter table Manhole
   drop constraint FK_HOLE_R_MANHOLES;

	alter table Manhole
   drop constraint FK_MANHOLE_RELATIONS_MANHOLEK;

	alter table Manhole
   drop constraint FK_MANHOLE_RELATIONS_POWERTUN;

	alter table Manhole
   drop constraint FK_MANHOLE_COMPANY;

	alter table Manhole
   drop constraint FK_MANHOLE_RELATIONS_MANHOLEC;

	alter table Manhole
   drop constraint FK_MANHOLE_RELATIONS_COVERSTU;

	alter table Manhole
   drop constraint FK_MANHOLE_RELATIONS_COVERSHA;

	alter table Manhole
   drop constraint FK_MANHOLE_R_MANHOLES;

	alter table ManholeKindType
   drop constraint FK_MANHOLEK_RELATIONS_MANHOLET;

	alter table ManholeOfSection
   drop constraint FK_MANHOLEO_RELATIONS_TUNNELSE;

	alter table ManholeOfSection
   drop constraint FK_MANHOLEO_RELATIONS_MANHOLE;

	alter table ManholeOfTunnel
   drop constraint FK_MANHOLEO_RELATIONS_POWERTUN;

	alter table ManholeOfTunnel
   drop constraint FK_MANHOLEO_RE_MANHOLE;

	alter table OperationLog
   drop constraint FK_OPERATIO_R_112_EMPLOYEE;

	alter table OperationLog
   drop constraint FK_OPERATIO_RELATIONS_OPERATIO;

	alter table Organization
   drop constraint FK_ORGANIZA_R_21_ORGANIZA;

	alter table Organization
   drop constraint FK_ORGANIZA_RELATIONS_TEAMTYPE;

	alter table PathAduitRecord
   drop constraint FK_PATHADUI_RELATIONS_CABLEDEV;

	alter table PathAduitRecord
   drop constraint FK_PATHADUI_RELATIONS_TASKSTAT;

	alter table PathAduitRecord
   drop constraint FK_PATHADUI_R_EMPLOYEE;

	alter table PathAduitRecord
   drop constraint FK_PATHADUI_RELATIONS_EMPLOYEE;

	alter table PathArchivesFile
   drop constraint FK_PATHARCH_RELATIONS_CABLEDEV;

	alter table PathArchivesFile
   drop constraint FK_PATHARCH_RELATIONS_PATHARCH;

	alter table PathArchivesFile
   drop constraint FK_PATHARCH_RELATIONS_PATHADUI;

	alter table PathArchivesFile
   drop constraint FK_PATHARCH_RELATIONS_EMPLOYEE;

	alter table PathCable
   drop constraint FK_PATHCABL_RELATIONS_POWERLOO;

	alter table PathCable
   drop constraint FK_PATHCABL_RELATIONS_ATTACHME;

	alter table PathCable
   drop constraint FK_PATHCABL_RELATIONS_PHASETYP;

	alter table PathSection
   drop constraint FK_PATHSECT_R_126_SAFEEART;

	alter table PathSection
   drop constraint FK_PATHSECT_MANHOLE;

	alter table PathSection
   drop constraint FK_PATHSECT_RELATIONS_MANHOLE;

	alter table PathSection
   drop constraint FK_PATHSECT_RELATIONS_CABLEPAT;

	alter table PathSection
   drop constraint FK_PATHSECT_RELATIONS_INSTALLT;

	alter table PathSection
   drop constraint FK_PATHSECT_RELATIONS_BASEFACI;

	alter table PathSection
   drop constraint FK_PATHSECT_RELATIONS_PATHSECT;

	alter table PathSectionRunStatusRecord
   drop constraint FK_PATHSECT_RELATIONS_POWERLOO;

	alter table PowerLevelTunnelColor
   drop constraint FK_POWERLEV_R_152_TUNNELST;

	alter table PowerLevelTunnelColor
   drop constraint FK_POWERLEV_R_153_POWERCAB;

	alter table PowerLoop
   drop constraint FK_POWERLOO_RELATIONS_PATHSECT;

	alter table PowerLoop
   drop constraint FK_POWERLOO_RELATIONS_ATTACHME;

	alter table PowerTunnel
   drop constraint FK_POWERTUN_R_73_ORGANIZA;

	alter table PowerTunnel
   drop constraint FK_POWERTUN_RELATIONS_POWERCAB;

	alter table PowerTunnel
   drop constraint FK_POWERTUN_R_COMPANY;

	alter table PowerTunnel
   drop constraint FK_POWERTUN_RELATIONS_COMPANY;

	alter table PowerTunnel
   drop constraint FK_POWERTUN_R_TUNNELST;

	alter table PowerTunnel
   drop constraint FK_POWERTUN_RELATIONS_TUNNELSH;

	alter table PowerTunnel
   drop constraint FK_POWERTUN_RELATIONS_EMPLOYEE;

	alter table PowerTunnel
   drop constraint FK_POWERTUN_RELATIONS_TUNNELST;

	alter table PowerTunnel
   drop constraint FK_POWERTUN_RELATIONS_AREA;

	alter table PowerTunnel
   drop constraint FK_POWERTUN_RELATIONS_TRESTLET;

	alter table PowerTunnel
   drop constraint FK_POWERTUN_RELATIONS_LEDGER;

	alter table RoleFunctions
   drop constraint FK_ROLEFUNC_R_108_ROLES;

	alter table RoleFunctions
   drop constraint FK_ROLEFUNC_RELATIONS_ACCESSFU;

	alter table RowTube
   drop constraint FK_ROWTUBE_RELATIONS_ROWTUBET;

	alter table RowTube
   drop constraint FK_ROWTUBE_RELATIONS_TRESTLEL;

	alter table RunRecord
   drop constraint FK_RUNRECOR_RELATIONS_CABLEATT;

	alter table RunRecord
   drop constraint FK_RUNRECOR_RELATIONS_ATTACHME;

	alter table TerminalFile
   drop constraint FK_TERMINAL_RELATIONS_MANHOLE;

	alter table TerminalFile
   drop constraint FK_TERMINAL_RELATIONS_EMPLOYEE;

	alter table TrestleLayer
   drop constraint FK_TRESTLEL_R_117_TRESTLES;

	alter table TrestleLayer
   drop constraint FK_TRESTLEL_RELATIONS_TRESTLED;

	alter table TrestleLayer
   drop constraint FK_TRESTLEL_RELATIONS_POWERCAB;

	alter table TrestleLayer
   drop constraint FK_TRESTLEL_RELATIONS_TUNNELSE;

	alter table TunnelAduitRecord
   drop constraint FK_TUNNELAD_RELATIONS_TASKSTAT;

	alter table TunnelAduitRecord
   drop constraint FK_TUNNELAD_EMPLOYEE;

	alter table TunnelAduitRecord
   drop constraint FK_TUNNELAD_RELATIONS_EMPLOYEE;

	alter table TunnelAduitRecord
   drop constraint FK_TUNNELAD_RELATIONS_LEDGER;

	alter table TunnelArchivesFile
   drop constraint FK_TUNNELAR_RELATIONS_TUNNELAD;

	alter table TunnelArchivesFile
   drop constraint FK_TUNNELAR_RELATIONS_EMPLOYEE;

	alter table TunnelArchivesFile
   drop constraint FK_TUNNELAR_RELATIONS_LEDGER;

	alter table TunnelArchivesFile
   drop constraint FK_TUNNELAR_RELATIONS_ARCHIVES;

	alter table TunnelSection
   drop constraint FK_TUNNELSE_R_102_TUNNLETO;

	alter table TunnelSection
   drop constraint FK_TUNNELSE_RELATIONS_POWERTUN;

	alter table TunnelStuffType
   drop constraint FK_TUNNELST_RELATIONS_TUNNELST;

	alter table UserRoles
   drop constraint FK_USERROLE_RELATIONS_ROLES;

	alter table UserRoles
   drop constraint FK_USERROLE_RELATIONS_EMPLOYEE;

drop table AcceptStatusType cascade constraints;

drop index R_113_FK;

drop table AccessFunction cascade constraints;

drop index Relationship_173_FK;

drop table AccessList cascade constraints;

drop table ArchivesFileType cascade constraints;

drop index Relationship_108_FK;

drop table Area cascade constraints;

drop table AreaType cascade constraints;

drop table AssetBorderType cascade constraints;

drop index R_118_FK;

drop index R_78_FK;

drop table AttachmentModelType cascade constraints;

drop index Relationship_153_FK;

drop index Relationship_152_FK;

drop index Relationship_121_FK;

drop index R_120_FK;

drop table AttachmentOfCable cascade constraints;

drop table AttachmentStatusType cascade constraints;

drop table AuthorizeTable cascade constraints;

drop index Relationship_59_FK;

drop table BaseFacility cascade constraints;

drop index R_142_FK;

drop index Relationship_124_FK;

drop index Relationship_89_FK;

drop table BranchBox cascade constraints;

drop table BranchBoxModel cascade constraints;

drop index Relationship_207_FK;

drop table BusinessProcessInstantiate cascade constraints;

drop index Relationship_182_FK;

drop table BusinessProcessTemplate cascade constraints;

drop index R_180_FK;

drop index Relationship_177_FK;

drop index Relationship_139_FK;

drop index Relationship_137_FK;

drop index Relationship_131_FK;

drop index Relationship_130_FK;

drop index R_110_FK;

drop index Relationship_99_FK;

drop index R_91_FK;

drop index Relationship_88_FK;

drop table CableAttachment cascade constraints;

drop table CableAttachmentType cascade constraints;

drop index Relationship_165_FK;

drop index Relationship_147_FK;

drop index R_136_FK;

drop index R_135_FK;

drop index Relationship_133_FK;

drop table CableDeviceLedger cascade constraints;

drop index Relationship_176_FK;

drop index Relationship_175_FK;

drop table CableDeviceStyle cascade constraints;

drop index Relationship_179_FK;

drop index Relationship_178_FK;

drop table CableDeviceType cascade constraints;

drop index R_99_FK;

drop index Relationship_91_FK;

drop index Relationship_101_FK;

drop index Relationship_100_FK;

drop table CableOfSection cascade constraints;

drop index Relationship_172_FK;

drop index Relationship_109_FK;

drop index Relationship_103_FK;

drop index Relationship_94_FK;

drop index Relationship_86_FK;

drop table CablePath cascade constraints;

drop index R_119_FK;

drop table CableSectionArrt cascade constraints;

drop index CompanyT_FK;

drop table Company cascade constraints;

drop table CompanyType cascade constraints;

drop table CoverShapeType cascade constraints;

drop index Relationship_80_FK;

drop table CoverStuffType cascade constraints;

drop table DoorStuffType cascade constraints;

drop index Relationship_71_FK;

drop table Employee cascade constraints;

drop index Relationship_167_FK;

drop index Relationship_12_FK;

drop index Relationship_11_FK;

drop index Relationship_61_FK;

drop index Relationship_60_FK;

drop table Extinguisher cascade constraints;

drop table ExtinguisherType cascade constraints;

drop table FaultIndicatorType cascade constraints;

drop index R_115_FK;

drop index R_114_FK;

drop table FileAttachment cascade constraints;

drop index Relationship_184_FK;

drop index Relationship_22_FK;

drop index Relationship_21_FK;

drop index Relationship_74_FK;

drop index Relationship_68_FK;

drop index Relationship_67_FK;

drop index Relationship_49_FK;

drop index Relationship_37_FK;

drop table FireWall cascade constraints;

drop table FireWallStuffType cascade constraints;

drop table FireWallType cascade constraints;

drop index Relationship_180_FK;

drop index Relationship_158_FK;

drop table FlawAdjunctFile cascade constraints;

drop index Relationship_164_FK;

drop index Relationship_183_FK;

drop index R_162_FK;

drop table FlawAduitRecord cascade constraints;

drop table FlawAduitStatus cascade constraints;

drop table FlawAduitWay cascade constraints;

drop table FlawLevelType cascade constraints;

drop table FlawProcAcceptType cascade constraints;

drop index Relationship_174_FK;

drop index R_163_FK;

drop table FlawProcFile cascade constraints;

drop index R_168_FK;

drop index Relationship_188_FK;

drop index Relationship_187_FK;

drop table FlawProcTask cascade constraints;

drop index Relationship_159_FK;

drop index R_166_FK;

drop index Relationship_185_FK;

drop table FlawProcTaskObj cascade constraints;

drop table FlawSourceType cascade constraints;

drop table FlawType cascade constraints;

drop index R_155_FK;

drop index Relationship_161_FK;

drop index Relationship_160_FK;

drop index Relationship_156_FK;

drop index Relationship_157_FK;

drop table InspectObjFlaw cascade constraints;

drop index Relationship_154_FK;

drop index Relationship_150_FK;

drop index Relationship_169_FK;

drop index Relationship_168_FK;

drop table InspectTask cascade constraints;

drop table InstallType cascade constraints;

drop index Relationship_122_FK;

drop index Relationship_136_FK;

drop index R_116_FK;

drop index Relationship_73_FK;

drop index Relationship_56_FK;

drop index Relationship_55_FK;

drop table Ledger cascade constraints;

drop index Relationship_129_FK;

drop index Relationship_112_FK;

drop table LoopEarthBox cascade constraints;

drop index Relationship_181_FK;

drop index Relationship_20_FK;

drop index Relationship_15_FK;

drop index Relationship_120_FK;

drop index Relationship_127_FK;

drop index Relationship_87_FK;

drop index Relationship_82_FK;

drop index Relationship_81_FK;

drop index Relationship_79_FK;

drop index Relationship_78_FK;

drop index Relationship_69_FK;

drop index Relationship_48_FK;

drop index Relationship_28_FK;

drop table Manhole cascade constraints;

drop table ManholeCoverType cascade constraints;

drop index Relationship_75_FK;

drop table ManholeKindType cascade constraints;

drop index Relationship_84_FK;

drop index Relationship_83_FK;

drop table ManholeOfSection cascade constraints;

drop index Relationship_30_FK;

drop index Relationship_29_FK;

drop table ManholeOfTunnel cascade constraints;

drop table ManholeShapeType cascade constraints;

drop table ManholeStuffType cascade constraints;

drop table ManholeType cascade constraints;

drop table MaxPrimaryKey cascade constraints;

drop index R_112_FK;

drop index Relationship_106_FK;

drop table OperationLog cascade constraints;

drop table OperationType cascade constraints;

drop index Relationship_64_FK;

drop index R_21_FK;

drop table Organization cascade constraints;

drop index Relationship_166_FK;

drop index Relationship_151_FK;

drop index Relationship_162_FK;

drop index Relationship_148_FK;

drop table PathAduitRecord cascade constraints;

drop index Relationship_149_FK;

drop index Relationship_163_FK;

drop index Relationship_146_FK;

drop index Relationship_145_FK;

drop table PathArchivesFile cascade constraints;

drop table PathArchivesFileType cascade constraints;

drop index Relationship_144_FK;

drop index Relationship_116_FK;

drop index Relationship_96_FK;

drop table PathCable cascade constraints;

drop index Relationship_205_FK;

drop index Relationship_171_FK;

drop index Relationship_134_FK;

drop index R_126_FK;

drop index Relationship_113_FK;

drop index Relationship_102_FK;

drop index Relationship_125_FK;

drop table PathSection cascade constraints;

drop index Relationship_192_FK;

drop table PathSectionRunStatusRecord cascade constraints;

drop table PathType cascade constraints;

drop table PhaseType cascade constraints;

drop table PowerCableLevel cascade constraints;

drop index R_153_FK;

drop index R_152_FK;

drop table PowerLevelTunnelColor cascade constraints;

drop index Relationship_190_FK;

drop index Relationship_104_FK;

drop table PowerLoop cascade constraints;

drop index Relationship_170_FK;

drop index Relationship_14_FK;

drop index Relationship_13_FK;

drop index Relationship_128_FK;

drop index R_73_FK;

drop index Relationship_70_FK;

drop index Relationship_26_FK;

drop index Relationship_19_FK;

drop index Relationship_18_FK;

drop index Relationship_17_FK;

drop index Relationship_16_FK;

drop table PowerTunnel cascade constraints;

drop table ProjectType cascade constraints;

drop index Relationship_72_FK;

drop index R_108_FK;

drop table RoleFunctions cascade constraints;

drop table Roles cascade constraints;

drop index Relationship_98_FK;

drop index Relationship_76_FK;

drop table RowTube cascade constraints;

drop table RowTubeType cascade constraints;

drop index Relationship_140_FK;

drop index Relationship_138_FK;

drop table RunRecord cascade constraints;

drop table SafeBoxType cascade constraints;

drop table SafeEarthType cascade constraints;

drop table TaskStatusType cascade constraints;

drop table TeamType cascade constraints;

drop index Relationship_143_FK;

drop index Relationship_141_FK;

drop table TerminalFile cascade constraints;

drop table TrestleDirectionType cascade constraints;

drop index R_117_FK;

drop index Relationship_77_FK;

drop index Relationship_42_FK;

drop index Relationship_25_FK;

drop table TrestleLayer cascade constraints;

drop table TrestleStuffType cascade constraints;

drop table TrestleTypeInfo cascade constraints;

drop index Relationship_155_FK;

drop index Relationship_132_FK;

drop index Relationship_135_FK;

drop index Relationship_57_FK;

drop table TunnelAduitRecord cascade constraints;

drop index Relationship_142_FK;

drop index Relationship_123_FK;

drop index Relationship_54_FK;

drop index Relationship_53_FK;

drop table TunnelArchivesFile cascade constraints;

drop index R_102_FK;

drop index Relationship_66_FK;

drop table TunnelSection cascade constraints;

drop table TunnelShapeType cascade constraints;

drop table TunnelStructureType cascade constraints;

drop index Relationship_63_FK;

drop table TunnelStuffType cascade constraints;

drop table TunnleTowardType cascade constraints;

drop index Relationship_204_FK;

drop index Relationship_193_FK;

drop table UserRoles cascade constraints;

create table AcceptStatusType  (
   AcceptStatusTypeID   INTEGER                         not null,
   AcceptStatusTypeName VARCHAR2(32)                    not null,
   ShowColor            VARCHAR2(8),
   constraint PK_ACCEPTSTATUSTYPE primary key (AcceptStatusTypeID)
);

comment on table AcceptStatusType is
'草稿状态
普通待验状态/加急待验状态
验收中
审核状态
验收通过
验收通过资料不全';

comment on column AcceptStatusType.AcceptStatusTypeID is
'验收状态类型ID';

comment on column AcceptStatusType.AcceptStatusTypeName is
'验收状态类型名称';

comment on column AcceptStatusType.ShowColor is
'显示颜色';

create table AccessFunction  (
   ApplicationModuleID  INTEGER                         not null,
   ParentModuleID       INTEGER,
   ApplicationModuleName VARCHAR2(64),
   Context              VARCHAR2(64),
   IsDisplay            SMALLINT,
   FunctionPath         VARCHAR2(255),
   constraint PK_ACCESSFUNCTION primary key (ApplicationModuleID)
);

comment on table AccessFunction is
'功能权限';

comment on column AccessFunction.ApplicationModuleID is
'功能ID';

comment on column AccessFunction.ParentModuleID is
'功能_父模块ID';

comment on column AccessFunction.ApplicationModuleName is
'功能名称';

comment on column AccessFunction.Context is
'描述信息';

comment on column AccessFunction.IsDisplay is
'是否显示';

comment on column AccessFunction.FunctionPath is
'功能对象地址';

create index R_113_FK on AccessFunction (
   ParentModuleID ASC
);

create table AccessList  (
   AccessNum            INTEGER                         not null,
   EmployeeID           VARCHAR2(16)                    not null,
   IP                   VARCHAR2(16)                    not null,
   MAC                  VARCHAR2(32),
   AppVer               VARCHAR2(32),
   IsLogin              SMALLINT,
   RecordTime           DATE                            not null,
   Memo                 VARCHAR2(64),
   constraint PK_ACCESSLIST primary key (AccessNum)
);

comment on table AccessList is
'访问记录表';

comment on column AccessList.AccessNum is
'记录编号';

comment on column AccessList.EmployeeID is
'用户ID';

comment on column AccessList.IP is
'IP';

comment on column AccessList.MAC is
'MAC';

comment on column AccessList.AppVer is
'程序版本';

comment on column AccessList.IsLogin is
'登录/登出标志';

comment on column AccessList.RecordTime is
'记录时间';

comment on column AccessList.Memo is
'备注';

create index Relationship_173_FK on AccessList (
   EmployeeID ASC
);

create table ArchivesFileType  (
   ArchivesFileTypeID   INTEGER                         not null,
   ArchivesFileTypeName VARCHAR2(32)                    not null,
   constraint PK_ARCHIVESFILETYPE primary key (ArchivesFileTypeID)
);

comment on table ArchivesFileType is
'8大类+小图';

comment on column ArchivesFileType.ArchivesFileTypeID is
'文件分类ID';

comment on column ArchivesFileType.ArchivesFileTypeName is
'文件类型名称';

create table Area  (
   AreaNum              INTEGER                         not null,
   AreaTypeID           INTEGER,
   AreaName             VARCHAR2(32)                    not null,
   AreaDescription      VARCHAR2(255),
   constraint PK_AREA primary key (AreaNum)
);

comment on table Area is
'区域分为市区、县区
桥东、桥西
栾城、廘泉、正定';

comment on column Area.AreaNum is
'片区编号';

comment on column Area.AreaTypeID is
'区域类型ID';

comment on column Area.AreaName is
'片区名称';

comment on column Area.AreaDescription is
'片区描述';

create index Relationship_108_FK on Area (
   AreaTypeID ASC
);

create table AreaType  (
   AreaTypeID           INTEGER                         not null,
   AreaTypeName         VARCHAR2(16)                    not null,
   constraint PK_AREATYPE primary key (AreaTypeID)
);

comment on table AreaType is
'市区
县区';

comment on column AreaType.AreaTypeID is
'区域类型ID';

comment on column AreaType.AreaTypeName is
'区域类型名称';

create table AssetBorderType  (
   AssetBorderTypeID    INTEGER                         not null,
   AssetBorderTypeName  VARCHAR2(64)                    not null,
   constraint PK_ASSETBORDERTYPE primary key (AssetBorderTypeID)
);

comment on table AssetBorderType is
'资产分界
一户一表、高供高量';

comment on column AssetBorderType.AssetBorderTypeID is
'资产边界类型ID';

comment on column AssetBorderType.AssetBorderTypeName is
'资产边界名称';

create table AttachmentModelType  (
   ModelTypeNum         INTEGER                         not null,
   AttachmentTypeID     INTEGER,
   PathTypeID           INTEGER,
   ModelTypeName        VARCHAR2(64)                    not null,
   constraint PK_ATTACHMENTMODELTYPE primary key (ModelTypeNum)
);

comment on table AttachmentModelType is
'电缆设备规格型号';

comment on column AttachmentModelType.ModelTypeNum is
'规格编号';

comment on column AttachmentModelType.AttachmentTypeID is
'附件类型ID';

comment on column AttachmentModelType.PathTypeID is
'线路类型ID';

comment on column AttachmentModelType.ModelTypeName is
'规格名称';

create index R_78_FK on AttachmentModelType (
   AttachmentTypeID ASC
);

create index R_118_FK on AttachmentModelType (
   PathTypeID ASC
);

create table AttachmentOfCable  (
   RecordNum            INTEGER                         not null,
   Start_AttachmentNum  INTEGER,
   End_AttachmentNum    INTEGER,
   Cab_AttachmentNum    INTEGER                         not null,
   CableNum             INTEGER                         not null,
   Place                VARCHAR2(255),
   Distance             FLOAT,
   InstallDate          DATE,
   constraint PK_ATTACHMENTOFCABLE primary key (RecordNum)
);

comment on table AttachmentOfCable is
'本体、终端头、 中间头、接地箱';

comment on column AttachmentOfCable.RecordNum is
'电缆附件编号';

comment on column AttachmentOfCable.Start_AttachmentNum is
'首端附件';

comment on column AttachmentOfCable.End_AttachmentNum is
'末端附件';

comment on column AttachmentOfCable.Cab_AttachmentNum is
'电缆下属设备';

comment on column AttachmentOfCable.CableNum is
'电缆编号';

comment on column AttachmentOfCable.Place is
'安装位置';

comment on column AttachmentOfCable.Distance is
'线路段起点距离';

comment on column AttachmentOfCable.InstallDate is
'安装时间';

create index R_120_FK on AttachmentOfCable (
   CableNum ASC
);

create index Relationship_121_FK on AttachmentOfCable (
   Cab_AttachmentNum ASC
);

create index Relationship_152_FK on AttachmentOfCable (
   Start_AttachmentNum ASC
);

create index Relationship_153_FK on AttachmentOfCable (
   End_AttachmentNum ASC
);

create table AttachmentStatusType  (
   AttachmentStatusTypeID INTEGER                         not null,
   AttachmentStatusTypeName VARCHAR2(32)                    not null,
   constraint PK_ATTACHMENTSTATUSTYPE primary key (AttachmentStatusTypeID)
);

comment on table AttachmentStatusType is
'预投运状态
在运状态
停运状态
退运状态';

comment on column AttachmentStatusType.AttachmentStatusTypeID is
'状态ID';

comment on column AttachmentStatusType.AttachmentStatusTypeName is
'状态名称';

create table AuthorizeTable  (
   IP                   VARCHAR2(16)                    not null,
   MAC                  VARCHAR2(32)                    not null,
   LastLoginTime        DATE                            not null,
   AppVer               VARCHAR2(32)                    not null,
   IsAuthorize          SMALLINT                        not null,
   AuthorizeTime        DATE,
   AuthorizeFilePath    VARCHAR2(512),
   Memo                 VARCHAR2(64),
   constraint PK_AUTHORIZETABLE primary key (IP)
);

comment on table AuthorizeTable is
'访问授权表';

comment on column AuthorizeTable.IP is
'IP';

comment on column AuthorizeTable.MAC is
'MAC';

comment on column AuthorizeTable.LastLoginTime is
'LastLoginTime';

comment on column AuthorizeTable.AppVer is
'AppVer';

comment on column AuthorizeTable.IsAuthorize is
'IsAuthorize';

comment on column AuthorizeTable.AuthorizeTime is
'授权时间';

comment on column AuthorizeTable.AuthorizeFilePath is
'批准文件';

comment on column AuthorizeTable.Memo is
'备注';

create table BaseFacility  (
   BaseFacilityNum      INTEGER                         not null,
   AreaNum              INTEGER,
   Lon                  FLOAT,
   Lat                  FLOAT,
   Height               FLOAT,
   Angle                FLOAT,
   Heading              FLOAT,
   Range                FLOAT,
   ViewLon              FLOAT,
   ViewLat              FLOAT,
   ViewHeight           FLOAT,
   ViewAngle            FLOAT,
   ViewHeading          FLOAT,
   ViewRange            FLOAT,
   BaseFacilityName     VARCHAR2(64)                    not null,
   AssetCode            VARCHAR2(64),
   BaseFacilityDescription VARCHAR2(255),
   GraphID              INTEGER,
   constraint PK_BASEFACILITY primary key (BaseFacilityNum)
);

comment on table BaseFacility is
'变电站';

comment on column BaseFacility.BaseFacilityNum is
'设施编号';

comment on column BaseFacility.AreaNum is
'片区编号';

comment on column BaseFacility.Lon is
'经度';

comment on column BaseFacility.Lat is
'纬度';

comment on column BaseFacility.Height is
'高度';

comment on column BaseFacility.Angle is
'倾角';

comment on column BaseFacility.Heading is
'方位';

comment on column BaseFacility.Range is
'范围';

comment on column BaseFacility.ViewLon is
'视点经度';

comment on column BaseFacility.ViewLat is
'视点纬度';

comment on column BaseFacility.ViewHeight is
'视点高度';

comment on column BaseFacility.ViewAngle is
'视点倾角';

comment on column BaseFacility.ViewHeading is
'视点方位';

comment on column BaseFacility.ViewRange is
'视点范围';

comment on column BaseFacility.BaseFacilityName is
'设施名称';

comment on column BaseFacility.AssetCode is
'资产编码';

comment on column BaseFacility.BaseFacilityDescription is
'设施描述';

comment on column BaseFacility.GraphID is
'图元ID';

create index Relationship_59_FK on BaseFacility (
   AreaNum ASC
);

create table BranchBox  (
   BranchBoxNum         INTEGER                         not null,
   ModelNum             INTEGER,
   VoltageLevelID       INTEGER,
   AssetNum             INTEGER                         not null,
   IsLoadSwitch         SMALLINT,
   IsLockDevice         SMALLINT,
   IsOnMonitor          SMALLINT,
   IsDrop               SMALLINT,
   RunDate              DATE,
   Memo                 VARCHAR2(255),
   constraint PK_BRANCHBOX primary key (BranchBoxNum)
);

comment on table BranchBox is
'分接箱台帐';

comment on column BranchBox.BranchBoxNum is
'分接箱记录编号';

comment on column BranchBox.ModelNum is
'规格型号编号';

comment on column BranchBox.VoltageLevelID is
'电压等级ID';

comment on column BranchBox.AssetNum is
'资产编号';

comment on column BranchBox.IsLoadSwitch is
'有无负荷开关';

comment on column BranchBox.IsLockDevice is
'有无闭锁装置';

comment on column BranchBox.IsOnMonitor is
'是否安装在线监测';

comment on column BranchBox.IsDrop is
'是否肘形接头';

comment on column BranchBox.RunDate is
'投运日期';

comment on column BranchBox.Memo is
'备注';

create index Relationship_89_FK on BranchBox (
   ModelNum ASC
);

create index Relationship_124_FK on BranchBox (
   AssetNum ASC
);

create index R_142_FK on BranchBox (
   VoltageLevelID ASC
);

create table BranchBoxModel  (
   ModelNum             INTEGER                         not null,
   ModelName            VARCHAR2(32)                    not null,
   constraint PK_BRANCHBOXMODEL primary key (ModelNum)
);

comment on table BranchBoxModel is
'分接箱规格型号';

comment on column BranchBoxModel.ModelNum is
'规格型号编号';

comment on column BranchBoxModel.ModelName is
'规格型号';

create table BusinessProcessInstantiate  (
   InstantiateID        INTEGER                         not null,
   TemplateID           INTEGER                         not null,
   UserAID              INTEGER,
   UserBID              INTEGER,
   UserCID              INTEGER,
   UserDID              INTEGER,
   UserEID              INTEGER,
   ctime                TIMESTAMP,
   constraint PK_BUSINESSPROCESSINSTANTIATE primary key (InstantiateID)
);

comment on table BusinessProcessInstantiate is
'业务流程实例化';

comment on column BusinessProcessInstantiate.InstantiateID is
'实例化编号';

comment on column BusinessProcessInstantiate.TemplateID is
'业务流程实例化编号';

comment on column BusinessProcessInstantiate.UserAID is
'流程节点A用户ID';

comment on column BusinessProcessInstantiate.UserBID is
'流程节点B用户ID';

comment on column BusinessProcessInstantiate.UserCID is
'流程节点C用户ID';

comment on column BusinessProcessInstantiate.UserDID is
'流程节点D用户ID';

comment on column BusinessProcessInstantiate.UserEID is
'流程节点E用户ID';

comment on column BusinessProcessInstantiate.ctime is
'创建时间';

create index Relationship_207_FK on BusinessProcessInstantiate (
   TemplateID ASC
);

create table BusinessProcessTemplate  (
   TemplateID           INTEGER                         not null,
   RoleNum              INTEGER,
   BusinessName         VARCHAR2(32),
   BusinessCode         VARCHAR2(32),
   NodeA                INTEGER,
   NodeB                INTEGER,
   NodeC                INTEGER,
   NodeD                INTEGER,
   NodeE                INTEGER,
   constraint PK_BUSINESSPROCESSTEMPLATE primary key (TemplateID)
);

comment on table BusinessProcessTemplate is
'系统单次业务流程支持6级流转
A-F节点存放相应流转角色ID';

comment on column BusinessProcessTemplate.TemplateID is
'业务流程实例化编号';

comment on column BusinessProcessTemplate.RoleNum is
'角色编号';

comment on column BusinessProcessTemplate.BusinessName is
'流程名称';

comment on column BusinessProcessTemplate.BusinessCode is
'业务流程编码';

comment on column BusinessProcessTemplate.NodeA is
'流程节点A';

comment on column BusinessProcessTemplate.NodeB is
'流程节点B';

comment on column BusinessProcessTemplate.NodeC is
'流程节点C';

comment on column BusinessProcessTemplate.NodeD is
'流程节点D';

comment on column BusinessProcessTemplate.NodeE is
'流程节点E';

create index Relationship_182_FK on BusinessProcessTemplate (
   RoleNum ASC
);

create table CableAttachment  (
   AttachmentNum        INTEGER                         not null,
   CableDeviceTypeID    INTEGER,
   ModelTypeNum         INTEGER,
   CableDeviceStyleID   INTEGER,
   Num                  INTEGER,
   FaultIndicatorTypeID INTEGER,
   SafeBoxTypeID        INTEGER,
   AttachmentTypeID     INTEGER                         not null,
   CompanyNum           INTEGER,
   PathTypeID           INTEGER                         not null,
   AttachmentStatusTypeID INTEGER,
   Lon                  FLOAT,
   Lat                  FLOAT,
   Height               FLOAT,
   Angle                FLOAT,
   Heading              FLOAT,
   Range                FLOAT,
   ViewLon              FLOAT,
   ViewLat              FLOAT,
   ViewHeight           FLOAT,
   ViewAngle            FLOAT,
   ViewHeading          FLOAT,
   ViewRange            FLOAT,
   AttachmentName       VARCHAR2(64),
   AssetCode            VARCHAR2(64),
   IsMonitor            SMALLINT,
   InstallDate          DATE,
   Memo                 VARCHAR2(255),
   constraint PK_CABLEATTACHMENT primary key (AttachmentNum)
);

comment on table CableAttachment is
'本体
终端（冷缩、热缩、预制、瓷套、GIS）
接头（预制）
接地系统（交叉互联箱、保护接地箱、直接接地箱）';

comment on column CableAttachment.AttachmentNum is
'电缆附件编号';

comment on column CableAttachment.CableDeviceTypeID is
'电缆设备类型ID';

comment on column CableAttachment.ModelTypeNum is
'规格编号';

comment on column CableAttachment.CableDeviceStyleID is
'设备类型ID';

comment on column CableAttachment.Num is
'档案编号';

comment on column CableAttachment.FaultIndicatorTypeID is
'类型ID';

comment on column CableAttachment.SafeBoxTypeID is
'类型ID2';

comment on column CableAttachment.AttachmentTypeID is
'附件类型ID';

comment on column CableAttachment.CompanyNum is
'单位编号';

comment on column CableAttachment.PathTypeID is
'线路类型ID';

comment on column CableAttachment.AttachmentStatusTypeID is
'状态ID';

comment on column CableAttachment.Lon is
'经度';

comment on column CableAttachment.Lat is
'纬度';

comment on column CableAttachment.Height is
'高度';

comment on column CableAttachment.Angle is
'倾角';

comment on column CableAttachment.Heading is
'方位';

comment on column CableAttachment.Range is
'范围';

comment on column CableAttachment.ViewLon is
'视点经度';

comment on column CableAttachment.ViewLat is
'视点纬度';

comment on column CableAttachment.ViewHeight is
'视点高度';

comment on column CableAttachment.ViewAngle is
'视点倾角';

comment on column CableAttachment.ViewHeading is
'视点方位';

comment on column CableAttachment.ViewRange is
'视点范围';

comment on column CableAttachment.AttachmentName is
'电缆附件名称';

comment on column CableAttachment.AssetCode is
'资产编码';

comment on column CableAttachment.IsMonitor is
'是否在线监测';

comment on column CableAttachment.InstallDate is
'投运时间';

comment on column CableAttachment.Memo is
'备注';

create index Relationship_88_FK on CableAttachment (
   AttachmentTypeID ASC
);

create index R_91_FK on CableAttachment (
   ModelTypeNum ASC
);

create index Relationship_99_FK on CableAttachment (
   CompanyNum ASC
);

create index R_110_FK on CableAttachment (
   PathTypeID ASC
);

create index Relationship_130_FK on CableAttachment (
   Num ASC
);

create index Relationship_131_FK on CableAttachment (
   FaultIndicatorTypeID ASC
);

create index Relationship_137_FK on CableAttachment (
   SafeBoxTypeID ASC
);

create index Relationship_139_FK on CableAttachment (
   AttachmentStatusTypeID ASC
);

create index Relationship_177_FK on CableAttachment (
   CableDeviceStyleID ASC
);

create index R_180_FK on CableAttachment (
   CableDeviceTypeID ASC
);

create table CableAttachmentType  (
   AttachmentTypeID     INTEGER                         not null,
   AttachmentTypeName   VARCHAR2(32)                    not null,
   constraint PK_CABLEATTACHMENTTYPE primary key (AttachmentTypeID)
);

comment on table CableAttachmentType is
'本体
终端头
中间接头
接地箱
';

comment on column CableAttachmentType.AttachmentTypeID is
'附件类型ID';

comment on column CableAttachmentType.AttachmentTypeName is
'附件类型名称';

create table CableDeviceLedger  (
   Num                  INTEGER                         not null,
   VoltageLevelID       INTEGER,
   EmployeeID           VARCHAR2(16)                    not null,
   AcceptStatusTypeID   INTEGER                         not null,
   PathTypeID           INTEGER                         not null,
   ProjectTypeID        INTEGER,
   LedgerName           VARCHAR2(255),
   LedgerCode           VARCHAR2(32),
   ProjectCode          VARCHAR2(32),
   ArchivesTime         DATE,
   IsRush               SMALLINT,
   BuildDate            DATE,
   AccpetDate           DATE,
   Memo                 VARCHAR2(255),
   constraint PK_CABLEDEVICELEDGER primary key (Num)
);

comment on table CableDeviceLedger is
'电缆设备档案';

comment on column CableDeviceLedger.Num is
'档案编号';

comment on column CableDeviceLedger.VoltageLevelID is
'电压等级ID';

comment on column CableDeviceLedger.EmployeeID is
'用户ID';

comment on column CableDeviceLedger.AcceptStatusTypeID is
'验收状态类型ID';

comment on column CableDeviceLedger.PathTypeID is
'线路类型ID';

comment on column CableDeviceLedger.ProjectTypeID is
'工程类型ID';

comment on column CableDeviceLedger.LedgerName is
'电缆档案名称';

comment on column CableDeviceLedger.LedgerCode is
'电缆档案编码';

comment on column CableDeviceLedger.ProjectCode is
'方案编号';

comment on column CableDeviceLedger.ArchivesTime is
'录入时间';

comment on column CableDeviceLedger.IsRush is
'加急验收标志';

comment on column CableDeviceLedger.BuildDate is
'施工时间';

comment on column CableDeviceLedger.AccpetDate is
'验收时间';

comment on column CableDeviceLedger.Memo is
'备注';

create index Relationship_133_FK on CableDeviceLedger (
   PathTypeID ASC
);

create index R_135_FK on CableDeviceLedger (
   VoltageLevelID ASC
);

create index R_136_FK on CableDeviceLedger (
   ProjectTypeID ASC
);

create index Relationship_147_FK on CableDeviceLedger (
   AcceptStatusTypeID ASC
);

create index Relationship_165_FK on CableDeviceLedger (
   EmployeeID ASC
);

create table CableDeviceStyle  (
   CableDeviceStyleID   INTEGER                         not null,
   PathTypeID           INTEGER                         not null,
   AttachmentTypeID     INTEGER,
   CableDeviceStyleName VARCHAR2(32)                    not null,
   constraint PK_CABLEDEVICESTYLE primary key (CableDeviceStyleID)
);

comment on table CableDeviceStyle is
'本体：铜、铝
配电端头：冷缩、热缩
输电端头：户外预制、GIS预制、瓷套
配电接头：冷缩、热缩
输电接头：整体、预制';

comment on column CableDeviceStyle.CableDeviceStyleID is
'设备类型ID';

comment on column CableDeviceStyle.PathTypeID is
'线路类型ID';

comment on column CableDeviceStyle.AttachmentTypeID is
'附件类型ID';

comment on column CableDeviceStyle.CableDeviceStyleName is
'设备类型名称';

create index Relationship_175_FK on CableDeviceStyle (
   AttachmentTypeID ASC
);

create index Relationship_176_FK on CableDeviceStyle (
   PathTypeID ASC
);

create table CableDeviceType  (
   CableDeviceTypeID    INTEGER                         not null,
   AttachmentTypeID     INTEGER,
   PathTypeID           INTEGER,
   CableDeviceTypeName  VARCHAR2(32)                    not null,
   constraint PK_CABLEDEVICETYPE primary key (CableDeviceTypeID)
);

comment on table CableDeviceType is
'配电本体：绝缘种类（油纸\交联等）
输电本体：绝缘种类（充油\交联等）

配电端头：连接方式（螺栓、T型）
输电端头：无

配电接头：无
输电接头：假接头、直通接头、绝缘接头';

comment on column CableDeviceType.CableDeviceTypeID is
'电缆设备类型ID';

comment on column CableDeviceType.AttachmentTypeID is
'附件类型ID';

comment on column CableDeviceType.PathTypeID is
'线路类型ID';

comment on column CableDeviceType.CableDeviceTypeName is
'电缆设备类型名称';

create index Relationship_178_FK on CableDeviceType (
   AttachmentTypeID ASC
);

create index Relationship_179_FK on CableDeviceType (
   PathTypeID ASC
);

create table CableOfSection  (
   LayerCableNum        INTEGER                         not null,
   TrestleLayerNum      INTEGER,
   CableNum             INTEGER                         not null,
   SectionNum           INTEGER                         not null,
   RowTubeNum           INTEGER,
   OrderNum             INTEGER,
   X                    FLOAT,
   Y                    FLOAT,
   PlaceType            INTEGER,
   IsTempCable          SMALLINT,
   constraint PK_CABLEOFSECTION primary key (LayerCableNum)
);

comment on table CableOfSection is
'位置顺序用于三维仿真，
根据支架长度确定每层支架可用的位置数量，计算间距，依顺序摆放
顺序从两边向中心计算
X、Y用于剖面坐标管理
敷设类型：1水平2垂直3品字
品字占位下排从边向中心1、2，上排序号为3

敷设性质：false 正式敷设 true预敷设（临时敷设）';

comment on column CableOfSection.LayerCableNum is
'敷设记录编号';

comment on column CableOfSection.TrestleLayerNum is
'层级编号';

comment on column CableOfSection.CableNum is
'电缆编号';

comment on column CableOfSection.SectionNum is
'沟道区段编号';

comment on column CableOfSection.RowTubeNum is
'排管编号';

comment on column CableOfSection.OrderNum is
'位置顺序';

comment on column CableOfSection.X is
'剖面x轴坐标';

comment on column CableOfSection.Y is
'剖面y轴坐标';

comment on column CableOfSection.PlaceType is
'敷设类型';

comment on column CableOfSection.IsTempCable is
'是否预敷设';

create index Relationship_100_FK on CableOfSection (
   CableNum ASC
);

create index Relationship_101_FK on CableOfSection (
   TrestleLayerNum ASC
);

create index Relationship_91_FK on CableOfSection (
   SectionNum ASC
);

create index R_99_FK on CableOfSection (
   RowTubeNum ASC
);

create table CablePath  (
   CablePathNum         INTEGER                         not null,
   PathTypeID           INTEGER                         not null,
   BaseFacilityNum      INTEGER,
   AreaNum              INTEGER,
   VoltageLevelID       INTEGER                         not null,
   OrganizationNum      INTEGER,
   CablePathCode        VARCHAR2(32),
   CablePathName        VARCHAR2(255),
   LayingMethod         VARCHAR2(255),
   LayingMemo           VARCHAR2(255),
   BeginPlace           VARCHAR2(255),
   EndPlace             VARCHAR2(255),
   Memo                 VARCHAR2(512),
   constraint PK_CABLEPATH primary key (CablePathNum)
);

comment on table CablePath is
'起止点是否采用录入方式？或从相关设施中选择

需要添加线路性质选项，选项为：电缆/混合
使用敷设备注或线路备注字段，使用XML字典方式';

comment on column CablePath.CablePathNum is
'线路编号';

comment on column CablePath.PathTypeID is
'线路类型ID';

comment on column CablePath.BaseFacilityNum is
'设施编号';

comment on column CablePath.AreaNum is
'片区编号';

comment on column CablePath.VoltageLevelID is
'电压等级ID';

comment on column CablePath.OrganizationNum is
'单位编号';

comment on column CablePath.CablePathCode is
'运行编号';

comment on column CablePath.CablePathName is
'线路名称';

comment on column CablePath.LayingMethod is
'敷设方式说明';

comment on column CablePath.LayingMemo is
'敷设备注';

comment on column CablePath.BeginPlace is
'起点';

comment on column CablePath.EndPlace is
'终点';

comment on column CablePath.Memo is
'线路备注';

create index Relationship_86_FK on CablePath (
   PathTypeID ASC
);

create index Relationship_94_FK on CablePath (
   VoltageLevelID ASC
);

create index Relationship_103_FK on CablePath (
   OrganizationNum ASC
);

create index Relationship_109_FK on CablePath (
   AreaNum ASC
);

create index Relationship_172_FK on CablePath (
   BaseFacilityNum ASC
);

create table CableSectionArrt  (
   AttrNum              INTEGER                         not null,
   AttachmentNum        INTEGER                         not null,
   BeginPlace           VARCHAR2(255),
   EndPlace             VARCHAR2(255),
   CurrentCapacity      FLOAT,
   Length               FLOAT,
   IsHaveEarthLine      SMALLINT,
   EarthConnectorType   VARCHAR2(16),
   constraint PK_CABLESECTIONARRT primary key (AttrNum)
);

comment on table CableSectionArrt is
'接地引出类型使用XML字典，预留设计（目前引出使用线路段对象）';

comment on column CableSectionArrt.AttrNum is
'属性编号';

comment on column CableSectionArrt.AttachmentNum is
'电缆附件编号';

comment on column CableSectionArrt.BeginPlace is
'起点';

comment on column CableSectionArrt.EndPlace is
'止点';

comment on column CableSectionArrt.CurrentCapacity is
'载流量';

comment on column CableSectionArrt.Length is
'长度';

comment on column CableSectionArrt.IsHaveEarthLine is
'是否地线引出';

comment on column CableSectionArrt.EarthConnectorType is
'接地引出类型';

create index R_119_FK on CableSectionArrt (
   AttachmentNum ASC
);

create table Company  (
   CompanyNum           INTEGER                         not null,
   CompanyTypeID        INTEGER                         not null,
   CompanyName          VARCHAR2(255)                   not null,
   CompanyAddr          VARCHAR2(255),
   CompanyTelephone     VARCHAR2(16),
   Contact              VARCHAR2(64),
   ContactPhone         VARCHAR2(16),
   Memo                 VARCHAR2(255),
   constraint PK_COMPANY primary key (CompanyNum)
);

comment on table Company is
'监理单位
施工单位
生产厂家
电缆厂家
电缆附件厂家
电缆设施厂家';

comment on column Company.CompanyNum is
'单位编号';

comment on column Company.CompanyTypeID is
'单位类型ID';

comment on column Company.CompanyName is
'单位名称';

comment on column Company.CompanyAddr is
'单位地址';

comment on column Company.CompanyTelephone is
'单位电话';

comment on column Company.Contact is
'联系人';

comment on column Company.ContactPhone is
'联系人电话';

comment on column Company.Memo is
'备注';

create index CompanyT_FK on Company (
   CompanyTypeID ASC
);

create table CompanyType  (
   CompanyTypeID        INTEGER                         not null,
   CompanyTypeName      VARCHAR2(32)                    not null,
   constraint PK_COMPANYTYPE primary key (CompanyTypeID)
);

comment on table CompanyType is
'生产厂家（沟道设施生产厂家）
施工单位
监理单位
电缆厂家
电缆附件厂家
设施厂家（杆塔、箱变、开闭所、分接箱）
';

comment on column CompanyType.CompanyTypeID is
'单位类型ID';

comment on column CompanyType.CompanyTypeName is
'单位类型名称';

create table CoverShapeType  (
   CoverShapeTypeID     INTEGER                         not null,
   CoverShapeTypeName   VARCHAR2(32)                    not null,
   constraint PK_COVERSHAPETYPE primary key (CoverShapeTypeID)
);

comment on table CoverShapeType is
'圆形、方形……';

comment on column CoverShapeType.CoverShapeTypeID is
'井口设施形状类型ID';

comment on column CoverShapeType.CoverShapeTypeName is
'井口设施形状类型名称';

create table CoverStuffType  (
   CoverStuffTypeID     INTEGER                         not null,
   ManholeCoverTypeID   INTEGER                         not null,
   CoverStuffTypeName   VARCHAR2(32)                    not null,
   constraint PK_COVERSTUFFTYPE primary key (CoverStuffTypeID)
);

comment on table CoverStuffType is
'井盖/风楼材质类型';

comment on column CoverStuffType.CoverStuffTypeID is
'井口设施材质类型ID';

comment on column CoverStuffType.ManholeCoverTypeID is
'井口设施设施类型ID';

comment on column CoverStuffType.CoverStuffTypeName is
'井口设施材质类型名称';

create index Relationship_80_FK on CoverStuffType (
   ManholeCoverTypeID ASC
);

create table DoorStuffType  (
   DoorStuffTypeID      INTEGER                         not null,
   DoorStuffTypeName    VARCHAR2(32)                    not null,
   constraint PK_DOORSTUFFTYPE primary key (DoorStuffTypeID)
);

comment on table DoorStuffType is
'防火门材质类型';

comment on column DoorStuffType.DoorStuffTypeID is
'防火门材质类型ID';

comment on column DoorStuffType.DoorStuffTypeName is
'防火门材质类型名称';

create table Employee  (
   EmployeeID           VARCHAR2(16)                    not null,
   OrganizationNum      INTEGER                         not null,
   Account              VARCHAR2(16)                    not null,
   Password             VARCHAR2(64)                    not null,
   UserName             VARCHAR2(16)                    not null,
   Sex                  VARCHAR2(8),
   Email                VARCHAR2(64),
   SID                  VARCHAR2(32),
   Grade                VARCHAR2(16),
   MobilePhone          VARCHAR2(11),
   Address              VARCHAR2(255),
   CreateDate           DATE,
   IsDisabled           SMALLINT,
   DisableDate          DATE,
   constraint PK_EMPLOYEE primary key (EmployeeID)
);

comment on table Employee is
'员工表

grade:
0组员
1班长
2专责
3主任
4书记';

comment on column Employee.EmployeeID is
'用户ID';

comment on column Employee.OrganizationNum is
'单位编号';

comment on column Employee.Account is
'登录帐号';

comment on column Employee.Password is
'Password';

comment on column Employee.UserName is
'用户名称';

comment on column Employee.Sex is
'性别';

comment on column Employee.Email is
'Email';

comment on column Employee.SID is
'SID';

comment on column Employee.Grade is
'等级';

comment on column Employee.MobilePhone is
'手机号码';

comment on column Employee.Address is
'家庭住址';

comment on column Employee.CreateDate is
'账户创建时间';

comment on column Employee.IsDisabled is
'停用标志';

comment on column Employee.DisableDate is
'停用时间';

create index Relationship_71_FK on Employee (
   OrganizationNum ASC
);

create table Extinguisher  (
   AssetNum             INTEGER                         not null,
   monitor_CompanyNum   INTEGER,
   EmployeeID           VARCHAR2(16),
   ExtinguisherTypeID   INTEGER,
   bulid_CompanyNum     INTEGER,
   Tunnel_AssetNum      INTEGER                         not null,
   AssetName            VARCHAR2(255),
   AssetCode            VARCHAR2(64),
   GraphID              INTEGER,
   OperationCode        VARCHAR2(32),
   BuildDate            DATE,
   CompletedDate        DATE,
   OperationDate        DATE,
   PositionDescription  VARCHAR2(512),
   Longitude            FLOAT,
   Latitude             FLOAT,
   Memo                 VARCHAR2(512),
   ExtinguisherInfo     VARCHAR2(32),
   Quantity             INTEGER,
   UpGradeTime          DATE,
   ValidityYear         FLOAT,
   DownTime             DATE,
   constraint PK_EXTINGUISHER primary key (AssetNum)
);

comment on table Extinguisher is
'灭火装置';

comment on column Extinguisher.AssetNum is
'资产编号';

comment on column Extinguisher.monitor_CompanyNum is
'监理_单位编号';

comment on column Extinguisher.EmployeeID is
'用户ID';

comment on column Extinguisher.ExtinguisherTypeID is
'灭火器材类型ID';

comment on column Extinguisher.bulid_CompanyNum is
'施工_单位编号';

comment on column Extinguisher.Tunnel_AssetNum is
'电缆通道_资产编号';

comment on column Extinguisher.AssetName is
'资产名称';

comment on column Extinguisher.AssetCode is
'资产编码';

comment on column Extinguisher.GraphID is
'图元ID';

comment on column Extinguisher.OperationCode is
'运行编码';

comment on column Extinguisher.BuildDate is
'施工日期';

comment on column Extinguisher.CompletedDate is
'竣工日期';

comment on column Extinguisher.OperationDate is
'投运日期';

comment on column Extinguisher.PositionDescription is
'所在方位';

comment on column Extinguisher.Longitude is
'经度';

comment on column Extinguisher.Latitude is
'纬度';

comment on column Extinguisher.Memo is
'备注';

comment on column Extinguisher.ExtinguisherInfo is
'规格说明';

comment on column Extinguisher.Quantity is
'数量';

comment on column Extinguisher.UpGradeTime is
'安装时间';

comment on column Extinguisher.ValidityYear is
'有效期';

comment on column Extinguisher.DownTime is
'失效时间';

create index Relationship_60_FK on Extinguisher (
   ExtinguisherTypeID ASC
);

create index Relationship_61_FK on Extinguisher (
   Tunnel_AssetNum ASC
);

create index Relationship_11_FK on Extinguisher (
   bulid_CompanyNum ASC
);

create index Relationship_12_FK on Extinguisher (
   monitor_CompanyNum ASC
);

create index Relationship_167_FK on Extinguisher (
   EmployeeID ASC
);

create table ExtinguisherType  (
   ExtinguisherTypeID   INTEGER                         not null,
   ExtinguisherTypeName VARCHAR2(32)                    not null,
   constraint PK_EXTINGUISHERTYPE primary key (ExtinguisherTypeID)
);

comment on table ExtinguisherType is
'灭火器材类型';

comment on column ExtinguisherType.ExtinguisherTypeID is
'灭火器材类型ID';

comment on column ExtinguisherType.ExtinguisherTypeName is
'灭火器材类型名称';

create table FaultIndicatorType  (
   FaultIndicatorTypeID INTEGER                         not null,
   FaultIndicatorTypeName VARCHAR2(32)                    not null,
   constraint PK_FAULTINDICATORTYPE primary key (FaultIndicatorTypeID)
);

comment on table FaultIndicatorType is
'故障指示器类型';

comment on column FaultIndicatorType.FaultIndicatorTypeID is
'类型ID';

comment on column FaultIndicatorType.FaultIndicatorTypeName is
'类型名称';

create table FileAttachment  (
   FileNum              INTEGER                         not null,
   EmployeeID           VARCHAR2(16),
   BaseFacilityNum      INTEGER                         not null,
   FileName             VARCHAR2(255)                   not null,
   FilePath             CLOB                            not null,
   UpdateDate           DATE                            not null,
   FileMemo             VARCHAR2(255),
   constraint PK_FILEATTACHMENT primary key (FileNum)
);

comment on table FileAttachment is
'文件附件';

comment on column FileAttachment.FileNum is
'文件编号';

comment on column FileAttachment.EmployeeID is
'用户ID';

comment on column FileAttachment.BaseFacilityNum is
'设施编号';

comment on column FileAttachment.FileName is
'文件名称';

comment on column FileAttachment.FilePath is
'文件存放路径';

comment on column FileAttachment.UpdateDate is
'上传时间';

comment on column FileAttachment.FileMemo is
'文件备注';

create index R_114_FK on FileAttachment (
   BaseFacilityNum ASC
);

create index R_115_FK on FileAttachment (
   EmployeeID ASC
);

create table FireWall  (
   AssetNum             INTEGER                         not null,
   CompanyNum           INTEGER,
   monitor_CompanyNum   INTEGER,
   FireWallStuffTypeID  INTEGER,
   EmployeeID           VARCHAR2(16),
   FireWallTypeID       INTEGER,
   DoorStuffTypeID      INTEGER,
   bulid_CompanyNum     INTEGER,
   Tunnel_AssetNum      INTEGER                         not null,
   AssetName            VARCHAR2(255),
   AssetCode            VARCHAR2(64),
   GraphID              INTEGER,
   OperationCode        VARCHAR2(32),
   BuildDate            DATE,
   CompletedDate        DATE,
   OperationDate        DATE,
   PositionDescription  VARCHAR2(512),
   Longitude            FLOAT,
   Latitude             FLOAT,
   Memo                 VARCHAR2(512),
   WallSize             VARCHAR2(32),
   DoorSize             VARCHAR2(32),
   DoorBuildDate        DATE,
   constraint PK_FIREWALL primary key (AssetNum)
);

comment on table FireWall is
'防火墙';

comment on column FireWall.AssetNum is
'资产编号';

comment on column FireWall.CompanyNum is
'防火门厂家编号';

comment on column FireWall.monitor_CompanyNum is
'监理_单位编号';

comment on column FireWall.FireWallStuffTypeID is
'防火墙材质类型ID';

comment on column FireWall.EmployeeID is
'用户ID';

comment on column FireWall.FireWallTypeID is
'防火墙类型ID';

comment on column FireWall.DoorStuffTypeID is
'防火门材质类型ID';

comment on column FireWall.bulid_CompanyNum is
'施工_单位编号';

comment on column FireWall.Tunnel_AssetNum is
'电缆通道_资产编号';

comment on column FireWall.AssetName is
'资产名称';

comment on column FireWall.AssetCode is
'资产编码';

comment on column FireWall.GraphID is
'图元ID';

comment on column FireWall.OperationCode is
'运行编码';

comment on column FireWall.BuildDate is
'施工日期';

comment on column FireWall.CompletedDate is
'竣工日期';

comment on column FireWall.OperationDate is
'投运日期';

comment on column FireWall.PositionDescription is
'所在方位';

comment on column FireWall.Longitude is
'经度';

comment on column FireWall.Latitude is
'纬度';

comment on column FireWall.Memo is
'备注';

comment on column FireWall.WallSize is
'防火墙规格';

comment on column FireWall.DoorSize is
'防火门规格';

comment on column FireWall.DoorBuildDate is
'防火门出厂日期';

create index Relationship_37_FK on FireWall (
   Tunnel_AssetNum ASC
);

create index Relationship_49_FK on FireWall (
   FireWallStuffTypeID ASC
);

create index Relationship_67_FK on FireWall (
   CompanyNum ASC
);

create index Relationship_68_FK on FireWall (
   DoorStuffTypeID ASC
);

create index Relationship_74_FK on FireWall (
   FireWallTypeID ASC
);

create index Relationship_21_FK on FireWall (
   bulid_CompanyNum ASC
);

create index Relationship_22_FK on FireWall (
   monitor_CompanyNum ASC
);

create index Relationship_184_FK on FireWall (
   EmployeeID ASC
);

create table FireWallStuffType  (
   FireWallStuffTypeID  INTEGER                         not null,
   FireWallStuffTypeName VARCHAR2(32)                    not null,
   constraint PK_FIREWALLSTUFFTYPE primary key (FireWallStuffTypeID)
);

comment on table FireWallStuffType is
'海泡石、
锚喷、
砖砌';

comment on column FireWallStuffType.FireWallStuffTypeID is
'防火墙材质类型ID';

comment on column FireWallStuffType.FireWallStuffTypeName is
'防火墙材质类型名称';

create table FireWallType  (
   FireWallTypeID       INTEGER                         not null,
   FireWallTypeName     VARCHAR2(32)                    not null,
   constraint PK_FIREWALLTYPE primary key (FireWallTypeID)
);

comment on table FireWallType is
'单侧
双侧
……';

comment on column FireWallType.FireWallTypeID is
'防火墙类型ID';

comment on column FireWallType.FireWallTypeName is
'防火墙类型名称';

create table FlawAdjunctFile  (
   AdjunctFileNum       INTEGER                         not null,
   ObjFlawNum           INTEGER                         not null,
   EmployeeID           VARCHAR2(16),
   AdjunctFileName      VARCHAR2(128),
   AdjunctFilePath      VARCHAR2(255),
   UpdateDate           DATE,
   constraint PK_FLAWADJUNCTFILE primary key (AdjunctFileNum)
);

comment on table FlawAdjunctFile is
'缺陷附件记录';

comment on column FlawAdjunctFile.AdjunctFileNum is
'文件记录编号';

comment on column FlawAdjunctFile.ObjFlawNum is
'记录编号';

comment on column FlawAdjunctFile.EmployeeID is
'用户ID';

comment on column FlawAdjunctFile.AdjunctFileName is
'文件名称';

comment on column FlawAdjunctFile.AdjunctFilePath is
'文件存放路径';

comment on column FlawAdjunctFile.UpdateDate is
'上传时间';

create index Relationship_158_FK on FlawAdjunctFile (
   ObjFlawNum ASC
);

create index Relationship_180_FK on FlawAdjunctFile (
   EmployeeID ASC
);

create table FlawAduitRecord  (
   AduitRecordNum       INTEGER                         not null,
   EmployeeID           VARCHAR2(16),
   FlawAduitWayID       INTEGER,
   ObjFlawNum           INTEGER                         not null,
   AduitOpinion         VARCHAR2(255),
   AduitDate            DATE                            not null,
   constraint PK_FLAWADUITRECORD primary key (AduitRecordNum)
);

comment on table FlawAduitRecord is
'缺陷处理审核记录';

comment on column FlawAduitRecord.AduitRecordNum is
'审核记录编号';

comment on column FlawAduitRecord.EmployeeID is
'用户ID';

comment on column FlawAduitRecord.FlawAduitWayID is
'审核处理方式ID';

comment on column FlawAduitRecord.ObjFlawNum is
'记录编号';

comment on column FlawAduitRecord.AduitOpinion is
'审核意见';

comment on column FlawAduitRecord.AduitDate is
'审核时间';

create index R_162_FK on FlawAduitRecord (
   ObjFlawNum ASC
);

create index Relationship_183_FK on FlawAduitRecord (
   EmployeeID ASC
);

create index Relationship_164_FK on FlawAduitRecord (
   FlawAduitWayID ASC
);

create table FlawAduitStatus  (
   FlawAduitStatusID    INTEGER                         not null,
   FlawAduitStatusName  VARCHAR2(32)                    not null,
   ShowColor            VARCHAR2(8),
   constraint PK_FLAWADUITSTATUS primary key (FlawAduitStatusID)
);

comment on table FlawAduitStatus is
'缺陷处理状态
班长审核、
专责审核、
主任审核、
暂不处理
不处理、
处理（安排消缺）/待消缺
处理中
已消缺';

comment on column FlawAduitStatus.FlawAduitStatusID is
'缺陷状态ID';

comment on column FlawAduitStatus.FlawAduitStatusName is
'缺陷名称';

comment on column FlawAduitStatus.ShowColor is
'状态颜色';

create table FlawAduitWay  (
   FlawAduitWayID       INTEGER                         not null,
   FlawAduitWayName     VARCHAR2(32)                    not null,
   constraint PK_FLAWADUITWAY primary key (FlawAduitWayID)
);

comment on table FlawAduitWay is
'审核处理方式
暂不处理
处理
无需处理
上报';

comment on column FlawAduitWay.FlawAduitWayID is
'审核处理方式ID';

comment on column FlawAduitWay.FlawAduitWayName is
'处理方式名称';

create table FlawLevelType  (
   FlawLevelTypeID      INTEGER                         not null,
   FlawLevelTypeName    VARCHAR2(32)                    not null,
   constraint PK_FLAWLEVELTYPE primary key (FlawLevelTypeID)
);

comment on table FlawLevelType is
'缺陷认定等级
一般缺陷、严重缺陷、危急缺陷';

comment on column FlawLevelType.FlawLevelTypeID is
'缺陷等级ID';

comment on column FlawLevelType.FlawLevelTypeName is
'缺陷等级名称';

create table FlawProcAcceptType  (
   FlawProcAcceptTypeID INTEGER                         not null,
   FlawProcAcceptTypeName VARCHAR2(32),
   constraint PK_FLAWPROCACCEPTTYPE primary key (FlawProcAcceptTypeID)
);

comment on table FlawProcAcceptType is
'已消缺
未完全消缺
未消缺';

comment on column FlawProcAcceptType.FlawProcAcceptTypeID is
'处理确认类型ID';

comment on column FlawProcAcceptType.FlawProcAcceptTypeName is
'类型名称';

create table FlawProcFile  (
   FileNum              INTEGER                         not null,
   FlawProcObj          INTEGER                         not null,
   EmployeeID           VARCHAR2(16),
   ProcAdjunctFile      VARCHAR2(128)                   not null,
   FilePath             VARCHAR2(255)                   not null,
   UpdateDate           DATE                            not null,
   FileMemo             VARCHAR2(255),
   constraint PK_FLAWPROCFILE primary key (FileNum)
);

comment on table FlawProcFile is
'消缺附件';

comment on column FlawProcFile.FileNum is
'文件编号';

comment on column FlawProcFile.FlawProcObj is
'消缺对象记录编号';

comment on column FlawProcFile.EmployeeID is
'用户ID';

comment on column FlawProcFile.ProcAdjunctFile is
'文件名称';

comment on column FlawProcFile.FilePath is
'文件存放路径';

comment on column FlawProcFile.UpdateDate is
'上传时间';

comment on column FlawProcFile.FileMemo is
'文件备注';

create index R_163_FK on FlawProcFile (
   FlawProcObj ASC
);

create index Relationship_174_FK on FlawProcFile (
   EmployeeID ASC
);

create table FlawProcTask  (
   FlawProcTaskNum      INTEGER                         not null,
   TaskStatusTypeID     INTEGER,
   EmployeeID           VARCHAR2(16)                    not null,
   Task_EmployeeID      VARCHAR2(16)                    not null,
   FlawProcTaskName     VARCHAR2(128)                   not null,
   FlawProcTaskDescption VARCHAR2(255),
   PlanDate             DATE                            not null,
   WorkUserList         VARCHAR2(255),
   WorkBillsCode        VARCHAR2(32),
   StartDateTime        DATE,
   CompleteDateTime     DATE,
   Memo                 VARCHAR2(255),
   constraint PK_FLAWPROCTASK primary key (FlawProcTaskNum)
);

comment on table FlawProcTask is
'消缺任务';

comment on column FlawProcTask.FlawProcTaskNum is
'消缺任务编号';

comment on column FlawProcTask.TaskStatusTypeID is
'任务状态ID';

comment on column FlawProcTask.EmployeeID is
'任务创建人ID';

comment on column FlawProcTask.Task_EmployeeID is
'工作负责人ID';

comment on column FlawProcTask.FlawProcTaskName is
'消缺任务名称';

comment on column FlawProcTask.FlawProcTaskDescption is
'消缺任务描述';

comment on column FlawProcTask.PlanDate is
'计划时间';

comment on column FlawProcTask.WorkUserList is
'消缺人员名称';

comment on column FlawProcTask.WorkBillsCode is
'二卡票号';

comment on column FlawProcTask.StartDateTime is
'开始时间';

comment on column FlawProcTask.CompleteDateTime is
'完成时间';

comment on column FlawProcTask.Memo is
'备注';

create index Relationship_187_FK on FlawProcTask (
   Task_EmployeeID ASC
);

create index Relationship_188_FK on FlawProcTask (
   EmployeeID ASC
);

create index R_168_FK on FlawProcTask (
   TaskStatusTypeID ASC
);

create table FlawProcTaskObj  (
   FlawProcObj          INTEGER                         not null,
   FlawProcAcceptTypeID INTEGER,
   FlawProcTaskNum      INTEGER                         not null,
   ObjFlawNum           INTEGER                         not null,
   FlawPrcoDescription  VARCHAR2(255),
   FlawProcDate         DATE,
   Memo                 VARCHAR2(255),
   constraint PK_FLAWPROCTASKOBJ primary key (FlawProcObj)
);

comment on table FlawProcTaskObj is
'消缺内容记录';

comment on column FlawProcTaskObj.FlawProcObj is
'消缺对象记录编号';

comment on column FlawProcTaskObj.FlawProcAcceptTypeID is
'处理确认类型ID';

comment on column FlawProcTaskObj.FlawProcTaskNum is
'消缺任务编号';

comment on column FlawProcTaskObj.ObjFlawNum is
'记录编号';

comment on column FlawProcTaskObj.FlawPrcoDescription is
'消缺处理说明';

comment on column FlawProcTaskObj.FlawProcDate is
'消缺处理时间';

comment on column FlawProcTaskObj.Memo is
'备注';

create index Relationship_185_FK on FlawProcTaskObj (
   FlawProcTaskNum ASC
);

create index R_166_FK on FlawProcTaskObj (
   ObjFlawNum ASC
);

create index Relationship_159_FK on FlawProcTaskObj (
   FlawProcAcceptTypeID ASC
);

create table FlawSourceType  (
   FlawSourceTypeID     INTEGER                         not null,
   FlawSourceName       VARCHAR2(32)                    not null,
   constraint PK_FLAWSOURCETYPE primary key (FlawSourceTypeID)
);

comment on table FlawSourceType is
'缺陷来源类型
1、现场巡视
2、电力热线（95598）
3、其他';

comment on column FlawSourceType.FlawSourceTypeID is
'来源类型ID';

comment on column FlawSourceType.FlawSourceName is
'类型名称';

create table FlawType  (
   FlawTypeID           INTEGER                         not null,
   FlawTypeName         VARCHAR2(32)                    not null,
   constraint PK_FLAWTYPE primary key (FlawTypeID)
);

comment on table FlawType is
'本体缺陷
有水缺陷
井底缺陷
井盖破损
有杂物
其他';

comment on column FlawType.FlawTypeID is
'缺陷分类ID';

comment on column FlawType.FlawTypeName is
'缺陷分类名称';

create table InspectObjFlaw  (
   ObjFlawNum           INTEGER                         not null,
   TaskNum              INTEGER,
   FlawTypeID           INTEGER,
   FlawSourceTypeID     INTEGER,
   FlawLevelTypeID      INTEGER,
   FlawAduitStatusID    INTEGER,
   ObjTypeEnum          INTEGER                         not null,
   ObjTableNum          INTEGER,
   ObjCode              VARCHAR2(64),
   IsFlaw               SMALLINT,
   FlawDescription      VARCHAR2(255),
   FlawDate             DATE,
   constraint PK_INSPECTOBJFLAW primary key (ObjFlawNum)
);

comment on table InspectObjFlaw is
'巡视内容记录
对象类型：
通道
通道段（建议不要到这层）
终端设施（工井、杆塔、分接箱……）
防火墙、
灭火装置
线路（线路段）
本体
终端头
中间头
接地箱
';

comment on column InspectObjFlaw.ObjFlawNum is
'记录编号';

comment on column InspectObjFlaw.TaskNum is
'任务记录';

comment on column InspectObjFlaw.FlawTypeID is
'缺陷分类ID';

comment on column InspectObjFlaw.FlawSourceTypeID is
'来源类型ID';

comment on column InspectObjFlaw.FlawLevelTypeID is
'缺陷等级ID';

comment on column InspectObjFlaw.FlawAduitStatusID is
'缺陷状态ID';

comment on column InspectObjFlaw.ObjTypeEnum is
'对象类型';

comment on column InspectObjFlaw.ObjTableNum is
'对象编号';

comment on column InspectObjFlaw.ObjCode is
'对象编码';

comment on column InspectObjFlaw.IsFlaw is
'是否有缺陷';

comment on column InspectObjFlaw.FlawDescription is
'缺陷描述';

comment on column InspectObjFlaw.FlawDate is
'缺陷记录时间';

create index Relationship_157_FK on InspectObjFlaw (
   FlawTypeID ASC
);

create index Relationship_156_FK on InspectObjFlaw (
   FlawSourceTypeID ASC
);

create index Relationship_160_FK on InspectObjFlaw (
   FlawLevelTypeID ASC
);

create index Relationship_161_FK on InspectObjFlaw (
   FlawAduitStatusID ASC
);

create index R_155_FK on InspectObjFlaw (
   TaskNum ASC
);

create table InspectTask  (
   TaskNum              INTEGER                         not null,
   TeamTypeID           INTEGER                         not null,
   EmployeeID           VARCHAR2(16)                    not null,
   Task_EmployeeID      VARCHAR2(16)                    not null,
   TaskStatusTypeID     INTEGER                         not null,
   TaskName             VARCHAR2(255)                   not null,
   TaskDescription      VARCHAR2(512),
   PlanDate             DATE                            not null,
   WorkUserList         VARCHAR2(255),
   WorkBillsCode        VARCHAR2(32),
   StartDateTime        DATE,
   CompleteDateTime     DATE,
   Memo                 VARCHAR2(255),
   constraint PK_INSPECTTASK primary key (TaskNum)
);

comment on table InspectTask is
'巡视任务
班组长发起';

comment on column InspectTask.TaskNum is
'任务记录';

comment on column InspectTask.TeamTypeID is
'专业类型ID';

comment on column InspectTask.EmployeeID is
'任务创建人ID';

comment on column InspectTask.Task_EmployeeID is
'工作负责人ID';

comment on column InspectTask.TaskStatusTypeID is
'任务状态ID';

comment on column InspectTask.TaskName is
'任务名称';

comment on column InspectTask.TaskDescription is
'任务详细说明';

comment on column InspectTask.PlanDate is
'任务计划时间';

comment on column InspectTask.WorkUserList is
'巡视人员名称';

comment on column InspectTask.WorkBillsCode is
'二卡票号';

comment on column InspectTask.StartDateTime is
'巡视开始时间';

comment on column InspectTask.CompleteDateTime is
'巡视完成时间';

comment on column InspectTask.Memo is
'备注';

create index Relationship_168_FK on InspectTask (
   EmployeeID ASC
);

create index Relationship_169_FK on InspectTask (
   Task_EmployeeID ASC
);

create index Relationship_150_FK on InspectTask (
   TaskStatusTypeID ASC
);

create index Relationship_154_FK on InspectTask (
   TeamTypeID ASC
);

create table InstallType  (
   InstallTypeID        INTEGER                         not null,
   InstallTypeName      VARCHAR2(32)                    not null,
   constraint PK_INSTALLTYPE primary key (InstallTypeID)
);

comment on table InstallType is
'架空
隧道
直埋';

comment on column InstallType.InstallTypeID is
'敷设类型ID';

comment on column InstallType.InstallTypeName is
'敷设类型名称';

create table Ledger  (
   ArchivesNum          INTEGER                         not null,
   BaseFacilityNum      INTEGER,
   monitor_CompanyNum   INTEGER,
   AssetBorderTypeID    INTEGER,
   EmployeeID           VARCHAR2(16)                    not null,
   AcceptStatusTypeID   INTEGER,
   bulid_CompanyNum     INTEGER,
   ArchivesCode         VARCHAR2(32)                    not null,
   ArchivesName         VARCHAR2(255),
   MonitorCompany       VARCHAR2(255),
   BuildCompany         VARCHAR2(255),
   BluePrintCode        VARCHAR2(32),
   ArchivesPlace        VARCHAR2(512),
   BluePrintPlace       VARCHAR2(512),
   DrawerCode           VARCHAR2(16),
   Address              VARCHAR2(255),
   Specification        VARCHAR2(512),
   BuildDate            DATE,
   CompleteDate         DATE,
   IsRush               SMALLINT,
   ArchivesTime         DATE,
   Memo                 VARCHAR2(512),
   constraint PK_LEDGER primary key (ArchivesNum)
);

comment on table Ledger is
'通道档案
验收紧急程度类型：1普通2紧急';

comment on column Ledger.ArchivesNum is
'档案记录编号';

comment on column Ledger.BaseFacilityNum is
'设施编号';

comment on column Ledger.monitor_CompanyNum is
'监理_单位编号';

comment on column Ledger.AssetBorderTypeID is
'资产边界类型ID';

comment on column Ledger.EmployeeID is
'用户ID';

comment on column Ledger.AcceptStatusTypeID is
'验收状态类型ID';

comment on column Ledger.bulid_CompanyNum is
'施工_单位编号';

comment on column Ledger.ArchivesCode is
'档案编码';

comment on column Ledger.ArchivesName is
'档案名称';

comment on column Ledger.MonitorCompany is
'监理单位';

comment on column Ledger.BuildCompany is
'施工单位';

comment on column Ledger.BluePrintCode is
'小图编号';

comment on column Ledger.ArchivesPlace is
'档案存放位置';

comment on column Ledger.BluePrintPlace is
'图纸存放位置';

comment on column Ledger.DrawerCode is
'盒内档案号';

comment on column Ledger.Address is
'设备地址';

comment on column Ledger.Specification is
'设备类型';

comment on column Ledger.BuildDate is
'施工日期';

comment on column Ledger.CompleteDate is
'竣工日期';

comment on column Ledger.IsRush is
'加急验收标志';

comment on column Ledger.ArchivesTime is
'录入时间';

comment on column Ledger.Memo is
'备注';

create index Relationship_55_FK on Ledger (
   monitor_CompanyNum ASC
);

create index Relationship_56_FK on Ledger (
   BaseFacilityNum ASC
);

create index Relationship_73_FK on Ledger (
   EmployeeID ASC
);

create index R_116_FK on Ledger (
   AssetBorderTypeID ASC
);

create index Relationship_136_FK on Ledger (
   bulid_CompanyNum ASC
);

create index Relationship_122_FK on Ledger (
   AcceptStatusTypeID ASC
);

create table LoopEarthBox  (
   LoopBoxNum           INTEGER                         not null,
   LoopNum              INTEGER                         not null,
   AttachmentNum        INTEGER                         not null,
   Place                VARCHAR2(255),
   Distance             FLOAT,
   InstallDate          DATE,
   constraint PK_LOOPEARTHBOX primary key (LoopBoxNum)
);

comment on table LoopEarthBox is
'回路接地箱';

comment on column LoopEarthBox.LoopBoxNum is
'编号';

comment on column LoopEarthBox.LoopNum is
'回路编号';

comment on column LoopEarthBox.AttachmentNum is
'电缆附件编号';

comment on column LoopEarthBox.Place is
'安装位置';

comment on column LoopEarthBox.Distance is
'距线路段起点距离';

comment on column LoopEarthBox.InstallDate is
'安装时间';

create index Relationship_112_FK on LoopEarthBox (
   AttachmentNum ASC
);

create index Relationship_129_FK on LoopEarthBox (
   LoopNum ASC
);

create table Manhole  (
   AssetNum             INTEGER                         not null,
   ManholeShapeTypeID   INTEGER,
   AreaNum              INTEGER,
   CompanyNum           INTEGER,
   CoverShapeTypeID     INTEGER,
   monitor_CompanyNum   INTEGER,
   CoverStuffTypeID     INTEGER,
   EmployeeID           VARCHAR2(16),
   ManholeKindTypeID    INTEGER                         not null,
   bulid_CompanyNum     INTEGER,
   BaseFacilityNum      INTEGER,
   ManholeStuffTypeID   INTEGER,
   ManholeCoverTypeID   INTEGER,
   Tunnel_AssetNum      INTEGER,
   AssetName            VARCHAR2(255),
   AssetCode            VARCHAR2(64),
   GraphID              INTEGER,
   OperationCode        VARCHAR2(32),
   BuildDate            DATE,
   CompletedDate        DATE,
   OperationDate        DATE,
   PositionDescription  VARCHAR2(512),
   Longitude            FLOAT,
   Latitude             FLOAT,
   Memo                 VARCHAR2(512),
   Length               FLOAT,
   Width                FLOAT,
   Diameter             FLOAT,
   Height               FLOAT,
   BottomHeight         FLOAT,
   TerraceLayerCount    INTEGER,
   OutLineQuantity      INTEGER,
   ManHoleCoverCode     VARCHAR2(32),
   ManHoleCoverSize     VARCHAR2(32),
   ViewLon              FLOAT,
   ViewLat              FLOAT,
   ViewHeight           FLOAT,
   ViewAngle            FLOAT,
   ViewHeading          FLOAT,
   ViewRange            FLOAT,
   constraint PK_MANHOLE primary key (AssetNum)
);

comment on table Manhole is
'工井
虚拟井
变电站出线井
分接箱
杆塔
箱变
开闭所
……

';

comment on column Manhole.AssetNum is
'资产编号';

comment on column Manhole.ManholeShapeTypeID is
'工井形状类型ID';

comment on column Manhole.AreaNum is
'片区编号';

comment on column Manhole.CompanyNum is
'井口设施厂家编号';

comment on column Manhole.CoverShapeTypeID is
'井口设施形状类型ID';

comment on column Manhole.monitor_CompanyNum is
'监理_单位编号';

comment on column Manhole.CoverStuffTypeID is
'井口设施材质类型ID';

comment on column Manhole.EmployeeID is
'用户ID';

comment on column Manhole.ManholeKindTypeID is
'工井类型ID';

comment on column Manhole.bulid_CompanyNum is
'施工_单位编号';

comment on column Manhole.BaseFacilityNum is
'设施编号';

comment on column Manhole.ManholeStuffTypeID is
'工井材质类型ID';

comment on column Manhole.ManholeCoverTypeID is
'井口设施设施类型ID';

comment on column Manhole.Tunnel_AssetNum is
'电缆通道_资产编号';

comment on column Manhole.AssetName is
'资产名称';

comment on column Manhole.AssetCode is
'资产编码';

comment on column Manhole.GraphID is
'图元ID';

comment on column Manhole.OperationCode is
'运行编码';

comment on column Manhole.BuildDate is
'施工日期';

comment on column Manhole.CompletedDate is
'竣工日期';

comment on column Manhole.OperationDate is
'投运日期';

comment on column Manhole.PositionDescription is
'所在方位';

comment on column Manhole.Longitude is
'经度';

comment on column Manhole.Latitude is
'纬度';

comment on column Manhole.Memo is
'备注';

comment on column Manhole.Length is
'长度';

comment on column Manhole.Width is
'宽度';

comment on column Manhole.Diameter is
'直径';

comment on column Manhole.Height is
'地面高程';

comment on column Manhole.BottomHeight is
'井底高程';

comment on column Manhole.TerraceLayerCount is
'平台层数';

comment on column Manhole.OutLineQuantity is
'出线管数';

comment on column Manhole.ManHoleCoverCode is
'井口设施编码';

comment on column Manhole.ManHoleCoverSize is
'井口设施尺寸';

comment on column Manhole.ViewLon is
'视点经度';

comment on column Manhole.ViewLat is
'视点纬度';

comment on column Manhole.ViewHeight is
'视点高度';

comment on column Manhole.ViewAngle is
'视点倾角';

comment on column Manhole.ViewHeading is
'视点方位';

comment on column Manhole.ViewRange is
'视点范围';

create index Relationship_28_FK on Manhole (
   ManholeStuffTypeID ASC
);

create index Relationship_48_FK on Manhole (
   ManholeKindTypeID ASC
);

create index Relationship_69_FK on Manhole (
   Tunnel_AssetNum ASC
);

create index Relationship_78_FK on Manhole (
   CompanyNum ASC
);

create index Relationship_79_FK on Manhole (
   ManholeCoverTypeID ASC
);

create index Relationship_81_FK on Manhole (
   CoverStuffTypeID ASC
);

create index Relationship_82_FK on Manhole (
   CoverShapeTypeID ASC
);

create index Relationship_87_FK on Manhole (
   ManholeShapeTypeID ASC
);

create index Relationship_127_FK on Manhole (
   BaseFacilityNum ASC
);

create index Relationship_120_FK on Manhole (
   AreaNum ASC
);

create index Relationship_15_FK on Manhole (
   bulid_CompanyNum ASC
);

create index Relationship_20_FK on Manhole (
   monitor_CompanyNum ASC
);

create index Relationship_181_FK on Manhole (
   EmployeeID ASC
);

create table ManholeCoverType  (
   ManholeCoverTypeID   INTEGER                         not null,
   ManholeCoverTypeName VARCHAR2(32)                    not null,
   constraint PK_MANHOLECOVERTYPE primary key (ManholeCoverTypeID)
);

comment on table ManholeCoverType is
'井盖
风楼';

comment on column ManholeCoverType.ManholeCoverTypeID is
'井口设施设施类型ID';

comment on column ManholeCoverType.ManholeCoverTypeName is
'井口设施设施类型名称';

create table ManholeKindType  (
   ManholeKindTypeID    INTEGER                         not null,
   ManholeTypeID        INTEGER                         not null,
   ManholeKindTypeName  VARCHAR2(32)                    not null,
   Prefix               VARCHAR2(8),
   LayerIcon            VARCHAR2(32),
   constraint PK_MANHOLEKINDTYPE primary key (ManholeKindTypeID)
);

comment on table ManholeKindType is
'电缆井：
直线井、
转角井、
四通井、
终端井……

虚拟井：
支架变动
电缆变动
出线变动

变电站出线

分接箱
杆塔
箱变
开闭所
';

comment on column ManholeKindType.ManholeKindTypeID is
'工井类型ID';

comment on column ManholeKindType.ManholeTypeID is
'工井性质类型ID';

comment on column ManholeKindType.ManholeKindTypeName is
'工井类型名称';

comment on column ManholeKindType.Prefix is
'编码前缀';

comment on column ManholeKindType.LayerIcon is
'图例资源名称';

create index Relationship_75_FK on ManholeKindType (
   ManholeTypeID ASC
);

create table ManholeOfSection  (
   Num                  INTEGER                         not null,
   SectionNum           INTEGER                         not null,
   AssetNum             INTEGER                         not null,
   OrderNum             INTEGER                         not null,
   constraint PK_MANHOLEOFSECTION primary key (Num)
);

comment on table ManholeOfSection is
'每个区段的起、止终端设施
可合并到通道区段（本次设计暂不改动）';

comment on column ManholeOfSection.Num is
'编号';

comment on column ManholeOfSection.SectionNum is
'沟道区段编号';

comment on column ManholeOfSection.AssetNum is
'资产编号';

comment on column ManholeOfSection.OrderNum is
'序号';

create index Relationship_83_FK on ManholeOfSection (
   SectionNum ASC
);

create index Relationship_84_FK on ManholeOfSection (
   AssetNum ASC
);

create table ManholeOfTunnel  (
   BuildOfTunnelNum     INTEGER                         not null,
   AssetNum             INTEGER                         not null,
   Man_AssetNum         INTEGER                         not null,
   IsEndpoint           SMALLINT                        not null,
   OrderNum             INTEGER                         not null,
   constraint PK_MANHOLEOFTUNNEL primary key (BuildOfTunnelNum)
);

comment on table ManholeOfTunnel is
'设施所属通道';

comment on column ManholeOfTunnel.BuildOfTunnelNum is
'沟道工井编号';

comment on column ManholeOfTunnel.AssetNum is
'资产编号';

comment on column ManholeOfTunnel.Man_AssetNum is
'终端设_资产编号';

comment on column ManholeOfTunnel.IsEndpoint is
'是否起止点';

comment on column ManholeOfTunnel.OrderNum is
'顺序编号';

create index Relationship_29_FK on ManholeOfTunnel (
   AssetNum ASC
);

create index Relationship_30_FK on ManholeOfTunnel (
   Man_AssetNum ASC
);

create table ManholeShapeType  (
   ManholeShapeTypeID   INTEGER                         not null,
   ManholeShapeTypeName VARCHAR2(32)                    not null,
   constraint PK_MANHOLESHAPETYPE primary key (ManholeShapeTypeID)
);

comment on table ManholeShapeType is
'工井形状类型';

comment on column ManholeShapeType.ManholeShapeTypeID is
'工井形状类型ID';

comment on column ManholeShapeType.ManholeShapeTypeName is
'工井形状类型名称';

create table ManholeStuffType  (
   ManholeStuffTypeID   INTEGER                         not null,
   ManholeStuffTypeName VARCHAR2(32),
   constraint PK_MANHOLESTUFFTYPE primary key (ManholeStuffTypeID)
);

comment on table ManholeStuffType is
'海泡石、
锚喷、
砖砌';

comment on column ManholeStuffType.ManholeStuffTypeID is
'工井材质类型ID';

comment on column ManholeStuffType.ManholeStuffTypeName is
'工井材质类型名称';

create table ManholeType  (
   ManholeTypeID        INTEGER                         not null,
   ManholeTypeName      VARCHAR2(32)                    not null,
   constraint PK_MANHOLETYPE primary key (ManholeTypeID)
);

comment on table ManholeType is
'电缆井
虚拟井
变电站（出线井）
终端设施';

comment on column ManholeType.ManholeTypeID is
'工井性质类型ID';

comment on column ManholeType.ManholeTypeName is
'工井性质类型名称';

create table MaxPrimaryKey  (
   TabName              VARCHAR2(64)                    not null,
   MaxVal               INTEGER                         not null,
   constraint PK_MAXPRIMARYKEY primary key (TabName)
);

comment on table MaxPrimaryKey is
'主键ID表';

comment on column MaxPrimaryKey.TabName is
'表名';

comment on column MaxPrimaryKey.MaxVal is
'当前最大值';

create table OperationLog  (
   LogNum               INTEGER                         not null,
   TypeID               INTEGER                         not null,
   EmployeeID           VARCHAR2(16)                    not null,
   Content              VARCHAR2(255)                   not null,
   LogDateTime          DATE                            not null,
   constraint PK_OPERATIONLOG primary key (LogNum)
);

comment on table OperationLog is
'操作日志';

comment on column OperationLog.LogNum is
'记录编号';

comment on column OperationLog.TypeID is
'操作类型ID';

comment on column OperationLog.EmployeeID is
'用户ID';

comment on column OperationLog.Content is
'操作描述';

comment on column OperationLog.LogDateTime is
'日志时间';

create index Relationship_106_FK on OperationLog (
   TypeID ASC
);

create index R_112_FK on OperationLog (
   EmployeeID ASC
);

create table OperationType  (
   TypeID               INTEGER                         not null,
   TypeName             VARCHAR2(16)                    not null,
   constraint PK_OPERATIONTYPE primary key (TypeID)
);

comment on table OperationType is
'操作类型';

comment on column OperationType.TypeID is
'操作类型ID';

comment on column OperationType.TypeName is
'操作类型名称';

create table Organization  (
   OrganizationNum      INTEGER                         not null,
   ParentID             INTEGER,
   TeamTypeID           INTEGER,
   OrganizationName     VARCHAR2(64)                    not null,
   Description          VARCHAR2(32),
   Visible              SMALLINT,
   constraint PK_ORGANIZATION primary key (OrganizationNum)
);

comment on table Organization is
'单位/车间/班组';

comment on column Organization.OrganizationNum is
'单位编号';

comment on column Organization.ParentID is
'单位/_单位编号';

comment on column Organization.TeamTypeID is
'专业类型ID';

comment on column Organization.OrganizationName is
'名称';

comment on column Organization.Description is
'描述';

comment on column Organization.Visible is
'是否可见';

create index R_21_FK on Organization (
   ParentID ASC
);

create index Relationship_64_FK on Organization (
   TeamTypeID ASC
);

create table PathAduitRecord  (
   AcceptRecordNum      INTEGER                         not null,
   TaskStatusTypeID     INTEGER                         not null,
   Num                  INTEGER                         not null,
   EmployeeID           VARCHAR2(16)                    not null,
   Task_EmployeeID      VARCHAR2(16)                    not null,
   PlanName             VARCHAR2(255)                   not null,
   WorkBillsCode        VARCHAR2(32),
   PlanDate             DATE                            not null,
   AcceptUserList       VARCHAR2(255),
   AcceptOpinion        VARCHAR2(255),
   AcceptDate           DATE,
   AuditResult          VARCHAR2(255),
   AuditDate            DATE,
   constraint PK_PATHADUITRECORD primary key (AcceptRecordNum)
);

comment on table PathAduitRecord is
'线路验收记录';

comment on column PathAduitRecord.AcceptRecordNum is
'验收记录编号';

comment on column PathAduitRecord.TaskStatusTypeID is
'任务状态ID';

comment on column PathAduitRecord.Num is
'档案编号';

comment on column PathAduitRecord.EmployeeID is
'任务创建人ID';

comment on column PathAduitRecord.Task_EmployeeID is
'工作负责人ID';

comment on column PathAduitRecord.PlanName is
'作业名称';

comment on column PathAduitRecord.WorkBillsCode is
'二卡票号';

comment on column PathAduitRecord.PlanDate is
'验收计划时间';

comment on column PathAduitRecord.AcceptUserList is
'验收人员名单';

comment on column PathAduitRecord.AcceptOpinion is
'验收意见';

comment on column PathAduitRecord.AcceptDate is
'验收时间';

comment on column PathAduitRecord.AuditResult is
'审核意见';

comment on column PathAduitRecord.AuditDate is
'审核时间';

create index Relationship_148_FK on PathAduitRecord (
   Num ASC
);

create index Relationship_162_FK on PathAduitRecord (
   EmployeeID ASC
);

create index Relationship_151_FK on PathAduitRecord (
   TaskStatusTypeID ASC
);

create index Relationship_166_FK on PathAduitRecord (
   Task_EmployeeID ASC
);

create table PathArchivesFile  (
   ArchivesFileNum      INTEGER                         not null,
   Num                  INTEGER                         not null,
   ArchivesFileTypeID   INTEGER,
   AcceptRecordNum      INTEGER,
   EmployeeID           VARCHAR2(16),
   ArchivesFileName     VARCHAR2(64)                    not null,
   ArchivesFilePath     VARCHAR2(255)                   not null,
   ArchivesFileUpDate   DATE,
   constraint PK_PATHARCHIVESFILE primary key (ArchivesFileNum)
);

comment on table PathArchivesFile is
'线路档案附件';

comment on column PathArchivesFile.ArchivesFileNum is
'文件记录编号';

comment on column PathArchivesFile.Num is
'档案编号';

comment on column PathArchivesFile.ArchivesFileTypeID is
'文件类型ID';

comment on column PathArchivesFile.AcceptRecordNum is
'验收记录编号';

comment on column PathArchivesFile.EmployeeID is
'用户ID';

comment on column PathArchivesFile.ArchivesFileName is
'文件名称';

comment on column PathArchivesFile.ArchivesFilePath is
'文件存放路径';

comment on column PathArchivesFile.ArchivesFileUpDate is
'提交时间';

create index Relationship_145_FK on PathArchivesFile (
   Num ASC
);

create index Relationship_146_FK on PathArchivesFile (
   ArchivesFileTypeID ASC
);

create index Relationship_163_FK on PathArchivesFile (
   EmployeeID ASC
);

create index Relationship_149_FK on PathArchivesFile (
   AcceptRecordNum ASC
);

create table PathArchivesFileType  (
   ArchivesFileTypeID   INTEGER                         not null,
   ArchivesFileTypeName VARCHAR2(64)                    not null,
   constraint PK_PATHARCHIVESFILETYPE primary key (ArchivesFileTypeID)
);

comment on table PathArchivesFileType is
'线路档案附件类型';

comment on column PathArchivesFileType.ArchivesFileTypeID is
'文件类型ID';

comment on column PathArchivesFileType.ArchivesFileTypeName is
'文件类型名称';

create table PathCable  (
   CableNum             INTEGER                         not null,
   PhaseTypeID          INTEGER                         not null,
   ModelTypeNum         INTEGER,
   LoopNum              INTEGER                         not null,
   CableName            VARCHAR2(96),
   RunCode              VARCHAR2(32),
   RunDate              DATE,
   IsExpEarthLine       SMALLINT,
   constraint PK_PATHCABLE primary key (CableNum)
);

comment on table PathCable is
'单相或三相混合电缆';

comment on column PathCable.CableNum is
'电缆编号';

comment on column PathCable.PhaseTypeID is
'相位类型ID';

comment on column PathCable.ModelTypeNum is
'规格编号';

comment on column PathCable.LoopNum is
'回路编号';

comment on column PathCable.CableName is
'电缆名称';

comment on column PathCable.RunCode is
'运行编号';

comment on column PathCable.RunDate is
'投运时间';

comment on column PathCable.IsExpEarthLine is
'接地引出';

create index Relationship_96_FK on PathCable (
   PhaseTypeID ASC
);

create index Relationship_116_FK on PathCable (
   LoopNum ASC
);

create index Relationship_144_FK on PathCable (
   ModelTypeNum ASC
);

create table PathSection  (
   PathSectionNum       INTEGER                         not null,
   CablePathNum         INTEGER,
   SafeEarthTypeID      INTEGER,
   InstallTypeID        INTEGER,
   ParentSectionNum     INTEGER,
   BaseFacilityNum      INTEGER,
   begin_AssetNum       INTEGER,
   end_AssetNum         INTEGER,
   PathSectionCode      VARCHAR2(64),
   PathSectionName      VARCHAR2(255),
   PlaceInfo            VARCHAR2(255),
   PlaceInfo2           VARCHAR2(255),
   LoopCount            INTEGER,
   LineCount            INTEGER,
   LoopLenght           FLOAT,
   IsExpEarthLine       SMALLINT,
   EarthConnectorType   VARCHAR2(32),
   Memo                 VARCHAR2(512),
   constraint PK_PATHSECTION primary key (PathSectionNum)
);

comment on table PathSection is
'线路段';

comment on column PathSection.PathSectionNum is
'编号';

comment on column PathSection.CablePathNum is
'线路编号';

comment on column PathSection.SafeEarthTypeID is
'接地方式类型ID';

comment on column PathSection.InstallTypeID is
'敷设类型ID';

comment on column PathSection.ParentSectionNum is
'线路段_父编号';

comment on column PathSection.BaseFacilityNum is
'设施编号';

comment on column PathSection.begin_AssetNum is
'起点设施编号';

comment on column PathSection.end_AssetNum is
'止点设施编号';

comment on column PathSection.PathSectionCode is
'线路段编码';

comment on column PathSection.PathSectionName is
'线路段名称';

comment on column PathSection.PlaceInfo is
'起点说明';

comment on column PathSection.PlaceInfo2 is
'止点说明';

comment on column PathSection.LoopCount is
'回数';

comment on column PathSection.LineCount is
'条数';

comment on column PathSection.LoopLenght is
'回长';

comment on column PathSection.IsExpEarthLine is
'接地引出';

comment on column PathSection.EarthConnectorType is
'接地引出类型';

comment on column PathSection.Memo is
'备注';

create index Relationship_125_FK on PathSection (
   CablePathNum ASC
);

create index Relationship_102_FK on PathSection (
   begin_AssetNum ASC
);

create index Relationship_113_FK on PathSection (
   end_AssetNum ASC
);

create index R_126_FK on PathSection (
   SafeEarthTypeID ASC
);

create index Relationship_134_FK on PathSection (
   InstallTypeID ASC
);

create index Relationship_171_FK on PathSection (
   BaseFacilityNum ASC
);

create index Relationship_205_FK on PathSection (
   ParentSectionNum ASC
);

create table PathSectionRunStatusRecord  (
   StatusRecordNum      INTEGER                         not null,
   LoopNum              INTEGER,
   StatusDate           DATE                            not null,
   Reason               VARCHAR2(255),
   constraint PK_PATHSECTIONRUNSTATUSRECORD primary key (StatusRecordNum)
);

comment on table PathSectionRunStatusRecord is
'线路段投运状态记录';

comment on column PathSectionRunStatusRecord.StatusRecordNum is
'状态记录编号';

comment on column PathSectionRunStatusRecord.LoopNum is
'回路编号';

comment on column PathSectionRunStatusRecord.StatusDate is
'状态变化时间';

comment on column PathSectionRunStatusRecord.Reason is
'状态变化原因';

create index Relationship_192_FK on PathSectionRunStatusRecord (
   LoopNum ASC
);

create table PathType  (
   PathTypeID           INTEGER                         not null,
   PathTypeName         VARCHAR2(32)                    not null,
   constraint PK_PATHTYPE primary key (PathTypeID)
);

comment on table PathType is
'变电（特指变电站内线路，不按电压区分）
输电
配电';

comment on column PathType.PathTypeID is
'线路类型ID';

comment on column PathType.PathTypeName is
'线路类型名称';

create table PhaseType  (
   PhaseTypeID          INTEGER                         not null,
   PhaseTypeName        VARCHAR2(32)                    not null,
   IsEarthPhase         SMALLINT                        not null,
   PhaseColor           VARCHAR2(16)                    not null,
   constraint PK_PHASETYPE primary key (PhaseTypeID)
);

comment on table PhaseType is
'A
B
C
Earth
Mix';

comment on column PhaseType.PhaseTypeID is
'相位类型ID';

comment on column PhaseType.PhaseTypeName is
'相位类型名称';

comment on column PhaseType.IsEarthPhase is
'是否地线';

comment on column PhaseType.PhaseColor is
'颜色';

create table PowerCableLevel  (
   VoltageLevelID       INTEGER                         not null,
   VoltageLevelName     VARCHAR2(32)                    not null,
   VoltageValue         INTEGER,
   ShowColor            VARCHAR2(8),
   constraint PK_POWERCABLELEVEL primary key (VoltageLevelID)
);

comment on table PowerCableLevel is
'6kV
10kV
35kV
110KV
220KV
其他';

comment on column PowerCableLevel.VoltageLevelID is
'电压等级ID';

comment on column PowerCableLevel.VoltageLevelName is
'电压等级名称';

comment on column PowerCableLevel.VoltageValue is
'电压值';

comment on column PowerCableLevel.ShowColor is
'显示颜色';

create table PowerLevelTunnelColor  (
   LevelTunnelNum       INTEGER                         not null,
   VoltageLevelID       INTEGER                         not null,
   TunnelStructureTypeID INTEGER                         not null,
   LevelTunnelName      VARCHAR2(64)                    not null,
   ShowColor            VARCHAR2(8),
   LineWidth            INTEGER,
   constraint PK_POWERLEVELTUNNELCOLOR primary key (LevelTunnelNum)
);

comment on table PowerLevelTunnelColor is
'通道电压等级类型颜色表';

comment on column PowerLevelTunnelColor.LevelTunnelNum is
'通道等级编号';

comment on column PowerLevelTunnelColor.VoltageLevelID is
'电压等级ID';

comment on column PowerLevelTunnelColor.TunnelStructureTypeID is
'沟道结构类型ID';

comment on column PowerLevelTunnelColor.LevelTunnelName is
'电压等级通道名称';

comment on column PowerLevelTunnelColor.ShowColor is
'显示颜色';

comment on column PowerLevelTunnelColor.LineWidth is
'线径';

create index R_152_FK on PowerLevelTunnelColor (
   TunnelStructureTypeID ASC
);

create index R_153_FK on PowerLevelTunnelColor (
   VoltageLevelID ASC
);

create table PowerLoop  (
   LoopNum              INTEGER                         not null,
   PathSectionNum       INTEGER                         not null,
   AttachmentStatusTypeID INTEGER,
   LoopName             VARCHAR2(255),
   RunCode              VARCHAR2(32),
   RunDate              DATE,
   constraint PK_POWERLOOP primary key (LoopNum)
);

comment on table PowerLoop is
'每回包括三相电缆
隐含一个接地回路';

comment on column PowerLoop.LoopNum is
'回路编号';

comment on column PowerLoop.PathSectionNum is
'编号';

comment on column PowerLoop.AttachmentStatusTypeID is
'状态ID';

comment on column PowerLoop.LoopName is
'回路名称';

comment on column PowerLoop.RunCode is
'运行编号';

comment on column PowerLoop.RunDate is
'投运时间';

create index Relationship_104_FK on PowerLoop (
   PathSectionNum ASC
);

create index Relationship_190_FK on PowerLoop (
   AttachmentStatusTypeID ASC
);

create table PowerTunnel  (
   AssetNum             INTEGER                         not null,
   VoltageLevelID       INTEGER,
   monitor_CompanyNum   INTEGER,
   ArchivesNum          INTEGER,
   TunnelStuffTypeID    INTEGER,
   EmployeeID           VARCHAR2(16),
   bulid_CompanyNum     INTEGER,
   TunnelShapeTypeID    INTEGER                         not null,
   AreaNum              INTEGER,
   TrestleTypeInfoID    INTEGER,
   OrganizationNum      INTEGER,
   TunnelStructureTypeID INTEGER                         not null,
   AssetName            VARCHAR2(255),
   AssetCode            VARCHAR2(64),
   GraphID              INTEGER,
   OperationCode        VARCHAR2(32),
   BuildDate            DATE,
   CompletedDate        DATE,
   OperationDate        DATE,
   PositionDescription  VARCHAR2(512),
   Ass_Longitude        FLOAT,
   Ass_Latitude         FLOAT,
   Memo                 VARCHAR2(512),
   TunnelLength         FLOAT                           not null,
   TunnelHeight         FLOAT,
   TunnelWidth          FLOAT,
   Diameter             FLOAT,
   FrontTopHeight       FLOAT,
   TailTopHeight        FLOAT,
   Latitude             FLOAT,
   Longitude            FLOAT,
   TrestleInterval      FLOAT,
   TrestleTypeDescription VARCHAR2(64),
   StartStopDescription VARCHAR2(512),
   IsPlan               SMALLINT,
   constraint PK_POWERTUNNEL primary key (AssetNum)
);

comment on table PowerTunnel is
'隧道/顶管
排管
沟槽
直埋
';

comment on column PowerTunnel.AssetNum is
'资产编号';

comment on column PowerTunnel.VoltageLevelID is
'电压等级ID';

comment on column PowerTunnel.monitor_CompanyNum is
'监理_单位编号';

comment on column PowerTunnel.ArchivesNum is
'档案记录编号';

comment on column PowerTunnel.TunnelStuffTypeID is
'材质类型ID';

comment on column PowerTunnel.EmployeeID is
'用户ID';

comment on column PowerTunnel.bulid_CompanyNum is
'施工_单位编号';

comment on column PowerTunnel.TunnelShapeTypeID is
'沟道形状ID';

comment on column PowerTunnel.AreaNum is
'片区编号';

comment on column PowerTunnel.TrestleTypeInfoID is
'描述类型ID';

comment on column PowerTunnel.OrganizationNum is
'所属班组';

comment on column PowerTunnel.TunnelStructureTypeID is
'沟道结构类型ID';

comment on column PowerTunnel.AssetName is
'资产名称';

comment on column PowerTunnel.AssetCode is
'资产编码';

comment on column PowerTunnel.GraphID is
'图元ID';

comment on column PowerTunnel.OperationCode is
'运行编码';

comment on column PowerTunnel.BuildDate is
'施工日期';

comment on column PowerTunnel.CompletedDate is
'竣工日期';

comment on column PowerTunnel.OperationDate is
'投运日期';

comment on column PowerTunnel.PositionDescription is
'所在方位';

comment on column PowerTunnel.Ass_Longitude is
'资产对_经度';

comment on column PowerTunnel.Ass_Latitude is
'资产对_纬度';

comment on column PowerTunnel.Memo is
'备注';

comment on column PowerTunnel.TunnelLength is
'长度';

comment on column PowerTunnel.TunnelHeight is
'高度';

comment on column PowerTunnel.TunnelWidth is
'宽度';

comment on column PowerTunnel.Diameter is
'直径';

comment on column PowerTunnel.FrontTopHeight is
'覆土深度';

comment on column PowerTunnel.TailTopHeight is
'末端覆土深度';

comment on column PowerTunnel.Latitude is
'止点经度';

comment on column PowerTunnel.Longitude is
'止点纬度';

comment on column PowerTunnel.TrestleInterval is
'支架间距';

comment on column PowerTunnel.TrestleTypeDescription is
'支架规格描述';

comment on column PowerTunnel.StartStopDescription is
'起止地点';

comment on column PowerTunnel.IsPlan is
'是否规划状态';

create index Relationship_16_FK on PowerTunnel (
   TunnelStructureTypeID ASC
);

create index Relationship_17_FK on PowerTunnel (
   TunnelShapeTypeID ASC
);

create index Relationship_18_FK on PowerTunnel (
   TunnelStuffTypeID ASC
);

create index Relationship_19_FK on PowerTunnel (
   AreaNum ASC
);

create index Relationship_26_FK on PowerTunnel (
   TrestleTypeInfoID ASC
);

create index Relationship_70_FK on PowerTunnel (
   ArchivesNum ASC
);

create index R_73_FK on PowerTunnel (
   OrganizationNum ASC
);

create index Relationship_128_FK on PowerTunnel (
   VoltageLevelID ASC
);

create index Relationship_13_FK on PowerTunnel (
   bulid_CompanyNum ASC
);

create index Relationship_14_FK on PowerTunnel (
   monitor_CompanyNum ASC
);

create index Relationship_170_FK on PowerTunnel (
   EmployeeID ASC
);

create table ProjectType  (
   ProjectTypeID        INTEGER                         not null,
   ProjectTypeName      VARCHAR2(32)                    not null,
   constraint PK_PROJECTTYPE primary key (ProjectTypeID)
);

comment on table ProjectType is
'工程性质
小区配套、大修、技改、迁改';

comment on column ProjectType.ProjectTypeID is
'工程类型ID';

comment on column ProjectType.ProjectTypeName is
'工程类型名称';

create table RoleFunctions  (
   RoleFunctionID       INTEGER                         not null,
   RoleNum              INTEGER                         not null,
   ApplicationModuleID  INTEGER                         not null,
   constraint PK_ROLEFUNCTIONS primary key (RoleFunctionID)
);

comment on table RoleFunctions is
'模块角色关系表';

comment on column RoleFunctions.RoleFunctionID is
'权限ID';

comment on column RoleFunctions.RoleNum is
'角色编号';

comment on column RoleFunctions.ApplicationModuleID is
'功能ID';

create index R_108_FK on RoleFunctions (
   RoleNum ASC
);

create index Relationship_72_FK on RoleFunctions (
   ApplicationModuleID ASC
);

create table Roles  (
   RoleNum              INTEGER                         not null,
   RoleName             VARCHAR2(32),
   "Comment"            VARCHAR2(64),
   constraint PK_ROLES primary key (RoleNum)
);

comment on table Roles is
'角色';

comment on column Roles.RoleNum is
'角色编号';

comment on column Roles.RoleName is
'角色名称';

comment on column Roles."Comment" is
'角色描述';

create table RowTube  (
   RowTubeNum           INTEGER                         not null,
   RowTubeTypeID        INTEGER                         not null,
   TrestleLayerNum      INTEGER                         not null,
   RowTubeOrder         INTEGER                         not null,
   constraint PK_ROWTUBE primary key (RowTubeNum)
);

comment on table RowTube is
'位置，
东西方向以从东向西为朝向，从左向右计算顺序
南北方向以从南向北为朝向，从左向右计算顺序
';

comment on column RowTube.RowTubeNum is
'排管编号';

comment on column RowTube.RowTubeTypeID is
'规格编号';

comment on column RowTube.TrestleLayerNum is
'层级编号';

comment on column RowTube.RowTubeOrder is
'位置顺序';

create index Relationship_76_FK on RowTube (
   RowTubeTypeID ASC
);

create index Relationship_98_FK on RowTube (
   TrestleLayerNum ASC
);

create table RowTubeType  (
   RowTubeTypeID        INTEGER                         not null,
   RowTubeTypeName      VARCHAR2(64),
   RowTubeDiameter      FLOAT,
   constraint PK_ROWTUBETYPE primary key (RowTubeTypeID)
);

comment on table RowTubeType is
'150
175';

comment on column RowTubeType.RowTubeTypeID is
'规格编号';

comment on column RowTubeType.RowTubeTypeName is
'规格说明';

comment on column RowTubeType.RowTubeDiameter is
'直径';

create table RunRecord  (
   RecordNum            INTEGER                         not null,
   AttachmentStatusTypeID INTEGER,
   AttachmentNum        INTEGER                         not null,
   RecordDate           DATE                            not null,
   Reason               VARCHAR2(255),
   constraint PK_RUNRECORD primary key (RecordNum)
);

comment on table RunRecord is
'电缆设施投运退运记录';

comment on column RunRecord.RecordNum is
'记录编号';

comment on column RunRecord.AttachmentStatusTypeID is
'状态ID';

comment on column RunRecord.AttachmentNum is
'电缆附件编号';

comment on column RunRecord.RecordDate is
'时间';

comment on column RunRecord.Reason is
'状态变化原因';

create index Relationship_138_FK on RunRecord (
   AttachmentNum ASC
);

create index Relationship_140_FK on RunRecord (
   AttachmentStatusTypeID ASC
);

create table SafeBoxType  (
   SafeBoxTypeID        INTEGER                         not null,
   SafeBoxTypeName      VARCHAR2(32)                    not null,
   constraint PK_SAFEBOXTYPE primary key (SafeBoxTypeID)
);

comment on table SafeBoxType is
'未安装
防水
不防水';

comment on column SafeBoxType.SafeBoxTypeID is
'类型ID';

comment on column SafeBoxType.SafeBoxTypeName is
'类型名称';

create table SafeEarthType  (
   SafeEarthTypeID      INTEGER                         not null,
   SafeEarthTypeName    VARCHAR2(64)                    not null,
   constraint PK_SAFEEARTHTYPE primary key (SafeEarthTypeID)
);

comment on table SafeEarthType is
'直接接地
一端接地
保护接地';

comment on column SafeEarthType.SafeEarthTypeID is
'接地方式类型ID';

comment on column SafeEarthType.SafeEarthTypeName is
'接地方式类型名称';

create table TaskStatusType  (
   TaskStatusTypeID     INTEGER                         not null,
   TaskStatusTypeName   VARCHAR2(255)                   not null,
   constraint PK_TASKSTATUSTYPE primary key (TaskStatusTypeID)
);

comment on table TaskStatusType is
'任务状态
计划状态、执行状态、完成状态';

comment on column TaskStatusType.TaskStatusTypeID is
'任务状态ID';

comment on column TaskStatusType.TaskStatusTypeName is
'任务状态名称';

create table TeamType  (
   TeamTypeID           INTEGER                         not null,
   TeamTypeName         VARCHAR2(32)                    not null,
   constraint PK_TEAMTYPE primary key (TeamTypeID)
);

comment on table TeamType is
'专业类型
沟道、输电、配电
';

comment on column TeamType.TeamTypeID is
'专业类型ID';

comment on column TeamType.TeamTypeName is
'专业类型名称';

create table TerminalFile  (
   FileNum              INTEGER                         not null,
   EmployeeID           VARCHAR2(16),
   AssetNum             INTEGER                         not null,
   FileName             VARCHAR2(255)                   not null,
   FilePath             CLOB                            not null,
   UpdateDate           DATE                            not null,
   constraint PK_TERMINALFILE primary key (FileNum)
);

comment on table TerminalFile is
'照片、图纸、方案';

comment on column TerminalFile.FileNum is
'附件文件编号';

comment on column TerminalFile.EmployeeID is
'用户ID';

comment on column TerminalFile.AssetNum is
'资产编号';

comment on column TerminalFile.FileName is
'附件文件名称';

comment on column TerminalFile.FilePath is
'文件位置';

comment on column TerminalFile.UpdateDate is
'上传时间';

create index Relationship_141_FK on TerminalFile (
   AssetNum ASC
);

create index Relationship_143_FK on TerminalFile (
   EmployeeID ASC
);

create table TrestleDirectionType  (
   TrestlePositionTypeID INTEGER                         not null,
   TrestlePositionTypeName VARCHAR2(32)                    not null,
   constraint PK_TRESTLEDIRECTIONTYPE primary key (TrestlePositionTypeID)
);

comment on table TrestleDirectionType is
'左侧支架
右侧支架
横跨支架

支架方位由沟道区段走向确定
区段走向分为东西、南北
东西走向的支架方位为人由东向西方向，左侧为南侧，右侧为北侧
南北走向的支架方位为人由南向北方向，左侧为西侧，右侧为东侧';

comment on column TrestleDirectionType.TrestlePositionTypeID is
'支架位置类型ID';

comment on column TrestleDirectionType.TrestlePositionTypeName is
'支架位置类型名称';

create table TrestleLayer  (
   TrestleLayerNum      INTEGER                         not null,
   TrestlePositionTypeID INTEGER                         not null,
   VoltageLevelID       INTEGER,
   SectionNum           INTEGER                         not null,
   TrestleStuffTypeID   INTEGER,
   Layer                INTEGER,
   TrestleLength        FLOAT,
   Height               FLOAT,
   Memo                 VARCHAR2(255),
   constraint PK_TRESTLELAYER primary key (TrestleLayerNum)
);

comment on table TrestleLayer is
'支架层高用于描述支架离地面的高度
备注用于说明支架层的特殊情况。';

comment on column TrestleLayer.TrestleLayerNum is
'层级编号';

comment on column TrestleLayer.TrestlePositionTypeID is
'支架位置类型ID';

comment on column TrestleLayer.VoltageLevelID is
'电压等级ID';

comment on column TrestleLayer.SectionNum is
'沟道区段编号';

comment on column TrestleLayer.TrestleStuffTypeID is
'支架材质类型ID';

comment on column TrestleLayer.Layer is
'层级';

comment on column TrestleLayer.TrestleLength is
'支架长度';

comment on column TrestleLayer.Height is
'层高';

comment on column TrestleLayer.Memo is
'备注';

create index Relationship_25_FK on TrestleLayer (
   TrestlePositionTypeID ASC
);

create index Relationship_42_FK on TrestleLayer (
   VoltageLevelID ASC
);

create index Relationship_77_FK on TrestleLayer (
   SectionNum ASC
);

create index R_117_FK on TrestleLayer (
   TrestleStuffTypeID ASC
);

create table TrestleStuffType  (
   TrestleStuffTypeID   INTEGER                         not null,
   TrestleStuffTypeName VARCHAR2(16)                    not null,
   constraint PK_TRESTLESTUFFTYPE primary key (TrestleStuffTypeID)
);

comment on table TrestleStuffType is
'支架材质类型';

comment on column TrestleStuffType.TrestleStuffTypeID is
'支架材质类型ID';

comment on column TrestleStuffType.TrestleStuffTypeName is
'支架材质类型名称';

create table TrestleTypeInfo  (
   TrestleTypeInfoID    INTEGER                         not null,
   TrestleTypeInfoName  VARCHAR2(32)                    not null,
   constraint PK_TRESTLETYPEINFO primary key (TrestleTypeInfoID)
);

comment on table TrestleTypeInfo is
'金属双侧、金属单侧、丰字支架……';

comment on column TrestleTypeInfo.TrestleTypeInfoID is
'描述类型ID';

comment on column TrestleTypeInfo.TrestleTypeInfoName is
'描述类型名称';

create table TunnelAduitRecord  (
   AcceptRecordNum      INTEGER                         not null,
   ArchivesNum          INTEGER                         not null,
   TaskStatusTypeID     INTEGER                         not null,
   EmployeeID           VARCHAR2(16)                    not null,
   Task_EmployeeID      VARCHAR2(16)                    not null,
   PlanName             VARCHAR2(255)                   not null,
   WorkBillsCode        VARCHAR2(32),
   PlanDate             DATE                            not null,
   AcceptUserList       VARCHAR2(255),
   AcceptOpinion        VARCHAR2(255),
   AcceptDate           DATE,
   AuditResult          VARCHAR2(255),
   AuditDate            DATE,
   constraint PK_TUNNELADUITRECORD primary key (AcceptRecordNum)
);

comment on table TunnelAduitRecord is
'通道验收记录';

comment on column TunnelAduitRecord.AcceptRecordNum is
'验收记录编号';

comment on column TunnelAduitRecord.ArchivesNum is
'档案记录编号';

comment on column TunnelAduitRecord.TaskStatusTypeID is
'任务状态ID';

comment on column TunnelAduitRecord.EmployeeID is
'任务创建人ID';

comment on column TunnelAduitRecord.Task_EmployeeID is
'工作负责人ID';

comment on column TunnelAduitRecord.PlanName is
'作业名称';

comment on column TunnelAduitRecord.WorkBillsCode is
'二卡票号';

comment on column TunnelAduitRecord.PlanDate is
'验收计划时间';

comment on column TunnelAduitRecord.AcceptUserList is
'验收人员名单';

comment on column TunnelAduitRecord.AcceptOpinion is
'验收意见';

comment on column TunnelAduitRecord.AcceptDate is
'验收时间';

comment on column TunnelAduitRecord.AuditResult is
'审核意见';

comment on column TunnelAduitRecord.AuditDate is
'审核时间';

create index Relationship_57_FK on TunnelAduitRecord (
   ArchivesNum ASC
);

create index Relationship_135_FK on TunnelAduitRecord (
   Task_EmployeeID ASC
);

create index Relationship_132_FK on TunnelAduitRecord (
   TaskStatusTypeID ASC
);

create index Relationship_155_FK on TunnelAduitRecord (
   EmployeeID ASC
);

create table TunnelArchivesFile  (
   ArchivesFileNum      INTEGER                         not null,
   EmployeeID           VARCHAR2(16),
   AcceptRecordNum      INTEGER,
   ArchivesNum          INTEGER                         not null,
   ArchivesFileTypeID   INTEGER                         not null,
   ArchivesFileName     VARCHAR2(128)                   not null,
   ArchivesFilePath     VARCHAR2(512)                   not null,
   ArchivesFileUpDate   DATE,
   constraint PK_TUNNELARCHIVESFILE primary key (ArchivesFileNum)
);

comment on table TunnelArchivesFile is
'通道档案附件';

comment on column TunnelArchivesFile.ArchivesFileNum is
'文件记录编号';

comment on column TunnelArchivesFile.EmployeeID is
'用户ID';

comment on column TunnelArchivesFile.AcceptRecordNum is
'验收记录编号';

comment on column TunnelArchivesFile.ArchivesNum is
'档案记录编号';

comment on column TunnelArchivesFile.ArchivesFileTypeID is
'文件分类ID';

comment on column TunnelArchivesFile.ArchivesFileName is
'文件名称';

comment on column TunnelArchivesFile.ArchivesFilePath is
'文件存放路径';

comment on column TunnelArchivesFile.ArchivesFileUpDate is
'提交时间';

create index Relationship_53_FK on TunnelArchivesFile (
   ArchivesNum ASC
);

create index Relationship_54_FK on TunnelArchivesFile (
   ArchivesFileTypeID ASC
);

create index Relationship_123_FK on TunnelArchivesFile (
   AcceptRecordNum ASC
);

create index Relationship_142_FK on TunnelArchivesFile (
   EmployeeID ASC
);

create table TunnelSection  (
   SectionNum           INTEGER                         not null,
   TunnleTowardTypeID   INTEGER                         not null,
   AssetNum             INTEGER                         not null,
   Length               FLOAT                           not null,
   OrderNum             INTEGER                         not null,
   FrontTopHeight       FLOAT,
   TailTopHeight        FLOAT,
   constraint PK_TUNNELSECTION primary key (SectionNum)
);

comment on table TunnelSection is
'通道区段';

comment on column TunnelSection.SectionNum is
'沟道区段编号';

comment on column TunnelSection.TunnleTowardTypeID is
'走向类型ID';

comment on column TunnelSection.AssetNum is
'资产编号';

comment on column TunnelSection.Length is
'区段长度';

comment on column TunnelSection.OrderNum is
'顺序编号';

comment on column TunnelSection.FrontTopHeight is
'首端覆土深度';

comment on column TunnelSection.TailTopHeight is
'末端覆土深度';

create index Relationship_66_FK on TunnelSection (
   AssetNum ASC
);

create index R_102_FK on TunnelSection (
   TunnleTowardTypeID ASC
);

create table TunnelShapeType  (
   TunnelShapeTypeID    INTEGER                         not null,
   TunnelShapeTypeName  VARCHAR2(32)                    not null,
   constraint PK_TUNNELSHAPETYPE primary key (TunnelShapeTypeID)
);

comment on table TunnelShapeType is
'马蹄形
方形
圆形
此表可不使用，用户按通道类型默认';

comment on column TunnelShapeType.TunnelShapeTypeID is
'沟道形状ID';

comment on column TunnelShapeType.TunnelShapeTypeName is
'沟道形状名称';

create table TunnelStructureType  (
   TunnelStructureTypeID INTEGER                         not null,
   TunnelStructureTypeName VARCHAR2(64),
   Prefix               VARCHAR2(8),
   ShowColor            VARCHAR2(8),
   LineWidth            INTEGER,
   constraint PK_TUNNELSTRUCTURETYPE primary key (TunnelStructureTypeID)
);

comment on table TunnelStructureType is
'隧道
顶管
排管
沟槽
直埋
';

comment on column TunnelStructureType.TunnelStructureTypeID is
'沟道结构类型ID';

comment on column TunnelStructureType.TunnelStructureTypeName is
'沟道结构类型名称';

comment on column TunnelStructureType.Prefix is
'编码前缀';

comment on column TunnelStructureType.ShowColor is
'显示颜色';

comment on column TunnelStructureType.LineWidth is
'线径';

create table TunnelStuffType  (
   TunnelStuffTypeID    INTEGER                         not null,
   TunnelStructureTypeID INTEGER,
   TunnelStuffTypeName  VARCHAR2(32)                    not null,
   constraint PK_TUNNELSTUFFTYPE primary key (TunnelStuffTypeID)
);

comment on table TunnelStuffType is
'海泡石、
锚喷、
砖砌';

comment on column TunnelStuffType.TunnelStuffTypeID is
'材质类型ID';

comment on column TunnelStuffType.TunnelStructureTypeID is
'沟道结构类型ID';

comment on column TunnelStuffType.TunnelStuffTypeName is
'材质类型名称';

create index Relationship_63_FK on TunnelStuffType (
   TunnelStructureTypeID ASC
);

create table TunnleTowardType  (
   TunnleTowardTypeID   INTEGER                         not null,
   TunnleTowardTypeName VARCHAR2(32)                    not null,
   constraint PK_TUNNLETOWARDTYPE primary key (TunnleTowardTypeID)
);

comment on table TunnleTowardType is
'东西
南北';

comment on column TunnleTowardType.TunnleTowardTypeID is
'走向类型ID';

comment on column TunnleTowardType.TunnleTowardTypeName is
'走向类型名称';

create table UserRoles  (
   UserRolesID          INTEGER                         not null,
   RoleNum              INTEGER                         not null,
   EmployeeID           VARCHAR2(16)                    not null,
   constraint PK_USERROLES primary key (UserRolesID)
);

comment on table UserRoles is
'用户角色表';

comment on column UserRoles.UserRolesID is
'用户角色权限ID';

comment on column UserRoles.RoleNum is
'角色编号';

comment on column UserRoles.EmployeeID is
'用户ID';

create index Relationship_193_FK on UserRoles (
   RoleNum ASC
);

create index Relationship_204_FK on UserRoles (
   EmployeeID ASC
);

alter table AccessFunction
   add constraint FK_ACCESSFU_R_113_ACCESSFU foreign key (ParentModuleID)
      references AccessFunction (ApplicationModuleID);

alter table AccessList
   add constraint FK_ACCESSLI_RELATIONS_EMPLOYEE foreign key (EmployeeID)
      references Employee (EmployeeID);

alter table Area
   add constraint FK_AREA_RELATIONS_AREATYPE foreign key (AreaTypeID)
      references AreaType (AreaTypeID);

alter table AttachmentModelType
   add constraint FK_ATTACHME_R_118_PATHTYPE foreign key (PathTypeID)
      references PathType (PathTypeID);

alter table AttachmentModelType
   add constraint FK_ATTACHME_R_78_CABLEATT foreign key (AttachmentTypeID)
      references CableAttachmentType (AttachmentTypeID);

alter table AttachmentOfCable
   add constraint FK_ATTACHME_R_120_PATHCABL foreign key (CableNum)
      references PathCable (CableNum);

alter table AttachmentOfCable
   add constraint FK_ATTACHME_R_CABLEATT foreign key (Cab_AttachmentNum)
      references CableAttachment (AttachmentNum);

alter table AttachmentOfCable
   add constraint FK_ATTACHME_RE_CABLEATT foreign key (Start_AttachmentNum)
      references CableAttachment (AttachmentNum);

alter table AttachmentOfCable
   add constraint FK_ATTACHME_RELATIONS_CABLEATT foreign key (End_AttachmentNum)
      references CableAttachment (AttachmentNum);

alter table BaseFacility
   add constraint FK_BASEFACI_RELATIONS_AREA foreign key (AreaNum)
      references Area (AreaNum);

alter table BranchBox
   add constraint FK_BRANCHBO_R_142_POWERCAB foreign key (VoltageLevelID)
      references PowerCableLevel (VoltageLevelID);

alter table BranchBox
   add constraint FK_BRANCHBO_RELATIONS_MANHOLE foreign key (AssetNum)
      references Manhole (AssetNum);

alter table BranchBox
   add constraint FK_BRANCHBO_RELATIONS_BRANCHBO foreign key (ModelNum)
      references BranchBoxModel (ModelNum);

alter table BusinessProcessInstantiate
   add constraint FK_BUSINESS_RELATIONS_BUSINESS foreign key (TemplateID)
      references BusinessProcessTemplate (TemplateID);

alter table BusinessProcessTemplate
   add constraint FK_BUSINESS_RELATIONS_ROLES foreign key (RoleNum)
      references Roles (RoleNum);

alter table CableAttachment
   add constraint FK_CABLEATT_R_110_PATHTYPE foreign key (PathTypeID)
      references PathType (PathTypeID);

alter table CableAttachment
   add constraint FK_CABLEATT_R_180_CABLEDEV foreign key (CableDeviceTypeID)
      references CableDeviceType (CableDeviceTypeID);

alter table CableAttachment
   add constraint FK_CABLEATT_R_91_ATTACHME foreign key (ModelTypeNum)
      references AttachmentModelType (ModelTypeNum);

alter table CableAttachment
   add constraint FK_CABLEATT_RE_CABLEDEV foreign key (Num)
      references CableDeviceLedger (Num);

alter table CableAttachment
   add constraint FK_CABLEATT_RELATIONS_FAULTIND foreign key (FaultIndicatorTypeID)
      references FaultIndicatorType (FaultIndicatorTypeID);

alter table CableAttachment
   add constraint FK_CABLEATT_RELATIONS_SAFEBOXT foreign key (SafeBoxTypeID)
      references SafeBoxType (SafeBoxTypeID);

alter table CableAttachment
   add constraint FK_CABLEATT_RELATIONS_ATTACHME foreign key (AttachmentStatusTypeID)
      references AttachmentStatusType (AttachmentStatusTypeID);

alter table CableAttachment
   add constraint FK_CABLEATT_RELATIONS_CABLEDEV foreign key (CableDeviceStyleID)
      references CableDeviceStyle (CableDeviceStyleID);

alter table CableAttachment
   add constraint FK_CABLEATT_RELATIONS_CABLEATT foreign key (AttachmentTypeID)
      references CableAttachmentType (AttachmentTypeID);

alter table CableAttachment
   add constraint FK_CABLEATT_RELATIONS_COMPANY foreign key (CompanyNum)
      references Company (CompanyNum);

alter table CableDeviceLedger
   add constraint FK_CABLEDEV_R_135_POWERCAB foreign key (VoltageLevelID)
      references PowerCableLevel (VoltageLevelID);

alter table CableDeviceLedger
   add constraint FK_CABLEDEV_R_136_PROJECTT foreign key (ProjectTypeID)
      references ProjectType (ProjectTypeID);

alter table CableDeviceLedger
   add constraint FK_CABLEDEV_RELATIONS_PATHTYPE foreign key (PathTypeID)
      references PathType (PathTypeID);

alter table CableDeviceLedger
   add constraint FK_CABLEDEV_RELATIONS_ACCEPTST foreign key (AcceptStatusTypeID)
      references AcceptStatusType (AcceptStatusTypeID);

alter table CableDeviceLedger
   add constraint FK_CABLEDEV_RELATIONS_EMPLOYEE foreign key (EmployeeID)
      references Employee (EmployeeID);

alter table CableDeviceStyle
   add constraint FK_CABLEDEV__CABLEATT foreign key (AttachmentTypeID)
      references CableAttachmentType (AttachmentTypeID);

alter table CableDeviceStyle
   add constraint FK_CABLEDEV_R_PATHTYPE foreign key (PathTypeID)
      references PathType (PathTypeID);

alter table CableDeviceType
   add constraint FK_CABLEDEV_RELATIONS_CABLEATT foreign key (AttachmentTypeID)
      references CableAttachmentType (AttachmentTypeID);

alter table CableDeviceType
   add constraint FK_CABLEDEV_PATHTYPE foreign key (PathTypeID)
      references PathType (PathTypeID);

alter table CableOfSection
   add constraint FK_CABLEOFS_R_99_ROWTUBE foreign key (RowTubeNum)
      references RowTube (RowTubeNum);

alter table CableOfSection
   add constraint FK_CABLEOFS_RELATIONS_PATHCABL foreign key (CableNum)
      references PathCable (CableNum);

alter table CableOfSection
   add constraint FK_CABLEOFS_RELATIONS_TRESTLEL foreign key (TrestleLayerNum)
      references TrestleLayer (TrestleLayerNum);

alter table CableOfSection
   add constraint FK_CABLEOFS_RELATIONS_TUNNELSE foreign key (SectionNum)
      references TunnelSection (SectionNum);

alter table CablePath
   add constraint FK_CABLEPAT_RELATIONS_ORGANIZA foreign key (OrganizationNum)
      references Organization (OrganizationNum);

alter table CablePath
   add constraint FK_CABLEPAT_RELATIONS_AREA foreign key (AreaNum)
      references Area (AreaNum);

alter table CablePath
   add constraint FK_CABLEPAT_RELATIONS_BASEFACI foreign key (BaseFacilityNum)
      references BaseFacility (BaseFacilityNum);

alter table CablePath
   add constraint FK_CABLEPAT_RELATIONS_PATHTYPE foreign key (PathTypeID)
      references PathType (PathTypeID);

alter table CablePath
   add constraint FK_CABLEPAT_RELATIONS_POWERCAB foreign key (VoltageLevelID)
      references PowerCableLevel (VoltageLevelID);

alter table CableSectionArrt
   add constraint FK_CABLESEC_R_119_CABLEATT foreign key (AttachmentNum)
      references CableAttachment (AttachmentNum);

alter table Company
   add constraint FK_COMPANY_COMPANYT_COMPANYT foreign key (CompanyTypeID)
      references CompanyType (CompanyTypeID);

alter table CoverStuffType
   add constraint FK_COVERSTU_RELATIONS_MANHOLEC foreign key (ManholeCoverTypeID)
      references ManholeCoverType (ManholeCoverTypeID);

alter table Employee
   add constraint FK_EMPLOYEE_RELATIONS_ORGANIZA foreign key (OrganizationNum)
      references Organization (OrganizationNum);

alter table Extinguisher
   add constraint FK_EXTINGUI_R_COMPANY foreign key (bulid_CompanyNum)
      references Company (CompanyNum);

alter table Extinguisher
   add constraint FK_EXTINGUI_RELATIONS_COMPANY foreign key (monitor_CompanyNum)
      references Company (CompanyNum);

alter table Extinguisher
   add constraint FK_EXTINGUI_RELATIONS_EMPLOYEE foreign key (EmployeeID)
      references Employee (EmployeeID);

alter table Extinguisher
   add constraint FK_EXTINGUI_RELATIONS_EXTINGUI foreign key (ExtinguisherTypeID)
      references ExtinguisherType (ExtinguisherTypeID);

alter table Extinguisher
   add constraint FK_EXTINGUI_RELATIONS_POWERTUN foreign key (Tunnel_AssetNum)
      references PowerTunnel (AssetNum);

alter table FileAttachment
   add constraint FK_FILEATTA_R_114_BASEFACI foreign key (BaseFacilityNum)
      references BaseFacility (BaseFacilityNum);

alter table FileAttachment
   add constraint FK_FILEATTA_R_115_EMPLOYEE foreign key (EmployeeID)
      references Employee (EmployeeID);

alter table FireWall
   add constraint FK_FIREWALL_RELATIONS_EMPLOYEE foreign key (EmployeeID)
      references Employee (EmployeeID);

alter table FireWall
   add constraint FK_FIREWALL_RE_COMPANY foreign key (bulid_CompanyNum)
      references Company (CompanyNum);

alter table FireWall
   add constraint FK_FIREWALL_RELATIONS_COMPANY foreign key (monitor_CompanyNum)
      references Company (CompanyNum);

alter table FireWall
   add constraint FK_FIREWALL_RELATIONS_POWERTUN foreign key (Tunnel_AssetNum)
      references PowerTunnel (AssetNum);

alter table FireWall
   add constraint FK_FIREWALL_RE_FIREWALL foreign key (FireWallStuffTypeID)
      references FireWallStuffType (FireWallStuffTypeID);

alter table FireWall
   add constraint FK_FIREWALLCOMPANY foreign key (CompanyNum)
      references Company (CompanyNum);

alter table FireWall
   add constraint FK_FIREWALL_RELATIONS_DOORSTUF foreign key (DoorStuffTypeID)
      references DoorStuffType (DoorStuffTypeID);

alter table FireWall
   add constraint FK_FIREWALL_RELATIONS_FIREWALL foreign key (FireWallTypeID)
      references FireWallType (FireWallTypeID);

alter table FlawAdjunctFile
   add constraint FK_FLAWADJU_RELATIONS_INSPECTO foreign key (ObjFlawNum)
      references InspectObjFlaw (ObjFlawNum);

alter table FlawAdjunctFile
   add constraint FK_FLAWADJU_RELATIONS_EMPLOYEE foreign key (EmployeeID)
      references Employee (EmployeeID);

alter table FlawAduitRecord
   add constraint FK_FLAWADUI_R_162_INSPECTO foreign key (ObjFlawNum)
      references InspectObjFlaw (ObjFlawNum);

alter table FlawAduitRecord
   add constraint FK_FLAWADUI_RELATIONS_FLAWADUI foreign key (FlawAduitWayID)
      references FlawAduitWay (FlawAduitWayID);

alter table FlawAduitRecord
   add constraint FK_FLAWADUI_RELATIONS_EMPLOYEE foreign key (EmployeeID)
      references Employee (EmployeeID);

alter table FlawProcFile
   add constraint FK_FLAWPROC_R_163_FLAWPROC foreign key (FlawProcObj)
      references FlawProcTaskObj (FlawProcObj);

alter table FlawProcFile
   add constraint FK_FLAWPROC_R_EMPLOYEE foreign key (EmployeeID)
      references Employee (EmployeeID);

alter table FlawProcTask
   add constraint FK_FLAWPROC_R_168_TASKSTAT foreign key (TaskStatusTypeID)
      references TaskStatusType (TaskStatusTypeID);

alter table FlawProcTask
   add constraint FK_FLAWPROC_RE_EMPLOYEE foreign key (Task_EmployeeID)
      references Employee (EmployeeID);

alter table FlawProcTask
   add constraint FK_FLAWPROC_EMPLOYEE foreign key (EmployeeID)
      references Employee (EmployeeID);

alter table FlawProcTaskObj
   add constraint FK_FLAWPROC_R_166_INSPECTO foreign key (ObjFlawNum)
      references InspectObjFlaw (ObjFlawNum);

alter table FlawProcTaskObj
   add constraint FK_FLAWPROC_RELATIONS_FLAWPROC foreign key (FlawProcAcceptTypeID)
      references FlawProcAcceptType (FlawProcAcceptTypeID);

alter table FlawProcTaskObj
   add constraint FK_FLAWPROC_RELAT_FLAWPROC foreign key (FlawProcTaskNum)
      references FlawProcTask (FlawProcTaskNum);

alter table InspectObjFlaw
   add constraint FK_INSPECTO_R_155_INSPECTT foreign key (TaskNum)
      references InspectTask (TaskNum);

alter table InspectObjFlaw
   add constraint FK_INSPECTO_RELATIONS_FLAWSOUR foreign key (FlawSourceTypeID)
      references FlawSourceType (FlawSourceTypeID);

alter table InspectObjFlaw
   add constraint FK_INSPECTO_RELATIONS_FLAWTYPE foreign key (FlawTypeID)
      references FlawType (FlawTypeID);

alter table InspectObjFlaw
   add constraint FK_INSPECTO_RELATIONS_FLAWLEVE foreign key (FlawLevelTypeID)
      references FlawLevelType (FlawLevelTypeID);

alter table InspectObjFlaw
   add constraint FK_INSPECTO_RELATIONS_FLAWADUI foreign key (FlawAduitStatusID)
      references FlawAduitStatus (FlawAduitStatusID);

alter table InspectTask
   add constraint FK_INSPECTT_RELATIONS_TASKSTAT foreign key (TaskStatusTypeID)
      references TaskStatusType (TaskStatusTypeID);

alter table InspectTask
   add constraint FK_INSPECTT_RELATIONS_TEAMTYPE foreign key (TeamTypeID)
      references TeamType (TeamTypeID);

alter table InspectTask
   add constraint FK_INSPECTT_RE_EMPLOYEE foreign key (EmployeeID)
      references Employee (EmployeeID);

alter table InspectTask
   add constraint FK_INSPECTT_RELATIONS_EMPLOYEE foreign key (Task_EmployeeID)
      references Employee (EmployeeID);

alter table Ledger
   add constraint FK_LEDGER_R_116_ASSETBOR foreign key (AssetBorderTypeID)
      references AssetBorderType (AssetBorderTypeID);

alter table Ledger
   add constraint FK_LEDGER_RELATIONS_ACCEPTST foreign key (AcceptStatusTypeID)
      references AcceptStatusType (AcceptStatusTypeID);

alter table Ledger
   add constraint FK_LEDGER_RELATIONS_COMPANY foreign key (bulid_CompanyNum)
      references Company (CompanyNum);

alter table Ledger
   add constraint FK_LEDGER_COMPANY foreign key (monitor_CompanyNum)
      references Company (CompanyNum);

alter table Ledger
   add constraint FK_LEDGER_RELATIONS_BASEFACI foreign key (BaseFacilityNum)
      references BaseFacility (BaseFacilityNum);

alter table Ledger
   add constraint FK_LEDGER_RELATIONS_EMPLOYEE foreign key (EmployeeID)
      references Employee (EmployeeID);

alter table LoopEarthBox
   add constraint FK_LOOPEART_RELATIONS_CABLEATT foreign key (AttachmentNum)
      references CableAttachment (AttachmentNum);

alter table LoopEarthBox
   add constraint FK_LOOPEART_RELATIONS_POWERLOO foreign key (LoopNum)
      references PowerLoop (LoopNum);

alter table Manhole
   add constraint FK_MANHOLE_RELATIONS_AREA foreign key (AreaNum)
      references Area (AreaNum);

alter table Manhole
   add constraint FK_MANHOLE_RELATIONS_BASEFACI foreign key (BaseFacilityNum)
      references BaseFacility (BaseFacilityNum);

alter table Manhole
   add constraint FK_HOLE_COMPANY foreign key (bulid_CompanyNum)
      references Company (CompanyNum);

alter table Manhole
   add constraint FK_MANHOLE_RELATIONS_EMPLOYEE foreign key (EmployeeID)
      references Employee (EmployeeID);

alter table Manhole
   add constraint FK_MANHOLE_RELATIONS_COMPANY foreign key (monitor_CompanyNum)
      references Company (CompanyNum);

alter table Manhole
   add constraint FK_HOLE_R_MANHOLES foreign key (ManholeStuffTypeID)
      references ManholeStuffType (ManholeStuffTypeID);

alter table Manhole
   add constraint FK_MANHOLE_RELATIONS_MANHOLEK foreign key (ManholeKindTypeID)
      references ManholeKindType (ManholeKindTypeID);

alter table Manhole
   add constraint FK_MANHOLE_RELATIONS_POWERTUN foreign key (Tunnel_AssetNum)
      references PowerTunnel (AssetNum);

alter table Manhole
   add constraint FK_MANHOLE_COMPANY foreign key (CompanyNum)
      references Company (CompanyNum);

alter table Manhole
   add constraint FK_MANHOLE_RELATIONS_MANHOLEC foreign key (ManholeCoverTypeID)
      references ManholeCoverType (ManholeCoverTypeID);

alter table Manhole
   add constraint FK_MANHOLE_RELATIONS_COVERSTU foreign key (CoverStuffTypeID)
      references CoverStuffType (CoverStuffTypeID);

alter table Manhole
   add constraint FK_MANHOLE_RELATIONS_COVERSHA foreign key (CoverShapeTypeID)
      references CoverShapeType (CoverShapeTypeID);

alter table Manhole
   add constraint FK_MANHOLE_R_MANHOLES foreign key (ManholeShapeTypeID)
      references ManholeShapeType (ManholeShapeTypeID);

alter table ManholeKindType
   add constraint FK_MANHOLEK_RELATIONS_MANHOLET foreign key (ManholeTypeID)
      references ManholeType (ManholeTypeID);

alter table ManholeOfSection
   add constraint FK_MANHOLEO_RELATIONS_TUNNELSE foreign key (SectionNum)
      references TunnelSection (SectionNum);

alter table ManholeOfSection
   add constraint FK_MANHOLEO_RELATIONS_MANHOLE foreign key (AssetNum)
      references Manhole (AssetNum);

alter table ManholeOfTunnel
   add constraint FK_MANHOLEO_RELATIONS_POWERTUN foreign key (AssetNum)
      references PowerTunnel (AssetNum);

alter table ManholeOfTunnel
   add constraint FK_MANHOLEO_RE_MANHOLE foreign key (Man_AssetNum)
      references Manhole (AssetNum);

alter table OperationLog
   add constraint FK_OPERATIO_R_112_EMPLOYEE foreign key (EmployeeID)
      references Employee (EmployeeID);

alter table OperationLog
   add constraint FK_OPERATIO_RELATIONS_OPERATIO foreign key (TypeID)
      references OperationType (TypeID);

alter table Organization
   add constraint FK_ORGANIZA_R_21_ORGANIZA foreign key (ParentID)
      references Organization (OrganizationNum);

alter table Organization
   add constraint FK_ORGANIZA_RELATIONS_TEAMTYPE foreign key (TeamTypeID)
      references TeamType (TeamTypeID);

alter table PathAduitRecord
   add constraint FK_PATHADUI_RELATIONS_CABLEDEV foreign key (Num)
      references CableDeviceLedger (Num);

alter table PathAduitRecord
   add constraint FK_PATHADUI_RELATIONS_TASKSTAT foreign key (TaskStatusTypeID)
      references TaskStatusType (TaskStatusTypeID);

alter table PathAduitRecord
   add constraint FK_PATHADUI_R_EMPLOYEE foreign key (EmployeeID)
      references Employee (EmployeeID);

alter table PathAduitRecord
   add constraint FK_PATHADUI_RELATIONS_EMPLOYEE foreign key (Task_EmployeeID)
      references Employee (EmployeeID);

alter table PathArchivesFile
   add constraint FK_PATHARCH_RELATIONS_CABLEDEV foreign key (Num)
      references CableDeviceLedger (Num);

alter table PathArchivesFile
   add constraint FK_PATHARCH_RELATIONS_PATHARCH foreign key (ArchivesFileTypeID)
      references PathArchivesFileType (ArchivesFileTypeID);

alter table PathArchivesFile
   add constraint FK_PATHARCH_RELATIONS_PATHADUI foreign key (AcceptRecordNum)
      references PathAduitRecord (AcceptRecordNum);

alter table PathArchivesFile
   add constraint FK_PATHARCH_RELATIONS_EMPLOYEE foreign key (EmployeeID)
      references Employee (EmployeeID);

alter table PathCable
   add constraint FK_PATHCABL_RELATIONS_POWERLOO foreign key (LoopNum)
      references PowerLoop (LoopNum);

alter table PathCable
   add constraint FK_PATHCABL_RELATIONS_ATTACHME foreign key (ModelTypeNum)
      references AttachmentModelType (ModelTypeNum);

alter table PathCable
   add constraint FK_PATHCABL_RELATIONS_PHASETYP foreign key (PhaseTypeID)
      references PhaseType (PhaseTypeID);

alter table PathSection
   add constraint FK_PATHSECT_R_126_SAFEEART foreign key (SafeEarthTypeID)
      references SafeEarthType (SafeEarthTypeID);

alter table PathSection
   add constraint FK_PATHSECT_MANHOLE foreign key (begin_AssetNum)
      references Manhole (AssetNum);

alter table PathSection
   add constraint FK_PATHSECT_RELATIONS_MANHOLE foreign key (end_AssetNum)
      references Manhole (AssetNum);

alter table PathSection
   add constraint FK_PATHSECT_RELATIONS_CABLEPAT foreign key (CablePathNum)
      references CablePath (CablePathNum);

alter table PathSection
   add constraint FK_PATHSECT_RELATIONS_INSTALLT foreign key (InstallTypeID)
      references InstallType (InstallTypeID);

alter table PathSection
   add constraint FK_PATHSECT_RELATIONS_BASEFACI foreign key (BaseFacilityNum)
      references BaseFacility (BaseFacilityNum);

alter table PathSection
   add constraint FK_PATHSECT_RELATIONS_PATHSECT foreign key (ParentSectionNum)
      references PathSection (PathSectionNum);

alter table PathSectionRunStatusRecord
   add constraint FK_PATHSECT_RELATIONS_POWERLOO foreign key (LoopNum)
      references PowerLoop (LoopNum);

alter table PowerLevelTunnelColor
   add constraint FK_POWERLEV_R_152_TUNNELST foreign key (TunnelStructureTypeID)
      references TunnelStructureType (TunnelStructureTypeID);

alter table PowerLevelTunnelColor
   add constraint FK_POWERLEV_R_153_POWERCAB foreign key (VoltageLevelID)
      references PowerCableLevel (VoltageLevelID);

alter table PowerLoop
   add constraint FK_POWERLOO_RELATIONS_PATHSECT foreign key (PathSectionNum)
      references PathSection (PathSectionNum);

alter table PowerLoop
   add constraint FK_POWERLOO_RELATIONS_ATTACHME foreign key (AttachmentStatusTypeID)
      references AttachmentStatusType (AttachmentStatusTypeID);

alter table PowerTunnel
   add constraint FK_POWERTUN_R_73_ORGANIZA foreign key (OrganizationNum)
      references Organization (OrganizationNum);

alter table PowerTunnel
   add constraint FK_POWERTUN_RELATIONS_POWERCAB foreign key (VoltageLevelID)
      references PowerCableLevel (VoltageLevelID);

alter table PowerTunnel
   add constraint FK_POWERTUN_R_COMPANY foreign key (bulid_CompanyNum)
      references Company (CompanyNum);

alter table PowerTunnel
   add constraint FK_POWERTUN_RELATIONS_COMPANY foreign key (monitor_CompanyNum)
      references Company (CompanyNum);

alter table PowerTunnel
   add constraint FK_POWERTUN_R_TUNNELST foreign key (TunnelStructureTypeID)
      references TunnelStructureType (TunnelStructureTypeID);

alter table PowerTunnel
   add constraint FK_POWERTUN_RELATIONS_TUNNELSH foreign key (TunnelShapeTypeID)
      references TunnelShapeType (TunnelShapeTypeID);

alter table PowerTunnel
   add constraint FK_POWERTUN_RELATIONS_EMPLOYEE foreign key (EmployeeID)
      references Employee (EmployeeID);

alter table PowerTunnel
   add constraint FK_POWERTUN_RELATIONS_TUNNELST foreign key (TunnelStuffTypeID)
      references TunnelStuffType (TunnelStuffTypeID);

alter table PowerTunnel
   add constraint FK_POWERTUN_RELATIONS_AREA foreign key (AreaNum)
      references Area (AreaNum);

alter table PowerTunnel
   add constraint FK_POWERTUN_RELATIONS_TRESTLET foreign key (TrestleTypeInfoID)
      references TrestleTypeInfo (TrestleTypeInfoID);

alter table PowerTunnel
   add constraint FK_POWERTUN_RELATIONS_LEDGER foreign key (ArchivesNum)
      references Ledger (ArchivesNum);

alter table RoleFunctions
   add constraint FK_ROLEFUNC_R_108_ROLES foreign key (RoleNum)
      references Roles (RoleNum);

alter table RoleFunctions
   add constraint FK_ROLEFUNC_RELATIONS_ACCESSFU foreign key (ApplicationModuleID)
      references AccessFunction (ApplicationModuleID);

alter table RowTube
   add constraint FK_ROWTUBE_RELATIONS_ROWTUBET foreign key (RowTubeTypeID)
      references RowTubeType (RowTubeTypeID);

alter table RowTube
   add constraint FK_ROWTUBE_RELATIONS_TRESTLEL foreign key (TrestleLayerNum)
      references TrestleLayer (TrestleLayerNum);

alter table RunRecord
   add constraint FK_RUNRECOR_RELATIONS_CABLEATT foreign key (AttachmentNum)
      references CableAttachment (AttachmentNum);

alter table RunRecord
   add constraint FK_RUNRECOR_RELATIONS_ATTACHME foreign key (AttachmentStatusTypeID)
      references AttachmentStatusType (AttachmentStatusTypeID);

alter table TerminalFile
   add constraint FK_TERMINAL_RELATIONS_MANHOLE foreign key (AssetNum)
      references Manhole (AssetNum);

alter table TerminalFile
   add constraint FK_TERMINAL_RELATIONS_EMPLOYEE foreign key (EmployeeID)
      references Employee (EmployeeID);

alter table TrestleLayer
   add constraint FK_TRESTLEL_R_117_TRESTLES foreign key (TrestleStuffTypeID)
      references TrestleStuffType (TrestleStuffTypeID);

alter table TrestleLayer
   add constraint FK_TRESTLEL_RELATIONS_TRESTLED foreign key (TrestlePositionTypeID)
      references TrestleDirectionType (TrestlePositionTypeID);

alter table TrestleLayer
   add constraint FK_TRESTLEL_RELATIONS_POWERCAB foreign key (VoltageLevelID)
      references PowerCableLevel (VoltageLevelID);

alter table TrestleLayer
   add constraint FK_TRESTLEL_RELATIONS_TUNNELSE foreign key (SectionNum)
      references TunnelSection (SectionNum);

alter table TunnelAduitRecord
   add constraint FK_TUNNELAD_RELATIONS_TASKSTAT foreign key (TaskStatusTypeID)
      references TaskStatusType (TaskStatusTypeID);

alter table TunnelAduitRecord
   add constraint FK_TUNNELAD_EMPLOYEE foreign key (Task_EmployeeID)
      references Employee (EmployeeID);

alter table TunnelAduitRecord
   add constraint FK_TUNNELAD_RELATIONS_EMPLOYEE foreign key (EmployeeID)
      references Employee (EmployeeID);

alter table TunnelAduitRecord
   add constraint FK_TUNNELAD_RELATIONS_LEDGER foreign key (ArchivesNum)
      references Ledger (ArchivesNum);

alter table TunnelArchivesFile
   add constraint FK_TUNNELAR_RELATIONS_TUNNELAD foreign key (AcceptRecordNum)
      references TunnelAduitRecord (AcceptRecordNum);

alter table TunnelArchivesFile
   add constraint FK_TUNNELAR_RELATIONS_EMPLOYEE foreign key (EmployeeID)
      references Employee (EmployeeID);

alter table TunnelArchivesFile
   add constraint FK_TUNNELAR_RELATIONS_LEDGER foreign key (ArchivesNum)
      references Ledger (ArchivesNum);

alter table TunnelArchivesFile
   add constraint FK_TUNNELAR_RELATIONS_ARCHIVES foreign key (ArchivesFileTypeID)
      references ArchivesFileType (ArchivesFileTypeID);

alter table TunnelSection
   add constraint FK_TUNNELSE_R_102_TUNNLETO foreign key (TunnleTowardTypeID)
      references TunnleTowardType (TunnleTowardTypeID);

alter table TunnelSection
   add constraint FK_TUNNELSE_RELATIONS_POWERTUN foreign key (AssetNum)
      references PowerTunnel (AssetNum);

alter table TunnelStuffType
   add constraint FK_TUNNELST_RELATIONS_TUNNELST foreign key (TunnelStructureTypeID)
      references TunnelStructureType (TunnelStructureTypeID);

alter table UserRoles
   add constraint FK_USERROLE_RELATIONS_ROLES foreign key (RoleNum)
      references Roles (RoleNum);

alter table UserRoles
   add constraint FK_USERROLE_RELATIONS_EMPLOYEE foreign key (EmployeeID)
      references Employee (EmployeeID);

