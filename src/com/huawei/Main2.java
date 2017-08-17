package com.huawei;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by qiaojiange on 2017/8/16.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Queue<Character> q = new LinkedList<>();

        boolean haveSign = false;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == ' ' && !haveSign){
                boolean useQueue = false;
                while(!q.isEmpty()){
                    useQueue = true;
                    sb.append(q.poll());
                }
                 if(useQueue){
                     count++;
                     sb.append("\n");
                 }
                continue;
            }
            if(haveSign && ch=='”'){
                haveSign = false;
                boolean useQueue = false;
                while(!q.isEmpty()){
                    useQueue = true;
                    sb.append(q.poll());
                }
                if(useQueue){
                    count++;
                    sb.append("\n");
                }
                continue;
            }
            if(ch == '“'){
                haveSign = true;
                continue;
            }
            q.add(ch);
        }

        if(!q.isEmpty()){
            count++;
        }

        while (!q.isEmpty()){
            sb.append(q.poll());
        }
        System.out.println(count);
        System.out.println(sb.toString());
    }

}
