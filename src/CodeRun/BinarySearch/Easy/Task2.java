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

class Node {
    int value;
    Node left;
    Node right;

    /**
     *  это обязательное значение, которое определяет содержимое узла дерева.
     *  Без ключа узел не имеет смысла, поэтому при создании нового
     *  узла обязательно нужно задать его ключ.
     * Поля left и right (ссылки на левого и правого потомка)
     * по умолчанию инициализируются как null, что логично для нового листового узла - у него пока нет детей.
     */
    public Node(int value) {
        this.value = value;
    }
}

class Result{
    int height;
    boolean balanced;

    public Result(int height, boolean balanced){
        this.balanced = balanced;
        this.height = height;
    }
}

public class Task2 {

    static Node insert (Node root, int value){
        if(root == null){
            return new Node(value);
        }
        if(value > root.value){
            root.right = insert(root.right, value);
        }
        else if(value == root.value){ // ОБРАТИ ВНИМАНИЕ НА ЭТУ СТРОКУ!!! тут мы орабатываем одинаковые значения
            return root;
        }
        else {
            root.left = insert(root.left,value);
        }
        return root;
    }

    static Result check(Node root){
        if(root == null){
            return new Result(0,true); //для листьев возвращаем высоту 0
        }
        // идем по дереву вверх
        Result leftR = check(root.left);
        Result rightR = check(root.right);

        //по спец формулам вычисляем высоту след узла
        int height = Math.max(leftR.height, rightR.height)+1;
        //проверяем что обе стороны сбалансированы и разница между высотами не больше 1
        boolean balanced = leftR.balanced && rightR.balanced &&
                Math.abs(leftR.height - rightR.height) <= 1;

        return new Result(height, balanced);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       Node root = null;

       while(true){
           int x = sc.nextInt();
           if (x == 0) break;
           root = insert(root,x);
       }

        Result res = check(root);
        System.out.println(res.balanced ? "YES" : "NO");


    }
}
