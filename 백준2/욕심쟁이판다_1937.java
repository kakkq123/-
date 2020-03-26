import java.util.*;
import java.io.*;

public class 욕심쟁이판다_1937 {
	static int n, k = 0;
	static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };
	static int[][] forest, dp;

	public static int dfs(int r, int c) {
		if (dp[r][c] == 0) {
			int max = 0;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i], nc = c + dc[i];
				if (nr < 0 || nr >= n || nc < 0 || nc >= n || forest[nr][nc] >= forest[r][c])
					continue;
				max = Math.max(max, dfs(nr, nc));
			}
			dp[r][c] = max + 1;
		}
		return dp[r][c];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		forest = new int[n][n];
		dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				forest[i][j] = Integer.parseInt(st.nextToken());
		}
		br.close();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (dp[i][j] == 0) {
					k = Math.max(k, dfs(i, j));
				}
			}
		}
		System.out.println(k);
	}

}
