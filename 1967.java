package algorithm_main;
import java.util.*;
class Edge {
    public int to;
    public int cost;
    Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}
public class Main {
    public static int[] bfs(int n, ArrayList<Edge>[] a, int start) {
        boolean[] check = new boolean[n+1];
        int[] dist = new int[n+1];
        Queue<Integer> q = new LinkedList<Integer>();
        check[start] = true;
        q.add(start);
        while (!q.isEmpty()) {
            int x = q.remove();
            for (Edge e : a[x]) {
                if (check[e.to] == false) {
                    dist[e.to] = dist[x] + e.cost;
                    q.add(e.to);
                    check[e.to] = true;
                }
            }
        }
        return dist;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Edge>[] a = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<Edge>();
        }
        for (int i = 1; i <= n-1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            a[x].add(new Edge(y,z));
            a[y].add(new Edge(x,z));
        }
        int[] dist = bfs(n, a,1);
        int start = 1;
        for (int i = 2; i <= n; i++) {
            if (dist[i] > dist[start]) {
                start = i;
            }
        }
        dist = bfs(n, a, start);
        int ans = dist[1];
        for (int i = 2; i <= n; i++) {
            if (ans < dist[i]) {
                ans = dist[i];
            }
        }
        System.out.println(ans);
    }
}
