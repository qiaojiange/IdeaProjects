package com.niuke;

import org.hamcrest.collection.IsArrayContaining;

import java.util.Scanner;

/**
 * Created by qiaojiange on 2017/3/23.
 */
public class MainMT2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        if (n == 1){
            System.out.println(1);
            return ;
        }

        int count = 0;
        int i =0;
        int j = i+1;

//        判断是递增，还是递减
        boolean isUp = arr[i]<arr[j]?true:false;

        boolean isCannot = arr[i]==arr[j]?true:false;;

        while(i<j && j<arr.length){
            if(isCannot && arr[i]<arr[j]){
                isUp = true;
            }
            if(isCannot && arr[i] > arr[j]){
                isUp = false;
            }

//            1.原来递增，现在递减
            if(isUp && arr[j-1]>arr[j]){
                i = j;
                j = j+1;
                count++;
                if(j>= arr.length){
                    break;
                }
                isUp = arr[i]<arr[j]?true:false;
                isCannot = arr[i]==arr[j]?true:false;
                continue;
            }

            if(!isUp && arr[j-1]<arr[j]){
                i = j;
                j = j+1;
                count++;
                if(j>= arr.length){
                    break;
                }
                isUp = arr[i]<arr[j]?true:false;
                isCannot = isCannot = arr[i]==arr[j]?true:false;
                continue;
            }
            j++;
        }


//        for(int j = 1;j<arr.length-1;j++){
//            if ( (arr[j-1] >arr[j] )&& arr[j]<arr[j+1]){
//                count++;
//            }
//
//            if ( arr[j-1] ==arr[j] && arr[j]< arr[j+1]){
//                int k = j-1;
//                while (k>=0){
//                    if(arr[k]>arr[j])
//                }
//                count++;
//            }
//
//            if ( arr[j-1] <arr[j] && arr[j]> arr[j+1]){
//                count++;
//            }
//
//            if ( arr[j-1] <arr[j] && arr[j]== arr[j+1]){
//                count++;
//            }
//
//
//        }

        System.out.println((count+1));

    }


}
