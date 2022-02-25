package cn.wang;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CiglibProxyFactory {
    private CalculatorImp calculatorImp;

    public CiglibProxyFactory(CalculatorImp calculatorImp) {
        this.calculatorImp = calculatorImp;
    }

    public Object getCiglibProxyObject(){
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(CalculatorImp.class);

        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println(method.getName()+"方法的参数:"+ objects);
                Object result = methodProxy.invoke(calculatorImp, objects);
                System.out.println(method.getName()+"方法的结果:"+ result);
                return result;
            }
        });

        Object obj = enhancer.create();
        return obj;
    }

}
