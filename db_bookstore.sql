/*
 Navicat Premium Data Transfer

 Source Server         : 2020
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : db_bookstore

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 19/12/2020 12:22:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_book
-- ----------------------------
DROP TABLE IF EXISTS `tb_book`;
CREATE TABLE `tb_book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `type` int NOT NULL,
  `price` double NOT NULL,
  `cover` text NOT NULL,
  `detail` text,
  PRIMARY KEY (`id`),
  KEY `typeKey` (`type`),
  CONSTRAINT `typeKey` FOREIGN KEY (`type`) REFERENCES `tb_types` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for tb_types
-- ----------------------------
DROP TABLE IF EXISTS `tb_types`;
CREATE TABLE `tb_types` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `password` text NOT NULL,
  `usergroup` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tb_user_ibfk_1` (`usergroup`),
  CONSTRAINT `tb_user_ibfk_1` FOREIGN KEY (`usergroup`) REFERENCES `tb_usergroups` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for tb_usergroups
-- ----------------------------
DROP TABLE IF EXISTS `tb_usergroups`;
CREATE TABLE `tb_usergroups` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `book_info_permission` int NOT NULL,
  `types_permission` int NOT NULL,
  `user_permission` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `book_info_permission` (`book_info_permission`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SET FOREIGN_KEY_CHECKS = 1;
