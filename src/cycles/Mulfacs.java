package cycles;


import java.util.Scanner;


public class Mulfacs {
    public static void main(String[] args) {
        System.out.println("There is F(N) = 1!*2!*3!*...*N!");
        System.out.print("Where N = ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int j = 1, m = 1;
        System.out.println("Well well...");
        String f = "F(N) = ";
        for (int i = 1; i <= n; i++){
            f = f+i+"!*";
            j *= i;
            m *= j;
        }
        f=f.replace(n+"!*",n+"!=");
        System.out.println("Answer is "+f+m);
    }
}

