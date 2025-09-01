import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Classss{
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(read.readLine());
        System.out.println(Eratosthenes(num));
    }
    public static ArrayList<Integer> Eratosthenes(int num){
        ArrayList<Integer> simpleNums = new ArrayList<>();
        int[] nums = new int[num];
        for(int i = 0; i < num; i++){
            nums[i] = i;
        }
        nums[1] = 0;
        for(int k = 2; k<num; k++){
            if(nums[k] != 0){
                for (int j = k*k; j < num; j+=k){
                    nums[j] = 0;
                }
            }
        }
        for(Integer el : nums){
            if (el!=0) {
                simpleNums.add(el);
            }
        }
        return simpleNums;
    }
}

