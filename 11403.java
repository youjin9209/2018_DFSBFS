/*
11403 경로찾기 
처음 시작점은 true로 하면 안된다 
*/
package algorithm_main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] a;
	static int N;
	static int[][] map;
	static boolean[] check;
	public static void dfs(int x, boolean startFlag) {
		if (check[x])
			return;
		if (!startFlag)
			check[x] = true;
		
		for (int y : a[x]) {
			if (!check[y]) {
				startFlag = false;
				dfs(y, startFlag);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N+2][N+2];
		a = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			a[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i <= N; i++) {
			String[] token = bf.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(token[j-1]);
				if (map[i][j] == 1)
					a[i].add(j);
			}
		}
		for (int i = 1; i <= N; i++) {
			check = new boolean[N+1];
			boolean startFlag = true;
			dfs(i, startFlag);
			for (int j = 1; j <= N; j++) {
				if (check[j])
					map[i][j] = 1;
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
