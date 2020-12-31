package com.zyuc.log;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.zyuc.log.constant.Color;
import com.zyuc.log.entity.SysLog;
import com.zyuc.log.entity.Tenant;
import com.zyuc.log.mapper.ISysLogMapper;
import com.zyuc.log.mapper.ITenantMapper;
import com.zyuc.log.service.MessageService;
import com.zyuc.log.util.IJWTInfo;
import com.zyuc.log.util.JWTInfo;
import com.zyuc.log.util.JwtTokenUtil;
import com.zyuc.log.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.time.LocalDate;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LogApplicationTests {
    
    @Test
    public void contextLoads() {
        System.err.println(LocalDate.now().toString());
        
    }

}
