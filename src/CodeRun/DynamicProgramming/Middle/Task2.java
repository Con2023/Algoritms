package CodeRun.DynamicProgramming.Middle;

import java.util.Scanner;

/**
 * Дана прямоугольная доска N×M (N строк и M столбцов).
 * В левом верхнем углу находится шахматный конь, которого необходимо переместить в правый нижний угол доски.
 * В данной задаче конь может перемещаться на две клетки вниз и одну клетку вправо или на одну клетку вниз и две клетки вправо.
 * Необходимо определить, сколько существует различных маршрутов, ведущих из левого верхнего в правый нижний угол.
 * Входной файл содержит два натуральных числа N и M (1⩽N,M⩽50)
 */
public class Task2 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int n = scanner.nextInt();
            int m = scanner.nextInt();

            int[][] board = new int[n + 2][m + 2];
            board[0][1] = 1;
            for (int i = 2; i < n + 2; ++i) {
                for (int j = 2; j < m + 2; ++j) {
                    board[i][j] = board[i - 2][j - 1] + board[i - 1][j - 2];
                }
            }
            System.out.println(board[n + 1][m + 1]);
        }

}

