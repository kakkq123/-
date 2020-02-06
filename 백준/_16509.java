import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

public class _16509 {
	static int r1, c1, r2, c2;
	static int[] dr = { -1, -1, 1, 1 }, dc = { -1, 1, 1, -1 };

	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static boolean range(int r, int c) {
		return r >= 0 && r < 10 && c >= 0 && c < 9;
	}

	public static boolean check(int r, int c, int d) {
		boolean flag = true;
		for (int k = 0; k < 2; k++) {
			if (r == r2 && c == c2)
				return false;
			r += dr[d];
			c += dc[d];
			if (!range(r, c)) {
				return false;
			}
		}
		return flag;
	}

	public static int bfs() {
		int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(new Pos(r1, c1));
		boolean[][] visit = new boolean[10][9];
		visit[r1][c1] = true;
		int cnt = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pos p = q.poll();
				if (p.r == r2 && p.c == c2) {
					return cnt;
				}
				// 상하좌우 이동
				for (int j = 0; j < 4; j++) {
					int nr = p.r + dx[j], nc = p.c + dy[j];
					if (!range(nr, nc) || (nr == r2 && nc == c2))
						continue;
					// 대각선 이동
					int tr = nr + dr[j] * 2, tc = nc + dc[j] * 2;
					if (check(nr, nc, j) && !visit[tr][tc]) {
						visit[tr][tc] = true;
						q.add(new Pos(tr, tc));
					}
					tr = nr + dr[(j + 1) % 4] * 2;
					tc = nc + dc[(j + 1) % 4] * 2;
					if (check(nr, nc, (j + 1) % 4) && !visit[tr][tc]) {
						visit[tr][tc] = true;
						q.add(new Pos(tr, tc));
					}
				}
			}
			cnt++;
		}
		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		r1 = Integer.parseInt(s[0]);
		c1 = Integer.parseInt(s[1]);

		s = br.readLine().split(" ");
		r2 = Integer.parseInt(s[0]);
		c2 = Integer.parseInt(s[1]);
		System.out.println(bfs());
		br.close();

	}

}
