package com.arigothem;

import java.util.*;

/**
 * Created by qiaojiange on 2017/4/16.
 */

public class SimpleHashMap<K,V> extends AbstractMap<K,V> {

    static final int SIZE = 997;

    LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[SIZE];

    public V put(K key,V value){
        V oldValue = null;
        int index = Math.abs(key.hashCode())%SIZE;

        if (buckets[index] == null){
            buckets[index] = new LinkedList<>();
        }

        MapEntry<K,V> pair = new MapEntry<K,V>(key,value);

        boolean found = false;
        for (MapEntry<K,V> entry:buckets[index]){
            if (entry.getKey().equals(key)){
                entry.setValue(value);
                oldValue = entry.getValue();
                found = true;
                break;
            }
        }

        if (!found){
            buckets[index].add(pair);
        }
        return oldValue;
    }

    public V get(Object key){
        int index = Math.abs(key.hashCode())%SIZE;
        if (buckets[index] == null) return null;

        for (MapEntry<K,V> iPair:buckets[index]){
            if (iPair.getKey().equals(key)){
                return iPair.getValue();
            }
        }
        return null;
    }

    public boolean contains(Object key){
        int index = Math.abs(key.hashCode())%SIZE;

        if (buckets[index] == null){
            return false;
        }

        for(MapEntry<K,V> entry:buckets[index]){
            if (entry.getKey().equals(key)){
                return true;
            }
        }

        return false;
    }

    public Set<Map.Entry<K,V>> entrySet(){
        Set<Map.Entry<K,V>> set = new HashSet<>();
        for (LinkedList<MapEntry<K,V>> bucket:buckets){
            if (bucket == null) continue;;
            for(MapEntry<K,V> mpair : bucket){
                set.add(mpair);
            }
        }
        return set;
    }


    public static void main(String[] args) {
//        SimpleHashMap<String,String> m = new SimpleHashMap<>();
//        m.putAll();
        SimpleHashMap<Integer,Integer> m = new SimpleHashMap<>();
        int[] array = new int[]{4,4,7,3,5,6,7,8,9,4};
//        int[] array = new int[]{4,4,4};

        for(int i:array){
            if ( null == m.get(i) ){
                m.put(i,1);
            }else{
                m.put( i, m.get(i)+1 );
            }
        }

//        System.out.println(m);
        for(int i:array){
            System.out.println(""+i+"="+m.get(i));
        }
    }

}
