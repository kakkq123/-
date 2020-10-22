import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	static int N;
	static int[][] a;
	static boolean[][] v;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

	static public void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		N = getSize(n);
		a = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				a[i][j] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < q; i++) {
			int l = Integer.parseInt(st.nextToken());
			l = getSize(l);
			// 구역별  90도 회전
			for (int r = 0; r < N; r += l)
				for (int c = 0; c < N; c += l)
					rotate(r, c, l);
			//얼음 녹기
			melt();
		}
		br.close();

		int max_cnt = 0, max_sum = 0;
		v = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				//얼음의 합
				if (a[r][c] > 0)
					max_sum += a[r][c];
				//가장 덩어리가 큰 얼음을 찾음
				if (!v[r][c] && a[r][c] > 0)
					max_cnt = Math.max(max_cnt, bfs(r, c));
			}
		}

		bw.write(max_sum + "\n" + max_cnt + "\n");
		bw.close();
	}

	private static void melt() {
		v = new boolean[N][N];
		for (int r = 0; r < N; r++)
			for (int c = 0; c < N; c++)
				if (a[r][c] > 0) {
					int cnt = 0;
					//인접한 얼음 개수 확인
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d], nc = c + dc[d];
						if (nr < 0 || nr >= N || nc < 0 || nc >= N)
							continue;
						if (a[nr][nc] > 0)
							cnt++;
					}
					// 감소해야하는 얼음
					if (cnt < 3)
						v[r][c] = true;
				}
		// 얼음 녹기
		for (int r = 0; r < N; r++)
			for (int c = 0; c < N; c++)
				if (v[r][c])
					a[r][c]--;

	}

	private static int bfs(int r, int c) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(r, c));
		v[r][c] = true;
		int cnt = 1; // 얼음 개수
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = p.x + dr[d], nc = p.y + dc[d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				if (v[nr][nc] || a[nr][nc] == 0)
					continue;
				v[nr][nc] = true;
				q.add(new Point(nr, nc));
				cnt++;
			}
		}
		return cnt;

	}

	private static void rotate(int r, int c, int size) {
		for (int s = size; s > 1; s -= 2) {
			rotate90(r, c, s);
			++r;
			++c;
		}
	}

	private static void rotate90(int r, int c, int s) {
		int[][] tmp = new int[4][s];
		//
		for (int i = 0; i < s; i++)
			tmp[0][i] = a[r][c + i];
		for (int i = 0; i < s; i++)
			tmp[1][i] = a[r + i][c + s - 1];
		for (int i = 0; i < s; i++)
			tmp[2][i] = a[r + s - 1][c + i];
		for (int i = 0; i < s; i++)
			tmp[3][i] = a[r + i][c];
		//
		for (int i = 0; i < s; i++)
			a[r][c + i] = tmp[3][s - 1 - i];
		for (int i = 0; i < s; i++)
			a[r + i][c + s - 1] = tmp[0][i];
		for (int i = 0; i < s; i++)
			a[r + s - 1][c + i] = tmp[1][s - 1 - i];
		for (int i = 0; i < s; i++)
			a[r + i][c] = tmp[2][i];
	}

	private static int getSize(int n) {
		int res = 1;
		for (int i = 0; i < n; i++)
			res *= 2;
		return res;
	}

}
