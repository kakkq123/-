import java.io.*;
import java.util.*;

public class Main {
	static int R, C, T;
	static int[][] a, b = new int[2][2];
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

	public static void diffusion() {
		int[][] copy = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (a[i][j] > 0) {
					int cnt = 0, val = a[i][j] / 5;
					for (int d = 0; d < 4; d++) {
						int r = i + dr[d], c = j + dc[d];
						if (r < 0 || r >= R || c < 0 || c >= C || (r == b[0][0] && c == b[0][1])
								|| (r == b[1][0] && c == b[1][1]))
							continue;
						cnt++;
						copy[r][c] += val;
					}
					copy[i][j] += a[i][j] - val * cnt;
				}
			}
		}
		for (int i = 0; i < R; i++)
			System.arraycopy(copy[i], 0, a[i], 0, copy[i].length);
	}

	public static void clear_air() {
		// 1
		for (int r = b[0][0] - 1; r > 0; r--)
			a[r][0] = a[r - 1][0];
		for (int c = 0; c < C - 1; c++)
			a[0][c] = a[0][c + 1];
		for (int r = 0; r < b[0][0]; r++)
			a[r][C - 1] = a[r + 1][C - 1];
		for (int c = C - 1; c > 0; c--)
			a[b[0][0]][c] = a[b[0][0]][c - 1];
		// 2
		for (int r = b[1][0] + 1; r < R - 1; r++)
			a[r][0] = a[r + 1][0];
		for (int c = 0; c < C - 1; c++)
			a[R - 1][c] = a[R - 1][c + 1];
		for (int r = R - 1; r > b[1][0]; r--)
			a[r][C - 1] = a[r - 1][C - 1];
		for (int c = C - 1; c > 0; c--)
			a[b[1][0]][c] = a[b[1][0]][c - 1];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		a = new int[R][C];
		int idx = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				if (a[i][j] == -1) {
					b[idx][0] = i;
					b[idx][1] = j;
					idx++;
				}
			}
		}
		br.close();
		for (int i = 0; i < T; i++) {
			diffusion();
			clear_air();
		}
		int ans = 0;
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				if (a[i][j] > 0)
					ans += a[i][j];

		System.out.println(ans);
	}

}
