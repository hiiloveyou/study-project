-- auto Generated on 2020-10-24
-- DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
	create_name VARCHAR (50) COMMENT 'createName',
	create_id BIGINT (15) COMMENT 'createId',
	create_time DATETIME COMMENT 'createTime',
	update_name VARCHAR (50) COMMENT 'updateName',
	update_id BIGINT (15) COMMENT 'updateId',
	update_time TIMESTAMP COMMENT 'updateTime',
	id BIGINT (15) UNIQUE NOT NULL AUTO_INCREMENT COMMENT 'id',
	user_name VARCHAR (50) COMMENT 'userName',
	telephone VARCHAR (50) COMMENT 'telephone',
	login_name VARCHAR (50) COMMENT 'loginName',
	INDEX(user_name),
	INDEX(telephone),
	INDEX(login_name),
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'user';
