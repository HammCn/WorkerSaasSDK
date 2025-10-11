# 获取被授权企业列表

## 接口地址

> park/getList

## 请求参数

无

## 响应参数(列表)

| 参数名称         | 类型                                   | 描述   |
|--------------|--------------------------------------|------|
| id           | Long                                 | 授权ID |
| serviceRatio | Double                               | 服务费率 |
| balance      | Double                               | 当前余额 |
| enterprise   | [Enterprise](../model/enterprise.md) | 企业信息 |

## 示例

```json
{
  "code": 200,
  "data": [
    {
      "id": 1,
      "serviceRatio": 0.01,
      "balance": 1000.0,
      "enterprise": {
        "name": "x",
        "code": "x"
      }
    }
  ]
}
```


