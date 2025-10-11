# 获取被授权园区列表

> [!Tip]
> 你可以通过这个 API 来获取当前应用所在企业被授权使用的可用园区列表以及对应的余额和服务费率等信息。

## 接口地址

> enterprisePark/getList

## 请求参数

无

## 响应参数(列表)

| 参数名称         | 类型                       | 描述   |
|--------------|--------------------------|------|
| id           | Long                     | 授权ID |
| serviceRatio | Double                   | 服务费率 |
| balance      | Double                   | 当前余额 |
| park         | [Park](../model/park.md) | 园区信息 |
