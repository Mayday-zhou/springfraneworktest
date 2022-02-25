package cn.wang;

import org.springframework.stereotype.Component;

@Component
public class CalculatorImp implements Calculator  {
    public int add(int a, int b) {
        System.out.println("add 方法开始");
        int c = a + b;
        System.out.println("add 方法结束");
        return c;
    }

    public int sub(int a, int b) {
        int c = a - b;
        return c;
    }

    public int mul(int a, int b) {
        int c = a * b;
        return c;
    }

    public int div(int a, int b) {
        int c = a / b;
        return c;
    }
}
