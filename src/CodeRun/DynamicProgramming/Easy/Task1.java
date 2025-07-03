package CodeRun.DynamicProgramming.Easy;

/** 150. Три единицы подряд
По данному числу N определите количество последовательностей из нулей и единиц длины N,
 в которых никакие три единицы не стоят рядом.

Формат ввода
Во входном файле написано натуральное число N, не превосходящее 35.

 Формат вывода
Выведите количество искомых последовательностей. Гарантируется, что ответ не превосходит
*/


//Последовательности - это бинарные строки, которые содержат рандомно 0 и 1.
// Например, если N равен 2 то выбор булет 0 1 01 и 10 то есть равен 2^N

import java.util.Scanner;

public class Task1 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            System.out.println(countGoodSequences(N));
            System.out.println(((int) Math.pow(2, N) - countGoodSequences(N)));
        }
        public static int countGoodSequences(int N) {
            if (N == 0) return 1;
            if (N == 1) return 2;
            if (N == 2) return 4;

            int[] dp = new int[N + 1];
            dp[0] = 1;
            dp[1] = 2;
            dp[2] = 4;
            for (int i = 3; i <= N; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
            return dp[N];
        }
}
