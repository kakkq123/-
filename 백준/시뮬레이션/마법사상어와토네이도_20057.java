import java.io.*;
import java.util.*;

public class Main {
	static int N, sum = 0;
	static int[][] a;
	static int[][] dx = { { -2, -1, -1, -1, 0, 1, 1, 1, 2, 0 }, { 0, -1, 0, 1, 2, -1, 0, 1, 0, 1 },
			{ -2, -1, -1, -1, 0, 1, 1, 1, 2, 0 }, { 0, 1, 0, -1, -2, 1, 0, -1, 0, -1 } };
	static int[][] dy = { { 0, 1, 0, -1, -2, 1, 0, -1, 0, -1 }, { -2, -1, -1, -1, 0, 1, 1, 1, 2, 0 },
			{ 0, -1, 0, 1, 2, -1, 0, 1, 0, 1 }, { -2, -1, -1, -1, 0, 1, 1, 1, 2, 0 } };
	static int[] dr = { 0, 1, 0, -1 }, dc = { -1, 0, 1, 0 }, p = { 2, 1, 7, 10, 5, 1, 7, 10, 2 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());

		a = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				a[i][j] = Integer.parseInt(st.nextToken());
		}
		br.close();
		solve(N / 2, N / 2);
		bw.write(sum + "");
		bw.close();
	}

	private static void solve(int r, int c) {
		int len = 1, dir = 0;
		while (true) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < len; j++) {
					r += dr[dir];
					c += dc[dir];
					moveSand(r, c, dir);
					if (r == 0 && c == 0)
						return;
				}
				dir = (dir + 1) % 4;
			}
			len++;
		}

	}

	private static void moveSand(int r, int c, int dir) {
		int sand = a[r][c], tmp = sand;
		a[r][c] = 0;
		for (int d = 0; d < 9; d++) {
			int nr = r + dx[dir][d], nc = c + dy[dir][d];
			int v = sand * p[d] / 100;
			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				sum += v;
			else
				a[nr][nc] += v;
			tmp -= v;
		}
		int nr = r + dx[dir][9], nc = c + dy[dir][9];
		if (nr < 0 || nr >= N || nc < 0 || nc >= N)
			sum += tmp;
		else
			a[nr][nc] += tmp;
	}

}
