# 创建支付订单

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
| bizAccount   | true  | String  | 业务账号                        |
| balance      | true  | Double  | 支付金额 (单位元，最多两位小数，0.1-50000) |
| taskId       | true  | Long    | 任务ID (需任务通过审核)              |

## 响应参数

| 参数名称         | 类型     | 描述                  |
|--------------|--------|---------------------|
| createTime   | Long   | 订单创建时间 (毫秒时间戳)      |
| outerTradeNo | String | 外部订单号(您系统的订单号，保持唯一) |
| tradeNo      | String | 订单号(理账狮订单号)         |
| state        | String | 订单状态                |

## 订单状态枚举

| 状态名称       | 描述   |
|------------|------|
| CONFIRMING | 等待确认 |
| CANCELED   | 订单取消 |
| PAYING     | 正在支付 |
| SUCCESS    | 支付成功 |
| FAIL       | 支付失败 |


