import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Введите загаданное число(0,1000):");
        int secretNum = scan.nextInt();

        int[] arr = new int[1000];
        for (int i = 0; i<1000; i++){
            arr[i] = i;
        }
        int answer = binarySearch(arr, secretNum);
        System.out.println("Ответ:"+answer);
    }

    private static int binarySearch(int[] arr, int number){
        int less = 0;
        int big = arr.length-1;

       while(less<=big) {

           int middle = (less + big)/2;
           int guess = arr[middle];

           if(number==guess){
               return guess;
           }
           else if (number>guess) {
               less = middle+1;
           }
           else {
               big = middle-1;
           }
       }
       return -1;
    }
}
