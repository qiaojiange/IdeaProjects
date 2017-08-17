package com.niuke;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by qiaojiange on 2017/3/23.
 */
public class MainMT4 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] num = new int[n];
        for(int i = 0;i<n;i++){
            num[i] = sc.nextInt();
        }

        Arrays.sort(num);

        int interval = 0;
        int diff = 0;
        for (int i = 1;i<num.length;i++){
            if( (num[i]-num[i-1]) == 1){
                continue;
            }else if(num[i]-num[i-1]==2){
                interval++;
                diff = num[i]-1;
            }else{
                System.out.println("mistake");
                return;

            }

        }
        if (interval == 0){
            if (n == 1 && num[0]==1 ){
                System.out.println(num[0]+1);

            }else if(n == 1 && num[0]==1000000000){
                System.out.println(num[0]-1);

            }else{
                if (num[0] == 1){
                    System.out.println((num[n-1]+1));
                }else{
                    System.out.print(num[0]-1);
                    System.out.println(" "+(num[n-1]+1));
                }

            }
        }else if (interval == 1){
            System.out.println(diff);
        }else{
            System.out.println("mistake");
        }

    }
}
