package com.huawei;

import java.util.Scanner;

/**
 * Created by qiaojiange on 2017/8/16.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        while(n>0){
            count++;
            n = n&(n-1);
        }
        System.out.println(count);
    }
}
