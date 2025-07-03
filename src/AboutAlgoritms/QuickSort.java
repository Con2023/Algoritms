package AboutAlgoritms;

import java.util.ArrayList;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] numbers = scan.nextLine().split(" ");

        ArrayList<Integer> nums = new ArrayList<>();
        for (String n : numbers) {
            nums.add(Integer.parseInt(n));
        }

        ArrayList<Integer> newArrayList = quickSort(nums);
        System.out.println(newArrayList);
    }

    public static ArrayList<Integer> quickSort(ArrayList<Integer> integers){
        ArrayList<Integer> arrLess = new ArrayList<>();
        ArrayList<Integer> arrBigger = new ArrayList<>();

        if (integers.size() == 1 || integers.isEmpty()){
            return integers;
        }

        int index = integers.size()/2;
        int element = integers.get(index);

       for(int i = 0; i<integers.size(); i++) {
            if (integers.get(i)<element){
                arrLess.add(integers.get(i));
            }
            else if(integers.get(i)>element){
                arrBigger.add(integers.get(i));
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
       result.addAll(quickSort(arrLess));
       result.add(element);
       result.addAll(quickSort(arrBigger));

        return result;
    }
}
