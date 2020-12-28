package com.zyuc.log;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.zyuc.log.constant.Color;
import com.zyuc.log.entity.SysLog;
import com.zyuc.log.entity.Tenant;
import com.zyuc.log.entity.User;
import com.zyuc.log.mapper.ISysLogMapper;
import com.zyuc.log.mapper.ITenantMapper;
import com.zyuc.log.service.MessageService;
import com.zyuc.log.util.IJWTInfo;
import com.zyuc.log.util.JWTInfo;
import com.zyuc.log.util.JwtTokenUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LogApplicationTests {

    @Autowired
    MessageService messageService;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    ISysLogMapper sysLogMapper;

    @Autowired
    ITenantMapper tenantMapper;

    @Autowired
    User user;

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
    public void test4() throws Exception {
        IJWTInfo jwtInfo = new JWTInfo("1", "哈喽", "hwj");
        String token = jwtTokenUtil.generateToken(jwtInfo);
        System.err.println(token);

    }

    @Test
    public void test5() throws Exception {
        Tenant tenantUpdate = new Tenant();
        tenantUpdate.setDescription("dashabi");
        tenantUpdate.setId(111);
        Integer tenant = tenantMapper.updateById(tenantUpdate);

    }

    @Test
    public void test6() throws Exception {
        System.out.println(Color.BLANK.getName());

    }

}
