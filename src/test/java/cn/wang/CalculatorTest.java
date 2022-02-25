package cn.wang;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalculatorTest {

    @Test
    public void test1(){
        CalculatorImp calculator = new CalculatorImp();
        int result = calculator.add(5,7);
        System.out.println("加法:" + result);
        result = calculator.sub(5,7);
        System.out.println("减法:" + result);
        result = calculator.mul(5,7);
        System.out.println("乘法:" + result);
        result = calculator.div(9,7);
        System.out.println("除法:" + result);
    }

    @Test
    public void test2(){
       /* Calculator calculator = new CalculatorStaticProxy(new CalculatorImp());
        int result = calculator.add(5,7);
        result = calculator.sub(5,7);
        result = calculator.mul(5,7);
        result = calculator.div(9,7);*/
    }

    @Test
    public void test3(){
       /* JdkProxyFactory factory = new JdkProxyFactory(new CalculatorImp());
        Calculator proxyObject = factory.getJdkProxyObject();
        int result = proxyObject.add(2, 1);
        System.out.println(result);
        result = proxyObject.sub(2, 1);
        System.out.println(result);
        result = proxyObject.mul(2, 1);
        System.out.println(result);
        result = proxyObject.div(2, 1);
        System.out.println(result);*/

    }

    @Test
    public void test4(){
        CiglibProxyFactory factory = new CiglibProxyFactory(new CalculatorImp());
        CalculatorImp proxyObject = (CalculatorImp) factory.getCiglibProxyObject();
        int result = proxyObject.add(2, 1);
        System.out.println(result);
        result = proxyObject.sub(2, 1);
        System.out.println(result);
        result = proxyObject.mul(2, 1);
        System.out.println(result);
        result = proxyObject.div(2, 1);
        System.out.println(result);

    }

    @Test
    public void test5(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

        Calculator calculator = ac.getBean(Calculator.class);

        int result = calculator.add(5, 2);
        System.out.println(result);
        result = calculator.sub(5, 2);
        System.out.println(result);
        result = calculator.mul(5, 2);
        System.out.println(result);
        result = calculator.div(5, 2);
        System.out.println(result);


    }

}
