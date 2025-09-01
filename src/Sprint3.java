import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Sprint3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(reader.readLine());
        ArrayList<Integer[]> arrays = new ArrayList<>();
        for(int i = 0; i < k; i++){
            Integer[] stringS = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            arrays.add(stringS);
        }
        flowers(arrays);


    }
    public static String twoBikesBinarySearch(Scanner sc){
        int n = sc.nextInt();
        sc.nextLine();
        Integer[] debets = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        int s = sc.nextInt();

        int left = 0;
        int right = debets.length-1;

        int resOneBike = binarySearch(s, right,left,debets);
        int resTwoBike = binarySearch(s*2, right,left,debets);

        return String.format("%d, %d", resOneBike, resTwoBike);
    }

    public static int binarySearch(int n, int right, int left, Integer[] array) {

        if (left > right) {
            return -1;
        }

        int indexMiddle =(left + right) / 2;
        int middleEl = array[indexMiddle];

        if (middleEl >= n) {
            return indexMiddle+1;

        }
        else {
            left = indexMiddle + 1;
            return binarySearch(n, right, left, array);
        }
    }

    public static void task2(Scanner sc){
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        int firstEl = sc.nextInt();
        int secondEl = sc.nextInt();

        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(func1(stringBuilder, map, firstEl,secondEl,0).toString());

    }
    public static StringBuilder func1(StringBuilder stringBuilder, HashMap<Integer, String> map, int a, int b, int index){
        if (index == map.get(a).length()){
            return stringBuilder;
        }
        for(char el : map.get(b).toCharArray()){
            if (index< map.get(a).length()) {
                stringBuilder.append((map.get(a).charAt(index))).append(el).append(" ");
            }
        }
        return func1(stringBuilder,map,a,b,index+1);

    }

    public static void func2(StringBuilder string, int open, int close, int n){
        if(string.length() == n*2){
            System.out.println(string);
        }
        if(open < n){
            string.append("(");
            func2(string, open+1, close, n);
            string.deleteCharAt(string.length() - 1);
        }
        if(close<open) {
            string.append(")");
            func2(string, open, close+1, n);
            string.deleteCharAt(string.length() - 1);
        }

    }

    public static void bubbleSort(ArrayList<Integer> nums){
        int indicator = 0;
        for(int j = 0; j<nums.size()-1; j++){
            indicator = 1;
            for(int i = 0; i<nums.size()-1; i++){
                int num = nums.get(i);
                if(nums.get(i) > nums.get(i+1)){
                    nums.set(i,nums.get(i+1));
                    nums.set(i+1,num);
                    indicator = 2;
                }
            }
            if(indicator == 2) System.out.println(nums);
            else break;

        }
        if (indicator == 1) System.out.println(nums);
    }

    public static void compare(HashMap<String, Integer> map, ArrayList<String> array) {
//        HashMap<String, Integer> map = new HashMap<>();
//        ArrayList<String> numsOnKeys = new ArrayList<>();
//        String[] debets = sc.nextLine().split(" ");
//        for (String el : debets){
//            char key = el.charAt(0);
//            numsOnKeys.add(String.valueOf(key));
//            map.put(String.valueOf(key), Integer.parseInt(el));
//        }
//        compare(map,numsOnKeys);
//
        int maxNum = Integer.MIN_VALUE;

        for (int j = 0; j < array.size() - 1; j++) {
            int index = j;
            for (int i = j + 1; i < array.size(); i++) {
                if (Integer.parseInt(String.valueOf(array.get(i))) > Integer.parseInt(String.valueOf(array.get(index)))) {
                    maxNum = Integer.parseInt(String.valueOf(array.get(i)));
                    index = i;
                }
            }
                String elArray = array.get(j);
                array.set(j, (Integer.toString(maxNum)));
                array.set(index, elArray);
        }
        StringBuilder stringBuilder = new StringBuilder();

        for(String el : array){
            int value = map.get(el);
            stringBuilder.append(value);
        }
        System.out.println(stringBuilder);
    }

    public static int[] merge(int[]arr, int left, int mid, int right){
//        Object[] numbers = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray();
//        int[] num = new int[numbers.length];
//        for(int i = 0; i < numbers.length;i++){
//            num[i] = Integer.parseInt(String.valueOf(numbers[i]));
//        }
//        mergeSort(num, 0,  6);
        int[] rightArray = Arrays.copyOfRange(arr, mid,right);
        int[] leftArray = Arrays.copyOfRange(arr, left, mid);
        int rangeNewArray = rightArray.length+leftArray.length;
        int[] newArray = new int[rangeNewArray];

        int n1 = leftArray.length;
        int n2 = rightArray.length;

        int i = 0; // индекс для leftArray
        int j = 0; // индекс для rightArray
        int k = 0; // индекс для newArray

            while (i<n1 && j < n2) {
                if (leftArray[i] > rightArray[j]) {
                    newArray[k] = rightArray[j];
                    k++;
                    j++;
                } else {
                    newArray[k++] = leftArray[i++];
                }
            }
            while (i < n1){
                newArray[k++] = leftArray[i++];
            }

        while (j < n2){
            newArray[k++] = rightArray[j++];
        }
        return newArray;
    }
    public static void mergeSort(int[] array, int left, int right){

        if (right - left <= 1) return; // Базовый случай

        int mid = (left + right) / 2; // Середина полуинтервала
        mergeSort(array, left, mid);    // Сортировка левой половины
        mergeSort(array, mid, right);   // Сортировка правой половины
        merge(array, left, mid, right);  // Слияние двух отсортированных половин
        System.out.println(Arrays.toString(array));
    }

    public static boolean conseq(char[] s, char[] t){
        if(s.length == 0 || t.length == 0){
            return false;
        }
        int i = 0;
        int j = 0;

        while(i < s.length && j < t.length){
            if (t[j] == s[i]){
                i++;
            }
            j++;
        }
        return i == s.length;
    }

    public static int coocies(String[] n, String[] m){

        int i = 0;
        int j = 0;
        int count = 0;
        Arrays.sort(n);
        Arrays.sort(m);

        while(i < n.length && j < m.length){
            if(Objects.equals(n[i++], m[j++])){
                count++;
            }
        }
        return count;
    }
    public static int buyHouses(int h, ArrayList<Integer> costs){

       for(int k = 0; k < costs.size()-1; k++) {
           for (int i = 0; i < costs.size()-1-k; i++) {
               int num = costs.get(i);
               if (costs.get(i) > costs.get(i + 1)) {
                   costs.set(i, costs.get(i + 1));
                   costs.set(i + 1, num);
               }
           }
       }

       int i = 0;
       int cost = 0;
       int count = 0;

       while (i<costs.size()){
           cost += costs.get(i);
           if(cost < h){
               count++;
           }
           i++;
       }
       return count;
    }
    public static void pTriangle(ArrayList<Integer> nums){
        for(int k = 0; k < nums.size()-1; k++) {
            for (int i = 0; i < nums.size()-1-k; i++) {
                if (nums.get(i) > nums.get(i + 1)) {
                    int num = nums.get(i);
                    nums.set(i, nums.get(i + 1));
                    nums.set(i + 1, num);
                }
            }
        }
    }
    public static void dutchFlag(Integer[] array){
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (Integer el:array){
            int mid = arrayList.size()/2;

            if(el == 0){
                arrayList.addFirst(el);
            } else if (el == 1) {
                arrayList.add(mid,el);
            }
            else {
                arrayList.add(el);
            }
        }
        System.out.println(arrayList);

    }
    public static void idUniver(Integer[] array, int k){
        ArrayList<Integer> arrayList = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(array);

        for (Integer el:array){
            map.put(el, map.getOrDefault(el, 0)+1);
        }

        List<Map.Entry<Integer,Integer>> readyList = map.entrySet().stream()
                        .sorted((a,b) -> {
                            if (b.getValue().equals(a.getValue())){
                                return a.getKey().compareTo(b.getKey());
                            }
                            else {
                                return b.getValue().compareTo(a.getValue());
                            }
                        })
                                .limit(k)
                                        .toList();
        for (Map.Entry el : readyList){
            System.out.println(el.getValue());
        }
    }
    public static void flowers(ArrayList<Integer[]> arrays){
        ArrayList<Integer[]> arrayList = new ArrayList<>();

        for(int i = 0; i < arrays.size()-1; i++){
            if(Objects.equals(arrays.get(i)[1], arrays.get(i + 1)[0]) || arrays.get(i)[1] >= arrays.get(i+1)[0]){
                arrays.set(i, new Integer[]{arrays.get(i)[0], arrays.get(i+1)[1]});
            }
        }
        for (Integer[] el : arrays){
            System.out.println(Arrays.toString(el));
        }
    }

    public static void quickSortInPlace(String[][] arr){

        int index = arr.length/2;
        String[] midEl = arr[index];

        int left = 0;
        int right = arr.length-1;

        for(int i = 0; i<arr.length-1; i++){
            if((Integer.parseInt(arr[i][1]) < Integer.parseInt(midEl[1])) && (Integer.parseInt(arr[arr.length-1-i][1]) > Integer.parseInt(midEl[1]))){
                left++;
                right--;
            }
            else {
                String[] swapEl = arr[i];
                arr[i] = arr[arr.length-1-i];
                arr[arr.length-1-i] = swapEl;
            }
            if(left == right){
                String[][] partLeft = Arrays.copyOfRange(arr, 0, index-1);
                String[][] partRight = Arrays.copyOfRange(arr,  index+1, arr.length);
                quickSortInPlace(partLeft);
                quickSortInPlace(partRight);
            }
        }
    }
}
