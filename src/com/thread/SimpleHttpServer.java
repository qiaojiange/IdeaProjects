package com.thread;

import java.io.BufferedReader;
import java.net.Socket;

/**
 * Created by qiaojiange on 2017/5/17.
 */
public class SimpleHttpServer {
//    static ThreadPool<>


    static class HttpRequestHandler implements Runnable{

        private Socket socket;

        public HttpRequestHandler(Socket socket){
            this.socket = socket;

        }

        @Override
        public void run() {
            String line = null;
            BufferedReader br = null;
            BufferedReader reader = null;


        }
    }
}
