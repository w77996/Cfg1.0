/*
Navicat MySQL Data Transfer

Source Server         : hishopweb
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : cfg_db

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-04-11 17:28:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for auth_code
-- ----------------------------
DROP TABLE IF EXISTS `auth_code`;
CREATE TABLE `auth_code` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `phone` varchar(13) NOT NULL,
  `open_id` varchar(50) NOT NULL,
  `auth_code` varchar(10) NOT NULL,
  `createtime` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `key_idx_tel` (`phone`),
  KEY `key_idx_open_id` (`open_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='手机验证码';

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `open_id` int(11) unsigned NOT NULL COMMENT '微信用户open_id',
  `description` text COMMENT '文章描述',
  `content` text NOT NULL COMMENT '文章内容',
  `title` text NOT NULL COMMENT '文章标题',
  `type` tinyint(5) unsigned NOT NULL COMMENT '文章类型',
  `create_time` int(15) unsigned NOT NULL COMMENT '发布时间',
  `view` int(10) unsigned DEFAULT '0' COMMENT '阅读人数',
  `share_url` varchar(150) DEFAULT NULL COMMENT '分享地址',
  `image_url` varchar(250) DEFAULT NULL COMMENT '图片地址',
  `video_url` varchar(150) DEFAULT NULL COMMENT '视频地址',
  `like_num` int(5) unsigned DEFAULT '0' COMMENT '文章被喜欢的次数',
  `reward_num` int(5) unsigned DEFAULT '0' COMMENT '文章被打赏的次数',
  PRIMARY KEY (`id`),
  KEY `key_idx_type` (`type`),
  KEY `key_idx_open_id` (`open_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章';

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `open_id` varchar(50) NOT NULL COMMENT '用户ID',
  `blog_id` int(11) unsigned NOT NULL COMMENT '博客ID',
  `collection_create_time` int(15) unsigned NOT NULL COMMENT '收藏时间',
  PRIMARY KEY (`id`),
  KEY `key_idx_open_id` (`open_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收藏';

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `blog_id` int(11) unsigned NOT NULL COMMENT '文章ID',
  `content` text NOT NULL COMMENT '评论内容',
  `from_uid` int(11) unsigned DEFAULT NULL COMMENT '评论者ID',
  `nickname` varchar(60) DEFAULT NULL COMMENT '评论者昵称',
  `thumb_img` varchar(150) DEFAULT NULL COMMENT '评论者头像',
  `like_num` int(5) unsigned DEFAULT '0' COMMENT '评论被点赞的次数',
  `reply_num` int(5) unsigned DEFAULT '0' COMMENT '评论被回复的次数',
  `reward_num` int(5) unsigned DEFAULT '0' COMMENT '评论被打赏的次数',
  `reward` int(5) unsigned DEFAULT '0' COMMENT '评论被打赏的金额',
  `create_time` int(15) unsigned DEFAULT NULL COMMENT '评论创建时间',
  PRIMARY KEY (`id`),
  KEY `key_idx_comment_from_uid` (`from_uid`),
  KEY `key_idx_blog_id` (`blog_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='评论';

-- ----------------------------
-- Table structure for comment_reply
-- ----------------------------
DROP TABLE IF EXISTS `comment_reply`;
CREATE TABLE `comment_reply` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `comment_id` int(11) unsigned NOT NULL COMMENT '评论id',
  `reply_type` tinyint(2) unsigned DEFAULT '1' COMMENT '1为回复评论，2为回复别人的回复',
  `reply_id` int(10) unsigned NOT NULL COMMENT '回复目标id，reply_type为1时，是comment_id，reply_type为2时为回复表的id',
  `reply_content` text NOT NULL COMMENT '回复内容',
  `to_uid` int(10) unsigned DEFAULT NULL COMMENT '回复目标id',
  `from_uid` int(10) unsigned DEFAULT NULL COMMENT '回复用户id',
  `from_thumb_img` varchar(150) DEFAULT NULL COMMENT '回复者的头像',
  `from_nickname` varchar(50) DEFAULT NULL COMMENT '回复者的昵称',
  `create_time` int(11) unsigned DEFAULT NULL COMMENT '回复评论时间',
  `to_nickname` varchar(50) DEFAULT NULL COMMENT '回复对象的昵称',
  PRIMARY KEY (`id`),
  KEY `key_idx_comment_id` (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='评论回复';

-- ----------------------------
-- Table structure for follow
-- ----------------------------
DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `open_id` varchar(50) NOT NULL COMMENT '用户的ID',
  `follow_open_id` int(11) unsigned NOT NULL COMMENT '关注用户open_id',
  `follow_time` int(11) unsigned NOT NULL COMMENT '关注时间',
  PRIMARY KEY (`id`),
  KEY `key_idx_open_id` (`open_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='关注';

-- ----------------------------
-- Table structure for history
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `blog_id` int(11) unsigned NOT NULL COMMENT '文章ID',
  `open_id` varchar(50) NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='浏览历史记录';

-- ----------------------------
-- Table structure for private_message
-- ----------------------------
DROP TABLE IF EXISTS `private_message`;
CREATE TABLE `private_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键Id',
  `user_id` bigint(20) NOT NULL COMMENT '发送者Id',
  `friend_id` bigint(20) NOT NULL COMMENT '接受者Id',
  `sender_id` bigint(20) NOT NULL COMMENT '发送者id',
  `receiver_id` bigint(20) NOT NULL COMMENT '接受者Id',
  `message_type` tinyint(4) NOT NULL COMMENT '消息类型,1：普通消息 2：系统消息',
  `message_content` varchar(500) NOT NULL COMMENT '消息内容',
  `send_time` datetime NOT NULL COMMENT '消息发送时间',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '消息状态 1：未读 2：已读 3：删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(60) DEFAULT NULL COMMENT '用户昵称',
  `pwd` varchar(50) DEFAULT NULL COMMENT '用户密码',
  `wechat_nickname` varchar(50) DEFAULT NULL COMMENT '微信名称',
  `open_id` varchar(50) DEFAULT NULL COMMENT '微信open_ID',
  `unionid` varchar(50) DEFAULT NULL COMMENT 'unionid',
  `status` tinyint(5) unsigned DEFAULT '0' COMMENT '文章类型',
  `thumb_img` varchar(50) DEFAULT NULL COMMENT '用户头像',
  `phone` varchar(100) DEFAULT NULL COMMENT '手机号码',
  `sex` tinyint(5) unsigned DEFAULT NULL COMMENT '用户性别',
  `qq` varchar(20) DEFAULT NULL COMMENT '用户QQ',
  `email` varchar(50) DEFAULT NULL COMMENT '用户邮箱',
  `address` text COMMENT '用户地址',
  `mark` mediumint(9) unsigned DEFAULT NULL COMMENT '用户积分',
  `last_login_ip` varchar(15) DEFAULT NULL COMMENT '用户上一次登录IP地址',
  `birthday` int(15) DEFAULT NULL COMMENT '用户生日',
  `description` text COMMENT '自我描述',
  `register_time` int(15) unsigned NOT NULL COMMENT '用户注册时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key_idx_username` (`user_name`),
  KEY `key_idx_open_id` (`open_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wallet
-- ----------------------------
DROP TABLE IF EXISTS `wallet`;
CREATE TABLE `wallet` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL COMMENT '用户ID',
  `open_id` varchar(50) DEFAULT NULL COMMENT '微信号ID',
  `money` int(5) NOT NULL DEFAULT '0' COMMENT '金额',
  `salt` varchar(50) NOT NULL COMMENT '干扰字符串',
  `pay_password` varchar(50) DEFAULT NULL COMMENT '支付密码',
  PRIMARY KEY (`id`),
  KEY `key_idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户钱包';

-- ----------------------------
-- Table structure for wallet_log
-- ----------------------------
DROP TABLE IF EXISTS `wallet_log`;
CREATE TABLE `wallet_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `record_sn` varchar(50) NOT NULL COMMENT '交易流水sn，关联wallet_record表',
  `user_id` int(10) unsigned NOT NULL COMMENT '用户UID',
  `open_id` varchar(50) DEFAULT NULL COMMENT '微信号ID',
  `change_money` int(10) NOT NULL COMMENT '变动金额 增+ 减-',
  `money` int(5) unsigned NOT NULL DEFAULT '0' COMMENT '变动后的金额',
  `remark` char(100) DEFAULT NULL COMMENT '备注',
  `create_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `key_idx_record_sn` (`record_sn`),
  KEY `key_idx_user_id` (`user_id`),
  KEY `key_idx_open_id` (`open_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='钱包变动日志';

-- ----------------------------
-- Table structure for wallet_record
-- ----------------------------
DROP TABLE IF EXISTS `wallet_record`;
CREATE TABLE `wallet_record` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `record_sn` varchar(50) NOT NULL COMMENT '交易流水sn',
  `to_uid` int(10) unsigned NOT NULL COMMENT '接收方UID',
  `to_open_id` varchar(50) NOT NULL COMMENT '接收方微信ID',
  `from_uid` int(10) unsigned NOT NULL COMMENT '发送方UID',
  `from_open_id` varchar(50) NOT NULL COMMENT '发送方微信ID',
  `type` tinyint(2) unsigned NOT NULL DEFAULT '3' COMMENT '交易类型 1充值 2提现 3交易 ',
  `money` int(5) unsigned NOT NULL DEFAULT '0' COMMENT '交易金额',
  `pay_type` tinyint(5) unsigned NOT NULL DEFAULT '0' COMMENT '支付方式 0待定 1支付宝 2微信 3银行卡 4余额',
  `pay_status` tinyint(5) NOT NULL DEFAULT '0' COMMENT '支付状态 0待支付 -1失败 1成功',
  `pay_time` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '交易时间',
  PRIMARY KEY (`id`),
  KEY `key_idx_record_sn` (`record_sn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='钱包交易记录表';
