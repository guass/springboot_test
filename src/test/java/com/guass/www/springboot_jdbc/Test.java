package com.guass.www.springboot_jdbc;

public class Test {

    public static void main(String[] args) {
//        System.out.println("gggg");
//
//        AiBase aiBase =  new ST();
//
//        ((ST) aiBase).f4();

        String ss = "aaa";
        String ss2 = ss;

        System.out.println("ss " + ss);
        System.out.println("ss2 " + ss2);

        ss = "111";

        System.out.println("ss " + ss);
        System.out.println("ss2 " + ss2);

    }

    @org.junit.Test
    public void test(){
        System.out.println("1111");
    }
}
