package org.AshInc.trafficLight;

import org.AshInc.fullName.LoggingAspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@Aspect
public class TrafficAspect {

    @Autowired
    Driver driver;

    private Logger logger = Logger.getLogger(TrafficAspect.class.getName());
    @Pointcut("within(org.AshInc.trafficLight.TrafficLight)")
    public void trafficLightMethods(){}

    @After("trafficLightMethods()")
    public void logMethodCall(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        logger.log(Level.INFO, "название метода: " + methodName);
    }

//    @AfterReturning(pointcut = "execution(public String org.AshInc.trafficLight.TrafficLight.switchRed())", returning = "result")
//    public void stopDriver(JoinPoint joinPoint, Object result) {
//        driver.stop();
//    }
//
//    @AfterReturning(pointcut = "execution(public String org.AshInc.trafficLight.TrafficLight.switchYellow())", returning = "result")
//    public void readyDriver(JoinPoint joinPoint, Object result) {
//        driver.ready();
//    }

    @AfterReturning(pointcut = "execution(public String org.AshInc.trafficLight.TrafficLight.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        String name = (String)result;
        switch(name){
            case "red":{
                driver.stop();
                break;
            }
            case "yellow":{
                driver.ready();
                break;
            }
            case "green":{
                driver.go();
            }
        }
    }
}
