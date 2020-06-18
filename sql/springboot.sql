/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.153.128
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : 192.168.153.128:3306
 Source Schema         : springboot

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 18/06/2020 10:39:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `roleId` int(0) NULL DEFAULT NULL,
  `menuId` int(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色 菜单关系表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (1, 1);
INSERT INTO `role_menu` VALUES (1, 3);
INSERT INTO `role_menu` VALUES (1, 4);
INSERT INTO `role_menu` VALUES (1, 25);
INSERT INTO `role_menu` VALUES (1, 39);
INSERT INTO `role_menu` VALUES (1, 31);
INSERT INTO `role_menu` VALUES (1, 32);
INSERT INTO `role_menu` VALUES (1, 54);
INSERT INTO `role_menu` VALUES (1, 34);
INSERT INTO `role_menu` VALUES (1, 30);
INSERT INTO `role_menu` VALUES (1, 56);
INSERT INTO `role_menu` VALUES (1, 38);
INSERT INTO `role_menu` VALUES (1, 43);
INSERT INTO `role_menu` VALUES (1, 40);
INSERT INTO `role_menu` VALUES (1, 33);
INSERT INTO `role_menu` VALUES (1, 42);
INSERT INTO `role_menu` VALUES (1, 2);
INSERT INTO `role_menu` VALUES (1, 48);
INSERT INTO `role_menu` VALUES (1, 47);
INSERT INTO `role_menu` VALUES (1, 36);
INSERT INTO `role_menu` VALUES (1, 53);
INSERT INTO `role_menu` VALUES (1, 57);
INSERT INTO `role_menu` VALUES (1, 59);
INSERT INTO `role_menu` VALUES (1, 60);
INSERT INTO `role_menu` VALUES (1, 49);
INSERT INTO `role_menu` VALUES (1, 41);
INSERT INTO `role_menu` VALUES (1, 50);
INSERT INTO `role_menu` VALUES (1, 55);
INSERT INTO `role_menu` VALUES (1, 45);
INSERT INTO `role_menu` VALUES (1, 52);

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `roleId` int(0) NULL DEFAULT NULL,
  `permissionId` int(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色 权限关系表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES (1, 44);
INSERT INTO `role_permission` VALUES (1, 11);
INSERT INTO `role_permission` VALUES (1, 12);
INSERT INTO `role_permission` VALUES (1, 13);
INSERT INTO `role_permission` VALUES (1, 14);
INSERT INTO `role_permission` VALUES (1, 15);
INSERT INTO `role_permission` VALUES (1, 16);
INSERT INTO `role_permission` VALUES (1, 45);
INSERT INTO `role_permission` VALUES (1, 17);
INSERT INTO `role_permission` VALUES (1, 18);
INSERT INTO `role_permission` VALUES (1, 19);
INSERT INTO `role_permission` VALUES (1, 20);
INSERT INTO `role_permission` VALUES (1, 21);
INSERT INTO `role_permission` VALUES (1, 22);
INSERT INTO `role_permission` VALUES (1, 46);
INSERT INTO `role_permission` VALUES (1, 26);
INSERT INTO `role_permission` VALUES (1, 27);
INSERT INTO `role_permission` VALUES (1, 28);
INSERT INTO `role_permission` VALUES (1, 29);
INSERT INTO `role_permission` VALUES (1, 30);
INSERT INTO `role_permission` VALUES (1, 31);
INSERT INTO `role_permission` VALUES (1, 32);
INSERT INTO `role_permission` VALUES (1, 33);
INSERT INTO `role_permission` VALUES (1, 47);
INSERT INTO `role_permission` VALUES (1, 1);
INSERT INTO `role_permission` VALUES (1, 2);
INSERT INTO `role_permission` VALUES (1, 3);
INSERT INTO `role_permission` VALUES (1, 4);
INSERT INTO `role_permission` VALUES (1, 5);
INSERT INTO `role_permission` VALUES (1, 6);
INSERT INTO `role_permission` VALUES (1, 48);
INSERT INTO `role_permission` VALUES (1, 23);
INSERT INTO `role_permission` VALUES (1, 24);
INSERT INTO `role_permission` VALUES (1, 49);
INSERT INTO `role_permission` VALUES (1, 34);
INSERT INTO `role_permission` VALUES (1, 35);
INSERT INTO `role_permission` VALUES (1, 50);
INSERT INTO `role_permission` VALUES (1, 36);
INSERT INTO `role_permission` VALUES (1, 37);
INSERT INTO `role_permission` VALUES (1, 38);
INSERT INTO `role_permission` VALUES (1, 39);
INSERT INTO `role_permission` VALUES (1, 40);
INSERT INTO `role_permission` VALUES (1, 41);
INSERT INTO `role_permission` VALUES (1, 43);
INSERT INTO `role_permission` VALUES (1, 51);
INSERT INTO `role_permission` VALUES (1, 42);
INSERT INTO `role_permission` VALUES (1, 52);
INSERT INTO `role_permission` VALUES (1, 25);

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `deptId` int(0) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `deptName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '1 有效 0 无效',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`deptId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (1, '经理部', '1', '经理部：负责管理各项事务', '2019-12-13 11:24:37');
INSERT INTO `sys_dept` VALUES (2, '采购部', '1', '采购部：负责采购公司物品', '2019-12-13 11:24:41');
INSERT INTO `sys_dept` VALUES (3, '开发部', '1', '开发部：负责公司开发相关事宜', '2019-12-13 13:04:21');
INSERT INTO `sys_dept` VALUES (8, 'IT部', '1', 'IT部：负责技术公司技术支持', '2019-12-13 17:19:59');
INSERT INTO `sys_dept` VALUES (12, '运维部', '1', '运维部：负责什么呢', '2019-12-20 09:30:25');
INSERT INTO `sys_dept` VALUES (13, '心情管理部', '1', '心情管理部：只许开心，不许难过哦！', '2019-12-16 15:49:25');
INSERT INTO `sys_dept` VALUES (14, '人力资源部', '1', '人力资源部门', '2019-12-16 15:50:05');

-- ----------------------------
-- Table structure for sys_icon
-- ----------------------------
DROP TABLE IF EXISTS `sys_icon`;
CREATE TABLE `sys_icon`  (
  `iconId` int(0) NOT NULL AUTO_INCREMENT COMMENT '图标id',
  `iconClass` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标class',
  `iconName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标名称',
  `iconCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标code',
  `iconFontClass` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标字体class',
  PRIMARY KEY (`iconId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 172 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '图标表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_icon
-- ----------------------------
INSERT INTO `sys_icon` VALUES (4, '        layui-icon layui-icon-rate-half', '        半星', '        &amp;#xe6c9;', '       layui-icon-rate-half');
INSERT INTO `sys_icon` VALUES (5, '        layui-icon layui-icon-rate', '        星星-空心', '        &amp;#xe67b;', '       layui-icon-rate');
INSERT INTO `sys_icon` VALUES (6, '        layui-icon layui-icon-rate-solid', '        星星-实心', '        &amp;#xe67a;', '       layui-icon-rate-solid');
INSERT INTO `sys_icon` VALUES (7, '        layui-icon layui-icon-cellphone', '        手机', '        &amp;#xe678;', '       layui-icon-cellphone');
INSERT INTO `sys_icon` VALUES (8, '        layui-icon layui-icon-vercode', '        验证码', '        &amp;#xe679;', '       layui-icon-vercode');
INSERT INTO `sys_icon` VALUES (9, '        layui-icon layui-icon-login-wechat', '        微信', '        &amp;#xe677;', '       layui-icon-login-wechat');
INSERT INTO `sys_icon` VALUES (10, '        layui-icon layui-icon-login-qq', '        QQ', '        &amp;#xe676;', '       layui-icon-login-qq');
INSERT INTO `sys_icon` VALUES (11, '        layui-icon layui-icon-login-weibo', '        微博', '        &amp;#xe675;', '       layui-icon-login-weibo');
INSERT INTO `sys_icon` VALUES (12, '        layui-icon layui-icon-password', '        密码', '        &amp;#xe673;', '       layui-icon-password');
INSERT INTO `sys_icon` VALUES (13, '        layui-icon layui-icon-username', '        用户名', '        &amp;#xe66f;', '       layui-icon-username');
INSERT INTO `sys_icon` VALUES (14, '        layui-icon layui-icon-refresh-3', '        刷新-粗', '        &amp;#xe9aa;', '       layui-icon-refresh-3');
INSERT INTO `sys_icon` VALUES (15, '        layui-icon layui-icon-auz', '        授权', '        &amp;#xe672;', '       layui-icon-auz');
INSERT INTO `sys_icon` VALUES (16, '        layui-icon layui-icon-spread-left', '        左向右伸缩菜单', '        &amp;#xe66b;', '       layui-icon-spread-left');
INSERT INTO `sys_icon` VALUES (17, '        layui-icon layui-icon-shrink-right', '        右向左伸缩菜单', '        &amp;#xe668;', '       layui-icon-shrink-right');
INSERT INTO `sys_icon` VALUES (18, '        layui-icon layui-icon-snowflake', '        雪花', '        &amp;#xe6b1;', '       layui-icon-snowflake');
INSERT INTO `sys_icon` VALUES (19, '        layui-icon layui-icon-tips', '        提示说明', '        &amp;#xe702;', '       layui-icon-tips');
INSERT INTO `sys_icon` VALUES (20, '        layui-icon layui-icon-note', '        便签', '        &amp;#xe66e;', '       layui-icon-note');
INSERT INTO `sys_icon` VALUES (21, '        layui-icon layui-icon-home', '        主页', '        &amp;#xe68e;', '       layui-icon-home');
INSERT INTO `sys_icon` VALUES (22, '        layui-icon layui-icon-senior', '        高级', '        &amp;#xe674;', '       layui-icon-senior');
INSERT INTO `sys_icon` VALUES (23, '        layui-icon layui-icon-refresh', '        刷新', '        &amp;#xe669;', '       layui-icon-refresh');
INSERT INTO `sys_icon` VALUES (24, '        layui-icon layui-icon-refresh-1', '        刷新', '        &amp;#xe666;', '       layui-icon-refresh-1');
INSERT INTO `sys_icon` VALUES (25, '        layui-icon layui-icon-flag', '        旗帜', '        &amp;#xe66c;', '       layui-icon-flag');
INSERT INTO `sys_icon` VALUES (26, '        layui-icon layui-icon-theme', '        主题', '        &amp;#xe66a;', '       layui-icon-theme');
INSERT INTO `sys_icon` VALUES (27, '        layui-icon layui-icon-notice', '        消息-通知', '        &amp;#xe667;', '       layui-icon-notice');
INSERT INTO `sys_icon` VALUES (28, '        layui-icon layui-icon-website', '        网站', '        &amp;#xe7ae;', '       layui-icon-website');
INSERT INTO `sys_icon` VALUES (29, '        layui-icon layui-icon-console', '        控制台', '        &amp;#xe665;', '       layui-icon-console');
INSERT INTO `sys_icon` VALUES (30, '        layui-icon layui-icon-face-surprised', '        表情-惊讶', '        &amp;#xe664;', '       layui-icon-face-surprised');
INSERT INTO `sys_icon` VALUES (31, '        layui-icon layui-icon-set', '        设置-空心', '        &amp;#xe716;', '       layui-icon-set');
INSERT INTO `sys_icon` VALUES (32, '        layui-icon layui-icon-template-1', '        模板', '        &amp;#xe656;', '       layui-icon-template-1');
INSERT INTO `sys_icon` VALUES (33, '        layui-icon layui-icon-app', '        应用', '        &amp;#xe653;', '       layui-icon-app');
INSERT INTO `sys_icon` VALUES (34, '        layui-icon layui-icon-template', '        模板', '        &amp;#xe663;', '       layui-icon-template');
INSERT INTO `sys_icon` VALUES (35, '        layui-icon layui-icon-praise', '        赞', '        &amp;#xe6c6;', '       layui-icon-praise');
INSERT INTO `sys_icon` VALUES (36, '        layui-icon layui-icon-tread', '        踩', '        &amp;#xe6c5;', '       layui-icon-tread');
INSERT INTO `sys_icon` VALUES (37, '        layui-icon layui-icon-male', '        男', '        &amp;#xe662;', '       layui-icon-male');
INSERT INTO `sys_icon` VALUES (38, '        layui-icon layui-icon-female', '        女', '        &amp;#xe661;', '       layui-icon-female');
INSERT INTO `sys_icon` VALUES (39, '        layui-icon layui-icon-camera', '        相机-空心', '        &amp;#xe660;', '       layui-icon-camera');
INSERT INTO `sys_icon` VALUES (40, '        layui-icon layui-icon-camera-fill', '        相机-实心', '        &amp;#xe65d;', '       layui-icon-camera-fill');
INSERT INTO `sys_icon` VALUES (41, '        layui-icon layui-icon-more', '        菜单-水平', '        &amp;#xe65f;', '       layui-icon-more');
INSERT INTO `sys_icon` VALUES (42, '        layui-icon layui-icon-more-vertical', '        菜单-垂直', '        &amp;#xe671;', '       layui-icon-more-vertical');
INSERT INTO `sys_icon` VALUES (43, '        layui-icon layui-icon-rmb', '        金额-人民币', '        &amp;#xe65e;', '       layui-icon-rmb');
INSERT INTO `sys_icon` VALUES (44, '        layui-icon layui-icon-dollar', '        金额-美元', '        &amp;#xe659;', '       layui-icon-dollar');
INSERT INTO `sys_icon` VALUES (45, '        layui-icon layui-icon-diamond', '        钻石-等级', '        &amp;#xe735;', '       layui-icon-diamond');
INSERT INTO `sys_icon` VALUES (46, '        layui-icon layui-icon-fire', '        火', '        &amp;#xe756;', '       layui-icon-fire');
INSERT INTO `sys_icon` VALUES (47, '        layui-icon layui-icon-return', '        返回', '        &amp;#xe65c;', '       layui-icon-return');
INSERT INTO `sys_icon` VALUES (48, '        layui-icon layui-icon-location', '        位置-地图', '        &amp;#xe715;', '       layui-icon-location');
INSERT INTO `sys_icon` VALUES (49, '        layui-icon layui-icon-read', '        办公-阅读', '        &amp;#xe705;', '       layui-icon-read');
INSERT INTO `sys_icon` VALUES (50, '        layui-icon layui-icon-survey', '        调查', '        &amp;#xe6b2;', '       layui-icon-survey');
INSERT INTO `sys_icon` VALUES (51, '        layui-icon layui-icon-face-smile', '        表情-微笑', '        &amp;#xe6af;', '       layui-icon-face-smile');
INSERT INTO `sys_icon` VALUES (52, '        layui-icon layui-icon-face-cry', '        表情-哭泣', '        &amp;#xe69c;', '       layui-icon-face-cry');
INSERT INTO `sys_icon` VALUES (53, '        layui-icon layui-icon-cart-simple', '        购物车', '        &amp;#xe698;', '       layui-icon-cart-simple');
INSERT INTO `sys_icon` VALUES (54, '        layui-icon layui-icon-cart', '        购物车', '        &amp;#xe657;', '       layui-icon-cart');
INSERT INTO `sys_icon` VALUES (55, '        layui-icon layui-icon-next', '        下一页', '        &amp;#xe65b;', '       layui-icon-next');
INSERT INTO `sys_icon` VALUES (56, '        layui-icon layui-icon-prev', '        上一页', '        &amp;#xe65a;', '       layui-icon-prev');
INSERT INTO `sys_icon` VALUES (57, '        layui-icon layui-icon-upload-drag', '        上传-空心-拖拽', '        &amp;#xe681;', '       layui-icon-upload-drag');
INSERT INTO `sys_icon` VALUES (58, '        layui-icon layui-icon-upload', '        上传-实心', '        &amp;#xe67c;', '       layui-icon-upload');
INSERT INTO `sys_icon` VALUES (59, '        layui-icon layui-icon-download-circle', '        下载-圆圈', '        &amp;#xe601;', '       layui-icon-download-circle');
INSERT INTO `sys_icon` VALUES (60, '        layui-icon layui-icon-component', '        组件', '        &amp;#xe857;', '       layui-icon-component');
INSERT INTO `sys_icon` VALUES (61, '        layui-icon layui-icon-file-b', '        文件-粗', '        &amp;#xe655;', '       layui-icon-file-b');
INSERT INTO `sys_icon` VALUES (62, '        layui-icon layui-icon-user', '        用户', '        &amp;#xe770;', '       layui-icon-user');
INSERT INTO `sys_icon` VALUES (63, '        layui-icon layui-icon-find-fill', '        发现-实心', '        &amp;#xe670;', '       layui-icon-find-fill');
INSERT INTO `sys_icon` VALUES (64, '        layui-icon layui-icon-loading layui-icon layui-anim layui-anim-rotate layui-anim-loop', '        loading', '        &amp;#xe63d;', '       layui-icon-loading');
INSERT INTO `sys_icon` VALUES (65, '        layui-icon layui-icon-loading-1 layui-icon layui-anim layui-anim-rotate layui-anim-loop', '        loading', '        &amp;#xe63e;', '       layui-icon-loading-1');
INSERT INTO `sys_icon` VALUES (66, '        layui-icon layui-icon-add-1', '        添加', '        &amp;#xe654;', '       layui-icon-add-1');
INSERT INTO `sys_icon` VALUES (67, '        layui-icon layui-icon-play', '        播放', '        &amp;#xe652;', '       layui-icon-play');
INSERT INTO `sys_icon` VALUES (68, '        layui-icon layui-icon-pause', '        暂停', '        &amp;#xe651;', '       layui-icon-pause');
INSERT INTO `sys_icon` VALUES (69, '        layui-icon layui-icon-headset', '        音频-耳机', '        &amp;#xe6fc;', '       layui-icon-headset');
INSERT INTO `sys_icon` VALUES (70, '        layui-icon layui-icon-video', '        视频', '        &amp;#xe6ed;', '       layui-icon-video');
INSERT INTO `sys_icon` VALUES (71, '        layui-icon layui-icon-voice', '        语音-声音', '        &amp;#xe688;', '       layui-icon-voice');
INSERT INTO `sys_icon` VALUES (72, '        layui-icon layui-icon-speaker', '        消息-通知-喇叭', '        &amp;#xe645;', '       layui-icon-speaker');
INSERT INTO `sys_icon` VALUES (73, '        layui-icon layui-icon-fonts-del', '        删除线', '        &amp;#xe64f;', '       layui-icon-fonts-del');
INSERT INTO `sys_icon` VALUES (74, '        layui-icon layui-icon-fonts-code', '        代码', '        &amp;#xe64e;', '       layui-icon-fonts-code');
INSERT INTO `sys_icon` VALUES (75, '        layui-icon layui-icon-fonts-html', '        HTML', '        &amp;#xe64b;', '       layui-icon-fonts-html');
INSERT INTO `sys_icon` VALUES (76, '        layui-icon layui-icon-fonts-strong', '        字体加粗', '        &amp;#xe62b;', '       layui-icon-fonts-strong');
INSERT INTO `sys_icon` VALUES (77, '        layui-icon layui-icon-unlink', '        删除链接', '        &amp;#xe64d;', '       layui-icon-unlink');
INSERT INTO `sys_icon` VALUES (78, '        layui-icon layui-icon-picture', '        图片', '        &amp;#xe64a;', '       layui-icon-picture');
INSERT INTO `sys_icon` VALUES (79, '        layui-icon layui-icon-link', '        链接', '        &amp;#xe64c;', '       layui-icon-link');
INSERT INTO `sys_icon` VALUES (80, '        layui-icon layui-icon-face-smile-b', '        表情-笑-粗', '        &amp;#xe650;', '       layui-icon-face-smile-b');
INSERT INTO `sys_icon` VALUES (81, '        layui-icon layui-icon-align-left', '        左对齐', '        &amp;#xe649;', '       layui-icon-align-left');
INSERT INTO `sys_icon` VALUES (82, '        layui-icon layui-icon-align-right', '        右对齐', '        &amp;#xe648;', '       layui-icon-align-right');
INSERT INTO `sys_icon` VALUES (83, '        layui-icon layui-icon-align-center', '        居中对齐', '        &amp;#xe647;', '       layui-icon-align-center');
INSERT INTO `sys_icon` VALUES (84, '        layui-icon layui-icon-fonts-u', '        字体-下划线', '        &amp;#xe646;', '       layui-icon-fonts-u');
INSERT INTO `sys_icon` VALUES (85, '        layui-icon layui-icon-fonts-i', '        字体-斜体', '        &amp;#xe644;', '       layui-icon-fonts-i');
INSERT INTO `sys_icon` VALUES (86, '        layui-icon layui-icon-tabs', '        Tabs 选项卡', '        &amp;#xe62a;', '       layui-icon-tabs');
INSERT INTO `sys_icon` VALUES (87, '        layui-icon layui-icon-radio', '        单选框-选中', '        &amp;#xe643;', '       layui-icon-radio');
INSERT INTO `sys_icon` VALUES (88, '        layui-icon layui-icon-circle', '        单选框-候选', '        &amp;#xe63f;', '       layui-icon-circle');
INSERT INTO `sys_icon` VALUES (89, '        layui-icon layui-icon-edit', '        编辑', '        &amp;#xe642;', '       layui-icon-edit');
INSERT INTO `sys_icon` VALUES (90, '        layui-icon layui-icon-share', '        分享', '        &amp;#xe641;', '       layui-icon-share');
INSERT INTO `sys_icon` VALUES (91, '        layui-icon layui-icon-delete', '        删除', '        &amp;#xe640;', '       layui-icon-delete');
INSERT INTO `sys_icon` VALUES (92, '        layui-icon layui-icon-form', '        表单', '        &amp;#xe63c;', '       layui-icon-form');
INSERT INTO `sys_icon` VALUES (93, '        layui-icon layui-icon-cellphone-fine', '        手机-细体', '        &amp;#xe63b;', '       layui-icon-cellphone-fine');
INSERT INTO `sys_icon` VALUES (94, '        layui-icon layui-icon-dialogue', '        聊天 对话 沟通', '        &amp;#xe63a;', '       layui-icon-dialogue');
INSERT INTO `sys_icon` VALUES (95, '        layui-icon layui-icon-fonts-clear', '        文字格式化', '        &amp;#xe639;', '       layui-icon-fonts-clear');
INSERT INTO `sys_icon` VALUES (96, '        layui-icon layui-icon-layer', '        窗口', '        &amp;#xe638;', '       layui-icon-layer');
INSERT INTO `sys_icon` VALUES (97, '        layui-icon layui-icon-date', '        日期', '        &amp;#xe637;', '       layui-icon-date');
INSERT INTO `sys_icon` VALUES (98, '        layui-icon layui-icon-water', '        水 下雨', '        &amp;#xe636;', '       layui-icon-water');
INSERT INTO `sys_icon` VALUES (99, '        layui-icon layui-icon-code-circle', '        代码-圆圈', '        &amp;#xe635;', '       layui-icon-code-circle');
INSERT INTO `sys_icon` VALUES (100, '        layui-icon layui-icon-carousel', '        轮播组图', '        &amp;#xe634;', '       layui-icon-carousel');
INSERT INTO `sys_icon` VALUES (101, '        layui-icon layui-icon-prev-circle', '        翻页', '        &amp;#xe633;', '       layui-icon-prev-circle');
INSERT INTO `sys_icon` VALUES (102, '        layui-icon layui-icon-layouts', '        布局', '        &amp;#xe632;', '       layui-icon-layouts');
INSERT INTO `sys_icon` VALUES (103, '        layui-icon layui-icon-utils', '        工具', '        &amp;#xe631;', '       layui-icon-utils');
INSERT INTO `sys_icon` VALUES (104, '        layui-icon layui-icon-templeate-1', '        选择模板', '        &amp;#xe630;', '       layui-icon-templeate-1');
INSERT INTO `sys_icon` VALUES (105, '        layui-icon layui-icon-upload-circle', '        上传-圆圈', '        &amp;#xe62f;', '       layui-icon-upload-circle');
INSERT INTO `sys_icon` VALUES (106, '        layui-icon layui-icon-tree', '        树', '        &amp;#xe62e;', '       layui-icon-tree');
INSERT INTO `sys_icon` VALUES (107, '        layui-icon layui-icon-table', '        表格', '        &amp;#xe62d;', '       layui-icon-table');
INSERT INTO `sys_icon` VALUES (108, '        layui-icon layui-icon-chart', '        图表', '        &amp;#xe62c;', '       layui-icon-chart');
INSERT INTO `sys_icon` VALUES (109, '        layui-icon layui-icon-chart-screen', '        图标 报表 屏幕', '        &amp;#xe629;', '       layui-icon-chart-screen');
INSERT INTO `sys_icon` VALUES (110, '        layui-icon layui-icon-engine', '        引擎', '        &amp;#xe628;', '       layui-icon-engine');
INSERT INTO `sys_icon` VALUES (111, '        layui-icon layui-icon-triangle-d', '        下三角', '        &amp;#xe625;', '       layui-icon-triangle-d');
INSERT INTO `sys_icon` VALUES (112, '        layui-icon layui-icon-triangle-r', '        右三角', '        &amp;#xe623;', '       layui-icon-triangle-r');
INSERT INTO `sys_icon` VALUES (113, '        layui-icon layui-icon-file', '        文件', '        &amp;#xe621;', '       layui-icon-file');
INSERT INTO `sys_icon` VALUES (114, '        layui-icon layui-icon-set-sm', '        设置-小型', '        &amp;#xe620;', '       layui-icon-set-sm');
INSERT INTO `sys_icon` VALUES (115, '        layui-icon layui-icon-add-circle', '        添加-圆圈', '        &amp;#xe61f;', '       layui-icon-add-circle');
INSERT INTO `sys_icon` VALUES (116, '        layui-icon layui-icon-404', '        404', '        &amp;#xe61c;', '       layui-icon-404');
INSERT INTO `sys_icon` VALUES (117, '        layui-icon layui-icon-about', '        关于', '        &amp;#xe60b;', '       layui-icon-about');
INSERT INTO `sys_icon` VALUES (118, '        layui-icon layui-icon-up', '        箭头 向上', '        &amp;#xe619;', '       layui-icon-up');
INSERT INTO `sys_icon` VALUES (119, '        layui-icon layui-icon-down', '        箭头 向下', '        &amp;#xe61a;', '       layui-icon-down');
INSERT INTO `sys_icon` VALUES (120, '        layui-icon layui-icon-left', '        箭头 向左', '        &amp;#xe603;', '       layui-icon-left');
INSERT INTO `sys_icon` VALUES (121, '        layui-icon layui-icon-right', '        箭头 向右', '        &amp;#xe602;', '       layui-icon-right');
INSERT INTO `sys_icon` VALUES (122, '        layui-icon layui-icon-circle-dot', '        圆点', '        &amp;#xe617;', '       layui-icon-circle-dot');
INSERT INTO `sys_icon` VALUES (123, '        layui-icon layui-icon-search', '        搜索', '        &amp;#xe615;', '       layui-icon-search');
INSERT INTO `sys_icon` VALUES (124, '        layui-icon layui-icon-set-fill', '        设置-实心', '        &amp;#xe614;', '       layui-icon-set-fill');
INSERT INTO `sys_icon` VALUES (125, '        layui-icon layui-icon-group', '        群组', '        &amp;#xe613;', '       layui-icon-group');
INSERT INTO `sys_icon` VALUES (126, '        layui-icon layui-icon-friends', '        好友', '        &amp;#xe612;', '       layui-icon-friends');
INSERT INTO `sys_icon` VALUES (127, '        layui-icon layui-icon-reply-fill', '        回复 评论 实心', '        &amp;#xe611;', '       layui-icon-reply-fill');
INSERT INTO `sys_icon` VALUES (128, '        layui-icon layui-icon-menu-fill', '        菜单 隐身 实心', '        &amp;#xe60f;', '       layui-icon-menu-fill');
INSERT INTO `sys_icon` VALUES (129, '        layui-icon layui-icon-log', '        记录', '        &amp;#xe60e;', '       layui-icon-log');
INSERT INTO `sys_icon` VALUES (130, '        layui-icon layui-icon-picture-fine', '        图片-细体', '        &amp;#xe60d;', '       layui-icon-picture-fine');
INSERT INTO `sys_icon` VALUES (131, '        layui-icon layui-icon-face-smile-fine', '        表情-笑-细体', '        &amp;#xe60c;', '       layui-icon-face-smile-fine');
INSERT INTO `sys_icon` VALUES (132, '        layui-icon layui-icon-list', '        列表', '        &amp;#xe60a;', '       layui-icon-list');
INSERT INTO `sys_icon` VALUES (133, '        layui-icon layui-icon-release', '        发布 纸飞机', '        &amp;#xe609;', '       layui-icon-release');
INSERT INTO `sys_icon` VALUES (134, '        layui-icon layui-icon-ok', '        对 OK', '        &amp;#xe605;', '       layui-icon-ok');
INSERT INTO `sys_icon` VALUES (135, '        layui-icon layui-icon-help', '        帮助', '        &amp;#xe607;', '       layui-icon-help');
INSERT INTO `sys_icon` VALUES (136, '        layui-icon layui-icon-chat', '        客服', '        &amp;#xe606;', '       layui-icon-chat');
INSERT INTO `sys_icon` VALUES (137, '        layui-icon layui-icon-top', '        top 置顶', '        &amp;#xe604;', '       layui-icon-top');
INSERT INTO `sys_icon` VALUES (138, '        layui-icon layui-icon-star', '        收藏-空心', '        &amp;#xe600;', '       layui-icon-star');
INSERT INTO `sys_icon` VALUES (139, '        layui-icon layui-icon-star-fill', '        收藏-实心', '        &amp;#xe658;', '       layui-icon-star-fill');
INSERT INTO `sys_icon` VALUES (140, '        layui-icon layui-icon-close-fill', '        关闭-实心', '        &amp;#x1007;', '       layui-icon-close-fill');
INSERT INTO `sys_icon` VALUES (141, '        layui-icon layui-icon-close', '        关闭-空心', '        &amp;#x1006;', '       layui-icon-close');
INSERT INTO `sys_icon` VALUES (142, '        layui-icon layui-icon-ok-circle', '        正确', '        &amp;#x1005;', '       layui-icon-ok-circle');
INSERT INTO `sys_icon` VALUES (143, '        layui-icon layui-icon-add-circle-fine', '        添加-圆圈-细体', '        &amp;#xe608;', '       layui-icon-add-circle-fine');
INSERT INTO `sys_icon` VALUES (144, '    layui-icon layui-icon-heart-fill', '实心', '&amp#xe68f;', 'layui-icon-heart-fill');
INSERT INTO `sys_icon` VALUES (145, '        layui-icon layui-icon-email', '邮箱', '&amp#xe618;', 'layui-icon-email');
INSERT INTO `sys_icon` VALUES (146, 'layui-icon layui-icon-light', '亮度/晴', '&amp#xe748;', 'layui-icon-ligh');
INSERT INTO `sys_icon` VALUES (147, 'layui-icon layui-icon-time', '时间/历史', '&amp#xe68d;', 'layui-icon-time');
INSERT INTO `sys_icon` VALUES (148, 'layui-icon layui-icon-bluetooth', '蓝牙', '&amp#xe689;', 'layui-icon-bluetooth');
INSERT INTO `sys_icon` VALUES (149, 'layui-icon layui-icon-at', '@艾特', '&amp#xe687;', 'layui-icon-at');
INSERT INTO `sys_icon` VALUES (150, 'layui-icon layui-icon-mute', '静音', '&amp#xe685;', 'layui-icon-mute');
INSERT INTO `sys_icon` VALUES (151, 'layui-icon layui-icon-mike', '录音/麦克风', '&amp#xe6dc;', 'layui-icon-mike');
INSERT INTO `sys_icon` VALUES (152, 'layui-icon layui-icon-key', '密钥/钥匙', '&amp#xe683;', 'layui-icon-key');
INSERT INTO `sys_icon` VALUES (153, 'layui-icon layui-icon-gift', '礼物/活动', '&amp#xe627;', 'layui-icon-gift');
INSERT INTO `sys_icon` VALUES (154, 'layui-icon layui-icon-rss', 'RSS', '&amp#xe808;', 'layui-icon-rss');
INSERT INTO `sys_icon` VALUES (155, 'layui-icon layui-icon-wifi', 'WiFi', '&amp#xe7e0;', 'layui-icon-wifi');
INSERT INTO `sys_icon` VALUES (156, 'layui-icon layui-icon-logout', '退出/注销', '&amp#xe682;', 'layui-icon-logout');
INSERT INTO `sys_icon` VALUES (157, 'layui-icon layui-icon-android', 'Android 安卓', '&amp#xe684;', 'layui-icon-android');
INSERT INTO `sys_icon` VALUES (158, 'layui-icon layui-icon-ios', 'Apple IOS 苹果', '&amp#xe680;', 'layui-icon-ios');
INSERT INTO `sys_icon` VALUES (159, 'layui-icon layui-icon-windows', 'Windows', '&amp#xe67f;', 'layui-icon-windows');
INSERT INTO `sys_icon` VALUES (160, 'layui-icon layui-icon-transfer', '穿梭框', '&amp#xe691;', 'layui-icon-transfer');
INSERT INTO `sys_icon` VALUES (161, 'layui-icon layui-icon-service', '客服', '&amp#xe626;', 'layui-icon-service');
INSERT INTO `sys_icon` VALUES (162, 'layui-icon layui-icon-subtraction', '减', '&amp#xe67e;', 'layui-icon-subtraction');
INSERT INTO `sys_icon` VALUES (163, 'layui-icon layui-icon-addition', '加', '&amp#xe624;', 'layui-icon-addition');
INSERT INTO `sys_icon` VALUES (164, 'layui-icon layui-icon-slider', '滑块', '&amp#xe714;', 'layui-icon-slider');
INSERT INTO `sys_icon` VALUES (165, 'layui-icon layui-icon-print', '打印', '&amp#xe66d;', 'layui-icon-print');
INSERT INTO `sys_icon` VALUES (166, 'layui-icon layui-icon-export', '导出', '&amp#xe67d;', 'layui-icon-export');
INSERT INTO `sys_icon` VALUES (167, 'layui-icon layui-icon-cols', '列', '&amp#xe610;', 'layui-icon-cols');
INSERT INTO `sys_icon` VALUES (168, 'layui-icon layui-icon-screen-restore', '退出全屏', '&amp#xe758;', 'layui-icon-screen-restore');
INSERT INTO `sys_icon` VALUES (169, 'layui-icon layui-icon-screen-full', '全屏', '&amp#xe622;', 'layui-icon-screen-full');
INSERT INTO `sys_icon` VALUES (170, 'layui-icon layui-icon-reduce-circle', '减少-圆圈', '&amp#xe616', 'layui-icon-reduce-circle');
INSERT INTO `sys_icon` VALUES (171, 'layui-icon layui-icon-download-circle', '下载-圆圈', '&amp#xe601;', 'layui-icon-download-circle');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户信息',
  `operation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '执行操作',
  `time` int(0) NULL DEFAULT NULL COMMENT '执行时间',
  `method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '执行方法',
  `params` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数',
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ip地址',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `browser` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '浏览器',
  `userSystem` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作系统',
  `requestUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11253 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '日志表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menuId` int(0) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `menuName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路径',
  `permissionIdentifier` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parentId` int(0) NULL DEFAULT NULL COMMENT '父id',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `deleteFlag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '1 有效 0无效',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单描述',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`menuId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 59 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '系统管理', '', NULL, 0, 'layui-icon layui-icon-set', '1', 'Live a good life meet slowly.', '2019-12-13 15:04:18');
INSERT INTO `sys_menu` VALUES (2, '员工管理', '/user/userIndex', NULL, 42, 'layui-icon layui-icon-username', '1', 'your name，my heart.', '2019-12-13 15:04:18');
INSERT INTO `sys_menu` VALUES (3, '菜单管理', '/menu/menuIndex', NULL, 1, 'layui-icon layui-icon-note', '1', 'Things do not change，we change.', '2019-12-13 15:04:18');
INSERT INTO `sys_menu` VALUES (4, '部门管理', '/dept/deptIndex', NULL, 1, 'layui-icon layui-icon-flag', '1', 'Baicha Qinghuan has nothing else, I am waiting for the wind and waiting for you.', '2019-12-13 15:04:18');
INSERT INTO `sys_menu` VALUES (25, '角色管理', '/role/roleIndex', NULL, 1, 'layui-icon layui-icon-vercode', '1', 'Do not desire, and do not want', '2019-12-13 15:04:18');
INSERT INTO `sys_menu` VALUES (30, 'icon 管理', '/icon/iconIndex', NULL, 34, 'layui-icon layui-icon-snowflake', '1', 'Time will help you solve everything.', '2019-12-17 14:20:10');
INSERT INTO `sys_menu` VALUES (31, '搜索引擎', '', NULL, 0, 'layui-icon layui-icon-search', '1', 'Neither slow nor determined.', '2019-12-18 10:43:25');
INSERT INTO `sys_menu` VALUES (32, '百度搜索', 'https://www.baidu.com', NULL, 31, 'layui-icon layui-icon-tree', '1', 'It\'s not mine，but his.', '2019-12-18 10:44:53');
INSERT INTO `sys_menu` VALUES (33, '私とあなたの物語', '/timeLine/timeLineIndex', NULL, 40, 'layui-icon layui-icon-engine', '1', '時間、新しい愛、古い愛、愛', '2019-12-18 17:02:16');
INSERT INTO `sys_menu` VALUES (34, '图标管理', '', NULL, 0, 'layui-icon layui-icon-template', '1', 'New day，new start.', '2019-12-23 10:31:42');
INSERT INTO `sys_menu` VALUES (36, 'LayUI 文档', 'https://www.layui.com/doc/', NULL, 47, 'layui-icon layui-icon-app', '1', 'I\'m lost, completely', '2019-12-23 16:41:53');
INSERT INTO `sys_menu` VALUES (37, '龙喵网', 'http://ailongmiao.com/', NULL, 55, 'layui-icon layui-icon-cart-simple', '0', '龙喵网', '2019-12-24 09:22:35');
INSERT INTO `sys_menu` VALUES (38, '文档管理', '', NULL, 0, 'layui-icon layui-icon-fonts-code', '1', '完全に迷ってしまった', '2019-12-24 09:28:53');
INSERT INTO `sys_menu` VALUES (39, '权限管理', '/permission/permissionIndex', NULL, 1, 'layui-icon layui-icon-password', '1', '权限管理', '2019-12-26 10:40:42');
INSERT INTO `sys_menu` VALUES (40, 'ラブストーリー', '', NULL, 0, 'layui-icon layui-icon-camera', '1', 'ラブストーリー', '2019-12-26 13:14:51');
INSERT INTO `sys_menu` VALUES (41, '系统日志', '/system/logIndex', NULL, 49, 'layui-icon layui-icon-log', '1', '系统日志', '2019-12-27 09:45:45');
INSERT INTO `sys_menu` VALUES (42, '用户管理', '', NULL, 0, 'layui-icon layui-icon-user', '1', '用户管理', '2019-12-27 10:39:24');
INSERT INTO `sys_menu` VALUES (43, '系统文档', 'http://localhost:8080/swagger-ui.html', NULL, 38, 'layui-icon layui-icon-read', '1', '本系统文档', '2019-12-27 10:54:02');
INSERT INTO `sys_menu` VALUES (44, 'Spring Boot', 'http://springboot.fun/', NULL, 47, 'layui-icon layui-icon-website', '0', 'Spring Boot', '2020-01-08 11:21:48');
INSERT INTO `sys_menu` VALUES (45, '爪哇工具箱', 'https://www.cloudbed.vip/index.html', NULL, 55, 'layui-icon layui-icon-fonts-html', '1', '爪哇工具箱', '2020-01-08 11:22:44');
INSERT INTO `sys_menu` VALUES (46, 'Spring Cloud', 'http://www.springcloud.wiki/#blog', NULL, 47, 'layui-icon layui-icon-headset', '0', 'Spring Cloud', '2020-01-08 13:03:01');
INSERT INTO `sys_menu` VALUES (47, 'Java相关', '', NULL, 0, 'layui-icon layui-icon-release', '1', 'Java 相关', '2020-01-08 13:05:32');
INSERT INTO `sys_menu` VALUES (48, '在线用户', '/online/index', NULL, 42, 'layui-icon layui-icon-fonts-code', '1', '在线用户', '2020-01-13 13:04:38');
INSERT INTO `sys_menu` VALUES (49, '系统监控', '', NULL, 0, 'layui-icon layui-icon-video', '1', '系统监控', '2020-01-13 16:19:05');
INSERT INTO `sys_menu` VALUES (50, 'Druid 监控', 'http://localhost:8080/druid/index.html', NULL, 49, 'layui-icon layui-icon-chart', '1', 'druid 监控', '2020-01-13 16:19:43');
INSERT INTO `sys_menu` VALUES (52, 'tooool', 'http://tooool.org/', NULL, 55, 'layui-icon layui-icon-notice', '1', 'http://tooool.org/', '2020-01-14 16:01:46');
INSERT INTO `sys_menu` VALUES (53, 'Hutool 工具', 'https://hutool.cn/docs/#/', NULL, 47, 'layui-icon layui-icon-star', '1', 'https://hutool.cn/docs/#/', '2020-01-15 10:10:00');
INSERT INTO `sys_menu` VALUES (54, '高德地图', '/map/index', NULL, 31, 'layui-icon layui-icon-location', '1', 'mapIndex', '2020-01-15 11:17:35');
INSERT INTO `sys_menu` VALUES (55, '资源导航', '', NULL, 0, 'layui-icon layui-icon-voice', '1', '资源导航', '2020-01-16 17:23:22');
INSERT INTO `sys_menu` VALUES (56, '图片管理', '/image/index', NULL, 34, 'layui-icon layui-icon-female', '1', '图片管理', '2020-01-19 09:04:38');
INSERT INTO `sys_menu` VALUES (57, 'vuejs 文档', 'https://cn.vuejs.org/v2/guide/', NULL, 47, 'layui-icon layui-icon-template', '1', 'vuejs 文档', '2020-06-18 10:13:11');
INSERT INTO `sys_menu` VALUES (59, 'Spring Boot', 'http://springboot.fun/', NULL, 47, 'layui-icon layui-icon-website', '1', 'Spring Boot', '2020-06-18 10:38:15');
INSERT INTO `sys_menu` VALUES (60, 'Spring Cloud', 'http://www.springcloud.wiki/#blog', NULL, 47, 'layui-icon layui-icon-headset', '1', 'Spring Cloud', '2020-06-18 10:39:16');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `permissionId` int(0) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `permissionName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '权限名称',
  `deleteFlag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '1 有效 0 无效',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `permissionNameCn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名称（中文）',
  `parentId` int(0) NULL DEFAULT NULL COMMENT '上级id',
  PRIMARY KEY (`permissionId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (1, 'permission:view', '1', '权限查看', '2020-01-19 13:10:17', '权限查看', 47);
INSERT INTO `sys_permission` VALUES (2, 'permission:modify', '1', '权限修改', '2020-01-19 13:10:27', '权限修改', 47);
INSERT INTO `sys_permission` VALUES (3, 'permission:add', '1', '权限新增', '2020-01-19 13:10:36', '权限新增', 47);
INSERT INTO `sys_permission` VALUES (4, 'permission:delete', '1', '权限删除', '2020-01-19 13:10:46', '权限删除', 47);
INSERT INTO `sys_permission` VALUES (5, 'permission:disable', '1', '权限禁用', '2020-01-19 13:10:54', '权限禁用', 47);
INSERT INTO `sys_permission` VALUES (6, 'permission:enable', '1', '权限启用', '2020-01-19 13:11:02', '权限启用', 47);
INSERT INTO `sys_permission` VALUES (11, 'menu:add', '1', '菜单新增', '2020-01-19 13:11:40', '菜单新增', 44);
INSERT INTO `sys_permission` VALUES (12, 'menu:delete', '1', '菜单删除', '2020-01-19 13:11:56', '菜单删除', 44);
INSERT INTO `sys_permission` VALUES (13, 'menu:modify', '1', '菜单修改', '2020-01-19 13:12:09', '菜单修改', 44);
INSERT INTO `sys_permission` VALUES (14, 'menu:disable', '1', '菜单禁用', '2020-01-19 13:12:22', '菜单禁用', 44);
INSERT INTO `sys_permission` VALUES (15, 'menu:view', '1', '菜单查看', '2020-01-19 13:12:33', '菜单查看', 44);
INSERT INTO `sys_permission` VALUES (16, 'menu:enable', '1', '菜单启用', '2020-01-19 13:12:44', '菜单启用', 44);
INSERT INTO `sys_permission` VALUES (17, 'dept:add', '1', '部门新增', '2020-01-19 13:12:56', '部门新增', 45);
INSERT INTO `sys_permission` VALUES (18, 'dept:delete', '1', '部门删除', '2020-01-19 13:13:08', '部门删除', 45);
INSERT INTO `sys_permission` VALUES (19, 'dept:modify', '1', '部门修改', '2020-01-19 13:13:27', '部门修改', 45);
INSERT INTO `sys_permission` VALUES (20, 'dept:disable', '1', '部门禁用', '2020-01-19 13:13:41', '部门禁用', 45);
INSERT INTO `sys_permission` VALUES (21, 'dept:view', '1', '部门查看', '2020-01-19 13:14:20', '部门查看', 45);
INSERT INTO `sys_permission` VALUES (22, 'dept:enable', '1', '部门启用', '2020-01-19 13:14:32', '部门启用', 45);
INSERT INTO `sys_permission` VALUES (23, 'icon:add', '1', '图标新增', '2020-01-19 13:14:43', '图标新增', 48);
INSERT INTO `sys_permission` VALUES (24, 'icon:view', '1', '图标查看', '2020-01-19 13:14:55', '图标查看', 48);
INSERT INTO `sys_permission` VALUES (25, 'log:view', '1', '系统日志查看', '2020-01-19 13:15:18', '系统日志查看', 52);
INSERT INTO `sys_permission` VALUES (26, 'role:add', '1', '角色新增', '2020-01-19 13:15:34', '角色新增', 46);
INSERT INTO `sys_permission` VALUES (27, 'role:delete', '1', '角色删除', '2020-01-19 13:15:49', '角色删除', 46);
INSERT INTO `sys_permission` VALUES (28, 'role:modify', '1', '角色修改', '2020-01-19 13:16:03', '角色修改', 46);
INSERT INTO `sys_permission` VALUES (29, 'role:disable', '1', '角色禁用', '2020-01-19 13:16:13', '角色禁用', 46);
INSERT INTO `sys_permission` VALUES (30, 'role:view', '1', '角色查看', '2020-01-19 13:16:31', '角色查看', 46);
INSERT INTO `sys_permission` VALUES (31, 'role:enable', '1', '角色启用', '2020-01-19 13:16:43', '角色启用', 46);
INSERT INTO `sys_permission` VALUES (32, 'role:permission', '1', '角色对应权限', '2020-01-19 13:17:00', '角色对应权限', 46);
INSERT INTO `sys_permission` VALUES (33, 'role:menu', '1', '角色对应菜单', '2020-01-19 13:17:14', '角色对应菜单', 46);
INSERT INTO `sys_permission` VALUES (34, 'timeLine:add', '1', '时间线新增', '2020-01-19 13:17:28', '时间线新增', 49);
INSERT INTO `sys_permission` VALUES (35, 'timeLine:view', '1', ' 时间线查看', '2020-01-19 13:17:41', ' 时间线查看', 49);
INSERT INTO `sys_permission` VALUES (36, 'user:add', '1', '用户新增', '2020-01-19 13:18:00', '用户新增', 50);
INSERT INTO `sys_permission` VALUES (37, 'user:delete', '1', '用户删除', '2020-01-19 13:18:17', '用户删除', 50);
INSERT INTO `sys_permission` VALUES (38, 'user:modify', '1', '用户修改', '2020-01-19 13:18:00', '用户修改', 50);
INSERT INTO `sys_permission` VALUES (39, 'user:disable', '1', '用户禁用', '2020-01-19 13:18:41', '用户禁用', 50);
INSERT INTO `sys_permission` VALUES (40, 'user:view', '1', '用户查看', '2020-01-19 13:18:53', '用户查看', 50);
INSERT INTO `sys_permission` VALUES (41, 'user:enable', '1', '用户启用', '2020-01-19 13:19:04', '用户启用', 50);
INSERT INTO `sys_permission` VALUES (42, 'user:kickOut', '1', '踢出在线用户', '2020-01-19 13:19:21', '踢出在线用户', 51);
INSERT INTO `sys_permission` VALUES (43, 'user:resetPassword', '1', '重置密码', '2020-01-19 13:39:29', '重置密码', 50);
INSERT INTO `sys_permission` VALUES (44, 'menuIndex', '1', '菜单管理页面', '2020-01-19 13:59:32', '菜单管理', 0);
INSERT INTO `sys_permission` VALUES (45, 'deptIndex', '1', '部门管理页面', '2020-01-19 13:59:39', '部门管理', 0);
INSERT INTO `sys_permission` VALUES (46, 'roleIndex', '1', '角色管理页面', '2020-01-19 13:59:46', '角色管理', 0);
INSERT INTO `sys_permission` VALUES (47, 'permissionIndex', '1', '权限管理页面', '2020-01-19 13:59:58', '权限管理', 0);
INSERT INTO `sys_permission` VALUES (48, 'iconIndex', '1', 'icon管理页面', '2020-01-19 14:00:06', 'icon管理', 0);
INSERT INTO `sys_permission` VALUES (49, 'timeLineIndex', '1', '时间线管理页面', '2020-01-19 14:00:11', '时间线管理', 0);
INSERT INTO `sys_permission` VALUES (50, 'userIndex', '1', '用户管理页面', '2020-01-19 14:01:21', '用户管理', 0);
INSERT INTO `sys_permission` VALUES (51, 'onlineIndex', '1', '在线用户管理', '2020-01-19 14:00:16', '在线用户管理', 0);
INSERT INTO `sys_permission` VALUES (52, 'logIndex', '1', '系统日志', '2020-01-19 14:01:04', '系统日志', 0);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `roleId` int(0) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `roleName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称英文',
  `deleteFlag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '1 有效 0无效',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `roleNameCn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称中文',
  PRIMARY KEY (`roleId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'ADMIN', '1', '管理员', '2019-12-06 14:56:20', '管理员');
INSERT INTO `sys_role` VALUES (2, 'EMP', '1', '普通员工', '2019-12-06 14:56:23', '员工');
INSERT INTO `sys_role` VALUES (5, 'FAN', '1', '财务', '2019-12-09 10:55:16', '财务');
INSERT INTO `sys_role` VALUES (6, 'HR', '1', '人力资源', '2019-12-09 13:11:56', '人力资源');
INSERT INTO `sys_role` VALUES (7, 'DEV', '1', '开发部门', '2019-12-09 13:37:18', '开发');
INSERT INTO `sys_role` VALUES (8, 'TEST', '1', '测试部门', '2019-12-09 13:37:59', '测试');
INSERT INTO `sys_role` VALUES (9, 'OM', '1', '运维部门', '2019-12-09 13:38:30', '运维');
INSERT INTO `sys_role` VALUES (11, 'CEO', '1', 'CEO', '2019-12-11 10:15:59', 'ceo');
INSERT INTO `sys_role` VALUES (12, 'COSPLAY', '1', '角色扮演', '2019-12-16 15:48:47', 'cosplay');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `chinaName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '中文名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否有效 1：有效  0：锁定',
  `deptId` int(0) NULL DEFAULT NULL COMMENT '部门id',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户描述',
  `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '0 男 1 女',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'zhangsan', '张三', 'c4ca4238a0b923820dcc509a6f75849b', '2020-01-08 16:41:25', '1', 2, '123@qq.com', '我是张三', '0');
INSERT INTO `sys_user` VALUES (2, 'lisi', '李四', 'c4ca4238a0b923820dcc509a6f75849b', '2019-11-15 15:56:51', '1', 3, '23@qq.com', '我是李四', '0');
INSERT INTO `sys_user` VALUES (3, 'wangwu', '王五', 'c4ca4238a0b923820dcc509a6f75849b', '2019-12-03 13:46:52', '1', 3, '1@qq.com', '我是王五', '1');
INSERT INTO `sys_user` VALUES (4, 'zhaoliu', '赵六', 'c4ca4238a0b923820dcc509a6f75849b', '2019-12-04 16:42:52', '1', 2, '2@qq.com', '赵六', '1');
INSERT INTO `sys_user` VALUES (5, 'sunqi', '孙奇', 'c4ca4238a0b923820dcc509a6f75849b', '2019-12-04 16:43:34', '1', 1, '3@qq.com', '孙奇', '1');
INSERT INTO `sys_user` VALUES (6, 'wangba', '王八', 'c4ca4238a0b923820dcc509a6f75849b', '2019-12-04 16:44:36', '1', 3, '0.@qq.com', '王八', '0');
INSERT INTO `sys_user` VALUES (7, 'jiujiu', '九久', 'c4ca4238a0b923820dcc509a6f75849b', '2019-12-04 16:45:32', '1', 14, '1@qq.com', '九久', '1');
INSERT INTO `sys_user` VALUES (8, 'shishi', '史诗', 'c4ca4238a0b923820dcc509a6f75849b', '2019-12-04 16:49:32', '1', 2, '3@qq.com', '史诗', '1');
INSERT INTO `sys_user` VALUES (9, 'xy', '小怡', 'c4ca4238a0b923820dcc509a6f75849b', '2019-12-04 16:50:19', '1', 1, '2952106446@qq.com', '山无棱，天地合，乃敢与君绝！', '1');
INSERT INTO `sys_user` VALUES (10, 'hy', '黄银', 'c4ca4238a0b923820dcc509a6f75849b', '2019-12-04 16:51:35', '1', 8, '3@qq.com', '黄银', '1');
INSERT INTO `sys_user` VALUES (11, 'mz', '名字111', 'c4ca4238a0b923820dcc509a6f75849b', '2019-12-04 17:03:58', '1', 13, '3@qq.cm111', '名字1111', '1');
INSERT INTO `sys_user` VALUES (14, 'jybd', '甲乙丙丁', 'c4ca4238a0b923820dcc509a6f75849b', '2019-12-11 16:19:25', '1', 14, '111@', '甲乙丙丁', '0');
INSERT INTO `sys_user` VALUES (15, 'mtdykxo', '每天都要开心哦！', 'c4ca4238a0b923820dcc509a6f75849b', '2019-12-18 13:36:42', '1', 1, '11', '每天都要开心哦！', '1');
INSERT INTO `sys_user` VALUES (16, 'smg', '什么鬼', 'c4ca4238a0b923820dcc509a6f75849b', '2019-12-25 17:25:29', '1', 13, '1', '', '0');
INSERT INTO `sys_user` VALUES (17, 'Rick', 'rick', 'c4ca4238a0b923820dcc509a6f75849b', '2020-06-05 14:30:21', '1', 1, '23232@qq.com', 'rick', '1');

-- ----------------------------
-- Table structure for time_line
-- ----------------------------
DROP TABLE IF EXISTS `time_line`;
CREATE TABLE `time_line`  (
  `timeLineId` int(0) NOT NULL AUTO_INCREMENT COMMENT '时间线id',
  `timeLineTitle` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间线标题',
  `timeLineContent` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间线内容（中日文）',
  `contentJapan` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间线内容（日文）',
  PRIMARY KEY (`timeLineId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '时间线 表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of time_line
-- ----------------------------
INSERT INTO `time_line` VALUES (1, '過去  2019-12-15 09:21:48', '<p>十年之前，我不认识你，你不属于我<br>10年前、私はあなたを知りませんでした、あなたは私に属していませんでした<br><br>尽管这样我们还是相识、相知、相爱<br>それにもかかわらず、私たちはまだお互いを知り、お互いを愛し、お互いを愛しています<br><br>最后却还是躲不过注定分开的命运<br>最後に、それはまだ運命に運命づけられました</p>', '<p>10年前、私はあなたを知りませんでした、あなたは私に属していませんでした<br>それにもかかわらず、私たちはまだお互いを知り、お互いを愛しています<br>最後に、それはまだ運命に運命づけられました</p>');
INSERT INTO `time_line` VALUES (2, 'あなたを知っている（2016年7月頃）  2019-12-16 16:00:25', '<p>那是我们第一次通过游戏认识，那年我刚上大学<br>私たちがゲームを通して出会ったのはこれが初めてでした、私はちょうどその年に大学に行きました<br><br>我记得那个时候我们经常一起玩，但是你却很少语音<br>当時一緒にプレイしたことを覚えていますが、あなたはめったに話しませんでした</p>', '<p>私たちがゲームを通して出会ったのはこれが初めてでした、私はちょうどその年に大学に行きました<br>当時一緒にプレイしたことを覚えていますが、あなたはめったに話しませんでした</p>');
INSERT INTO `time_line` VALUES (4, 'あなたのように（10月下旬）  2019-12-17 10:12:15', '<p>我们整天一起玩，一起聊天，三个月后我心动了，但我并没有对你说<br>私たちは一緒に遊んで、一日中一緒にチャットします。3ヶ月後、私の心は動きましたが、私はあなたに伝えませんでした<br><br>不是因为我不想，而是我不敢<br>したくないからではないが、あえてしない<br><br>就这样我们彼此陪伴了许多日夜，那个时候心里住着一个人，她就是我的世界，真的感觉得到了全世界<br>このように、私たちは何日も夜もずっと一緒にいましたが、当時は心の中に人がいました。彼女は私の世界であり、世界全体が</p>', '<p>私たちは一緒に遊んで、一日中一緒にチャットします。3ヶ月後、私の心は動きましたが、私はあなたに伝えませんでした<br>したくないからではないが、あえてしない<br>このように、私たちは何日も夜もずっと一緒にいましたが、当時は心の中に人がいました。彼女は私の世界であり、世界全体が</p>');
INSERT INTO `time_line` VALUES (5, 'あなたも私を愛している(2018年12月）  2019-12-18 14:10:38', '<p>在这段时间我们删了很多次，最长的一次是3个月，但是最后还是加回来了<br>この間に何度も削除しましたが、最長のものは3か月でしたが、最後に追加されました<br><br>12月，你说你喜欢我，终于我们还是在一起了，难道这就是命运的安排吗？你知道我会多开心吗?<br>12月に、あなたはあなたが私のことを好きだと言いました、そして最終的に私たちはまだ一緒です、これは運命の取り決めですか？私の幸せを知っていますか?</p>', '<p>この間に何度も削除しましたが、最長のものは3か月でしたが、最後に追加されました<br>12月に、あなたはあなたが私のことを好きだと言いました、そして最終的に私たちはまだ一緒です、これは運命の取り決めですか？私の幸せを知っていますか?</p>');
INSERT INTO `time_line` VALUES (6, '別れる（2019年7月20日  星期六）  2019-12-19 17:20:13', '<p>结局总是那么的不尽人意,没想到最后，担心的还是发生了<br>エンディングはいつもとても不満足だ、私は最終的には心配がまだ起こったことを期待していなかった<br><br>我们还是分开了，一切的一切都早已注定，任何人都躲不过命运的安排，或许命运早就说过，这不过是一个玩笑罢了<br>私たちはまだ離れており、すべてがすでに運命づけられており、誰も運命の取り決めから逃れることはできません<br><br>8月8日，你来上海玩，前一天我说我想见你，你说你不想见我<br>8月8日、あなたは上海に遊びに来ました。私があなたに会いたいと言った前日、あなたはあなたが私に会いたくないと言いました<br><br>7号晚上你再一次删了联系方式，而这一次再也没有加回来，8号那天我打了很多电话，你没有接，我在上面等了一整天却什么也没有等到<br> 7日の夕方、連絡先情報を再度削除しましたが、今回は再度追加しませんでしたが、8日には多くの電話をかけました、あなたは答えなかった、私は一日中それを待っていたが、何も<br><br>我知道你走远了，再也没有后来的我们了，曾经我得到了全世界，而那一刻我失去了整个世界<br>私はあなたが遠くに行ってしまったことを知っています、後で私たちはもういません、私が全世界を手に入れたら</p>', '<p>エンディングはいつもとても不満足だ、私は最終的には心配がまだ起こったことを期待していなかった<br>私たちはまだ離れており、すべてがすでに運命づけられており、誰も運命の取り決めから逃れることはできません<br>8月8日、あなたは上海に遊びに来ました。私があなたに会いたいと言った前日、あなたはあなたが私に会いたくないと言いました<br>7日の夕方、連絡先情報を再度削除しましたが、今回は再度追加しませんでしたが、8日には多くの電話をかけました、あなたは答えなかった、私は一日中それを待っていたが、何も<br>私はあなたが遠くに行ってしまったことを知っています、後で私たちはもういません、私が全世界を手に入れたら</p>');
INSERT INTO `time_line` VALUES (7, 'いま  2019-12-20 11:20:06 星期五', '<p>时间渐渐已然过去了整整5个月了，而我还是无法忘记你，无法忘记我们曾经拥有的过去<br>5か月が経ちましたが、私はまだあなたを忘れることはできません、私たちは過去を忘れることはできません<br><br>时间、新欢、旧爱、思恋<br>時間、新しい愛、古い愛、愛<br><br>你早已选择了新欢，而我选择了时间，剩下的是对你深深的思恋<br>あなたはすでに新環を選びました、そして私は時間を選びました、そして残りはあなたへの深い愛です<br><br>最后无论它曾经走了多远，抑或如何支撑？至少我曾倾注全心，无怨无悔  <br>それがどこまで行ったとしても、それをどのようにサポートするにしても、最終的には？少なくとも私は心を尽くし、後悔はしていない<br><br>谢谢你曾来过，我会一直记得你的 lqy<br>ここにいてくれてありがとう、私はいつもあなたを覚えています lqy<br><br>请记得曾经有那么一个人，真的爱过你<br>あなたを本当に愛していた人がいたことを覚えておいてください</p>', '<p>5か月が経ちましたが、私はまだあなたを忘れることはできません、私たちは過去を忘れることはできません<br>時間、新しい愛、古い愛、愛<br>あなたはすでに新環を選びました、そして私は時間を選びました、そして残りはあなたへの深い愛です<br>それがどこまで行ったとしても、それをどのようにサポートするにしても、最終的には？少なくとも私は心を尽くし、後悔はしていない<br>ここにいてくれてありがとう、私はいつもあなたを覚えています lqy<br>あなたを本当に愛していた人がいたことを覚えておいてください</p>');
INSERT INTO `time_line` VALUES (8, '今すぐ    2019-12-23 15:16:48', '<p>因为一个人，爱上一座城，因为一座城，住着喜欢的人<br>一人の人のために、都市に恋をする、都市のために、それを好きな人がいる<br><br>今年是等不到下雪了，可能是老天觉得一个看雪太寂寞吧<br>今年は雪が降るのを待つことはできません。多分、神は雪を見るには寂しすぎると思う<br><br>且听风吟，静待花开<br>風に耳を傾け、花が咲くのを待つ<br><br>曾以为走不出去的日子，现在都回不去了<br>今は外出できないと思っていた日々、今は戻れない</p>', '<p>一人の人のために、都市に恋をする、都市のために、それを好きな人がいる<br>今年は雪が降るのを待つことはできません。多分、神は雪を見るには寂しすぎると思う<br>風に耳を傾け、花が咲くのを待つ<br>今は外出できないと思っていた日々、今は戻れない</p>');
INSERT INTO `time_line` VALUES (11, '未来は大丈夫ですか   2020-01-01 09:48:10', '<p>未来会好吗？会的吧、肯定会的吧，一切都会过去的吧<br>未来は大丈夫ですか はい、確かに、すべてが合格します<br><br>加油吧！一切都会慢慢过去的<br>さあ！すべてがゆっくりと通過します</p>', '<p>未来は大丈夫ですか？はい、確かに、すべてが合格します<br>さあ！すべてがゆっくりと通過します</p>');
INSERT INTO `time_line` VALUES (12, '半年  2020-01-20 11:29:41  星期一', '<p>时间过得真快啊，一晃就已经半年了，我知道你已经不再爱我了，可是我还是忍不住的去留意你的消息<br>時間が経ち、半年になります、あなたはもう私を愛していないことを知っています、しかし、私はまだあなたのニュースに注意を払うことはできません<br><br>我是不是不应该再坚持了，是时候放手了，我想我还是做不到吧，也就只能交给时间了<br>私がもう主張しないならば、それは手放す時です、まだできないと思います。時間にしか与えられません<br><br>说真的，昨天你能陪我打游戏我已经很开心了 xy<br>真面目に、昨日あなたが私と一緒にゲームをすることができてとても幸せでした xy<br><br>过几天就过年了，或许我也应该有一个新的开始了吧<br>数日で中国の新年、多分私は新しい始まりを持っている必要があります<br><br>也希望你能天天开心，一直幸福下去 <br>私はあなたが毎日幸せであり、常に幸せであることを願っています<br><br><br><br></p>', '<p>時間が経ち、半年になります、あなたはもう私を愛していないことを知っています、しかし、私はまだあなたのニュースに注意を払うことはできません<br>私がもう主張しないならば、それは手放す時です、まだできないと思います。時間にしか与えられません<br>真面目に、昨日あなたが私と一緒にゲームをすることができてとても幸せでした xy<br>数日で中国の新年、多分私は新しい始まりを持っている必要があります<br>私はあなたが毎日幸せであり、常に幸せであることを願っています<br></p>');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `userId` int(0) NULL DEFAULT NULL,
  `roleId` int(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户 角色关系表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (2, 2);
INSERT INTO `user_role` VALUES (6, 2);
INSERT INTO `user_role` VALUES (13, 7);
INSERT INTO `user_role` VALUES (7, 6);
INSERT INTO `user_role` VALUES (9, 1);
INSERT INTO `user_role` VALUES (10, 9);
INSERT INTO `user_role` VALUES (1, 5);
INSERT INTO `user_role` VALUES (17, 1);

SET FOREIGN_KEY_CHECKS = 1;
