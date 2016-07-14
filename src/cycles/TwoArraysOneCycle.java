package cycles;


public class TwoArraysOneCycle {
    public static void main(String[] args) {
        int[] A = {0,1,3,5,7,12,16};
        int[] B = {2,6,9,15};
        int a = A.length, b = B.length,Ai = 0, Bi = 0;
        System.out.println("A = {0,1,3,5,7,12,16}");
        System.out.println("B = {2,6,9,15}");
        System.out.print("Sorted A[a] + B[b]: ");
        for (int i = 0; i < a+b; i++){
            int ai,bi;
            if (Ai<A.length)ai = A[Ai]; else ai = Integer.MAX_VALUE;
            if (Bi<B.length)bi = B[Bi]; else bi = Integer.MAX_VALUE;
            String ch;
            if ((a+b-i)>1) ch = ","; else ch = ".";
            if (ai < bi) {
                System.out.print(A[Ai]+ch);
                Ai++;
            } else {
                System.out.print(B[Bi]+ch);
                Bi++;
            }
        }
    }
}
