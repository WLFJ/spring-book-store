# 图书管理系统

## 特性

* 支持UNIX风格的权限管理（用户组和权限码）
* 支持图书信息、图书分类的CRUD
* 图书简介支持Markdown显示

## 搭建方式

首先创建数据库，使用`db_bookstore.db`将表创建好。

在`application.properties`中修改连接数据库的相关细节以及文件上传的目录，注意权限控制。

## 编译打包

使用
```shell
mvn package
```
即可在`target`文件夹下得到打包的`jar`文件。

## 服务器运行

因为与本地环境不同，使用以下命令运行运行即可制定服务器信息：

```shell
java -jar fun.wlfj.bookstore-<version>-SNAPSHOT.jar --spring.datasource.password=pAsSwOrD --yves.upload.path=/your/upload/path
```
注意命令无法直接运行，需要稍微修改。

## 遵循协议

本项目遵循WTFPL协议。
