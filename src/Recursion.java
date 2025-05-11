public class Recursion {
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
