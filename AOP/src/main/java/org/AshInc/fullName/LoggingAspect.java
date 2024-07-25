package org.AshInc.fullName;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;

@Component
@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());
    {
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        handler.setFormatter(new SimpleFormatter());
        //logger.addHandler(handler);
    }

    @Pointcut("within(org.AshInc.fullName.FullName)")
    public void stringProcessingMethods(){}

    @After("stringProcessingMethods()")
    public void logMethodCall(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        logger.log(Level.INFO, "название метода: " + methodName);
    }

    @AfterReturning(pointcut = "execution(public String org.AshInc.fullName.FullName.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.log(Level.INFO, "возвращенное значение: " + result.toString());
    }

    @Around("@annotation(LogExecutionTime)")
    public Object logExecutiontime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        logger.log(Level.INFO, joinPoint.getSignature() + " выполнен за " + executionTime + " мс");
        return proceed;
    }
}
