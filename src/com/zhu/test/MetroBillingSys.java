package com.zhu.test;

import java.util.HashMap;

/**
 * @author shkstart
 * @create 2023-06-09 19:35
 */
public class MetroBillingSys {
    int[] cost;
    int price;
    int limit;
    HashMap<Integer,Integer> accountBalance;
    HashMap<Integer,Integer> accountCount;

    public MetroBillingSys(int[] cost, int price, int limit){
        this.accountBalance = new HashMap<>();
        this.accountCount = new HashMap<>();
        this.cost = cost;
        this.price = price;
        this.limit = limit;

    }

    public void recharge(int id,int amount){
        accountBalance.put(id,accountBalance.getOrDefault(id,0) + amount);
        return;
    }

    public boolean purchase(int id){
        if (accountBalance.containsKey(id)){
            if (accountBalance.get(id) >= price){
                accountBalance.put(id,accountBalance.get(id) - price);
                accountCount.put(id,accountCount.getOrDefault(id,0) + limit);
                return true;
            }else {
                accountCount.put(id,accountCount.getOrDefault(id,0));
                return false;
            }
        }else {
            accountBalance.put(id,0);
            accountCount.put(id,0);
            return false;
        }
    }

    public boolean commute(int id,int distance){
        accountBalance.put(id,accountBalance.getOrDefault(id,0));
        accountCount.put(id,accountCount.getOrDefault(id,0));
        if (accountCount.get(id) > 0){
            accountCount.put(id,accountCount.get(id) - 1);
            return true;
        }else {
            if (accountBalance.get(id) > 0){
                accountBalance.put(id,accountBalance.get(id) - cost[distance - 1]);
                return true;
            }else {
                return false;
            }
        }

    }

    public int[] query(int id){
        int[] arr= new int[2];
        if (!accountBalance.containsKey(id)){
            accountBalance.put(id,0);
            arr[0] = 0;
        }else{
            arr[0] = accountBalance.get(id);
        }

        if (!accountCount.containsKey(id)){
            accountCount.put(id,0);
            arr[1] = 0;
        }else {
            arr[1] = accountCount.get(id);
        }
        return arr;
    }

}
