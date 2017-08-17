package com.arigothem;

/**
 * Created by qiaojiange on 2017/4/16.
 */
public class MThreadLocal {
    //通过匿名内部类覆盖ThreadLocal的initialValue()方法，指定初始值
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){
        public Integer initialValue(){
            return 0;
        }
    };

//  获取下一个序列值
    public int getNextNum(){
        seqNum.set(seqNum.get()+1);
        return seqNum.get();
    }

    public static void main(String[] args) {

        MThreadLocal sn = new MThreadLocal();
        //3个线程共享sn,各自产生序列号
        TestClient t1 = new TestClient(sn);
        TestClient t2 = new TestClient(sn);
        TestClient t3 = new TestClient(sn);

        t1.start();
        t2.start();
        t3.start();

    }

    private static class TestClient extends Thread{
        private MThreadLocal sn;
        public TestClient(MThreadLocal sn){
            this.sn = sn;
        }

        public void run(){
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+" : "+sn.getNextNum());
            }
        }
    }
}
