# 附件模型 Asset

## 属性

| 参数名称     | 类型     | 描述   |
|----------|--------|------|
| category | String | 附件类型 |
| url      | String | 文件地址 |

## 下载文件

请重定向下面的 URL 进行下载：

> 假定 GATEWAY_PRODUCTION = "https://open.workersaas.com/api/open/";

则下载地址为去掉 `/open/` 并加上 `file/url?url={$URL}`

结果如下：

> https://open.workersaas.com/api/file/url?url={url}
