import java.io.*;
import java.util.*;

public class Main {
	static int N, M, D, answer = 0, tmp = 0, enemy = 0, num;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static int[][] a, copy;
	static ArrayList<Point> b = new ArrayList<Point>();

	static class Point implements Comparable<Point> {
		int r, c, dis;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public Point(int r, int c, int dis) {
			this.r = r;
			this.c = c;
			this.dis = dis;
		}

		@Override
		public int compareTo(Point p) {
			if (this.dis == p.dis)
				return this.c < p.c ? -1 : 1;
			return this.dis < p.dis ? -1 : 1;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		a = new int[N + 1][M];
		copy = new int[N + 1][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				if (a[i][j] == 1)
					enemy++;
			}
		}
		dfs(0, 0);
		System.out.println(answer);
	}

	private static void dfs(int c, int cnt) {
		if (cnt == 3) {
			num = enemy;
			tmp = 0;
			for (int i = 0; i <= N; i++)
				System.arraycopy(a[i], 0, copy[i], 0, M);

			while (num > 0) {
				for (Point p : b) {
					find(p.r, p.c);
				}
				attack();
				move();
			}

			answer = Math.max(answer, tmp);
			return;
		}

		for (int j = c; j < M; j++) {
			if (a[N][j] == 0) {
				a[N][j] = 2;
				b.add(new Point(N, j));
				dfs(j, cnt + 1);
				a[N][j] = 0;
				b.remove(cnt);
			}
		}

	}

	private static void move() {
		for (int r = N - 1; r >= 0; r--) {
			for (int c = 0; c < M; c++) {
				if (copy[r][c] == 1) {
					copy[r][c] = 0;
					if (r + 1 < N) {
						copy[r + 1][c] = 1;
					} else {
						num--;
					}
				}
			}
		}

	}

	private static void attack() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (copy[r][c] == -1) {
					copy[r][c] = 0;
					tmp++;
					num--;
				}
			}
		}
	}

	private static void find(int r, int c) {
		int d = D + 1, nr = 0, nc = M;
		for (int i = r - D; i <= r; i++) {
			for (int j = c - D; j <= c + D; j++) {
				if (i < 0 || i >= N || j < 0 || j >= M)
					continue;
				if (copy[i][j] == 1 || copy[i][j] == -1) {
					int cur_dis = Math.abs(i - r) + Math.abs(j - c);
					if (cur_dis < d) {
						d = cur_dis;
						nr = i;
						nc = j;
					} else if (cur_dis == d && nc > j) {
						nr = i;
						nc = j;
					}
				}
			}
		}
		if (d <= D) 
			copy[nr][nc] = -1;
		
	}

}
