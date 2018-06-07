import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
1707 - 이분 그래프  
인접한 정점을 칠할 색 배열 !! 
*/
public class Main {
	public static void dfs(int i, ArrayList<Integer>[] a, int[] color, int c) {
		color[i] = c;
		for (int y : a[i]) {
			if (color[y] == 0) {
				dfs(y, a, color, 3-c);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		while(K-- > 0) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			ArrayList<Integer>[] a = new ArrayList[V+1];
			for (int i = 1; i <= V; i++) {
				a[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < E; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				a[u].add(v);
				a[v].add(u);
			}
			int[] color = new int[V+1];
			for (int i = 1; i <= V; i++) {
				if (color[i] == 0)
					dfs(i, a, color, 1);
			}
			boolean OK = true;
			for (int i = 1; i <= V; i++) {
				for (int y : a[i]) {
					if (color[y] == color[i])
						OK = false;
				}
			}
			if(OK)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
