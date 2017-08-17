package com.niuke;

import java.util.Scanner;

/**
 * Created by qiaojiange on 2017/3/23.
 */
public class MainMT1 {
    public static boolean[] flags = new boolean[10001];
    public static void init(){
//        for(int i = 2;i<flags.length/2;i++){
//            for(int j = i;j<flags.length;j+=i){
//                if(!flags[j]){
//                    flags[j] = true;
//                }
//            }
//        }

        boolean isEnd = false;
        int j =2;
        for(int i = 1;i<flags.length/2;i++,j++){

            for(int k = i*j;k<flags.length;k+=j){
                if(k>=flags.length){
                    isEnd =true;
                    break;
                }

                if(!flags[k]){
                    flags[k] = true;
                }

            }
            if (isEnd){
                break;
            }
        }

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        init();
//        while (sc.hasNext

            int a = sc.nextInt();
            int b = sc.nextInt();

            int count = 0;
            for(int i = a;i<=b;i++){
                if(isPrime(i)){
//                    System.out.println(i);
                    count++;
                }
            }
            System.out.println(count);
    }

    private static boolean isPrime(int num) {

        int[] arr = new int[5];
        int i = 0;
        int tmp = num;
        while(tmp>0){
            arr[i] = tmp%10;
            tmp /=10;
            i++;
        }
//        if (num == 19){
//            System.out.println();
//        }
        //计算所有排列组合
        for( i = 0;i<arr.length-1;i++){
            for(int j = i+1;j<arr.length;++j){
                if(arr[i]!=0 && arr[j]!=0){

                    int num1 = arr[i]*10+arr[j];
                    int num2 = arr[j]*10+arr[i];
                    if(arr[i] == arr[j] && !flags[num1]){
                        return true;
                    }

                    if(  !flags[num1]){
                        return true;
                    }
                    if(!flags[num2] ){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
