CREATE TABLE `blog`
(
    `id`          varchar(20) NOT NULL COMMENT '博客id',
    `title`       varchar(50) NOT NULL COMMENT '博客标题',
    `author`      varchar(20) NOT NULL COMMENT '博客作者',
    `create_time` datetime    NOT NULL COMMENT '创建时间',
    `views`       int(10)     NOT NULL COMMENT '浏览量'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


INSERT INTO `blog`(`id`, `title`, `author`, `create_time`, `views`)
VALUES ('110', 'MySQL数据库', '张三', '2021-07-05 22:57:23', 3981);
INSERT INTO `blog`(`id`, `title`, `author`, `create_time`, `views`)
VALUES ('111', 'java开发实战经典', '李兴华', '2020-01-03 21:21:11', 5490);
INSERT INTO `blog`(`id`, `title`, `author`, `create_time`, `views`)
VALUES ('112', 'python基础教程', 'jerry', '2021-01-06 23:24:35', 6811);
INSERT INTO `blog`(`id`, `title`, `author`, `create_time`, `views`)
VALUES ('113', 'linux基础命令', 'tom', '2021-06-24 18:27:19', 6744);
