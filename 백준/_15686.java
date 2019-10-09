import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15686 {
	static int n, m, all_distance = Integer.MAX_VALUE;
	static int[][] map;
	static Pos[] store;
	static Pos[] house;
	static boolean[][] visit;

	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static int get_distance(int r, int c) {
		int len = Integer.MAX_VALUE;
		for (int i = 1; i <= m; i++)
			len = Math.min(len, (Math.abs(r - store[i].r) + Math.abs(c - store[i].c)));
		return len;
	}

	public static void cal() {
		int len = 0;
		for (int i = 1; i < house.length; i++)
			len += get_distance(house[i].r, house[i].c);
		all_distance = Math.min(len, all_distance);
	}

	public static void dfs(int s, int r, int c) {
		if (s > m) {
			cal();
			return;
		}
		for (int i = r; i <= n; i++) {
			int k = (r < n && i == r ? c : 1);
			for (int j = k; j <= n; j++) {
				if (visit[i][j] || map[i][j] != 2)
					continue;
				visit[i][j] = true;
				store[s] = new Pos(i, j);
				dfs(s + 1, i, j);
				visit[i][j] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n + 1][n + 1];
		store = new Pos[m + 1];
		visit = new boolean[n + 1][n + 1];
		int h = 0;

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					h++;
				}
			}
		}
		house = new Pos[h + 1];
		h = 0;
		// house
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= n; j++)
				if (map[i][j] == 1)
					house[++h] = new Pos(i, j);

		dfs(1, 1, 1);
		System.out.println(all_distance);
		br.close();
	}
}
