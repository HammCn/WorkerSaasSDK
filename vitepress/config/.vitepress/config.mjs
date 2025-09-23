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
                text: '授权园区',
                items: [
                    {text: '获取被授权园区列表', link: '/enterprise/getList'},
                    {text: '获取被授权园区信息', link: '/enterprise/query'},
                ]
            },
            {
                text: '任务相关',
                items: [
                    {text: '获取可用任务列表', link: '/task/getList'},
                ]
            },
            {
                text: '订单相关',
                items: [
                    {text: '创建支付订单', link: '/order/create'},
                    {text: '查询支付订单', link: '/order/query'},
                    {text: '订单回调通知', link: '/order/notify'},
                ]
            }
        ],
    }
})
