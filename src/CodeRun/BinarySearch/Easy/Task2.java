package CodeRun.BinarySearch.Easy;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Дерево называется АВЛ-сбалансированным, если для любой его вершины высота левого
 * и правого поддерева для этой вершины различаются не более чем на 1.
 * Формат ввода
 * Вводится последовательность целых чисел, оканчивающаяся нулем.
 * Сам ноль в последовательность не входит. Постройте дерево,
 * соответствующее данной последовательности.
 * Формат вывода
 * Определите, является ли дерево сбалансированным, выведите слово YES или NO.
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>();
        int num = Integer.MIN_VALUE;
        while (num != 0){
            num = sc.nextInt();
            nums.add(num);
        }
        System.out.println(nums);


    }
}
