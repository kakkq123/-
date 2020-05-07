import java.io.*;
import java.util.*;
import java.awt.Point;

//0 빈칸, 1 벽, 2 바이러스
public class 연구소_14502 {
	static int N, M, max = 0;
	static int[][] a;
	static int[] dr = { 0, 0, -1, 1 }, dc = { -1, 1, 0, 0 };
	static Queue<Point> virus = new LinkedList<Point>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		a=new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				if (a[i][j] == 2)
					virus.add(new Point(i, j));
			}
		}
		dfs(0, 0, 0);
		bw.write(max+"\n");
		br.close();
		bw.close();
	}

	private static void dfs(int row, int col, int wall) {
		if (wall == 3) {
			spread_check();
			return;
		}
		for (int r = row; r < N; r++) {
			int _c = r == row ? col : 0;
			for (int c = _c; c < M; c++) {
				if (a[r][c] == 0) {
					a[r][c] = 1; // 벽 세움
					dfs(r, c, wall + 1);
					a[r][c] = 0;
				}
			}
		}
	}

	private static void spread_check() {
		Queue<Point> q = new LinkedList<Point>();
		q.addAll(virus);
		boolean[][] v = new boolean[N][M];
		int[][] copy = new int[N][M];
		for (int i = 0; i < N; i++)
			System.arraycopy(a[i], 0, copy[i], 0, a[i].length);

		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < 4; d++) {
				int x = p.x + dr[d], y = p.y + dc[d];
				if (x < 0 || x >= N || y < 0 || y >= M || v[x][y] || copy[x][y] != 0)
					continue;
				v[x][y] = true;
				copy[x][y] = 2;
				q.add(new Point(x, y));
			}
		}
		int count = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (copy[r][c] == 0)
					count++;
			}
		}
		max = Math.max(max, count);
	}

}
