
import java.util.Scanner;
import java.util.Stack;

class Recursion {

    public static void main(String[] args){
        count(3);
    }
    public static void count(int num){

        System.out.println(num);
        if(num<=0){
            return;
        }
        else {
            count(num - 1);
        }
    }

}



public class Recursion1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] string = scan.nextLine().toLowerCase().split(" ");
        Stack<Integer> nums = new Stack<>();

        for(String el : string){
            nums.add(Integer.parseInt(el));
        }


        System.out.println("Количество: " + count((Stack<Integer>) nums.clone()));
        System.out.println("Результат: " + sum((Stack<Integer>) nums.clone()));
        System.out.println("Результат: " + findMax((Stack<Integer>) nums.clone(), 0 ));
    }

    public static int sum(Stack<Integer> integers){

        if (integers.isEmpty()){
            return 0;
        }
        else {
            return integers.pop() + sum(integers);
        }
    }

    public static int count(Stack<Integer> integers){

        if (integers.isEmpty()){
            return 0;
        }
        else {
            integers.pop();
            return 1 + count(integers);
        }
    }

    public static int findMax(Stack<Integer> stack, int index) {
        if (stack.isEmpty() || index > stack.size()-1) {
            return Integer.MIN_VALUE;
        }
        int current = stack.get(index);
        int maxRes = findMax(stack,index+1);
        return Math.max(current, maxRes);
    }

}
