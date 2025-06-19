# yunxin-server-sdk

![GitHub](https://img.shields.io/badge/license-MIT-blue.svg)
![GitHub release](https://img.shields.io/github/release/netease-im/yunxin-im-server-sdk.svg)
![java_language](https://img.shields.io/badge/java--language-1.8-blue.svg)

## 核心特性

* 基于okhttp封装了云信服务器api的sdk
* 支持重试，支持配置不同的重试策略，也支持自定义重试策略
* 支持多域名高可用，故障自动切换
* 支持多域名服务器调度，故障切换快速生效
* 支持trace-id，方便问题排查
* 支持metrics，支持prometheus格式输出
* 支持使用raw-client直接发起请求，也支持使用面向对象的client发起请求
* 支持云信以下功能模块的api：即时通讯（IM）、实时音视频（RTC）、短信（SMS）、直播（LIVE）、点播（VOD）、房间组件（NEROOM）、会议（MEETING）
* 支持云信私有化环境使用

## 架构图

<img src="docs/img.png" width="60%" height="60%">

## 引入依赖

```
<dependency>
    <groupId>com.netease.nim</groupId>
    <artifactId>yunxin-im-server-sdk</artifactId>
    <version>0.2.0</version>
</dependency>
```

## 更新日志

具体见：[更新日志](update.md)


## 快速开始

具体见：[快速开始](docs/quick_start.md)


## 关于重试

具体见：[retry](docs/retry.md)


## 关于多域名

具体见：[endpoint](docs/endpoint.md)


## 关于监控

具体见：[metrics](docs/metrics.md)


## 关于私有化

具体见：[privatization](docs/privatization.md)

## 其他

具体见：[others](docs/others.md)