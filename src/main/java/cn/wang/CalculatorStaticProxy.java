package cn.wang;

public class CalculatorStaticProxy implements Calculator {

    private Calculator calculator;

    public CalculatorStaticProxy(Calculator calculator) {
        this.calculator = calculator;
    }

    public int add(int a, int b) {
        System.out.println("加法参数:" + a + " " + b);
        int result = calculator.add(a, b);
        System.out.println("加法结果:" + result);
        return result;
    }

    public int sub(int a, int b) {
        System.out.println("减法参数:" + a + " " + b);
        int result = calculator.sub(a, b);
        System.out.println("减法结果:" + result);
        return result;
    }

    public int mul(int a, int b) {
        System.out.println("乘法参数:" + a + " " + b);
        int result = calculator.mul(a, b);
        System.out.println("乘法结果:" + result);
        return result;
    }

    public int div(int a, int b) {
        System.out.println("除法参数:" + a + " " + b);
        int result = calculator.div(a, b);
        System.out.println("除法结果:" + result);
        return result;
    }
}
