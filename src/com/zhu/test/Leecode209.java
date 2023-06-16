package com.zhu.test;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author shkstart
 * @create 2022-09-28 9:21
 */
public class Leecode209 {
    public static void main(String[] args) {

        TreeNode1 node1 = new TreeNode1(3);
        TreeNode1 node2 = new TreeNode1(9);
        TreeNode1 node3 = new TreeNode1(20);
        TreeNode1 node4 = new TreeNode1(15);
        TreeNode1 node5 = new TreeNode1(7);
        node1.left = node2;
        node1.right = node3;

        node3.left = node4;
        node3.right = node5;
//
        int i = 1;

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        pre(node1,queue,i);

        System.out.println(queue.peek());

//        ArrayList<Integer> result = new ArrayList<Integer>();
//        preOrder(node1, result);
//
//        for (Integer i : result){
//
//            System.out.println(i);
//        }

    }


   public static void preOrder(TreeNode1 root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);

        if (root.left != null){
            preOrder(root.left, result);
            // 注意这一句
        }
       if (root.right != null){
           // 注意这一句
           preOrder(root.right, result);
       }


    }


    public static void pre(TreeNode1 root,PriorityQueue<Integer> queue,int i){

        if (root == null){

            return;

        }

        i =i+1;


        if (root.left != null){
            queue.offer(i);
            pre(root.left,queue,i);

        }
        if (root.right != null){
            queue.offer(i);
            pre(root.right,queue,i);

        }

    }




}
class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1() {}
    TreeNode1(int val) { this.val = val; }
    TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}