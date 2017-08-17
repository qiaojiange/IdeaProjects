package com.arigothem;

import java.awt.*;
import java.util.FormatFlagsConversionMismatchException;

/**
 * Created by qiaojiange on 2017/4/16.
 */
public class MaxHeap {
    int[] heap;
    int heapsize;

    public MaxHeap(int[] heap){
        this.heapsize = heap.length;
        this.heap = heap;
    }

    public int left(int i){
        return 2*i+1;
    }

    public int right(int i){
        return 2*i+2;
    }
    public void maxify(int i){
        int l = left(i);
        int r = right(i);

        int largest = i;
        if (l<this.heapsize && heap[l]> heap[i]){
            largest = l;
        }
        if (r<this.heapsize && heap[r]>heap[largest]){
            largest = r;
        }

        if (largest == i || largest>= this.heapsize){
            return ;
        }
        int tmp = heap[largest];
        heap[largest] = heap[i];
        heap[i] = tmp;

        maxify(largest);
    }
//    大顶堆
    public void buildHeap(){
        for (int i = this.heapsize/2-1;i>=0;i-- ){
            maxify(i);
        }
    }

    public void heapSort(){
        buildHeap();
        for(int i = heap.length-1;i>=0;i--){
//            将最大的交换到最后
            int tmp = heap[0];
            heap[0] = heap[i];
            heap[i] = tmp;

            heapsize--;
            maxify(0);
        }
    }

}
