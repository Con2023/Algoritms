import java.util.*;

public class DFS {
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

        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> path = new HashMap<>() {};
        int current = new ArrayList<>(graph.keySet()).getFirst();
        path.put(current,null);

        ArrayList<Integer> result = dfs(graph, findElement,current,path,visited);
        System.out.println(result);
    }

    public static ArrayList<Integer> dfs (HashMap<Integer,ArrayList<Integer>> graph, int number, int current, Map<Integer, Integer> path,Set<Integer> visited){

        visited.add(current);

        if(current == number){
            System.out.println("Вершина: " + current +" найдена.");
            ArrayList<Integer> pathPoints = new ArrayList<>();
            for(Integer el = current; el != null; el = path.get(el)){
                pathPoints.add(el);
            }
            Collections.reverse(pathPoints);
            return pathPoints;
        }
        else {
            for(Integer el : graph.get(current))
                if(!visited.contains(el)){
                    path.put(el, current);
                    ArrayList<Integer> result = dfs(graph, number, el, path, visited);
                    if (result != null) {
                        return result;
                    }
                }

            }
        return null;
    }

}

