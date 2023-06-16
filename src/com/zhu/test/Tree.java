package com.zhu.test;

/**
 * @author shkstart
 * @create 2022-10-13 9:48
 */
public class Tree {

static int count = 0;

    public static void main(String[] args) {

    }



    public int[] subsetsTest(TreeNode root){

        if (root == null)
            return new int[]{0,0};

        int[] left = subsetsTest(root.left);
        int[] right = subsetsTest(root.right);

        int rob = left[0] + right[0] + root.val;

        int notRob = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);

        return new int[]{notRob,rob};


    }

    public int[] getNum(String string){

        int[] num = new int[2];

        int strLength = string.length();

        for (int i = 0; i < strLength; i++){

            if (string.charAt(i) == '0'){

                num[0]++;
            }else
                num[1]++;
        }

        return num;
    }




}

     class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
  }


