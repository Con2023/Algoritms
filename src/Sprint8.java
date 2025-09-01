import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sprint8 {
    public static void main(String[] args) throws IOException {
        task10();
    }

    public static void task1() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] words = reader.readLine().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = words.length-1; i >=0; i--){
            stringBuilder.append(words[i]).append(" ");
        }
        System.out.println(stringBuilder);
    }

    public static void task2() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        ArrayList<String> letters = new ArrayList<>(Arrays.asList(line.split("")));

        int num = Integer.parseInt(reader.readLine());

        for(int i = 0 ; i < num; i++){
            String[] word = reader.readLine().split(" ");
            letters.add(Integer.parseInt(word[1]), word[0]);
        }
        System.out.println(String.join("",letters));
    }

    public static void task3() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = reader.readLine().toLowerCase().split("");
        String[] line2 = reader.readLine().toLowerCase().split("");

        int[][] dp = new int[line1.length+1][line2.length+1];

        for(int i = 0; i <= line1.length; i++){
            dp[i][0] = i;
        }
        for(int i = 0; i <= line2.length; i++){
            dp[0][i] = i;
        }

        for(int i = 1; i <= line1.length; i++){
            for(int j = 1; j <= line2.length; j++){
                if(Objects.equals(line1[i-1], line2[j-1])){
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                }
            }

        }
        int res = dp[line1.length][line2.length];
        if(res > 1) System.out.println("FAIL");
        else System.out.println("OK");
    }
    public static void task4() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] line1 = reader.readLine().toLowerCase().toCharArray();
        char[] line2 = reader.readLine().toLowerCase().toCharArray();
        int sumLine1 = 0;
        int sumLine2 = 0;

        for(int i = 0; i < line1.length; i++){
            if(line1[i] % 2 == 0){
                sumLine1+=line1[i];
            }
        }

        for(int i = 0; i < line2.length; i++){
            if(line2[i] % 2 == 0){
                sumLine2+=line2[i];
            }
        }
        if(sumLine1>sumLine2) System.out.println(1);
        else if (sumLine2>sumLine1) System.out.println(-1);
        else System.out.println(0);
    }
    public static void task5() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer[] string = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] pattern = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        int diffPattern = Math.abs(pattern[0] - pattern[1]);

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1; i < string.length; i++){
            arr.add(string[i] - string[i-1]);
        }

        for(int i = 0; i <= string.length-pattern.length; i++){
            if (arr.get(i) == diffPattern){
                int diff = string[i] - pattern[0];
                boolean matched = true;
                for(int j = 1; j < pattern.length; j++){
                    if(diff != string[i+j] - pattern[j]){
                        matched = false;
                        break;
                    }
                }
                if (matched) {
                    System.out.println(i+1);
                }
            }
        }
    }

    public static void task6() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().toLowerCase().split("");

        int[] dp = new int[s.length];

        for(int i = 1; i < s.length; i++){
           int k = dp[i-1];
           while(k > 0 && !Objects.equals(s[i], s[k])){
               k = dp[k-1];
           }
           if(Objects.equals(s[i], s[k])){
               k = k+1;
           }
           dp[i] = k;
        }

        System.out.println(Arrays.toString(dp));
    }

    public static void task7() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine().toLowerCase();
        String pattern = reader.readLine().toLowerCase();
        String change = reader.readLine().toLowerCase();
        String[] arr = (pattern +"#"+s).split("");

        ArrayList<Integer> res = new ArrayList<>();

        int[] dp = new int[arr.length];
        int prev = 0;

        for(int i = 1; i < arr.length; i++){
            int k = prev;
            while(k > 0 && !Objects.equals(arr[i], arr[k])){
                k = dp[k-1];
            }
            if(Objects.equals(arr[i], arr[k])){
                k = k+1;
            }
            if(i < pattern.length()){
                dp[i] = k;
            }
            prev = k;
            if(k == pattern.length()){
                res.add(i - 2*pattern.length());
            }
        }

        ArrayList<String> string = new ArrayList<>(Arrays.asList(s.split("")));
        for (int i = res.size() - 1; i >= 0; i--) {
            int len = pattern.length();
            int index = res.get(i);
            while (len > 0) {
                string.remove(index);
                len--;
            }
            string.add(index,change);
        }

        System.out.println(String.join("",string));
    }

    public static void task8() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] s = reader.readLine().toLowerCase().toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length; i++){
            map.put(s[i], map.getOrDefault(s[i],0)+1);
        }

        Character middle = null;

        for(Character el : map.keySet()){
            if(map.get(el) % 2 != 0){
                if(middle == null || el < middle){
                    middle = el;
                }
            }
        }

        for(Character el : map.keySet()){
            if(el != middle && map.get(el) % 2 != 0){
                map.put(el, map.get(el)-1);
            }
        }

        List<Character> chars = new ArrayList<>(map.keySet());
        Collections.sort(chars);
        StringBuilder firstHalf = new StringBuilder();
        for (char c : chars) {
            for (int i = 0; i < map.get(c) / 2; i++) {
                firstHalf.append(c);
            }
        }
        StringBuilder palindrome = new StringBuilder(firstHalf);
        if (middle != null) {
            palindrome.append(middle);
        }
        palindrome.append(firstHalf.reverse());
        System.out.println(palindrome);
    }

    public static void task9() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        ArrayList<String[]> arrayList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String[] s = reader.readLine().split("");
            arrayList.add(s);
        }
        int count = 0;

        String[] parts = arrayList.get(0);

        for(int i = 0; i < arrayList.size(); i++){
            boolean allMatch = true;
            for(String[] el : arrayList){
                if(!Objects.equals(el[i], parts[i])){
                    allMatch = false;
                    break;
                }
            }
            if (allMatch) {
                count++;
            } else {
                break;
            }
        }
        System.out.println(count);
    }

    public static void task10() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        ArrayList<String> arrayList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String s = reader.readLine();
            arrayList.add(s);
        }

       HashMap<String, Integer> map = new HashMap<>();
       for(String el : arrayList){
           map.put(el, map.getOrDefault(el,0)+1);
       }
       int max = -1;
       String answer = null;

       for(String key : map.keySet()){
           if(map.get(key) > max){
               max=map.get(key);
               answer = key;
           } else if (map.get(key) == max) {
               if(key.compareTo(answer) < 0){
                   answer = key;
               }
           }
       }
       System.out.println(answer);
    }
}
