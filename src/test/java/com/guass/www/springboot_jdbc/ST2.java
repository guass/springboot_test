package com.guass.www.springboot_jdbc;

public class ST2 extends AiBase {

    @Override
    public void f1() {
        System.out.println("2222");
    }

    @Override
    public int f2() {

       return 0;
    }

    @Override
    public String f3() {
        String ss = "aaa";
        String ss2 = ss;

        System.out.println("ss " + ss);
        System.out.println("ss2 " + ss2);

        ss = "111";

        System.out.println("ss " + ss);
        System.out.println("ss2 " + ss2);
        return null;
    }
}
