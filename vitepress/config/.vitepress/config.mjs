import {withMermaid} from "vitepress-plugin-mermaid"

// https://vitepress.dev/reference/site-config
export default withMermaid({
    srcDir: "../",
    outDir: "../../docs",
    title: "理账狮开放平台",
    description: "理账狮开放平台",
    themeConfig: {
        siteTitle: '开放平台',
        logo: "../../assets/logo.png",
        // https://vitepress.dev/reference/default-theme-config
        nav: [
            {text: '返回官网', link: 'https://open.workersaas.com'},
            {text: 'JavaSDK', link: 'https://github.com/HammCn/WorkerSaasSDK'}
        ],
        sidebar: [
            {
                text: '理账狮开放平台',
                items: [
                    {text: '请先阅读', link: '/'},
                ]
            },
            {
                text: '企业API',
                items: [
                    {text: '税额预算(参考)', link: '/tax/calc'},
                    {text: '获取被授权园区列表', link: '/enterprise/getList'},
                    {text: '获取被授权园区信息', link: '/enterprise/query'},
                    {text: '获取可用任务列表', link: '/task/getList'},
                    {text: '上报签约并派单', link: '/task/push'},
                    {text: '创建支付订单', link: '/order/create'},
                    {text: '查询支付订单', link: '/order/query'},
                    {text: '订单回调通知', link: '/order/notify'},
                ]
            },
            {
                text: '园区API',
                items: [
                    {text: '查看我园区下的企业', link: '/park/getList'},
                    {text: '查看我园区企业的详情', link: '/park/query'},
                    {text: '查看订单列表', link: '/park/order/getParkOrderList'},
                    {text: '查看订单详情', link: '/park/order/getParkOrderDetail'},
                ]
            },
            {
                text: '数据模型',
                items: [
                    {text: '订单', link: '/model/order'},
                    {text: '企业', link: '/model/enterprise'},
                    {text: '园区', link: '/model/park'},
                    {text: '可用授权园区', link: '/model/enterprisePark'},
                    {text: '附件', link: '/model/asset'},
                    {text: '分页', link: '/model/page'},
                    {text: '排序', link: '/model/sort'},
                ]
            },
        ],
    }
})
