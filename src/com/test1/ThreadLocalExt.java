package com.test1;

import java.util.Date;

/**
 * Created by qiaojiange on 2017/5/29.
 */
public class ThreadLocalExt extends ThreadLocal {
    @Override
    protected Object initialValue() {
        return  new Date().getTime();
    }
}


