package com.kemalkeskin.libary.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class LoggerAspect {

    Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.kemalkeskin.libary.repository.*.*(..))")
    private void getRepositoryLayer() {

    }

    @Pointcut("execution(* com.kemalkeskin.libary.business.*.*(..))")
    private void getServiceLayer() {

    }

    @Pointcut("execution(* com.kemalkeskin.libary.controller.*.*(..))")
    private void getControllerLayer() {

    }

    @Pointcut("getRepositoryLayer() || getServiceLayer() || getControllerLayer()")
    private void getAllLayer() {

    }

    @Before("getAllLayer()")
    public void beforeAspect(JoinPoint joinPoint) {

        String result = joinPoint.getSignature().toShortString();
        logger.info("Çağıran kullanıcı username= " + getCurrentName() + "|| Before Result =" + result);

        Object[] args = joinPoint.getArgs();
        for (Object arg : args)
            System.out.println("argument: " + arg);
    }

    @AfterReturning(pointcut = "getAllLayer()", returning = "result")
    public void afterAspect(JoinPoint joinPoint, Object result) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("Çağıran kullanıcı username= " + getCurrentName() + "|| After Returning=   " + method);

    }

    @AfterThrowing(pointcut = "getAllLayer()", throwing = "exception")
    public void afterThrowingAspect(Exception exception) {

        logger.info("Çağıran kullanıcı username= " + getCurrentName() + "|| Aspect Exception= " + exception.getMessage());

    }


    private String getCurrentName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated()) {
            Object prinicpal = auth.getPrincipal();
            return ((UserDetails) prinicpal).getUsername() + ((UserDetails) prinicpal).getAuthorities();
        }
        return "sign in please";
    }
}
//securitycontextholder
//kimlik bilgileri ve oturum bilgileri bulunur içinde
//getName()=>kullanıcının adını döner
//getAuthorities()=> kullanıcının sahip olduğu rolleri ve yetkileri döndürür
//getPrinicipal()=> kullanıcının temel bilgileri bulunur(ad,eposta vs..)
//getCredentials()=> kullanıcının kimlik doğrulama bilgileri temsil eder(şifre gibi)
// kullanma zamanları
// eğer kullanıcya özel işlem yapılcaksa
//yetkilendirme kontrolleri gerektiğinde ve log ve izleme