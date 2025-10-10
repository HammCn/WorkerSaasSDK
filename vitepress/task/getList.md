# 获取任务列表


> [!Tip]
> 你可以通过这个 API 来获取当前应用所在企业发布的已过审的任务列表。

## 接口地址

> task/getList

## 请求参数

无

## 响应参数

| 参数名称           | 类型             | 描述    |
|----------------|----------------|-------|
| id             | Long           | 任务ID  |
| name           | String         | 任务名称  |
| project        | String         | 项目ID  |
| enterprisePark | EnterprisePark | 授权的园区 |

## 授权的园区

| 参数名称         | 类型     | 描述   |
  |--------------|--------|------|
| id           | Long   | 授权ID |
| serviceRatio | Double | 服务费率 |
| balance      | Double | 当前余额 |
| park         | Park   | 园区信息 |

## 园区基本信息

| 参数名称 | 类型     | 描述     |
|------|--------|--------|
| id   | Long   | 园区ID   |
| name | String | 园区名称   |
| code | String | 统一信用代码 |

