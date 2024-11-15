package com.kemalkeskin.libary.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class LoggerAspect {

    Logger logger=Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.kemalkeskin.libary.repository.*.*(..))")
    private void getRepositoryLayer(){

    }

    @Pointcut("execution(* com.kemalkeskin.libary.business.*.*(..))")
    private void getServiceLayer(){

    }

    @Pointcut("execution(* com.kemalkeskin.libary.controller.*.*(..))")
    private void getControllerLayer(){

    }

    @Pointcut("getRepositoryLayer() || getServiceLayer() || getControllerLayer()")
    private void getAllLayer(){

    }

    @Before("getAllLayer()")
    public void beforeAspect(JoinPoint joinPoint){

        String result=joinPoint.getSignature().toShortString();
        logger.info("Before Result ="+result);

        Object[] args=joinPoint.getArgs();
        for (Object arg :args)
            System.out.println("argument: "+arg);
    }

    @AfterReturning(pointcut="getAllLayer()",returning = "result")
    public void afterAspect(JoinPoint joinPoint,Object result){
        String method=joinPoint.getSignature().toShortString();
        logger.info("After Returning=   "+method);

    }

    @AfterThrowing(pointcut="getAllLayer()",throwing = "exception")
    public void afterThrowingAspect(Exception exception){

        logger.info("Aspect Exception= "+exception.getMessage());

    }


}
