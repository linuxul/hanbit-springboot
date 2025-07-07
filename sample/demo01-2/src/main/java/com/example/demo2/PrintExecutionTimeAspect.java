package com.example.demo2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PrintExecutionTimeAspect {

    @Before("@annotation(PrintExecuteTime)")
    public void beforePrintExecutionTime(JoinPoint joinPoint) {
        System.out.println("do something before " + joinPoint.toShortString() +
                " with " + joinPoint.getArgs().length + " args.");
    }

    @Around("@annotation(PrintExecuteTime)")
    public Object printExecuteTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        var object = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        System.out.println("execute " + joinPoint.toShortString() +
                " with " + joinPoint.getArgs().length +
                " args in " + executionTime + " ms");
        return object;
    }

    @After("@annotation(PrintExecuteTime)")
    public void afterPrintExecutionTime(JoinPoint joinPoint) {
        System.out.println("do something after " + joinPoint.toShortString() +
                " with " + joinPoint.getArgs().length + " args.");
    }

    @AfterReturning(
            pointcut = "@annotation(PrintExecuteTime)",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("afterReturning " + joinPoint.toShortString() +
                " with " + joinPoint.getArgs().length +
                " args returning " + result.toString());
    }

    @AfterThrowing(
            pointcut = "@annotation(PrintExecuteTime)",
            throwing = "ex"
    )
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) { ㅍㅍㅅ
        System.out.println("afterThrowing " + joinPoint.toShortString() +
                " with " + joinPoint.getArgs().length +
                " args throwing " + ex.toString());
    }
}
