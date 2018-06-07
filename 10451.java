/*
10451 - 순열 사이클 
DFS - 완전탐색 / 정점 덩어리 화 시켜주는것 ! 
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void dfs(int i, ArrayList<Integer>[] a, boolean[] c) {
		if (c[i])
			return;
		c[i] = true;
		for(int y : a[i]) {
			if (!c[y])
				dfs(y, a, c);
		}
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0) {
			int N = sc.nextInt();
			ArrayList<Integer>[] a = new ArrayList[N+1];
			for(int i = 1; i <= N; i++) {
				a[i] = new ArrayList<Integer>();
			}
			for(int i = 1; i <= N; i++) {
				int u = sc.nextInt();
				a[i].add(u);
				a[u].add(i);
			}
			boolean[] c = new boolean[N+1];
			int count = 0;
			for (int i = 1; i <= N; i++) {
				if (!c[i]) {
					count++;
					dfs(i, a, c);
				}
			}
			System.out.println(count);
		}
	}
}
