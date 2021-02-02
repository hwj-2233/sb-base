package com.zyuc.log;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import cn.hutool.http.HttpUtil;
import cn.snowheart.dingtalk.robot.starter.client.DingTalkRobotClient;
import cn.snowheart.dingtalk.robot.starter.entity.*;
import cn.snowheart.dingtalk.robot.starter.type.HideAvatarType;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.waner.starter.service.MyService;
import com.zyuc.log.constant.Color;
import com.zyuc.log.entity.Employee;
import com.zyuc.log.entity.SysLog;
import com.zyuc.log.entity.Tenant;
import com.zyuc.log.mapper.ISysLogMapper;
import com.zyuc.log.mapper.ITenantMapper;
import com.zyuc.log.service.MessageService;
import com.zyuc.log.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class LogApplicationTests {

    @Autowired
    private DingTalkRobotClient client;

    @Autowired
    private Employee employee;

    @Autowired
    private MyService myService;

    @Test
    public void contextLoads() {

    }

    /**
     * 测试 DingTalkRobotClient#sendMessage(BaseMessage) 发送消息
     *
     * @throws InterruptedException
     * @see DingTalkRobotClient#sendMessage(cn.snowheart.dingtalk.robot.starter.entity.BaseMessage)
     */
    @Test
    public void testSendMessageWithText() throws InterruptedException {
        DingTalkResponse response = null;

        response = client.sendMessage(new TextMessage("HelloWorld!"));
        Assert.assertEquals(response.getErrcode().longValue(), 0L);
        log.info(response.toString());
        Thread.sleep(3000);

        response = client.sendMessage(new LinkMessage("习近平等党和国家领导人出席全国政协十三届一次会议闭幕会",
                "全国政协十三届一次会议闭幕 习近平李克强张德江俞正声张高丽栗战书王沪宁赵乐际韩正出席 汪洋发表讲话",
                "http://mp.weixin.qq.com/s/UfmtYLSZL7kgCNnKC6Co0Q",
                "http://www.scps.gov.cn/images/17/03/02/1our9zwzfg/C6065233104C46BBC626EB4FC48A4941.jpg"));
        Assert.assertEquals(response.getErrcode().longValue(), 0L);
        log.info(response.toString());
        Thread.sleep(3000);

        response = client.sendMessage(new MarkdownMessage("钉钉markdown消息支持的语法",
                markDownDemoText));

        Assert.assertEquals(response.getErrcode().longValue(), 0L);
        log.info(response.toString());
        Thread.sleep(3000);

        response = client.sendMessage(new ActionCardMessage("This is title", "![screenshot](@lADOpwk3K80C0M0FoA)\n" +
                "**Apple Store** 的设计正从原来满满的科技感走向生活化，而其生活化的走向其实可以追溯到 20 年前苹果一个建立咖啡馆的计划",
                HideAvatarType.HIDE));
        Assert.assertEquals(response.getErrcode().longValue(), 0L);
        log.info(response.toString());
        Thread.sleep(3000);

    }

    /**
     * 测试 DingTalkRobotClient#sendTextMessage() 发送文本消息
     *
     * @throws InterruptedException
     * @see DingTalkRobotClient#sendTextMessage(String)
     */
    @Test
    public void testSendTextMessage() throws InterruptedException {
        DingTalkResponse response = null;

        response = client.sendTextMessage(new TextMessage("HelloWorld!"));
        Assert.assertEquals(response.getErrcode().longValue(), 0L);
        log.info(response.toString());
        Thread.sleep(3000);

        response = client.sendTextMessage("HelloWorld!");
        Assert.assertEquals(response.getErrcode().longValue(), 0L);
        log.info(response.toString());
        Thread.sleep(3000);

        response = client.sendTextMessage("HelloWorld!", new String[]{"13123456789"});
        Assert.assertEquals(response.getErrcode().longValue(), 0L);
        log.info(response.toString());
        Thread.sleep(3000);

        response = client.sendTextMessage("HelloWorld!", true);
        Assert.assertEquals(response.getErrcode().longValue(), 0L);
        log.info(response.toString());
        Thread.sleep(3000);
    }

    /**
     * 测试 DingTalkRobotClient#sendLinkMessage() 发送链接消息
     *
     * @throws InterruptedException
     */
    @Test
    public void testSendLinkMessage() throws InterruptedException {
        DingTalkResponse response = null;

        response = client.sendLinkMessage(new LinkMessage("习近平等党和国家领导人出席全国政协十三届一次会议闭幕会",
                "全国政协十三届一次会议闭幕 习近平李克强张德江俞正声张高丽栗战书王沪宁赵乐际韩正出席 汪洋发表讲话",
                "http://mp.weixin.qq.com/s/UfmtYLSZL7kgCNnKC6Co0Q",
                "http://www.scps.gov.cn/images/17/03/02/1our9zwzfg/C6065233104C46BBC626EB4FC48A4941.jpg"));
        Assert.assertEquals(response.getErrcode().longValue(), 0L);
        log.info(response.toString());
//        Thread.sleep(3000);
//
//        response = client.sendLinkMessage("习近平等党和国家领导人出席全国政协十三届一次会议闭幕会",
//                "全国政协十三届一次会议闭幕 习近平李克强张德江俞正声张高丽栗战书王沪宁赵乐际韩正出席 汪洋发表讲话",
//                "http://mp.weixin.qq.com/s/UfmtYLSZL7kgCNnKC6Co0Q");
//        Assert.assertEquals(response.getErrcode().longValue(), 0L);
//        log.info(response.toString());
//        Thread.sleep(3000);
//
//        response = client.sendLinkMessage("习近平等党和国家领导人出席全国政协十三届一次会议闭幕会",
//                "全国政协十三届一次会议闭幕 习近平李克强张德江俞正声张高丽栗战书王沪宁赵乐际韩正出席 汪洋发表讲话",
//                "http://mp.weixin.qq.com/s/UfmtYLSZL7kgCNnKC6Co0Q",
//                "http://www.scps.gov.cn/images/17/03/02/1our9zwzfg/C6065233104C46BBC626EB4FC48A4941.jpg");
//        Assert.assertEquals(response.getErrcode().longValue(), 0L);
//        log.info(response.toString());
//        Thread.sleep(3000);

    }

    /**
     * 测试 DingTalkRobotClient#sendMarkdownMessage() 发送链接消息
     *
     * @throws InterruptedException
     */
    @Test
    public void testSendMarkdownMessage() throws InterruptedException {
        DingTalkResponse response = null;

        response = client.sendMarkdownMessage(new MarkdownMessage("钉钉markdown消息支持的语法",
                markDownDemoText));
        Assert.assertEquals(response.getErrcode().longValue(), 0L);
        log.info(response.toString());
        Thread.sleep(3000);

        response = client.sendMarkdownMessage("钉钉markdown消息支持的语法",
                markDownDemoText);
        Assert.assertEquals(response.getErrcode().longValue(), 0L);
        log.info(response.toString());
        Thread.sleep(3000);

        response = client.sendMarkdownMessage("钉钉markdown消息支持的语法",
                markDownDemoText, new String[]{"13123456789"});
        Assert.assertEquals(response.getErrcode().longValue(), 0L);
        log.info(response.toString());
        Thread.sleep(3000);

        response = client.sendMarkdownMessage("钉钉markdown消息支持的语法",
                markDownDemoText, true);
        Assert.assertEquals(response.getErrcode().longValue(), 0L);
        log.info(response.toString());
        Thread.sleep(3000);
    }

    /**
     * 测试 DingTalkRobotClient#sendActionCardMessage() 发送ActionCard消息
     *
     * @throws InterruptedException
     */
    @Test
    public void testSendActionCardMessage() throws InterruptedException {
        DingTalkResponse response = null;

        response = client.sendActionCardMessage(new ActionCardMessage("This is title", "![screenshot](@lADOpwk3K80C0M0FoA)\n" +
                "**Apple Store** 的设计正从原来满满的科技感走向生活化，而其生活化的走向其实可以追溯到 20 年前苹果一个建立咖啡馆的计划"));
        Assert.assertEquals(response.getErrcode().longValue(), 0L);
        log.info(response.toString());
        Thread.sleep(3000);

        response = client.sendActionCardMessage("This is title", "![screenshot](@lADOpwk3K80C0M0FoA)\n" +
                "**Apple Store** 的设计正从原来满满的科技感走向生活化，而其生活化的走向其实可以追溯到 20 年前苹果一个建立咖啡馆的计划");
        Assert.assertEquals(response.getErrcode().longValue(), 0L);
        log.info(response.toString());
        Thread.sleep(3000);

        response = client.sendActionCardMessage("This is title", "![screenshot](@lADOpwk3K80C0M0FoA)\n" +
                        "**Apple Store** 的设计正从原来满满的科技感走向生活化，而其生活化的走向其实可以追溯到 20 年前苹果一个建立咖啡馆的计划",
                HideAvatarType.HIDE);
        Assert.assertEquals(response.getErrcode().longValue(), 0L);
        log.info(response.toString());
        Thread.sleep(3000);

        response = client.sendActionCardMessage("This is title", "![screenshot](@lADOpwk3K80C0M0FoA)\n" +
                        "**Apple Store** 的设计正从原来满满的科技感走向生活化，而其生活化的走向其实可以追溯到 20 年前苹果一个建立咖啡馆的计划",
                ActionCardButton.defaultReadButton("https://www.dingtalk.com"));
        Assert.assertEquals(response.getErrcode().longValue(), 0L);
        log.info(response.toString());
        Thread.sleep(3000);

        response = client.sendActionCardMessage("This is title", "![screenshot](@lADOpwk3K80C0M0FoA)\n" +
                        "**Apple Store** 的设计正从原来满满的科技感走向生活化，而其生活化的走向其实可以追溯到 20 年前苹果一个建立咖啡馆的计划",
                HideAvatarType.HIDE,
                ActionCardButton.defaultReadButton("https://www.dingtalk.com"));
        Assert.assertEquals(response.getErrcode().longValue(), 0L);
        log.info(response.toString());
        Thread.sleep(3000);

    }

    /**
     * 测试 DingTalkRobotClient#sendFeedCardMessage() 发送FeedCard消息
     *
     * @throws InterruptedException
     */
    @Test
    public void testSendFeedCardMessage() throws InterruptedException {
        DingTalkResponse response = null;

        ArrayList<FeedCardMessageItem> items = new ArrayList<>();
        items.add(new FeedCardMessageItem("成为架构师的路上，看这一篇文章就足够了，因为……",
                "http://mp.weixin.qq.com/s/CPUaB60pue0Zf3fUL9xqvw",
                "https://mmbiz.qpic.cn/mmbiz_jpg/YriaiaJPb26VMtfgPvTsM9amH5hf3pmTbf40ia6OLE845icrDb0vt4AsMnTyva5mMMpwwxnkVR5UjCEI8ADvSic1qWQ/640"));

        items.add(new FeedCardMessageItem("想成为一名Web开发者？你应该学习Node.js而不是PHP",
                "http://mp.weixin.qq.com/s/x8dm9e7gwLXSEzxE6sQYow",
                "https://mmbiz.qpic.cn/mmbiz_jpg/YriaiaJPb26VND0Q0hSBOoyVkr9cXQrFjWI7hOzax1IxIibqanXYD4W8nyeYX5iaicjgiaqia7ly94iawOsGwehbKGwGsA/640"));

        response = client.sendFeedCardMessage(new FeedCardMessage(items));
        Assert.assertEquals(response.getErrcode().longValue(), 0L);
        log.info(response.toString());
        Thread.sleep(3000);

        response = client.sendFeedCardMessage(items);
        Assert.assertEquals(response.getErrcode().longValue(), 0L);
        log.info(response.toString());
        Thread.sleep(3000);
    }

    /**
     * 通过调用getWebhook方法来做外部的配置项传入，之后再进行消息发送
     */
    @Test
    public void testGetWebhookAndSendMessage() throws InterruptedException {
        DingTalkResponse response;

        TextMessage message = new TextMessage("HelloWorld!");

        String nonSignAccessToken = "change-to-your-access-token";
        String signAccessToken = "change-to-your-access-token";
        String signSecretToken = "change-to-your-secret-token";

        String actualUrl;

        actualUrl = client.getWebhook(nonSignAccessToken);
        response = client.sendMessageByURL(actualUrl, message);
        Assert.assertEquals(response.getErrcode().longValue(), 0L);
        Thread.sleep(3000);

        actualUrl = client.getWebhook(nonSignAccessToken, null, false);
        response = client.sendMessageByURL(actualUrl, message);
        Assert.assertEquals(response.getErrcode().longValue(), 0L);
        Thread.sleep(3000);

        actualUrl = client.getWebhook(signAccessToken, signSecretToken);
        response = client.sendMessageByURL(actualUrl, message);
        Assert.assertEquals(response.getErrcode().longValue(), 0L);
        Thread.sleep(3000);

        actualUrl = client.getWebhook(signAccessToken, signSecretToken, true);
        response = client.sendMessageByURL(actualUrl, message);
        Assert.assertEquals(response.getErrcode().longValue(), 0L);
        Thread.sleep(3000);
    }

    private static final String markDownDemoText = "标题\n" +
            "# 一级标题\n" +
            "## 二级标题\n" +
            "### 三级标题\n" +
            "#### 四级标题\n" +
            "##### 五级标题\n" +
            "###### 六级标题\n" +
            " \n" +
            "引用\n" +
            "> A man who stands for nothing will fall for anything.\n" +
            " \n" +
            "文字加粗、斜体\n" +
            "**bold**\n" +
            "*italic*\n" +
            " \n" +
            "链接\n" +
            "[阿里钉钉](https://www.dingtalk.com/)\n" +
            " \n" +
            "图片\n" +
            "![](https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522996154390&di=a2d4d224314dac89acafbfce1bb04c11&imgtype=0)\n" +
            " \n" +
            "无序列表\n" +
            "- item1\n" +
            "- item2\n" +
            " \n" +
            "有序列表\n" +
            "1. item1\n" +
            "2. item2";


    @Test
    public void test1() {
        myService.say();

    }

    @Test
    public void test2() {
        String result1 = HttpUtil.post("http://172.16.0.23:8086/api/app/getTypes","{\n" +
                "\t\"dataBelongCom\": \"\",\n" +
                "\t\"dataBelongRole\": \"\",\n" +
                "\t\"endTime\": \"\",\n" +
                "\t\"eventId\": [],\n" +
                "\t\"eventLevel\": [],\n" +
                "\t\"eventType\": [],\n" +
                "\t\"host\": [],\n" +
                "\t\"srcIp\": \"\",\n" +
                "\t\"startTime\": \"\"\n" +
                "}");
        System.err.println(result1);


    }
}
