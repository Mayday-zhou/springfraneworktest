package cn.wang;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//工厂类，具有工厂方法，由工厂方法来生成代理类并返回
public class JdkProxyFactory {
    private Calculator calculator;

    //把目标对象传入到本对象中
    public JdkProxyFactory(Calculator calculator) {
        this.calculator = calculator;
    }

    //工厂方法
    public  Calculator getJdkProxyObject(){
        ClassLoader loader = calculator.getClass().getClassLoader();
        Class<?>[] interfaces = calculator.getClass().getInterfaces();
        InvocationHandler invocationHandler = new InvocationHandler() {
            public Object invoke(Object o, Method method, Object[] objects) throws InvocationTargetException, IllegalAccessException {
                System.out.println(method.getName()+"方法的参数:"+ objects);
                Object result = method.invoke(calculator, objects);//调用了目标对象的所有方法
                System.out.println(method.getName()+"方法的结果:"+ result);
                return result;
            }
        };
        Calculator obj = (Calculator) Proxy.newProxyInstance(loader, interfaces, invocationHandler);
        return obj;
    }

}
