package com.zyuc.log;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import com.zyuc.log.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LogApplicationTests {

    @Autowired
    MessageService messageService;

    @Test
    public void contextLoads() {
        System.out.println("hello");
    }

    @Test
    public void test2() {
        MailAccount account = new MailAccount();
        account.setHost("smtp.qq.com");
        account.setPort(587);
        account.setAuth(true);
        account.setFrom("2233128678@qq.com");
        account.setUser("2233128678@qq.com");
        account.setPass("nnqvmbfddddiecgi");

        MailUtil.send(account, CollUtil.newArrayList("2233128678@qq.com"), "验证码", "24680", false);

    }

    @Test
    public void test4()  {

        try {
            messageService.sendMessage("18012175908","验证码123456");
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

}
