package com.b面试.集合;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/15 23:35
 */

public class DemoC {
    public static void main(String[] args) throws CloneNotSupportedException {
        String s = "abc";
        String abc = "abc";
        System.out.println(abc == s);
        System.out.println("DemoC.main");
        Son o = new Son();
        System.out.println(o);
        Object clone = o.clone();
        System.out.println(clone);
        int[] ints = {1, 2, 3};
        int[] clone1 = ints.clone();
        ArrayList<Son> sons = new ArrayList<>();
        sons.add(o);
        Object clone2 = sons.clone();
        o.a=545;


    }


}
