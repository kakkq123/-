import java.io.*;
import java.util.*;

public class Main {
	static int N, ans = 0;
	static int[][] a = new int[16][16];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				a[i][j] = Integer.parseInt(st.nextToken());
		}
		dfs(0, 1, 0);
		System.out.println(ans);
	}

	private static void dfs(int r, int c, int k) {
		if (r == N - 1 && c == N - 1) {
			ans++;
			return;
		}
		// ↘
		if (c + 1 < N && r + 1 < N && a[r][c + 1] == 0 && a[r + 1][c] == 0 && a[r + 1][c + 1] == 0)
			dfs(r + 1, c + 1, 2);

		// →
		if (k == 0 || k == 2)
			if (c + 1 < N && a[r][c + 1] == 0)
				dfs(r, c + 1, 0);

		// ↓
		if (k == 1 || k == 2)
			if (r + 1 < N && a[r + 1][c] == 0)
				dfs(r + 1, c, 1);

	}

}
