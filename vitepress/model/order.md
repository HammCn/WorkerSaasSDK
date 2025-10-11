# 订单模型 Order

## 属性

| 参数名称           | 类型                            | 描述                    |
|----------------|-------------------------------|-----------------------|
| createTime     | Long                          | 订单创建时间 (`毫秒时间戳`)      |
| outerTradeNo   | String                        | 外部订单号(`您系统的订单号，保持唯一`) |
| payOutTradeNo  | String                        | 支付平台流水号(`如支付宝`)       |
| tradeNo        | String                        | 订单号(`理账狮订单号`)         |
| state          | String                        | 订单状态      `状态枚举`      |
| payAccount     | String                        | 支付账号(支持手机号/邮箱/银行卡)    |
| taskId         | Long                          | 任务ID (`需任务通过审核`)      |
| balance        | Double                        | 提交的支付金额，`单位元，精确到分`    |
| tax            | Double                        | 个人所得税，`单位元，精确到分`      |
| vatTax         | Double                        | 增值税，`单位元，精确到分 `       |
| additionalTax  | Double                        | 附加税，`单位元，精确到分 `       |
| additionalTax  | Double                        | 附加税，`单位元，精确到分 `       |
| errorMessage   | String                        | 错误信息                  |
| payTime        | Long                          | 付款时间 (`毫秒时间戳`)        |
| serviceBalance | Double                        | 服务费，`单位元，精确到分  `      |
| realName       | String                        | 真实姓名                  |
| phone          | String                        | 手机号                   |
| idCard         | String                        | 证件号                   |
| idCardType     | Integer                       | 证件类型，目前固定 `1`，身份证     |
| enterprise     | [Enterprise](./enterprise.md) | 企业信息                  |

## 状态枚举

| 状态名称       | 描述   |
|------------|------|
| CONFIRMING | 等待确认 |
| CANCELED   | 订单取消 |
| PAYING     | 正在支付 |
| SUCCESS    | 支付成功 |
| FAIL       | 支付失败 |


