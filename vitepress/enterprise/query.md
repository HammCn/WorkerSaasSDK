# 获取被授权园区信息

## 接口地址

> enterprisePark/query

## 请求参数

| 参数名称 | 是否必须 | 类型   | 描述   |
|------|------|------|------|
| id   | true | Long | 授权ID |

## 响应参数

| 参数名称         | 类型     | 描述   |
|--------------|--------|------|
| id           | Long   | 授权ID |
| serviceRatio | Double | 服务费率 |
| balance      | Double | 当前余额 |
| park         | Park   | 园区信息 |

## 园区基本信息

| 参数名称 | 类型     | 描述     |
|------|--------|--------|
| name | String | 园区名称   |
| code | String | 统一信用代码 |

