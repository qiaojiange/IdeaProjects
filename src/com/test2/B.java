package com.test2;

/**
 * Created by qiaojiange on 2017/5/18.
 */
public class B  extends Thread{

    public static void main(String[] args) {
//        B b = new B();


        String str1 = "str";
        String str2 = "ing";

        String str3 = "str" + "ing";
        String str4 = str1 + str2;
        System.out.println(str3 == str4);//false

        String str5 = "string";
        System.out.println(str3 == str5);//true
    }

}
