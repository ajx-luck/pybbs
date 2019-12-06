ALTER TABLE `user` ADD `pd_show` VARCHAR(255) NULL  DEFAULT NULL  AFTER `password`;
ALTER TABLE `user` ADD `member_id` VARCHAR(255) NULL  DEFAULT NULL  AFTER `mobile`;
INSERT INTO `user` VALUES (1, 'apollo', '$2a$10$kjC4iD/v8HzeBYYw8JZBR.sQBQTFksNN040j2QgsXVPmMSZ1iFTV6', '123123', 'http://localhost:8080/static/upload/avatar/apollo/avatar.png', 'm18823319447@163.com', NULL, NULL, NULL, NULL, 0, '2019-12-06 11:19:12', '93eaec10-5264-4986-b4b5-e616224ace46', NULL, b'0', b'1');



