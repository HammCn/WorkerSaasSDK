# 创建支付订单

> [!IMPORTANT]
> 创建订单需要先创建任务并审核通过，订单要求用户姓名、手机号二要素匹配。如用户未完成签约和报名任务，将无法进行发放。

## 接口地址

> order/create

## 请求参数

| 参数名称         | 是否必须  | 类型      | 描述                          |
|--------------|-------|---------|-----------------------------|
| outerTradeNo | true  | String  | 外部订单号(您系统的订单号，保持唯一)         |
| realName     | true  | String  | 真实姓名                        |
| phone        | true  | String  | 手机号(仅支持中国大陆，无需`+86`)        |
| idCard       | true  | String  | 证件号                         |
| idCardType   | false | Integer | 证件类型，目前固定传入 `1`，身份证         |
| payAccount   | true  | String  | 支付账号(支持手机号/邮箱/银行卡)          |
| reason       | true  | String  | 付款描述(真实场景描述,4-10位)          |
| bizAccount   | true  | String  | 业务账号(您系统的用户唯一索引)            |
| balance      | true  | Double  | 支付金额 (单位元，最多两位小数，0.1-50000) |
| taskId       | true  | Long    | 任务ID (需任务通过审核)              |

## 响应参数

返回订单模型，详情请查看 [订单模型](../model/order.md)

