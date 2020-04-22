import java.io.*;
import java.util.*;

public class _12100 {
	static int max = 0, N;
	static int[] dr = { 1, -1, 0, 0 }, dc = { 0, 0, 1, -1 };
	static Queue<Integer> q;

	public static void merge(int r, int c, int dir, int[][] b) {
		while (!q.isEmpty()) {
			int num = q.poll();
			if (b[r][c] == 0)
				b[r][c] = num;
			else {
				if (b[r][c] == num) {
					b[r][c] += num;
					r += dr[dir];
					c += dc[dir];
				} else {
					r += dr[dir];
					c += dc[dir];
					b[r][c] = num;
				}
			}
		}
	}

	public static void move(int dir, int[][] a) {
		switch (dir) {
		// 위
		case 0:
			for (int c = 0; c < N; c++) {
				q = new LinkedList<Integer>();
				for (int r = 0; r < N; r++) {
					if (a[r][c] > 0) {
						q.add(a[r][c]);
						a[r][c] = 0;
					}
				}
				merge(0, c, dir, a);
			}
			break;
		// 아래
		case 1:
			for (int c = 0; c < N; c++) {
				q = new LinkedList<Integer>();
				for (int r = N - 1; r >= 0; r--) {
					if (a[r][c] > 0) {
						q.add(a[r][c]);
						a[r][c] = 0;
					}
				}
				merge(N - 1, c, dir, a);
			}
			break;
		// 왼
		case 2:
			for (int r = 0; r < N; r++) {
				q = new LinkedList<Integer>();
				for (int c = 0; c < N; c++) {
					if (a[r][c] > 0) {
						q.add(a[r][c]);
						a[r][c] = 0;
					}
				}
				merge(r, 0, dir, a);
			}
			break;
		// 오
		default:
			for (int r = 0; r < N; r++) {
				q = new LinkedList<Integer>();
				for (int c = N - 1; c >= 0; c--) {
					if (a[r][c] > 0) {
						q.add(a[r][c]);
						a[r][c] = 0;
					}
				}
				merge(r, N - 1, dir, a);
			}
			break;
		}
	}

	public static void dfs(int cnt, int[][] a) {
		if (cnt == 5) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					max = Math.max(max, a[i][j]);
				}
			}
			return;
		}
		int[][] copy = new int[N][N];
		for (int i = 0; i < 4; i++) {
			for (int s = 0; s < N; s++)
				System.arraycopy(a[s], 0, copy[s], 0, N);
			move(i, copy);
			dfs(cnt + 1, copy);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] a = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		dfs(0, a);
		System.out.println(max);
	}

}
