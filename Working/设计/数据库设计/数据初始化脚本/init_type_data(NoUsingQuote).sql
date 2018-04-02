
INSERT INTO  AreaType (AreaTypeID,AreaTypeName) VALUES ( 1,'市区');
INSERT INTO  AreaType (AreaTypeID,AreaTypeName) VALUES ( 2,'县区');
INSERT INTO  AreaType (AreaTypeID,AreaTypeName) VALUES ( 3,'片区');

INSERT INTO  Area (AreaNum,AreaTypeID,AreaName) VALUES ( 1,1,'桥东区');
INSERT INTO  Area (AreaNum,AreaTypeID,AreaName) VALUES ( 2,1,'桥西区');
INSERT INTO  Area (AreaNum,AreaTypeID,AreaName) VALUES ( 3,1,'新华区');
INSERT INTO  Area (AreaNum,AreaTypeID,AreaName) VALUES ( 4,1,'长安区');
INSERT INTO  Area (AreaNum,AreaTypeID,AreaName) VALUES ( 5,1,'裕华区');
INSERT INTO  Area (AreaNum,AreaTypeID,AreaName) VALUES ( 6,1,'井陉矿区');
INSERT INTO  Area (AreaNum,AreaTypeID,AreaName) VALUES ( 7,1,'开发区');
INSERT INTO  Area (AreaNum,AreaTypeID,AreaName) VALUES ( 8,1,'正定新区');
INSERT INTO  Area (AreaNum,AreaTypeID,AreaName) VALUES ( 9,2,'市区');
INSERT INTO  Area (AreaNum,AreaTypeID,AreaName) VALUES ( 10,2,'鹿泉市');
INSERT INTO  Area (AreaNum,AreaTypeID,AreaName) VALUES ( 11,2,'藁城');
INSERT INTO  Area (AreaNum,AreaTypeID,AreaName) VALUES ( 12,2,'栾城');
INSERT INTO  Area (AreaNum,AreaTypeID,AreaName) VALUES ( 13,2,'正定');
INSERT INTO  Area (AreaNum,AreaTypeID,AreaName) VALUES ( 14,2,'辛集');
INSERT INTO  Area (AreaNum,AreaTypeID,AreaName) VALUES ( 15,2,'井陉');
INSERT INTO  Area (AreaNum,AreaTypeID,AreaName) VALUES ( 16,2,'新乐');
INSERT INTO  Area (AreaNum,AreaTypeID,AreaName) VALUES ( 17,2,'元氏');
INSERT INTO  Area (AreaNum,AreaTypeID,AreaName) VALUES ( 18,3,'西1');
INSERT INTO  Area (AreaNum,AreaTypeID,AreaName) VALUES ( 19,3,'西2');
INSERT INTO  Area (AreaNum,AreaTypeID,AreaName) VALUES ( 20,3,'西3');
INSERT INTO  Area (AreaNum,AreaTypeID,AreaName) VALUES ( 21,3,'西4');
INSERT INTO  Area (AreaNum,AreaTypeID,AreaName) VALUES ( 22,3,'西5');
INSERT INTO  Area (AreaNum,AreaTypeID,AreaName) VALUES ( 23,3,'东1');
INSERT INTO  Area (AreaNum,AreaTypeID,AreaName) VALUES ( 24,3,'东2');
INSERT INTO  Area (AreaNum,AreaTypeID,AreaName) VALUES ( 25,3,'东3');
INSERT INTO  Area (AreaNum,AreaTypeID,AreaName) VALUES ( 26,3,'东4');
INSERT INTO  Area (AreaNum,AreaTypeID,AreaName) VALUES ( 27,3,'东5');
INSERT INTO  Area (AreaNum,AreaTypeID,AreaName) VALUES ( 28,3,'东6');
INSERT INTO  Area (AreaNum,AreaTypeID,AreaName) VALUES ( 29,3,'未填写');


INSERT INTO  AcceptStatusType (AcceptStatusTypeID,AcceptStatusTypeName,ShowColor) VALUES ( 1,'草稿状态','#E8E8D0');
INSERT INTO  AcceptStatusType (AcceptStatusTypeID,AcceptStatusTypeName,ShowColor) VALUES ( 2,'待验状态','#D9B3B3');
INSERT INTO  AcceptStatusType (AcceptStatusTypeID,AcceptStatusTypeName,ShowColor) VALUES ( 3,'验收计划中','#64A600');
INSERT INTO  AcceptStatusType (AcceptStatusTypeID,AcceptStatusTypeName,ShowColor) VALUES ( 4,'验收中','#00AEAE');
INSERT INTO  AcceptStatusType (AcceptStatusTypeID,AcceptStatusTypeName,ShowColor) VALUES ( 5,'审核状态','#01B468');
INSERT INTO  AcceptStatusType (AcceptStatusTypeID,AcceptStatusTypeName,ShowColor) VALUES ( 6,'审核通过','#01B468');
INSERT INTO  AcceptStatusType (AcceptStatusTypeID,AcceptStatusTypeName,ShowColor) VALUES ( 7,'审核通过,资料不全','#0FB468');
INSERT INTO  AcceptStatusType (AcceptStatusTypeID,AcceptStatusTypeName,ShowColor) VALUES ( 8,'规划状态','#0FB468');


INSERT INTO  ArchivesFileType (ArchivesFileTypeID,ArchivesFileTypeName) VALUES ( 1,'规划手续');
INSERT INTO  ArchivesFileType (ArchivesFileTypeID,ArchivesFileTypeName) VALUES ( 2,'设计方案');
INSERT INTO  ArchivesFileType (ArchivesFileTypeID,ArchivesFileTypeName) VALUES ( 3,'设计图纸');
INSERT INTO  ArchivesFileType (ArchivesFileTypeID,ArchivesFileTypeName) VALUES ( 4,'施工单位资质');
INSERT INTO  ArchivesFileType (ArchivesFileTypeID,ArchivesFileTypeName) VALUES ( 5,'验收通知单');
INSERT INTO  ArchivesFileType (ArchivesFileTypeID,ArchivesFileTypeName) VALUES ( 6,'材料报告');
INSERT INTO  ArchivesFileType (ArchivesFileTypeID,ArchivesFileTypeName) VALUES ( 7,'用户自建材料');
INSERT INTO  ArchivesFileType (ArchivesFileTypeID,ArchivesFileTypeName) VALUES ( 8,'竣工图');


INSERT INTO  AssetBorderType (AssetBorderTypeID,AssetBorderTypeName) VALUES ( 1,'用户计量装置下口电缆压接处');
INSERT INTO  AssetBorderType (AssetBorderTypeID,AssetBorderTypeName) VALUES ( 2,'新设环网室负荷侧电缆压接处');
INSERT INTO  AssetBorderType (AssetBorderTypeID,AssetBorderTypeName) VALUES ( 3,'未填写');

INSERT INTO  PathType (PathTypeID,PathTypeName) VALUES ( 1,'变电');
INSERT INTO  PathType (PathTypeID,PathTypeName) VALUES ( 2,'输电');
INSERT INTO  PathType (PathTypeID,PathTypeName) VALUES ( 3,'配电');

INSERT INTO  CableAttachmentType (AttachmentTypeID,AttachmentTypeName) VALUES ( 1,'本体');
INSERT INTO  CableAttachmentType (AttachmentTypeID,AttachmentTypeName) VALUES ( 2,'接头');
INSERT INTO  CableAttachmentType (AttachmentTypeID,AttachmentTypeName) VALUES ( 3,'终端');
INSERT INTO  CableAttachmentType (AttachmentTypeID,AttachmentTypeName) VALUES ( 4,'接地箱');

INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 1,1,2,'FS-YJLV22-3*300');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 2,1,2,'FS-YJLV22-3*500');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 3,1,2,'FS-YJLW03-1*630');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 4,1,2,'FS-YJV62-1*300');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 5,1,2,'SR-YJLW02-1*400');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 6,1,2,'YJLLW02-1*400');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 7,1,2,'YJLLW02-1*500');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 8,1,2,'YJLLW02-1*630');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 9,1,2,'YJLLW02-1*800');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 10,1,2,'YJLLW02-J-1*630');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 11,1,2,'YJLV22-3*300');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 12,1,2,'YJLW02-1*1000');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 13,1,2,'YJLW02-1*300');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 14,1,2,'YJLW02-1*400');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 15,1,2,'YJLW03-1*1000');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 16,1,2,'YJLW03-1*630');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 17,1,2,'ZC-YJLVV02-1*800');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 18,1,2,'ZC-YJLW02-Z-1*1200');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 19,1,2,'ZC-YJLW02-Z-1*1600');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 20,1,2,'ZC-YJLW02-Z-1*2500');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 21,1,2,'ZC-YJLW03-1*2000');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 22,1,2,'ZC-YJLW03-1*400');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 23,1,2,'ZC-YJLW03-1*630');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 24,1,2,'ZC-YJLW03-1*800');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 25,1,2,'ZL-YJLW02-1*1600');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 26,1,2,'ZR- YJLW02-1*400');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 27,1,2,'ZR-YJLLW02-1*400');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 28,1,2,'ZR-YJLLW02-1*500');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 29,1,2,'ZR-YJLLW02-1*630');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 30,1,2,'ZR-YJLLW02-1*800');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 31,1,2,'ZR-YJLV62-1*240');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 32,1,2,'ZR-YJLW02-1*1000');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 33,1,2,'ZR-YJLW02-1*1600');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 34,1,2,'ZR-YJLW02-1*2000');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 35,1,2,'ZR-YJLW02-1*300');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 36,1,2,'ZR-YJLW02-1*400');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 37,1,2,'ZR-YJLW03-1*400');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 38,1,2,'ZR-YJLW03-1*630');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 39,1,2,'ZR-YJV22-3*185');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 40,1,2,'ZR-YJV22-3*240');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 41,1,2,'ZR-YJV22-3*300');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 42,1,3,'YJV22-3*400');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 43,1,3,'YJV22-3*300');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 44,1,3,'ZR-YJLV22-3*300');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 45,1,3,'YJLV22-3*70');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 46,1,3,'ZC-YJV22-3*300');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 47,1,3,'ZLQ2-3*150');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 48,1,3,'YJV22-3*120');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 49,1,3,'ZR-YJLV22-3*70');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 50,1,3,'ZR-YJV22-3*150');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 51,1,3,'YJLV22-3*50');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 52,1,3,'ZR-YJV22-3*120');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 53,1,3,'YJV22-3*70');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 54,1,3,'ZR-YJLV22-3*240');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 55,1,3,'YJLV22-3*120');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 56,1,3,'YJV22-3*240');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 57,1,3,'ZLQ21-3*240');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 58,1,3,'ZR-YJV22-1*35');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 59,1,3,'ZR-YJV22-3*70');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 60,1,3,'ZR-YJLV22-3*120');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 61,1,3,'YJLV22-3*240');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 62,1,3,'ZC-YJV22-3*120');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 63,1,3,'ZC-YJV22-3*240');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 64,1,3,'ZR-YJV22-3*95');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 65,1,3,'ZR-YJV22-3*35');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 66,1,3,'YJV22-3*95');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 67,1,3,'ZLQD22-3*120');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 68,1,3,'YJV22-3*25');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 69,1,3,'ZR-YJLV22-3*50');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 70,1,3,'ZR-YJV22-3*400');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 71,1,3,'YJLV22-3*150');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 72,1,3,'ZLQD22-3*240');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 73,1,3,'YJV22-3*185');
INSERT INTO  AttachmentModelType (ModelTypeNum,AttachmentTypeID,PathTypeID,ModelTypeName) VALUES ( 74,1,3,'YJLV22-3*95');


INSERT INTO  AttachmentStatusType (AttachmentStatusTypeID,AttachmentStatusTypeName) VALUES ( 1,'预占位');
INSERT INTO  AttachmentStatusType (AttachmentStatusTypeID,AttachmentStatusTypeName) VALUES ( 2,'在运');
INSERT INTO  AttachmentStatusType (AttachmentStatusTypeID,AttachmentStatusTypeName) VALUES ( 3,'停运');
INSERT INTO  AttachmentStatusType (AttachmentStatusTypeID,AttachmentStatusTypeName) VALUES ( 4,'退运');


INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 1,'富强站','01');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 2,'位同站','02');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 3,'南栗站','03');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 4,'南郊站','04');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 5,'方北站','05');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 6,'中山站','06');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 7,'红光站','07');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 8,'纺织站','08');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 9,'平安站','09');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 10,'时光站','10');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 11,'西郊站','11');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 12,'车站站','12');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 13,'新华站','13');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 14,'玉村站','14');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 15,'联盟站','15');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 16,'柳林站','16');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 17,'友谊站','17');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 18,'五七站','18');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 19,'滨河站','20');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 20,'维明站','21');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 21,'泰山站','22');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 22,'广安站','23');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 23,'北道岔站','24');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 24,'民生站','25');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 25,'东垣站','26');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 26,'东郊站','27');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 27,'北郊站','28');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 28,'长江站','29');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 29,'石化站','30');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 30,'留村站','31');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 31,'白伏站','32');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 32,'杜北站','33');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 33,'兆通站','34');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 34,'铜冶站','35');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 35,'仓丰站','36');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 36,'方村站','37');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 37,'陵园站','38');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 38,'韩通站','39');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 39,'大马站','40');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 40,'北邑站','41');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 41,'中华站','42');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 42,'裕华站','43');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 43,'鹿泉站','45');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 44,'昆仑站','44');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 45,'桥西站','46');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 46,'石牵站','47');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 47,'建华站','48');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 48,'燕山站','49');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 49,'74#开闭所','50');
INSERT INTO  BaseFacility (BaseFacilityNum,BaseFacilityName,AssetCode) VALUES ( 50,'电缆','99');

INSERT INTO  CableDeviceStyle (CableDeviceStyleID,PathTypeID,AttachmentTypeID,CableDeviceStyleName) VALUES ( 1,2,1,'铜');
INSERT INTO  CableDeviceStyle (CableDeviceStyleID,PathTypeID,AttachmentTypeID,CableDeviceStyleName) VALUES ( 2,2,1,'铝');
INSERT INTO  CableDeviceStyle (CableDeviceStyleID,PathTypeID,AttachmentTypeID,CableDeviceStyleName) VALUES ( 3,2,2,'整体');
INSERT INTO  CableDeviceStyle (CableDeviceStyleID,PathTypeID,AttachmentTypeID,CableDeviceStyleName) VALUES ( 4,2,2,'预制');
INSERT INTO  CableDeviceStyle (CableDeviceStyleID,PathTypeID,AttachmentTypeID,CableDeviceStyleName) VALUES ( 5,2,3,'户外预制');
INSERT INTO  CableDeviceStyle (CableDeviceStyleID,PathTypeID,AttachmentTypeID,CableDeviceStyleName) VALUES ( 6,2,3,'GIS预制');
INSERT INTO  CableDeviceStyle (CableDeviceStyleID,PathTypeID,AttachmentTypeID,CableDeviceStyleName) VALUES ( 7,2,3,'瓷套');
INSERT INTO  CableDeviceStyle (CableDeviceStyleID,PathTypeID,AttachmentTypeID,CableDeviceStyleName) VALUES ( 8,3,1,'铜');
INSERT INTO  CableDeviceStyle (CableDeviceStyleID,PathTypeID,AttachmentTypeID,CableDeviceStyleName) VALUES ( 9,3,1,'铝');
INSERT INTO  CableDeviceStyle (CableDeviceStyleID,PathTypeID,AttachmentTypeID,CableDeviceStyleName) VALUES ( 10,3,2,'冷缩');
INSERT INTO  CableDeviceStyle (CableDeviceStyleID,PathTypeID,AttachmentTypeID,CableDeviceStyleName) VALUES ( 11,3,2,'热缩');
INSERT INTO  CableDeviceStyle (CableDeviceStyleID,PathTypeID,AttachmentTypeID,CableDeviceStyleName) VALUES ( 12,3,3,'冷缩');
INSERT INTO  CableDeviceStyle (CableDeviceStyleID,PathTypeID,AttachmentTypeID,CableDeviceStyleName) VALUES ( 13,3,3,'热缩');

INSERT INTO  CableDeviceType (CableDeviceTypeID,AttachmentTypeID,PathTypeID,CableDeviceTypeName) VALUES ( 1,1,2,'油纸');
INSERT INTO  CableDeviceType (CableDeviceTypeID,AttachmentTypeID,PathTypeID,CableDeviceTypeName) VALUES ( 2,1,2,'交联');
INSERT INTO  CableDeviceType (CableDeviceTypeID,AttachmentTypeID,PathTypeID,CableDeviceTypeName) VALUES ( 3,2,2,'假接头');
INSERT INTO  CableDeviceType (CableDeviceTypeID,AttachmentTypeID,PathTypeID,CableDeviceTypeName) VALUES ( 4,2,2,'直通接头');
INSERT INTO  CableDeviceType (CableDeviceTypeID,AttachmentTypeID,PathTypeID,CableDeviceTypeName) VALUES ( 5,2,2,'绝缘接头');
INSERT INTO  CableDeviceType (CableDeviceTypeID,AttachmentTypeID,PathTypeID,CableDeviceTypeName) VALUES ( 6,1,3,'充油');
INSERT INTO  CableDeviceType (CableDeviceTypeID,AttachmentTypeID,PathTypeID,CableDeviceTypeName) VALUES ( 7,1,3,'交联');
INSERT INTO  CableDeviceType (CableDeviceTypeID,AttachmentTypeID,PathTypeID,CableDeviceTypeName) VALUES ( 8,3,3,'螺栓');
INSERT INTO  CableDeviceType (CableDeviceTypeID,AttachmentTypeID,PathTypeID,CableDeviceTypeName) VALUES ( 9,3,3,'T型');

INSERT INTO  ExtinguisherType (ExtinguisherTypeID,ExtinguisherTypeName) VALUES ( 1,'脉冲式');

INSERT INTO  FireWallStuffType (FireWallStuffTypeID,FireWallStuffTypeName) VALUES ( 1,'刚性');
INSERT INTO  FireWallStuffType (FireWallStuffTypeID,FireWallStuffTypeName) VALUES ( 2,'软性');

INSERT INTO  FlawLevelType (FlawLevelTypeID,FlawLevelTypeName) VALUES ( 1,'一般缺陷');
INSERT INTO  FlawLevelType (FlawLevelTypeID,FlawLevelTypeName) VALUES ( 2,'严重缺陷');
INSERT INTO  FlawLevelType (FlawLevelTypeID,FlawLevelTypeName) VALUES ( 3,'危急缺陷');

INSERT INTO  FlawProcAcceptType (FlawProcAcceptTypeID,FlawProcAcceptTypeName) VALUES ( 1,'已消缺');
INSERT INTO  FlawProcAcceptType (FlawProcAcceptTypeID,FlawProcAcceptTypeName) VALUES ( 2,'未完全消缺');
INSERT INTO  FlawProcAcceptType (FlawProcAcceptTypeID,FlawProcAcceptTypeName) VALUES ( 3,'未消缺');

INSERT INTO  FlawSourceType (FlawSourceTypeID,FlawSourceName) VALUES ( 1,'现场巡视');
INSERT INTO  FlawSourceType (FlawSourceTypeID,FlawSourceName) VALUES ( 2,'电力热线（95598）');
INSERT INTO  FlawSourceType (FlawSourceTypeID,FlawSourceName) VALUES ( 3,'其他');

INSERT INTO  FlawType (FlawTypeID,FlawTypeName) VALUES ( 1,'本体缺陷');
INSERT INTO  FlawType (FlawTypeID,FlawTypeName) VALUES ( 2,'有水缺陷');
INSERT INTO  FlawType (FlawTypeID,FlawTypeName) VALUES ( 3,'井底缺陷');
INSERT INTO  FlawType (FlawTypeID,FlawTypeName) VALUES ( 4,'井盖破损');
INSERT INTO  FlawType (FlawTypeID,FlawTypeName) VALUES ( 5,'有杂物');
INSERT INTO  FlawType (FlawTypeID,FlawTypeName) VALUES ( 6,'其他');

INSERT INTO  PhaseType (PhaseTypeID,PhaseTypeName,IsEarthPhase,PhaseColor) VALUES ( 1,'A',0,'#0FB468');
INSERT INTO  PhaseType (PhaseTypeID,PhaseTypeName,IsEarthPhase,PhaseColor) VALUES ( 2,'B',0,'#0FB468');
INSERT INTO  PhaseType (PhaseTypeID,PhaseTypeName,IsEarthPhase,PhaseColor) VALUES ( 3,'C',0,'#0FB468');
INSERT INTO  PhaseType (PhaseTypeID,PhaseTypeName,IsEarthPhase,PhaseColor) VALUES ( 4,'GND',1,'#0FB468');
INSERT INTO  PhaseType (PhaseTypeID,PhaseTypeName,IsEarthPhase,PhaseColor) VALUES ( 5,'配电',0,'#0FB468');

INSERT INTO  ProjectType (ProjectTypeID,ProjectTypeName) VALUES ( 1,'电缆工程性质');

INSERT INTO  RowTubeType (RowTubeTypeID,RowTubeTypeName,RowTubeDiameter) VALUES ( 1,'100',0.1);
INSERT INTO  RowTubeType (RowTubeTypeID,RowTubeTypeName,RowTubeDiameter) VALUES ( 2,'120',0.12);
INSERT INTO  RowTubeType (RowTubeTypeID,RowTubeTypeName,RowTubeDiameter) VALUES ( 3,'125',0.125);
INSERT INTO  RowTubeType (RowTubeTypeID,RowTubeTypeName,RowTubeDiameter) VALUES ( 4,'130',0.13);
INSERT INTO  RowTubeType (RowTubeTypeID,RowTubeTypeName,RowTubeDiameter) VALUES ( 5,'135',0.135);
INSERT INTO  RowTubeType (RowTubeTypeID,RowTubeTypeName,RowTubeDiameter) VALUES ( 6,'140',0.14);
INSERT INTO  RowTubeType (RowTubeTypeID,RowTubeTypeName,RowTubeDiameter) VALUES ( 7,'145',0.145);
INSERT INTO  RowTubeType (RowTubeTypeID,RowTubeTypeName,RowTubeDiameter) VALUES ( 8,'150',0.15);
INSERT INTO  RowTubeType (RowTubeTypeID,RowTubeTypeName,RowTubeDiameter) VALUES ( 9,'155',0.155);
INSERT INTO  RowTubeType (RowTubeTypeID,RowTubeTypeName,RowTubeDiameter) VALUES ( 10,'160',0.16);
INSERT INTO  RowTubeType (RowTubeTypeID,RowTubeTypeName,RowTubeDiameter) VALUES ( 11,'165',0.165);
INSERT INTO  RowTubeType (RowTubeTypeID,RowTubeTypeName,RowTubeDiameter) VALUES ( 12,'170',0.17);
INSERT INTO  RowTubeType (RowTubeTypeID,RowTubeTypeName,RowTubeDiameter) VALUES ( 13,'175',0.175);
INSERT INTO  RowTubeType (RowTubeTypeID,RowTubeTypeName,RowTubeDiameter) VALUES ( 14,'180',0.18);
INSERT INTO  RowTubeType (RowTubeTypeID,RowTubeTypeName,RowTubeDiameter) VALUES ( 15,'200',0.2);
INSERT INTO  RowTubeType (RowTubeTypeID,RowTubeTypeName,RowTubeDiameter) VALUES ( 16,'220',0.22);
INSERT INTO  RowTubeType (RowTubeTypeID,RowTubeTypeName,RowTubeDiameter) VALUES ( 17,'240',0.24);
INSERT INTO  RowTubeType (RowTubeTypeID,RowTubeTypeName,RowTubeDiameter) VALUES ( 18,'300',0.3);

INSERT INTO  SafeEarthType (SafeEarthTypeID,SafeEarthTypeName) VALUES ( 1,'交叉互联');
INSERT INTO  SafeEarthType (SafeEarthTypeID,SafeEarthTypeName) VALUES ( 2,'一端直接接地一端保护接地');
INSERT INTO  SafeEarthType (SafeEarthTypeID,SafeEarthTypeName) VALUES ( 3,'中间直接接地两端保护接地');

INSERT INTO  TaskStatusType (TaskStatusTypeID,TaskStatusTypeName) VALUES ( 1,'计划');
INSERT INTO  TaskStatusType (TaskStatusTypeID,TaskStatusTypeName) VALUES ( 2,'执行');
INSERT INTO  TaskStatusType (TaskStatusTypeID,TaskStatusTypeName) VALUES ( 3,'结束');

INSERT INTO  TeamType (TeamTypeID,TeamTypeName) VALUES ( 1,'通道');
INSERT INTO  TeamType (TeamTypeID,TeamTypeName) VALUES ( 2,'输电');
INSERT INTO  TeamType (TeamTypeID,TeamTypeName) VALUES ( 3,'配电');

INSERT INTO  TrestleDirectionType (TrestlePositionTypeID,TrestlePositionTypeName) VALUES ( 1,'左侧支架');
INSERT INTO  TrestleDirectionType (TrestlePositionTypeID,TrestlePositionTypeName) VALUES ( 2,'右侧支架');
INSERT INTO  TrestleDirectionType (TrestlePositionTypeID,TrestlePositionTypeName) VALUES ( 3,'横跨支架');

INSERT INTO  TrestleStuffType (TrestleStuffTypeID,TrestleStuffTypeName) VALUES ( 1,'玻璃钢');
INSERT INTO  TrestleStuffType (TrestleStuffTypeID,TrestleStuffTypeName) VALUES ( 2,'铸铁');

INSERT INTO  TunnelShapeType (TunnelShapeTypeID,TunnelShapeTypeName) VALUES ( 1,'马蹄形');
INSERT INTO  TunnelShapeType (TunnelShapeTypeID,TunnelShapeTypeName) VALUES ( 2,'圆形');
INSERT INTO  TunnelShapeType (TunnelShapeTypeID,TunnelShapeTypeName) VALUES ( 3,'方形');

INSERT INTO  TunnelStructureType (TunnelStructureTypeID,TunnelStructureTypeName,Prefix) VALUES ( 1,'隧道','SD');
INSERT INTO  TunnelStructureType (TunnelStructureTypeID,TunnelStructureTypeName,Prefix) VALUES ( 2,'顶管','DG');
INSERT INTO  TunnelStructureType (TunnelStructureTypeID,TunnelStructureTypeName,Prefix) VALUES ( 3,'方沟','FG');
INSERT INTO  TunnelStructureType (TunnelStructureTypeID,TunnelStructureTypeName,Prefix) VALUES ( 4,'沟槽','GC');
INSERT INTO  TunnelStructureType (TunnelStructureTypeID,TunnelStructureTypeName,Prefix) VALUES ( 5,'排管','PG');
INSERT INTO  TunnelStructureType (TunnelStructureTypeID,TunnelStructureTypeName,Prefix) VALUES ( 6,'拉管','LG');
INSERT INTO  TunnelStructureType (TunnelStructureTypeID,TunnelStructureTypeName,Prefix) VALUES ( 7,'直埋','ZM');
INSERT INTO  TunnelStructureType (TunnelStructureTypeID,TunnelStructureTypeName,Prefix) VALUES ( 8,'桥架','QJ');

INSERT INTO  TunnelStuffType (TunnelStuffTypeID,TunnelStructureTypeID,TunnelStuffTypeName) VALUES ( 1,1,'砖砌');
INSERT INTO  TunnelStuffType (TunnelStuffTypeID,TunnelStructureTypeID,TunnelStuffTypeName) VALUES ( 2,1,'锚喷');
INSERT INTO  TunnelStuffType (TunnelStuffTypeID,TunnelStructureTypeID,TunnelStuffTypeName) VALUES ( 3,2,'玻璃钢');
INSERT INTO  TunnelStuffType (TunnelStuffTypeID,TunnelStructureTypeID,TunnelStuffTypeName) VALUES ( 4,2,'混凝土');
INSERT INTO  TunnelStuffType (TunnelStuffTypeID,TunnelStructureTypeID,TunnelStuffTypeName) VALUES ( 5,3,'锚喷');
INSERT INTO  TunnelStuffType (TunnelStuffTypeID,TunnelStructureTypeID,TunnelStuffTypeName) VALUES ( 6,3,'砖砌');
INSERT INTO  TunnelStuffType (TunnelStuffTypeID,TunnelStructureTypeID,TunnelStuffTypeName) VALUES ( 7,3,'模铸');
INSERT INTO  TunnelStuffType (TunnelStuffTypeID,TunnelStructureTypeID,TunnelStuffTypeName) VALUES ( 8,4,'砖砌');
INSERT INTO  TunnelStuffType (TunnelStuffTypeID,TunnelStructureTypeID,TunnelStuffTypeName) VALUES ( 9,4,'冲砂');
INSERT INTO  TunnelStuffType (TunnelStuffTypeID,TunnelStructureTypeID,TunnelStuffTypeName) VALUES ( 10,4,'模铸');
INSERT INTO  TunnelStuffType (TunnelStuffTypeID,TunnelStructureTypeID,TunnelStuffTypeName) VALUES ( 11,5,'钢管');
INSERT INTO  TunnelStuffType (TunnelStuffTypeID,TunnelStructureTypeID,TunnelStuffTypeName) VALUES ( 12,5,'海泡石');
INSERT INTO  TunnelStuffType (TunnelStuffTypeID,TunnelStructureTypeID,TunnelStuffTypeName) VALUES ( 13,5,'螺纹管');
INSERT INTO  TunnelStuffType (TunnelStuffTypeID,TunnelStructureTypeID,TunnelStuffTypeName) VALUES ( 14,5,'mpp');
INSERT INTO  TunnelStuffType (TunnelStuffTypeID,TunnelStructureTypeID,TunnelStuffTypeName) VALUES ( 15,5,'PE');
INSERT INTO  TunnelStuffType (TunnelStuffTypeID,TunnelStructureTypeID,TunnelStuffTypeName) VALUES ( 16,5,'mpc');
INSERT INTO  TunnelStuffType (TunnelStuffTypeID,TunnelStructureTypeID,TunnelStuffTypeName) VALUES ( 17,5,'玻璃钢');
INSERT INTO  TunnelStuffType (TunnelStuffTypeID,TunnelStructureTypeID,TunnelStuffTypeName) VALUES ( 18,6,'钢管');
INSERT INTO  TunnelStuffType (TunnelStuffTypeID,TunnelStructureTypeID,TunnelStuffTypeName) VALUES ( 19,6,'海泡石');
INSERT INTO  TunnelStuffType (TunnelStuffTypeID,TunnelStructureTypeID,TunnelStuffTypeName) VALUES ( 20,6,'螺纹管');
INSERT INTO  TunnelStuffType (TunnelStuffTypeID,TunnelStructureTypeID,TunnelStuffTypeName) VALUES ( 21,6,'mpp');
INSERT INTO  TunnelStuffType (TunnelStuffTypeID,TunnelStructureTypeID,TunnelStuffTypeName) VALUES ( 22,6,'PE');
INSERT INTO  TunnelStuffType (TunnelStuffTypeID,TunnelStructureTypeID,TunnelStuffTypeName) VALUES ( 23,6,'mpc');
INSERT INTO  TunnelStuffType (TunnelStuffTypeID,TunnelStructureTypeID,TunnelStuffTypeName) VALUES ( 24,7,'钢管');
INSERT INTO  TunnelStuffType (TunnelStuffTypeID,TunnelStructureTypeID,TunnelStuffTypeName) VALUES ( 25,7,'海泡石');
INSERT INTO  TunnelStuffType (TunnelStuffTypeID,TunnelStructureTypeID,TunnelStuffTypeName) VALUES ( 26,7,'螺纹管');
INSERT INTO  TunnelStuffType (TunnelStuffTypeID,TunnelStructureTypeID,TunnelStuffTypeName) VALUES ( 27,7,'mpp');
INSERT INTO  TunnelStuffType (TunnelStuffTypeID,TunnelStructureTypeID,TunnelStuffTypeName) VALUES ( 28,7,'PE');
INSERT INTO  TunnelStuffType (TunnelStuffTypeID,TunnelStructureTypeID,TunnelStuffTypeName) VALUES ( 29,7,'mpc');
INSERT INTO  TunnelStuffType (TunnelStuffTypeID,TunnelStructureTypeID,TunnelStuffTypeName) VALUES ( 30,8,'铁');

INSERT INTO  TunnleTowardType (TunnleTowardTypeID,TunnleTowardTypeName) VALUES ( 1,'东');
INSERT INTO  TunnleTowardType (TunnleTowardTypeID,TunnleTowardTypeName) VALUES ( 2,'南');
INSERT INTO  TunnleTowardType (TunnleTowardTypeID,TunnleTowardTypeName) VALUES ( 3,'西');
INSERT INTO  TunnleTowardType (TunnleTowardTypeID,TunnleTowardTypeName) VALUES ( 4,'北');

INSERT INTO  ManholeType (ManholeTypeID,ManholeTypeName) VALUES ( 1,'电缆井');
INSERT INTO  ManholeType (ManholeTypeID,ManholeTypeName) VALUES ( 2,'虚拟井');
INSERT INTO  ManholeType (ManholeTypeID,ManholeTypeName) VALUES ( 3,'变电站出线井');
INSERT INTO  ManholeType (ManholeTypeID,ManholeTypeName) VALUES ( 4,'终端设施');

INSERT INTO  ManholeShapeType (ManholeShapeTypeID,ManholeShapeTypeName) VALUES ( 1,'圆形');
INSERT INTO  ManholeShapeType (ManholeShapeTypeID,ManholeShapeTypeName) VALUES ( 2,'方形');

INSERT INTO  ManholeCoverType (ManholeCoverTypeID,ManholeCoverTypeName) VALUES ( 1,'井盖');
INSERT INTO  ManholeCoverType (ManholeCoverTypeID,ManholeCoverTypeName) VALUES ( 2,'风楼');
INSERT INTO  ManholeCoverType (ManholeCoverTypeID,ManholeCoverTypeName) VALUES ( 3,'虚拟井');

INSERT INTO  ManholeKindType (ManholeKindTypeID,ManholeTypeID,ManholeKindTypeName,LayerIcon) VALUES ( 1,1,'直线井','直线井');
INSERT INTO  ManholeKindType (ManholeKindTypeID,ManholeTypeID,ManholeKindTypeName,LayerIcon) VALUES ( 2,1,'转角井','转角井');
INSERT INTO  ManholeKindType (ManholeKindTypeID,ManholeTypeID,ManholeKindTypeName,LayerIcon) VALUES ( 3,1,'三通井','三通井');
INSERT INTO  ManholeKindType (ManholeKindTypeID,ManholeTypeID,ManholeKindTypeName,LayerIcon) VALUES ( 4,1,'四通井','四通井');
INSERT INTO  ManholeKindType (ManholeKindTypeID,ManholeTypeID,ManholeKindTypeName,LayerIcon) VALUES ( 5,1,'五通井','五通井');
INSERT INTO  ManholeKindType (ManholeKindTypeID,ManholeTypeID,ManholeKindTypeName,LayerIcon) VALUES ( 6,1,'六通井','六通井');
INSERT INTO  ManholeKindType (ManholeKindTypeID,ManholeTypeID,ManholeKindTypeName,LayerIcon) VALUES ( 7,1,'暗井','十字叉');
INSERT INTO  ManholeKindType (ManholeKindTypeID,ManholeTypeID,ManholeKindTypeName,LayerIcon) VALUES ( 8,1,'风楼','风楼');
INSERT INTO  ManholeKindType (ManholeKindTypeID,ManholeTypeID,ManholeKindTypeName,LayerIcon) VALUES ( 9,1,'通风口','通风口');
INSERT INTO  ManholeKindType (ManholeKindTypeID,ManholeTypeID,ManholeKindTypeName,LayerIcon) VALUES ( 10,3,'站内出线井','站内出线井');
INSERT INTO  ManholeKindType (ManholeKindTypeID,ManholeTypeID,ManholeKindTypeName,LayerIcon) VALUES ( 11,2,'支架变动井','支架变动井');
INSERT INTO  ManholeKindType (ManholeKindTypeID,ManholeTypeID,ManholeKindTypeName,LayerIcon) VALUES ( 12,2,'墙壁出线井','墙壁出线井');
INSERT INTO  ManholeKindType (ManholeKindTypeID,ManholeTypeID,ManholeKindTypeName,LayerIcon) VALUES ( 13,2,'电缆虚拟井','电缆虚拟井');
INSERT INTO  ManholeKindType (ManholeKindTypeID,ManholeTypeID,ManholeKindTypeName,LayerIcon) VALUES ( 14,2,'虚拟井','虚拟井');
INSERT INTO  ManholeKindType (ManholeKindTypeID,ManholeTypeID,ManholeKindTypeName,LayerIcon) VALUES ( 15,4,'分接箱','分接箱');
INSERT INTO  ManholeKindType (ManholeKindTypeID,ManholeTypeID,ManholeKindTypeName,LayerIcon) VALUES ( 16,4,'开闭所','开闭所');
INSERT INTO  ManholeKindType (ManholeKindTypeID,ManholeTypeID,ManholeKindTypeName,LayerIcon) VALUES ( 17,4,'杆塔','杆塔');
INSERT INTO  ManholeKindType (ManholeKindTypeID,ManholeTypeID,ManholeKindTypeName,LayerIcon) VALUES ( 18,4,'箱变','箱变');
INSERT INTO  ManholeKindType (ManholeKindTypeID,ManholeTypeID,ManholeKindTypeName,LayerIcon) VALUES ( 19,4,'配电室','配电室');
INSERT INTO  ManholeKindType (ManholeKindTypeID,ManholeTypeID,ManholeKindTypeName,LayerIcon) VALUES ( 20,4,'户外高压计量箱','户外高压计量箱');
INSERT INTO  ManholeKindType (ManholeKindTypeID,ManholeTypeID,ManholeKindTypeName,LayerIcon) VALUES ( 21,4,'T接头','T接头');
INSERT INTO  ManholeKindType (ManholeKindTypeID,ManholeTypeID,ManholeKindTypeName,LayerIcon) VALUES ( 22,4,'变电站','变电站');

INSERT INTO  DoorStuffType (DoorStuffTypeID,DoorStuffTypeName) VALUES ( 1,'防火板');
INSERT INTO  DoorStuffType (DoorStuffTypeID,DoorStuffTypeName) VALUES ( 2,'不锈钢');

INSERT INTO  CoverStuffType (CoverStuffTypeID,ManholeCoverTypeID,CoverStuffTypeName) VALUES ( 1,1,'水泥双层');
INSERT INTO  CoverStuffType (CoverStuffTypeID,ManholeCoverTypeID,CoverStuffTypeName) VALUES ( 2,1,'衡水永固');
INSERT INTO  CoverStuffType (CoverStuffTypeID,ManholeCoverTypeID,CoverStuffTypeName) VALUES ( 3,1,'球墨铸铁');
INSERT INTO  CoverStuffType (CoverStuffTypeID,ManholeCoverTypeID,CoverStuffTypeName) VALUES ( 4,1,'其他');
INSERT INTO  CoverStuffType (CoverStuffTypeID,ManholeCoverTypeID,CoverStuffTypeName) VALUES ( 5,1,'电字');
INSERT INTO  CoverStuffType (CoverStuffTypeID,ManholeCoverTypeID,CoverStuffTypeName) VALUES ( 6,1,'复合井盖');
INSERT INTO  CoverStuffType (CoverStuffTypeID,ManholeCoverTypeID,CoverStuffTypeName) VALUES ( 7,1,'灵寿永胜');

INSERT INTO  CoverShapeType (CoverShapeTypeID,CoverShapeTypeName) VALUES ( 1,'圆形');
INSERT INTO  CoverShapeType (CoverShapeTypeID,CoverShapeTypeName) VALUES ( 2,'方形');

INSERT INTO  CompanyType (CompanyTypeID,CompanyTypeName) VALUES ( 1,'监理单位');
INSERT INTO  CompanyType (CompanyTypeID,CompanyTypeName) VALUES ( 2,'施工单位');
INSERT INTO  CompanyType (CompanyTypeID,CompanyTypeName) VALUES ( 3,'生产厂家');
INSERT INTO  CompanyType (CompanyTypeID,CompanyTypeName) VALUES ( 4,'电缆厂家');
INSERT INTO  CompanyType (CompanyTypeID,CompanyTypeName) VALUES ( 5,'电缆附件厂家');
