package com.example.springdemo002.AOP.Impl;
/*
* 日志切面
* 1、将此类放入IOC容器中：@Component
* 2、再将此类申明为一个切面：@Aspect
* 3、在具体要执行的方法上申明相关操作顺序：@Before("")
* 4、在配置文件中配置AOP自动代理，使切面起作用：<aop:aspectj-autoproxy></aop:aspectj-autoproxy>
* */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Order(2)//切面优先级，数字越小优先级越高
@Aspect
@Component
public class loggingAspect {

    /*
     * 定义一个用于声明切入点表达式的方法，通常该方法中不必添加任何代码
     * @Pointcut()用于申明切入点表达式
     * 后面的其他通知直接使用方法名来引用申明的切入点表达式
     * */
    @Pointcut("execution(public int com.example.springdemo002.AOP.Impl.ArithmeticCalculator.*(int,int))")
    public void declareJointPointExpression(){}

    //目标方法执行之前执行
    @Before("declareJointPointExpression()")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> arg = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method：" + methodName + " /begins with args：" + arg);
    }

    //目标方法执行之后执行（无论是否出现异常）
    @After("declareJointPointExpression()")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method：" + methodName);
    }

    //后置返回，在目标方法正常（未出现异常）执行结束之后执行的代码
    @AfterReturning(value = "declareJointPointExpression()",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        System.out.println("ends：" + result);
    }

    //在目标方法出现异常时会执行的代码，可以访问到异常对象，且可以指定在出现特定异常时再执行通知代码
    @AfterThrowing(value = "declareJointPointExpression()",
            throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint,Exception ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method：" + methodName + " /occurs exection：" + ex);
    }

    /*
    * 环绕通知（相当于动态代理的全过程）
    * 需要传入ProceedingJoinPoint类型的参数，此参数决定是否执行目标方法
    * 环绕通知必须有返回值，返回值为目标方法的返回值
    * */
    @Around("declareJointPointExpression()")
    public Object aroundMethod(ProceedingJoinPoint pjp){

        Object result = null;
        String methodName = pjp.getSignature().getName();

        //执行目标方法
        try {
            //前置通知
            System.out.println("The method：" + methodName + " /with arguments:" + Arrays.asList(pjp.getArgs()));
            //开始执行
            result = pjp.proceed();
            //返回通知
            System.out.println("The method ends with：" + result);
        } catch (Throwable throwable) {
            //异常通知
            //throwable.printStackTrace();
            System.out.println("The method：" + methodName + " /occurs exection：" + throwable);
            //抛出异常
            throw new RuntimeException(throwable);
        }

        //后置通知
        System.out.println("The method：" + methodName + " ends");

        return result;
    }
}
