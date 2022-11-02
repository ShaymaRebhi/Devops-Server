package com.esprit.examen.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.springframework.stereotype.Component;
@Component
@Aspect
public class LoggingAspect {

    private static final Logger l = LogManager.getLogger(LoggingAspect.class);

    @Before("execution(* com.esprit.examen.services.SecteurActiviteServiceImpl.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        l.info("In method " + name + " : ");
    }

}
