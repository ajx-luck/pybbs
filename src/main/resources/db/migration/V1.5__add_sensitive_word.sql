# Dump of table sensitive_word
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sensitive_word`;
CREATE TABLE `sensitive_word` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`word` VARCHAR(255) NOT NULL COMMENT '敏感词',
	PRIMARY KEY (`id`)
);