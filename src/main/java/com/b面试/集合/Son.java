package com.b面试.集合;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/2 18:24
 */
public class Son extends Father implements Cloneable {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    int a = 20;

    public Son() {
        toPrint();
    }

    @Override
    public void toPrint() {
        System.out.println(a);
    }
}
