import java.util.*;

public class Sprint7 {
    public static void main(String[] args) {
        fin1();
    }
    public static void task1(){
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] days = new int[number];

        for(int i = 0; i<number; i++){
            days[i] = scanner.nextInt();
        }

        int maxSum = 0;

        for(int i = 1; i < days.length; i++){
            if(days[i] > days[i-1]){
                maxSum+=days[i]-days[i-1];
            }
        }
        System.out.println(maxSum);
    }

    public static void task2(){
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        sc.nextLine();
        ArrayList<Double[]> arrayList = new ArrayList<>();


        for(int i = 0; i < hour; i++){
            Double[] hours = Arrays.stream(sc.nextLine().split(" ")).map(Double::parseDouble).toArray(Double[]::new);
            arrayList.add(hours);
        }

        arrayList.sort(Comparator.comparingDouble(arr -> arr[arr.length-1]));

        ArrayList<Double[]> res = new ArrayList<>();
        res.add(arrayList.get(0));
        
        int i = 0;
        for(int j = 1; j< arrayList.size(); j++){
                if (res.get(i)[1] <= arrayList.get(j)[0]){
                    res.add(arrayList.get(j));
                    i++;
            }
        }

        System.out.println(res.size());
        for(Double[] el : res){
            System.out.println(Arrays.toString(el));
        }
    }

    public static void task3(){
        Scanner sc = new Scanner(System.in);
        int kg = sc.nextInt();
        int countHeap = sc.nextInt();
        sc.nextLine();
        ArrayList<Integer[]> arrayList = new ArrayList<>();

        for(int i = 0; i < countHeap; i++){
            Integer[] hours = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            arrayList.add(hours);
        }

        arrayList.sort(Comparator.comparing((Integer[] arr) -> arr[0]).reversed());

        int sum = 0;
        int k = 0;
        for(Integer[] el : arrayList){
            for(int i = 1; i <= el[1]; i++){
                sum+=el[0];
                k++;
                if (k ==kg){
                    break;
                }
            }
        }
       System.out.println(sum);
    }

    public static void task4() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        System.out.println(dp[n]);
    }

    public static void task5() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int m = sc.nextInt();

        int[] value = new int[m];
        for (int i = 0; i < m; i++) {
            value[i] = sc.nextInt();
        }

        int[] dp = new int[x + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= x; i++) {
            for (int nom : value) {
                if (nom <= i) {
                    dp[i] = Math.min(dp[i], dp[i - nom] + 1);
                }
            }
        }
        System.out.println(dp[x] == Integer.MAX_VALUE ? -1 : dp[x]);
    }

    public static void task6() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int m = sc.nextInt();

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;


        for (int i = 3; i <= n; i++) {
            for (int j = m; j > 0; j--) {
                if (i - j > 0) {
                    dp[i] += dp[i - j];
                }
            }
        }
        System.out.println(dp[n]);
    }

    public static void task7() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // нужная сумма
        int n = sc.nextInt(); // количество номиналов

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        long[] dp = new long[t + 1];
        dp[0] = 1; // базовый случай

        // Перебираем номиналы во внешнем цикле
        for (int coin : coins) {
            for (int i = coin; i <= t; i++) {
                dp[i] += dp[i - coin];
            }
        }

        System.out.println(dp[t]);
    }

    public static void task8() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] points = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                points[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[n + 1][m + 1];
        dp[n - 1][1] = points[n - 1][0];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= m; j++) {
                if (i == n - 1 & j == 1) continue;
                dp[i][j] += Integer.max(dp[i][j - 1], dp[i + 1][j]) + points[i][j - 1];
            }
        }

        int i = 0, j = m-1;
        StringBuilder stringBuilder = new StringBuilder();
        while(i <n-1 || j >0){
            if(i < n-1 && (j == 0 || dp[i+1][j] >= dp[i][j-1])){
                stringBuilder.append('U');
                i++;
            }
            else {
                stringBuilder.append('R');
                j--;
            }
        }
        System.out.println(dp[0][m]);
        System.out.println(stringBuilder.reverse());
    }
    public static void task9(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] numbers = new int[N+1];
        for(int i = 1; i <= N; i++){
            numbers[i] = sc.nextInt();
        }

        int[][] dp = new int[N+1][M+1];

        for(int i = 1; i <=N; i++){
            for(int j = 1; j <=M; j++){
                if(numbers[i]>j){
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Integer.max(dp[i-1][j], dp[i-1][j-numbers[i]] + numbers[i]);
                }
            }
        }
        System.out.println(dp[N][M]);
    }
    public static void task10(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] weight = new int[N+1];
        for(int i = 1; i <= N; i++){
            weight[i] = sc.nextInt();
        }

        int[] value = new int[N+1];
        for(int i = 1; i <= N; i++){
            value[i] = sc.nextInt();
        }

        int[][] dp = new int[N+1][M+1];

        for(int i = 1; i <=N; i++){
            for(int j = 1; j <=M; j++){
                if(weight[i]>j){
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Integer.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i]);
                }
            }
        }
        System.out.println(dp[N][M]);
        int i = N, w = M;
        ArrayList<Integer> list = new ArrayList<>();

        while(i>0 && w > 0){
            if(dp[i][w] > dp[i-1][w]){
                list.add(i);
                w -= weight[i];
            }
            i--;
        }
        System.out.println(list);

    }
    public static void task11(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] string1 = new int[N+1];
        for(int i = 1; i <= N; i++){
            string1[i] = sc.nextInt();
        }

        int M = sc.nextInt();

        int[] string2 = new int[M+1];
        for(int i = 1; i <= M; i++){
            string2[i] = sc.nextInt();
        }

        int[][] dp = new int[N+1][M+1];

        for(int i = 1; i <=N; i++){
            for(int j = 1; j <=M; j++){
                if(string1[i] == string2[j]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else {
                    dp[i][j] = Integer.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[N][M]);

        int i = N, w = M;
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        while(i > 0 && w > 0){
            if(string1[i] == string2[w]){
                list1.add(i);
                list2.add(w);
                i--;
                w--;
            }
            else {
               if(dp[i-1][w]>dp[i][w-1]){
                   i--;
               }
               else {
                   w--;
               }

            }
        }
        System.out.println(list1);
        System.out.println(list2);

    }
    public static void task12(){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] numbers = new int[N];
        for(int i = 0; i < N; i++){
            numbers[i] = sc.nextInt();
        }

        int dp[] = new int[N];
        Arrays.fill(dp,1);
        System.out.println(Arrays.toString(dp));


        for(int i = 1; i < N; i++){
            for(int j = 0; j<i; j++){
                if(numbers[i] > numbers[j] && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                }
            }
        }
        System.out.println(dp[N-1]);
    }

    public static void fin1(){
        Scanner sc = new Scanner(System.in);
        String[] stringOne = sc.nextLine().split("");
        String[] stringTwo = sc.nextLine().split("");

        int[][] dp = new int[stringOne.length+1][stringTwo.length+1];

        for(int i = 0; i<stringOne.length+1;i++){
            dp[i][0] = i;
        }

        for(int i = 0; i<stringTwo.length+1;i++){
            dp[0][i] = i;
        }

        for (int i = 1; i <= stringOne.length; i++) {
            for (int j = 1; j <= stringTwo.length; j++) {
                if(Objects.equals(stringOne[i-1], stringTwo[j-1])){
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                }
            }
        }
        System.out.println(dp[stringOne.length][stringTwo.length]);
    }
    public static boolean fin2(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] string = new int[n];
        int total = 0;

        for(int i = 0; i<n;i++){
            int x = sc.nextInt();
            total+=x;
            string[i] = x;
        }

        if(total%2!=0){
            return false;
        }
        int half = total / 2;

        boolean[] dp = new boolean[half + 1];
        dp[0] = true;

        for (int score : string) {
            for (int j = half; j >= score; j--) {
                if (dp[j - score]) {
                    dp[j] = true;
                }
            }
        }
        return dp[half];
    }
}
