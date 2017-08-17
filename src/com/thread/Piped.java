package com.thread;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * Created by qiaojiange on 2017/5/15.
 */
public class Piped {
    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();

//        in.connect(out);
        out.connect(in);
        Thread thread = new Thread(new Print(in),"printThread");
        thread.start();

        int receive = 0;
        try {
            while ( (receive = System.in.read())!=-1){
                out.write(receive);
            }
        }finally {
            out.close();
        }


    }


    static class Print implements Runnable {
        private int receive = 0;
        private PipedReader in;

        public Print(PipedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            try {
                while ((receive = in.read()) != -1) {
                    System.out.print((char) receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
