package AboutAlgoritms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Eratosthenes {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(read.readLine());
        System.out.println(Eratosthen(num));
    }
    public static ArrayList<Integer> Eratosthen(int num){
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

