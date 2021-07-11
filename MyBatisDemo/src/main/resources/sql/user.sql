DROP TABLE IF EXISTS `user`;

CREATE TABLE `user`
(
    `id`   INT(10) PRIMARY KEY,
    `name` VARCHAR(20),
    `age`  INT(10)
) ENGINE INNODB
  DEFAULT CHARSET = utf8;

INSERT INTO `user`(`id`, `name`, `age`)
VALUES (1000, '赵四', 22);
INSERT INTO `user`(`id`, `name`, `age`)
VALUES (1001, '张三', 20);
INSERT INTO `user`(`id`, `name`, `age`)
VALUES (1002, '李四', 24);
INSERT INTO `user`(`id`, `name`, `age`)
VALUES (1003, '王五', 21);
INSERT INTO `user`(`id`, `name`, `age`)
VALUES (1004, '赵六', 20);
INSERT INTO `user`(`id`, `name`, `age`)
VALUES (1005, 'tom', 23);
INSERT INTO `user`(`id`, `name`, `age`)
VALUES (1006, 'jerry', 22);