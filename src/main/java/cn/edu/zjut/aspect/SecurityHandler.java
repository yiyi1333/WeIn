package cn.edu.zjut.aspect;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.aspectj.lang.ProceedingJoinPoint;

import java.nio.file.AccessDeniedException;
import java.util.Map;
import java.util.Objects;

public class SecurityHandler  {

    private void checkSecurity() throws AccessDeniedException {
        System.out.println("execute --checkSecurity()");
//        if (!Objects.equals("enterpriseAgency", "enterpriseAgency")) {
            throw new AccessDeniedException("无权访问");
//        }
    }
}
