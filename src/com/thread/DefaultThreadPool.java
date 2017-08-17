package com.thread;

import javafx.concurrent.Worker;
import sun.swing.plaf.synth.DefaultSynthStyle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by qiaojiange on 2017/5/17.
 */
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {
    //    线程池最大数量
    private static final int MAX_WORKER_NUMBERS = 10;
    //    线程池默认数量
    private static final int DEFAULT_WORKER_NUMBERS = 5;
    //    线程池最小数量
    private static final int MIN_WORKER_NUMBERS = 1;

    //    这是一个工作列表，将会向里面插入工作
    private final LinkedList<Job> jobs = new LinkedList<Job>();

    //    工作列表
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());
    //线程编号生成
    AtomicLong threadNum = new AtomicLong();
    //    线程的工作数量
    private int workerNum = DEFAULT_WORKER_NUMBERS;

    public DefaultThreadPool() {
        initalizeWorkers(DEFAULT_WORKER_NUMBERS);
    }

    public DefaultThreadPool(int num) {
        this.workerNum = num > MAX_WORKER_NUMBERS ? MAX_WORKER_NUMBERS : num < MIN_WORKER_NUMBERS ? MIN_WORKER_NUMBERS : num;
        initalizeWorkers(this.workerNum);
    }

    private void initalizeWorkers(int num) {
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker,"ThreadPool-Worker-"+threadNum.incrementAndGet());
            thread.start();
        }

//        for (int i = 0; i < num; i++) {
//            Worker worker = new Worker();
//            workers.add(worker);
//            Thread thread = new Thread(worker, "ThreadPool-Worker-" + threadNum.incrementAndGet());
//
//            thread.start();
//        }
    }

    @Override
    public void execute(Job job) {
        if (job != null){
            synchronized (jobs){
                jobs.addLast(job);
                jobs.notify();
            }
        }

//        if (null != job) {
////    添加一个工作，然后进行通知
//            synchronized (jobs) {
//                jobs.addLast(job);
//                jobs.notify();
//            }
//        }

    }

    @Override
    public void shutdown() {
        for(Worker worker:workers){
            worker.shutdown();
        }

//        for (Worker worker : workers) {
//            worker.shutdown();
//        }
    }

    @Override
    public void addWorkers(int num) {
        synchronized (jobs){
            if (num + this.workerNum > MAX_WORKER_NUMBERS){
                num = MAX_WORKER_NUMBERS - this.workerNum;
            }
            initalizeWorkers(num);
        }

    }

    @Override
    public void removeWorker(int num) {
        synchronized (jobs){
            if (num > this.workerNum){
                throw new IllegalArgumentException("beyond workNum");
            }
            int count = 0;
            while (count <num){
                Worker worker = workers.get(count);
                if (workers.remove(worker)){
                    worker.shutdown();
                    count++;
                }
            }
            this.workerNum -= num;
        }


    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }

    //    工作者,负责消费任务
    class Worker implements Runnable {
        private volatile boolean running = true;

        @Override
        public void run() {
          while (running){
              Job job = null;
              synchronized(jobs){
                  if (jobs.isEmpty()){
                      try {
                          jobs.wait();
                      } catch (InterruptedException e) {
//                          感知到外界对workerThread的中断操作，返回
                          Thread.currentThread().interrupt();
                      }
                  }
                  job = jobs.removeFirst();
              }
              if (null != job){
                  job.run();
              }
          }
        }

        public void shutdown() {
            running = false;
        }
    }
}
