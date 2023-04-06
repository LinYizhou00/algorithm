package com.图;

import java.util.ArrayList;
import java.util.*;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/23 19:09
 */

public class Demo_990等式方程的可满足性 {
    public static void main(String[] args) {
        System.out.println(new Demo_990等式方程的可满足性().equationsPossible(new String[]{"a==b", "b==c", "a==c"}));
    }

    public boolean equationsPossible(String[] equations) {
        UF uf = new UF(26);
        List<String> list = new ArrayList<>();
        for (String equation : equations) {
            char a = equation.charAt(0);
            char b = equation.charAt(3);
            char fuHao = equation.charAt(1);
            if (fuHao == '=') {
                uf.union(a - 'a', b - 'a');
            } else {
                list.add(equation);
            }
        }
        for (String equation : list) {
            char a = equation.charAt(0);
            char b = equation.charAt(3);
            if (uf.isConnect(a - 'a', b - 'a')) {
                return false;
            }
        }
        return true;


    }
}
