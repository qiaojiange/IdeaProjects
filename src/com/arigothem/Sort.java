package com.arigothem;

/**
 * Created by qiaojiange on 2017/4/16.
 */
public class Sort {

//    public void adjustMaxHeap(int[] array,int pos,int len){
//        int temp;
//        int child= 2*pos+1;
//        for(temp = array[pos];(2*pos+1)<len;pos = child){
//            System.out.println("pos="+pos);
//
//            if (child<len && array[child] <array[child+1]){
//                child +=1;
//            }
//
//            //找到子元素的最大值的下标
//            if (temp < array[child]){
//                array[pos] = array[child];
//                array[child] = temp;
//            }else{
//                break;
//            }
//        }
//    }
//
//
//    public void heapSort(int[] array) {
//        //建堆的过程
//        for(int i = array.length/2-1;i>=0;i--){
//            adjustMaxHeap(array,i,array.length-1);
//        }
//
//        for (int i = array.length-1;i>1;i--){
//            if(i==1){
//                System.out.println("-----开始停止------");
//            }
//
//            int temp = array[0];
//            array[0] = array[i];
//            array[i] = temp;
//
//            adjustMaxHeap(array,0,i-1);
//        }
//
//    }


}
