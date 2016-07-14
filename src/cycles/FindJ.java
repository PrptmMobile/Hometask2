package cycles;

/**
 * Created by Artemka on 14.07.2016.
 */
public class FindJ {
    public static void main(String[] args) {
        int [] a = {1,0,7,2,3,5,6};
        int n = a.length+1;
        int hSum = 0; //Сумма элементов в массиве
        for(int i = 0; i <a.length; i++){
            hSum += a[i];
        }
        int nSum = 0; //Предполагаемая сумма элементов
        for(int i = 0; i <n; i++){
            nSum += i;
        }
        System.out.println("Не хватает числа "+(nSum-hSum));
    }
}
