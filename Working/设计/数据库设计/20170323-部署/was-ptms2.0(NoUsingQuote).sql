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
'�ݸ�״̬
��ͨ����״̬/�Ӽ�����״̬
������
���״̬
����ͨ��
����ͨ�����ϲ�ȫ';

comment on column AcceptStatusType.AcceptStatusTypeID is
'����״̬����ID';

comment on column AcceptStatusType.AcceptStatusTypeName is
'����״̬��������';

comment on column AcceptStatusType.ShowColor is
'��ʾ��ɫ';

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
'����Ȩ��';

comment on column AccessFunction.ApplicationModuleID is
'����ID';

comment on column AccessFunction.ParentModuleID is
'����_��ģ��ID';

comment on column AccessFunction.ApplicationModuleName is
'��������';

comment on column AccessFunction.Context is
'������Ϣ';

comment on column AccessFunction.IsDisplay is
'�Ƿ���ʾ';

comment on column AccessFunction.FunctionPath is
'���ܶ����ַ';

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
'���ʼ�¼��';

comment on column AccessList.AccessNum is
'��¼���';

comment on column AccessList.EmployeeID is
'�û�ID';

comment on column AccessList.IP is
'IP';

comment on column AccessList.MAC is
'MAC';

comment on column AccessList.AppVer is
'����汾';

comment on column AccessList.IsLogin is
'��¼/�ǳ���־';

comment on column AccessList.RecordTime is
'��¼ʱ��';

comment on column AccessList.Memo is
'��ע';

create index Relationship_173_FK on AccessList (
   EmployeeID ASC
);

create table ArchivesFileType  (
   ArchivesFileTypeID   INTEGER                         not null,
   ArchivesFileTypeName VARCHAR2(32)                    not null,
   constraint PK_ARCHIVESFILETYPE primary key (ArchivesFileTypeID)
);

comment on table ArchivesFileType is
'8����+Сͼ';

comment on column ArchivesFileType.ArchivesFileTypeID is
'�ļ�����ID';

comment on column ArchivesFileType.ArchivesFileTypeName is
'�ļ���������';

create table Area  (
   AreaNum              INTEGER                         not null,
   AreaTypeID           INTEGER,
   AreaName             VARCHAR2(32)                    not null,
   AreaDescription      VARCHAR2(255),
   constraint PK_AREA primary key (AreaNum)
);

comment on table Area is
'�����Ϊ����������
�Ŷ�������
��ǡ��LȪ������';

comment on column Area.AreaNum is
'Ƭ�����';

comment on column Area.AreaTypeID is
'��������ID';

comment on column Area.AreaName is
'Ƭ������';

comment on column Area.AreaDescription is
'Ƭ������';

create index Relationship_108_FK on Area (
   AreaTypeID ASC
);

create table AreaType  (
   AreaTypeID           INTEGER                         not null,
   AreaTypeName         VARCHAR2(16)                    not null,
   constraint PK_AREATYPE primary key (AreaTypeID)
);

comment on table AreaType is
'����
����';

comment on column AreaType.AreaTypeID is
'��������ID';

comment on column AreaType.AreaTypeName is
'������������';

create table AssetBorderType  (
   AssetBorderTypeID    INTEGER                         not null,
   AssetBorderTypeName  VARCHAR2(64)                    not null,
   constraint PK_ASSETBORDERTYPE primary key (AssetBorderTypeID)
);

comment on table AssetBorderType is
'�ʲ��ֽ�
һ��һ���߹�����';

comment on column AssetBorderType.AssetBorderTypeID is
'�ʲ��߽�����ID';

comment on column AssetBorderType.AssetBorderTypeName is
'�ʲ��߽�����';

create table AttachmentModelType  (
   ModelTypeNum         INTEGER                         not null,
   AttachmentTypeID     INTEGER,
   PathTypeID           INTEGER,
   ModelTypeName        VARCHAR2(64)                    not null,
   constraint PK_ATTACHMENTMODELTYPE primary key (ModelTypeNum)
);

comment on table AttachmentModelType is
'�����豸����ͺ�';

comment on column AttachmentModelType.ModelTypeNum is
'�����';

comment on column AttachmentModelType.AttachmentTypeID is
'��������ID';

comment on column AttachmentModelType.PathTypeID is
'��·����ID';

comment on column AttachmentModelType.ModelTypeName is
'�������';

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
'���塢�ն�ͷ�� �м�ͷ���ӵ���';

comment on column AttachmentOfCable.RecordNum is
'���¸������';

comment on column AttachmentOfCable.Start_AttachmentNum is
'�׶˸���';

comment on column AttachmentOfCable.End_AttachmentNum is
'ĩ�˸���';

comment on column AttachmentOfCable.Cab_AttachmentNum is
'���������豸';

comment on column AttachmentOfCable.CableNum is
'���±��';

comment on column AttachmentOfCable.Place is
'��װλ��';

comment on column AttachmentOfCable.Distance is
'��·��������';

comment on column AttachmentOfCable.InstallDate is
'��װʱ��';

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
'ԤͶ��״̬
����״̬
ͣ��״̬
����״̬';

comment on column AttachmentStatusType.AttachmentStatusTypeID is
'״̬ID';

comment on column AttachmentStatusType.AttachmentStatusTypeName is
'״̬����';

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
'������Ȩ��';

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
'��Ȩʱ��';

comment on column AuthorizeTable.AuthorizeFilePath is
'��׼�ļ�';

comment on column AuthorizeTable.Memo is
'��ע';

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
'���վ';

comment on column BaseFacility.BaseFacilityNum is
'��ʩ���';

comment on column BaseFacility.AreaNum is
'Ƭ�����';

comment on column BaseFacility.Lon is
'����';

comment on column BaseFacility.Lat is
'γ��';

comment on column BaseFacility.Height is
'�߶�';

comment on column BaseFacility.Angle is
'���';

comment on column BaseFacility.Heading is
'��λ';

comment on column BaseFacility.Range is
'��Χ';

comment on column BaseFacility.ViewLon is
'�ӵ㾭��';

comment on column BaseFacility.ViewLat is
'�ӵ�γ��';

comment on column BaseFacility.ViewHeight is
'�ӵ�߶�';

comment on column BaseFacility.ViewAngle is
'�ӵ����';

comment on column BaseFacility.ViewHeading is
'�ӵ㷽λ';

comment on column BaseFacility.ViewRange is
'�ӵ㷶Χ';

comment on column BaseFacility.BaseFacilityName is
'��ʩ����';

comment on column BaseFacility.AssetCode is
'�ʲ�����';

comment on column BaseFacility.BaseFacilityDescription is
'��ʩ����';

comment on column BaseFacility.GraphID is
'ͼԪID';

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
'�ֽ���̨��';

comment on column BranchBox.BranchBoxNum is
'�ֽ����¼���';

comment on column BranchBox.ModelNum is
'����ͺű��';

comment on column BranchBox.VoltageLevelID is
'��ѹ�ȼ�ID';

comment on column BranchBox.AssetNum is
'�ʲ����';

comment on column BranchBox.IsLoadSwitch is
'���޸��ɿ���';

comment on column BranchBox.IsLockDevice is
'���ޱ���װ��';

comment on column BranchBox.IsOnMonitor is
'�Ƿ�װ���߼��';

comment on column BranchBox.IsDrop is
'�Ƿ����ν�ͷ';

comment on column BranchBox.RunDate is
'Ͷ������';

comment on column BranchBox.Memo is
'��ע';

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
'�ֽ������ͺ�';

comment on column BranchBoxModel.ModelNum is
'����ͺű��';

comment on column BranchBoxModel.ModelName is
'����ͺ�';

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
'ҵ������ʵ����';

comment on column BusinessProcessInstantiate.InstantiateID is
'ʵ�������';

comment on column BusinessProcessInstantiate.TemplateID is
'ҵ������ʵ�������';

comment on column BusinessProcessInstantiate.UserAID is
'���̽ڵ�A�û�ID';

comment on column BusinessProcessInstantiate.UserBID is
'���̽ڵ�B�û�ID';

comment on column BusinessProcessInstantiate.UserCID is
'���̽ڵ�C�û�ID';

comment on column BusinessProcessInstantiate.UserDID is
'���̽ڵ�D�û�ID';

comment on column BusinessProcessInstantiate.UserEID is
'���̽ڵ�E�û�ID';

comment on column BusinessProcessInstantiate.ctime is
'����ʱ��';

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
'ϵͳ����ҵ������֧��6����ת
A-F�ڵ�����Ӧ��ת��ɫID';

comment on column BusinessProcessTemplate.TemplateID is
'ҵ������ʵ�������';

comment on column BusinessProcessTemplate.RoleNum is
'��ɫ���';

comment on column BusinessProcessTemplate.BusinessName is
'��������';

comment on column BusinessProcessTemplate.BusinessCode is
'ҵ�����̱���';

comment on column BusinessProcessTemplate.NodeA is
'���̽ڵ�A';

comment on column BusinessProcessTemplate.NodeB is
'���̽ڵ�B';

comment on column BusinessProcessTemplate.NodeC is
'���̽ڵ�C';

comment on column BusinessProcessTemplate.NodeD is
'���̽ڵ�D';

comment on column BusinessProcessTemplate.NodeE is
'���̽ڵ�E';

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
'����
�նˣ�������������Ԥ�ơ����ס�GIS��
��ͷ��Ԥ�ƣ�
�ӵ�ϵͳ�����滥���䡢�����ӵ��䡢ֱ�ӽӵ��䣩';

comment on column CableAttachment.AttachmentNum is
'���¸������';

comment on column CableAttachment.CableDeviceTypeID is
'�����豸����ID';

comment on column CableAttachment.ModelTypeNum is
'�����';

comment on column CableAttachment.CableDeviceStyleID is
'�豸����ID';

comment on column CableAttachment.Num is
'�������';

comment on column CableAttachment.FaultIndicatorTypeID is
'����ID';

comment on column CableAttachment.SafeBoxTypeID is
'����ID2';

comment on column CableAttachment.AttachmentTypeID is
'��������ID';

comment on column CableAttachment.CompanyNum is
'��λ���';

comment on column CableAttachment.PathTypeID is
'��·����ID';

comment on column CableAttachment.AttachmentStatusTypeID is
'״̬ID';

comment on column CableAttachment.Lon is
'����';

comment on column CableAttachment.Lat is
'γ��';

comment on column CableAttachment.Height is
'�߶�';

comment on column CableAttachment.Angle is
'���';

comment on column CableAttachment.Heading is
'��λ';

comment on column CableAttachment.Range is
'��Χ';

comment on column CableAttachment.ViewLon is
'�ӵ㾭��';

comment on column CableAttachment.ViewLat is
'�ӵ�γ��';

comment on column CableAttachment.ViewHeight is
'�ӵ�߶�';

comment on column CableAttachment.ViewAngle is
'�ӵ����';

comment on column CableAttachment.ViewHeading is
'�ӵ㷽λ';

comment on column CableAttachment.ViewRange is
'�ӵ㷶Χ';

comment on column CableAttachment.AttachmentName is
'���¸�������';

comment on column CableAttachment.AssetCode is
'�ʲ�����';

comment on column CableAttachment.IsMonitor is
'�Ƿ����߼��';

comment on column CableAttachment.InstallDate is
'Ͷ��ʱ��';

comment on column CableAttachment.Memo is
'��ע';

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
'����
�ն�ͷ
�м��ͷ
�ӵ���
';

comment on column CableAttachmentType.AttachmentTypeID is
'��������ID';

comment on column CableAttachmentType.AttachmentTypeName is
'������������';

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
'�����豸����';

comment on column CableDeviceLedger.Num is
'�������';

comment on column CableDeviceLedger.VoltageLevelID is
'��ѹ�ȼ�ID';

comment on column CableDeviceLedger.EmployeeID is
'�û�ID';

comment on column CableDeviceLedger.AcceptStatusTypeID is
'����״̬����ID';

comment on column CableDeviceLedger.PathTypeID is
'��·����ID';

comment on column CableDeviceLedger.ProjectTypeID is
'��������ID';

comment on column CableDeviceLedger.LedgerName is
'���µ�������';

comment on column CableDeviceLedger.LedgerCode is
'���µ�������';

comment on column CableDeviceLedger.ProjectCode is
'�������';

comment on column CableDeviceLedger.ArchivesTime is
'¼��ʱ��';

comment on column CableDeviceLedger.IsRush is
'�Ӽ����ձ�־';

comment on column CableDeviceLedger.BuildDate is
'ʩ��ʱ��';

comment on column CableDeviceLedger.AccpetDate is
'����ʱ��';

comment on column CableDeviceLedger.Memo is
'��ע';

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
'���壺ͭ����
����ͷ������������
����ͷ������Ԥ�ơ�GISԤ�ơ�����
����ͷ������������
����ͷ�����塢Ԥ��';

comment on column CableDeviceStyle.CableDeviceStyleID is
'�豸����ID';

comment on column CableDeviceStyle.PathTypeID is
'��·����ID';

comment on column CableDeviceStyle.AttachmentTypeID is
'��������ID';

comment on column CableDeviceStyle.CableDeviceStyleName is
'�豸��������';

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
'��籾�壺��Ե���ࣨ��ֽ\�����ȣ�
��籾�壺��Ե���ࣨ����\�����ȣ�

����ͷ�����ӷ�ʽ����˨��T�ͣ�
����ͷ����

����ͷ����
����ͷ���ٽ�ͷ��ֱͨ��ͷ����Ե��ͷ';

comment on column CableDeviceType.CableDeviceTypeID is
'�����豸����ID';

comment on column CableDeviceType.AttachmentTypeID is
'��������ID';

comment on column CableDeviceType.PathTypeID is
'��·����ID';

comment on column CableDeviceType.CableDeviceTypeName is
'�����豸��������';

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
'λ��˳��������ά���棬
����֧�ܳ���ȷ��ÿ��֧�ܿ��õ�λ�������������࣬��˳��ڷ�
˳������������ļ���
X��Y���������������
�������ͣ�1ˮƽ2��ֱ3Ʒ��
Ʒ��ռλ���Ŵӱ�������1��2���������Ϊ3

�������ʣ�false ��ʽ���� trueԤ���裨��ʱ���裩';

comment on column CableOfSection.LayerCableNum is
'�����¼���';

comment on column CableOfSection.TrestleLayerNum is
'�㼶���';

comment on column CableOfSection.CableNum is
'���±��';

comment on column CableOfSection.SectionNum is
'�������α��';

comment on column CableOfSection.RowTubeNum is
'�Źܱ��';

comment on column CableOfSection.OrderNum is
'λ��˳��';

comment on column CableOfSection.X is
'����x������';

comment on column CableOfSection.Y is
'����y������';

comment on column CableOfSection.PlaceType is
'��������';

comment on column CableOfSection.IsTempCable is
'�Ƿ�Ԥ����';

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
'��ֹ���Ƿ����¼�뷽ʽ����������ʩ��ѡ��

��Ҫ�����·����ѡ�ѡ��Ϊ������/���
ʹ�÷��豸ע����·��ע�ֶΣ�ʹ��XML�ֵ䷽ʽ';

comment on column CablePath.CablePathNum is
'��·���';

comment on column CablePath.PathTypeID is
'��·����ID';

comment on column CablePath.BaseFacilityNum is
'��ʩ���';

comment on column CablePath.AreaNum is
'Ƭ�����';

comment on column CablePath.VoltageLevelID is
'��ѹ�ȼ�ID';

comment on column CablePath.OrganizationNum is
'��λ���';

comment on column CablePath.CablePathCode is
'���б��';

comment on column CablePath.CablePathName is
'��·����';

comment on column CablePath.LayingMethod is
'���跽ʽ˵��';

comment on column CablePath.LayingMemo is
'���豸ע';

comment on column CablePath.BeginPlace is
'���';

comment on column CablePath.EndPlace is
'�յ�';

comment on column CablePath.Memo is
'��·��ע';

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
'�ӵ���������ʹ��XML�ֵ䣬Ԥ����ƣ�Ŀǰ����ʹ����·�ζ���';

comment on column CableSectionArrt.AttrNum is
'���Ա��';

comment on column CableSectionArrt.AttachmentNum is
'���¸������';

comment on column CableSectionArrt.BeginPlace is
'���';

comment on column CableSectionArrt.EndPlace is
'ֹ��';

comment on column CableSectionArrt.CurrentCapacity is
'������';

comment on column CableSectionArrt.Length is
'����';

comment on column CableSectionArrt.IsHaveEarthLine is
'�Ƿ��������';

comment on column CableSectionArrt.EarthConnectorType is
'�ӵ���������';

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
'����λ
ʩ����λ
��������
���³���
���¸�������
������ʩ����';

comment on column Company.CompanyNum is
'��λ���';

comment on column Company.CompanyTypeID is
'��λ����ID';

comment on column Company.CompanyName is
'��λ����';

comment on column Company.CompanyAddr is
'��λ��ַ';

comment on column Company.CompanyTelephone is
'��λ�绰';

comment on column Company.Contact is
'��ϵ��';

comment on column Company.ContactPhone is
'��ϵ�˵绰';

comment on column Company.Memo is
'��ע';

create index CompanyT_FK on Company (
   CompanyTypeID ASC
);

create table CompanyType  (
   CompanyTypeID        INTEGER                         not null,
   CompanyTypeName      VARCHAR2(32)                    not null,
   constraint PK_COMPANYTYPE primary key (CompanyTypeID)
);

comment on table CompanyType is
'�������ң�������ʩ�������ң�
ʩ����λ
����λ
���³���
���¸�������
��ʩ���ң���������䡢���������ֽ��䣩
';

comment on column CompanyType.CompanyTypeID is
'��λ����ID';

comment on column CompanyType.CompanyTypeName is
'��λ��������';

create table CoverShapeType  (
   CoverShapeTypeID     INTEGER                         not null,
   CoverShapeTypeName   VARCHAR2(32)                    not null,
   constraint PK_COVERSHAPETYPE primary key (CoverShapeTypeID)
);

comment on table CoverShapeType is
'Բ�Ρ����Ρ���';

comment on column CoverShapeType.CoverShapeTypeID is
'������ʩ��״����ID';

comment on column CoverShapeType.CoverShapeTypeName is
'������ʩ��״��������';

create table CoverStuffType  (
   CoverStuffTypeID     INTEGER                         not null,
   ManholeCoverTypeID   INTEGER                         not null,
   CoverStuffTypeName   VARCHAR2(32)                    not null,
   constraint PK_COVERSTUFFTYPE primary key (CoverStuffTypeID)
);

comment on table CoverStuffType is
'����/��¥��������';

comment on column CoverStuffType.CoverStuffTypeID is
'������ʩ��������ID';

comment on column CoverStuffType.ManholeCoverTypeID is
'������ʩ��ʩ����ID';

comment on column CoverStuffType.CoverStuffTypeName is
'������ʩ������������';

create index Relationship_80_FK on CoverStuffType (
   ManholeCoverTypeID ASC
);

create table DoorStuffType  (
   DoorStuffTypeID      INTEGER                         not null,
   DoorStuffTypeName    VARCHAR2(32)                    not null,
   constraint PK_DOORSTUFFTYPE primary key (DoorStuffTypeID)
);

comment on table DoorStuffType is
'�����Ų�������';

comment on column DoorStuffType.DoorStuffTypeID is
'�����Ų�������ID';

comment on column DoorStuffType.DoorStuffTypeName is
'�����Ų�����������';

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
'Ա����

grade:
0��Ա
1�೤
2ר��
3����
4���';

comment on column Employee.EmployeeID is
'�û�ID';

comment on column Employee.OrganizationNum is
'��λ���';

comment on column Employee.Account is
'��¼�ʺ�';

comment on column Employee.Password is
'Password';

comment on column Employee.UserName is
'�û�����';

comment on column Employee.Sex is
'�Ա�';

comment on column Employee.Email is
'Email';

comment on column Employee.SID is
'SID';

comment on column Employee.Grade is
'�ȼ�';

comment on column Employee.MobilePhone is
'�ֻ�����';

comment on column Employee.Address is
'��ͥסַ';

comment on column Employee.CreateDate is
'�˻�����ʱ��';

comment on column Employee.IsDisabled is
'ͣ�ñ�־';

comment on column Employee.DisableDate is
'ͣ��ʱ��';

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
'���װ��';

comment on column Extinguisher.AssetNum is
'�ʲ����';

comment on column Extinguisher.monitor_CompanyNum is
'����_��λ���';

comment on column Extinguisher.EmployeeID is
'�û�ID';

comment on column Extinguisher.ExtinguisherTypeID is
'�����������ID';

comment on column Extinguisher.bulid_CompanyNum is
'ʩ��_��λ���';

comment on column Extinguisher.Tunnel_AssetNum is
'����ͨ��_�ʲ����';

comment on column Extinguisher.AssetName is
'�ʲ�����';

comment on column Extinguisher.AssetCode is
'�ʲ�����';

comment on column Extinguisher.GraphID is
'ͼԪID';

comment on column Extinguisher.OperationCode is
'���б���';

comment on column Extinguisher.BuildDate is
'ʩ������';

comment on column Extinguisher.CompletedDate is
'��������';

comment on column Extinguisher.OperationDate is
'Ͷ������';

comment on column Extinguisher.PositionDescription is
'���ڷ�λ';

comment on column Extinguisher.Longitude is
'����';

comment on column Extinguisher.Latitude is
'γ��';

comment on column Extinguisher.Memo is
'��ע';

comment on column Extinguisher.ExtinguisherInfo is
'���˵��';

comment on column Extinguisher.Quantity is
'����';

comment on column Extinguisher.UpGradeTime is
'��װʱ��';

comment on column Extinguisher.ValidityYear is
'��Ч��';

comment on column Extinguisher.DownTime is
'ʧЧʱ��';

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
'�����������';

comment on column ExtinguisherType.ExtinguisherTypeID is
'�����������ID';

comment on column ExtinguisherType.ExtinguisherTypeName is
'���������������';

create table FaultIndicatorType  (
   FaultIndicatorTypeID INTEGER                         not null,
   FaultIndicatorTypeName VARCHAR2(32)                    not null,
   constraint PK_FAULTINDICATORTYPE primary key (FaultIndicatorTypeID)
);

comment on table FaultIndicatorType is
'����ָʾ������';

comment on column FaultIndicatorType.FaultIndicatorTypeID is
'����ID';

comment on column FaultIndicatorType.FaultIndicatorTypeName is
'��������';

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
'�ļ�����';

comment on column FileAttachment.FileNum is
'�ļ����';

comment on column FileAttachment.EmployeeID is
'�û�ID';

comment on column FileAttachment.BaseFacilityNum is
'��ʩ���';

comment on column FileAttachment.FileName is
'�ļ�����';

comment on column FileAttachment.FilePath is
'�ļ����·��';

comment on column FileAttachment.UpdateDate is
'�ϴ�ʱ��';

comment on column FileAttachment.FileMemo is
'�ļ���ע';

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
'����ǽ';

comment on column FireWall.AssetNum is
'�ʲ����';

comment on column FireWall.CompanyNum is
'�����ų��ұ��';

comment on column FireWall.monitor_CompanyNum is
'����_��λ���';

comment on column FireWall.FireWallStuffTypeID is
'����ǽ��������ID';

comment on column FireWall.EmployeeID is
'�û�ID';

comment on column FireWall.FireWallTypeID is
'����ǽ����ID';

comment on column FireWall.DoorStuffTypeID is
'�����Ų�������ID';

comment on column FireWall.bulid_CompanyNum is
'ʩ��_��λ���';

comment on column FireWall.Tunnel_AssetNum is
'����ͨ��_�ʲ����';

comment on column FireWall.AssetName is
'�ʲ�����';

comment on column FireWall.AssetCode is
'�ʲ�����';

comment on column FireWall.GraphID is
'ͼԪID';

comment on column FireWall.OperationCode is
'���б���';

comment on column FireWall.BuildDate is
'ʩ������';

comment on column FireWall.CompletedDate is
'��������';

comment on column FireWall.OperationDate is
'Ͷ������';

comment on column FireWall.PositionDescription is
'���ڷ�λ';

comment on column FireWall.Longitude is
'����';

comment on column FireWall.Latitude is
'γ��';

comment on column FireWall.Memo is
'��ע';

comment on column FireWall.WallSize is
'����ǽ���';

comment on column FireWall.DoorSize is
'�����Ź��';

comment on column FireWall.DoorBuildDate is
'�����ų�������';

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
'����ʯ��
ê�硢
ש��';

comment on column FireWallStuffType.FireWallStuffTypeID is
'����ǽ��������ID';

comment on column FireWallStuffType.FireWallStuffTypeName is
'����ǽ������������';

create table FireWallType  (
   FireWallTypeID       INTEGER                         not null,
   FireWallTypeName     VARCHAR2(32)                    not null,
   constraint PK_FIREWALLTYPE primary key (FireWallTypeID)
);

comment on table FireWallType is
'����
˫��
����';

comment on column FireWallType.FireWallTypeID is
'����ǽ����ID';

comment on column FireWallType.FireWallTypeName is
'����ǽ��������';

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
'ȱ�ݸ�����¼';

comment on column FlawAdjunctFile.AdjunctFileNum is
'�ļ���¼���';

comment on column FlawAdjunctFile.ObjFlawNum is
'��¼���';

comment on column FlawAdjunctFile.EmployeeID is
'�û�ID';

comment on column FlawAdjunctFile.AdjunctFileName is
'�ļ�����';

comment on column FlawAdjunctFile.AdjunctFilePath is
'�ļ����·��';

comment on column FlawAdjunctFile.UpdateDate is
'�ϴ�ʱ��';

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
'ȱ�ݴ�����˼�¼';

comment on column FlawAduitRecord.AduitRecordNum is
'��˼�¼���';

comment on column FlawAduitRecord.EmployeeID is
'�û�ID';

comment on column FlawAduitRecord.FlawAduitWayID is
'��˴���ʽID';

comment on column FlawAduitRecord.ObjFlawNum is
'��¼���';

comment on column FlawAduitRecord.AduitOpinion is
'������';

comment on column FlawAduitRecord.AduitDate is
'���ʱ��';

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
'ȱ�ݴ���״̬
�೤��ˡ�
ר����ˡ�
������ˡ�
�ݲ�����
������
����������ȱ��/����ȱ
������
����ȱ';

comment on column FlawAduitStatus.FlawAduitStatusID is
'ȱ��״̬ID';

comment on column FlawAduitStatus.FlawAduitStatusName is
'ȱ������';

comment on column FlawAduitStatus.ShowColor is
'״̬��ɫ';

create table FlawAduitWay  (
   FlawAduitWayID       INTEGER                         not null,
   FlawAduitWayName     VARCHAR2(32)                    not null,
   constraint PK_FLAWADUITWAY primary key (FlawAduitWayID)
);

comment on table FlawAduitWay is
'��˴���ʽ
�ݲ�����
����
���账��
�ϱ�';

comment on column FlawAduitWay.FlawAduitWayID is
'��˴���ʽID';

comment on column FlawAduitWay.FlawAduitWayName is
'����ʽ����';

create table FlawLevelType  (
   FlawLevelTypeID      INTEGER                         not null,
   FlawLevelTypeName    VARCHAR2(32)                    not null,
   constraint PK_FLAWLEVELTYPE primary key (FlawLevelTypeID)
);

comment on table FlawLevelType is
'ȱ���϶��ȼ�
һ��ȱ�ݡ�����ȱ�ݡ�Σ��ȱ��';

comment on column FlawLevelType.FlawLevelTypeID is
'ȱ�ݵȼ�ID';

comment on column FlawLevelType.FlawLevelTypeName is
'ȱ�ݵȼ�����';

create table FlawProcAcceptType  (
   FlawProcAcceptTypeID INTEGER                         not null,
   FlawProcAcceptTypeName VARCHAR2(32),
   constraint PK_FLAWPROCACCEPTTYPE primary key (FlawProcAcceptTypeID)
);

comment on table FlawProcAcceptType is
'����ȱ
δ��ȫ��ȱ
δ��ȱ';

comment on column FlawProcAcceptType.FlawProcAcceptTypeID is
'����ȷ������ID';

comment on column FlawProcAcceptType.FlawProcAcceptTypeName is
'��������';

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
'��ȱ����';

comment on column FlawProcFile.FileNum is
'�ļ����';

comment on column FlawProcFile.FlawProcObj is
'��ȱ�����¼���';

comment on column FlawProcFile.EmployeeID is
'�û�ID';

comment on column FlawProcFile.ProcAdjunctFile is
'�ļ�����';

comment on column FlawProcFile.FilePath is
'�ļ����·��';

comment on column FlawProcFile.UpdateDate is
'�ϴ�ʱ��';

comment on column FlawProcFile.FileMemo is
'�ļ���ע';

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
'��ȱ����';

comment on column FlawProcTask.FlawProcTaskNum is
'��ȱ������';

comment on column FlawProcTask.TaskStatusTypeID is
'����״̬ID';

comment on column FlawProcTask.EmployeeID is
'���񴴽���ID';

comment on column FlawProcTask.Task_EmployeeID is
'����������ID';

comment on column FlawProcTask.FlawProcTaskName is
'��ȱ��������';

comment on column FlawProcTask.FlawProcTaskDescption is
'��ȱ��������';

comment on column FlawProcTask.PlanDate is
'�ƻ�ʱ��';

comment on column FlawProcTask.WorkUserList is
'��ȱ��Ա����';

comment on column FlawProcTask.WorkBillsCode is
'����Ʊ��';

comment on column FlawProcTask.StartDateTime is
'��ʼʱ��';

comment on column FlawProcTask.CompleteDateTime is
'���ʱ��';

comment on column FlawProcTask.Memo is
'��ע';

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
'��ȱ���ݼ�¼';

comment on column FlawProcTaskObj.FlawProcObj is
'��ȱ�����¼���';

comment on column FlawProcTaskObj.FlawProcAcceptTypeID is
'����ȷ������ID';

comment on column FlawProcTaskObj.FlawProcTaskNum is
'��ȱ������';

comment on column FlawProcTaskObj.ObjFlawNum is
'��¼���';

comment on column FlawProcTaskObj.FlawPrcoDescription is
'��ȱ����˵��';

comment on column FlawProcTaskObj.FlawProcDate is
'��ȱ����ʱ��';

comment on column FlawProcTaskObj.Memo is
'��ע';

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
'ȱ����Դ����
1���ֳ�Ѳ��
2���������ߣ�95598��
3������';

comment on column FlawSourceType.FlawSourceTypeID is
'��Դ����ID';

comment on column FlawSourceType.FlawSourceName is
'��������';

create table FlawType  (
   FlawTypeID           INTEGER                         not null,
   FlawTypeName         VARCHAR2(32)                    not null,
   constraint PK_FLAWTYPE primary key (FlawTypeID)
);

comment on table FlawType is
'����ȱ��
��ˮȱ��
����ȱ��
��������
������
����';

comment on column FlawType.FlawTypeID is
'ȱ�ݷ���ID';

comment on column FlawType.FlawTypeName is
'ȱ�ݷ�������';

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
'Ѳ�����ݼ�¼
�������ͣ�
ͨ��
ͨ���Σ����鲻Ҫ����㣩
�ն���ʩ���������������ֽ��䡭����
����ǽ��
���װ��
��·����·�Σ�
����
�ն�ͷ
�м�ͷ
�ӵ���
';

comment on column InspectObjFlaw.ObjFlawNum is
'��¼���';

comment on column InspectObjFlaw.TaskNum is
'�����¼';

comment on column InspectObjFlaw.FlawTypeID is
'ȱ�ݷ���ID';

comment on column InspectObjFlaw.FlawSourceTypeID is
'��Դ����ID';

comment on column InspectObjFlaw.FlawLevelTypeID is
'ȱ�ݵȼ�ID';

comment on column InspectObjFlaw.FlawAduitStatusID is
'ȱ��״̬ID';

comment on column InspectObjFlaw.ObjTypeEnum is
'��������';

comment on column InspectObjFlaw.ObjTableNum is
'������';

comment on column InspectObjFlaw.ObjCode is
'�������';

comment on column InspectObjFlaw.IsFlaw is
'�Ƿ���ȱ��';

comment on column InspectObjFlaw.FlawDescription is
'ȱ������';

comment on column InspectObjFlaw.FlawDate is
'ȱ�ݼ�¼ʱ��';

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
'Ѳ������
���鳤����';

comment on column InspectTask.TaskNum is
'�����¼';

comment on column InspectTask.TeamTypeID is
'רҵ����ID';

comment on column InspectTask.EmployeeID is
'���񴴽���ID';

comment on column InspectTask.Task_EmployeeID is
'����������ID';

comment on column InspectTask.TaskStatusTypeID is
'����״̬ID';

comment on column InspectTask.TaskName is
'��������';

comment on column InspectTask.TaskDescription is
'������ϸ˵��';

comment on column InspectTask.PlanDate is
'����ƻ�ʱ��';

comment on column InspectTask.WorkUserList is
'Ѳ����Ա����';

comment on column InspectTask.WorkBillsCode is
'����Ʊ��';

comment on column InspectTask.StartDateTime is
'Ѳ�ӿ�ʼʱ��';

comment on column InspectTask.CompleteDateTime is
'Ѳ�����ʱ��';

comment on column InspectTask.Memo is
'��ע';

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
'�ܿ�
���
ֱ��';

comment on column InstallType.InstallTypeID is
'��������ID';

comment on column InstallType.InstallTypeName is
'������������';

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
'ͨ������
���ս����̶����ͣ�1��ͨ2����';

comment on column Ledger.ArchivesNum is
'������¼���';

comment on column Ledger.BaseFacilityNum is
'��ʩ���';

comment on column Ledger.monitor_CompanyNum is
'����_��λ���';

comment on column Ledger.AssetBorderTypeID is
'�ʲ��߽�����ID';

comment on column Ledger.EmployeeID is
'�û�ID';

comment on column Ledger.AcceptStatusTypeID is
'����״̬����ID';

comment on column Ledger.bulid_CompanyNum is
'ʩ��_��λ���';

comment on column Ledger.ArchivesCode is
'��������';

comment on column Ledger.ArchivesName is
'��������';

comment on column Ledger.MonitorCompany is
'����λ';

comment on column Ledger.BuildCompany is
'ʩ����λ';

comment on column Ledger.BluePrintCode is
'Сͼ���';

comment on column Ledger.ArchivesPlace is
'�������λ��';

comment on column Ledger.BluePrintPlace is
'ͼֽ���λ��';

comment on column Ledger.DrawerCode is
'���ڵ�����';

comment on column Ledger.Address is
'�豸��ַ';

comment on column Ledger.Specification is
'�豸����';

comment on column Ledger.BuildDate is
'ʩ������';

comment on column Ledger.CompleteDate is
'��������';

comment on column Ledger.IsRush is
'�Ӽ����ձ�־';

comment on column Ledger.ArchivesTime is
'¼��ʱ��';

comment on column Ledger.Memo is
'��ע';

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
'��·�ӵ���';

comment on column LoopEarthBox.LoopBoxNum is
'���';

comment on column LoopEarthBox.LoopNum is
'��·���';

comment on column LoopEarthBox.AttachmentNum is
'���¸������';

comment on column LoopEarthBox.Place is
'��װλ��';

comment on column LoopEarthBox.Distance is
'����·��������';

comment on column LoopEarthBox.InstallDate is
'��װʱ��';

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
'����
���⾮
���վ���߾�
�ֽ���
����
���
������
����

';

comment on column Manhole.AssetNum is
'�ʲ����';

comment on column Manhole.ManholeShapeTypeID is
'������״����ID';

comment on column Manhole.AreaNum is
'Ƭ�����';

comment on column Manhole.CompanyNum is
'������ʩ���ұ��';

comment on column Manhole.CoverShapeTypeID is
'������ʩ��״����ID';

comment on column Manhole.monitor_CompanyNum is
'����_��λ���';

comment on column Manhole.CoverStuffTypeID is
'������ʩ��������ID';

comment on column Manhole.EmployeeID is
'�û�ID';

comment on column Manhole.ManholeKindTypeID is
'��������ID';

comment on column Manhole.bulid_CompanyNum is
'ʩ��_��λ���';

comment on column Manhole.BaseFacilityNum is
'��ʩ���';

comment on column Manhole.ManholeStuffTypeID is
'������������ID';

comment on column Manhole.ManholeCoverTypeID is
'������ʩ��ʩ����ID';

comment on column Manhole.Tunnel_AssetNum is
'����ͨ��_�ʲ����';

comment on column Manhole.AssetName is
'�ʲ�����';

comment on column Manhole.AssetCode is
'�ʲ�����';

comment on column Manhole.GraphID is
'ͼԪID';

comment on column Manhole.OperationCode is
'���б���';

comment on column Manhole.BuildDate is
'ʩ������';

comment on column Manhole.CompletedDate is
'��������';

comment on column Manhole.OperationDate is
'Ͷ������';

comment on column Manhole.PositionDescription is
'���ڷ�λ';

comment on column Manhole.Longitude is
'����';

comment on column Manhole.Latitude is
'γ��';

comment on column Manhole.Memo is
'��ע';

comment on column Manhole.Length is
'����';

comment on column Manhole.Width is
'���';

comment on column Manhole.Diameter is
'ֱ��';

comment on column Manhole.Height is
'����߳�';

comment on column Manhole.BottomHeight is
'���׸߳�';

comment on column Manhole.TerraceLayerCount is
'ƽ̨����';

comment on column Manhole.OutLineQuantity is
'���߹���';

comment on column Manhole.ManHoleCoverCode is
'������ʩ����';

comment on column Manhole.ManHoleCoverSize is
'������ʩ�ߴ�';

comment on column Manhole.ViewLon is
'�ӵ㾭��';

comment on column Manhole.ViewLat is
'�ӵ�γ��';

comment on column Manhole.ViewHeight is
'�ӵ�߶�';

comment on column Manhole.ViewAngle is
'�ӵ����';

comment on column Manhole.ViewHeading is
'�ӵ㷽λ';

comment on column Manhole.ViewRange is
'�ӵ㷶Χ';

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
'����
��¥';

comment on column ManholeCoverType.ManholeCoverTypeID is
'������ʩ��ʩ����ID';

comment on column ManholeCoverType.ManholeCoverTypeName is
'������ʩ��ʩ��������';

create table ManholeKindType  (
   ManholeKindTypeID    INTEGER                         not null,
   ManholeTypeID        INTEGER                         not null,
   ManholeKindTypeName  VARCHAR2(32)                    not null,
   Prefix               VARCHAR2(8),
   LayerIcon            VARCHAR2(32),
   constraint PK_MANHOLEKINDTYPE primary key (ManholeKindTypeID)
);

comment on table ManholeKindType is
'���¾���
ֱ�߾���
ת�Ǿ���
��ͨ����
�ն˾�����

���⾮��
֧�ܱ䶯
���±䶯
���߱䶯

���վ����

�ֽ���
����
���
������
';

comment on column ManholeKindType.ManholeKindTypeID is
'��������ID';

comment on column ManholeKindType.ManholeTypeID is
'������������ID';

comment on column ManholeKindType.ManholeKindTypeName is
'������������';

comment on column ManholeKindType.Prefix is
'����ǰ׺';

comment on column ManholeKindType.LayerIcon is
'ͼ����Դ����';

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
'ÿ�����ε���ֹ�ն���ʩ
�ɺϲ���ͨ�����Σ���������ݲ��Ķ���';

comment on column ManholeOfSection.Num is
'���';

comment on column ManholeOfSection.SectionNum is
'�������α��';

comment on column ManholeOfSection.AssetNum is
'�ʲ����';

comment on column ManholeOfSection.OrderNum is
'���';

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
'��ʩ����ͨ��';

comment on column ManholeOfTunnel.BuildOfTunnelNum is
'�����������';

comment on column ManholeOfTunnel.AssetNum is
'�ʲ����';

comment on column ManholeOfTunnel.Man_AssetNum is
'�ն���_�ʲ����';

comment on column ManholeOfTunnel.IsEndpoint is
'�Ƿ���ֹ��';

comment on column ManholeOfTunnel.OrderNum is
'˳����';

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
'������״����';

comment on column ManholeShapeType.ManholeShapeTypeID is
'������״����ID';

comment on column ManholeShapeType.ManholeShapeTypeName is
'������״��������';

create table ManholeStuffType  (
   ManholeStuffTypeID   INTEGER                         not null,
   ManholeStuffTypeName VARCHAR2(32),
   constraint PK_MANHOLESTUFFTYPE primary key (ManholeStuffTypeID)
);

comment on table ManholeStuffType is
'����ʯ��
ê�硢
ש��';

comment on column ManholeStuffType.ManholeStuffTypeID is
'������������ID';

comment on column ManholeStuffType.ManholeStuffTypeName is
'����������������';

create table ManholeType  (
   ManholeTypeID        INTEGER                         not null,
   ManholeTypeName      VARCHAR2(32)                    not null,
   constraint PK_MANHOLETYPE primary key (ManholeTypeID)
);

comment on table ManholeType is
'���¾�
���⾮
���վ�����߾���
�ն���ʩ';

comment on column ManholeType.ManholeTypeID is
'������������ID';

comment on column ManholeType.ManholeTypeName is
'����������������';

create table MaxPrimaryKey  (
   TabName              VARCHAR2(64)                    not null,
   MaxVal               INTEGER                         not null,
   constraint PK_MAXPRIMARYKEY primary key (TabName)
);

comment on table MaxPrimaryKey is
'����ID��';

comment on column MaxPrimaryKey.TabName is
'����';

comment on column MaxPrimaryKey.MaxVal is
'��ǰ���ֵ';

create table OperationLog  (
   LogNum               INTEGER                         not null,
   TypeID               INTEGER                         not null,
   EmployeeID           VARCHAR2(16)                    not null,
   Content              VARCHAR2(255)                   not null,
   LogDateTime          DATE                            not null,
   constraint PK_OPERATIONLOG primary key (LogNum)
);

comment on table OperationLog is
'������־';

comment on column OperationLog.LogNum is
'��¼���';

comment on column OperationLog.TypeID is
'��������ID';

comment on column OperationLog.EmployeeID is
'�û�ID';

comment on column OperationLog.Content is
'��������';

comment on column OperationLog.LogDateTime is
'��־ʱ��';

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
'��������';

comment on column OperationType.TypeID is
'��������ID';

comment on column OperationType.TypeName is
'������������';

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
'��λ/����/����';

comment on column Organization.OrganizationNum is
'��λ���';

comment on column Organization.ParentID is
'��λ/_��λ���';

comment on column Organization.TeamTypeID is
'רҵ����ID';

comment on column Organization.OrganizationName is
'����';

comment on column Organization.Description is
'����';

comment on column Organization.Visible is
'�Ƿ�ɼ�';

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
'��·���ռ�¼';

comment on column PathAduitRecord.AcceptRecordNum is
'���ռ�¼���';

comment on column PathAduitRecord.TaskStatusTypeID is
'����״̬ID';

comment on column PathAduitRecord.Num is
'�������';

comment on column PathAduitRecord.EmployeeID is
'���񴴽���ID';

comment on column PathAduitRecord.Task_EmployeeID is
'����������ID';

comment on column PathAduitRecord.PlanName is
'��ҵ����';

comment on column PathAduitRecord.WorkBillsCode is
'����Ʊ��';

comment on column PathAduitRecord.PlanDate is
'���ռƻ�ʱ��';

comment on column PathAduitRecord.AcceptUserList is
'������Ա����';

comment on column PathAduitRecord.AcceptOpinion is
'�������';

comment on column PathAduitRecord.AcceptDate is
'����ʱ��';

comment on column PathAduitRecord.AuditResult is
'������';

comment on column PathAduitRecord.AuditDate is
'���ʱ��';

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
'��·��������';

comment on column PathArchivesFile.ArchivesFileNum is
'�ļ���¼���';

comment on column PathArchivesFile.Num is
'�������';

comment on column PathArchivesFile.ArchivesFileTypeID is
'�ļ�����ID';

comment on column PathArchivesFile.AcceptRecordNum is
'���ռ�¼���';

comment on column PathArchivesFile.EmployeeID is
'�û�ID';

comment on column PathArchivesFile.ArchivesFileName is
'�ļ�����';

comment on column PathArchivesFile.ArchivesFilePath is
'�ļ����·��';

comment on column PathArchivesFile.ArchivesFileUpDate is
'�ύʱ��';

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
'��·������������';

comment on column PathArchivesFileType.ArchivesFileTypeID is
'�ļ�����ID';

comment on column PathArchivesFileType.ArchivesFileTypeName is
'�ļ���������';

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
'����������ϵ���';

comment on column PathCable.CableNum is
'���±��';

comment on column PathCable.PhaseTypeID is
'��λ����ID';

comment on column PathCable.ModelTypeNum is
'�����';

comment on column PathCable.LoopNum is
'��·���';

comment on column PathCable.CableName is
'��������';

comment on column PathCable.RunCode is
'���б��';

comment on column PathCable.RunDate is
'Ͷ��ʱ��';

comment on column PathCable.IsExpEarthLine is
'�ӵ�����';

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
'��·��';

comment on column PathSection.PathSectionNum is
'���';

comment on column PathSection.CablePathNum is
'��·���';

comment on column PathSection.SafeEarthTypeID is
'�ӵط�ʽ����ID';

comment on column PathSection.InstallTypeID is
'��������ID';

comment on column PathSection.ParentSectionNum is
'��·��_�����';

comment on column PathSection.BaseFacilityNum is
'��ʩ���';

comment on column PathSection.begin_AssetNum is
'�����ʩ���';

comment on column PathSection.end_AssetNum is
'ֹ����ʩ���';

comment on column PathSection.PathSectionCode is
'��·�α���';

comment on column PathSection.PathSectionName is
'��·������';

comment on column PathSection.PlaceInfo is
'���˵��';

comment on column PathSection.PlaceInfo2 is
'ֹ��˵��';

comment on column PathSection.LoopCount is
'����';

comment on column PathSection.LineCount is
'����';

comment on column PathSection.LoopLenght is
'�س�';

comment on column PathSection.IsExpEarthLine is
'�ӵ�����';

comment on column PathSection.EarthConnectorType is
'�ӵ���������';

comment on column PathSection.Memo is
'��ע';

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
'��·��Ͷ��״̬��¼';

comment on column PathSectionRunStatusRecord.StatusRecordNum is
'״̬��¼���';

comment on column PathSectionRunStatusRecord.LoopNum is
'��·���';

comment on column PathSectionRunStatusRecord.StatusDate is
'״̬�仯ʱ��';

comment on column PathSectionRunStatusRecord.Reason is
'״̬�仯ԭ��';

create index Relationship_192_FK on PathSectionRunStatusRecord (
   LoopNum ASC
);

create table PathType  (
   PathTypeID           INTEGER                         not null,
   PathTypeName         VARCHAR2(32)                    not null,
   constraint PK_PATHTYPE primary key (PathTypeID)
);

comment on table PathType is
'��磨��ָ���վ����·��������ѹ���֣�
���
���';

comment on column PathType.PathTypeID is
'��·����ID';

comment on column PathType.PathTypeName is
'��·��������';

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
'��λ����ID';

comment on column PhaseType.PhaseTypeName is
'��λ��������';

comment on column PhaseType.IsEarthPhase is
'�Ƿ����';

comment on column PhaseType.PhaseColor is
'��ɫ';

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
����';

comment on column PowerCableLevel.VoltageLevelID is
'��ѹ�ȼ�ID';

comment on column PowerCableLevel.VoltageLevelName is
'��ѹ�ȼ�����';

comment on column PowerCableLevel.VoltageValue is
'��ѹֵ';

comment on column PowerCableLevel.ShowColor is
'��ʾ��ɫ';

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
'ͨ����ѹ�ȼ�������ɫ��';

comment on column PowerLevelTunnelColor.LevelTunnelNum is
'ͨ���ȼ����';

comment on column PowerLevelTunnelColor.VoltageLevelID is
'��ѹ�ȼ�ID';

comment on column PowerLevelTunnelColor.TunnelStructureTypeID is
'�����ṹ����ID';

comment on column PowerLevelTunnelColor.LevelTunnelName is
'��ѹ�ȼ�ͨ������';

comment on column PowerLevelTunnelColor.ShowColor is
'��ʾ��ɫ';

comment on column PowerLevelTunnelColor.LineWidth is
'�߾�';

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
'ÿ�ذ����������
����һ���ӵػ�·';

comment on column PowerLoop.LoopNum is
'��·���';

comment on column PowerLoop.PathSectionNum is
'���';

comment on column PowerLoop.AttachmentStatusTypeID is
'״̬ID';

comment on column PowerLoop.LoopName is
'��·����';

comment on column PowerLoop.RunCode is
'���б��';

comment on column PowerLoop.RunDate is
'Ͷ��ʱ��';

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
'���/����
�Ź�
����
ֱ��
';

comment on column PowerTunnel.AssetNum is
'�ʲ����';

comment on column PowerTunnel.VoltageLevelID is
'��ѹ�ȼ�ID';

comment on column PowerTunnel.monitor_CompanyNum is
'����_��λ���';

comment on column PowerTunnel.ArchivesNum is
'������¼���';

comment on column PowerTunnel.TunnelStuffTypeID is
'��������ID';

comment on column PowerTunnel.EmployeeID is
'�û�ID';

comment on column PowerTunnel.bulid_CompanyNum is
'ʩ��_��λ���';

comment on column PowerTunnel.TunnelShapeTypeID is
'������״ID';

comment on column PowerTunnel.AreaNum is
'Ƭ�����';

comment on column PowerTunnel.TrestleTypeInfoID is
'��������ID';

comment on column PowerTunnel.OrganizationNum is
'��������';

comment on column PowerTunnel.TunnelStructureTypeID is
'�����ṹ����ID';

comment on column PowerTunnel.AssetName is
'�ʲ�����';

comment on column PowerTunnel.AssetCode is
'�ʲ�����';

comment on column PowerTunnel.GraphID is
'ͼԪID';

comment on column PowerTunnel.OperationCode is
'���б���';

comment on column PowerTunnel.BuildDate is
'ʩ������';

comment on column PowerTunnel.CompletedDate is
'��������';

comment on column PowerTunnel.OperationDate is
'Ͷ������';

comment on column PowerTunnel.PositionDescription is
'���ڷ�λ';

comment on column PowerTunnel.Ass_Longitude is
'�ʲ���_����';

comment on column PowerTunnel.Ass_Latitude is
'�ʲ���_γ��';

comment on column PowerTunnel.Memo is
'��ע';

comment on column PowerTunnel.TunnelLength is
'����';

comment on column PowerTunnel.TunnelHeight is
'�߶�';

comment on column PowerTunnel.TunnelWidth is
'���';

comment on column PowerTunnel.Diameter is
'ֱ��';

comment on column PowerTunnel.FrontTopHeight is
'�������';

comment on column PowerTunnel.TailTopHeight is
'ĩ�˸������';

comment on column PowerTunnel.Latitude is
'ֹ�㾭��';

comment on column PowerTunnel.Longitude is
'ֹ��γ��';

comment on column PowerTunnel.TrestleInterval is
'֧�ܼ��';

comment on column PowerTunnel.TrestleTypeDescription is
'֧�ܹ������';

comment on column PowerTunnel.StartStopDescription is
'��ֹ�ص�';

comment on column PowerTunnel.IsPlan is
'�Ƿ�滮״̬';

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
'��������
С�����ס����ޡ����ġ�Ǩ��';

comment on column ProjectType.ProjectTypeID is
'��������ID';

comment on column ProjectType.ProjectTypeName is
'������������';

create table RoleFunctions  (
   RoleFunctionID       INTEGER                         not null,
   RoleNum              INTEGER                         not null,
   ApplicationModuleID  INTEGER                         not null,
   constraint PK_ROLEFUNCTIONS primary key (RoleFunctionID)
);

comment on table RoleFunctions is
'ģ���ɫ��ϵ��';

comment on column RoleFunctions.RoleFunctionID is
'Ȩ��ID';

comment on column RoleFunctions.RoleNum is
'��ɫ���';

comment on column RoleFunctions.ApplicationModuleID is
'����ID';

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
'��ɫ';

comment on column Roles.RoleNum is
'��ɫ���';

comment on column Roles.RoleName is
'��ɫ����';

comment on column Roles."Comment" is
'��ɫ����';

create table RowTube  (
   RowTubeNum           INTEGER                         not null,
   RowTubeTypeID        INTEGER                         not null,
   TrestleLayerNum      INTEGER                         not null,
   RowTubeOrder         INTEGER                         not null,
   constraint PK_ROWTUBE primary key (RowTubeNum)
);

comment on table RowTube is
'λ�ã�
���������ԴӶ�����Ϊ���򣬴������Ҽ���˳��
�ϱ������Դ�����Ϊ���򣬴������Ҽ���˳��
';

comment on column RowTube.RowTubeNum is
'�Źܱ��';

comment on column RowTube.RowTubeTypeID is
'�����';

comment on column RowTube.TrestleLayerNum is
'�㼶���';

comment on column RowTube.RowTubeOrder is
'λ��˳��';

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
'�����';

comment on column RowTubeType.RowTubeTypeName is
'���˵��';

comment on column RowTubeType.RowTubeDiameter is
'ֱ��';

create table RunRecord  (
   RecordNum            INTEGER                         not null,
   AttachmentStatusTypeID INTEGER,
   AttachmentNum        INTEGER                         not null,
   RecordDate           DATE                            not null,
   Reason               VARCHAR2(255),
   constraint PK_RUNRECORD primary key (RecordNum)
);

comment on table RunRecord is
'������ʩͶ�����˼�¼';

comment on column RunRecord.RecordNum is
'��¼���';

comment on column RunRecord.AttachmentStatusTypeID is
'״̬ID';

comment on column RunRecord.AttachmentNum is
'���¸������';

comment on column RunRecord.RecordDate is
'ʱ��';

comment on column RunRecord.Reason is
'״̬�仯ԭ��';

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
'δ��װ
��ˮ
����ˮ';

comment on column SafeBoxType.SafeBoxTypeID is
'����ID';

comment on column SafeBoxType.SafeBoxTypeName is
'��������';

create table SafeEarthType  (
   SafeEarthTypeID      INTEGER                         not null,
   SafeEarthTypeName    VARCHAR2(64)                    not null,
   constraint PK_SAFEEARTHTYPE primary key (SafeEarthTypeID)
);

comment on table SafeEarthType is
'ֱ�ӽӵ�
һ�˽ӵ�
�����ӵ�';

comment on column SafeEarthType.SafeEarthTypeID is
'�ӵط�ʽ����ID';

comment on column SafeEarthType.SafeEarthTypeName is
'�ӵط�ʽ��������';

create table TaskStatusType  (
   TaskStatusTypeID     INTEGER                         not null,
   TaskStatusTypeName   VARCHAR2(255)                   not null,
   constraint PK_TASKSTATUSTYPE primary key (TaskStatusTypeID)
);

comment on table TaskStatusType is
'����״̬
�ƻ�״̬��ִ��״̬�����״̬';

comment on column TaskStatusType.TaskStatusTypeID is
'����״̬ID';

comment on column TaskStatusType.TaskStatusTypeName is
'����״̬����';

create table TeamType  (
   TeamTypeID           INTEGER                         not null,
   TeamTypeName         VARCHAR2(32)                    not null,
   constraint PK_TEAMTYPE primary key (TeamTypeID)
);

comment on table TeamType is
'רҵ����
��������硢���
';

comment on column TeamType.TeamTypeID is
'רҵ����ID';

comment on column TeamType.TeamTypeName is
'רҵ��������';

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
'��Ƭ��ͼֽ������';

comment on column TerminalFile.FileNum is
'�����ļ����';

comment on column TerminalFile.EmployeeID is
'�û�ID';

comment on column TerminalFile.AssetNum is
'�ʲ����';

comment on column TerminalFile.FileName is
'�����ļ�����';

comment on column TerminalFile.FilePath is
'�ļ�λ��';

comment on column TerminalFile.UpdateDate is
'�ϴ�ʱ��';

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
'���֧��
�Ҳ�֧��
���֧��

֧�ܷ�λ�ɹ�����������ȷ��
���������Ϊ�������ϱ�
���������֧�ܷ�λΪ���ɶ������������Ϊ�ϲ࣬�Ҳ�Ϊ����
�ϱ������֧�ܷ�λΪ�������򱱷������Ϊ���࣬�Ҳ�Ϊ����';

comment on column TrestleDirectionType.TrestlePositionTypeID is
'֧��λ������ID';

comment on column TrestleDirectionType.TrestlePositionTypeName is
'֧��λ����������';

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
'֧�ܲ����������֧�������ĸ߶�
��ע����˵��֧�ܲ�����������';

comment on column TrestleLayer.TrestleLayerNum is
'�㼶���';

comment on column TrestleLayer.TrestlePositionTypeID is
'֧��λ������ID';

comment on column TrestleLayer.VoltageLevelID is
'��ѹ�ȼ�ID';

comment on column TrestleLayer.SectionNum is
'�������α��';

comment on column TrestleLayer.TrestleStuffTypeID is
'֧�ܲ�������ID';

comment on column TrestleLayer.Layer is
'�㼶';

comment on column TrestleLayer.TrestleLength is
'֧�ܳ���';

comment on column TrestleLayer.Height is
'���';

comment on column TrestleLayer.Memo is
'��ע';

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
'֧�ܲ�������';

comment on column TrestleStuffType.TrestleStuffTypeID is
'֧�ܲ�������ID';

comment on column TrestleStuffType.TrestleStuffTypeName is
'֧�ܲ�����������';

create table TrestleTypeInfo  (
   TrestleTypeInfoID    INTEGER                         not null,
   TrestleTypeInfoName  VARCHAR2(32)                    not null,
   constraint PK_TRESTLETYPEINFO primary key (TrestleTypeInfoID)
);

comment on table TrestleTypeInfo is
'����˫�ࡢ�������ࡢ����֧�ܡ���';

comment on column TrestleTypeInfo.TrestleTypeInfoID is
'��������ID';

comment on column TrestleTypeInfo.TrestleTypeInfoName is
'������������';

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
'ͨ�����ռ�¼';

comment on column TunnelAduitRecord.AcceptRecordNum is
'���ռ�¼���';

comment on column TunnelAduitRecord.ArchivesNum is
'������¼���';

comment on column TunnelAduitRecord.TaskStatusTypeID is
'����״̬ID';

comment on column TunnelAduitRecord.EmployeeID is
'���񴴽���ID';

comment on column TunnelAduitRecord.Task_EmployeeID is
'����������ID';

comment on column TunnelAduitRecord.PlanName is
'��ҵ����';

comment on column TunnelAduitRecord.WorkBillsCode is
'����Ʊ��';

comment on column TunnelAduitRecord.PlanDate is
'���ռƻ�ʱ��';

comment on column TunnelAduitRecord.AcceptUserList is
'������Ա����';

comment on column TunnelAduitRecord.AcceptOpinion is
'�������';

comment on column TunnelAduitRecord.AcceptDate is
'����ʱ��';

comment on column TunnelAduitRecord.AuditResult is
'������';

comment on column TunnelAduitRecord.AuditDate is
'���ʱ��';

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
'ͨ����������';

comment on column TunnelArchivesFile.ArchivesFileNum is
'�ļ���¼���';

comment on column TunnelArchivesFile.EmployeeID is
'�û�ID';

comment on column TunnelArchivesFile.AcceptRecordNum is
'���ռ�¼���';

comment on column TunnelArchivesFile.ArchivesNum is
'������¼���';

comment on column TunnelArchivesFile.ArchivesFileTypeID is
'�ļ�����ID';

comment on column TunnelArchivesFile.ArchivesFileName is
'�ļ�����';

comment on column TunnelArchivesFile.ArchivesFilePath is
'�ļ����·��';

comment on column TunnelArchivesFile.ArchivesFileUpDate is
'�ύʱ��';

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
'ͨ������';

comment on column TunnelSection.SectionNum is
'�������α��';

comment on column TunnelSection.TunnleTowardTypeID is
'��������ID';

comment on column TunnelSection.AssetNum is
'�ʲ����';

comment on column TunnelSection.Length is
'���γ���';

comment on column TunnelSection.OrderNum is
'˳����';

comment on column TunnelSection.FrontTopHeight is
'�׶˸������';

comment on column TunnelSection.TailTopHeight is
'ĩ�˸������';

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
'������
����
Բ��
�˱�ɲ�ʹ�ã��û���ͨ������Ĭ��';

comment on column TunnelShapeType.TunnelShapeTypeID is
'������״ID';

comment on column TunnelShapeType.TunnelShapeTypeName is
'������״����';

create table TunnelStructureType  (
   TunnelStructureTypeID INTEGER                         not null,
   TunnelStructureTypeName VARCHAR2(64),
   Prefix               VARCHAR2(8),
   ShowColor            VARCHAR2(8),
   LineWidth            INTEGER,
   constraint PK_TUNNELSTRUCTURETYPE primary key (TunnelStructureTypeID)
);

comment on table TunnelStructureType is
'���
����
�Ź�
����
ֱ��
';

comment on column TunnelStructureType.TunnelStructureTypeID is
'�����ṹ����ID';

comment on column TunnelStructureType.TunnelStructureTypeName is
'�����ṹ��������';

comment on column TunnelStructureType.Prefix is
'����ǰ׺';

comment on column TunnelStructureType.ShowColor is
'��ʾ��ɫ';

comment on column TunnelStructureType.LineWidth is
'�߾�';

create table TunnelStuffType  (
   TunnelStuffTypeID    INTEGER                         not null,
   TunnelStructureTypeID INTEGER,
   TunnelStuffTypeName  VARCHAR2(32)                    not null,
   constraint PK_TUNNELSTUFFTYPE primary key (TunnelStuffTypeID)
);

comment on table TunnelStuffType is
'����ʯ��
ê�硢
ש��';

comment on column TunnelStuffType.TunnelStuffTypeID is
'��������ID';

comment on column TunnelStuffType.TunnelStructureTypeID is
'�����ṹ����ID';

comment on column TunnelStuffType.TunnelStuffTypeName is
'������������';

create index Relationship_63_FK on TunnelStuffType (
   TunnelStructureTypeID ASC
);

create table TunnleTowardType  (
   TunnleTowardTypeID   INTEGER                         not null,
   TunnleTowardTypeName VARCHAR2(32)                    not null,
   constraint PK_TUNNLETOWARDTYPE primary key (TunnleTowardTypeID)
);

comment on table TunnleTowardType is
'����
�ϱ�';

comment on column TunnleTowardType.TunnleTowardTypeID is
'��������ID';

comment on column TunnleTowardType.TunnleTowardTypeName is
'������������';

create table UserRoles  (
   UserRolesID          INTEGER                         not null,
   RoleNum              INTEGER                         not null,
   EmployeeID           VARCHAR2(16)                    not null,
   constraint PK_USERROLES primary key (UserRolesID)
);

comment on table UserRoles is
'�û���ɫ��';

comment on column UserRoles.UserRolesID is
'�û���ɫȨ��ID';

comment on column UserRoles.RoleNum is
'��ɫ���';

comment on column UserRoles.EmployeeID is
'�û�ID';

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

