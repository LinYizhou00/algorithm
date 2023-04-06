package com.a练习测试;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/13 18:36
 */
class Person {
    int id;

    public Person() {
        this(11);
        System.out.println(this);
    }

    public Person(int id) {
        this.id = id;
    }

    public void say() {
        System.out.println("Person Say");
    }
}

class Stu extends Person {
    int sid;

    public Stu() {
        this(100);
        id = 22;
        System.out.println(this);
    }

    public Stu(int sid) {
        this.sid = sid;
    }

    @Override
    public void say() {
        System.out.println("Stu Say");
    }
}

public class Demo_类加载顺序 {
    public static void main(String[] args) {

        System.out.println("Demo_类加载顺序.main");
        Person person = new Person();
        person.say();
        System.out.println("11 " +person.id);
        Stu stu = new Stu();
        stu.say();
        System.out.println("22 " + stu.id);
        System.out.println(stu.sid);
        Person p = new Stu();
        p.say();


    }
}
