package TExams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

class Edge {
    int from;
    int to;

    public Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return (from == edge.from && to == edge.to) ||
                (from == edge.to && to == edge.from);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Math.min(from, to), Math.max(from, to));
    }
}

class Main6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        List<Edge> edges = new ArrayList<>();
        List<List<Integer>> adjacencyList = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; ++i) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; ++i) {
            String[] uv = br.readLine().split(" ");
            int u = Integer.parseInt(uv[0]), v = Integer.parseInt(uv[1]);
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
            edges.add(new Edge(u, v));
        }

        int[] degrees = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            degrees[i] = adjacencyList.get(i).size();
        }

        int oddCount = 0;
        for (int deg : degrees) {
            if (deg % 2 != 0) {
                oddCount++;
            }
        }

        if (oddCount % 2 != 0) {
            System.out.println("-1");
            return;
        }

       int[] outDegrees = new int[n + 1];
        List<Edge> directedEdges = new ArrayList<>();
        for (Edge edge : edges) {
            directedEdges.add(edge);
            outDegrees[edge.from]++;
        }

        for (int i = 1; i <= n; ++i) {
            while (outDegrees[i] % 2 != 0) {
                for (int j = 0; j < directedEdges.size(); ++j) {
                    Edge currEdge = directedEdges.get(j);
                    if (currEdge.from == i) {
                        directedEdges.set(j, new Edge(currEdge.to, currEdge.from));
                        outDegrees[currEdge.from]--;
                        outDegrees[currEdge.to]++;
                        break;
                    }
                }
            }
        }

        for (int i = 1; i <= n; ++i) {
            if (outDegrees[i] % 2 != 0) {
                System.out.println("-1");
                return;
            }
        }

          for (Edge edge : directedEdges) {
            System.out.println(edge.from + " " + edge.to);
        }
    }
}

 class Main5 {
    static long[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        dp = new long[n + 1];
        dp[0] = 1;
        for (int x = 1; x <= n; x++) {
            for (int i = n; i >= 0; i--) {
                if (dp[i] == 0) continue;
                for (int j = 1; i + x * j <= n; j++) {
                    long ways = combinations(j + k -1, k -1);
                    dp[i + x * j] += dp[i] * ways;
                }
            }
        }
        System.out.println(dp[n]);
    }
    static long combinations(int n, int k) {
        if (k > n) return 0;
        if (k > n - k) k = n - k;
        long res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (n - k + i) / i;
        }
        return res;
    }
}

 class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] l = new int[n+1];
        int[] r = new int[n+1];
        int[] a = new int[n+1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            l[i] = Integer.parseInt(st.nextToken());
            r[i] = Integer.parseInt(st.nextToken());
            a[i] = Integer.parseInt(st.nextToken());
        }

        long[] left = new long[n+2];
        long[] right = new long[n+2];

        for (int i = 1; i <= n; i++) {
            left[i] = a[i] + Math.min(l[i], left[i-1]);
        }

        for (int i = n; i >= 1; i--) {
            right[i] = a[i] + Math.min(r[i], right[i+1]);
        }

        long ans = 0;
        for (int i = 1; i <= n; i++) {
            long total = left[i] + right[i] - a[i];
            if (total > ans) ans = total;
        }

        System.out.println(ans);
    }
}

 class Main3 {
     static final int MOD = (int)1e9 + 7;

     public static void main(String[] args) throws Exception {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         PrintWriter out = new PrintWriter(System.out);

         int n = Integer.parseInt(br.readLine());
         int[] a = new int[n];

         StringTokenizer st = new StringTokenizer(br.readLine());
         for (int i = 0; i < n; i++) {
             a[i] = Integer.parseInt(st.nextToken());
         }

         long[] dp = new long[n + 1];
         dp[0] = 1;

         HashMap<Integer, Integer> lastIndex = new HashMap<>();

         for (int i = 1; i <= n; i++) {
             int val = a[i - 1];
             dp[i] = (2 * dp[i - 1]) % MOD;
             if (lastIndex.containsKey(val)) {
                 int prev = lastIndex.get(val);
                 dp[i] = (dp[i] - dp[prev - 1] + MOD) % MOD;
             }
             lastIndex.put(val, i);
         }

         out.println((dp[n] - 1 + MOD) % MOD);
         out.flush();
         out.close();
     }
 }



class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        char[] digits = input.toCharArray();
        Arrays.sort(digits);

        if (digits[0] == '0') {
             int firstNonZeroIndex = -1;
            for (int i = 1; i < digits.length; i++) {
                if (digits[i] != '0') {
                    firstNonZeroIndex = i;
                    break;
                }
            }
            if (firstNonZeroIndex != -1) {
                char temp = digits[0];
                digits[0] = digits[firstNonZeroIndex];
                digits[firstNonZeroIndex] = temp;
            }
        }

        System.out.println(new String(digits));
    }
}
 class Main2 {

    public static boolean canConstructPermutation(int[] a, int n) {
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            if (a[i] > i + 1) {
                return false;
            }
        }
        return true;
    }

    public static String solve(int[] a, int n) {
        Arrays.sort(a);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (long)(i + 1) - a[i];
        }
        return (sum % 2 == 1) ? "First" : "Second";
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            if (!canConstructPermutation(a, n)) {
                out.println("Second");
            } else {
                out.println(solve(a, n));
            }
        }

        out.flush();
        out.close();
    }
}
