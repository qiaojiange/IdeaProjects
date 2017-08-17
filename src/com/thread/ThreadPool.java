package com.thread;

/**
 * Created by qiaojiange on 2017/5/17.
 */
public interface ThreadPool<Job extends Runnable> {
//    执行job
    void execute(Job job);
//    关闭线程
    void shutdown();
//    添加工作者线程
    void addWorkers(int num);
//    移除工作者线程
    void removeWorker(int num);
//    得到正在等待执行的任务数量
    int getJobSize();


}
