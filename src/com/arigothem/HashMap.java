package com.arigothem;

import java.util.*;

/**
 * Created by qiaojiange on 2017/4/16.
 */
public class HashMap{
    static class Entry{
       public  int k;
        public int v;

        public Entry(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }

    ArrayList<Entry>[] array = new ArrayList[100];

    int count = 0;

    public Integer get(int k){
        int hash = hash(k);
        if (array[hash]!=null){
            for(Entry en:array[hash]){
                if (en.k == k){
                    return en.v;
                }
            }
            return null;
        }
        return null;
    }

    private int hash(int k){
        return k%array.length;
    }

    public void put(int k,int v){
        int hash = hash(k);
        if (array[hash] == null){
            array[hash] = new ArrayList<>();
        }
        boolean isHave = false;
        for (Entry en:array[hash]){
            if (en.k == k){
                isHave =true;
                en.v = v;
                break;
            }
        }

        if (!isHave){
            array[hash].add(new Entry(k,v));
            count++;
        }
    }

    public int size(){
        return count;
    }

    public boolean contains(int k){
        int index = hash(k);
        if (array[k] == null){
            return false;
        }

        for (Entry en:array[k]){
            if (en.k == k){
                return true;
            }
        }
        return false;
    }



}