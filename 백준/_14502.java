import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class _14502 {
	static int n, m, max = 0;
	static int[][] lab;
	static Queue<Pos> virus = new LinkedList<Pos>();
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	static int index = 0;//

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static boolean check(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < m;
	}

	public static int[][] virus_spread(int r, int c, int[][] tmp) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dx[i];
			int nc = c + dy[i];
			if (check(nr, nc) && tmp[nr][nc] == 0) {
				tmp[nr][nc] = 2;
				virus_spread(nr, nc, tmp);
			}
		}
		return tmp;
	}

	public static void safe_zone(int[][] tmp) {
		int safe_zone = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tmp[i][j] == 0)
					safe_zone++;
			}
		}
		max = Math.max(max, safe_zone);
	}

	public static void dfs(int wall_cnt, int x, int y) {
		if (wall_cnt == 3) {
			Queue<Pos> copy_virus = new LinkedList<Pos>();
			copy_virus.addAll(virus);
			int[][] tmp = new int[n][m];

			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++)
					tmp[i][j] = lab[i][j];
			while (!copy_virus.isEmpty()) {
				tmp = virus_spread(copy_virus.peek().x, copy_virus.peek().y, tmp);
				copy_virus.poll();
			}
			safe_zone(tmp);
			return;
		}

		int t;

		for (int i = x; i < n; i++) {
			t = (i == x ? y : 0);
			for (int j = t; j < m; j++) {
				if (lab[i][j] == 0) {
					lab[i][j] = 1;
					dfs(wall_cnt + 1, i, j);
					lab[i][j] = 0;
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		lab = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				if (lab[i][j] == 2)
					virus.add(new Pos(i, j));
			}
		}
		dfs(0, 0, 0);

		System.out.println(max);
		br.close();
	}

}
