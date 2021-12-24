package cn.edu.zjut.aspect;


import cn.edu.zjut.annotation.MyLog;
import cn.edu.zjut.po.Log;
import cn.edu.zjut.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.sql.Time;
import java.util.Date;


/**
 * @author hydrogen_zyx
 */
@Component
@Aspect
public class LogAspect {

    @Autowired
    private LogService logService;

    public LogService getLogService() {
        return logService;
    }

    public void setLogService(LogService logService) {
        this.logService = logService;
    }

    //切入点是:自定义注解加在哪个方法上,哪个方法就是切入点
    @Before("@annotation(cn.edu.zjut.annotation.MyLog)")
    public void Log(JoinPoint joinPoint) {
        //1.获取目标方法名
        String MethodName = joinPoint.getSignature().getName();

        //2.获得目标方法上的注解的值
        Object target = joinPoint.getTarget();  //目标方法所在类的对象


        //3.时间
        Date date = new Date();

        //4.ip
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = request.getRemoteHost();
        System.out.println(">>>>>>>>>>>>>>" + MethodName);
        System.out.println(">>>>>>>>>>>>>>" + date);
        System.out.println(">>>>>>>>>>>>>>" + ip);
        Log log = new Log();
        log.setOpeDate(date);
        Time time = new Time(0);
        time.setTime(date.getTime());
        log.setTime(time);
        log.setOpeIp(ip);
        log.setOpeMethod(MethodName);
        log.setName((String) request.getSession().getAttribute("name"));
        log.setType((String) request.getSession().getAttribute("type"));
        logService.insert(log);
    }
}

