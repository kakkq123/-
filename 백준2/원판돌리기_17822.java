import java.io.*;
import java.util.*;
import java.awt.Point;

public class 원판돌리기_17822 {
	static int N, M;
	static boolean flag;
	static int[][] a = new int[50][50];
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken()); // 0 시계 방향, 1: 반시계 방향
			int k = Integer.parseInt(st.nextToken());

			int _x = x + 1;
			for (int j = x; j < N; j += _x)
				rotate(j, d, k);
			
			solve();
		}
		br.close();
		
		int ans = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				ans += a[i][j];
		System.out.println(ans);
	}

	private static void solve() {
		boolean[][] v = new boolean[N][M];
		boolean flag = false;
		double num = 0, cnt = 0;
		Queue<Point> q;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (a[i][j] == 0)
					continue;
				cnt++;
				num += a[i][j];

				int comp = a[i][j];
				q = new LinkedList<Point>();
				q.add(new Point(i, j));
				while (!q.isEmpty()) {
					Point p = q.poll();
					for (int d = 0; d < 4; d++) {
						int x = p.x + dx[d], y = p.y + dy[d];
						if (y == M)
							y = 0;
						else if (y == -1)
							y = M - 1;

						if (x < 0 || x >= N || y < 0 || y >= M || v[x][y] || a[x][y] != comp)
							continue;

						v[p.x][p.y] = v[x][y] = true;
						q.add(new Point(x, y));
						flag = true;
					}
				}

			}
		}

		if (flag) {
			for (int i = 0; i < N; i++)
				for (int j = 0; j < M; j++)
					if (v[i][j])
						a[i][j] = 0;

		} else {
			if (cnt == 0)
				return;
			double avg = num / cnt;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (a[i][j] == 0)
						continue;
					if (a[i][j] > avg)
						a[i][j]--;
					else if (a[i][j] < avg)
						a[i][j]++;
				}
			}
		}
	}

	private static void rotate(int x, int d, int k) {

		int[] t = new int[M];
		System.arraycopy(a[x], 0, t, 0, M);
		// 시계방향 회전
		if (d == 1) {
			for (int i = 0; i < M; i++) {
				a[x][i] = t[(i + k) % M];
			}
		} // 반시계방향 회전
		else {
			for (int i = 0; i < M; i++) {
				a[x][i] = t[(i - k + M) % M];
			}
		}
	}

}
