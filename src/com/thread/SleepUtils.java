package com.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by qiaojiange on 2017/5/12.
 */
public class SleepUtils {
    public static final void second(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
