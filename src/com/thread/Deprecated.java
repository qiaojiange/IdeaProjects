package com.thread;

import javafx.scene.input.DataFormat;
import sun.util.locale.provider.TimeZoneNameUtility;

import javax.sound.midi.Soundbank;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by qiaojiange on 2017/5/13.
 */
public class Deprecated {

    public static void main(String[] args) throws InterruptedException {
        Thread printThread = new Thread(new Runner(),"printThread");
        DateFormat format = new SimpleDateFormat("HH:mm:ss");
        printThread.setDaemon(true);
        printThread.start();
        TimeUnit.SECONDS.sleep(3);
        //暂停
        printThread.suspend();

        System.out.println("main suspend PrintThread at "+ format.format(new Date()));

        TimeUnit.SECONDS.sleep(3);
        //唤醒
        printThread.resume();
        System.out.println("main resume PrintThread at "+ format.format(new Date()));

        TimeUnit.SECONDS.sleep(3);
        //停止
        printThread.stop();
        System.out.println("main stop PrintThread at "+ format.format(new Date()));

        TimeUnit.SECONDS.sleep(3);
    }

    static class Runner implements Runnable {
        @Override
        public void run() {
            DateFormat format = new SimpleDateFormat("HH:mm:ss");
            while (true) {
                System.out.println(Thread.currentThread().getName()+"Run at "+format.format(new Date()));
                SleepUtils.second(1);
            }
        }
    }

}
