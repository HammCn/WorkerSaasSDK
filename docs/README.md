# 理账狮开放接口文档

## 文档说明

如无特殊说明：

- 均使用 `POST` 方式请求，其中 `code` 为 `200` 表示请求成功，其他为失败。

目前提供的环境：

- 沙箱环境：`https://sandbox.workersaas.com/api/open/`

## 概念描述

- `appKey`：应用标识，全局唯一。
- `appSecret`：应用密钥，请勿泄露。
- `version`：接口版本号，固定为 `10000`。
- `timestamp`：时间戳，毫秒数。
- `nonce`：随机字符串，长度为 32 个字符。
- `signature`：签名，使用 `SHA1` 签名算法对 `content` 进行签名。
- `content`：请求内容，使用 `AES` 加密后的数据。

其中，除 `appSecret` 之外，其他参数都是接口必须的固定参数。

## 签名与加解密

- 加密方法：`AES/CBC/PKCS5Padding`
- 签名方法：`SHA1`

## 签名算法说明

### 获取加密数据的 `JSON`：

根据各个接口提供的参数，准备请求的 `JSON` 如下：

```json
{
  "outerTradeNo": "D202410010000000004",
  "realName": "XXX",
  "phone": "XXX",
  "idCard": "XXX",
  "idCardType": 1,
  "payAccount": "XXX",
  "bizAccount": "XXX",
  "balance": 1.0,
  "taskId": 1
}
```

### 使用 AES 对数据进行加密

- 加密方法：`AES/CBC/PKCS5Padding`
- 应用的 `AppSecret` 是加解密密钥，请勿泄露。
- 初始向量：`0000000000000000`

加密后的数据为：

```txt
zzMvuQIn8wD5wV68jRvJEimnoLrCMumVIUDcRukB2bAc8rAGIQSv1WzT8tJ7JrYVeSHH9v0FczOCcw8ya2Vh1Puf6z1/rYizMsMlZ0Mxe85a2KnJHPCWQOSpRIwfLgdmimsl/Wy6C56vnWN4GQ5q9gYwgfmScEzwhUDQSb6Gg+cPio8s2YQVWClbB6P1qY+KxzjgEJWszhkWcViNncmZpzxoPe0HHW5Kj6hUfTbPFYvxW+opZ0hk1I0+Iv4Gokusd6vBkr8k7UCZ45a83GEL5g==
```

### 准备待签名字符串

按 `AppSeceret`、`AppKey`、`版本号`、`毫秒时间戳`、`随机字符串`、`加密后的内容` 的固定顺序组成待签名字符串：

> 下面是为了演示，实际请勿包含空格、换行符、其他符号等。

```txt
xNBf8CcKJW1GImCiVt1LHWFb68hDOLcARrNA5rTCACY=
NO9pn4tMn3aIvwX95CyxFlFzexXmzOFp
10000
1758634162422
9vTpJuqg1Y601qbJ6FL9aZKEI7hURWBh
zzMvuQIn8wD5wV68jRvJEimnoLrCMumVIUDcRukB2bAc8rAGIQSv1WzT8tJ7JrYVeSHH9v0FczOCcw8ya2Vh1Puf6z1/rYizMsMlZ0Mxe85a2KnJHPCWQOSpRIwfLgdmimsl/Wy6C56vnWN4GQ5q9gYwgfmScEzwhUDQSb6Gg+cPio8s2YQVWClbB6P1qY+KxzjgEJWszhkWcViNncmZpzxoPe0HHW5Kj6hUfTbPFYvxW+opZ0hk1I0+Iv4Gokusd6vBkr8k7UCZ45a83GEL5g==
````

组合后的字符串如下：

```txt
xNBf8CcKJW1GImCiVt1LHWFb68hDOLcARrNA5rTCACY=NO9pn4tMn3aIvwX95CyxFlFzexXmzOFp1000017586341624229vTpJuqg1Y601qbJ6FL9aZKEI7hURWBhzzMvuQIn8wD5wV68jRvJEimnoLrCMumVIUDcRukB2bAc8rAGIQSv1WzT8tJ7JrYVeSHH9v0FczOCcw8ya2Vh1Puf6z1/rYizMsMlZ0Mxe85a2KnJHPCWQOSpRIwfLgdmimsl/Wy6C56vnWN4GQ5q9gYwgfmScEzwhUDQSb6Gg+cPio8s2YQVWClbB6P1qY+KxzjgEJWszhkWcViNncmZpzxoPe0HHW5Kj6hUfTbPFYvxW+opZ0hk1I0+Iv4Gokusd6vBkr8k7UCZ45a83GEL5g==
```

### 使用 `sha1` 签名

使用 `sha1` 签名算法对待签名字符串进行签名，得到签名结果：

```txt
86c83642c2413fdb0d14ece56f7cee4ede78b0a8
```

### 发起请求

接下来，就可以将 `sign` 添加到请求参数中发起请求了，于是下面的 `json` 为最终的提交参数：

```json
{
  "appKey": "NO9pn4tMn3aIvwX95CyxFlFzexXmzOFp",
  "version": 10000,
  "timestamp": 1758634162422,
  "content": "zzMvuQIn8wD5wV68jRvJEimnoLrCMumVIUDcRukB2bAc8rAGIQSv1WzT8tJ7JrYVeSHH9v0FczOCcw8ya2Vh1Puf6z1/rYizMsMlZ0Mxe85a2KnJHPCWQOSpRIwfLgdmimsl/Wy6C56vnWN4GQ5q9gYwgfmScEzwhUDQSb6Gg+cPio8s2YQVWClbB6P1qY+KxzjgEJWszhkWcViNncmZpzxoPe0HHW5Kj6hUfTbPFYvxW+opZ0hk1I0+Iv4Gokusd6vBkr8k7UCZ45a83GEL5g==",
  "nonce": "9vTpJuqg1Y601qbJ6FL9aZKEI7hURWBh",
  "signature": "86c83642c2413fdb0d14ece56f7cee4ede78b0a8"
}
```

### 接口列表

- [获取授权园区列表](enterprise/getList.md)
- [获取授权园区信息](enterprise/query.md)
- [创建支付订单](order/create.md)
- [查询支付订单](order/query.md)
- [订单回调](order/notify.md)
- [查询可用任务列表](task/getList.md)
