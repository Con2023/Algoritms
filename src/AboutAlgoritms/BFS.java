package AboutAlgoritms;

import java.util.*;

public class BFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        graph.put(1, new ArrayList<>());
        graph.put(2, new ArrayList<>());
        graph.put(3, new ArrayList<>());
        graph.put(4, new ArrayList<>());
        graph.put(5, new ArrayList<>());

        graph.get(1).add(2);
        graph.get(1).add(3);

        graph.get(2).add(1);
        graph.get(2).add(4);

        graph.get(3).add(1);
        graph.get(3).add(5);

        graph.get(4).add(2);
        graph.get(5).add(3);

        for(int key : graph.keySet()){
            System.out.println("Вершина:"+key);
            for(int i : graph.get(key)){
                System.out.println("->"+i);
            }
        }

        System.out.println("Введите число, которое нужно найти: ");
        int findElement = sc.nextInt();

        List<Integer> result = bfs(graph, findElement);
        System.out.println(result);
    }

    public static List<Integer> bfs(HashMap<Integer, ArrayList<Integer>> integers, int num){
        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> parent = new HashMap<>();

        int firstKey = new ArrayList<>(integers.keySet()).getFirst();
        deque.add(firstKey);
        visited.add(firstKey);
        parent.put(firstKey, null);

        while(!deque.isEmpty()){
            int current = deque.removeFirst();
            System.out.println("Посещаем вершину: " + current);

            if (current == num){
                List<Integer> path = new ArrayList<>();

                for (Integer at = current; at != null; at = parent.get(at)) {
                    path.add(at);
                }
                Collections.reverse(path);

                return path;
                }
            else {
                for(int el : integers.get(current)){
                    if(!visited.contains(el)){
                        deque.add(el);
                        visited.add(el);
                        parent.put(el,current);
                    }
                }
            }
        }
        return null;
    }
}
