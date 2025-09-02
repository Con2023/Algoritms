package Practicum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class NodeDoub<V>{
    public NodeDoub<V> next;
    public V value;
    public NodeDoub<V> previous;
    public NodeDoub(V value, NodeDoub<V> next, NodeDoub<V> previous){
        this.value = value;
        this.next = next;
        this.previous = previous;
    }
}

class Node<V>{
    public Node<V> next;
    public V value;
    public Node(V value, Node<V> next){
        this.value = value;
        this.next = next;
    }
}

class linkedListAndSize{
    int size;
    Node<String> head;

    public linkedListAndSize(Node<String> head, int size){
        this.size = size;
        this.head = head;
    }
}
public class Sprint2 {
    public static void main(String[] args) throws IOException {
        Deck();

//        Practicum.linkedListAndSize perm = getLinkedList();
//        Practicum.Node<String> head = perm.head;
//        int size = perm.size;
//     //   System.out.println(size);
//     //   printLinkedList(head);
//        Random random = new Random();
//        int num = random.nextInt(8);
//      //  Practicum.linkedListAndSize permAfterDel = deleteFromLinkedList(head,num,size) ;
//      //  Practicum.Node<String> headAfterDel = permAfterDel.head;
//      //  int sizeAfterDel = permAfterDel.size;
//      //  System.out.println(sizeAfterDel);
//     //   printLinkedList(headAfterDel);
//       // System.out.println(findElOnIndex(head, "Клиент", size));
//        printDoubleLinkedList(createFromNodeToNodeDoub(head));


    }


    public static void task1() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        StringBuilder stringOrig = new StringBuilder();
        StringBuilder stringNew = new StringBuilder();

        for(int i = 0; i < n;i++){
            String string = reader.readLine().replace(" ","");
            stringOrig.append(string);
        }

        for (int j = 0; j < m; j++){
            for (int i = j; i < n*m; i+=m){
                stringNew.append(stringOrig.charAt(i)).append(" ");
            }
            stringNew.append("\n");
        }
        System.out.print(stringNew.toString().trim());

    }
    public static void task11() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        int [][] matrixOrig = new int [n][m];
        for(int i = 0; i < n; i++){
            String[] let = reader.readLine().split(" ");
            for(int j = 0; j < m; j++){
                matrixOrig[i][j] = Integer.parseInt(let[j]);
            }
        }

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                System.out.print(matrixOrig[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static linkedListAndSize getLinkedList(){

        String[] tasks = {"Завтрак", "Почта", "План на день", "Клиент", "Отчет",
                "Обед", "Проект", "Пробежка", "Книга"};
        int size = 1;

        Node<String> head = new Node<>(tasks[0], null);
        Node<String> current = head;

        for(int i = 1; i<tasks.length; i++){
            current.next = new Node<>(tasks[i], null); // у нас уже есть текущий и для него мы создаем следующий,
            // то есть к current мы добавляем ссылку на следующий  элемент в виде current.next и она будет равна новой ноде со значением и null ссылкой на след.
            // Теперь текцщим становиться следущий элемент.
            current = current.next;
            size++;
        }

        return new linkedListAndSize(head, size);
    }

    public static void printLinkedList(Node<String> head){
        Node<String> current = head;
        while (current!=null){
            System.out.println(current.value);
            current = current.next;
        }
    }
    public static void printDoubleLinkedList(NodeDoub<String> head){
        NodeDoub<String> currentStart = head;

        while (currentStart.next!=null){
            System.out.println(currentStart.value);
            currentStart = currentStart.next;
        }
        NodeDoub<String> currentEnd = currentStart;

        while (currentEnd.previous!=null) {
            currentEnd = currentEnd.previous;
            System.out.println(currentEnd.value);
        }
    }


    public static linkedListAndSize deleteFromLinkedList(Node<String> head, int index, int size){
        Node<String> current = head;

        if(index == 0){
            current = current.next;
        }
        else if(index == size-1){
            for(int i = 0; i<size-2; i++){
                current = current.next;
            }
            current.next = null;
        }
        else {
            for(int i = 1; i < index-1; i++){
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
        return new linkedListAndSize(current, size);
    }

    public static int findElOnIndex(Node<String> head, String el, int size){
        Node<String> current = head;

        for(int i = 0; i < size-1; i++){
            if( current.value != el){
                current = current.next;
            }
            else return i;
        }
        return -1;

    }
    public static NodeDoub<String> createFromNodeToNodeDoub(Node<String> head){

        NodeDoub<String> headNodeD = new NodeDoub<>(head.value, null,null);
        NodeDoub<String> current = headNodeD;
        Node<String> curr = head.next;

        while(curr != null){
            NodeDoub<String> newNodeDoub = new NodeDoub<>(curr.value, null, current);
            current.next = newNodeDoub;
            current = newNodeDoub;

            curr = curr.next;
        }

        return headNodeD;
    }

    public static void StackMax() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(reader.readLine());
        ArrayList<Integer> maxList = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int num =Integer.MIN_VALUE;
        String command = "";

        while(n!=0) {

            String[] string = reader.readLine().split(" ");
            n= n-1;
            if (string.length == 1) {
                command = string[0];
            } else {
                command = string[0];
                num = Integer.parseInt(string[1]);
            }

            switch (command) {
                case "push":
                    stack.push(num);
                    maxList.add(num);
                    if (num > max) {
                        max = num;
                    }
                    break;
                case "get_max":
                    if (stack.isEmpty()) {
                        System.out.println("None");
                    } else System.out.println(Collections.max(maxList));
                    break;

                case "pop":
                    if (stack.isEmpty()) {
                        System.out.println("error");
                    } else {
                        stack.pop();
                        maxList.removeLast();
                    }
                    break;
            }
        }
    }

    public static void StackMaxOn() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(reader.readLine());
        Stack<Integer> onlyMax = new Stack<>();

        int num =Integer.MIN_VALUE;
        String command = "";

        while(n!=0) {
            String[] string = reader.readLine().split(" ");
            n= n-1;
            if (string.length == 1) {
                command = string[0];
            } else {
                command = string[0];
                num = Integer.parseInt(string[1]);
            }

            switch (command) {
                case "push":
                    stack.push(num);
                    if (onlyMax.isEmpty() || num >= onlyMax.peek()) {
                        onlyMax.push(num);
                    }
                    break;

                case "get_max":
                    if (stack.isEmpty()) {
                        System.out.println("None");
                    } else System.out.println(onlyMax.peek());
                    break;

                case "pop":
                    if (stack.isEmpty()) {
                        System.out.println("error");
                    } else {
                        int delEl = stack.pop();
                        if(delEl == onlyMax.peek())
                         onlyMax.pop();
                    }
                    break;
            }
        }
    }

    public static boolean correct() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();
        char[] answer = reader.readLine().toCharArray();
        for(char el: answer){
            String elS = String.valueOf(el);
            if(!stack.isEmpty() &&(elS.equals("}") && Objects.equals(stack.peek(), "{") || elS.equals(")") && Objects.equals(stack.peek(), "(") || elS.equals("]") && Objects.equals(stack.peek(), "["))){
                stack.pop();
            }
            else stack.push(elS);
        }
        if(stack.isEmpty()) return true;
        else return false;
    }

    public static void queueLimit() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(reader.readLine());
        int max_size = Integer.parseInt(reader.readLine());
        String command = "";
        int num = Integer.MIN_VALUE;
        int size = 0;

        while(n!=0) {
            String[] string = reader.readLine().split(" ");
            n= n-1;
            if (string.length == 1) {
                command = string[0];
            } else {
                command = string[0];
                num = Integer.parseInt(string[1]);
            }

            switch (command) {
                case "push":
                    if(size >= max_size){
                        System.out.println("None");
                    }
                    else {
                        queue.offer(num);
                        size++;
                    }
                    break;

                case "pop":
                    if (queue.isEmpty()) {
                        System.out.println("error");
                    } else {
                        int delEl = queue.poll();
                        size--;
                        System.out.println(delEl);
                    }
                    break;

                case "peek":
                    if (queue.isEmpty()) {
                        System.out.println("None");
                    } else {
                        System.out.println(queue.peek());
                    }
                    break;

                case "size":
                    System.out.println(size);
                    break;
            }
        }
    }

    public static int Fib(int n){
        if( n == 1 || n == 0){
            return 1;
        }
        return (Fib(n-1) + Fib(n -2));
    }
    public static int fibMod(int n, int k){
        int num = Fib(n);
        int modulus = (int) Math.pow(10, k);
        return num%modulus;

    }

    public static void Deck() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> queue = new ArrayDeque<>();
        int n = Integer.parseInt(reader.readLine());
        int max_size = Integer.parseInt(reader.readLine());
        String command = "";
        int num = Integer.MIN_VALUE;
        int size = 0;

        while(n!=0) {
            String[] string = reader.readLine().split(" ");
            n= n-1;
            if (string.length == 1) {
                command = string[0];
            } else {
                command = string[0];
                num = Integer.parseInt(string[1]);
            }

            switch (command) {
                case "push_back":
                    if(size >= max_size){
                        System.out.println("error");
                    }
                    else {
                        queue.addLast(num);
                        size++;
                    }
                    break;
                case "push_front":
                    if(size >= max_size){
                        System.out.println("error");
                    }
                    else {
                        queue.addFirst(num);
                        size++;
                    }
                    break;

                case "pop_front":
                    if (queue.isEmpty()) {
                        System.out.println("error");
                    } else {
                        int delEl = queue.removeFirst();
                        size--;
                        System.out.println(delEl);
                    }
                    break;

                case "pop_back":
                    if (queue.isEmpty()) {
                        System.out.println("error");
                    } else {
                        int delEl = queue.removeLast();
                        size--;
                        System.out.println(delEl);
                    }
                    break;

                case "size":
                    System.out.println(size);
                    break;
            }
        }
    }
}

