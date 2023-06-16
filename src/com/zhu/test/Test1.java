package com.zhu.test;

/**
 * @author shkstart
 * @create 2022-09-26 15:44
 */
public class Test1 {

    public static void main(String[] args) {
        int n = 4;
        int[][] array = new int[n][n];
        int startX = 0;
        int startY = 0;

        int offset = 1;

        int loop = n / 2;

        int count = 1;

        while ( loop > 0){

            int i = startX;
            int j = startY;

            for (; j < n - offset +startY; j++){
                array[startX][j] = count++;
            }

            for (; i < n - offset +startX; i++){
                array[i][j] = count++;
            }

            for (; j > startY ; j--){
                array[i][j] = count++;
            }

            for (; i > startX ; i--){
                array[i][j] = count++;
            }

            loop--;

            startX += 1;
            startY += 1;

            offset += 2;
        }

        if (n % 2 == 1) {
            array[n/2][n/2] = count;
        }

        for (int i = 0;i<n;i++){
            for (int j = 0; j<n; j++){
                System.out.println(array[i][j]);
            }
        }
    }


}
