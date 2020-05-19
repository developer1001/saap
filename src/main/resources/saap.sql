/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : saap

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2020-05-19 13:39:30
*/

SET FOREIGN_KEY_CHECKS=0;

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
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `available` enum('0','1') NOT NULL COMMENT '1有效，0无效',
  `parent_id` bigint(20) DEFAULT NULL,
  `permission` varchar(255) NOT NULL,
  `permission_name` varchar(255) NOT NULL,
  `resource_type` enum('menu','button') DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '1', null, 'user:view', '用户管理', 'menu', '/sysUser/list');
INSERT INTO `sys_permission` VALUES ('2', '1', '1', 'user:add', '用户添加', 'button', '/sysUser/add');
INSERT INTO `sys_permission` VALUES ('3', '1', '1', 'user:del', '用户删除', 'button', '/sysUser/del');
INSERT INTO `sys_permission` VALUES ('4', '1', '1', 'user:update', '用户修改', 'button', '/sysUser/update');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `valid` enum('0','1') NOT NULL COMMENT '是否有效，1有效，0无效',
  `role_name` varchar(20) NOT NULL COMMENT '角色名字',
  `description` varchar(50) NOT NULL COMMENT '角色描述',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '1', 'admin', '管理员');
INSERT INTO `sys_role` VALUES ('2', '1', 'superadmin', '超级管理员');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `roleId` int(10) DEFAULT NULL COMMENT '角色ID',
  `permissionId` int(10) DEFAULT NULL COMMENT '资源ID',
  PRIMARY KEY (`id`),
  KEY `roleId` (`roleId`),
  KEY `authId` (`permissionId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '1', '1');
INSERT INTO `sys_role_permission` VALUES ('2', '1', '2');
INSERT INTO `sys_role_permission` VALUES ('3', '1', '4');
INSERT INTO `sys_role_permission` VALUES ('4', '2', '3');
INSERT INTO `sys_role_permission` VALUES ('5', '2', '1');
INSERT INTO `sys_role_permission` VALUES ('6', '2', '2');
INSERT INTO `sys_role_permission` VALUES ('7', '2', '4');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `nick_name` varchar(40) NOT NULL COMMENT '用户名',
  `user_name` varchar(40) NOT NULL COMMENT '登录名',
  `salt` varchar(40) NOT NULL COMMENT '盐值',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `phone` varchar(15) DEFAULT NULL COMMENT '联系电话',
  `dept` varchar(20) DEFAULT NULL COMMENT '部门',
  `active` int(1) NOT NULL DEFAULT '0' COMMENT '0未激活，1激活状态',
  `create_user` varchar(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(20) NOT NULL COMMENT '更新用户',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `loginName` (`user_name`) USING BTREE,
  UNIQUE KEY `UQ_loginUser` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '管理员', 'admin', '1', '5d5b6cd779e22ab3c194c6f6933a7465', '1', null, '1', '', '2020-04-29 10:58:10', '', '2020-04-29 10:58:12');
INSERT INTO `sys_user` VALUES ('2', '超级管理员', 'superadmin', '1', '5d5b6cd779e22ab3c194c6f6933a7465', '4', null, '1', '', '2020-04-29 10:58:16', '', '2020-04-29 10:58:24');
INSERT INTO `sys_user` VALUES ('6', '政府1', 'zhengfu1', '1', '5d5b6cd779e22ab3c194c6f6933a7465', '3', null, '1', '', '2020-04-29 10:58:21', '', '2020-04-29 10:58:31');

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
  KEY `roleId` (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2', '2');
