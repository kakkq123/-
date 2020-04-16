import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class _1726 {
	static int r, c, sr, sc, sd, er, ec, ed;
	static int[][] map;
	static int[] dr = { 0, 0, 0, 1, -1 }, dc = { 0, 1, -1, 0, 0 }, left = { 0, 4, 3, 1, 2 }, right = { 0, 3, 4, 2, 1 };

	static class Pos {
		int r, c, d;

		public Pos(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}

	}

	public static boolean range(int x, int y) {
		return x >= 1 && x <= r && y >= 1 && y <= c;
	}

	public static void bfs() {
		boolean[][][] visit = new boolean[r + 1][c + 1][5];
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(new Pos(sr, sc, sd));
		visit[sr][sc][sd] = true;
		int cnt = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pos p = q.poll();
				// Destination
				if (p.r == er && p.c == ec && p.d == ed) {
					System.out.println(cnt);
					return;
				}
				// Left
				if (!visit[p.r][p.c][left[p.d]]) {
					visit[p.r][p.c][left[p.d]] = true;
					q.add(new Pos(p.r, p.c, left[p.d]));
				}
				// Right
				if (!visit[p.r][p.c][right[p.d]]) {
					visit[p.r][p.c][right[p.d]] = true;
					q.add(new Pos(p.r, p.c, right[p.d]));
				}
				// Go k (1~3)
				for (int j = 1; j <= 3; j++) {
					int nr = p.r + dr[p.d] * j, nc = p.c + dc[p.d] * j;
					if (!range(nr, nc) || map[nr][nc] == 1)
						break;
					if (visit[nr][nc][p.d])
						continue;
					if (range(nr, nc) || map[nr][nc] == 0) {
						visit[nr][nc][p.d] = true;
						q.add(new Pos(nr, nc, p.d));
					}
				}
			}
			cnt++;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new int[r + 1][c + 1];
		for (int i = 1; i <= r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		sr = Integer.parseInt(st.nextToken());
		sc = Integer.parseInt(st.nextToken());
		sd = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		er = Integer.parseInt(st.nextToken());
		ec = Integer.parseInt(st.nextToken());
		ed = Integer.parseInt(st.nextToken());
		bfs(); //
		br.close();
	}

}
