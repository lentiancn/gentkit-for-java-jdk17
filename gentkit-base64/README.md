# GentKit Base64

[![许可证](https://img.shields.io/github/license/lentiancn/gentkit-for-java-jdk17.svg)](../LICENSE)
[![Codecov](https://img.shields.io/codecov/c/github/lentiancn/gentkit-for-java-jdk17/master)](https://codecov.io/gh/lentiancn/gentkit-for-java-jdk17)
[![GitHub 发行版本](https://img.shields.io/github/tag/lentiancn/gentkit-for-java-jdk17.svg?label=release)](https://github.com/lentiancn/gentkit-for-java-jdk17/releases)

简体中文 | [繁體中文](README/README_zh_CN_Hant.md) | [English](README/README_en.md)

## 介绍

Base64 encoding and decoding library.

## 开发语言

> Java JDK 17，但是如果需要应用旧版本环境，请移步至 [Java JDK 1.8](https://gitee.com/gentkit/gentkit-for-java-jdk8)

## 功能列表

> `com.gentkit.base64.utils.Base64WithCommonsCodecUtils.java` - 基于 commons codec 的 Base64 工具。

| 序号 | 功能                                             | 说明              |
|----|:-----------------------------------------------|:----------------|
| 1  | `byte[] decode(final byte[] base64)`           | 解码 Base64 字节数组。 |
| 2  | `byte[] decodeFromString(final String base64)` | 解码 Base64 字符串。  |
| 3  | `byte[] encode(final byte[] rawData)`          | 编码字节数组。         |
| 4  | `String encodeToString(final byte[] rawData)`  | 编码字节数组。         |

## 安装方法

获取[最新版本](https://gitee.com/gentkit/gentkit-for-java-jdk17/releases/latest)

> **Maven 项目** -> 添加依赖至 <code>pom.xml</code> ：

```xml
<dependency>
    <groupId>com.gentkit.base64</groupId>
    <artifactId>gentkit-base64-with-commons-codec</artifactId>
    <version>最新版本</version>
</dependency>
```

> **Gradle 项目** -> 添加依赖至 <code>build.gradle</code> ：

```groovy
implementation 'com.gentkit.base64:gentkit-base64-with-commons-codec:最新版本'
```

## 使用方法

待续...

