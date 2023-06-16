package com.zhu.test;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        Scanner scanner =new Scanner(System.in);

        while(scanner.hasNextInt()) {

            String strings = scanner.nextLine();


            String[] split = strings.split(" ");

            for (int j = 0; j < split.length; j++) {

                int i = Integer.parseInt(split[j]);

                if (i >= 91) {
                    System.out.print(i);
                    System.out.print(" ");
                } else if (91 - i < 4 && 91 - i > 0) {

                    System.out.print(91);
                    System.out.print(" ");
                } else if (i >= 84) {
                    System.out.print(i);
                    System.out.print(" ");
                } else if (84 - i < 4 && 84 - i > 0) {

                    System.out.print(84);
                    System.out.print(" ");
                } else if (i >= 77) {
                    System.out.print(i);
                    System.out.print(" ");
                } else if (77 - i < 4 && 77 - i > 0) {

                    System.out.print(77);
                    System.out.print(" ");
                } else if (i >= 70) {
                    System.out.print(i);
                    System.out.print(" ");
                } else if (70 - i < 4 && 70 - i > 0) {

                    System.out.print(70);
                    System.out.print(" ");
                } else if (i >= 63) {
                    System.out.print(i);
                    System.out.print(" ");
                } else if (63 - i < 4 && 63 - i > 0) {
                    System.out.print(63);
                    System.out.print(" ");
                } else {
                    System.out.print(i);
                    System.out.print(" ");
                }


            }


        }

    }


}
