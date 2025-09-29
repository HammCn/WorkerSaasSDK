# 查询我园区的订单列表

## 接口地址

> park/getParkOrderDetail

## 请求参数

| 参数名称    | 类型     | 描述  |
|---------|--------|-----|
| tradeNo | String | 订单号 |

## 请求示例

```json
 {
  "tradeNo": "2019061000000001"
}
```

## 订单详情

| 参数名称       | 类型         | 描述                          |
|------------|------------|-----------------------------|
| createTime | Long       | 订单创建时间 (毫秒时间戳)              |
| tradeNo    | String     | 订单号(理账狮订单号)                 |
| state      | String     | 订单状态                        |
| payAccount | String     | 支付账号(支持手机号/邮箱/银行卡)          |
| taskId     | Long       | 任务ID (需任务通过审核)              |
| balance    | Double     | 支付金额 (单位元，最多两位小数，0.1-50000) |
| realName   | String     | 真实姓名                        |
| phone      | String     | 手机号(仅支持中国大陆，无需`+86`)        |
| idCard     | String     | 证件号                         |
| idCardType | Integer    | 证件类型，目前固定传入 `1`，身份证         |
| enterprise | Enterprise | 企业信息                        |

## 企业信息

| 参数名称 | 类型     | 描述     |
|------|--------|--------|
| name | String | 企业名称   
| code | String | 组织机构代码 |

## 订单状态枚举

| 状态名称       | 描述   |
|------------|------|
| CONFIRMING | 等待确认 |
| CANCELED   | 订单取消 |
| PAYING     | 正在支付 |
| SUCCESS    | 支付成功 |
| FAIL       | 支付失败 |

## 返回示例

```json
{
  "code": 200,
  "data": {
    "createTime": 1560000000000,
    "tradeNo": "2019061000000001",
    "state": "SUCCESS",
    "payAccount": "12345678901",
    "taskId": 1,
    "balance": 0.01,
    "realName": "张三",
    "phone": "12345678901",
    "idCard": "123456789012345678",
    "idCardType": 1,
    "enterprise": {
      "name": "x",
      "code": "x"
    }
  }
}

```

> 如果有需要的其他字段，请联系我们。