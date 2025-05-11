import java.util.ArrayList;
import java.util.Scanner;

public class SortChoice {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String[] numbers = scan.nextLine().split(" ");

        ArrayList<Integer> nums = new ArrayList<>();
        for (String n : numbers) {
            nums.add(Integer.parseInt(n));
        }

        ArrayList<Integer> newArrayList = new ArrayList<>();
        while (!nums.isEmpty()){
            int smallEl = nums.get(findSmallEl(nums));
            newArrayList.add(smallEl);
            nums.remove(findSmallEl(nums));
        }
        System.out.println(newArrayList);

    }
    public static int findSmallEl(ArrayList<Integer> nums){
        int smallindex = 0;
        int smallNum = nums.getFirst();

        for(int i = 0; i < nums.size(); i++){
            if (smallNum>nums.get(i)){
                smallNum = nums.get(i);
                smallindex = i;
            }
        }

        return smallindex;

    }

}
//public class SortChoice {
//    public static void main(String[] args){
//        Scanner scan = new Scanner(System.in);
//        String[] numbers = scan.nextLine().split(" ");
//
//        ArrayList<Integer> nums = new ArrayList<>();
//        for (String n : numbers) {
//            nums.add(Integer.parseInt(n));
//        }
//
//        ArrayList<Integer> newArrayList = new ArrayList<>();
//        while (!nums.isEmpty()){
//            int smallEl = findSmallEl(nums);
//            newArrayList.add(smallEl);
//            nums.remove(Integer.valueOf(smallEl));
//        }
//        System.out.println(newArrayList);
//
//    }
//    public static int findSmallEl(ArrayList<Integer> nums){
//        int smallNum = nums.getFirst();
//
//        for(int i = 0; i < nums.size(); i++){
//            if (smallNum>nums.get(i)){
//                smallNum = nums.get(i);
//
//            }
//        }
//
//        return smallNum;
//
//    }
//
//}
