package com.zyuc.log.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author hongwj
 * @date 2020/12/21
 **/
@Service
public class MailService {

   public void sendEmail(String content) {

        MailAccount account = new MailAccount();
        account.setHost("smtp.qq.com");
        account.setPort(587);
        account.setAuth(true);
        account.setFrom("2233128678@qq.com");
        account.setUser("2233128678@qq.com");
        account.setPass("nnqvmbfddddiecgi");

        MailUtil.send(account, CollUtil.newArrayList("2233128678@qq.com"), "验证码", content, false);
    }
}
