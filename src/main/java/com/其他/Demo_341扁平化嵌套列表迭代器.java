package com.其他;

import java.util.*;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/19 13:54
 */
interface NestedInteger {

    boolean isInteger();

    Integer getInteger();

    List<NestedInteger> getList();
}

public class Demo_341扁平化嵌套列表迭代器 implements Iterator<Integer> {

    LinkedList<NestedInteger> list;

    public Demo_341扁平化嵌套列表迭代器(List<NestedInteger> nestedList) {
        list = new LinkedList<>(nestedList);
    }

    @Override
    public Integer next() {
        return list.removeFirst().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!list.isEmpty() && !list.get(0).isInteger()) {
            List<NestedInteger> nestedIntegerList = list.removeFirst().getList();
            for (int i = nestedIntegerList.size() - 1; i >= 0; i--) {
                list.addFirst(nestedIntegerList.get(i));
            }
        }
        return !list.isEmpty();
    }
}