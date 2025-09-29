# 获取被授权企业列表

## 接口地址

> park/getList

## 请求参数

无

## 响应参数(列表)

| 参数名称         | 类型         | 描述   |
|--------------|------------|------|
| id           | Long       | 授权ID |
| serviceRatio | Double     | 服务费率 |
| balance      | Double     | 当前余额 |
| enterprise   | Enterprise | 企业信息 |

## 企业基本信息

| 参数名称      | 类型     | 描述     |
|-----------|--------|--------|
| id        | Long   | 园区ID   |
| name      | String | 园区名称   |
| code      | String | 统一信用代码 |
| assetList | List[Asset] | 附件列表   |


## 附件信息

| 参数名称     | 类型     | 描述   |
|----------|--------|------|
| category | String | 附件类型 |
| url      | String | 文件地址 |

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


