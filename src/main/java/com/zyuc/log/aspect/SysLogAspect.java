package com.zyuc.log.aspect;

/**
 * @author hongwj
 * @date 2020/12/25
 **/

import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;

import com.zyuc.log.annotation.MyLog;
import com.zyuc.log.entity.SysLog;
import com.zyuc.log.mapper.ISysLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
@Slf4j
public class SysLogAspect {

    @Autowired
    private  HttpServletRequest request;


    @Autowired
    private ISysLogMapper sysLogService;


    @Pointcut("@annotation(com.zyuc.log.annotation.MyLog)")
    public void logPointCut() {
    }

    @AfterReturning("logPointCut()")
    public void saveSysLog(JoinPoint joinPoint) {

        log.info("日志保存开始---->");
        //保存日志
        SysLog sysLog = new SysLog();

        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();

        //获取操作
        MyLog myLog = method.getAnnotation(MyLog.class);
        if (myLog != null) {
            String value = myLog.value();
            sysLog.setOperation(value);
        }

        //获取请求的方法名
        String methodName = method.getName();
        sysLog.setMethod(methodName);

        //请求的参数
        Object[] args = joinPoint.getArgs();
        //将参数所在的数组转换成json
        sysLog.setParams(null);

        sysLog.setCreateDate(new Date());
        //获取用户名
        sysLog.setUsername(request.getSession().getId());
        sysLog.setIp(ServletUtil.getClientIP(request));

        //调用service保存SysLog实体类到数据库
        sysLogService.insert(sysLog);
        log.info("保存日志成功");
    }

}
