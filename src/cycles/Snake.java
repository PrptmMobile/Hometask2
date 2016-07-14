package cycles;

import java.util.Scanner;


public class Snake {
    public static Scanner sc = new Scanner(System.in);
    public static int[][] box;
    public static int lenOfSnake;

    public static int[][] snakeInBox (int length){
        int boxWidth = (int)Math.sqrt(length);
        int[][] snakebox = new int[boxWidth][boxWidth];
        int r = 0, c = 0, x = 1, y = 0, changes = 0, vis = boxWidth;
        for (int i = 0; i < length; i++) {
            snakebox[r][c] = i+1;
            if (--vis == 0) {
                vis = boxWidth * (changes%2) + boxWidth * ((changes+1)%2) - (changes/2 - 1) - 2;
                int temp = x;
                x = - y;
                y = temp;
                changes++;
            }
            c += x;
            r += y;
        }
        return snakebox;
    }
    public static void main(String[] args) {
        System.out.println("Hi, what is the length of your snake? I`ll try to put in box.");
        System.out.println("But length of your snake must have an integer square root.");
        System.out.print("Type here snake`s length: ");
        double temp = sc.nextDouble();
        while (Math.sqrt(temp)%1!=0) {
            System.out.println("I`m sorry, but there is no box for your snake.");
            System.out.print("Type new length if you cutted it: ");
            temp = sc.nextDouble();
        }
        System.out.println();
        lenOfSnake = (int)temp;
        int boxWidth = (int)Math.sqrt(temp);
        box = snakeInBox(lenOfSnake);
        System.out.println("Yes, i did it!");
        System.out.println("Look at your snake in box!");

        for (int i = 0; i < boxWidth; i++) {
            for (int j = 0; j < boxWidth; j++)
                System.out.print(box[i][j] + "\t");
            System.out.println();
        }
    }

}



