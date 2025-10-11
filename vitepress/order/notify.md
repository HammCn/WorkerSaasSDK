# 订单回调通知

> [!IMPORTANT]
> 沙箱在您正常提交之后，会自动回调到应用配置的地址上，请求方法为 `POST`，请求数据类型为 `application/json`
> 我们将进行多次重试，请确保自行处理幂等逻辑，避免订单被重复操作。

## 请求参数

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

您可以参考签名部分，使用同样的方式对上面的数据进行签名，并验证签名是否和传入的 `signature` 一致，如果一致，则说明签名成功，可以进行解密，并解析参数。

## 解析订单参数

返回订单模型，详情请查看 [订单模型](../model/order.md)
