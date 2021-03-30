-- auto Generated on 2020-10-30
-- DROP TABLE IF EXISTS study_user;
CREATE TABLE study_user
(
    id            BIGINT(15) UNIQUE NOT NULL AUTO_INCREMENT COMMENT 'id',
    create_name   VARCHAR(50) COMMENT 'createName',
    create_id     BIGINT(15) COMMENT 'createId',
    create_time   DATETIME COMMENT 'createTime',
    update_name   VARCHAR(50) COMMENT 'updateName',
    update_id     BIGINT(15) COMMENT 'updateId',
    update_time   TIMESTAMP COMMENT 'updateTime',
    lock_version  INT(11) COMMENT 'lockVersion',
    user_name     VARCHAR(50) UNIQUE COMMENT '用户名',
    telephone     VARCHAR(50) UNIQUE COMMENT '用户手机号',
    login_name    VARCHAR(50) UNIQUE COMMENT '用户登陆名',
    email_address VARCHAR(50) UNIQUE COMMENT '邮箱地址',
    user_type     VARCHAR(50) COMMENT '用户类型',
    `password`    VARCHAR(50) COMMENT '密码',
    salt          VARCHAR(50) UNIQUE COMMENT '用户盐值',
    `status`      TINYINT(1) COMMENT '用户当前状态',
    description   VARCHAR(50) COMMENT '用户描述',
    INDEX (user_name),
    INDEX (telephone),
    INDEX (login_name),
    INDEX (email_address),
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT 'study_user';

-- auto Generated on 2020-10-30
-- DROP TABLE IF EXISTS study_organization;
CREATE TABLE study_organization
(
    id                BIGINT(15)         NOT NULL AUTO_INCREMENT COMMENT 'id',
    create_name       VARCHAR(50) COMMENT 'createName',
    create_id         BIGINT(15) COMMENT 'createId',
    create_time       DATETIME COMMENT 'createTime',
    update_name       VARCHAR(50) COMMENT 'updateName',
    update_id         BIGINT(15) COMMENT 'updateId',
    update_time       TIMESTAMP COMMENT 'updateTime',
    lock_version      INT(11) COMMENT 'lockVersion',
    organization_name VARCHAR(50) UNIQUE NOT NULL COMMENT 'organizationName',
    organization_code VARCHAR(50) UNIQUE NOT NULL COMMENT 'organizationCode',
    `status`          VARCHAR(50) COMMENT 'status',
    INDEX (organization_name),
    INDEX (organization_code),
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT 'study_organization';


-- auto Generated on 2020-10-30
-- DROP TABLE IF EXISTS study_organization_role_relation;
CREATE TABLE study_organization_role_relation
(
    id              BIGINT(15) NOT NULL AUTO_INCREMENT COMMENT 'id',
    create_name     VARCHAR(50) COMMENT 'createName',
    create_id       BIGINT(15) COMMENT 'createId',
    create_time     DATETIME COMMENT 'createTime',
    update_name     VARCHAR(50) COMMENT 'updateName',
    update_id       BIGINT(15) COMMENT 'updateId',
    update_time     TIMESTAMP COMMENT 'updateTime',
    lock_version    INT(11) COMMENT 'lockVersion',
    organization_id BIGINT(15) NOT NULL COMMENT 'organizationId',
    role_id         BIGINT(15) NOT NULL COMMENT 'roleId',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT 'study_organization_role_relation';

-- auto Generated on 2020-11-14
DROP TABLE IF EXISTS study_permission;
CREATE TABLE study_permission
(
    id              BIGINT(15) UNIQUE  NOT NULL AUTO_INCREMENT COMMENT 'id',
    create_name     VARCHAR(50) COMMENT 'createName',
    create_id       BIGINT(15) COMMENT 'createId',
    create_time     DATETIME COMMENT 'createTime',
    update_name     VARCHAR(50) COMMENT 'updateName',
    update_id       BIGINT(15) COMMENT 'updateId',
    update_time     TIMESTAMP COMMENT 'updateTime',
    lock_version    INT(11) COMMENT 'lockVersion',
    url             VARCHAR(50) COMMENT 'url',
    permission_type VARCHAR(50)        NOT NULL COMMENT '权限类型：包括文件夹菜单，按钮等',
    permission_name VARCHAR(50) UNIQUE NOT NULL COMMENT 'permissionName',
    permission_code VARCHAR(50) UNIQUE NOT NULL COMMENT 'permissionCode',
    `path`          VARCHAR(50)        NOT NULL COMMENT 'path',
    parent_id       BIGINT(15)         NOT NULL COMMENT 'parentId',
    sort_index      INT(11)            NOT NULL COMMENT 'sortIndex',
    description     VARCHAR(50) COMMENT 'description',
    INDEX (url),
    INDEX (permission_type),
    INDEX (permission_name),
    INDEX (permission_code),
    INDEX (path),
    INDEX (parent_id),
    INDEX (sort_index),
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT 'permission';

-- auto Generated on 2020-10-30
-- DROP TABLE IF EXISTS study_role;
CREATE TABLE study_role
(
    id           BIGINT(15)         NOT NULL AUTO_INCREMENT COMMENT 'id',
    create_name  VARCHAR(50) COMMENT 'createName',
    create_id    BIGINT(15) COMMENT 'createId',
    create_time  DATETIME COMMENT 'createTime',
    update_name  VARCHAR(50) COMMENT 'updateName',
    update_id    BIGINT(15) COMMENT 'updateId',
    update_time  TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'updateTime',
    lock_version INT(11) COMMENT 'lockVersion',
    role_name    VARCHAR(50) UNIQUE NOT NULL COMMENT 'roleName',
    `status`     VARCHAR(50) COMMENT 'status',
    INDEX (role_name),
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT 'study_role';


-- auto Generated on 2020-10-30
-- DROP TABLE IF EXISTS study_user_group;
CREATE TABLE study_user_group
(
    id              BIGINT(15)         NOT NULL AUTO_INCREMENT COMMENT 'id',
    create_name     VARCHAR(50) COMMENT 'createName',
    create_id       BIGINT(15) COMMENT 'createId',
    create_time     DATETIME COMMENT 'createTime',
    update_name     VARCHAR(50) COMMENT 'updateName',
    update_id       BIGINT(15) COMMENT 'updateId',
    update_time     TIMESTAMP COMMENT 'updateTime',
    lock_version    INT(11) COMMENT 'lockVersion',
    user_group_name VARCHAR(50) UNIQUE NOT NULL COMMENT 'userGroupName',
    user_group_code VARCHAR(50) UNIQUE NOT NULL COMMENT 'userGroupCode',
    description     VARCHAR(50) COMMENT 'description',
    principal       VARCHAR(50) COMMENT 'principal',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT 'study_user_group';


-- auto Generated on 2020-10-30
-- DROP TABLE IF EXISTS study_role_permission_relation;
CREATE TABLE study_role_permission_relation
(
    id            BIGINT(15) NOT NULL AUTO_INCREMENT COMMENT 'id',
    create_name   VARCHAR(50) COMMENT 'createName',
    create_id     BIGINT(15) COMMENT 'createId',
    create_time   DATETIME COMMENT 'createTime',
    update_name   VARCHAR(50) COMMENT 'updateName',
    update_id     BIGINT(15) COMMENT 'updateId',
    update_time   TIMESTAMP COMMENT 'updateTime',
    lock_version  INT(11) COMMENT 'lockVersion',
    role_id       BIGINT(15) NOT NULL COMMENT 'roleId',
    permission_id BIGINT(15) NOT NULL COMMENT 'permissionId',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT 'study_role_permission_relation';


-- auto Generated on 2020-10-30
-- DROP TABLE IF EXISTS study_user_group_relation;
CREATE TABLE study_user_group_relation
(
    id            BIGINT(15) NOT NULL AUTO_INCREMENT COMMENT 'id',
    create_name   VARCHAR(50) COMMENT 'createName',
    create_id     BIGINT(15) COMMENT 'createId',
    create_time   DATETIME COMMENT 'createTime',
    update_name   VARCHAR(50) COMMENT 'updateName',
    update_id     BIGINT(15) COMMENT 'updateId',
    update_time   TIMESTAMP COMMENT 'updateTime',
    lock_version  INT(11) COMMENT 'lockVersion',
    user_id       BIGINT(15) NOT NULL COMMENT 'userId',
    user_group_id BIGINT(15) NOT NULL COMMENT 'userGroupId',
    INDEX (user_id),
    INDEX (user_group_id),
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT 'study_user_group_relation';


-- auto Generated on 2020-10-30
-- DROP TABLE IF EXISTS study__organization_relation;
CREATE TABLE study_user_organization_relation
(
    id              BIGINT(15) NOT NULL AUTO_INCREMENT COMMENT 'id',
    create_name     VARCHAR(50)         DEFAULT '' COMMENT 'createName',
    create_id       BIGINT(15)          DEFAULT -1 COMMENT 'createId',
    create_time     DATETIME            DEFAULT '1000-01-01 00:00:00' COMMENT 'createTime',
    update_name     VARCHAR(50)         DEFAULT '' COMMENT 'updateName',
    update_id       BIGINT(15)          DEFAULT -1 COMMENT 'updateId',
    update_time     TIMESTAMP           DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'updateTime',
    lock_version    INT(11)             DEFAULT -1 COMMENT 'lockVersion',
    user_id         BIGINT(15) NOT NULL DEFAULT -1 COMMENT 'userId',
    organization_id BIGINT(15) NOT NULL DEFAULT -1 COMMENT 'organizationId',
    INDEX (user_id),
    INDEX (organization_id),
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT 'study_user_organization_relation';


-- auto Generated on 2020-10-30
-- DROP TABLE IF EXISTS user_role_relation;
CREATE TABLE study_user_role_relation
(
    id           BIGINT(15) NOT NULL AUTO_INCREMENT COMMENT 'id',
    create_name  VARCHAR(50) COMMENT 'createName',
    create_id    BIGINT(15) COMMENT 'createId',
    create_time  DATETIME COMMENT 'createTime',
    update_name  VARCHAR(50) COMMENT 'updateName',
    update_id    BIGINT(15) COMMENT 'updateId',
    update_time  TIMESTAMP COMMENT 'updateTime',
    lock_version INT(11) COMMENT 'lockVersion',
    user_id      BIGINT(15) COMMENT 'userId',
    role_id      BIGINT(15) COMMENT 'roleId',
    INDEX (user_id),
    INDEX (role_id),
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT 'user_role_relation';
