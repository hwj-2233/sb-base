package com.zyuc.log.aspect;

/**

 *@author hongwj

 *@date 2020/12/25

 **/

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;

import com.zyuc.log.annotation.MyLog;
import com.zyuc.log.entity.SysLog;
import com.zyuc.log.mapper.ISysLogMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 系统日志：切面处理类
 */
@Aspect
@Component
public class SysLogAspect {

    @Autowired
    private ISysLogMapper sysLogService;


    @Pointcut("@annotation(com.zyuc.log.annotation.MyLog)")
    public void logPointCut() {
    }

    @AfterReturning("logPointCut()")
    public void saveSysLog(JoinPoint joinPoint) {
        System.out.println("切面。。。。。");
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
            sysLog.setOperation(value);//保存获取的操作
        }

        //获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        //获取请求的方法名
        String methodName = method.getName();
        sysLog.setMethod(className + "." + methodName);

        //请求的参数
        Object[] args = joinPoint.getArgs();
        //将参数所在的数组转换成json
        String params = "null";
        sysLog.setParams(params);

        sysLog.setCreateDate(new Date());
//        //获取用户名
//        sysLog.setUsername(ShiroUtils.getUserEntity().getUsername());
//        //获取用户ip地址
//        HttpServletRequest request = HttpUtil.getHttpServletRequest();
//        sysLog.setIp(IPUtils.getIpAddr(request));

        //调用service保存SysLog实体类到数据库
        sysLogService.insert(sysLog);
    }

}
