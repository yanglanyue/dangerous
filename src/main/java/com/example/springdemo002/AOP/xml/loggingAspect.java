package com.example.springdemo002.AOP.xml;
/*
* 日志切面
* 1、将此类放入IOC容器中：@Component
* 2、再将此类申明为一个切面：@Aspect
* 3、在具体要执行的方法上申明相关操作顺序：@Before("")
* 4、在配置文件中配置AOP自动代理，使切面起作用：<aop:aspectj-autoproxy></aop:aspectj-autoproxy>
* */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import java.util.Arrays;
import java.util.List;


public class loggingAspect {

    public void declareJointPointExpression(){}

    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> arg = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method：" + methodName + " /begins with args：" + arg);
    }

    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method：" + methodName);
    }

    public void afterReturning(JoinPoint joinPoint,Object result){
        System.out.println("ends：" + result);
    }

    public void afterThrowing(JoinPoint joinPoint,Exception ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method：" + methodName + " /occurs exection：" + ex);
    }

    public Object aroundMethod(ProceedingJoinPoint pjp){

        Object result = null;
        String methodName = pjp.getSignature().getName();

        try {
            System.out.println("Method：" + methodName + " /with arguments:" + Arrays.asList(pjp.getArgs()));
            result = pjp.proceed();
            System.out.println("Method ends with：" + result);
        } catch (Throwable throwable) {
            System.out.println("Method：" + methodName + " /occurs exection：" + throwable);
            throw new RuntimeException(throwable);
        }

        System.out.println("Method：" + methodName + " ends");

        return result;
    }
}
