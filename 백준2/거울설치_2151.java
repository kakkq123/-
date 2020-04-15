import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.ArrayDeque;

public class 거울설치_2151 {
	static int n, er, ec, min;
	static char[][] home;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, 1, -1 }, x = { 2, 3, 0, 1 }, y = { 3, 2, 1, 0 };
	static Deque<Pos> q = new ArrayDeque<Pos>();

	static class Pos {
		int r, c, d, m;

		public Pos(int r, int c, int d, int m) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.m = m;
		}
	}

	public static boolean check(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < n && home[r][c] != '*';
	}

	public static void bfs() {
		int min = n * n;
		boolean flag = false;
		boolean[][][] visit = new boolean[n][n][4];
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pos p = q.pollFirst();
				if (!check(p.r, p.c) || visit[p.r][p.c][p.d])
					continue;
				visit[p.r][p.c][p.d] = true;
				if (p.r == er && p.c == ec) {
					min = Math.min(min, p.m);
					flag = true;
				}
				if (flag)
					continue;
				q.addFirst(new Pos(p.r + dr[p.d], p.c + dc[p.d], p.d, p.m));
				if (home[p.r][p.c] == '!') {
					q.addLast(new Pos(p.r + dr[x[p.d]], p.c + dc[x[p.d]], x[p.d], p.m + 1));
					q.addLast(new Pos(p.r + dr[y[p.d]], p.c + dc[y[p.d]], y[p.d], p.m + 1));
				}

			}
		}
		System.out.println(min);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		home = new char[n][n];

		for (int i = 0; i < n; i++) {
			home[i] = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				if (home[i][j] == '#') {
					if (q.isEmpty()) {
						for (int d = 0; d < 4; d++) {
							q.add(new Pos(i + dr[d], j + dc[d], d, 0));
						}
					} else {
						er = i;
						ec = j;
					}
				}
			}
		}
		bfs();
		br.close();
	}

}
