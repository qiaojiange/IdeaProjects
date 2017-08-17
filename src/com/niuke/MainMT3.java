package com.niuke;

import java.util.Scanner;

/**
 * Created by qiaojiange on 2017/3/23.
 */
public class MainMT3 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String[] strs = str.split(" ");

        int count1 = 0;
        int count2 = 0;
        char[] str1 = strs[0].toCharArray();
        char[] str2 = strs[1].toCharArray();

        for(int i = 0;i<str1.length;i++){
            if ((str1[i] == 'A' && str2[i] == 'T') || (str1[i] == 'T' && str2[i] == 'A') ||(str1[i] == 'G' && str2[i] == 'C') ||(str1[i] == 'C' && str2[i] == 'G')) {
                continue;
            }else{
                count1++;
            }
        }
        System.out.println(count1);
    }
}
