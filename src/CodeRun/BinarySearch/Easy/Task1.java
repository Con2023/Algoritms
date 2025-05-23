package CodeRun.BinarySearch.Easy;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
//Реализуйте двоичный поиск в массиве
//
//Формат ввода
//В первой строке входных данных содержатся натуральные числа
//N
//N и
//K
//K (
//0
//        <
//N
//        ,
//K
//≤
//        100
//         
//        000
//        0<N,K≤100000). Во второй строке задаются
//N
//N элементов первого массива, а в третьей строке –
//K
//K элементов второго массива. Элементы обоих массивов - целые числа, каждое из которых по модулю не превосходит
//1
//        0
//        9
//        10
//        9
//
//
//Формат вывода
//Требуется для каждого из K чисел вывести в отдельную строку "YES", если это число встречается в первом массиве, и "NO" в противном случае.
public class Task1 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstLine = reader.readLine().split(" ");
        int K = Integer.parseInt(firstLine[1]);
        int N = Integer.parseInt(firstLine[0]);

        int[] arrN = new int[N];
        int[] arrK = new int[K];

        System.out.println("Full first array.");
        String[] numsN = reader.readLine().split(" ");
        for(int i = 0; i < N; i++){
            arrN[i] = Integer.parseInt(numsN[i]);
        }
        Arrays.sort(arrN);

        System.out.println("Full second array.");
        String[] numsK = reader.readLine().split(" ");
        for(int i = 0; i < K; i++){
            int el = Integer.parseInt(numsK[i]);
            boolean result = findElement(el,arrN);
            if (result){
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }

    }
    public static boolean findElement(Integer el, int[] array){
        int start = 0;
        int end = array.length - 1;

        while(start<=end){
            int middle = (start+end)/2;
            int guess = array[middle];

            if(guess == el){
                return true;
            }
            else if(guess > el){
                end = middle-1;
            }
            else {
                start = middle+1;
            }
        }

        return false;
    }
}


//public class Task1 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String[] numbers = scanner.nextLine().split(" ");
//
//
//        int K = Integer.parseInt(numbers[1]);
//        int N = Integer.parseInt(numbers[0]);
//
//        int[] arrN = new int[N];
//        int[] arrK = new int[K];
//
//        for(int i = 0; i < N; i++){
//            arrN[i] = scanner.nextInt();
//        }
//
//        for(int i = 0; i < K; i++){
//            arrK[i] = scanner.nextInt();
//        }
//        Arrays.sort(arrN);
//
//        for(Integer el : arrK){
//            boolean result = findElement(el,arrN);
//            if (result){
//                System.out.println("YES");
//            }
//            else {
//                System.out.println("NO");
//            }
//        }
//    }
//    public static boolean findElement(Integer el, int[] array){
//        int start = 0;
//        int end = array.length - 1;
//
//        while(start<=end){
//            int middle = (start+end)/2;
//            int guess = array[middle];
//
//            if(guess == el){
//                return true;
//            }
//            else if(guess > el){
//                end = middle-1;
//            }
//            else {
//                start = middle+1;
//            }
//        }
//
//        return false;
//    }
//}
//
