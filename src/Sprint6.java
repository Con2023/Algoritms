import AboutAlgoritms.BFS;
import AboutAlgoritms.DFS;

import java.net.CookieHandler;
import java.util.*;

public class Sprint6 {
    public static void main(String[] args) {
        task12();

    }

    public static void task1() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Integer[]> arrayList = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            Integer[] integers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            arrayList.add(integers);
        }

        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            adjacencyMap.put(i, new ArrayList<>());
        }

        for (Integer[] edge : arrayList) {
            int u = edge[0];
            int v = edge[1];
            adjacencyMap.get(u).add(v);
        }

        for (int i = 1; i <= n; i++) {
            List<Integer> adjacentVertices = adjacencyMap.get(i);
            Collections.sort(adjacentVertices);  // сортируем вершины
            System.out.print(adjacentVertices.size());  // количество рёбер
            for (int vertex : adjacentVertices) {
                System.out.print(" " + vertex);  // вершины в порядке возрастания
            }
            System.out.println();
        }
    }

    public static void task2() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Integer[]> arrayList = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            Integer[] integers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            arrayList.add(integers);
        }

        int[][] matrix = new int[n + 1][n + 1];

        for (int i = 0; i < arrayList.size(); i++) {
            int ii = arrayList.get(i)[0];
            int jj = arrayList.get(i)[1];
            matrix[ii][jj] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.print("\n");
        }
    }

    public static void task3() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            Integer[] integers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            graph.get(integers[0]).add(integers[1]);
            graph.get(integers[1]).add(integers[0]);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        ArrayList<Integer> res = new ArrayList<>();
        int s = scanner.nextInt();

        int[] color = new int[n + 1];

        DFS(s, color, graph, res);

        System.out.println(res);
    }

    public static void DFS(int a, int[] color, HashMap<Integer, ArrayList<Integer>> graph, ArrayList<Integer> integers) {
        color[a] = 1;
        integers.add(a);
        System.out.println("Посещаем вершину: " + a);

        for (Integer el : graph.get(a)) {
            if ((color[el] == 0)) {
                DFS(el, color, graph, integers);
            }
        }
        color[a] = 2;
        System.out.println("Завершили вершину: " + a);

    }

    public static void task4() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            Integer[] integers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            graph.get(integers[0]).add(integers[1]);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        int[] color = new int[n + 1];

        int[] entry = new int[n + 1];
        int[] leave = new int[n + 1];
        int[] time = new int[1];

        DFStime(1, color, graph, entry, leave, time);

        for (int i = 1; i < entry.length; i++) {
            System.out.printf("%s %s\n", entry[i], leave[i]);
        }

    }

    public static void DFStime(int a, int[] color, HashMap<Integer, ArrayList<Integer>> graph, int[] entry, int[] leave, int[] time) {
        color[a] = 1;
        entry[a] = time[0];
        time[0] += 1;

        for (Integer el : graph.get(a)) {
            if (color[el] == 0) {
                DFStime(el, color, graph, entry, leave, time);
            }
        }
        leave[a] = time[0];
        time[0] += 1;
        color[a] = 2;
    }

    public static void task5() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            Integer[] integers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            graph.get(integers[0]).add(integers[1]);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        Stack<Integer> stack = new Stack<>();
        int[] color = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                DAG(i, color, graph, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void DAG(int a, int[] color, HashMap<Integer, ArrayList<Integer>> graph, Stack<Integer> stack) {
        color[a] = 1;

        for (Integer el : graph.get(a)) {
            if (color[el] == 0) {
                DAG(el, color, graph, stack);
            }
        }
        color[a] = 2;
        stack.push(a);
    }

    public static void task6() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            Integer[] integers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            graph.get(integers[0]).add(integers[1]);
            graph.get(integers[1]).add(integers[0]);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }


        int[] color = new int[n + 1];
        Arrays.fill(color, -1);
        int componentCount = 0;


        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                componentJoin(i, color, graph, componentCount);
                componentCount++;
            }
        }

        System.out.println(componentCount);

        Map<Integer, List<Integer>> components = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            components.computeIfAbsent(color[i], k -> new ArrayList<>()).add(i);
        }
        System.out.println(components.values());
    }

    public static void componentJoin(int a, int[] color, HashMap<Integer, ArrayList<Integer>> graph, int component) {
        color[a] = component;
        for (Integer el : graph.get(a)) {
            if (color[el] == -1) {
                componentJoin(el, color, graph, component);
            }
        }
    }

    public static void task7() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            Integer[] integers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            graph.get(integers[0]).add(integers[1]);
            graph.get(integers[1]).add(integers[0]);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        int s = scanner.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        int[] color = new int[n + 1];
        Queue<Integer> planned = new LinkedList<>();
        color[s] = 1;
        planned.add(s);

        while (!planned.isEmpty()) {

            BFS(planned, color, graph, arr);
        }
        System.out.println(arr);
    }

    public static void BFS(Queue<Integer> planned, int[] color, HashMap<Integer, ArrayList<Integer>> graph, ArrayList<Integer> arr) {
        int v = planned.poll();
        color[v] = 2;
        arr.add(v);
        for (Integer el : graph.get(v)) {
            if (color[el] == 0) {
                planned.add(el);
                color[el] = 1;
            }
        }
    }

    public static void task8() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            Integer[] integers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            map.get(integers[0]).add(integers[1]);
            map.get(integers[1]).add(integers[0]);
        }

        for (int i = 1; i <= map.size(); i++) {
            Collections.sort(map.get(i));
        }

        int start = scanner.nextInt();
        int end = scanner.nextInt();


        int[] color = new int[n + 1];
        Queue<Integer> planned = new LinkedList<>();
        int[] distance = new int[n + 1];
        int[] previous = new int[n + 1];
        planned.add(start);
        color[start] = 1;
        distance[start] = 0;
        previous[start] = -1;

        while (!planned.isEmpty()) {
            BFSs(planned, color, map, previous, distance);
        }

        if (color[end] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(distance[end]);
            shortPath(end, previous);
        }

    }

    public static void BFSs(Queue<Integer> planned, int[] color, HashMap<Integer, ArrayList<Integer>> graph, int[] previous, int[] distance) {
        int v = planned.poll();
        for (Integer el : graph.get(v)) {
            if (color[el] == 0) {
                planned.add(el);
                color[el] = 1;
                distance[el] = distance[v] + 1;
                previous[el] = v;
            }
        }
        color[v] = 2;
    }

    public static void shortPath(int v, int[] previous) {
        Stack<Integer> stack = new Stack<>();
        int current = v;
        while (current != -1) {
            stack.push(current);
            current = previous[current];
        }
        System.out.println(stack);
    }

    public static void task9() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            Integer[] integers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            map.get(integers[0]).add(integers[1]);
            map.get(integers[1]).add(integers[0]);
        }

        for (int i = 1; i <= map.size(); i++) {
            Collections.sort(map.get(i));
        }


        int point = scanner.nextInt();

        int[] color = new int[n + 1];
        Queue<Integer> planned = new LinkedList<>();
        int[] distance = new int[n + 1];

        planned.add(point);
        color[point] = 1;
        distance[point] = 0;

        while (!planned.isEmpty()) {
            BFSss(planned, color, map, distance);
        }
        System.out.println(distance[distance.length - 1]);
    }

    public static void BFSss(Queue<Integer> planned, int[] color, HashMap<Integer, ArrayList<Integer>> graph, int[] distance) {
        int v = planned.poll();
        for (Integer el : graph.get(v)) {
            if (color[el] == 0) {
                planned.add(el);
                color[el] = 1;
                distance[el] = distance[v] + 1;
            }
        }
        color[v] = 2;
    }

    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void task10() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        HashMap<Integer, ArrayList<Edge>> graph = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            int w = scanner.nextInt();
            scanner.nextLine();

            graph.get(from).add(new Edge(to, w));
            graph.get(to).add(new Edge(from, w)); // так как граф неориентированный
        }

        // Сортируем соседей для каждой вершины по номеру вершины, если нужно
        for (int i = 1; i <= n; i++) {
            graph.get(i).sort(Comparator.comparingInt(e -> e.to));
        }

        // Запускаем алгоритм Дейкстры от каждой вершины и печатаем расстояния
        for (int start = 1; start <= n; start++) {
            int[] dist = dijkstra(graph, start, n);
            System.out.println("От вершины " + start + ": " + Arrays.toString(dist));
        }
    }

    public static int[] dijkstra(HashMap<Integer, ArrayList<Edge>> graph, int start, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        boolean[] visited = new boolean[n + 1];

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.to;

            if (visited[u]) continue;
            visited[u] = true;

            for (Edge edge : graph.get(u)) {
                int v = edge.to;
                int w = edge.weight;

                if (!visited[v] && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new Edge(v, dist[v]));
                }
            }
        }
        // Можно сделать dist[0] = 0, т.к. нумерация с 1
        dist[0] = 0;
        return dist;
    }

    public static void taskFin1() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        HashMap<Integer, ArrayList<Edge>> graph = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            int w = scanner.nextInt();
            scanner.nextLine();

            graph.get(from).add(new Edge(to, w));
            graph.get(to).add(new Edge(from, w)); // так как граф неориентированный
        }

        // Сортируем соседей для каждой вершины по номеру вершины, если нужно
        for (int i = 1; i <= n; i++) {
            graph.get(i).sort(Comparator.comparingInt(e -> e.to));
        }

        prim(graph, n);
    }

    public static void prim(HashMap<Integer, ArrayList<Edge>> map, int n) {

        boolean[] used = new boolean[n + 1];
        int[] maxEdge = new int[n + 1];

        Arrays.fill(maxEdge, Integer.MIN_VALUE);
        maxEdge[1] = 0;

        //Переменная для хранения суммарного веса MST.
        int mstWeight = 0;

        for (int i = 1; i <= n; i++) {

            int v = -1;
            for(int j = 1; j <=n; j++){
                if(!used[j] && (v == -1 || maxEdge[j] > maxEdge[v])){
                    v = j;
                }
            }

            if(maxEdge[v] == Integer.MAX_VALUE){
                System.out.println("Граф несвязный!");
                return;
            }

            used[v] = true;
            mstWeight += maxEdge[v];

            for(Edge e : map.get(v)){
                if(!used[e.to] && e.weight > maxEdge[e.to]){
                    maxEdge[e.to] = e.weight;
                }
            }
        }
        System.out.println("Суммарный вес MST: " + mstWeight);

    }

    public static void taskFin2(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        HashMap<Integer, ArrayList<Integer>> mapR = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> mapB = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            mapR.put(i, new ArrayList<>());
            mapB.put(i, new ArrayList<>());
        }

        for(int i = 1; i <n; i++){
            char[] line = scanner.nextLine().toCharArray();
            for(int j = 0; j < line.length; j++){
                int from = i;
                int to = i + j +1;

                if(line[j] == 'B'){
                    mapB.get(from).add(to);
                }
                else if(line[j] == 'R'){
                    mapR.get(from).add(to);
                }
            }
        }

        boolean isOptimal = true;

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                boolean hasPathR = hasPath(mapR, i, j, new boolean[n + 1]);
                boolean hasPathB = hasPath(mapB, i, j, new boolean[n + 1]);
                if (hasPathR && hasPathB) {
                    isOptimal = false;
                }
            }
        }
        System.out.println(isOptimal ? "YES" : "NO");
    }
    private static boolean hasPath(HashMap<Integer, ArrayList<Integer>> graph, int start, int end, boolean[] visited) {
        if(start == end) return true;

        visited[start] = true;

        for (Integer el : graph.get(start)){
            if(!visited[el]){
                if (hasPath(graph, el, end, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void task11() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        int[] ver = new int[n];
        for (int i = 0; i < n; i++) {
            ver[i] = i + 1;
        }

        for (int i = 1; i <= m; i++) {
            Integer[] integers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
                map.get(integers[0]).add(integers[1]);
                map.get(integers[1]).add(integers[0]);

        }

        if(checkFullGraph(ver, map))
            System.out.println("Граф полный!");
        else System.out.println("NO");


    }
    public static boolean checkFullGraph(int[] v, HashMap<Integer, ArrayList<Integer>> map){

        for (int i = 1; i <= map.size(); i++) {
            ArrayList<Integer> list = map.get(i);

            for(int vertex : v){
                if(vertex != i && !list.contains(vertex)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void task12() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        int[] ver = new int[n];
        for (int i = 0; i < n; i++) {
            ver[i] = i + 1;
        }

        for (int i = 1; i <= m; i++) {
            Integer[] integers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            map.get(integers[0]).add(integers[1]);
            map.get(integers[1]).add(integers[0]);

        }

        checkBipartiteGraph(ver,map);


    }
    public static void checkBipartiteGraph(int[] v, HashMap<Integer, ArrayList<Integer>> map) {
        int[] color = new int[v.length+1];
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        list1.add(v[0]);
        color[1] = 1;

        for (int el : v) {
            if(list1.contains(el)){
                for(int y : map.get(el)){
                    if(!list1.contains(y) && color[y] != 1){
                        list2.add(y);
                    }
                }
            }

            else if(list2.contains(el)){
                for(int y : map.get(el)){
                    if(!list2.contains(y)  && color[y] != 1){
                        list1.add(y);
                    }
                }
            }
        }
        System.out.println(list2);
        System.out.println(list1);
    }

}
