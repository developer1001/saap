/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : hmsh

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2018-07-22 23:00:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_auth
-- ----------------------------
DROP TABLE IF EXISTS `sys_auth`;
CREATE TABLE `sys_auth` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `menuName` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `menuCode` varchar(50) DEFAULT NULL COMMENT '菜单编码',
  `menuUrl` varchar(50) DEFAULT NULL COMMENT '菜单地址',
  `description` varchar(50) DEFAULT NULL COMMENT '菜单描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_auth
-- ----------------------------
INSERT INTO `sys_auth` VALUES ('2', '百度', 'asgbsdgkjs564dfgsd', 'https://www.baidu.com', '百度');
INSERT INTO `sys_auth` VALUES ('8', '腾讯', '4s8d4f84gwq4fe9q', 'http://www.qq.com/', '还乱码吗腾讯');
INSERT INTO `sys_auth` VALUES ('9', '天气', '', 'http://tianqi.hao123.com/', '天气预报');
INSERT INTO `sys_auth` VALUES ('10', '搜狐', '', 'http://www.sohu.com/', '搜狐网的网址');
INSERT INTO `sys_auth` VALUES ('11', '网易', '', 'http://www.163.com/', '网易的网址');
INSERT INTO `sys_auth` VALUES ('12', '去哪网', '', 'https://www.qunar.com/', '去哪网的网址');
INSERT INTO `sys_auth` VALUES ('13', '12306', '', 'http://www.12306.cn/mormhweb/', '12306买票');
INSERT INTO `sys_auth` VALUES ('14', '凤凰网', '', 'http://www.ifeng.com/', '凤凰网');
INSERT INTO `sys_auth` VALUES ('15', '淘宝网', '', 'https://www.taobao.com/', '淘宝网来了，你的购物天堂');
INSERT INTO `sys_auth` VALUES ('16', '京东', '', 'https://www.jd.com/', '买电器，上京东');
INSERT INTO `sys_auth` VALUES ('17', '当当', '', 'http://www.dangdang.com/', '买图书，选当当网');
INSERT INTO `sys_auth` VALUES ('18', '游戏4399', '', 'http://www.4399.com/', '4399小游戏，玩的开心');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `dept_name` varchar(50) DEFAULT NULL COMMENT '部门名称',
  `dept_code` varchar(50) DEFAULT NULL COMMENT '部门编码',
  `pid` int(10) DEFAULT NULL COMMENT '上级部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('1', '水利局', 'asgbsdgkjs564dfgsd', null);
INSERT INTO `sys_dept` VALUES ('2', '水利二局', 'dfg645', '1');
INSERT INTO `sys_dept` VALUES ('3', '水利三局', '4b6rw5ht', '1');
INSERT INTO `sys_dept` VALUES ('4', '公安部', 'ga1fe54g', null);
INSERT INTO `sys_dept` VALUES ('5', '北京市公安局', '456ewg6we5', '4');
INSERT INTO `sys_dept` VALUES ('6', '北京市公安局海淀分局', '546q1g6reg', '5');
INSERT INTO `sys_dept` VALUES ('7', '北京市公安局朝阳分局', '46erg51845y64sa', '5');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `F_ModuleId` varchar(100) NOT NULL,
  `F_ParentId` varchar(100) DEFAULT NULL,
  `F_EnCode` varchar(100) DEFAULT NULL,
  `F_FullName` varchar(100) DEFAULT NULL,
  `F_Icon` varchar(100) DEFAULT NULL,
  `F_UrlAddress` varchar(100) DEFAULT NULL,
  `F_Target` varchar(100) DEFAULT NULL,
  `F_IsMenu` int(10) DEFAULT NULL,
  `F_AllowExpand` int(10) DEFAULT NULL,
  `F_IsPublic` int(10) DEFAULT NULL,
  `F_AllowEdit` varchar(100) DEFAULT NULL,
  `F_AllowDelete` varchar(100) DEFAULT NULL,
  `F_SortCode` int(10) DEFAULT NULL,
  `F_DeleteMark` int(10) DEFAULT NULL,
  `F_EnabledMark` int(10) DEFAULT NULL,
  `F_Description` varchar(100) DEFAULT NULL,
  `F_CreateDate` datetime DEFAULT NULL,
  `F_CreateUserId` varchar(100) DEFAULT NULL,
  `F_CreateUserName` varchar(100) DEFAULT NULL,
  `F_ModifyDate` datetime DEFAULT NULL,
  `F_ModifyUserId` varchar(100) DEFAULT NULL,
  `F_ModifyUserName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`F_ModuleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('00ae31cf-b340-4c17-9ee7-6dd08943df02', '458113c6-b0be-4d6f-acce-7524f4bc3e88', 'FormCategory', '表单类别', 'fa fa-tags', '/SystemManage/DataItemList/Index?ItemCode=FormSort', 'iframe', '1', '1', '0', null, null, '1', '0', '1', null, '2015-11-27 10:30:47', 'System', '超级管理员', '2015-12-01 09:42:16', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('021a59b0-2589-4f9e-8140-6052177a967c', '5', '我的流程', '我的流程', 'fa fa-file-word-o', '/FlowManage/FlowMyProcess/Index', 'iframe', '1', '1', '0', null, null, '3', '0', '1', null, '2016-03-19 13:32:54', '24a055d6-5924-44c5-be52-3715cdd68011', '陈彬彬', '2016-03-22 20:02:21', '24a055d6-5924-44c5-be52-3715cdd68011', '陈彬彬');
INSERT INTO `sys_menu` VALUES ('04b88c96-8d99-45ec-956c-444efa630020', '4', 'ResourceFileManage', '文件资料', 'fa fa-jsfiddle', '/PublicInfoManage/ResourceFile/Index', 'iframe', '1', '1', '0', null, null, '3', '0', '1', '文件管理', '2015-11-27 09:47:48', 'System', '超级管理员', '2016-04-21 15:06:21', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('08dfd779-92d5-4cd8-9982-a76176af0f7c', '458113c6-b0be-4d6f-acce-7524f4bc3e88', 'FlowCategory', '流程类别', 'fa fa-tags', '/SystemManage/DataItemList/Index?ItemCode=FlowSort', 'iframe', '1', '1', '0', null, null, '2', '0', '1', null, '2015-11-23 14:42:18', 'System', '超级管理员', '2015-11-27 10:41:42', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('0d296398-bc0e-4f38-996a-6e24bc88cc53', '5', '待办流程', '待办流程', 'fa fa-hourglass-half', '/FlowManage/FlowBeforeProcessing/Index', 'iframe', '1', '1', '0', null, null, '4', '0', '1', null, '2015-11-23 22:13:39', 'System', '超级管理员', '2016-03-23 18:07:42', '24a055d6-5924-44c5-be52-3715cdd68011', '陈彬彬');
INSERT INTO `sys_menu` VALUES ('1', '0', 'SysManage', '系统管理', 'fa fa-desktop', null, 'expand', '0', '1', '0', null, null, '1', '0', '1', null, null, null, null, '2015-11-17 11:22:46', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('10', '2', 'UserManage', '用户管理', 'fa fa-user', 'view/default', 'iframe', '1', '1', '0', null, null, '8', '0', '1', null, null, null, null, '2016-04-29 11:51:54', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('11', '2', 'RoleManage', '角色管理', 'fa fa-paw', '/BaseManage/Role/Index', 'iframe', '1', '1', '0', null, null, '3', '0', '1', null, null, null, null, '2016-05-23 18:12:29', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('12', '2', 'JobManage', '职位管理', 'fa fa-briefcase', '/BaseManage/Job/Index', 'iframe', '1', '1', '0', null, null, '6', '0', '1', null, null, null, null, '2016-04-29 12:00:32', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('13', '2', 'PostManage', '岗位管理', 'fa fa-graduation-cap', '/BaseManage/Post/Index', 'iframe', '1', '1', '0', null, null, '5', '0', '1', null, null, null, null, '2016-04-29 11:59:17', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('14', '2', 'UserGroupManage', '用户组管理', 'fa fa-group', '/BaseManage/UserGroup/Index', 'iframe', '1', '1', '0', null, null, '7', '0', '1', null, null, null, null, '2016-04-29 12:01:17', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('16d4e2d5-d154-455f-94f7-63bf80ab26aa', 'ad147f6d-613f-4d2d-8c84-b749d0754f3b', 'ClientBaseData', '基础设置', 'fa fa fa-book', null, 'expand', '0', '1', '1', null, null, '1', '0', '1', '客户基础资料', '2016-03-11 11:51:34', '0f36148c-719f-41e0-8c8c-16ffbc40d0e0', '佘赐雄', '2016-03-29 09:41:15', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('1b642904-d674-495f-a1e1-4814cc543870', '5', '发起流程', '发起流程', 'fa fa-edit', '/FlowManage/FlowLaunch/Index', 'iframe', '1', '1', '0', null, null, '1', '0', '1', null, '2015-11-23 22:12:27', 'System', '超级管理员', '2016-01-12 17:39:01', '0f36148c-719f-41e0-8c8c-16ffbc40d0e0', '佘赐雄');
INSERT INTO `sys_menu` VALUES ('1d3797f6-5cd2-41bc-b769-27f2513d61a9', 'ad147f6d-613f-4d2d-8c84-b749d0754f3b', 'ClientInfoManage', '客户管理', 'fa fa-suitcase', '/CustomerManage/Customer/Index', 'iframe', '1', '0', '0', null, null, '3', '0', '1', '客户管理', '2016-03-11 11:57:48', '0f36148c-719f-41e0-8c8c-16ffbc40d0e0', '佘赐雄', '2016-04-29 14:19:05', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('1ef31fba-7f0a-46f7-b533-49dd0c2e51e0', 'ad147f6d-613f-4d2d-8c84-b749d0754f3b', 'ClienReceivableReport', '收款报表', 'fa fa-bar-chart', '/CustomerManage/ReceivableReport/Index', 'iframe', '1', '1', '0', null, null, '7', '0', '1', '收款报表', '2016-04-20 09:41:51', 'System', '超级管理员', '2016-04-29 14:21:24', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('2', '0', 'BaseManage', '单位组织', 'fa fa-coffee', null, 'expand', '0', '1', '0', null, null, '2', '0', '1', null, null, null, null, '2016-03-11 11:02:06', '0f36148c-719f-41e0-8c8c-16ffbc40d0e0', '佘赐雄');
INSERT INTO `sys_menu` VALUES ('21', '1', 'SystemModule', '系统功能', 'fa fa-navicon', 'view/MyJsp.jsp', 'iframe', '1', '0', '0', null, null, '7', '0', '1', '系统导航功能', null, null, null, '2016-04-29 14:13:00', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('23713d3a-810f-422d-acd5-39bec28ce47e', '4', 'ScheduleManage', '日程管理', 'fa fa-calendar', '/PublicInfoManage/Schedule/Index', 'iframe', '1', '0', '0', null, null, '6', '0', '1', '日程管理', '2016-04-21 14:15:30', 'System', '超级管理员', '2016-04-21 16:08:46', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('27b6c487-a2d9-4a3a-a40d-dbba27a53d26', 'b5cb98f6-fb41-4a0f-bc11-469ff117a411', 'FlowMonitor', '流程监控', 'fa fa-eye', '/FlowManage/FlowProcess/MonitoringIndex', 'iframe', '1', '1', '0', null, null, '2', '0', '1', null, '2015-11-23 21:58:17', 'System', '超级管理员', '2016-04-26 12:06:13', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('2f820f6e-ae2e-472f-82cc-0129a2a57597', '7cec0a0f-7204-4240-b009-312fa0c11cbf', 'DataBaseTable', '数据表管理', 'fa fa-table', '/SystemManage/DataBaseTable/Index', 'iframe', '1', '1', '0', null, null, '3', '0', '1', '数据库表结构', '2015-11-24 09:53:42', 'System', '超级管理员', '2016-04-29 14:08:55', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('34e362f4-c220-4fb7-b3f0-288c83417cb3', '7cec0a0f-7204-4240-b009-312fa0c11cbf', 'DataBaseLink', '数据库连接', 'fa fa-plug', '/SystemManage/DataBaseLink/Index', 'iframe', '1', '1', '0', null, null, '1', '0', '1', '动态链接数据库', '2015-11-24 09:50:22', 'System', '超级管理员', '2016-04-29 14:07:45', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('3b03806d-98d8-40fe-9895-01633119458c', '16d4e2d5-d154-455f-94f7-63bf80ab26aa', 'Client_ProductInfo', '产品信息', 'fa fa-shopping-bag', '/SystemManage/DataItemList/Index?ItemCode=Client_ProductInfo', 'iframe', '1', '0', '0', null, null, '1', '0', '1', '销售产品信息', '2016-03-11 16:42:57', '0f36148c-719f-41e0-8c8c-16ffbc40d0e0', '佘赐雄', '2016-03-23 16:36:07', '0f36148c-719f-41e0-8c8c-16ffbc40d0e0', '佘赐雄');
INSERT INTO `sys_menu` VALUES ('4', '0', 'CommonInfo', '公共信息', 'fa fa-globe', null, 'expand', '0', '1', '0', null, null, '5', '0', '1', null, null, null, null, '2016-04-11 10:21:59', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('458113c6-b0be-4d6f-acce-7524f4bc3e88', '5', '流程配置', '流程配置', 'fa fa-wrench', null, 'expand', '0', '1', '0', null, null, '7', '0', '1', null, '2015-11-27 10:39:01', 'System', '超级管理员', '2016-03-19 13:34:52', '24a055d6-5924-44c5-be52-3715cdd68011', '陈彬彬');
INSERT INTO `sys_menu` VALUES ('4d0f2e44-f68f-41fd-a55c-40ac67453ef4', 'b9f9df92-8ac5-46e2-90ac-68c5c2e034c3', '企业号成员', '企业号成员', 'fa fa-users', '/WeChatManage/User/Index', 'iframe', '1', '0', '0', null, null, '3', '0', '1', null, '2015-12-22 17:20:53', 'System', '超级管理员', '2016-04-29 14:11:24', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('4efd37bf-e3ef-4ced-8248-58eba046d78b', '1', 'DataItemManage', '通用字典', 'fa fa-book', '/SystemManage/DataItemDetail/Index', 'iframe', '1', '1', '0', null, null, '2', '0', '1', '通用数据字典', '2015-11-12 14:37:04', 'System', '超级管理员', '2016-04-29 14:06:26', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('5', '0', 'FlowManage', '工作流程', 'fa fa-share-alt', null, 'expand', '0', '1', '0', null, null, '3', '0', '1', null, null, null, null, '2016-04-11 10:21:44', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('52fe82f8-41ba-433e-9351-ef67e5b35217', '16d4e2d5-d154-455f-94f7-63bf80ab26aa', 'Client_Level', '客户级别', 'fa fa-tag', '/SystemManage/DataItemList/Index?ItemCode=Client_Level', 'iframe', '1', '0', '0', null, null, '5', '0', '1', null, '2016-03-11 16:52:08', '0f36148c-719f-41e0-8c8c-16ffbc40d0e0', '佘赐雄', '2016-04-06 10:23:29', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('535d92e9-e066-406c-b2c2-697150a5bdff', 'ad147f6d-613f-4d2d-8c84-b749d0754f3b', 'ClienReceivable', '收款管理', 'fa fa-money', '/CustomerManage/Receivable/Index', 'iframe', '1', '0', '0', null, null, '6', '0', '1', '收款管理', '2016-04-06 16:04:16', 'System', '超级管理员', '2016-04-29 14:20:56', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('5cc9d2d9-e097-4b51-9b9e-84ca9f1a0ab5', 'b9f9df92-8ac5-46e2-90ac-68c5c2e034c3', '企业号部门', '企业号部门', 'fa fa-sitemap', '/WeChatManage/Organize/Index', 'iframe', '1', '0', '0', null, null, '2', '0', '1', null, '2015-12-22 17:20:38', 'System', '超级管理员', '2016-04-29 14:10:46', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('5f1fa264-cc9b-4146-b49e-743e4633bb4c', 'ad147f6d-613f-4d2d-8c84-b749d0754f3b', 'ClientInvoice', '客户开票', 'fa fa-coffee', '/CustomerManage/Invoice/Index', 'iframe', '1', '0', '0', null, null, '4', '0', '1', '开票管理', '2016-04-01 10:40:18', 'System', '超级管理员', '2016-04-29 14:20:23', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('6', '0', 'ReportManage', '报表中心', 'fa fa-area-chart', null, 'expand', '0', '1', '0', null, null, '4', '0', '1', null, null, null, null, '2016-04-11 10:21:54', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('6252983c-52f5-402c-991b-ad19a9cb1f94', '4', 'NoticeManage', '通知公告', 'fa fa-volume-up', '/PublicInfoManage/Notice/Index', 'iframe', '1', '1', '0', null, null, '2', '0', '1', null, '2015-11-27 09:47:33', 'System', '超级管理员', '2016-04-29 14:17:39', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('62af0605-4558-47b1-9530-bc3515036b37', '16d4e2d5-d154-455f-94f7-63bf80ab26aa', 'Client_PaymentAccount', '收支账户', 'fa fa-tag', '/SystemManage/DataItemList/Index?ItemCode=Client_PaymentAccount', 'iframe', '1', '0', '0', null, null, '9', '0', '1', null, '2016-04-20 09:54:48', 'System', '超级管理员', '2016-04-20 09:55:13', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('66f6301c-1789-4525-a7d2-2b83272aafa6', 'ad147f6d-613f-4d2d-8c84-b749d0754f3b', 'ClientChance', '商机管理', 'fa fa-binoculars', '/CustomerManage/Chance/Index', 'iframe', '1', '1', '0', null, null, '2', '0', '1', '商机管理', '2016-03-11 11:55:16', '0f36148c-719f-41e0-8c8c-16ffbc40d0e0', '佘赐雄', '2016-04-29 14:19:13', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('691f3810-a602-4523-8518-ce5856482d48', '5', '草稿流程', '草稿流程', 'fa fa-file-text-o', '/FlowManage/FlowRoughdraft/Index', 'iframe', '1', '1', '0', null, null, '2', '0', '1', null, '2015-11-23 22:13:21', 'System', '超级管理员', '2016-03-19 16:15:15', '24a055d6-5924-44c5-be52-3715cdd68011', '陈彬彬');
INSERT INTO `sys_menu` VALUES ('6a67a67f-ef07-41e7-baa5-00bc5f662a76', '5', '工作委托', '工作委托', 'fa fa-coffee', '/FlowManage/FlowDelegate/Index', 'iframe', '1', '1', '0', null, null, '6', '0', '1', null, '2015-11-23 22:14:20', 'System', '超级管理员', '2016-03-28 17:34:24', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('6be31cc9-4aee-4279-8435-4b266cec33f0', '16d4e2d5-d154-455f-94f7-63bf80ab26aa', 'Client_Trade', '客户行业', 'fa fa-tag', '/SystemManage/DataItemList/Index?ItemCode=Client_Trade', 'iframe', '1', '0', '0', null, null, '2', '0', '1', null, '2016-03-11 16:45:14', '0f36148c-719f-41e0-8c8c-16ffbc40d0e0', '佘赐雄', '2016-03-23 16:36:23', '0f36148c-719f-41e0-8c8c-16ffbc40d0e0', '佘赐雄');
INSERT INTO `sys_menu` VALUES ('77f13de5-32ad-4226-9e24-f1db507e78cb', '16d4e2d5-d154-455f-94f7-63bf80ab26aa', 'Client_PaymentMode', '收支方式', 'fa fa-tag', '/SystemManage/DataItemList/Index?ItemCode=Client_PaymentMode', 'iframe', '1', '0', '0', null, null, '8', '0', '1', null, '2016-03-14 19:49:53', '0f36148c-719f-41e0-8c8c-16ffbc40d0e0', '佘赐雄', '2016-04-20 09:55:52', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('7adc5a16-54a4-408e-a101-2ddab8117d67', '1', 'CodeRule', '单据编码', 'fa fa-barcode', '/SystemManage/CodeRule/Index', 'iframe', '1', '1', '0', null, null, '3', '0', '1', '自动产生号码', '2015-11-12 14:47:51', 'System', '超级管理员', '2016-05-03 15:56:56', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('7ae94059-9aa5-48eb-8330-4e2a6565b193', '1', 'AreaManage', '行政区域', 'fa fa-leaf', '/SystemManage/Area/Index', 'iframe', '1', '1', '0', null, null, '1', '0', '1', '行政区域管理', '2015-11-12 14:38:20', 'System', '超级管理员', '2016-04-29 14:05:33', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('7cec0a0f-7204-4240-b009-312fa0c11cbf', '1', 'DatabaseManage', '数据管理', 'fa fa-database', null, 'expand', '0', '1', '0', null, null, '4', '0', '1', null, '2015-11-12 15:03:09', 'System', '超级管理员', '2016-03-11 12:10:01', '0f36148c-719f-41e0-8c8c-16ffbc40d0e0', '佘赐雄');
INSERT INTO `sys_menu` VALUES ('8', '2', 'OrganizeManage', '机构管理', 'fa fa-sitemap', '/BaseManage/Organize/Index', 'iframe', '1', '1', '0', null, null, '1', '0', '1', null, null, null, null, '2016-04-29 11:55:28', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('80620d6f-55bd-492b-9c21-1b04ca268e75', '16d4e2d5-d154-455f-94f7-63bf80ab26aa', 'Client_ChancePhase', '商机阶段', 'fa fa-tag', '/SystemManage/DataItemList/Index?ItemCode=Client_ChancePhase', 'iframe', '1', '0', '0', null, null, '7', '0', '1', null, '2016-03-12 11:02:09', '0f36148c-719f-41e0-8c8c-16ffbc40d0e0', '佘赐雄', '2016-03-23 16:37:06', '0f36148c-719f-41e0-8c8c-16ffbc40d0e0', '佘赐雄');
INSERT INTO `sys_menu` VALUES ('9', '2', 'DepartmentManage', '部门管理', 'fa fa-th-list', '/BaseManage/Department/Index', 'iframe', '1', '1', '0', null, null, '2', '0', '1', null, null, null, null, '2016-04-29 11:57:20', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('901e6122-985d-4c84-8d8c-56560520f6ed', '6', 'StorageReport', '仓存报表', 'fa fa-area-chart', '/ReportManage/ReportDemo/Store', 'iframe', '1', '1', '0', null, null, '4', '0', '1', null, '2016-01-04 16:30:25', '0f36148c-719f-41e0-8c8c-16ffbc40d0e0', '佘赐雄', '2016-04-29 14:15:52', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('923f7d65-e307-45f7-8f96-73ecbf23b324', '5', '已办流程', '已办流程', 'fa fa-flag', '/FlowManage/FlowAferProcessing/Index', 'iframe', '1', '1', '0', null, null, '5', '0', '1', null, '2015-11-23 22:14:03', 'System', '超级管理员', '2016-03-25 11:39:51', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('92a535c9-4d4b-4500-968d-a142e671c09b', '6', 'ReportTemp', '报表管理', 'fa fa-cogs', '/ReportManage/Report/Index', 'iframe', '1', '0', '1', null, null, '1', '0', '1', '报表模板管理', '2016-01-13 17:21:17', 'System', '超级管理员', '2016-04-29 14:14:56', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('9db71a92-2ecb-496c-839f-7a82bc22905d', '6', 'MoneyReport', '对账报表', 'fa fa-pie-chart', '/ReportManage/ReportDemo/Reconciliation', 'iframe', '1', '1', '0', null, null, '5', '0', '1', '现金银行报表', '2016-01-04 16:31:03', '0f36148c-719f-41e0-8c8c-16ffbc40d0e0', '佘赐雄', '2016-04-29 14:16:09', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('9fc384f5-efb7-439e-9fe1-3e50807e6399', 'ad147f6d-613f-4d2d-8c84-b749d0754f3b', 'ClienExpenses', '支出管理', 'fa fa-credit-card-alt', '/CustomerManage/Expenses/Index', 'iframe', '1', '0', '0', null, null, '8', '0', '1', '支出管理', '2016-04-20 11:31:56', 'System', '超级管理员', '2016-04-29 14:21:50', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('a57993fa-5a94-44a8-a330-89196515c1d9', '458113c6-b0be-4d6f-acce-7524f4bc3e88', 'FormDesign', '表单设计', 'fa fa-puzzle-piece', '/FlowManage/FormDesign/Index', 'iframe', '1', '1', '0', null, null, '3', '0', '1', null, '2015-11-27 10:29:53', 'System', '超级管理员', '2015-12-01 09:41:58', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('a653a69e-5dcc-4ece-b457-fc0875271a88', '1', 'AppCreate', '移动开发', 'fa fa-file-code-o', '/AppManage/AppProjects/Index', 'iframe', '1', '0', '0', null, null, '9', '0', '1', '手机移动端开发', '2016-06-14 15:57:59', '24a055d6-5924-44c5-be52-3715cdd68011', '陈彬彬', '2016-06-15 16:27:42', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('a977d91e-77b7-4d60-a7ad-dfbc138f7c0a', 'b9f9df92-8ac5-46e2-90ac-68c5c2e034c3', '企业号设置', '企业号设置', 'fa fa-plug', '/WeChatManage/Token/Index', 'iframe', '1', '0', '0', null, null, '1', '0', '1', null, '2015-12-22 17:20:21', 'System', '超级管理员', '2015-12-29 19:05:02', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('aa844d70-7211-41d9-907a-f9a10f4ac801', 'b9f9df92-8ac5-46e2-90ac-68c5c2e034c3', '企业号应用', '企业号应用', 'fa fa-safari', '/WeChatManage/App/Index', 'iframe', '1', '0', '0', null, null, '4', '0', '1', null, '2015-12-22 17:21:25', 'System', '超级管理员', '2015-12-25 10:34:44', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('ad147f6d-613f-4d2d-8c84-b749d0754f3b', '0', 'CustomerManage', '客户关系', 'fa fa-briefcase', null, 'expand', '0', '1', '0', null, null, '6', '0', '1', '客户关系管理', '2016-03-11 10:53:05', '0f36148c-719f-41e0-8c8c-16ffbc40d0e0', '佘赐雄', '2016-04-21 16:00:07', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('aed02ee7-322f-47f0-8ad6-ab0a2172628f', '16d4e2d5-d154-455f-94f7-63bf80ab26aa', 'Client_Degree', '客户程度', 'fa fa-tag', '/SystemManage/DataItemList/Index?ItemCode=Client_Degree', 'iframe', '1', '0', '0', null, null, '4', '0', '1', null, '2016-03-11 16:49:46', '0f36148c-719f-41e0-8c8c-16ffbc40d0e0', '佘赐雄', '2016-04-06 10:23:36', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('affacee1-41a3-4c7b-8804-f1c1926babbd', '6', 'PurchaseReport', '采购报表', 'fa fa-bar-chart', '/ReportManage/ReportDemo/Purchase', 'iframe', '1', '1', '0', null, null, '2', '0', '1', null, '2016-01-04 16:29:07', '0f36148c-719f-41e0-8c8c-16ffbc40d0e0', '佘赐雄', '2016-04-29 14:15:19', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('b0261df5-7be0-4c8e-829c-15836e200af0', '1', 'SystemForm', '系统表单', 'fa fa-paw', '/AuthorizeManage/ModuleForm/Index', 'iframe', '1', '1', '0', null, null, '8', '0', '1', '系统功能自定义表单', '2016-04-11 11:19:06', 'System', '超级管理员', '2016-04-29 14:14:02', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('b352f049-4331-4b19-ac22-e379cb30bd55', 'ad147f6d-613f-4d2d-8c84-b749d0754f3b', 'ClientOrder', '客户订单', 'fa fa-modx', '/CustomerManage/Order/Index', 'iframe', '1', '1', '0', null, null, '5', '0', '1', '客户订单管理', '2016-03-11 12:01:30', '0f36148c-719f-41e0-8c8c-16ffbc40d0e0', '佘赐雄', '2016-04-29 14:20:16', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('b5cb98f6-fb41-4a0f-bc11-469ff117a411', '5', 'FlowManage', '流程管理', 'fa fa-cogs', null, 'expand', '0', '1', '0', null, null, '8', '0', '1', null, '2015-11-23 10:20:00', 'System', '超级管理员', '2016-03-19 13:33:50', '24a055d6-5924-44c5-be52-3715cdd68011', '陈彬彬');
INSERT INTO `sys_menu` VALUES ('b9f9df92-8ac5-46e2-90ac-68c5c2e034c3', '1', 'WeChatManage', '微信管理', 'fa fa-weixin', null, 'expand', '0', '0', '0', null, null, '5', '0', '1', null, '2015-12-22 16:42:12', 'System', '超级管理员', '2015-12-22 18:20:30', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('be9cbe61-265f-4ddd-851e-d5a1cef6011b', '16d4e2d5-d154-455f-94f7-63bf80ab26aa', 'Client_ChanceSource', '商机来源', 'fa fa-tag', '/SystemManage/DataItemList/Index?ItemCode=Client_ChanceSource', 'iframe', '1', '0', '0', null, null, '6', '0', '1', null, '2016-03-12 11:01:38', '0f36148c-719f-41e0-8c8c-16ffbc40d0e0', '佘赐雄', '2016-03-23 16:36:58', '0f36148c-719f-41e0-8c8c-16ffbc40d0e0', '佘赐雄');
INSERT INTO `sys_menu` VALUES ('c0544bfd-a557-45fc-a856-a678a1e88bfc', 'b5cb98f6-fb41-4a0f-bc11-469ff117a411', 'FlowDelegate', '流程指派', 'fa fa-random', '/FlowManage/FlowProcess/DesignationIndex', 'iframe', '1', '1', '0', null, null, '3', '0', '1', null, '2015-11-23 21:58:36', 'System', '超级管理员', '2016-04-26 12:06:40', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('c30310a7-d0a5-4bf6-8655-c3834a8cc73d', '16d4e2d5-d154-455f-94f7-63bf80ab26aa', 'Client_Sort', '客户类别', 'fa fa-tag', '/SystemManage/DataItemList/Index?ItemCode=Client_Sort', 'iframe', '1', '0', '0', null, null, '3', '0', '1', null, '2016-03-11 16:47:39', '0f36148c-719f-41e0-8c8c-16ffbc40d0e0', '佘赐雄', '2016-03-23 16:36:33', '0f36148c-719f-41e0-8c8c-16ffbc40d0e0', '佘赐雄');
INSERT INTO `sys_menu` VALUES ('c4d7ce1f-72de-4651-b495-6c466261e9af', '7cec0a0f-7204-4240-b009-312fa0c11cbf', 'DataBaseBackup', '数据库备份', 'fa fa-cloud-download', '/SystemManage/DataBaseBackup/Index', 'iframe', '1', '1', '0', null, null, '2', '0', '1', '数据备份、数据还原', '2015-11-24 09:55:52', 'System', '超级管理员', '2016-04-29 14:08:22', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('c6b80ed5-b0cb-4844-ba1a-725d2cb4f935', '4', 'EmailManage', '邮件中心', 'fa fa-send', '/PublicInfoManage/Email/Index', 'iframe', '1', '1', '0', null, null, '6', '0', '1', '邮件管理', '2015-11-27 09:48:38', 'System', '超级管理员', '2016-04-21 15:06:31', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('cfa631fe-e7f8-42b5-911f-7172f178a811', '1', 'CodeCreate', '快速开发', 'fa fa-code', '/GeneratorManage/Template/Index', 'iframe', '1', '0', '0', null, null, '8', '0', '1', '自动生成代码、自动生成功能', '2015-11-12 15:21:38', 'System', '超级管理员', '2016-04-12 10:52:30', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('ddce0dc1-3345-41b7-9716-22641fbbfaed', '6', 'rpt001', '销售日报表', 'fa fa-pie-chart', '/ReportManage/Report/ReportPreview?keyValue=a9762855-cd45-4815-a8e1-c8b818f79ad5', 'iframe', '1', '0', '0', null, null, '9', '0', '1', null, '2016-03-22 16:55:20', 'eab01522-f4fe-48ce-8db6-76fd7813cdf5', '刘晓雷', '2016-03-29 16:53:54', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('dec79ca7-3b54-432a-be1e-c96e7a2c7150', 'ad147f6d-613f-4d2d-8c84-b749d0754f3b', 'ClienCashBalanceReport', '现金报表', 'fa fa-bar-chart', '/CustomerManage/CashBalanceReport/Index', 'iframe', '1', '1', '0', null, null, '9', '0', '1', '收支报表', '2016-04-28 15:12:16', 'System', '超级管理员', '2016-05-27 16:29:15', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('e35d24ce-8a6a-46b9-8b3f-6dc864a8f342', '4', 'NewManage', '新闻中心', 'fa fa-feed', '/PublicInfoManage/News/Index', 'iframe', '1', '1', '0', null, null, '1', '0', '1', null, '2015-11-27 09:47:16', 'System', '超级管理员', '2016-04-29 14:17:09', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('eab4a37f-d976-42b7-9589-489ed0678151', '16d4e2d5-d154-455f-94f7-63bf80ab26aa', 'Client_ExpensesType', '支出种类', 'fa fa-tag', '/SystemManage/DataItemList/Index?ItemCode=Client_ExpensesType', 'iframe', '1', '0', '0', null, null, '10', '0', '1', null, '2016-04-20 15:06:10', 'System', '超级管理员', '2016-04-20 15:06:46', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('f21fa3a0-c523-4d02-99ca-fd8dd3ae3d59', '1', 'SystemLog', '系统日志', 'fa fa-warning', '/SystemManage/Log/Index', 'iframe', '1', '1', '0', null, null, '6', '0', '1', '登录日志、操作日志。异常日志', '2015-11-12 15:04:58', 'System', '超级管理员', '2016-04-29 14:12:14', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('f63a252b-975f-4832-a5be-1ce733bc8ece', '458113c6-b0be-4d6f-acce-7524f4bc3e88', 'FlowDesign', '流程设计', 'fa fa-share-alt', '/FlowManage/FlowDesign/Index', 'iframe', '1', '1', '0', null, null, '4', '0', '1', null, '2015-11-23 14:42:43', 'System', '超级管理员', '2015-11-27 10:41:09', 'System', '超级管理员');
INSERT INTO `sys_menu` VALUES ('ff1823b5-a966-4e6c-83de-807854f4f0fb', '6', 'SalesReport', '销售报表', 'fa fa-line-chart', '/ReportManage/ReportDemo/Sales', 'iframe', '1', '1', '0', null, null, '3', '0', '1', null, '2016-01-04 16:29:46', '0f36148c-719f-41e0-8c8c-16ffbc40d0e0', '佘赐雄', '2016-04-29 14:15:34', 'System', '超级管理员');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `roleCode` varchar(50) DEFAULT NULL COMMENT '角色编码',
  `roleName` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `description` varchar(50) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'g55w1qwh6', 'zhengfu', '政府角色');
INSERT INTO `sys_role` VALUES ('2', null, 'qiye', '企业角色');
INSERT INTO `sys_role` VALUES ('3', null, 'admin', '管理员角色');
INSERT INTO `sys_role` VALUES ('4', null, 'superadmin', '超管角色权限最大');

-- ----------------------------
-- Table structure for sys_role_auth
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_auth`;
CREATE TABLE `sys_role_auth` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `roleId` int(10) DEFAULT NULL COMMENT '角色ID',
  `authId` int(10) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`),
  KEY `roleId` (`roleId`),
  KEY `authId` (`authId`),
  CONSTRAINT `sys_role_auth_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sys_role_auth_ibfk_2` FOREIGN KEY (`authId`) REFERENCES `sys_auth` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_auth
-- ----------------------------
INSERT INTO `sys_role_auth` VALUES ('2', '3', '2');
INSERT INTO `sys_role_auth` VALUES ('3', '3', '8');
INSERT INTO `sys_role_auth` VALUES ('4', '3', '9');
INSERT INTO `sys_role_auth` VALUES ('5', '3', '10');
INSERT INTO `sys_role_auth` VALUES ('6', '3', '11');
INSERT INTO `sys_role_auth` VALUES ('7', '4', '8');
INSERT INTO `sys_role_auth` VALUES ('8', '4', '9');
INSERT INTO `sys_role_auth` VALUES ('9', '4', '10');
INSERT INTO `sys_role_auth` VALUES ('10', '4', '2');
INSERT INTO `sys_role_auth` VALUES ('11', '4', '11');
INSERT INTO `sys_role_auth` VALUES ('12', '4', '12');
INSERT INTO `sys_role_auth` VALUES ('13', '4', '13');
INSERT INTO `sys_role_auth` VALUES ('14', '4', '14');
INSERT INTO `sys_role_auth` VALUES ('15', '4', '15');
INSERT INTO `sys_role_auth` VALUES ('16', '4', '16');
INSERT INTO `sys_role_auth` VALUES ('17', '4', '17');
INSERT INTO `sys_role_auth` VALUES ('18', '4', '18');
INSERT INTO `sys_role_auth` VALUES ('19', '1', '14');
INSERT INTO `sys_role_auth` VALUES ('20', '2', '8');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userName` varchar(40) NOT NULL COMMENT '用户名',
  `loginName` varchar(40) NOT NULL COMMENT '登录名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `isActive` int(1) NOT NULL DEFAULT '0' COMMENT '0未激活，1激活状态',
  PRIMARY KEY (`id`),
  UNIQUE KEY `loginName` (`loginName`) USING BTREE,
  UNIQUE KEY `UQ_loginUser` (`loginName`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '管理员', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '1');
INSERT INTO `sys_user` VALUES ('2', '超级管理员', 'superadmin', 'e10adc3949ba59abbe56e057f20f883e', '1');
INSERT INTO `sys_user` VALUES ('5', '企业1', 'qiye1', 'e10adc3949ba59abbe56e057f20f883e', '1');
INSERT INTO `sys_user` VALUES ('6', '政府1', 'zhengfu1', 'e10adc3949ba59abbe56e057f20f883e', '1');

-- ----------------------------
-- Table structure for sys_user_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_dept`;
CREATE TABLE `sys_user_dept` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userId` int(10) DEFAULT NULL COMMENT '用户ID',
  `deptId` int(10) DEFAULT NULL COMMENT '部门ID',
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `deptId` (`deptId`),
  CONSTRAINT `sys_user_dept_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `sys_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sys_user_dept_ibfk_2` FOREIGN KEY (`deptId`) REFERENCES `sys_dept` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_dept
-- ----------------------------
INSERT INTO `sys_user_dept` VALUES ('1', '1', '4');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userId` int(10) DEFAULT NULL COMMENT '用户id',
  `roleId` int(10) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `sys_user_role_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `sys_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sys_user_role_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '3');
INSERT INTO `sys_user_role` VALUES ('2', '2', '4');
INSERT INTO `sys_user_role` VALUES ('3', '5', '1');
INSERT INTO `sys_user_role` VALUES ('4', '6', '2');
INSERT INTO `sys_user_role` VALUES ('5', '1', '1');
INSERT INTO `sys_user_role` VALUES ('6', '1', '2');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(40) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `age` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '老杨头', 'e10adc3949ba59abbe56e057f20f883e', '26');
INSERT INTO `t_user` VALUES ('2', '贺平', 'b4d687b8089de728319718ff7f514f3e', '30');
INSERT INTO `t_user` VALUES ('3', '张迪', '3a4b559f7a4a97f00346191c93cc158c', '26');
INSERT INTO `t_user` VALUES ('7', '老赵', '238c84dcef4be4ed4e20937591adbeaf', '35');
INSERT INTO `t_user` VALUES ('9', '八哥', '78d08f1b86bd916291876fed2d25ea76', '10000');
