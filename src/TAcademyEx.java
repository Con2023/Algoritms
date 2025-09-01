import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import java.util.Scanner;

public class TAcademyEx {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().trim().split("\\s+");
        double X = Double.parseDouble(size[0]);
        double Y = Double.parseDouble(size[1]);

        String[] planPoints = br.readLine().trim().split("\\s+");
        if (planPoints.length < 8) {
            StringBuilder sb = new StringBuilder();
            while (sb.length() < 15) {
                sb.append(" ").append(br.readLine().trim());
                planPoints = (String.join(" ", planPoints) + sb.toString()).trim().split("\\s+");
                if (planPoints.length >= 8) break;
            }
        }

        double x0 = Double.parseDouble(planPoints[0]);
        double y0 = Double.parseDouble(planPoints[1]);
        double x1 = Double.parseDouble(planPoints[2]);
        double y1 = Double.parseDouble(planPoints[3]);
        double x2 = Double.parseDouble(planPoints[4]);
        double y2 = Double.parseDouble(planPoints[5]);
        double x3 = Double.parseDouble(planPoints[6]);
        double y3 = Double.parseDouble(planPoints[7]);

        double a = (x1 - x0) / X;
        double b = (x3 - x0) / Y;
        double c = (y1 - y0) / X;
        double d = (y3 - y0) / Y;

        double m00 = 1 - a;
        double m01 = -b;
        double m10 = -c;
        double m11 = 1 - d;

        double e = x0;
        double f = y0;

        double det = m00 * m11 - m01 * m10;
        if (Math.abs(det) < 1e-15) {
            System.out.printf("%.6f %.6f\n", 0.0, 0.0);
            return;
        }

        double inv00 = m11 / det;
        double inv01 = -m01 / det;
        double inv10 = -m10 / det;
        double inv11 = m00 / det;

        double Xp = inv00 * e + inv01 * f;
        double Yp = inv10 * e + inv11 * f;

        System.out.printf("%.6f %.6f\n", Xp, Yp);
    }
}

//public class TAcademyEx {
//    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        for(int i = 0; i < n; i++){
//            int num = scanner.nextInt();
//            arrayList.add(num);
//        }
//        System.out.println(arrayList);
//
//        long sum = 0;
//
//        for (int x = l; x <= r; x++) {
//            if (x % p == 0) {
//                continue;
//            }
//            long inv = modInverse(x, p);
//            sum = (sum + inv) % p;
//        }
//
//        System.out.println(sum);
//    }
//
//    public static long modInverse(int x, int p) {
//        return pow(x, p - 2, p);
//    }
//
//    public static long pow(int base, int exponent, int mod) {
//        long result = 1;
//        long x = base % mod;
//
//        while (exponent > 0) {
//            if (exponent % 2 == 1) {
//                result = (result * x) % mod;
//            }
//            x = (x * x) % mod;
//            exponent /= 2;
//        }
//
//        return result;
//    }
//
//}

//public class TAcademyEx {
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(reader.readLine());
//        Integer[] array = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
//        int a = array[0];
//        int b = array[1];
//        int c = array[2];
//
//        int count = 0;
//
//        boolean[] dp = new boolean[n+1];
//
//        dp[1] = true;
//
//        for(int i = 1; i <=n; i++) {
//            if(dp[i]) {
//                if (i + a <= n) dp[i + a] = true;
//                if (i + b <= n) dp[i + b] = true;
//                if (i + c <= n) dp[i + c] = true;
//                count++;
//            }
//        }
//
//        System.out.println(count);
//    }
//
//}


//Task1
//        Integer[] array =Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
//        int credit = 0;
//        if (array[3] > array[1]){
//            credit = (array[3] - array[1])*array[2];
//        }
//        System.out.println(array[0]+credit);

//Task2
//int res = (int) Math.ceil(Math.log(n)/Math.log(2));
//        System.out.println(res);

//Task3
//public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        Integer[] array = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
//        int n = array[0];
//        int t = array[1];
//        Integer[] arrayFloor = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
//        int k = Integer.parseInt(reader.readLine());
//
//        int sum;
//        int floorTo;
//        int floorAfter;
//
//        if (arrayFloor[k-1] <= t){
//            sum = arrayFloor[n-1]-arrayFloor[0];
//        }
//        else{
//            floorTo = arrayFloor[k-1] - arrayFloor[0];
//            floorAfter = arrayFloor[n-1] - arrayFloor[k-1];
//            sum = Math.min(floorTo * 2 + floorAfter, floorTo + floorAfter * 2);
//
//        }
//        System.out.println(sum);
//    }
//Task4
//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        Integer[] array = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
//        int n = array[0];
//        int k = array[1];
//
//        String[] numbers = reader.readLine().split(" ");
//
//        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
//
//        for (String numStr : numbers) {
//            char[] digits = numStr.toCharArray();
//            for (int i = 0; i < digits.length; i++) {
//                char originalDigit = digits[i];
//                digits[i] = '9';
//                long newNum = Long.parseLong(new String(digits));
//                long diff = newNum - Long.parseLong(numStr);
//                maxHeap.add(diff);
//                digits[i] = originalDigit;
//            }
//        }
//
//        long maxIncrease = 0;
//        for (int i = 0; i < k && !maxHeap.isEmpty(); i++) {
//            maxIncrease += maxHeap.poll();
//        }
//
//        System.out.println(maxIncrease);
//    }
//Task5
//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        Integer[] array = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
//        long l = array[0];
//        long r = array[1];
//
//        int count = 0;
//
//        for(int length = 1; length < 19; length++){
//            for (int digit = 1; digit < 10; digit++){
//                long num = check(digit, length);
//                if(num>l && num<r){
//                    count++;
//                }
//            }
//        }
//        System.out.println(count);
//    }
//
//    public static long check(int d, int l){
//        long num = 0;
//        for (int i = 0; i < l; i++) {
//            num = num * 10 + d;
//        }
//        return num;
//    }
//}
//Task6
// Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] heights = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            heights[i] = scanner.nextInt();
//        }
//
//        int evenCount = 0, oddCount = 0;
//        for (int height : heights) {
//            if (height % 2 == 0) evenCount++;
//            else oddCount++;
//        }
//
//        if (Math.abs(evenCount - oddCount) > 1) {
//            System.out.println("-1 -1");
//            return;
//        }
//
//        List<Integer> evenAtOddPos = new ArrayList<>();
//        List<Integer> oddAtEvenPos = new ArrayList<>();
//
//        for (int i = 0; i < n; i++) {
//            int pos = i + 1;
//            if (heights[i] % 2 == 0 && pos % 2 != 0) {
//                evenAtOddPos.add(i);
//            } else if (heights[i] % 2 != 0 && pos % 2 == 0) {
//                oddAtEvenPos.add(i);
//            }
//        }
//
//        if (evenAtOddPos.size() == 1 && oddAtEvenPos.size() == 1) {
//            System.out.println((evenAtOddPos.getFirst() + 1 + " " + (oddAtEvenPos.getFirst() + 1)));
//        } else if (evenAtOddPos.isEmpty() && oddAtEvenPos.isEmpty()) {
//            System.out.println("-1 -1");
//        } else {
//            System.out.println("-1 -1");
//        }
//    }
//
//}