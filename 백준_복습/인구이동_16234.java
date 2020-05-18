import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	static int N, L, R, sum;
	static int[][] A = new int[50][50];
	static boolean[][] v;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static Queue<Point> q = new LinkedList<Point>(); // 메모리를 많이 잡아먹음!!!!

	public static void dfs(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d], nc = c + dc[d];
			if (nr < 0 || nr >= N || nc < 0 || nc >= N || v[nr][nc])
				continue;
			int diff = Math.abs(A[r][c] - A[nr][nc]);
			if (diff >= L && diff <= R) {
				q.add(new Point(nr, nc));
				v[nr][nc] = true;
				sum += A[nr][nc];
				dfs(nr, nc);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		while (true) {
			boolean flag = true;
			v = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!v[i][j]) {
						sum = A[i][j]; // 인구 수의 합
						v[i][j] = true; // 방문 체크
						q.clear();
						q.add(new Point(i, j)); // 방문기록
						dfs(i, j);
						if (q.size() > 1) {
							flag = false;
							int avg = sum / q.size();
							while (!q.isEmpty()) {
								A[q.peek().x][q.peek().y] = avg;
								q.poll();
							}
						}
					}
				}
			}
			if (flag)
				break;
			cnt++;
		}
		System.out.print(cnt);

	}

}
