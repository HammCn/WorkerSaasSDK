# 获取被授权企业信息

## 接口地址

> park/query

## 请求参数

| 参数名称 | 是否必须 | 类型   | 描述   |
|------|------|------|------|
| id   | true | Long | 授权ID |

## 响应参数

| 参数名称         | 类型         | 描述   |
|--------------|------------|------|
| id           | Long       | 授权ID |
| serviceRatio | Double     | 服务费率 |
| balance      | Double     | 当前余额 |
| enterprise   | Enterprise | 企业信息 |

## 企业基本信息

| 参数名称      | 类型     | 描述     |
|-----------|--------|--------|
| name      | String | 企业名称   |
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
  "data": {
    "id": 1,
    "serviceRatio": 0.01,
    "balance": 1000.0,
    "enterprise": {
      "name": "x",
      "code": "x",
      "assetList": [
        {
          "category": "x",
          "url": "x"
        }
      ]
    }
  }
}
```

## 下载文件

请重定向下面的 URL 进行下载：

> 假定 GATEWAY_PRODUCTION = "https://open.workersaas.com/api/open/";

则下载地址为去掉 `/open/` 并加上 `file/url?url={$URL}`

结果如下：

> https://open.workersaas.com/api/file/url?url={url}
