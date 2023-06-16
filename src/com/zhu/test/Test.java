package com.zhu.test;

/**
 * @author shkstart
 * @create 2022-07-18 15:49
 */
public class Test {
    public static void main(String[] args) {

        MetroBillingSys metroBillingSys = new MetroBillingSys(new int[]{3,4,5,6,7},15,4);
        metroBillingSys.recharge(101,32);
        boolean purchase = metroBillingSys.purchase(101);
        boolean commute = metroBillingSys.commute(101, 3);
        boolean purchase1 = metroBillingSys.purchase(101);
        int[] query = metroBillingSys.query(101);
        metroBillingSys.recharge(102,5);
        boolean commute1 = metroBillingSys.commute(102, 4);
        int[] query1 = metroBillingSys.query(102);
        boolean commute2 = metroBillingSys.commute(102, 3);
        metroBillingSys.recharge(102,1);
        boolean commute3 = metroBillingSys.commute(102, 1);


        System.out.println(purchase);
        System.out.println(commute);
        System.out.println(purchase1);
        for (int i : query){
            System.out.println(i);
        }
        System.out.println(commute1);
        for (int i : query1){
            System.out.println(i);
        }
        System.out.println(commute2);
        System.out.println(commute3);
    }
}
