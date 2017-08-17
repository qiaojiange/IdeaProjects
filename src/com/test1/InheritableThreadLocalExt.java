package com.test1;

import java.util.Date;

/**
 * Created by qiaojiange on 2017/5/29.
 */
public class InheritableThreadLocalExt extends InheritableThreadLocal {
    @Override
    protected Object initialValue() {
        return new Date().getTime();
    }

    @Override
    protected Object childValue(Object parentValue) {
        return parentValue+ " add in child thread";
    }
}
