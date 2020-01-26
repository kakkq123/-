import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2468 {
	static int[][] a;
	static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };
	static int n;
	static boolean[][] visit;

	public static void dfs(int r, int c, int h) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i], nc = c + dc[i];
			if (nr < 0 || nr >= n || nc < 0 || nc >= n || a[nr][nc] <= h || visit[nr][nc])
				continue;
			visit[nr][nc] = true;
			dfs(nr, nc, h);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		a = new int[n][n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				if (max < a[i][j])
					max = a[i][j];
			}
		}
		int ans = 0;
		for (int h = 0; h < max; h++) {
			int cnt = 0;
			visit = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (a[i][j] > h && !visit[i][j]) {
						visit[i][j]=true;
						dfs(i, j, h);
						cnt++;
					}
				}
			}
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
		br.close();
	}

}
