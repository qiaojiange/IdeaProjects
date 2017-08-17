package com.niuke;

/**
 * Created by qiaojiange on 2017/4/13.
 */
public class LcsLearn {
    //    使用暴力法
    public int longestCommonSubString1(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) {
            return 0;
        }
        int len1 = str1.length();
        int len2 = str2.length();

        int longest = 0;

        int start = 0;
        int end = 0;

//        保存两个字符串的起始位置
        int start1 = 0;
        int start2 = 0;
        int comparison = 0;
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {

                int m = i;
                int n = j;
                while (m < len1 && n < len2) {
                    ++comparison;
                    if (str1.charAt(m) != str2.charAt(n)) break;
                    ++m;
                    ++n;
                }

                //求出了最长的长度
                if ((m - i) > longest) {
                    longest = m - i;
                    start = i;
                    end = m;

                    start1 = i;
                    start2 = j;
                }
            }
        }
        if (start < end) {
            System.out.println("start1=" + start1 + " start2=" + start2 + " comparsion=" + comparison);
            System.out.println("the longest subString is:" + str1.substring(start, end));
        } else {
            System.out.println("no common subString");
        }
        return longest;
    }

    //    使用动态规划
    public int longestCommonSubString2(String str1, String str2) {
        if (str2 == null || str1 == null) return 0;
        int size1 = str1.length();
        int size2 = str2.length();
        int[][] c = new int[size1][size2];

        int comparison = 0;

//        单纯为理解可以这样写，容易读懂
//        for (int i = 0; i < size1; i++) {
//            ++comparison;
//            if (str1.charAt(i) == str2.charAt(0)) {
//                c[i][0] = 1;
//            }
//        }

        for (int j = 0; j < size2; j++) {
            ++comparison;
            if (str1.charAt(0) == str2.charAt(j)) {
                c[0][j] = 1;
            }
        }

        for (int i = 1; i < size1; i++) {
            ++comparison;
            if (str1.charAt(i) == str2.charAt(0)) {
                c[i][0] = 1;
            }


            for (int j = 1; j < size2; j++) {
                ++comparison;
                if (str1.charAt(i) != str2.charAt(j)) {
                    c[i][j] = 0;
                } else {
                    c[i][j] = 1 + c[i - 1][j - 1];
                }
            }
        }

        int longest = 0;
//        寻找最大的c[i][j]
        int start1 = 0;
        int start2 = 0;

        int start = 0;
        int end = 0;
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                if (longest < c[i][j]) {
                    longest = c[i][j];
                    start1 = i - longest + 1;
                    start2 = j - longest + 1;

                    start = start1;
                    end = i + 1;
                }
            }
        }

        if (start < end) {
            System.out.println("start1=" + start1 + " start2=" + start2 + " comparsion=" + comparison);
            System.out.println("the longest subString is:" + str1.substring(start, end));
        } else {
            System.out.println("no common subString");
        }
        return longest;
    }


    public int longestCommonSubString3(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) {
            return 0;
        }

        int size1 = str1.length();
        int size2 = str2.length();
        int[][] c = new int[2][size2];

        int longest = 0;
        int start1 = 0;
        int start2 = 0;

        int start = 0;
        int end = 0;
        int comparison = 0;

        for (int j = 0; j < size2; j++) {
            ++comparison;
            if (str1.charAt(0) == str2.charAt(j)) {
                c[0][j] = 1;
                if (longest == 0) {
                    longest = 1;
                    start1 = 0;
                    start2 = j;

                    start = start1;
                    end = start1 + 1;
                }
            }
        }


        for (int i = 1; i < size1; i++) {
            ++comparison;
            int curr = (i & 0x1) == 1 ? 1 : 0;
            int pre = (i & 0x1) == 0 ? 1 : 0;
            //这个地方要注意
            if (str1.charAt(i) == str2.charAt(0)) {
                c[curr][0] = 1;
                if (longest == 0) {
                    longest = 1;
                    start1 = i;
                    start2 = 0;

                    start = start1;
                    end = start1 + 1;
                }
            }

            for (int j = 1; j < size2; j++) {
                ++comparison;
                if (str1.charAt(i) == str2.charAt(j)) {
                    c[curr][j] = 1 + c[pre][j - 1];
                    if (longest < c[curr][j]) {
                        longest = c[curr][j];
                        start1 = i - longest + 1;
                        start2 = j - longest + 1;

                        if (start1<0){
                            System.out.println("start1 < 0");
                        }

                        start = start1;
                        end = i + 1;
                    }
                } else {
                    c[curr][j] = 0;
                }
            }
        }

        if (start < end) {
            System.out.println("start1=" + start1 + " start2=" + start2 + " comparsion=" + comparison);
            System.out.println("the longest subString is:" + str1.substring(start, end));
        } else {
            System.out.println("no common subString");
        }


        return longest;
    }

    static class Test {
        public static void main(String[] args) {

            LcsLearn lcsLearn = new LcsLearn();
            String str1 = "YXXXXXY";
            String str2 = "YXYXXYYYYXXYYYYXYYXXYYXXYXYYYYYYXYXYYXYXYYYXXXXXX";

            System.out.println("暴力法：" + lcsLearn.longestCommonSubString1(str1, str2));

            System.out.println("动态规划：" + lcsLearn.longestCommonSubString2(str1, str2));


            System.out.println("改进版的动态规划：" + lcsLearn.longestCommonSubString3(str1, str2));

//
//            String str3 = "XXYXYYYXXYXYYYYXYXYYYXYYYYYXYX";
//            String str4 = "XYY";
//            System.out.println("暴力法："+lcsLearn.longestCommonSubString1(str3,str4));
//
//
//            String str5 = "XXYXXYYYXYXYYXXYYYYYXXYXXXYXXYXYXXXXYXXYYYXYYXYXYXXXYYXXXYYXYYXYXYXYXXXXXXXXXYXXXX";
//            String str6 = "YYYYYXYYYXYYXXXYYYXXYYXXYXXXYYYYYYYYXXYXYYYYXYXYYXYX";
//            System.out.println("暴力法："+lcsLearn.longestCommonSubString1(str5,str6));


        }
    }
}
