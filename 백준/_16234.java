import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16234 {
	static int n, l, r, move_cnt = 0, nation;
	static int[][] a;
	static boolean[][] visit, moving;
	static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };

	public static boolean isRange(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < n;
	}

	public static boolean possible(int r1, int c1, int r2, int c2) {
		return Math.abs(a[r1][c1] - a[r2][c2]) >= l && Math.abs(a[r1][c1] - a[r2][c2]) <= r;
	}

	public static void move(int population) {
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (moving[i][j]) {
					moving[i][j]=false;
					a[i][j] = population;	
				}
	}

	public static int dfs(int r, int c) {
		int population =a[r][c];
		visit[r][c] = true;
		for (int i = 0; i < 4; i++) {
			if (isRange(r + dr[i], c + dc[i]) && possible(r, c, r + dr[i], c + dc[i]) && !visit[r + dr[i]][c + dc[i]]) {
				nation++;
				moving[r][c] =moving[r + dr[i]][c + dc[i]] = true;
				population +=dfs(r + dr[i], c + dc[i]);
			}
		}
		return population;
	}

	public static void solve() {
		boolean ischange;
		while (true) {
			ischange = false;
			visit = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (visit[i][j])
						continue;
					nation = 1;
					int population = dfs(i, j);
					if (nation > 1) {
						ischange = true;
						move(population / nation);
					}
				}
			}
			if (!ischange)
				break;
			move_cnt++;
		} // while
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		a = new int[n][n];
		moving=new boolean[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				a[i][j] = Integer.parseInt(st.nextToken());
		}
		solve();
		System.out.println(move_cnt);
		br.close();
	}
}
