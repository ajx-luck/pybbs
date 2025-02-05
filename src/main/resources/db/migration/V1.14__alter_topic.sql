ALTER TABLE `topic` ADD `check_status` INTEGER (11) NULL  DEFAULT NULL  AFTER `good`;
ALTER TABLE `topic` ADD `back_content` VARCHAR(255) NULL  DEFAULT NULL  AFTER `good`;
ALTER TABLE `topic` ADD `score` INTEGER(11) NULL  DEFAULT NULL  AFTER `good`;
ALTER TABLE `topic` ADD `paid` INTEGER(11) NULL  DEFAULT NULL  AFTER `good`;
ALTER TABLE `topic` ADD `aid` INTEGER(11) NULL  DEFAULT NULL  AFTER `good`;
ALTER TABLE `topic` ADD `cid` INTEGER(11) NULL  DEFAULT NULL  AFTER `good`;
ALTER TABLE `topic` ADD `address` VARCHAR(255)  NULL  DEFAULT NULL  AFTER `good`;
ALTER TABLE `topic` ADD `infocome` VARCHAR(255)  NULL  DEFAULT NULL  AFTER `good`;
ALTER TABLE `topic` ADD `missnumber` VARCHAR(255)  NULL  DEFAULT NULL  AFTER `good`;
ALTER TABLE `topic` ADD `missage` VARCHAR(255)  NULL  DEFAULT NULL  AFTER `good`;
ALTER TABLE `topic` ADD `missquality` VARCHAR(255)  NULL  DEFAULT NULL  AFTER `good`;
ALTER TABLE `topic` ADD `missappearance` VARCHAR(255)  NULL  DEFAULT NULL  AFTER `good`;
ALTER TABLE `topic` ADD `sextype` VARCHAR(255)  NULL  DEFAULT NULL  AFTER `good`;
ALTER TABLE `topic` ADD `price` VARCHAR(255)  NULL  DEFAULT NULL  AFTER `good`;
ALTER TABLE `topic` ADD `bustime` VARCHAR(255)  NULL  DEFAULT NULL  AFTER `good`;
ALTER TABLE `topic` ADD `env` VARCHAR(255)  NULL  DEFAULT NULL  AFTER `good`;
ALTER TABLE `topic` ADD `safety` VARCHAR(255)  NULL  DEFAULT NULL  AFTER `good`;
ALTER TABLE `topic` ADD `contact` VARCHAR(255)  NULL  DEFAULT NULL  AFTER `good`;
ALTER TABLE `topic` ADD `evaluate` VARCHAR(255)  NULL  DEFAULT NULL  AFTER `good`;
ALTER TABLE `topic` ADD `provice` VARCHAR(255)  NULL  DEFAULT NULL  AFTER `good`;
ALTER TABLE `topic` ADD `city` VARCHAR(255)  NULL  DEFAULT NULL  AFTER `good`;
ALTER TABLE `topic` ADD `category` VARCHAR(255)  NULL  DEFAULT NULL  AFTER `good`;
ALTER TABLE `comment` ADD `check_status` INTEGER (11) NULL  DEFAULT NULL  AFTER `content`;
ALTER TABLE `comment` ADD `back_content` VARCHAR(255) NULL  DEFAULT NULL  AFTER `content`;

INSERT INTO `topic` VALUES (1, '北仑一条街，探秘高', NULL, '2019-12-06 11:19:27', '2019-12-06 11:19:27', 1, 0, 0, 1, b'0', b'0', '其她小姐', '宁波', '浙江省', '查看需扣除20小姐币【现在开通VIP后，无需小姐币，即可免费查看全站所', '查看需扣除20小姐币【现在开通VIP后，无需小姐币，即可免费查看全站所有信息】', '不去最安全', '小屋', '10点之后', '200-1000', '一条龙', '60-70', '高', '20-30', '10+', '查看需扣除20小姐币【现在开通VIP后，无需小姐币，即可免费查看全站所有信息】', '查看需扣除20小姐币【现在开通VIP后，无需小姐币，即可免费查看全站所有信息】', NULL, NULL, NULL, NULL, NULL, NULL, NULL);


# Dump of table area
# ------------------------------------------------------------

DROP TABLE IF EXISTS `area`;

CREATE TABLE `area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aid` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `aid` (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


# Dump of table category
# ------------------------------------------------------------

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cid` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `category` (`id`, `cid`, `name`)
VALUES
	(1, 1, '洗浴中心');

INSERT INTO `category` (`id`, `cid`, `name`)
VALUES
	(2, 2, '酒店宾馆');

INSERT INTO `category` (`id`, `cid`, `name`)
VALUES
	(3, 3, '休闲发廊');

INSERT INTO `category` (`id`, `cid`, `name`)
VALUES
	(4, 4, '楼凤兼职');

INSERT INTO `category` (`id`, `cid`, `name`)
VALUES
	(5, 5, '其她小姐');

INSERT INTO `category` (`id`, `cid`, `name`)
VALUES
	(6, 6, '黑店曝光');

INSERT INTO `category` (`id`, `cid`, `name`)
VALUES
	(7, 7, 'QQ群');