-- auto Generated on 2020-10-24
-- DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
	id BIGINT (20) UNIQUE NOT NULL AUTO_INCREMENT COMMENT 'id',
	user_name VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'userName',
	tele_phone VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'telePhone',
	login_name VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'loginName',
	nick_name VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'nickName',
	INDEX(tele_phone),
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'user';
