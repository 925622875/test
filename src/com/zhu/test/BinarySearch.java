package com.zhu.test;

/**
 * @author shkstart
 * @create 2022-07-22 14:53
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] a = new int[]{1,5,9,11,22,33,44,55,66};
        int binary = binary(a, 55);
        System.out.println(binary);
    }

    public static int binary(int[] a,int b){
        int left = 0;
        int right = a.length-1;
        int mid;
        while(right > left){
            mid = (left + right)/2;
            if (a[mid] == b){
                return a[mid];
            }else if (a[mid] > b){
                right = mid - 1;
            }else if (a[mid] < b){
                left = mid +1;
            }
        }
        return -1;
    }
}
