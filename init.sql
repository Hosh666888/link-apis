CREATE TABLE if not exists `article` (
                           `id` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
                           `title` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
                           `labels` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标签 逗号分隔',
                           `content` longtext COLLATE utf8mb4_general_ci COMMENT '富文本原始字符',
                           `plain_text` longtext COLLATE utf8mb4_general_ci COMMENT '用于检索的文本',
                           `if_reprintd` tinyint(1) DEFAULT '0' COMMENT '是否转载',
                           `reprinted_url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '转载链接',
                           `if_top` tinyint(1) DEFAULT '0' COMMENT '是否置顶',
                           `cover_image_url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '封面图片地址',
                           `remark` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
                           `heat` bigint DEFAULT '0',
                           `create_user` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
                           `create_time` datetime DEFAULT NULL,
                           `update_user` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
                           `update_time` datetime DEFAULT NULL,
                           `delete_flag` tinyint(1) DEFAULT '0',
                           PRIMARY KEY (`id`),
                           UNIQUE KEY `article_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE if not exists `user` (
                        `id` bigint NOT NULL,
                        `username` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户名',
                        `password` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
                        `nick_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '昵称',
                        `gender` tinyint NOT NULL DEFAULT '1' COMMENT '性别',
                        `email` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
                        `role` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'normal' COMMENT '角色',
                        `experience` bigint DEFAULT '0' COMMENT '经验值',
                        `create_time` datetime NOT NULL,
                        `flag` int DEFAULT '1' COMMENT '标记位',
                        `avatar` varchar(255) COLLATE utf8mb4_general_ci DEFAULT 'https://images.pexels.com/photos/1605148/pexels-photo-1605148.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750' COMMENT '头像url',
                        `github_id` bigint DEFAULT NULL,
                        `github_home_url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `username_idx` (`username`) USING BTREE,
                        UNIQUE KEY `user_github_id_uindex` (`github_id`),
                        KEY `nickname_idx` (`nick_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;