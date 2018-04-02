/*==============================================================*/
/* View: v_TunnelArchivesFile                                      */
/*==============================================================*/
CREATE OR REPLACE VIEW v_TunnelArchivesFile as(
SELECT TunnelArchivesFile.ArchivesFileNum, TunnelArchivesFile.AcceptRecordNum, TunnelArchivesFile.ArchivesNum, TunnelArchivesFile.ArchivesFileTypeID, 
           TunnelArchivesFile.ArchivesFileName, TunnelArchivesFile.ArchivesFilePath, TunnelArchivesFile.ArchivesFileUpDate, ArchivesFileType.ArchivesFileTypeName, 
           Employee.UserName, TunnelArchivesFile.EmployeeID
      FROM TunnelArchivesFile INNER JOIN  ArchivesFileType ON ArchivesFileType.ArchivesFileTypeID = TunnelArchivesFile.ArchivesFileTypeID 
           LEFT OUTER JOIN Employee ON TunnelArchivesFile.EmployeeID = Employee.EmployeeID);
/*==============================================================*/
/* View: v_AccessFunction                                      */
/*==============================================================*/
CREATE OR REPLACE VIEW v_AccessFunction as(
SELECT AccessFunction.ApplicationModuleID, AccessFunction.PARENTMODULEID, AccessFunction.ApplicationModuleName, AccessFunction.Context, AccessFunction.IsDisplay, 
       AccessFunction.FunctionPath, AccessFunction.ApplicationModuleName AS ParentApplicationModuleName
    FROM AccessFunction INNER JOIN AccessFunction AccessFunction_Parent ON AccessFunction.PARENTMODULEID = AccessFunction_Parent.ApplicationModuleID);
/*==============================================================*/
/* View: v_AttachmentModelType                                  */
/*==============================================================*/
CREATE OR REPLACE VIEW v_AttachmentModelType as(
SELECT AttachmentModelType.ModelTypeNum, AttachmentModelType.AttachmentTypeID, AttachmentModelType.PathTypeID, AttachmentModelType.ModelTypeName, 
           CableAttachmentType.AttachmentTypeName, PathType.PathTypeName
	  FROM AttachmentModelType LEFT OUTER JOIN CableAttachmentType ON AttachmentModelType.AttachmentTypeID = CableAttachmentType.AttachmentTypeID 
	       LEFT OUTER JOIN PathType ON AttachmentModelType.PathTypeID = PathType.PathTypeID);
/*==============================================================*/
/* View: v_AttachmentOfCable                                      */
/*==============================================================*/
CREATE OR REPLACE VIEW v_AttachmentOfCable as(
SELECT AttachmentOfCable.RecordNum, AttachmentOfCable.Cab_AttachmentNum, AttachmentOfCable.Start_AttachmentNum, AttachmentOfCable.End_AttachmentNum, 
       AttachmentOfCable.CableNum, AttachmentOfCable.Place, AttachmentOfCable.Distance, AttachmentOfCable.InstallDate, CableAttachment.Num, 
       CableAttachment.AttachmentTypeID, CableAttachment.CompanyNum, CableAttachment.PathTypeID, CableAttachment.AttachmentStatusTypeID, 
       CableAttachment.AttachmentName, CableAttachment.AssetCode, CableAttachment_Begin.AttachmentTypeID AS AttachmentTypeID_Begin, 
       CableAttachment_Begin.CompanyNum AS CompanyNum_Begin, CableAttachment_Begin.AttachmentStatusTypeID AS AttachmentStatusTypeID_Begin, 
       CableAttachment_Begin.AttachmentName AS AttachmentName_Begin, CableAttachment_Begin.AssetCode AS AssetCode_Begin, CableAttachment_End.AttachmentTypeID AS AttachmentTypeID_End, 
       CableAttachment_End.CompanyNum AS CompanyNum_End, CableAttachment_End.AttachmentStatusTypeID AS AttachmentStatusTypeID_End, 
       CableAttachment_End.AttachmentName AS AttachmentName_End, CableAttachment_End.AssetCode AS AssetCode_End, PathCable.PhaseTypeID, PathCable.LoopNum, 
       PathCable.CableName, PathCable.RunCode AS CableRunCode, PathCable.RunDate AS CableRunDate, PowerLoop.PathSectionNum, PowerLoop.LoopName, 
       PathSection.CablePathNum, PathCable.ModelTypeNum, AttachmentModelType.ModelTypeName, 
       CableAttachment.AssetCode + '(' + CableAttachmentType.AttachmentTypeName + ')' AS CodeName, CableAttachmentType.AttachmentTypeName, 
       CableAttachmentType_Begin.AttachmentTypeName AS AttachmentTypeName_Begin, CableAttachmentType_End.AttachmentTypeName AS AttachmentTypeName_End
    FROM AttachmentOfCable INNER JOIN CableAttachment ON AttachmentOfCable.Cab_AttachmentNum = CableAttachment.AttachmentNum 
         INNER JOIN CableAttachmentType ON CableAttachmentType.AttachmentTypeID = CableAttachment.AttachmentTypeID
         INNER JOIN PathCable ON AttachmentOfCable.CableNum = PathCable.CableNum
       INNER JOIN PowerLoop ON PathCable.LoopNum = PowerLoop.LoopNum 
       INNER JOIN PathSection ON PowerLoop.PathSectionNum = PathSection.PathSectionNum 
       LEFT OUTER JOIN CableAttachment CableAttachment_Begin ON CableAttachment_Begin.AttachmentNum = AttachmentOfCable.CAB_ATTACHMENTNUM
       LEFT OUTER JOIN CableAttachmentType CableAttachmentType_Begin ON CableAttachmentType_Begin.AttachmentTypeID = CableAttachment_Begin.AttachmentTypeID  LEFT OUTER JOIN CableAttachment CableAttachment_End ON CableAttachment_End.AttachmentNum = AttachmentOfCable.CAB_ATTACHMENTNUM
       LEFT OUTER JOIN CableAttachmentType CableAttachmentType_End ON CableAttachmentType_End.AttachmentTypeID = CableAttachment_End.AttachmentTypeID
       LEFT OUTER JOIN AttachmentModelType ON AttachmentModelType.ModelTypeNum = PathCable.ModelTypeNum);
/*==============================================================*/
/* View: v_LoopEarthBox                                      */
/*==============================================================*/
CREATE OR REPLACE VIEW v_LoopEarthBox as(
SELECT LoopEarthBox.LoopBoxNum, LoopEarthBox.LoopNum, LoopEarthBox.AttachmentNum, LoopEarthBox.Place, LoopEarthBox.Distance, LoopEarthBox.InstallDate, 
       CableAttachment.ModelTypeNum, CableAttachment.Num, CableAttachment.FaultIndicatorTypeID, CableAttachment.SafeBoxTypeID, CableAttachment.AttachmentTypeID, 
       CableAttachment.CompanyNum, CableAttachment.PathTypeID, CableAttachment.AttachmentStatusTypeID, CableAttachment.Lon, CableAttachment.Lat, 
       CableAttachment.Height, CableAttachment.Angle, CableAttachment.Heading, CableAttachment.Range, CableAttachment.ViewLon, CableAttachment.ViewLat, 
       CableAttachment.ViewHeight, CableAttachment.ViewAngle, CableAttachment.ViewHeading, CableAttachment.ViewRange, CableAttachment.AttachmentName, 
       CableAttachment.AssetCode, CableAttachment.IsMonitor, CableAttachment.InstallDate AS CableAttachmentInstallDate, CableAttachment.Memo, PowerLoop.LoopName, 
       PowerLoop.PathSectionNum, CableAttachment.AssetCode + '(' + CableAttachmentType.AttachmentTypeName + ')' AS CodeName
    FROM LoopEarthBox INNER JOIN CableAttachment ON LoopEarthBox.AttachmentNum = CableAttachment.AttachmentNum 
         INNER JOIN CableAttachmentType ON CableAttachmentType.AttachmentTypeID = CableAttachment.AttachmentTypeID
         INNER JOIN PowerLoop ON LoopEarthBox.LoopNum = PowerLoop.LoopNum);
/*==============================================================*/
/* View: v_Substation                                      */
/*==============================================================*/
CREATE OR REPLACE VIEW v_Substation as(
SELECT BaseFacility.BaseFacilityNum, BaseFacility.AreaNum, BaseFacility.Lon, BaseFacility.Lat, BaseFacility.Height, BaseFacility.Angle, BaseFacility.Heading, 
       BaseFacility.Range, BaseFacility.ViewLon, BaseFacility.ViewLat, BaseFacility.ViewHeight, BaseFacility.ViewAngle, BaseFacility.ViewHeading, 
       BaseFacility.ViewRange, BaseFacility.BaseFacilityName, BaseFacility.AssetCode, BaseFacility.BaseFacilityDescription, BaseFacility.GraphID, Area.AreaTypeID, 
       Area.AreaName
    FROM BaseFacility LEFT OUTER JOIN Area ON BaseFacility.AreaNum = Area.AreaNum);
/*==============================================================*/
/* View: v_SubstationFileAttachment                                      */
/*==============================================================*/
CREATE OR REPLACE VIEW v_SubstationFileAttachment as(
SELECT FileAttachment.FileNum, FileAttachment.EmployeeID, FileAttachment.BaseFacilityNum, FileAttachment.FileName, FileAttachment.FilePath, FileAttachment.UpdateDate, 
       FileAttachment.FileMemo, Employee.OrganizationNum,Employee.UserName, BaseFacility.AssetCode, BaseFacility.BaseFacilityName
    FROM FileAttachment INNER JOIN BaseFacility ON FileAttachment.BaseFacilityNum = BaseFacility.BaseFacilityNum 
         LEFT OUTER JOIN Employee ON FileAttachment.EmployeeID = Employee.EmployeeID);
/*==============================================================*/
/* View: v_SubstationManhole                                      */
/*==============================================================*/
CREATE OR REPLACE VIEW v_SubstationManhole as(
SELECT Manhole.AssetNum, Manhole.EmployeeID, Manhole.ManholeKindTypeID, Manhole.BaseFacilityNum, Manhole.Tunnel_AssetNum, Manhole.AssetName, 
       Manhole.AssetCode, Manhole.OperationCode, Manhole.PositionDescription, Manhole.Longitude, Manhole.Latitude, Manhole.Memo, Manhole.ViewLon, 
       Manhole.ViewLat, Manhole.ViewHeight, Manhole.ViewAngle, Manhole.ViewHeading, Manhole.ViewRange, Manhole.AreaNum, BaseFacility.BaseFacilityName, 
       BaseFacility.AssetCode AS SubstationAssetCode, ManholeKindType.ManholeKindTypeName, ManholeKindType.Prefix, ManholeKindType.ManholeTypeID, 
       ManholeType.ManholeTypeName
    FROM Manhole INNER JOIN ManholeKindType ON Manhole.ManholeKindTypeID = ManholeKindType.ManholeKindTypeID 
         INNER JOIN ManholeType ON ManholeKindType.ManholeTypeID = ManholeType.ManholeTypeID
         LEFT OUTER JOIN BaseFacility ON Manhole.BaseFacilityNum = BaseFacility.BaseFacilityNum);
/*==============================================================*/
/* View: v_Company                                      */
/*==============================================================*/
CREATE OR REPLACE VIEW v_Company as(
SELECT Company.CompanyNum, Company.CompanyTypeID, Company.CompanyName, Company.CompanyAddr, Company.CompanyTelephone, Company.Contact, 
       Company.ContactPhone, Company.Memo, CompanyType.CompanyTypeName
    FROM Company INNER JOIN CompanyType ON Company.CompanyTypeID = CompanyType.CompanyTypeID);
/*==============================================================*/
/* View: v_Organization                                      */
/*==============================================================*/
CREATE OR REPLACE VIEW v_Organization as(
SELECT Organization.OrganizationNum, Organization.ParentID, Organization.TeamTypeID, Organization.OrganizationName, Organization.Description, Organization.Visible, 
		   Organization_Parent.OrganizationName AS ParentName, TeamType.TeamTypeName
	  FROM Organization LEFT OUTER JOIN
		   Organization Organization_Parent ON Organization.ParentID = Organization_Parent.OrganizationNum LEFT OUTER JOIN
           TeamType ON Organization.TeamTypeID = TeamType.TeamTypeID);
/*==============================================================*/
/* View: v_ManholeKindType                                      */
/*==============================================================*/
CREATE OR REPLACE VIEW v_ManholeKindType as(
SELECT ManholeKindType.ManholeKindTypeID, ManholeKindType.ManholeTypeID, ManholeKindType.ManholeKindTypeName, ManholeKindType.Prefix, 
		   ManholeType.ManholeTypeName
	  FROM ManholeKindType INNER JOIN ManholeType ON ManholeKindType.ManholeTypeID = ManholeType.ManholeTypeID);
/*==============================================================*/
/* View: v_TunnelStuffType                                      */
/*==============================================================*/
CREATE OR REPLACE VIEW v_TunnelStuffType as(
SELECT TunnelStuffType.TunnelStuffTypeID, TunnelStuffType.TunnelStructureTypeID, TunnelStuffType.TunnelStuffTypeName, TunnelStructureType.TunnelStructureTypeName
    FROM TunnelStuffType LEFT OUTER JOIN TunnelStructureType 
         ON TunnelStuffType.TunnelStructureTypeID = TunnelStructureType.TunnelStructureTypeID);
/*==============================================================*/
/* View: v_BranchBox                                      */
/*==============================================================*/
CREATE OR REPLACE VIEW v_BranchBox as(
SELECT
  BranchBox.BranchBoxNum,
  BranchBox.ModelNum,
  BranchBox.AssetNum,
  BranchBox.IsLoadSwitch,
  BranchBox.IsLockDevice,
  BranchBox.IsOnMonitor,
  BranchBox.IsDrop,
  BranchBox.RunDate,
  BranchBox.Memo,
  BranchBox.VoltageLevelID,
  Manhole.ManholeKindTypeID,
  Manhole.AssetName,
  Manhole.AssetCode,
  Manhole.OperationCode,
  Manhole.Longitude,
  Manhole.Latitude,
  Manhole.PositionDescription,
  Manhole.ViewLon,
  Manhole.ViewLat,
  Manhole.ViewHeight,
  Manhole.ViewAngle,
  Manhole.ViewHeading,
  Manhole.ViewRange,
  Manhole.bulid_CompanyNum,
  BranchBoxModel.ModelName,
  ManholeKindType.ManholeTypeID,
  ManholeKindType.ManholeKindTypeName,
  Company.CompanyName,
  PowerCableLevel.VoltageLevelName,
  Manhole.BaseFacilityNum,
  BaseFacilityName
FROM BranchBox
INNER JOIN Manhole
  ON BranchBox.AssetNum = Manhole.AssetNum
INNER JOIN ManholeKindType
  ON Manhole.ManholeKindTypeID = ManholeKindType.ManholeKindTypeID
LEFT OUTER JOIN BranchBoxModel
  ON BranchBox.ModelNum = BranchBoxModel.ModelNum
LEFT OUTER JOIN Company
  ON Manhole.bulid_CompanyNum = Company.CompanyNum
LEFT OUTER JOIN PowerCableLevel
  ON PowerCableLevel.VoltageLevelID = BranchBox.VoltageLevelID
LEFT OUTER JOIN BaseFacility
  ON BaseFacility.BaseFacilityNum = Manhole.BaseFacilityNum);
/*==============================================================*/
/* View: v_TunnelLedger                                      */
/*==============================================================*/
CREATE OR REPLACE VIEW v_TunnelLedger as(
SELECT Ledger.ArchivesNum, Ledger.BaseFacilityNum, Ledger.AssetBorderTypeID, Ledger.EmployeeID, Ledger.AcceptStatusTypeID,
       Ledger.ArchivesCode, Ledger.ArchivesName, Ledger.MonitorCompany, Ledger.BuildCompany, Ledger.BluePrintCode, Ledger.ArchivesPlace, Ledger.BluePrintPlace, 
       Ledger.DrawerCode, Ledger.Address, Ledger.Specification, Ledger.BuildDate, Ledger.CompleteDate, Ledger.ArchivesTime, Ledger.Memo, Ledger.IsRush,Ledger.ArchivesType,
       Employee.UserName AS RecordUserName,BaseFacility.AssetCode, BaseFacility.BaseFacilityName, 
       AssetBorderType.AssetBorderTypeName, AcceptStatusType.AcceptStatusTypeName, AcceptStatusType.ShowColor
    FROM Ledger INNER JOIN Employee ON Ledger.EmployeeID = Employee.EmployeeID
         LEFT OUTER JOIN BaseFacility ON Ledger.BaseFacilityNum = BaseFacility.BaseFacilityNum 
         LEFT OUTER JOIN AssetBorderType ON Ledger.AssetBorderTypeID = AssetBorderType.AssetBorderTypeID
         LEFT OUTER JOIN AcceptStatusType ON Ledger.AcceptStatusTypeID = AcceptStatusType.AcceptStatusTypeID);
/*==============================================================*/
/* View: v_Extinguisher                                      */
/*==============================================================*/
CREATE OR REPLACE VIEW v_Extinguisher as(
SELECT Extinguisher.AssetNum, Extinguisher.EmployeeID, Extinguisher.bulid_CompanyNum, Extinguisher.ExtinguisherTypeID, Extinguisher.monitor_CompanyNum, 
       Extinguisher.Tunnel_AssetNum, Extinguisher.AssetName, Extinguisher.AssetCode, Extinguisher.GraphID, Extinguisher.OperationCode, 
       Extinguisher.BuildDate, Extinguisher.CompletedDate, Extinguisher.OperationDate, Extinguisher.PositionDescription, Extinguisher.Longitude, Extinguisher.Latitude, 
       Extinguisher.Memo, Extinguisher.ExtinguisherInfo, Extinguisher.Quantity, Extinguisher.UpGradeTime, Extinguisher.ValidityYear, Extinguisher.DownTime, 
       PowerTunnel.ArchivesNum, PowerTunnel.AssetCode AS TunnelAssetCode, PowerTunnel.OperationCode AS TunnelOperationCode, Ledger.ArchivesCode, Ledger.ArchivesName, 
       ExtinguisherType.ExtinguisherTypeName, Employee.UserName AS EmployeeName
    FROM Extinguisher INNER JOIN PowerTunnel ON Extinguisher.Tunnel_AssetNum = PowerTunnel.AssetNum 
         LEFT OUTER JOIN Ledger ON PowerTunnel.ArchivesNum = Ledger.ArchivesNum 
         LEFT OUTER JOIN ExtinguisherType ON Extinguisher.ExtinguisherTypeID = ExtinguisherType.ExtinguisherTypeID 
         LEFT OUTER JOIN Employee ON Extinguisher.EmployeeID = Employee.EmployeeID);
/*==============================================================*/
/* View: v_FireWall                                      */
/*==============================================================*/
CREATE OR REPLACE VIEW v_FireWall as(
SELECT FireWall.AssetNum, FireWall.CompanyNum, FireWall.EmployeeID, FireWall.BULID_COMPANYNUM, FireWall.FireWallStuffTypeID, FireWall.FireWallTypeID, 
       FireWall.DoorStuffTypeID, FireWall.Monitor_CompanyNum,FireWall.Tunnel_AssetNum, FireWall.AssetName, FireWall.AssetCode, 
       FireWall.GraphID, FireWall.OperationCode, FireWall.BuildDate, FireWall.CompletedDate, FireWall.OperationDate, FireWall.PositionDescription, FireWall.Longitude, 
       FireWall.Latitude, FireWall.Memo, FireWall.WallSize, FireWall.DoorSize, FireWall.DoorBuildDate, PowerTunnel.ArchivesNum, 
       PowerTunnel.AssetCode AS TunnelAssetCode, PowerTunnel.OperationCode AS TunnelOperationCode, Ledger.ArchivesCode, Ledger.ArchivesName, 
       FireWallStuffType.FireWallStuffTypeName, FireWallType.FireWallTypeName, DoorStuffType.DoorStuffTypeName, Employee.UserName AS EmployeeName
    FROM FireWall INNER JOIN PowerTunnel ON FireWall.Tunnel_AssetNum = PowerTunnel.AssetNum 
         LEFT OUTER JOIN Ledger ON PowerTunnel.ArchivesNum = Ledger.ArchivesNum 
         LEFT OUTER JOIN FireWallType ON FireWall.FireWallTypeID = FireWallType.FireWallTypeID 
         LEFT OUTER JOIN FireWallStuffType ON FireWall.FireWallStuffTypeID = FireWallStuffType.FireWallStuffTypeID 
         LEFT OUTER JOIN DoorStuffType ON FireWall.DoorStuffTypeID = DoorStuffType.DoorStuffTypeID 
         LEFT OUTER JOIN Employee ON FireWall.EmployeeID = Employee.EmployeeID);
/*==============================================================*/
/* View: v_RoleFunctions                                      */
/*==============================================================*/
CREATE OR REPLACE VIEW v_RoleFunctions as(
SELECT RoleFunctions.RoleFunctionID, RoleFunctions.RoleNum, RoleFunctions.ApplicationModuleID, Roles.RoleName, AccessFunction.PARENTMODULEID, 
       AccessFunction.ApplicationModuleName, AccessFunction.Context, AccessFunction.IsDisplay, AccessFunction.FunctionPath
    FROM RoleFunctions INNER JOIN AccessFunction ON RoleFunctions.ApplicationModuleID = AccessFunction.ApplicationModuleID 
         INNER JOIN Roles ON RoleFunctions.RoleNum = Roles.RoleNum
   WHERE (AccessFunction.IsDisplay = 1));
/*==============================================================*/
/* View: v_OperationLog                                      */
/*==============================================================*/
CREATE OR REPLACE VIEW v_OperationLog as(
SELECT OperationLog.LogNum, OperationLog.TypeID, OperationLog.EmployeeID, OperationLog.Content, OperationLog.LogDateTime, OperationType.TypeName, 
       Employee.UserName, Employee.OrganizationNum, Organization.OrganizationName, Organization.TeamTypeID, TeamType.TeamTypeName
    FROM OperationLog INNER JOIN OperationType ON OperationLog.TypeID = OperationType.TypeID 
         INNER JOIN Employee ON OperationLog.EmployeeID = Employee.EmployeeID 
         LEFT OUTER JOIN Organization ON Employee.OrganizationNum = Organization.OrganizationNum 
         LEFT OUTER JOIN TeamType ON Organization.TeamTypeID = TeamType.TeamTypeID);
/*==============================================================*/
/* View: v_PowerTunnel                                      */
/*==============================================================*/
CREATE OR REPLACE VIEW v_PowerTunnel as(
SELECT PowerTunnel.AssetNum, PowerTunnel.EmployeeID, PowerTunnel.VoltageLevelID, PowerTunnel.bulid_CompanyNum, PowerTunnel.ArchivesNum, 
       PowerTunnel.TunnelStuffTypeID, PowerTunnel.monitor_CompanyNum, PowerTunnel.TunnelShapeTypeID, PowerTunnel.AreaNum,
       PowerTunnel.TrestleTypeInfoID, PowerTunnel.OrganizationNum, PowerTunnel.TunnelStructureTypeID, PowerTunnel.AssetName, PowerTunnel.AssetCode, 
       PowerTunnel.GraphID, PowerTunnel.OperationCode, PowerTunnel.BuildDate, PowerTunnel.CompletedDate, PowerTunnel.OperationDate, PowerTunnel.PositionDescription, 
       PowerTunnel.Memo, PowerTunnel.TunnelLength, PowerTunnel.TunnelHeight, PowerTunnel.TunnelWidth, PowerTunnel.Diameter, PowerTunnel.FrontTopHeight, 
       PowerTunnel.TailTopHeight, PowerTunnel.TrestleInterval, PowerTunnel.TrestleTypeDescription, PowerTunnel.StartStopDescription, PowerTunnel.Longitude, 
       PowerTunnel.Latitude,Ledger.ArchivesCode, Ledger.ArchivesName, Ledger.BaseFacilityNum,Ledger.AcceptStatusTypeID,
       (CASE WHEN PowerTunnel.TunnelStructureTypeID = 2 THEN to_char(PowerTunnel.Diameter) 
             ELSE to_char(PowerTunnel.TunnelWidth)||'*'||to_char(PowerTunnel.TunnelHeight) END) AS TunnelSize, 
       (CASE WHEN PowerTunnel.FrontTopHeight = PowerTunnel.TailTopHeight THEN to_char(PowerTunnel.TailTopHeight) 
             ELSE to_char(PowerTunnel.FrontTopHeight)||'-'||to_char(PowerTunnel.TailTopHeight) END) TopHeight, 
       TunnelStructureType.TunnelStructureTypeName, TunnelShapeType.TunnelShapeTypeName, BaseFacility.AssetCode SubstationAssetCode, 
       BaseFacility.BaseFacilityName, TrestleTypeInfo.TrestleTypeInfoName, TunnelStuffType.TunnelStuffTypeName, PowerCableLevel.VoltageLevelName, 
       Area.AreaName, Organization.OrganizationName, Employee.UserName EmployeeName
    FROM PowerTunnel LEFT JOIN TunnelStructureType ON PowerTunnel.TunnelStructureTypeID = TunnelStructureType.TunnelStructureTypeID
         LEFT JOIN TunnelShapeType ON PowerTunnel.TunnelShapeTypeID = TunnelShapeType.TunnelShapeTypeID 
         LEFT JOIN Ledger ON PowerTunnel.ArchivesNum = Ledger.ArchivesNum
         LEFT JOIN Area ON PowerTunnel.AreaNum = Area.AreaNum 
         LEFT JOIN Organization ON PowerTunnel.OrganizationNum = Organization.OrganizationNum 
         LEFT JOIN TunnelStuffType ON TunnelStuffType.TunnelStuffTypeID = PowerTunnel.TunnelStuffTypeID
       LEFT JOIN TrestleTypeInfo ON PowerTunnel.TrestleTypeInfoID = TrestleTypeInfo.TrestleTypeInfoID 
       LEFT JOIN PowerCableLevel ON PowerTunnel.VoltageLevelID = PowerCableLevel.VoltageLevelID 
       LEFT JOIN Employee ON PowerTunnel.EmployeeID = Employee.EmployeeID
       LEFT JOIN BaseFacility ON Ledger.BaseFacilityNum = BaseFacility.BaseFacilityNum);
/*==============================================================*/
/* View: v_TunnelSection                                      */
/*==============================================================*/
CREATE OR REPLACE VIEW v_TunnelSection as(
SELECT TunnelSection.SectionNum, TunnelSection.AssetNum, TunnelSection.Length, TunnelSection.OrderNum, TunnelSection.TunnleTowardTypeID, 
         TunnelSection.FrontTopHeight,TunnelSection.TailTopHeight,
      (CASE WHEN TunnelSection.FrontTopHeight = TunnelSection.TailTopHeight THEN to_char(TunnelSection.TailTopHeight) 
        ELSE to_char(TunnelSection.FrontTopHeight)||'-'||to_char(TunnelSection.TailTopHeight) END ) TopHeight
         ,PowerTunnel.AssetCode, TunnleTowardType.TunnleTowardTypeName, PowerTunnel.TunnelStructureTypeID
         ,TunnelStructureType.TunnelStructureTypeName, PowerTunnel.VoltageLevelID, PowerCableLevel.VoltageLevelName
    FROM TunnelSection INNER JOIN PowerTunnel ON PowerTunnel.AssetNum = TunnelSection.AssetNum
         INNER JOIN TunnleTowardType ON TunnleTowardType.TunnleTowardTypeID = TunnelSection.TunnleTowardTypeID
         INNER JOIN TunnelStructureType ON TunnelStructureType.TunnelStructureTypeID = PowerTunnel.TunnelStructureTypeID
         LEFT OUTER JOIN PowerCableLevel ON PowerCableLevel.VoltageLevelID = PowerTunnel.VoltageLevelID);
/*==============================================================*/
/* View: v_TunnelSectionWithManhole                                      */
/*==============================================================*/
CREATE OR REPLACE VIEW v_TunnelSectionWithManhole as(
SELECT ts.SectionNum, ts.TunnleTowardTypeID, ts.AssetNum, ts.Length, ts.OrderNum, ts.FrontTopHeight, ts.TailTopHeight, 
         mos.StartManholeAssetNum, mb.OperationCode AS StartOperationCode, mb.AssetCode AS StartAssetCode, 
         mos.EndManholeAssetNum, me.OperationCode AS EndOperationCode, me.AssetCode AS EndAssetCode 
    FROM TunnelSection ts INNER JOIN (SELECT SectionNum, 1 StartManholeAssetNum, 2 AS EndManholeAssetNum 
         FROM (SELECT SectionNum, AssetNum, OrderNum FROM ManholeOfSection) tmp PIVOT(MAX(AssetNum) FOR OrderNum IN (1, 2)) pvt) mos 
       ON mos.SectionNum = ts.SectionNum
       INNER JOIN Manhole mb ON mb.AssetNum = mos.StartManholeAssetNum
       INNER JOIN Manhole me ON me.AssetNum = mos.EndManholeAssetNum);
/*==============================================================*/
/* View: v_TrestleLayer                                      */
/*==============================================================*/
CREATE OR REPLACE VIEW v_TrestleLayer as(
SELECT TrestleLayer.TrestleLayerNum, TrestleLayer.TrestlePositionTypeID, TrestleLayer.VoltageLevelID,
         TrestleLayer.SectionNum, TrestleLayer.Layer, TrestleLayer.TrestleLength, TrestleLayer.Height, TrestleLayer.TrestleStuffTypeID, 
         TrestleLayer.Memo, TrestleDirectionType.TrestlePositionTypeName, PowerCableLevel.VoltageLevelName, PowerCableLevel.VoltageValue,
         PowerTunnel.TunnelStructureTypeID, TunnelStructureType.TunnelStructureTypeName, TrestleStuffType.TrestleStuffTypeName
    FROM TrestleLayer INNER JOIN TunnelSection ON TunnelSection.SectionNum = TrestleLayer.SectionNum
         INNER JOIN PowerTunnel ON PowerTunnel.AssetNum = TunnelSection.AssetNum
         INNER JOIN TunnelStructureType ON TunnelStructureType.TunnelStructureTypeID = PowerTunnel.TunnelStructureTypeID
         INNER JOIN TrestleDirectionType ON TrestleDirectionType.TrestlePositionTypeID = TrestleLayer.TrestlePositionTypeID
         LEFT JOIN PowerCableLevel ON PowerCableLevel.VoltageLevelID = TrestleLayer.VoltageLevelID
         LEFT JOIN TrestleStuffType ON TrestleStuffType.TrestleStuffTypeID = TrestleLayer.TrestleStuffTypeID);
/*==============================================================*/
/* View: v_RowTube                                      */
/*==============================================================*/
CREATE OR REPLACE VIEW v_RowTube as(
SELECT RowTube.RowTubeNum, RowTube.TrestleLayerNum, RowTube.RowTubeTypeID, RowTube.RowTubeOrder, RowTubeType.RowTubeTypeName,
	       TrestleLayer.SectionNum
	  FROM RowTube INNER JOIN TrestleLayer ON TrestleLayer.TrestleLayerNum = RowTube.TrestleLayerNum
	       LEFT OUTER JOIN RowTubeType ON RowTubeType.RowTubeTypeID = RowTube.RowTubeTypeID);
/*==============================================================*/
/* View: v_CoverStuffType                                      */
/*==============================================================*/
CREATE OR REPLACE VIEW v_CoverStuffType as(
SELECT CoverStuffType.CoverStuffTypeID, CoverStuffType.ManholeCoverTypeID, CoverStuffType.CoverStuffTypeName, ManholeCoverType.ManholeCoverTypeName
    FROM CoverStuffType INNER JOIN ManholeCoverType ON ManholeCoverType.ManholeCoverTypeID = CoverStuffType.ManholeCoverTypeID);
/*==============================================================*/
/* View: v_ManholeOfTunnel                                      */
/*==============================================================*/
CREATE OR REPLACE VIEW v_ManholeOfTunnel as(
SELECT ManholeOfTunnel.BuildOfTunnelNum, ManholeOfTunnel.AssetNum, ManholeOfTunnel.Man_AssetNum, ManholeOfTunnel.IsEndpoint, 
           ManholeOfTunnel.OrderNum, Manhole.AssetCode AS Man_AssetCode, PowerTunnel.AssetCode, 
           Manhole.ManholeKindTypeID, ManholeKindType.ManholeKindTypeName,
         ManholeType.ManholeTypeID, ManholeType.ManholeTypeName, 
           PowerTunnel.FrontTopHeight, PowerTunnel.TailTopHeight, Manhole.Longitude, Manhole.Latitude,
           Manhole.OperationCode
    FROM ManholeOfTunnel INNER JOIN Manhole ON Manhole.AssetNum = ManholeOfTunnel.Man_AssetNum
         INNER JOIN PowerTunnel ON PowerTunnel.AssetNum = ManholeOfTunnel.AssetNum
         INNER JOIN ManholeKindType ON ManholeKindType.ManholeKindTypeID = Manhole.ManholeKindTypeID
         INNER JOIN ManholeType ON ManholeType.ManholeTypeID = ManholeKindType.ManholeTypeID);
/*==============================================================*/
/* View: v_ManholeOfSection                                      */
/*==============================================================*/
CREATE OR REPLACE VIEW v_ManholeOfSection as(
SELECT ManholeOfSection.Num, ManholeOfSection.SectionNum, ManholeOfSection.AssetNum, ManholeOfSection.OrderNum, ts.AssetNum AS TunnelAssetNum,
         Manhole.AssetCode, Manhole.Longitude, Manhole.Latitude 
    FROM ManholeOfSection INNER JOIN TunnelSection ts ON ts.SectionNum = ManholeOfSection.SectionNum
         INNER JOIN Manhole ON Manhole.AssetNum = ManholeOfSection.AssetNum);
/*==============================================================*/
/* View: v_Manhole                                      */
/*==============================================================*/
CREATE OR REPLACE VIEW v_Manhole as(
SELECT Manhole.AssetNum, Manhole.ManholeShapeTypeID, Manhole.AreaNum, Manhole.EmployeeID, Manhole.bulid_CompanyNum, Manhole.CoverShapeTypeID, 
       Manhole.monitor_CompanyNum, Manhole.CoverStuffTypeID, Manhole.ManholeKindTypeID, Manhole.ManholeCoverTypeID, Manhole.BaseFacilityNum, 
       Manhole.ManholeStuffTypeID, Manhole.Tunnel_AssetNum, Manhole.AssetName, Manhole.AssetCode, 
       Manhole.GraphID, Manhole.OperationCode, Manhole.BuildDate, Manhole.CompletedDate, Manhole.OperationDate, Manhole.PositionDescription, Manhole.Longitude, 
       Manhole.Latitude, Manhole.Memo, Manhole.Length, Manhole.Width, Manhole.Diameter, Manhole.Height, Manhole.BottomHeight, Manhole.TerraceLayerCount, 
         Manhole.OutLineQuantity, Manhole.ManHoleCoverCode, Manhole.ManHoleCoverSize, Manhole.ViewLon, Manhole.ViewLat, Manhole.ViewHeight, Manhole.ViewAngle, 
       Manhole.ViewHeading, Manhole.ViewRange, ManholeKindType.ManholeTypeID, ManholeKindType.ManholeKindTypeName, ManholeType.ManholeTypeName, 
       to_char(Manhole.Width)||'*'||to_char(Manhole.Length) size1, 
       PowerTunnel.ArchivesNum, PowerTunnel.AreaNum AS TunnelAreaNum, PowerTunnel.OrganizationNum, PowerTunnel.TunnelStructureTypeID, 
       PowerTunnel.AssetCode AS TunnelAssetCode, PowerTunnel.OperationCode AS TunnelOperationCode, Ledger.ArchivesCode, Ledger.ArchivesName, 
       (CASE WHEN ManholeKindType.ManholeTypeID = 3 THEN BaseFacility.BaseFacilityName ELSE BaseFacility_Ledger.BaseFacilityName END) AS BaseFacilityName, 
       ManholeOfTunnel.OrderNum, Organization.OrganizationName, Organization.TeamTypeID, Area.AreaName, Area_Tunnel.AreaName AS TunnelAreaName, 
       Employee.UserName AS EmployeeName, ManholeStuffType.ManholeStuffTypeName, 
       ManholeCoverType.ManholeCoverTypeName, CoverStuffType.CoverStuffTypeName, CoverShapeType.CoverShapeTypeName, BaseFacility.AssetCode AS SubstationAssetCode
    FROM Manhole INNER JOIN ManholeKindType ON Manhole.ManholeKindTypeID = ManholeKindType.ManholeKindTypeID 
         INNER JOIN ManholeType ON ManholeKindType.ManholeTypeID = ManholeType.ManholeTypeID
         LEFT OUTER JOIN ManholeOfTunnel ON Manhole.AssetNum = ManholeOfTunnel.Man_AssetNum AND Manhole.TUNNEL_ASSETNUM = ManholeOfTunnel.AssetNum
         LEFT OUTER JOIN PowerTunnel ON PowerTunnel.AssetNum = Manhole.TUNNEL_ASSETNUM
         LEFT OUTER JOIN Ledger ON Ledger.ArchivesNum = PowerTunnel.ArchivesNum
         LEFT OUTER JOIN BaseFacility ON Manhole.BaseFacilityNum = BaseFacility.BaseFacilityNum
         LEFT OUTER JOIN BaseFacility BaseFacility_Ledger ON Ledger.BaseFacilityNum = BaseFacility_Ledger.BaseFacilityNum
         LEFT OUTER JOIN Area ON Manhole.AreaNum = Area.AreaNum
         LEFT OUTER JOIN Organization ON Organization.OrganizationNum = PowerTunnel.OrganizationNum
         LEFT OUTER JOIN Area Area_Tunnel ON PowerTunnel.AreaNum = Area_Tunnel.AreaNum 
         LEFT OUTER JOIN ManholeStuffType ON Manhole.ManholeStuffTypeID = ManholeStuffType.ManholeStuffTypeID 
         LEFT OUTER JOIN ManholeCoverType ON Manhole.ManholeCoverTypeID = ManholeCoverType.ManholeCoverTypeID
         LEFT OUTER JOIN CoverStuffType ON Manhole.CoverStuffTypeID = CoverStuffType.CoverStuffTypeID  
         LEFT OUTER JOIN CoverShapeType ON Manhole.CoverShapeTypeID = CoverShapeType.CoverShapeTypeID
         LEFT OUTER JOIN Employee ON Employee.EmployeeID = Manhole.EmployeeID);
/*==============================================================*/
/* View: v_Teminator                                      */
/*==============================================================*/
CREATE OR REPLACE VIEW v_Teminator as(
SELECT Manhole.AssetNum, Manhole.AssetName, Manhole.AssetCode, Manhole.OperationCode, Manhole.PositionDescription, Manhole.Longitude, Manhole.Latitude, 
           Manhole.Memo, Manhole.ViewLon, Manhole.ViewLat, Manhole.ViewHeight, Manhole.ViewAngle, Manhole.ViewHeading, Manhole.ViewRange, Manhole.GraphID, 
           Manhole.ManholeKindTypeID, ManholeKindType.ManholeTypeID, ManholeKindType.ManholeKindTypeName, ManholeType.ManholeTypeName
      FROM Manhole INNER JOIN ManholeKindType ON Manhole.ManholeKindTypeID = ManholeKindType.ManholeKindTypeID 
           INNER JOIN ManholeType ON ManholeKindType.ManholeTypeID = ManholeType.ManholeTypeID);
/*==============================================================*/
/* View: v_TerminalFile                                      */
/*==============================================================*/
CREATE OR REPLACE VIEW v_TerminalFile as(
SELECT TerminalFile.FileNum, TerminalFile.EmployeeID, TerminalFile.AssetNum, TerminalFile.FileName, TerminalFile.FilePath, TerminalFile.UpdateDate, 
       Manhole.AssetCode, Manhole.AssetName, Manhole.ManholeKindTypeID, ManholeKindType.ManholeTypeID, Employee.UserName
    FROM TerminalFile INNER JOIN Manhole ON TerminalFile.AssetNum = Manhole.AssetNum 
         INNER JOIN ManholeKindType ON Manhole.ManholeKindTypeID = ManholeKindType.ManholeKindTypeID 
         LEFT OUTER JOIN Employee ON TerminalFile.EmployeeID = Employee.EmployeeID);
/*==============================================================*/
/* View: v_CableAttachment                                      */
/*==============================================================*/
CREATE OR REPLACE VIEW v_CableAttachment as(
SELECT CableAttachment.AttachmentNum, CableAttachment.ModelTypeNum, CableAttachment.Num, CableAttachment.FaultIndicatorTypeID, CableAttachment.SafeBoxTypeID, 
       CableAttachment.AttachmentTypeID, CableAttachment.CompanyNum, CableAttachment.PathTypeID, CableAttachment.AttachmentStatusTypeID, CableAttachment.Lon, 
       CableAttachment.Lat, CableAttachment.Height, CableAttachment.Angle, CableAttachment.Heading, CableAttachment.Range, CableAttachment.ViewLon, 
       CableAttachment.ViewLat, CableAttachment.ViewHeight, CableAttachment.ViewAngle, CableAttachment.ViewHeading, CableAttachment.ViewRange, 
       CableAttachment.AttachmentName, CableAttachment.AssetCode, CableAttachment.IsMonitor, CableAttachment.InstallDate, CableAttachment.Memo, 
       PathType.PathTypeName, CableAttachmentType.AttachmentTypeName, FaultIndicatorType.FaultIndicatorTypeName, SafeBoxType.SafeBoxTypeName, 
       Company.CompanyName, Company.CompanyTypeID, AttachmentModelType.ModelTypeName, AttachmentStatusType.AttachmentStatusTypeName, 
       CableDeviceLedger.LedgerCode, CableDeviceLedger.LedgerName, CableAttachment.CableDeviceStyleID, 
       CableDeviceStyle.CableDeviceStyleName, CableAttachment.CableDeviceTypeID, CableDeviceType.CableDeviceTypeName 
    FROM CableAttachment INNER JOIN PathType ON CableAttachment.PathTypeID = PathType.PathTypeID 
         INNER JOIN CableAttachmentType ON CableAttachment.AttachmentTypeID = CableAttachmentType.AttachmentTypeID 
         LEFT OUTER JOIN CableDeviceLedger ON CableDeviceLedger.Num = CableAttachment.Num
         LEFT OUTER JOIN AttachmentModelType ON CableAttachment.ModelTypeNum = AttachmentModelType.ModelTypeNum 
         LEFT OUTER JOIN FaultIndicatorType ON CableAttachment.FaultIndicatorTypeID = FaultIndicatorType.FaultIndicatorTypeID 
         LEFT OUTER JOIN SafeBoxType ON CableAttachment.SafeBoxTypeID = SafeBoxType.SafeBoxTypeID 
         LEFT OUTER JOIN Company ON CableAttachment.CompanyNum = Company.CompanyNum
         LEFT OUTER JOIN AttachmentStatusType ON CableAttachment.AttachmentStatusTypeID = AttachmentStatusType.AttachmentStatusTypeID
         LEFT OUTER JOIN CableDeviceStyle ON CableDeviceStyle.CableDeviceStyleID = CableAttachment.CableDeviceStyleID
         LEFT OUTER JOIN CableDeviceType ON CableDeviceType.CableDeviceTypeID = CableAttachment.CableDeviceTypeID);
/*==============================================================*/
/* View: v_CableAttachmentRunRecord                             */
/*==============================================================*/
CREATE OR REPLACE VIEW v_CableAttachmentRunRecord as(
SELECT RunRecord.RecordNum, RunRecord.AttachmentStatusTypeID, RunRecord.AttachmentNum, RunRecord.RecordDate, CableAttachment.ModelTypeNum, 
		   CableAttachment.Num, CableAttachment.AttachmentTypeID, CableAttachment.PathTypeID, CableAttachment.AssetCode, CableAttachment.AttachmentName, 
		   AttachmentStatusType.AttachmentStatusTypeName
	  FROM RunRecord INNER JOIN CableAttachment ON RunRecord.AttachmentNum = CableAttachment.AttachmentNum 
	       LEFT OUTER JOIN AttachmentStatusType ON RunRecord.AttachmentStatusTypeID = AttachmentStatusType.AttachmentStatusTypeID);
/*==============================================================*/
/* View: v_CableSectionArrt                                             */
/*==============================================================*/
CREATE OR REPLACE VIEW v_CableSectionArrt as(
SELECT CableSectionArrt.AttrNum, CableSectionArrt.AttachmentNum, CableSectionArrt.BeginPlace, CableSectionArrt.EndPlace, CableSectionArrt.Length, 
       CableAttachment.ModelTypeNum, CableAttachment.Num, CableAttachment.AttachmentTypeID, CableAttachment.CompanyNum, CableAttachment.PathTypeID, 
       CableAttachment.AttachmentStatusTypeID, CableAttachment.Lon, CableAttachment.Lat, CableAttachment.Height, CableAttachment.Angle, CableAttachment.Heading, 
       CableAttachment.Range, CableAttachment.ViewLon, CableAttachment.ViewLat, CableAttachment.ViewHeight, CableAttachment.ViewAngle, CableAttachment.ViewHeading, 
       CableAttachment.ViewRange, CableAttachment.AttachmentName, CableAttachment.AssetCode, CableAttachment.InstallDate, CableAttachment.Memo, 
       AttachmentModelType.ModelTypeName, CableAttachmentType.AttachmentTypeName, PathType.PathTypeName, Company.CompanyName, 
       AttachmentStatusType.AttachmentStatusTypeName, CableDeviceLedger.LedgerCode, CableDeviceLedger.LedgerName,
       CableSectionArrt.IsHaveEarthLine, CableSectionArrt.CurrentCapacity, CableSectionArrt.EarthConnectorType,
       CableAttachment.CableDeviceStyleID, CableDeviceStyle.CableDeviceStyleName, CableAttachment.CableDeviceTypeID, CableDeviceType.CableDeviceTypeName 
    FROM CableSectionArrt INNER JOIN CableAttachment ON CableSectionArrt.AttachmentNum = CableAttachment.AttachmentNum 
         INNER JOIN PathType ON CableAttachment.PathTypeID = PathType.PathTypeID 
         INNER JOIN CableAttachmentType ON CableAttachment.AttachmentTypeID = CableAttachmentType.AttachmentTypeID 
         LEFT OUTER JOIN CableDeviceLedger ON CableDeviceLedger.Num = CableAttachment.Num
         LEFT OUTER JOIN AttachmentModelType ON CableAttachment.ModelTypeNum = AttachmentModelType.ModelTypeNum 
         LEFT OUTER JOIN AttachmentStatusType ON CableAttachment.AttachmentStatusTypeID = AttachmentStatusType.AttachmentStatusTypeID 
         LEFT OUTER JOIN Company ON CableAttachment.CompanyNum = Company.CompanyNum
         LEFT OUTER JOIN CableDeviceStyle ON CableDeviceStyle.CableDeviceStyleID = CableAttachment.CableDeviceStyleID
         LEFT OUTER JOIN CableDeviceType ON CableDeviceType.CableDeviceTypeID = CableAttachment.CableDeviceTypeID);
/*==============================================================*/
/* View: v_CablePath                                             */
/*==============================================================*/
CREATE OR REPLACE VIEW v_CablePath as(
SELECT CablePath.CablePathNum, CablePath.PathTypeID, CablePath.AreaNum, CablePath.VoltageLevelID, CablePath.OrganizationNum, CablePath.CablePathCode, 
       CablePath.CablePathName, CablePath.LayingMethod, CablePath.LayingMemo, CablePath.BeginPlace, CablePath.EndPlace, CablePath.Memo, 
       PathType.PathTypeName, Area.AreaName, Area.AreaTypeID, PowerCableLevel.VoltageLevelName, PowerCableLevel.VoltageValue, Organization.TeamTypeID, 
       Organization.OrganizationName, CablePath.BaseFacilityNum, BaseFacility.BaseFacilityName
    FROM CablePath INNER JOIN PathType ON CablePath.PathTypeID = PathType.PathTypeID 
         INNER JOIN PowerCableLevel ON CablePath.VoltageLevelID = PowerCableLevel.VoltageLevelID 
         LEFT OUTER JOIN BaseFacility ON BaseFacility.BaseFacilityNum = CablePath.BaseFacilityNum
         LEFT OUTER JOIN Area ON CablePath.AreaNum = Area.AreaNum 
         LEFT OUTER JOIN Organization ON CablePath.OrganizationNum = Organization.OrganizationNum);
/*==============================================================*/
/* View: v_PathSection                                          */
/*==============================================================*/
CREATE OR REPLACE VIEW v_PathSection as(
SELECT PathSection.PathSectionNum, PathSection.CablePathNum, PathSection.SafeEarthTypeID, PathSection.InstallTypeID,
       PathSection.begin_AssetNum, PathSection.end_AssetNum, PathSection.PathSectionCode, PathSection.PathSectionName,
       PathSection.PlaceInfo, PathSection.PlaceInfo2, PathSection.LoopCount, PathSection.LineCount,
       PathSection.LoopLenght, PathSection.Memo, (nvl(PathSection.LoopLenght, 0) * nvl(PathSection.LineCount, 0)) AS TotalLength,
       nvl(PowerLoop.AttachmentStatusTypeID, 2) AS AttachmentStatusTypeID, CablePath.PathTypeID, CablePath.AreaNum, CablePath.VoltageLevelID, 
       CablePath.CablePathCode, CablePath.CablePathName, SafeEarthType.SafeEarthTypeName, InstallType.InstallTypeName, 
       Manhole_Begin.ManholeKindTypeID, Manhole_Begin.AssetCode, Manhole_Begin.AssetName, Manhole_Begin.OperationCode, 
       Manhole_End.ManholeKindTypeID AS End_ManholeKindTypeID, Manhole_End.AssetName AS End_AssetName, Manhole_End.AssetCode AS End_AssetCode, 
       Manhole_End.OperationCode AS End_OperationCode, ManholeKindType_Begin.ManholeTypeID, ManholeKindType_Begin.ManholeKindTypeName, 
       ManholeKindType_End.ManholeTypeID AS End_ManholeTypeID, ManholeKindType_End.ManholeKindTypeName AS End_ManholeKindTypeName,
       PathSection.BaseFacilityNum, BaseFacility.BaseFacilityName, AttachmentStatusType.AttachmentStatusTypeName, 
       PathSection.IsExpEarthLine, PathSection.EarthConnectorType,PowerLoop.RunDate
    FROM PathSection INNER JOIN CablePath ON PathSection.CablePathNum = CablePath.CablePathNum
       LEFT OUTER JOIN SafeEarthType ON PathSection.SafeEarthTypeID = SafeEarthType.SafeEarthTypeID
       LEFT OUTER JOIN InstallType ON PathSection.InstallTypeID = InstallType.InstallTypeID
       LEFT OUTER JOIN Manhole Manhole_Begin ON Manhole_Begin.AssetNum = PathSection.begin_AssetNum
       LEFT OUTER JOIN ManholeKindType ManholeKindType_Begin ON ManholeKindType_Begin.ManholeKindTypeID = Manhole_Begin.ManholeKindTypeID
       LEFT OUTER JOIN Manhole Manhole_End ON Manhole_End.AssetNum = PathSection.end_AssetNum
       LEFT OUTER JOIN ManholeKindType ManholeKindType_End ON ManholeKindType_End.ManholeKindTypeID = Manhole_End.ManholeKindTypeID
       LEFT OUTER JOIN BaseFacility ON BaseFacility.BaseFacilityNum = PathSection.BaseFacilityNum
       LEFT OUTER JOIN PowerLoop ON PowerLoop.PathSectionNum=PathSection.PathSectionNum
       LEFT OUTER JOIN AttachmentStatusType ON AttachmentStatusType.AttachmentStatusTypeID = nvl(PowerLoop.AttachmentStatusTypeID, 2));
/*==============================================================*/
/* View: v_PowerLoop                                             */
/*==============================================================*/
CREATE OR REPLACE VIEW v_PowerLoop as(
SELECT PowerLoop.LoopNum, PowerLoop.PathSectionNum, PowerLoop.LoopName, PowerLoop.RunCode, PowerLoop.RunDate, PathSection.CablePathNum, 
		   PathSection.PathSectionCode, PathSection.PathSectionName, CablePath.PathTypeID, CablePath.AreaNum, CablePath.VoltageLevelID
	  FROM PowerLoop INNER JOIN PathSection ON PowerLoop.PathSectionNum = PathSection.PathSectionNum
	       INNER JOIN CablePath ON CablePath.CablePathNum = PathSection.CablePathNum);
/*==============================================================*/
/* View: v_PathCable                                             */
/*==============================================================*/
CREATE OR REPLACE VIEW v_PathCable as(
SELECT PathCable.CableNum, PathCable.PhaseTypeID, PathCable.LoopNum, PathCable.CableName, PathCable.RunCode, PathCable.RunDate, PowerLoop.PathSectionNum, 
       PowerLoop.LoopName, PathSection.CablePathNum, PathSection.PathSectionCode, PathSection.PathSectionName, PhaseType.PhaseTypeName, 
       PowerLoop.RunCode AS LoopRunCode, PowerLoop.RunDate AS LoopRunDate, PhaseType.IsEarthPhase, PathCable.ModelTypeNum, 
       AttachmentModelType.ModelTypeName, CablePath.PathTypeID, CablePath.AreaNum, CablePath.VoltageLevelID, 
       PowerCableLevel.VoltageValue, CablePath.CablePathCode, CablePath.CablePathName
    FROM PathCable INNER JOIN PowerLoop ON PathCable.LoopNum = PowerLoop.LoopNum 
         INNER JOIN PathSection ON PowerLoop.PathSectionNum = PathSection.PathSectionNum 
         INNER JOIN CablePath ON CablePath.CablePathNum = PathSection.CablePathNum
         INNER JOIN PhaseType ON PathCable.PhaseTypeID = PhaseType.PhaseTypeID
         INNER JOIN PowerCableLevel ON PowerCableLevel.VoltageLevelID = CablePath.VoltageLevelID
         LEFT OUTER JOIN AttachmentModelType ON AttachmentModelType.ModelTypeNum = PathCable.ModelTypeNum);
/*==============================================================*/
/* View: v_CableOfSection                                             */
/*==============================================================*/
CREATE OR REPLACE VIEW v_CableOfSection as(
SELECT CableOfSection.LayerCableNum, CableOfSection.TrestleLayerNum, CableOfSection.CableNum, CableOfSection.SectionNum, CableOfSection.RowTubeNum, 
       CableOfSection.OrderNum, CableOfSection.X, CableOfSection.Y, PathCable.PhaseTypeID, PathCable.LoopNum, PathCable.CableName, PowerLoop.PathSectionNum, 
       PowerLoop.LoopName, PathSection.CablePathNum, PathSection.PathSectionCode, PathSection.PathSectionName, TunnelSection.TunnleTowardTypeID, 
       TunnelSection.AssetNum, TunnelSection.Length, TunnelSection.OrderNum as tsOrderNum, PowerTunnel.ArchivesNum, PowerTunnel.AreaNum, PowerTunnel.OrganizationNum, 
       PowerTunnel.TunnelStructureTypeID, PowerTunnel.AssetCode, PowerTunnel.OperationCode, TrestleLayer.TrestlePositionTypeID, TrestleLayer.VoltageLevelID, 
       TrestleLayer.TrestleStuffTypeID, TrestleLayer.Layer, TrestleLayer.TrestleLength, RowTube.RowTubeTypeID, RowTube.RowTubeOrder, 
       TunnelStructureType.TunnelStructureTypeName, CableOfSection.PlaceType, CableOfSection.IsTempCable, CablePath.PathTypeID, CablePath.CablePathCode,
       CablePath.CablePathName, CablePath.BaseFacilityNum, BaseFacility.BaseFacilityName, PowerLoop.RunDate, AttachmentModelType.ModelTypeName,
       CablePath.VoltageLevelID AS CableVoltageLevelID, PowerCableLevel.VoltageLevelName, CablePath.AreaNum AS CableAreaNum, Area.AreaName AS CableAreaName
    FROM CableOfSection INNER JOIN PathCable ON CableOfSection.CableNum = PathCable.CableNum 
         INNER JOIN PowerLoop ON PathCable.LoopNum = PowerLoop.LoopNum 
         INNER JOIN PathSection ON PowerLoop.PathSectionNum = PathSection.PathSectionNum 
         INNER JOIN CablePath ON CablePath.CablePathNum = PathSection.CablePathNum
         INNER JOIN TunnelSection ON CableOfSection.SectionNum = TunnelSection.SectionNum 
         INNER JOIN PowerTunnel ON TunnelSection.AssetNum = PowerTunnel.AssetNum 
         INNER JOIN TunnelStructureType ON TunnelStructureType.TunnelStructureTypeID = PowerTunnel.TunnelStructureTypeID
         LEFT OUTER JOIN TrestleLayer ON CableOfSection.TrestleLayerNum = TrestleLayer.TrestleLayerNum 
         LEFT OUTER JOIN RowTube ON CableOfSection.RowTubeNum = RowTube.RowTubeNum
         LEFT OUTER JOIN BaseFacility ON BaseFacility.BaseFacilityNum = CablePath.BaseFacilityNum
         LEFT OUTER JOIN AttachmentModelType ON AttachmentModelType.ModelTypeNum = PathCable.ModelTypeNum
         LEFT OUTER JOIN PowerCableLevel ON PowerCableLevel.VoltageLevelID = CablePath.VoltageLevelID
         LEFT OUTER JOIN Area ON CablePath.AreaNum = Area.AreaNum);
/*==============================================================*/
/* View: v_CableLay                                             */
/*==============================================================*/
CREATE OR REPLACE VIEW v_CableLay as(
SELECT CableOfSection.LayerCableNum, CableOfSection.TrestleLayerNum, CableOfSection.CableNum, CableOfSection.SectionNum, CableOfSection.RowTubeNum, 
       CableOfSection.OrderNum, CableOfSection.X, CableOfSection.Y, PathCable.PhaseTypeID, PathCable.LoopNum, PathCable.CableName, PhaseType.PhaseTypeName, 
       PhaseType.IsEarthPhase, PowerLoop.PathSectionNum, PowerLoop.LoopName, PathSection.CablePathNum, PathSection.PathSectionCode, PathSection.PathSectionName, 
       CablePath.PathTypeID, CablePath.VoltageLevelID AS CableVoltageLevelID, CablePath.CablePathCode, CablePath.CablePathName, TunnelSection.AssetNum, 
       PowerTunnel.VoltageLevelID AS TunnelVoltageLevelID, PowerTunnel.ArchivesNum, PowerTunnel.TunnelStructureTypeID, PowerTunnel.AssetCode, PowerTunnel.OperationCode, 
       TunnelStructureType.TunnelStructureTypeName, TrestleLayer.TrestlePositionTypeID, TrestleLayer.VoltageLevelID AS TrestleVoltageLevelID, TrestleLayer.Layer, TrestleLayer.TrestleLength, 
       TrestleLayer.TrestleStuffTypeID, TrestleDirectionType.TrestlePositionTypeName, PowerCableLevel.VoltageLevelName AS TrestleVoltageLevelName,  
       RowTube.RowTubeTypeID, RowTube.RowTubeOrder, RowTubeType.RowTubeTypeName, RowTubeType.RowTubeDiameter, AttachmentModelType.ModelTypeName, 
       CableOfSection.PlaceType, CableOfSection.IsTempCable
    FROM CableOfSection INNER JOIN PathCable ON CableOfSection.CableNum = PathCable.CableNum 
         INNER JOIN PowerLoop ON PathCable.LoopNum = PowerLoop.LoopNum 
         INNER JOIN PathSection ON PowerLoop.PathSectionNum = PathSection.PathSectionNum 
         INNER JOIN CablePath ON PathSection.CablePathNum = CablePath.CablePathNum 
         INNER JOIN TunnelSection ON CableOfSection.SectionNum = TunnelSection.SectionNum 
         INNER JOIN PowerTunnel ON TunnelSection.AssetNum = PowerTunnel.AssetNum 
         INNER JOIN TunnelStructureType ON PowerTunnel.TunnelStructureTypeID = TunnelStructureType.TunnelStructureTypeID 
         --INNER JOIN TrestleLayer ON CableOfSection.TrestleLayerNum = TrestleLayer.TrestleLayerNum 
         LEFT OUTER JOIN TrestleLayer ON CableOfSection.TrestleLayerNum = TrestleLayer.TrestleLayerNum 
         LEFT OUTER JOIN RowTube ON CableOfSection.RowTubeNum = RowTube.RowTubeNum 
         LEFT OUTER JOIN RowTubeType ON RowTube.RowTubeTypeID = RowTubeType.RowTubeTypeID 
         LEFT OUTER JOIN PhaseType ON PathCable.PhaseTypeID = PhaseType.PhaseTypeID 
         LEFT OUTER JOIN PowerCableLevel ON TrestleLayer.VoltageLevelID = PowerCableLevel.VoltageLevelID 
         LEFT OUTER JOIN TrestleDirectionType ON TrestleLayer.TrestlePositionTypeID = TrestleDirectionType.TrestlePositionTypeID
         LEFT OUTER JOIN AttachmentModelType ON AttachmentModelType.ModelTypeNum = PathCable.ModelTypeNum);
/*==============================================================*/
/* View: v_CableDeviceLedger                                    */
/*==============================================================*/
CREATE OR REPLACE VIEW v_CableDeviceLedger as(
SELECT CableDeviceLedger.Num, CableDeviceLedger.VoltageLevelID, CableDeviceLedger.EmployeeID, CableDeviceLedger.AcceptStatusTypeID, CableDeviceLedger.PathTypeID, 
		   CableDeviceLedger.ProjectTypeID, CableDeviceLedger.LedgerName, CableDeviceLedger.LedgerCode, CableDeviceLedger.ProjectCode, CableDeviceLedger.ArchivesTime, 
		   CableDeviceLedger.IsRush, CableDeviceLedger.BuildDate, CableDeviceLedger.AccpetDate, CableDeviceLedger.Memo, PathType.PathTypeName, 
		   AcceptStatusType.AcceptStatusTypeName, AcceptStatusType.ShowColor, Employee.UserName, ProjectType.ProjectTypeName, PowerCableLevel.VoltageLevelName, 
		   PowerCableLevel.VoltageValue
	  FROM CableDeviceLedger INNER JOIN PathType ON CableDeviceLedger.PathTypeID = PathType.PathTypeID 
	       INNER JOIN AcceptStatusType ON CableDeviceLedger.AcceptStatusTypeID = AcceptStatusType.AcceptStatusTypeID 
	       INNER JOIN Employee ON CableDeviceLedger.EmployeeID = Employee.EmployeeID 
	       LEFT OUTER JOIN ProjectType ON CableDeviceLedger.ProjectTypeID = ProjectType.ProjectTypeID 
	       LEFT OUTER JOIN PowerCableLevel ON CableDeviceLedger.VoltageLevelID = PowerCableLevel.VoltageLevelID);
/*==============================================================*/
/* View: v_PathArchivesFile                                     */
/*==============================================================*/
CREATE OR REPLACE VIEW v_PathArchivesFile as(
SELECT PathArchivesFile.ArchivesFileNum, PathArchivesFile.Num, PathArchivesFile.ArchivesFileTypeID, PathArchivesFile.AcceptRecordNum, PathArchivesFile.EmployeeID, 
		   PathArchivesFile.ArchivesFileName, PathArchivesFile.ArchivesFilePath, PathArchivesFile.ArchivesFileUpDate, PathArchivesFileType.ArchivesFileTypeName, 
		   Employee.UserName
FROM PathArchivesFile INNER JOIN PathArchivesFileType ON PathArchivesFile.ArchivesFileTypeID = PathArchivesFileType.ArchivesFileTypeID 
	 LEFT OUTER JOIN Employee ON PathArchivesFile.EmployeeID = Employee.EmployeeID);
/*==============================================================*/
/* View: v_PowerLevelTunnelColor                                */
/*==============================================================*/
CREATE OR REPLACE VIEW v_PowerLevelTunnelColor as(
SELECT     PowerLevelTunnelColor.LevelTunnelNum,PowerLevelTunnelColor.LevelTunnelName, PowerLevelTunnelColor.VoltageLevelID, PowerLevelTunnelColor.TunnelStructureTypeID, PowerLevelTunnelColor.ShowColor, 
                      PowerLevelTunnelColor.LineWidth, TunnelStructureType.TunnelStructureTypeName, PowerCableLevel.VoltageLevelName, PowerCableLevel.VoltageValue
FROM         TunnelStructureType INNER JOIN
                      PowerLevelTunnelColor ON TunnelStructureType.TunnelStructureTypeID = PowerLevelTunnelColor.TunnelStructureTypeID INNER JOIN
                      PowerCableLevel ON PowerLevelTunnelColor.VoltageLevelID = PowerCableLevel.VoltageLevelID);
/*==============================================================*/
/* View: v_TunnelSectionTrestle                                 */
/*==============================================================*/
CREATE OR REPLACE VIEW v_TunnelSectionTrestle as(
SELECT TunnelSection.SectionNum, TunnelSection.TunnleTowardTypeID, TunnelSection.AssetNum, TunnelSection.Length, TunnelSection.OrderNum, 
         TrestleLayer.TrestleLayerNum, TrestleLayer.TrestlePositionTypeID, TrestleLayer.VoltageLevelID, TrestleLayer.Layer, TrestleLayer.TrestleLength, 
         TrestleLayer.Height, TunnleTowardType.TunnleTowardTypeName, TrestleDirectionType.TrestlePositionTypeName, RowTube.RowTubeNum, 
         RowTube.RowTubeTypeID, RowTube.RowTubeOrder, PowerCableLevel.VoltageLevelName, PowerCableLevel.VoltageValue, RowTubeType.RowTubeTypeName, 
         PowerTunnel.AssetCode, PowerTunnel.OperationCode,       
       (CASE WHEN TunnelSection.FrontTopHeight = TunnelSection.TailTopHeight THEN to_char(TunnelSection.TailTopHeight)
         ELSE to_char(TunnelSection.FrontTopHeight)||'-'||to_char(TunnelSection.TailTopHeight) END ) AS TopHeight
    FROM TunnelSection INNER JOIN PowerTunnel ON PowerTunnel.AssetNum = TunnelSection.AssetNum
       INNER JOIN TrestleLayer ON TrestleLayer.SectionNum = TunnelSection.SectionNum
       INNER JOIN TunnleTowardType ON TunnleTowardType.TunnleTowardTypeID = TunnelSection.TunnleTowardTypeID
       INNER JOIN TrestleDirectionType ON TrestleDirectionType.TrestlePositionTypeID = TrestleLayer.TrestlePositionTypeID
       LEFT OUTER JOIN RowTube ON RowTube.TrestleLayerNum = TrestleLayer.TrestleLayerNum
       LEFT OUTER JOIN PowerCableLevel ON PowerCableLevel.VoltageLevelID = TrestleLayer.VoltageLevelID
       LEFT OUTER JOIN RowTubeType ON RowTubeType.RowTubeTypeID = RowTube.RowTubeTypeID);
/*==============================================================*/
/* View: v_InspectTask                                          */
/*==============================================================*/
CREATE OR REPLACE VIEW v_InspectTask as(
SELECT
  TaskNum,
  TeamTypeID,
  InspectTask.EMPLOYEEID,
  TASK_EMPLOYEEID,Employee.UserName,
  InspectTask.TaskStatusTypeID,TaskStatusType.TaskStatusTypeName,
  TaskName,
  TaskDescription,
  PlanDate,
  WorkUserList,
  WorkBillsCode,
  StartDateTime,
  CompleteDateTime,
  Memo
FROM InspectTask
INNER JOIN TaskStatusType
  ON InspectTask.TaskStatusTypeID = TaskStatusType.TaskStatusTypeID
  inner join Employee on Employee.EmployeeID = TASK_EMPLOYEEID);
/*==============================================================*/
/* View: v_FlawAduitRecord                                      */
/*==============================================================*/
CREATE OR REPLACE VIEW v_FlawAduitRecord as(
select AduitRecordNum
      ,FlawAduitRecord.EmployeeID,Employee.UserName
      ,FlawAduitRecord.FlawAduitWayID,FlawAduitWay.FlawAduitWayName
      ,ObjFlawNum
      ,AduitOpinion
      ,AduitDate
      from  FlawAduitRecord
inner JOIN FlawAduitWay on FlawAduitRecord.FlawAduitWayID = FlawAduitWay.FlawAduitWayID
inner join Employee on Employee.EmployeeID = FlawAduitRecord.EmployeeID);
/*==============================================================*/
/* View: v_FlawProcTask                                       */
/*==============================================================*/
CREATE OR REPLACE VIEW v_FlawProcTask as(
SELECT FlawProcTaskNum
      ,TaskStatusType.TaskStatusTypeID,TaskStatusType.TaskStatusTypeName
      ,TASK_EMPLOYEEID,Employee.UserName
      ,FlawProcTask.EMPLOYEEID
      ,FlawProcTaskName
      ,FlawProcTaskDescption
      ,PlanDate
      ,WorkUserList
      ,WorkBillsCode
      ,StartDateTime
      ,CompleteDateTime
      ,Memo 
from FlawProcTask
INNER JOIN TaskStatusType
  ON TaskStatusType.TaskStatusTypeID = FlawProcTask.TaskStatusTypeID
  inner join Employee on Employee.EmployeeID = FlawProcTask.TASK_EMPLOYEEID);
/*==============================================================*/
/* View: v_InspectObjFlaw                                       */
/*==============================================================*/
CREATE OR REPLACE VIEW v_InspectObjFlaw as(
SELECT
	ObjFlawNum,
	TaskNum,
	InspectObjFlaw.FlawTypeID,FlawType.FlawTypeName,
	InspectObjFlaw.FlawSourceTypeID,FlawSourceType.FlawSourceName,
	InspectObjFlaw.FlawLevelTypeID,FlawLevelType.FlawLevelTypeName,
	InspectObjFlaw.FlawAduitStatusID,FlawAduitStatus.FlawAduitStatusName,
	ObjTypeEnum,
	case ObjTypeEnum 
			when 1 then '通道'
			when 2 then '通道段'
			when 3 then '工井'
			when 4 then '防火墙'
			when 5 then '灭火装置'
			when 6 then '线路段'
			when 7 then '本体'
			when 8 then '终端头'
			when 9 then '中间头'
			when 10 then '接地箱'
			else '未指定'
	END as ObjTypeEnumName,
	ObjTableNum,
	ObjCode,
	IsFlaw,
	FlawDescription,
	FlawDate
FROM InspectObjFlaw
LEFT JOIN FlawType on FlawType.FlawTypeID = InspectObjFlaw.FlawTypeID
LEFT JOIN 	FlawSourceType on FlawSourceType.FlawSourceTypeID =InspectObjFlaw.FlawSourceTypeID
LEFT JOIN 	FlawLevelType on FlawLevelType.FlawLevelTypeID = InspectObjFlaw.FlawLevelTypeID
LEFT JOIN 	FlawAduitStatus on FlawAduitStatus.FlawAduitStatusID = InspectObjFlaw.FlawAduitStatusID);
/*==============================================================*/
/* View: v_FlawProcTaskObj                                    */
/*==============================================================*/
CREATE OR REPLACE VIEW v_FlawProcTaskObj as(
SELECT FlawProcObj
      ,fpt.FlawProcAcceptTypeID 
	  ,fat.FlawProcAcceptTypeName
      ,FlawProcTaskNum
      ,fpt.ObjFlawNum
      ,FlawPrcoDescription
      ,Memo
      ,FlawProcDate
      ,TaskNum
      ,FlawTypeID
      ,FlawTypeName
      ,FlawSourceTypeID
      ,FlawSourceName
      ,FlawLevelTypeID
      ,FlawLevelTypeName
      ,FlawAduitStatusID
      ,FlawAduitStatusName
      ,ObjTypeEnum
      ,ObjTypeEnumName
      ,ObjTableNum
      ,ObjCode
      ,IsFlaw
      ,FlawDescription
from FlawProcTaskObj fpt
inner join v_InspectObjFlaw iof on iof.ObjFlawNum = fpt.ObjFlawNum and iof.FlawAduitStatusID>=4
inner join FlawProcAcceptType fat ON fat.FlawProcAcceptTypeID = fpt.FlawProcAcceptTypeID);
/*==============================================================*/
/* View: V_RowTube                                           */
/*==============================================================*/
CREATE OR REPLACE VIEW  V_RowTube as(
SELECT     RowTube.RowTubeNum, RowTube.TrestleLayerNum, RowTube.RowTubeTypeID, RowTube.RowTubeOrder, RowTubeType.RowTubeTypeName, TrestleLayer.SectionNum, 
                      RowTubeType.RowTubeDiameter
FROM         RowTube INNER JOIN
                      TrestleLayer ON TrestleLayer.TrestleLayerNum = RowTube.TrestleLayerNum LEFT OUTER JOIN
                      RowTubeType ON RowTubeType.RowTubeTypeID = RowTube.RowTubeTypeID);
/*==============================================================*/
/* View: v_TunnelLedgerAttachment                                           */
/*==============================================================*/
CREATE OR REPLACE VIEW v_TunnelLedgerAttachment as(
SELECT Ledger.ArchivesNum, Ledger.BaseFacilityNum, Ledger.Monitor_CompanyNum,
         Ledger.AssetBorderTypeID, Ledger.EmployeeID, Ledger.AcceptStatusTypeID,
         Ledger.bulid_CompanyNum,Ledger.ArchivesCode,
         Ledger.ArchivesName, Ledger.MonitorCompany, Ledger.BuildCompany,
         Ledger.BluePrintCode, Ledger.ArchivesPlace, Ledger.BluePrintPlace,
         Ledger.DrawerCode, Ledger.Address, Ledger.Specification,
         Ledger.BuildDate, Ledger.CompleteDate, Ledger.IsRush,
         Ledger.ArchivesTime, Ledger.Memo,
         TunnelArchivesFile.ArchivesFileNum,TunnelArchivesFile.ArchivesFileTypeID 
    FROM Ledger LEFT JOIN TunnelArchivesFile ON Ledger.ArchivesNum = TunnelArchivesFile.ArchivesNum);
/*==============================================================*/
/* View: v_TunnelAduitRecord                                    */
/*==============================================================*/
CREATE OR REPLACE VIEW v_TunnelAduitRecord as(
SELECT TunnelAduitRecord.*,Employee.UserName,TaskStatusType.TaskStatusTypeName from TunnelAduitRecord
left JOIN Employee on TunnelAduitRecord.Task_EmployeeID = Employee.EmployeeID
left JOIN TaskStatusType on TaskStatusType.TaskStatusTypeID = TunnelAduitRecord.TaskStatusTypeID);
/*==============================================================*/
/* View: View_CableOfTrestle                                    */
/*==============================================================*/
CREATE OR REPLACE VIEW V_CableOfTrestle as(
SELECT     CableOfSection.OrderNum, CableOfSection.X, CableOfSection.Y, PathCable.RunCode, PathCable.RunDate, PhaseType.PhaseTypeName, PhaseType.PhaseTypeID, 
                      AttachmentModelType.ModelTypeName, PowerLoop.LoopName, TrestleLayer.Height, TrestleLayer.Layer, TrestleLayer.TrestleLength, PathSection.PathSectionCode, 
                      PathSection.PathSectionName, PathSection.LoopLenght, CableOfSection.LayerCableNum, CableOfSection.CableNum, CableOfSection.SectionNum, 
                      CableOfSection.TrestleLayerNum, PathSection.PlaceInfo, PathSection.PlaceInfo2, CableOfSection.PlaceType, CableOfSection.IsTempCable, PowerCableLevel.VoltageValue, 
                      PowerCableLevel.VoltageLevelName
FROM         TrestleLayer INNER JOIN
                      CableOfSection ON TrestleLayer.TrestleLayerNum = CableOfSection.TrestleLayerNum INNER JOIN
                      PathCable ON CableOfSection.CableNum = PathCable.CableNum INNER JOIN
                      PhaseType ON PathCable.PhaseTypeID = PhaseType.PhaseTypeID LEFT OUTER JOIN
                      AttachmentModelType ON PathCable.ModelTypeNum = AttachmentModelType.ModelTypeNum INNER JOIN
                      PowerLoop ON PathCable.LoopNum = PowerLoop.LoopNum INNER JOIN
                      PathSection ON PowerLoop.PathSectionNum = PathSection.PathSectionNum LEFT OUTER JOIN
                      CablePath ON PathSection.CablePathNum = CablePath.CablePathNum LEFT OUTER JOIN
                      PowerCableLevel ON CablePath.VoltageLevelID = PowerCableLevel.VoltageLevelID);
/*==============================================================*/
/* View: View_CableOfTube                                       */
/*==============================================================*/
CREATE OR REPLACE VIEW V_CableOfTube as(
SELECT     CableOfSection.OrderNum, CableOfSection.X, CableOfSection.Y, PathCable.RunCode, PathCable.RunDate, PhaseType.PhaseTypeName, PhaseType.PhaseTypeID, 
                      AttachmentModelType.ModelTypeName, PowerLoop.LoopName, PathSection.PathSectionCode, PathSection.PathSectionName, PathSection.LoopLenght, 
                      RowTube.RowTubeOrder, RowTube.TrestleLayerNum, CableOfSection.LayerCableNum, CableOfSection.SectionNum, CableOfSection.RowTubeNum, 
                      CableOfSection.CableNum, PathSection.PlaceInfo, PathSection.PlaceInfo2, CableOfSection.PlaceType, CableOfSection.IsTempCable, PowerCableLevel.VoltageLevelName, 
                      PowerCableLevel.VoltageValue
FROM         PowerCableLevel RIGHT OUTER JOIN
                      CablePath ON PowerCableLevel.VoltageLevelID = CablePath.VoltageLevelID RIGHT OUTER JOIN
                      CableOfSection INNER JOIN
                      PathCable ON CableOfSection.CableNum = PathCable.CableNum INNER JOIN
                      PhaseType ON PathCable.PhaseTypeID = PhaseType.PhaseTypeID LEFT OUTER JOIN
                      AttachmentModelType ON PathCable.ModelTypeNum = AttachmentModelType.ModelTypeNum INNER JOIN
                      PowerLoop ON PathCable.LoopNum = PowerLoop.LoopNum INNER JOIN
                      PathSection ON PowerLoop.PathSectionNum = PathSection.PathSectionNum INNER JOIN
                      RowTube ON CableOfSection.RowTubeNum = RowTube.RowTubeNum ON CablePath.CablePathNum = PathSection.CablePathNum);
/*==============================================================*/
/* View: View_MixCableOfTrestle                                 */
/*==============================================================*/
CREATE OR REPLACE VIEW V_MixCableOfTrestle as(
SELECT     CableOfSection.OrderNum, CableOfSection.X, CableOfSection.Y, PathCable.RunCode, PathCable.RunDate, PhaseType.PhaseTypeName, PhaseType.PhaseTypeID, 
                      AttachmentModelType.ModelTypeName, PowerLoop.LoopName, TrestleLayer.Height, TrestleLayer.Layer, TrestleLayer.TrestleLength, PathSection.PathSectionCode, 
                      PathSection.PathSectionName, PathSection.LoopLenght, CableOfSection.LayerCableNum, CableOfSection.CableNum, CableOfSection.SectionNum, 
                      CableOfSection.TrestleLayerNum, PathSection.PlaceInfo, PathSection.PlaceInfo2, CableOfSection.PlaceType, PathType.PathTypeID, PathType.PathTypeName, 
                      BaseFacility.BaseFacilityName, CableOfSection.IsTempCable, PowerCableLevel.VoltageLevelName, PowerCableLevel.VoltageValue
FROM         TrestleLayer INNER JOIN
                      CableOfSection ON TrestleLayer.TrestleLayerNum = CableOfSection.TrestleLayerNum INNER JOIN
                      PathCable ON CableOfSection.CableNum = PathCable.CableNum INNER JOIN
                      PhaseType ON PathCable.PhaseTypeID = PhaseType.PhaseTypeID LEFT OUTER JOIN
                      AttachmentModelType ON PathCable.ModelTypeNum = AttachmentModelType.ModelTypeNum INNER JOIN
                      PowerLoop ON PathCable.LoopNum = PowerLoop.LoopNum INNER JOIN
                      PathSection ON PowerLoop.PathSectionNum = PathSection.PathSectionNum INNER JOIN
                      CablePath ON PathSection.CablePathNum = CablePath.CablePathNum INNER JOIN
                      PathType ON CablePath.PathTypeID = PathType.PathTypeID LEFT OUTER JOIN
                      PowerCableLevel ON CablePath.VoltageLevelID = PowerCableLevel.VoltageLevelID LEFT OUTER JOIN
                      BaseFacility ON PathSection.BaseFacilityNum = BaseFacility.BaseFacilityNum);
/*==============================================================*/
/* View: View_MixCableOfTube                                    */
/*==============================================================*/
CREATE OR REPLACE VIEW V_MixCableOfTube as(
SELECT     CableOfSection.OrderNum, CableOfSection.X, CableOfSection.Y, PathCable.RunCode, PathCable.RunDate, PhaseType.PhaseTypeName, PhaseType.PhaseTypeID, 
                      AttachmentModelType.ModelTypeName, PowerLoop.LoopName, PathSection.PathSectionCode, PathSection.PathSectionName, PathSection.LoopLenght, 
                      RowTube.RowTubeOrder, RowTube.TrestleLayerNum, CableOfSection.LayerCableNum, CableOfSection.SectionNum, CableOfSection.RowTubeNum, 
                      CableOfSection.CableNum, PathSection.PlaceInfo, PathSection.PlaceInfo2, CableOfSection.PlaceType, PathType.PathTypeID, PathType.PathTypeName, 
                      BaseFacility.BaseFacilityName, CableOfSection.IsTempCable, PowerCableLevel.VoltageLevelName, PowerCableLevel.VoltageValue
FROM         CableOfSection INNER JOIN
                      PathCable ON CableOfSection.CableNum = PathCable.CableNum INNER JOIN
                      PhaseType ON PathCable.PhaseTypeID = PhaseType.PhaseTypeID LEFT OUTER JOIN
                      AttachmentModelType ON PathCable.ModelTypeNum = AttachmentModelType.ModelTypeNum INNER JOIN
                      PowerLoop ON PathCable.LoopNum = PowerLoop.LoopNum INNER JOIN
                      PathSection ON PowerLoop.PathSectionNum = PathSection.PathSectionNum INNER JOIN
                      RowTube ON CableOfSection.RowTubeNum = RowTube.RowTubeNum INNER JOIN
                      CablePath ON PathSection.CablePathNum = CablePath.CablePathNum INNER JOIN
                      PathType ON CablePath.PathTypeID = PathType.PathTypeID LEFT OUTER JOIN
                      PowerCableLevel ON CablePath.VoltageLevelID = PowerCableLevel.VoltageLevelID LEFT OUTER JOIN
                      BaseFacility ON PathSection.BaseFacilityNum = BaseFacility.BaseFacilityNum);
/*==============================================================*/
/* View: v_FlawProcFile                                         */
/*==============================================================*/
CREATE OR REPLACE VIEW v_FlawProcFile as(
select FlawProcFile.*,UserName FROM FlawProcFile
left JOIN Employee on FlawProcFile.EmployeeID = Employee.EmployeeID);
/*==============================================================*/
/* View: v_FlawAdjunctFile                                      */
/*==============================================================*/
CREATE OR REPLACE VIEW v_FlawAdjunctFile as(
SELECT FlawAdjunctFile.*,UserName FROM FlawAdjunctFile
left JOIN Employee on Employee.EmployeeID = FlawAdjunctFile.EmployeeID);
/*==============================================================*/
/* View: v_ManholeOfTunnelForList                                      */
/*==============================================================*/
CREATE OR REPLACE VIEW v_ManholeOfTunnelForList as(
select
ld.ArchivesCode, /*档案编号*/
pt.AssetCode as PowerTunnelAssetCode, /*通道编号*/
m.AssetCode as ManholeAssetCode, /*工井编号*/
m.OperationCode, /*工井运行编号*/
org.OrganizationName, /*运检班组*/
mct.ManholeCoverTypeID, /*设施ID*/
mct.ManholeCoverTypeName, /*设施*/
mkt.ManholeKindTypeID, /*类型ID*/
mkt.ManholeKindTypeName, /*类型*/
m.PositionDescription, /*位置*/
m.Length, /*尺寸：长*/
m.Width, /*尺寸：宽*/
m.Diameter, /*尺寸：直径*/
m.TerraceLayerCount, /*平台层数*/
m.Height, /*地面高程*/
m.BottomHeight, /*井底高程*/
mst.ManholeStuffTypeName, /*材质*/
m.Longitude, /*经度*/
m.Latitude, /*维度*/
csf.CoverStuffTypeID, /*设施材质ID*/
csf.CoverStuffTypeName, /*设施材质*/
cst.CoverShapeTypeID, /*设施形状ID*/
cst.CoverShapeTypeName, /*设施形状*/
ey.UserName, /*录入人*/
m.AssetNum as ManholeAssetNum, /*终端设施ID*/
pt.AssetNum PowerTunnelAssetNum, /*通道台账ID*/
ld.ArchivesNum, /*通道档案ID*/
mt.OrderNum, /*工井顺序编号*/
m.CompanyNum, /*设施生产厂家ID*/
m.bulid_CompanyNum, /*施工单位ID*/
m.monitor_CompanyNum, /*监理单位ID*/
m.CompletedDate, /*竣工日期*/
m.Memo, /*备注*/
m.ManHoleCoverSize /*设施尺寸*/
from manhole m 
right join ManholeOfTunnel mt on m.AssetNum=mt.Man_AssetNum
left join PowerTunnel pt on mt.AssetNum=pt.AssetNum
left join Organization org on org.OrganizationNum = pt.OrganizationNum
left join Ledger ld on ld.ArchivesNum=pt.ArchivesNum
left join ManholeCoverType mct on mct.ManholeCoverTypeID=m.ManholeCoverTypeID
left join ManholeKindType mkt on mkt.ManholeKindTypeID=m.ManholeKindTypeID
left join CoverStuffType csf on csf.CoverStuffTypeID=m.CoverStuffTypeID
left join CoverShapeType cst on cst.CoverShapeTypeID=m.CoverShapeTypeID
left join ManholeStuffType mst on mst.ManholeStuffTypeID=m.ManholeStuffTypeID
left join Employee ey on ey.EmployeeID=m.EmployeeID
);
