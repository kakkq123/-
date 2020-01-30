import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class _6087 {
	static int w, h, er, ec;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, 1, -1 }, x = { 2, 3, 0, 1 }, y = { 3, 2, 1, 0 };
	static Deque<Pos> q = new ArrayDeque<Pos>();
	static char[][] map;

	static class Pos {
		int r, c, d, m;

		public Pos(int r, int c, int d, int m) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.m = m;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		w = Integer.parseInt(st[0]); // 열
		h = Integer.parseInt(st[1]); // 행
		map = new char[h][w];
		for (int i = 0; i < h; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < w; j++) {
				if (map[i][j] == 'C') {
					if (q.isEmpty())
						for (int d = 0; d < 4; d++) {
							q.add(new Pos(i, j, d, 0));
						}
					else {
						er = i;
						ec = j;
					}
				}
			}
		}

		bfs();
		br.close();
	}

	public static boolean check(int r, int c) {
		return r >= 0 && r < h && c >= 0 && c < w && map[r][c] != '*';
	}

	public static void bfs() {
		int min = w * h;
		boolean flag = false;
		boolean[][][] visit = new boolean[h][w][4];
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
				q.addFirst(new Pos(p.r + dr[p.d], p.c + dc[p.d], p.d, p.m)); // 거울 X
				q.addLast(new Pos(p.r + dr[x[p.d]], p.c + dc[x[p.d]], x[p.d], p.m + 1)); // 거울 /
				q.addLast(new Pos(p.r + dr[y[p.d]], p.c + dc[y[p.d]], y[p.d], p.m + 1)); // 거울 \

			}
		}
		System.out.println(min);
	}
}
