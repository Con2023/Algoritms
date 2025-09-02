package Practicum;

import java.beans.Introspector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyStore;
import java.util.*;

public class Sprint4 {
    public static void main(String[] args) throws IOException {
        taskFin1();

    }
    public static void task1(HashMap<String, Integer> map){
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(reader.readLine());
//        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
//        for(int i = 0; i < n; i++){
//            String string = reader.readLine();
//            map.put(string,i);
//        }
//        task1(map);
        System.out.println(map.values());
        System.out.println(map.keySet());
    }
    public static void task2(Integer[] arr){
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(reader.readLine());
//        Integer[] array = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
//        task2(array);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer el : arr){
            map.put(el, (map.getOrDefault(el,0) + 1));
        }
        int num = Math.min(map.get(0), map.get(1));
        System.out.println(num*2);
    }
    public static boolean task3(String[] array1, String[] array2){
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String[] string1 = reader.readLine().split("");
//        String[] string2 = reader.readLine().split("");
//
//        System.out.println(task3(string1,string2));
        if(array2.length != array1.length){
            System.out.println("No");
        }
        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        for(int i =0; i < array1.length; i++){
            if(map.containsKey(array1[i]) && !Objects.equals(map.get(array1[i]), array2[i])){
                return false;
            }
            else {
                map.put(array1[i], array2[i]);
            }
        }
        return true;

    }
    public static double task4(Integer a, Integer m, char[] s){
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int a = Integer.parseInt(reader.readLine());
//        int m = Integer.parseInt(reader.readLine());
//        char[] string = reader.readLine().toCharArray();
//
//        System.out.println(task4(a,m,string));
        HashMap<Character, Integer> map = new HashMap<>();
        for(char el: s){
            map.put(el, (int) el);
        }
        double sum = 0;
        for(int i = 0; i < s.length; i++){
            char el = s[i];
            sum += (map.get(el)*Math.pow(a, s.length-1-i));
        }
        return sum%m;
    }

    public static char[] generateString(){
        Random random = new Random();
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] newArray = new char[10];
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i<10; i++){
            int index = random.nextInt(26);
            newArray[i] = chars[index];
        }
        return newArray;
    }
    public static void task5(){


        while(true){
            char[] string1= generateString();
            char[] string2 = generateString();

            double hashString1 = task4(1000, 123987123, string1);
            double hashString2 = task4(1000, 123987123, string2);

            if((hashString2 == hashString1)&&(!Arrays.equals(string1, string2))){
                System.out.println(string2);
                System.out.println(string1);
                break;
            }

        }
    }
    public static void task6(char[] elements){
        int max = 0;
        ArrayList<Character> otherEl = new ArrayList<>();
        int size = elements.length;
        int num = 0;

        while(size != 0){
            for(int i = num; i < elements.length; i++){
                if (otherEl.contains(elements[i])){
                    System.out.println(otherEl);
                    int len = otherEl.size();
                    if(len > max) max = len;
                    otherEl.clear();
                    break;
                }
                else{
                    otherEl.add(elements[i]);
                    size--;
                    num++;
                }
            }
        }
        System.out.println(max);
    }

    public static boolean annagram(String s, String t){
        if (s.length() != t.length()) return false;

        char[] el1 = s.toCharArray();
        char[] el2 = t.toCharArray();

        Arrays.sort(el2);
        Arrays.sort(el1);

        return Arrays.equals(el2, el1);
    }

    public static void checkAnnagram(String[] strings){

        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0 ; i < strings.length; i++){
            map.put(strings[i], i);
        }

        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i < strings.length; i++){
            List<String> betweenRes = new ArrayList<>();
            betweenRes.add(strings[i]);
            for(int j = 1+i; j < strings.length; j++){
                if(annagram(strings[i], strings[j]) && !Objects.equals(strings[j], " ")){
                    betweenRes.add(strings[j]);
                    strings[j] = " ";
                }
            }
            if(!betweenRes.contains(" ")){
                res.add(betweenRes);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(List<String> el : res){
                for (String st : el) {
                        String stVal = String.valueOf(map.get(st));
                        stringBuilder.append(stVal).append(" ");
            }
        }
        System.out.println(stringBuilder);
    }

    public static void task() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i =0; i < n; i++){
            int el = Integer.parseInt(reader.readLine());
            arr.add(el);
        }
        int count = 0;

        Integer[] array = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        for (Integer el : array){
            if(arr.contains(el)){
                int index = arr.indexOf(el);
                arr.remove(index);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void task6() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
       ArrayList<Double> arr = new ArrayList<>();
        ArrayList<Integer[]> arrayListMetro = new ArrayList<>();
        for(int i = 0; i < n; i++){
            arrayListMetro.add(Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new));
        }
        int m = Integer.parseInt(reader.readLine());
        ArrayList<Integer[]> arrayListStation = new ArrayList<>();
        for(int i = 0; i < m; i++){
            arrayListStation.add(Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new));
        }

        for(int i = 0; i < arrayListMetro.size(); i++){
            double max = 0;
            for(int j = 0; j < arrayListStation.size(); j++){
                double dist = Math.sqrt((Math.pow((arrayListMetro.get(i)[0] - arrayListStation.get(i)[0]), 2)) +  (Math.pow((arrayListMetro.get(i)[1] - arrayListStation.get(i)[1]), 2)));
                if((dist<20) && (dist>max)){
                    max = dist;
                }
            }
           arr.add(max);
        }
        int index = arr.indexOf(Collections.max(arr));
        System.out.println(index+1);
    }

    public static void task7() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        String string = reader.readLine();

        HashMap<String,Integer> map = new HashMap<>();
        Map<String, Integer> firstOccurrence = new HashMap<>();

        for(int i = 0; i <= string.length() - n; i++){
                String el = string.substring(i, i + n);
                map.put(el, (map.getOrDefault(el,0) + 1));
                firstOccurrence.putIfAbsent (el, i);

        }
        System.out.println(firstOccurrence.values());

    }

    public static void taskFin1() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<Map<String, Integer>> documentsWordCounts = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            String stringFull = reader.readLine();
            for(String s : stringFull.split(" ")){
                map.put(s, map.getOrDefault(s,0)+1);
            }
            documentsWordCounts.add(map);

        }

        int m = Integer.parseInt(reader.readLine());
        while (m != 0){
            ArrayList<Integer[]> countsString = new ArrayList<>();
            String[] words = reader.readLine().split(" ");
            for (int i = 0; i < documentsWordCounts.size(); i++){
                int count = 0;
                for(String word: words){
                    if (documentsWordCounts.get(i).containsKey(word)) {
                        count++;
                    }
                }
                if (count > 0) {
                    Integer[] integers = {i + 1, count};
                    countsString.add(integers);
                }
            }
            countsString.sort((a, b) -> {
                if (!Objects.equals(b[1], a[1]))
                    return b[1] - a[1];
                return a[0] - b[0];
            });

            for (int k = 0; k < 5; k++) {
                System.out.println(countsString.get(k)[0]);
            }
            m--;
        }
    }
}

