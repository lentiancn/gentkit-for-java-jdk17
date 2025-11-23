# GentKit Base64

## 介绍

Base64 encoding and decoding library.

## 功能列表

> `com.gentkit.base64.utils.Base64WithCommonsCodecUtils.java` - 基于 commons codec 的 Base64 工具。

| 序号 | 功能                                             | 说明              |
|----|:-----------------------------------------------|:----------------|
| 1  | `byte[] decode(final byte[] base64)`           | 解码 Base64 字节数组。 |
| 2  | `byte[] decodeFromString(final String base64)` | 解码 Base64 字符串。  |
| 3  | `byte[] encode(final byte[] rawData)`          | 编码字节数组。         |
| 4  | `String encodeToString(final byte[] rawData)`  | 编码字节数组。         |

## 安装方法

> **Maven 项目** -> 添加依赖至 <code>pom.xml</code> ：

```xml
<dependency>
    <groupId>com.gentkit.base64</groupId>
    <artifactId>gentkit-base64-with-commons-codec</artifactId>
    <version>1.0.4-jdk17</version>
</dependency>
```

> **Gradle 项目** -> 添加依赖至 <code>build.gradle</code> ：

```groovy
implementation 'com.gentkit.base64:gentkit-base64-with-commons-codec:1.0.4-jdk17'
```
