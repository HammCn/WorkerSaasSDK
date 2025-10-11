# 查询我园区的订单列表

## 接口地址

> park/getParkOrderList

## 请求参数

| 参数名称 | 类型                          | 描述   |
|------|-----------------------------|------|
| page | [Page](../../model/page.md) | 分页对象 |
| sort | [Sort](../../model/sort.md) | 排序对象 |

## 请求示例

```json
 {
  "page": {
    "pageNum": 1,
    "pageSize": 10
  },
  "sort": {
    "field": "id",
    "direction": "desc"
  }
}
```

## 响应参数

| 参数名称      | 类型                                  | 描述   |
|-----------|-------------------------------------|------|
| total     | Int                                 | 总条数  |
| pageCount | Int                                 | 总页数  |
| list      | List[[Order](../../model/order.md)] | 订单列表 |
| page      | [Page](../../model/page.md)         | 分页对象 |
| sort      | [Sort](../../model/sort.md)         | 排序对象 |

## 返回示例

```json
{
  "code": 200,
  "data": {
    "total": 1,
    "pageCount": 1,
    "list": [
      {
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
    ],
    "page": {
      "pageNum": 1,
      "pageSize": 10
    },
    "sort": {
      "field": "createTime",
      "direction": "desc"
    }
  }
}

```