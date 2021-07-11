CREATE TABLE `teacher`
(
    `id`   INT(10) NOT NULL,
    `name` VARCHAR(20) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8;

INSERT INTO teacher(`id`, `name`)
VALUES (1001, '张老师');

CREATE TABLE `student`
(
    `id`   INT(10) NOT NULL,
    `name` VARCHAR(30) DEFAULT NULL,
    `tid`  INT(10)     DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `fktid` (`tid`),
    CONSTRAINT `fktid` FOREIGN KEY (`tid`) REFERENCES `teacher` (`id`)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8;

INSERT INTO `student` (`id`, `name`, `tid`)
VALUES ('2001', '小明', '1001');
INSERT INTO `student` (`id`, `name`, `tid`)
VALUES ('2002', '小红', '1001');
INSERT INTO `student` (`id`, `name`, `tid`)
VALUES ('2003', '小张', '1001');
INSERT INTO `student` (`id`, `name`, `tid`)
VALUES ('2004', '小李', '1001');
INSERT INTO `student` (`id`, `name`, `tid`)
VALUES ('2005', '小王', '1001');