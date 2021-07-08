/*
 Navicat Premium Data Transfer

 Source Server         : zsj
 Source Server Type    : MySQL
 Source Server Version : 50650
 Source Host           : localhost:3306
 Source Schema         : jwsystem

 Target Server Type    : MySQL
 Target Server Version : 50650
 File Encoding         : 65001

 Date: 07/07/2021 11:01:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_course
-- ----------------------------
DROP TABLE IF EXISTS `sys_course`;
CREATE TABLE `sys_course`  (
  `courseId` int(20) NOT NULL AUTO_INCREMENT,
  `curriculum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `teacher` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `time` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `credit` int(20) NOT NULL,
  PRIMARY KEY (`courseId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_croatian_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_course
-- ----------------------------
INSERT INTO `sys_course` VALUES (2, 'Python', '诗云', '1', 2);

-- ----------------------------
-- Table structure for sys_curriculum
-- ----------------------------
DROP TABLE IF EXISTS `sys_curriculum`;
CREATE TABLE `sys_curriculum`  (
  `curriculumId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NULL DEFAULT NULL,
  `courseId` int(11) NULL DEFAULT NULL,
  `curriculum` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `teacher` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `time` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `credit` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`curriculumId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_croatian_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_curriculum
-- ----------------------------
INSERT INTO `sys_curriculum` VALUES (4, 1, 2, 'Python', '诗云', '1', 2);

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `permissionId` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `pId` int(11) NULL DEFAULT NULL COMMENT '权限ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'url',
  `percode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限码',
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`permissionId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (1, -1, '根节点', 'root', '无', '无', '1');
INSERT INTO `sys_permission` VALUES (2, 1, '系统管理', '菜单', '无', '无', '1');
INSERT INTO `sys_permission` VALUES (3, 2, '用户管理', '权限', 'userController.do?method=list', 'userList', '1');
INSERT INTO `sys_permission` VALUES (4, 2, '角色管理', '权限', 'roleController.do?method=list', 'roleList', '1');
INSERT INTO `sys_permission` VALUES (5, 2, '权限管理', '权限', 'permissionController.do?method=list', 'permissionList', '1');
INSERT INTO `sys_permission` VALUES (6, 1, '邮件系统 ', '菜单', '无', '无', '1');
INSERT INTO `sys_permission` VALUES (7, 6, '写邮件', '权限', '无', '无', '1');
INSERT INTO `sys_permission` VALUES (8, 6, '收件箱', '权限', '无', '无', '1');
INSERT INTO `sys_permission` VALUES (9, 6, '发件箱', '权限', '无', '无', '1');
INSERT INTO `sys_permission` VALUES (10, 6, '草稿箱', '权限', '无', '无', '1');
INSERT INTO `sys_permission` VALUES (11, 6, '垃圾箱', '权限', '无', '无', '1');
INSERT INTO `sys_permission` VALUES (14, 1, '选课系统', '菜单', '无', '无', '1');
INSERT INTO `sys_permission` VALUES (15, 14, '学生网上选课', '权限', 'selectionController.do?method=list', 'selectionList', '1');
INSERT INTO `sys_permission` VALUES (16, 14, '选课数据调整', '权限', 'courseController.do?method=list', 'courseList', '1');
INSERT INTO `sys_permission` VALUES (18, 14, '选课结果统计', '权限', 'countController.do?method=list', 'countList', '1');
INSERT INTO `sys_permission` VALUES (20, 14, '生成课表', '权限', 'tableController.do?method=list', 'tableList', '1');
INSERT INTO `sys_permission` VALUES (21, 14, '选课结果查询', '权限', 'selectController.do?method=list', 'selectList', '1');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `roleId` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色Id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`roleId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '管理员', '1');
INSERT INTO `sys_role` VALUES (2, '教师', '1');
INSERT INTO `sys_role` VALUES (3, '学生', '1');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `rolePermissionId` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色权限ID',
  `roleId` int(11) NULL DEFAULT NULL COMMENT '角色Id',
  `permissionId` int(11) NULL DEFAULT NULL COMMENT '权限ID',
  PRIMARY KEY (`rolePermissionId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 246 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES (125, 2, 1);
INSERT INTO `sys_role_permission` VALUES (126, 2, 2);
INSERT INTO `sys_role_permission` VALUES (127, 2, 3);
INSERT INTO `sys_role_permission` VALUES (128, 2, 4);
INSERT INTO `sys_role_permission` VALUES (129, 2, 5);
INSERT INTO `sys_role_permission` VALUES (137, 3, 1);
INSERT INTO `sys_role_permission` VALUES (138, 3, 6);
INSERT INTO `sys_role_permission` VALUES (139, 3, 7);
INSERT INTO `sys_role_permission` VALUES (140, 3, 8);
INSERT INTO `sys_role_permission` VALUES (141, 3, 9);
INSERT INTO `sys_role_permission` VALUES (142, 3, 10);
INSERT INTO `sys_role_permission` VALUES (143, 3, 11);
INSERT INTO `sys_role_permission` VALUES (144, 3, 14);
INSERT INTO `sys_role_permission` VALUES (145, 3, 15);
INSERT INTO `sys_role_permission` VALUES (146, 3, 16);
INSERT INTO `sys_role_permission` VALUES (229, 1, 1);
INSERT INTO `sys_role_permission` VALUES (230, 1, 2);
INSERT INTO `sys_role_permission` VALUES (231, 1, 3);
INSERT INTO `sys_role_permission` VALUES (232, 1, 4);
INSERT INTO `sys_role_permission` VALUES (233, 1, 5);
INSERT INTO `sys_role_permission` VALUES (234, 1, 6);
INSERT INTO `sys_role_permission` VALUES (235, 1, 7);
INSERT INTO `sys_role_permission` VALUES (236, 1, 8);
INSERT INTO `sys_role_permission` VALUES (237, 1, 9);
INSERT INTO `sys_role_permission` VALUES (238, 1, 10);
INSERT INTO `sys_role_permission` VALUES (239, 1, 11);
INSERT INTO `sys_role_permission` VALUES (240, 1, 14);
INSERT INTO `sys_role_permission` VALUES (241, 1, 15);
INSERT INTO `sys_role_permission` VALUES (242, 1, 16);
INSERT INTO `sys_role_permission` VALUES (243, 1, 18);
INSERT INTO `sys_role_permission` VALUES (244, 1, 20);
INSERT INTO `sys_role_permission` VALUES (245, 1, 21);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `age` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年龄',
  `adress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `QQ` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'QQ',
  `wechat` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '潘大', '男', '36', '湖北', '911', '5436546', '8987', 'ewe@dd.com', 'admin', '111');
INSERT INTO `sys_user` VALUES (2, '胡班春', '女', '12', '贵州', '110', '78798', '5445', '423@dd.com', 'hbc', '111');
INSERT INTO `sys_user` VALUES (3, '龚大美', '女', '18', '贵州', '119', '879799', '2132123', 'gdm@dd.com', 'gdm', '111');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `userRroleId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户角色ID',
  `userId` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  `roleId` int(11) NULL DEFAULT NULL COMMENT '角色Id',
  PRIMARY KEY (`userRroleId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (20, 1, 1);
INSERT INTO `sys_user_role` VALUES (21, 2, 2);
INSERT INTO `sys_user_role` VALUES (22, 3, 3);

SET FOREIGN_KEY_CHECKS = 1;
