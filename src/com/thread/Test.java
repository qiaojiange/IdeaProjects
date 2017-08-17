package com.thread;

import com.niuke.ListNode;

import java.util.*;

/**
 * Created by qiaojiange on 2017/5/15.
 */
public class Test {

    private  int i ;
    private int j;

    public Test(int i) {
        this.i = i;
    }

    public static void main(String[] args) {

        Map<Integer,Integer> map = new HashMap<>();
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 100; i++) {
            int val = random.nextInt(10);
            if (map.get(val)!=null){
                map.put(val,map.get(val)+1);
            }else{
                map.put(val,1);
            }

        }
        for(Map.Entry<Integer,Integer> en:map.entrySet()){
            System.out.println(en.getKey() + ":" + en.getValue());
        }

        System.out.println("----------------------");
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
//        for(Map.Entry<Integer,Integer> en:map.entrySet()){
//            list.add(en);
//        }
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                int val1 = o1.getValue();
                int val2 = o2.getValue();
                if (val1>val2){
                    return 1;
                }else if(val1 == val2){
                    return 0;
                }
                return -1;
            }
        });

        for(Map.Entry en:list){
            System.out.println(en.getKey() + ":" + en.getValue());
        }


//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i <100; i++) {
//            list.add(i);
//        }
//
//        Collections.sort(list,new Comparator<Integer>(){
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if (o1 > o2){
//                    return 1;
//                }else if(o1 == o2){
//                    return 0;
//                }
//                return -1;
//            }
//        });
//
//        for (Integer i : list) {
//            System.out.println(i);
//        }
    }


    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }

        if(obj instanceof com.niuke.Test){
            Test t2 = (Test)obj;
            if (t2.i == this.i){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {

        return i*3+j*4;
    }
}
