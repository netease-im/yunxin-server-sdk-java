
# 1.0.0（2025/08/07）
### 新增
* 新增 `IM` 面向对象接口封装

### 更新
* 无

### fix
* 修复默认域名不可用时，sdk初始化失败的问题


# 0.9.0（2025/06/30）
### 新增
* 新增对 `RTC/SMS/LIVE/VOD/NEROOM/MEETING` 等业务的支持（目前仅支持raw-client)

### 更新
* PrometheusConverter新增biz字段，用于标识 IM/RTC/NEROOM/SMS/MEETING 等业务属性
* 修改了包名，包名前缀从 `com.netease.nim.im.server.sdk` 修改为 `com.netease.nim.server.sdk` ，以便实现对非IM业务的支持（破坏性更新）
* maven仓库依赖的 `artifactId` 从 `yunxin-im-server-sdk` 修改为 `yunxin-server-sdk` ，以便实现对非IM业务的支持（破坏性更新）
* `HttpCodeException` 和 `YunxinSdkException` 的 `message` 中，增加 `bizName` 描述

### fix
* PrometheusConverter格式化输出中耗时分位数相关metric的字段错误的问题


# 0.2.0（2025/03/21）
### 新增
* 在发起请求之前，允许设置超时，从而可以对单次请求设置和全局超时配置不一样的超时时间

### 更新
* 一个appkey/appsecret组合仅允许初始化YunxinHttpClient一次，多次初始化将直接报错

### fix
* 无


# 0.1.0（2024/12/24）
### 新增
* 第一个release版本
* 提供sdk核心功能，包括：多域名切换和调度策略、重试策略、监控、trace等
* 提供云信v1-api的raw-client，以及创建账号的面向对象client
* 提供云信v2-api的raw-client，以及创建账号、更新账号、查询账号的面向对象client

### 更新
* 无

### fix
* 无