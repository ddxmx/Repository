CREATE TABLE `user`(
   `id` INT(10),
   `name` VARCHAR(20) NOT	NULL,
   `age` INT(10)
) ENGINE INNODB DEFAULT CHARSET=utf8;


INSERT	INTO `user`(`id`,`name`,`age`) VALUES(1001,'zhangsan',20);
INSERT	INTO `user`(`id`,`name`,`age`) VALUES(1002,'lisi',24);
INSERT	INTO `user`(`id`,`name`,`age`) VALUES(1003,'wangwu',21);
INSERT	INTO `user`(`id`,`name`,`age`) VALUES(1004,'zhuliu',20);
INSERT	INTO `user`(`id`,`name`,`age`) VALUES(1005,'zhaoqi',22);