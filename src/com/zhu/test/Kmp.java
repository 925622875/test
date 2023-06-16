package com.zhu.test;

/**
 * @author shkstart
 * @create 2022-09-27 21:48
 */
public class Kmp {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";


        Kmp kmp = new Kmp();
        int[] next = kmp.kmpSearch(str2);
        int kmp1 = kmp.kmp(str1, str2, next);
        System.out.println(kmp1);
    }

    public int kmp(String str1, String str2, int[] next){

        for (int i = 0, j =0; i < str1.length(); i++){

            while (j > 0 && str1.charAt(i) != str2.charAt(j)){

                j = next[j-1];

            }

            if (str1.charAt(i) == str2.charAt(j)){

                j++;

            }

            if (j == str2.length()){
                return i - j +1;
            }

        }

        return -1;

    }

    public int[] kmpSearch(String str){

        int[] next = new int[str.length()];

        next[0] = 0;

        for (int i = 1, j = 0; i < str.length(); i++){

            while (j > 0 && str.charAt(i) != str.charAt(j)){

                j = next[j - 1];

            }

            if (str.charAt(i) == str.charAt(j)){

                j++;

            }

            next[i] = j;

        }

        return next;

    }
}
