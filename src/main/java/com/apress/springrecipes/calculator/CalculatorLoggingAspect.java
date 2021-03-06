package com.apress.springrecipes.calculator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

/**
 * Created by Matrix on 21.10.2014.
 */
@Aspect
@Order(1) //or implements Ordered
public class CalculatorLoggingAspect {
    private static Logger log = LoggerFactory.getLogger(CalculatorLoggingAspect.class);

    @Pointcut("execution(* *.*(..))")
    private void loggingOperation() {
    }

    //@Before("execution(* *.*(..)) && target(target) && args(a, b)")
    @Before("CalculatorPointcuts.parameterPointcut(target, a, b)")
    public void logParameter(Object target, double a, double b) {
        log.info("Target class : " + target.getClass().getName());
        log.info("Arguments : " + a + ", " + b);
    }

    //@Before("execution(* ArithmeticCalculator.add(..))")
    public void logBefore() {
        //log.info("{}", "The method add() begins");
    }

    //@Before("CalculatorPointcuts.loggingOperation()")
    @Before("@annotation(LoggingRequired)")
    public void logJoinPoint(JoinPoint joinPoint) {
        log.info("logging aspect");
        /*log.info("Join point kind : "
                + joinPoint.getKind());
        log.info("Signature declaring type : "
                + joinPoint.getSignature().getDeclaringTypeName());
        log.info("Signature name : "
                + joinPoint.getSignature().getName());
        log.info("Arguments : "
                + Arrays.toString(joinPoint.getArgs()));
        log.info("Target class : "
                + joinPoint.getTarget().getClass().getName());
        log.info("This class : "
                + joinPoint.getThis().getClass().getName());*/
    }

    /*@Before("execution(* *.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("The method " + joinPoint.getSignature().getName()
                + "() begins with " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("execution(* *.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        log.info("The method " + joinPoint.getSignature().getName()
                + "() ends");
    }

    @AfterReturning(
            pointcut = "execution(* *.*(..))",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("The method " + joinPoint.getSignature().getName()
                + "() ends with " + result);
    }

    @AfterThrowing(
            pointcut = "execution(* *.*(..))",
            throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.error("An exception " + e + " has been thrown in "
                + joinPoint.getSignature().getName() + "()");
    }

    @AfterThrowing(
            pointcut = "execution(* *.*(..))",
            throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint,
                                 IllegalArgumentException e) {
        log.error("Illegal argument " + Arrays.toString(joinPoint.getArgs())
                + " in " + joinPoint.getSignature().getName() + "()");
    }*/

   /* @Around("execution(* *.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("The method " + joinPoint.getSignature().getName()
                + "() begins with " + Arrays.toString(joinPoint.getArgs()));
        try {
            Object result = joinPoint.proceed();
            log.info("The method " + joinPoint.getSignature().getName()
                    + "() ends with " + result);
            return result;
        } catch (IllegalArgumentException e) {
            log.error("Illegal argument "
                    + Arrays.toString(joinPoint.getArgs()) + " in "
                    + joinPoint.getSignature().getName() + "()");
            throw e;
        }
    }*/
}
