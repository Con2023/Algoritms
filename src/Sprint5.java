import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

class Nodee {
    int value;
    Nodee left;
    Nodee right;

    public Nodee(int value) {
        this.left = null;
        this.right = null;
        this.value = value;
    }

    public static void print(Nodee node) {
        if (node == null) return;
        System.out.println(node.value);
        print(node.left);
        print(node.right);
    }

    public static int treeSolution1(Nodee node) {

        int max = node.value;

        if (node.left != null) {
            max = Math.max(max, treeSolution1(node.left));
        }
        if (node.right != null) {
            max = Math.max(max, treeSolution1(node.right));
        }
        return max;
    }

    public static boolean treeSolution2(Nodee node, int min, int max) {
        if (node == null) {
            return true;
        }
        int val = node.value;
        if (val <= min || val >= max) {
            return false;
        }
        if ((!treeSolution2(node.left, min, val)) || (!treeSolution2(node.right, val, max))) return false;
        return true;
    }

    public static ArrayList<Integer> treeSolution3(Nodee node, int a, int b) {
        ArrayList<Integer> nums = new ArrayList<>();
        if (node != null) {
            int value = node.value;
            nums.addAll(treeSolution3(node.left, a, b));
            if ((value >= a) && (value <= b)) {
                nums.add(value);
            }
            nums.addAll(treeSolution3(node.right, a, b));
        }
        return nums;
    }

    public static Nodee insert(Nodee node, int key) {
        if (key >= node.value) {
            if (node.right == null) {
                node.right = new Nodee(key);
            } else {
                insert(node.right, key);
            }
        }
        if (key < node.value) {
            if (node.left == null) {
                node.left = new Nodee(key);
            } else {
                insert(node.left, key);
            }
        }
        return node;
    }
    private static Nodee findMax(Nodee node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public static Nodee delete(Nodee node, int key) {
        if (node == null) return null;
        if (key > node.value) node.right = delete(node.right, key);
        else if (key < node.value) node.left = delete(node.left, key);
        else {
            if (node.left == null && node.right == null) {
                return null;
            }
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Nodee maxEl = findMax(node.left);
            node.value = maxEl.value;
            node.left = delete(node.left, maxEl.value);
        }
        return node;
    }

    public static int checkedABL(Nodee node){
        if(node == null){
            return 0;
        }
        int leftCount = checkedABL(node.left);
        if(leftCount == -1){
            return -1;
        }
        int rightCount = checkedABL(node.right);
        if(rightCount == -1){
            return -1;
        }
        if(Math.abs(leftCount - rightCount) > 1){
            return -1;
        }
        return Math.max(leftCount,rightCount)+1;
    }
    public static int siftDownCheck(int[] heap, int index) {
        int indexLeft = 2 * index + 1;
        int indexRight = 2 * index + 2;
        int largeEl = index;


        if(indexLeft < heap.length && (heap[index] < heap[indexLeft])){
            largeEl = indexLeft;
        }

        if (indexRight < heap.length && (heap[index] < heap[indexRight])) {
            largeEl = indexRight;
        }

        if (largeEl == index) {
            return index;
        }
        else {
            int num = heap[index];
            heap[index] = heap[largeEl];
            heap[largeEl] = num;
            return siftDownCheck(heap, largeEl);
        }
    }

    public static int siftUpCheck(int[] heap, int index){


        int indexParent = (index / 2 ) - 1;

        if(indexParent == -1){
            return index;
        }

        if(indexParent > -1 && heap[indexParent] < heap[index-1]){
            int num = heap[indexParent];
            heap[indexParent] = heap[index-1];
            heap[index-1] = num;
            return siftUpCheck(heap, indexParent+1);
        }

        return index;
    }
    public static boolean treeAnagramm(Nodee leftNode, Nodee rightNode){


        if(leftNode.left == null && rightNode.right == null){
            return true;
        }
        if(leftNode.right == null && rightNode.left == null){
            return true;
        }

        if(leftNode.value == rightNode.value && leftNode.left.value == rightNode.right.value && leftNode.right.value == rightNode.left.value){
             treeAnagramm(leftNode.left, rightNode.right);
             treeAnagramm(leftNode.right, rightNode.left);
        }
        else return false;

        return true;
    }

    public static boolean treeSame(Nodee node1, Nodee node2){

        if (node1 == null && node2 == null){
            return true;
        }

        return node1 != null && node2 != null &&
                node1.value == node2.value &&
                treeSame(node1.left, node2.left)&&
                treeSame(node1.right,node2.right);
    }

    public static int treeDeep(Nodee node){

        if(node == null){
            return 0;
        }
        int rightDepth = treeDeep(node.right);
        int leftDepth = treeDeep(node.left);


        return Math.max(leftDepth, rightDepth) +1;
    }

    public static int treePath(Nodee node, int currentSum){


        if(node == null){
            return 0;
        }

        int left = Math.max(0, treePath(node.left, currentSum));
        int right = Math.max(0, treePath(node.right, currentSum));

        currentSum = Math.max(currentSum, left + right + node.value);

        return Math.max(left, right) + node.value;
    }
}


public class Sprint5 {
    public static void main(String[] args) {
        Nodee root = new Nodee(2);
        root.left = new Nodee(2);
        root.right = new Nodee(-3);
        root.right.left = new Nodee(5);
        root.right.right = new Nodee(1);

        //System.out.println("Максимальное значение в дереве: " + Nodee.treeSolution1(root));
        //System.out.println("Максимальное значение в дереве: " + Nodee.treeSolution2(root,Integer.MIN_VALUE, Integer.MAX_VALUE));
        //System.out.println("Диапазон: " + Nodee.treeSolution3(root,10, 16));
//        Nodee.insert(root, 90);
//        Nodee.insert(root, 1);
//        //Nodee.print(root);
//        Nodee.delete(root,12);
//        Nodee.delete(root, 0);
//        Nodee.delete(root,1);
       // Nodee.print(root);
//        if(Nodee.checkedABL(root) != 1){
//            System.out.println("true");
//        }
//        else System.out.println("else");
//        int[] heap = new int[]{12, 6,8,3,15,7};
//        System.out.println(Nodee.siftDownCheck(heap,2));
//        System.out.println(Arrays.toString(heap));
        System.out.println(Nodee.treePath(root,0));
    }
}
//12, 1, 8, 3, 4, 7
//12, 6,8,3,15,7
