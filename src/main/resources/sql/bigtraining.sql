
CREATE DATABASE bigtraining DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
drop table  if exists bigtraining.order;
CREATE TABLE bigtraining.order (
  `order_id` varchar(20) NOT NULL,
  `Item_code` varchar(20) NOT NULL,
  `order_qty` int DEFAULT '0',
  `order_date` char(8) DEFAULT NULL,
  `order_time` char(6) DEFAULT NULL,
  `order_user` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for stock
-- ----------------------------
drop table  if exists bigtraining.stock;
CREATE TABLE bigtraining.stock (
  `Item_code` varchar(20) NOT NULL,
  `qty` int DEFAULT '0',
  PRIMARY KEY (`Item_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stock
-- ----------------------------
INSERT INTO bigtraining.stock VALUES ('00010001', 10000);
INSERT INTO bigtraining.stock VALUES ('00010010', 10000);
INSERT INTO bigtraining.stock VALUES ('00010011', 10000);
INSERT INTO bigtraining.stock VALUES ('00010100', 10000);
INSERT INTO bigtraining.stock VALUES ('00100001', 10000);
INSERT INTO bigtraining.stock VALUES ('00100010', 10000);
INSERT INTO bigtraining.stock VALUES ('00100011', 10000);
INSERT INTO bigtraining.stock VALUES ('00110001', 10000);
INSERT INTO bigtraining.stock VALUES ('00110010', 10000);
INSERT INTO bigtraining.stock VALUES ('00110011', 10000);
