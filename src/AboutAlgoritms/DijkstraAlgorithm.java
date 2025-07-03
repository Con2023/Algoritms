package AboutAlgoritms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DijkstraAlgorithm {
    static class Edge{
        public int direction;
        public int weight;

        public Edge(int direction, int weight) {
            this.direction = direction;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, ArrayList<Edge>> graph = new HashMap<>();

        graph.put(1, new ArrayList<>());
        graph.put(2, new ArrayList<>());
        graph.put(3, new ArrayList<>());
        graph.put(4, new ArrayList<>());
        graph.put(5, new ArrayList<>());
        graph.put(6, new ArrayList<>());

        graph.get(1).add(new Edge(2,5));
        graph.get(1).add(new Edge(3, 3));
        graph.get(2).add(new Edge(4, 6));
        graph.get(3).add(new Edge(2, 2));
        graph.get(3).add(new Edge(4, 7));
        graph.get(3).add(new Edge(5, 4));
        graph.get(4).add(new Edge(5, 1));
        graph.get(4).add(new Edge(6, 8));
        graph.get(5).add(new Edge(6, 5));

        System.out.println("Граф с весами:");
        for(Integer key: graph.keySet()){
            System.out.println("Вершина " + key);
            for(Edge edge: graph.get(key)){
                System.out.print(edge.direction + "(вес=" + edge.weight + ") ");
            }
            System.out.println();
        }
    }
}
