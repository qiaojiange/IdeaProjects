package com.thread;

import sun.util.locale.provider.TimeZoneNameUtility;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * Created by qiaojiange on 2017/5/16.
 */
public class Profiler {
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>(){
        @Override
        protected Long initialValue() {
            System.out.println("initialValue ");
            return System.currentTimeMillis();
        }
    };


    public static void main(String[] args) throws InterruptedException {
//        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("cost: "+Profiler.end()+" mills");
    }

    private static void begin() {
        System.out.println("begin() ");
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }



    private static Long end() {
        System.out.println("end() ");
        return System.currentTimeMillis()-TIME_THREADLOCAL.get();
    }


}
