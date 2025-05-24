package CodeRun.BinarySearch.Easy;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;


/* Задание: Реализуйте двоичный поиск в массиве
Ввод: В первой строке входных данных содержатся натуральные числа N и K. Во второй строке задаются N элементов первого массива, а в третьей строке – K элементов второго массива.
Элементы обоих массивов - целые числа.
Вывод: Требуется для каждого из K чисел вывести в отдельную строку "YES", если это число встречается в первом массиве, и "NO" в противном случае.
*/
public class Task1 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        //создаем для ускорения, можно сделать серез классический ввод через System, но это займет больше времени.

        String[] firstLine = reader.readLine().split(" ");
        int K = Integer.parseInt(firstLine[1]);
        int N = Integer.parseInt(firstLine[0]);


        int[] arrN = new int[N];
        //Читаем строку и задаем массивы по введенному размеру.

        System.out.println("Full first array.");
        String[] numsN = reader.readLine().split(" ");
        for(int i = 0; i < N; i++){
            arrN[i] = Integer.parseInt(numsN[i]);
        }
        Arrays.sort(arrN);
        //считываем значения из строки, заполняем массив числами и сортируем! это нужно так как мы работаем с бинарным поиском

        System.out.println("Full second array.");
        String[] numsK = reader.readLine().split(" ");
        for(int i = 0; i < K; i++){
            int el = Integer.parseInt(numsK[i]);
            //считываем сторку и заполняем второй массив И сразу выявляем есть ли это число в первом массиве или нет.
            boolean result = findElement(el,arrN);
            //получаем результат и выводим по условию
            if (result){
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }

    }
    //функция нахождения элемента в другом массиве(можно через contain, но это не интересно)).
    // Реализуем бинарный поиск через нахождения индекс среднего элемента и сравнения, сокращаем массив поиска.
    public static boolean findElement(Integer el, int[] array){
        int start = 0;
        int end = array.length - 1;
        // первый и последний индексы

        while(start<=end){
            //пока у нас индекс начала не больше конца выполняется цикл
            int middle = (start+end)/2;
            int guess = array[middle];
            //находим иднекс середины и элемент по этому индексу
            if(guess == el){
                return true;
            }
            //если у нас элемент равен загаданномк, то цикл останавливается
            else if(guess > el){
                end = middle-1;
                //если средний элемент больше выбранного элемента, то новый индекс конца массива будет равен индекс середины минус 1
            }
            else {
                start = middle+1;
            }
        }
        //иначе не найдено
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
