package com.a练习测试;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/30 10:07
 */
class User {
    private String str;

    public void toStr() {
        System.out.println(this);
        System.out.println(new Object());
    }

    public void toStr1() {
        toStr();
    }
}

public class Demo_A {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE - 2);
        //System.out.println(  Integer.valueOf(12) == Integer.valueOf(12));
        //System.out.println(Integer.compare(12125, 1225));
        //System.out.println(null == new Object());
        //System.out.println(3 >> 1);
        //new User().toStr();


    }

    public static void dg(int n) {

        int i = 6;
        System.out.println(i);
        i = i - 6;
        dg(n);

    }
}
