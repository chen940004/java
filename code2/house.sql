/*
 Navicat Premium Data Transfer

 Source Server         : 外部
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : 81.70.186.67:11234
 Source Schema         : house

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 08/05/2024 01:14:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for decoration
-- ----------------------------
DROP TABLE IF EXISTS `decoration`;
CREATE TABLE `decoration`  (
  `decoration` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `count` bigint(20) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of decoration
-- ----------------------------
INSERT INTO `decoration` VALUES ('无', 1);
INSERT INTO `decoration` VALUES ('其他', 2864);
INSERT INTO `decoration` VALUES ('简装', 4373);
INSERT INTO `decoration` VALUES ('毛坯', 3046);
INSERT INTO `decoration` VALUES ('精装', 8055);

-- ----------------------------
-- Table structure for district
-- ----------------------------
DROP TABLE IF EXISTS `district`;
CREATE TABLE `district`  (
  `district` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `count` bigint(20) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of district
-- ----------------------------
INSERT INTO `district` VALUES ('经济技术开发区', 2154);
INSERT INTO `district` VALUES ('奎文区', 2563);
INSERT INTO `district` VALUES ('青州市', 1114);
INSERT INTO `district` VALUES ('潍城区', 2736);
INSERT INTO `district` VALUES ('高新技术产业开发区', 2664);
INSERT INTO `district` VALUES ('锦绣学校', 1);
INSERT INTO `district` VALUES ('坊子区', 2598);
INSERT INTO `district` VALUES ('寒亭区', 1989);
INSERT INTO `district` VALUES ('寿光市', 2520);

-- ----------------------------
-- Table structure for elevator
-- ----------------------------
DROP TABLE IF EXISTS `elevator`;
CREATE TABLE `elevator`  (
  `elevator` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `count` bigint(20) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of elevator
-- ----------------------------
INSERT INTO `elevator` VALUES ('有', 8027);
INSERT INTO `elevator` VALUES ('一梯两户', 1);
INSERT INTO `elevator` VALUES ('无', 10311);

-- ----------------------------
-- Table structure for total
-- ----------------------------
DROP TABLE IF EXISTS `total`;
CREATE TABLE `total`  (
  `summary` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `total_price` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of total
-- ----------------------------
INSERT INTO `total` VALUES ('max', '99.9');
INSERT INTO `total` VALUES ('stddev', '61.62704212202812');
INSERT INTO `total` VALUES ('min', '10');
INSERT INTO `total` VALUES ('count', '18339');
INSERT INTO `total` VALUES ('mean', '85.72449424723449');

SET FOREIGN_KEY_CHECKS = 1;
