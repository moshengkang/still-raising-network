CREATE TABLE `table_emp` (
`emp_id`  int NOT NULL AUTO_INCREMENT COMMENT '主键id',
`emp_name`  varchar(100) NULL COMMENT '姓名',
`emp_age`  int NULL COMMENT '年龄',
PRIMARY KEY (`emp_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='部门表';
#数据初始化
INSERT INTO `table_emp` (`emp_id`, `emp_name`, `emp_age`) VALUES ('1', 'tom', '18');
INSERT INTO `table_emp` (`emp_id`, `emp_name`, `emp_age`) VALUES ('2', 'jack', '18');
