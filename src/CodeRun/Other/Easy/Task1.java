package CodeRun.Other.Easy;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;


//Рассмотрим три числа a b и c. Упорядочим их по возрастанию.
//Какое число будет стоять между двумя другими?

/** Задача реализована двумя методами: ручной перебор и реализация быстрой сортировки.
 * Первый способ является простым в реализации и понимании, но громоздкий.
 * Второй способ универсален по количеству чисел и краток по содержанию.
 */

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        ArrayList<Integer> nums = new ArrayList<>();
        for (String word : words) {
            nums.add(Integer.valueOf(word));
        }
        ArrayList<Integer> result = new ArrayList<>();
       if (nums.getFirst()>nums.get(1) && nums.getFirst()> nums.getLast()){
           if (nums.get(1)>nums.getLast()){
               result.add(nums.getLast());
               result.add(nums.get(1));
               result.add(nums.getFirst());
           }
           else {
               result.add(nums.get(1));
               result.add(nums.getLast());
               result.add(nums.getFirst());
           }
       }
        if (nums.getFirst()<nums.get(1) && nums.getFirst()> nums.getLast() || nums.getFirst()>nums.get(1) && nums.getFirst()<nums.getLast()){
            if(nums.getLast()>nums.get(1)){
                result.add(nums.get(1));
                result.add(nums.getFirst());
                result.add(nums.getLast());
            }
            else {
                result.add(nums.getLast());
                result.add(nums.getFirst());
                result.add(nums.get(1));
            }
        }
        if(nums.getFirst()<nums.get(1) && nums.getFirst()<nums.getLast()) {
            if (nums.get(1) > nums.getLast()) {
                result.add(nums.getFirst());
                result.add(nums.getLast());
                result.add(nums.get(1));
            } else result = nums;
        }
        ArrayList<Integer> res = quickSort(nums);
        System.out.println(res);
    }

    public static ArrayList<Integer> quickSort(ArrayList<Integer> nums){
        if (nums.isEmpty()) {
            return nums;
        }
        int middleIndex = nums.size()/2;
        int middleEl = nums.get(middleIndex);
        ArrayList<Integer> lessCounters = new ArrayList<>();
        ArrayList<Integer> bigCounters = new ArrayList<>();
        ArrayList<Integer> middleCounters = new ArrayList<>();


        for (Integer el : nums){
            if (el>middleEl){
                bigCounters.add(el);
            }
            else if (el<middleEl){
                lessCounters.add(el);
            }
            else {middleCounters.add(el);}
        }
        ArrayList<Integer> result = new ArrayList<>(quickSort(lessCounters));
        result.addAll(middleCounters);
        result.addAll(quickSort(bigCounters));
        return result;
    }
}
