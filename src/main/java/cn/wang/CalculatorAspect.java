package cn.wang;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class CalculatorAspect {

    //在目标对象的目标方法前面添加功能,写一个通知方法，添加前置通知注解
    //前置通知在目标方法执行前执行
    @Before("execution(* *.*(..))")
    public void before(JoinPoint joinPoint){
        System.out.println("前置通知,方法"+joinPoint.getSignature().getName()+
                " 参数:" + Arrays.asList(joinPoint.getArgs()));
    }

    //后置通知，在方法执行完成后执行
    @After("execution(* *.*(..))")
    public void after(JoinPoint joinPoint){
        System.out.println("后置通知,方法"+joinPoint.getSignature().getName()+
                " 参数:" + Arrays.asList(joinPoint.getArgs()));
    }

    //返回通知，在方法执行返回后执行,可以对方法的返回值进行处理
    @AfterReturning(value = "execution(* *.*(..))",returning = "result")
    public void afterReturn(JoinPoint joinPoint,int result){
        System.out.println("返回通知,方法" + " 返回值:" + result);
    }

    //异常通知，在方法抛出异常后执行
    @AfterThrowing(value = "execution(* *.*(..))",throwing = "e")
    public void throwing(JoinPoint joinPoint,Exception e){
        System.out.println("异常通知,方法" + " 异常信息:" + e.getMessage());
    }

    //环绕通知，它可以控制目标方法是否能够执行
    @Around(value = "execution(* *.*(..))")
    public Object around(ProceedingJoinPoint joinPoint){
        System.out.println("环绕通知,方法");

        if(1 == 1){
            try {
                Object result = joinPoint.proceed();
                return result;
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        return null;
    }


}
