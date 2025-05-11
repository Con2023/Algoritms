import java.util.Scanner;

/**
 * Игра угадай число. Программа применяет бинарный поиск для отгадывания числа пользователя.
 */

public class PlayGuessNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задайте нижние значение:");
        int low = scanner.nextInt();

        System.out.println("Задайте верхнее значение:");
        int big = scanner.nextInt();
        int[] arr = new int[big-low+1];

        for ( int i = 0; i < arr.length; i++){
            arr[i] = low;
            low++;
        }
        scanner.nextLine();

        int indexFirst = 0;
        int indexLast = arr.length-1;


        while (indexFirst<=indexLast){
            int middle = (indexFirst + indexLast)/2;
            int res = arr[middle];
            System.out.println(String.format("Ваше число %s?",res));
            System.out.println("Напишите да/меньше/больше.");
            String answer = scanner.nextLine().trim().toLowerCase();;
            if (answer.equals("да")){
                System.out.println("Я победил!");
                return;
            }
            else if(answer.equals("меньше")){
                indexLast = middle-1;
            }
            else if(answer.equals("больше")) {
                indexFirst = middle+1;
            }
            else {
                System.out.println("Что-то странное Вы ввели(");
                return;
            }
        }
        System.out.println("Число не найдено. Возможно, вы ошиблись в ответах.");
    }

}
