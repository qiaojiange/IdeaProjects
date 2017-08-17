package com.arigothem;

/**
 * Created by qiaojiange on 2017/4/16.
 */
public class TestSort {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        int[] array = new int[]{4,5,7,3,5,6,7,8,9,4};

        for(int i = 0;i<array.length;i++){
            if (!map.contains(array[i])){
                map.put(array[i],1);
            }else{
                map.put(array[i],map.get(array[i])+1);
            }
        }

        System.out.println("-------------------------");
        for (int i = 0; i < array.length; i++) {
            System.out.println(""+array[i]+" = "+map.get(array[i]) );
        }

    }

}
