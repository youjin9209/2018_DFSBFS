/*
11724 - 연결요소의 개수
dfs 돌기전에 방문했는지 체크해서 count++ 해주는거 !! 
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {	
	static ArrayList<Integer>[] a;
	static boolean[] c;
	public static void dfs(int x) {
		if (c[x])
			return;
		c[x] = true;
		for (int y : a[x]) {
			if (!c[y])
				dfs(y);
		}
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		a = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			a[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			a[u].add(v);
			a[v].add(u);
		}
		c = new boolean[N+1];
		int count = 0;
		for (int i = 1; i <= N; i++) {
			int start = i;
			if (!c[start])
				count++;
			dfs(start);
		}
		System.out.println(count);
	}
}
