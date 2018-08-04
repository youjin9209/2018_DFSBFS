/*
1012 백준
유기농 배추
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
class Point {
	int x, y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int[][] map;
	static boolean[][] check;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int M;
	static int N;
	public static void bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(x, y));
		check[x][y] = true;
		
		while (!queue.isEmpty()) {
			Point p = queue.remove();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (map[nx][ny] == 1 && !check[nx][ny]) {
						queue.add(new Point(nx, ny));
						check[nx][ny] = true;
					}
				}
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			M = sc.nextInt();
			N = sc.nextInt();
			int cnt = 0;
			map = new int[N][M];
			check = new boolean[N][M];
			int K = sc.nextInt();
			while (K-- > 0) {
				int m = sc.nextInt();
				int n = sc.nextInt();
				map[n][m] = 1;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1 && !check[i][j]) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
