import java.beans.Introspector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sprint1 {
    public static void main(String[] args) throws IOException {
        finalTask2();

    }
    public static void finalTask2() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(read.readLine())*2; // сколько нажали всего (один - n)
        ArrayList<Integer> arrayListFull = new ArrayList<>();
        for( int i = 0; i < 4; i++){
            char[] str = read.readLine().replace(".","").toCharArray();
            for(char el : str){
                arrayListFull.add(Integer.parseInt(String.valueOf(el)));
            }
        }
        int point = 0;
        int count = 0;
        HashMap<Integer, Integer> countNumbers = new HashMap<>();
        for(Integer el : arrayListFull){
//            for(int i = 0; i < arrayListFull.size(); i++){
//                if(Objects.equals(el, arrayListFull.get(i))) count++;
//            } // обеспечивает скорость О(n**2)
            countNumbers.put(el, countNumbers.getOrDefault(el, 0) + 1); //теперь скорость О(n), мы вставлем ключи проверяем сколько вхождений было проходясь по массиву один раз
            count = 0;
        }
        for(Integer el : countNumbers.values()){
            if (el <= n){
                point++;
            }
        }
        System.out.println(point);
    }

        //модуль числа это Math.abs()
    //чтобы найти минимм в массиве, нужно преобразовать его в поток, взфть функцию min и метод getAsInt так как без него мф получим OptionalInt
    //// решение за O(n*k)
    public static ArrayList<Integer> finalTask1() throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer. parseInt(read.readLine());
        Integer[] array = Arrays.stream(read.readLine().split(" ")).map(Integer :: parseInt).toArray(Integer[]::new);

        ArrayList<Integer> arrayEmptyHousesIndexes = new ArrayList<>();
        ArrayList<Integer> arrayResult = new ArrayList<>();

        for(int i = 0; i < array.length; i++){
            if(array[i] == 0){
                arrayEmptyHousesIndexes.add(i);
            }
        }
        for(int i = 0; i < array.length; i++){
            int[] betweenRes = new int[arrayEmptyHousesIndexes.size()];
            for(int j = 0; j < arrayEmptyHousesIndexes.size(); j ++){
                int dis = Math.abs(arrayEmptyHousesIndexes.get(j) - i);
                betweenRes[j] = dis;

            }
            arrayResult.add(Arrays.stream(betweenRes).min().getAsInt());
        }
        return arrayResult;
    }
    // решение за O(n)
//    public static ArrayList<Integer> finalTask1() throws IOException {
//        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(read.readLine());
//        int[] array = Arrays.stream(read.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//
//        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE));
//
//        // Проход слева направо: ищем ближайший 0 слева
//        int lastZero = -n; // Условно "очень далеко"
//        for (int i = 0; i < n; i++) {
//            if (array[i] == 0) {
//                lastZero = i;
//                result.set(i, 0);
//            } else {
//                result.set(i, Math.min(result.get(i), i - lastZero));
//            }
//        }
//
//        // Проход справа налево: ищем ближайший 0 справа
//        lastZero = 2 * n; // Условно "очень далеко"
//        for (int i = n - 1; i >= 0; i--) {
//            if (array[i] == 0) {
//                lastZero = i;
//                result.set(i, 0);
//            } else {
//                result.set(i, Math.min(result.get(i), lastZero - i));
//            }
//        }
//
//        return result;
//    }
    public static char task11() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] stringS = reader.readLine().toLowerCase().toCharArray();
        char[] stringT = reader.readLine().toLowerCase().toCharArray();


        for(int j = 0; j<stringS.length; j++){
            char el = stringT[j];
            for(char elS : stringS){
                if (elS == el) {
                    stringT[j] = '\u0000';
                    break;
                }

            }

        }

        for (char el : stringT) {
            if (el != '\u0000') {
                return el;
            }
        }
        return '0';
    }

    public static StringBuilder task10() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String stringX = reader.readLine().replace(" ", "");
        int numberK = Integer.parseInt(reader.readLine());
        int numberX = Integer.parseInt(stringX);
        int res = numberK + numberX;
        StringBuilder resultString = new StringBuilder();
        char[] stringRes = String.valueOf(res).toCharArray();

        for(int i = 0; i<stringRes.length; i++){
            resultString.append(stringRes[i]);
            resultString.append(" ");
        }
        return resultString;

    }
    public static ArrayList<Integer> task9() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 2; i <= num;){
            if(num%i == 0 && isPrime(i)){
                numbers.add(i);
                num = num / i;
            }
            else {
                i++;
            }

        }

        return numbers;
    }

    public static boolean task8() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        while(num%4 == 0){
            num/=4;
        }
        return num==1;
    }

    public static void task7() {
        Scanner sc = new Scanner(System.in);
        char[] num1 = sc.nextLine().toCharArray();
        char[] num2 = sc.nextLine().toCharArray();
        ArrayList<Integer> listNum1 = new ArrayList<>();
        ArrayList<Integer> listNum2 = new ArrayList<>();

        for (char c : num1) {
            listNum1.add(Integer.parseInt(String.valueOf(c)));
        }
        for (char c : num2) {
            listNum2.add(Integer.parseInt(String.valueOf(c)));
        }

        int maxSize = Math.max(num1.length, num2.length);
        int minSize = Math.min(num1.length, num2.length);
        int diff = maxSize - minSize;

        for(int i = 0; i < diff; i++){
            if(listNum1.size() == minSize){
                listNum1.addFirst(0);
            }
            else {listNum2.addFirst(0);}

        }
        StringBuilder res = new StringBuilder();

        int[] addNumbs = new int[maxSize];

        for(int i = maxSize-1; i>=0; i--){
            int sum = listNum1.get(i)+listNum2.get(i)+addNumbs[i];
            if((sum==0) || (sum == 1)){
                res.append(sum);
            }
            else if (sum == 2){
                res.append(0);
                if(i > 0)
                    addNumbs[i - 1] = 1;
            }
            else {
                res.append(1);
                if(i > 0)
                    addNumbs[i - 1] = 1;
            }

        }
        if(listNum1.getFirst() == 1 && listNum2.getFirst() == 1){
            res.append(1);
        }

        System.out.println(res.reverse());

    }

    public static String task6() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        StringBuilder listNum = new StringBuilder("");

        while (num!= 0){
            int bit = num % 2;
            listNum.append(bit);
            num = num / 2;

        }
        return listNum.reverse().toString();
    }
    public static boolean task5() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine().toLowerCase().replaceAll(" ","");
        String stringClean= string.replaceAll("[\\p{Punct}]","");
        for(int i = 0; i < stringClean.length()/2; i++){
            if (stringClean.charAt(i) != stringClean.charAt(stringClean.length()- 1 - i)){
                return false;
            }
        }
        return  true;
    }
    public static String task4() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] string = reader.readLine().split(" ");

        //хороше решение но только если нужно вернуть слово максимальной длины которое посмледнее так как мапа перепзаписывает значения по ключу
        //HashMap<Integer, String> map = new HashMap<>();

        int size = Integer.MIN_VALUE;
        String word = "";

        for (String el : string){
            if(el.length() > size){
                size = el.length();
                word = el;

            }
        }

        return String.format("%d %s", size, word);
    }
    public static int task3() throws  IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> listNumbers = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        listNumbers.add(Integer.MIN_VALUE);
        int n = Integer.parseInt(reader.readLine());
        String[] stringNum = reader.readLine().split(" ");
        Integer[] num = Arrays.stream(stringNum).map(Integer::parseInt).toArray(Integer[]::new);
        listNumbers.addAll(Arrays.asList(num));
        listNumbers.addLast(Integer.MIN_VALUE);

        for(int i = 1; i < n+1; i++){
            if(listNumbers.get(i) > listNumbers.get(i+1) && listNumbers.get(i) > listNumbers.get(i-1)){
                numbers.add(listNumbers.get(i));
            }
        }
        return numbers.size();
    }

    public static ArrayList<Integer> task2() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] row = reader.readLine().split(" ");
            Integer[] rowNum = Arrays.stream(row).map(Integer::parseInt).toArray(Integer[]::new);
            for (int j = 0; j < m; j++) {
                matrix[i][j] = rowNum[j];
            }
        }
        int k = Integer.parseInt(reader.readLine());
        int x = Integer.parseInt(reader.readLine());
            ArrayList<Integer> points = new ArrayList<>();
            int[] K = new int[]{-1, 1, 0, 0};
            int[] X = new int[]{0,0,-1,1};
            for(int i = 0; i < 4; i++){
                int newK = k + K[i];
                int newX = x + X[i];
                if(newK >= 0 && newK < n && newX >= 0 && newX < m){
                    points.add(matrix[newK][newX]);
                }
            }
            return points;
    }
    public static String task1 (Integer[] nums){

        for(Integer el:nums){
            if (!isPrime(el)){
                return "FAIL";
            }
        }
        return "WIN";
    }

    public static boolean isPrime(int n){
        if(n<2) return false;
        for(int i = 2; i*i < n; i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }



}
