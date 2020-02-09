import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class _1600 {
	static int w, h;
	static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 }, hr = { -2, -2, -1, 1, 2, 2, 1, -1 },
			hc = { -1, 1, 2, 2, 1, -1, -2, -2 };

	static class Monkey {
		int r, c, move;

		public Monkey(int r, int c, int move) {
			this.r = r;
			this.c = c;
			this.move = move;
		}
	}

	public static boolean range(int r, int c) {
		return r >= 0 && r < h && c >= 0 && c < w;
	}

	public static int bfs(int[][] a, int k) {
		Queue<Monkey> q = new LinkedList<Monkey>();
		q.add(new Monkey(0, 0, 0));
		int cnt = 0;
		boolean[][][] visit = new boolean[h][w][k + 1]; // 말처럼 이동을 몇 번 했는지 체크 필수
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Monkey m = q.poll();
				if (m.r == h - 1 && m.c == w - 1) {
					return cnt;
				}
				for (int d = 0; d < 4; d++) {
					int nr = m.r + dr[d], nc = m.c + dc[d];
					if (!range(nr, nc) || a[nr][nc] == 1 || visit[nr][nc][m.move])
						continue;
					visit[nr][nc][m.move] = true;
					q.add(new Monkey(nr, nc, m.move));
				}
				if (m.move < k) {
					for (int t = 0; t < 8; t++) {
						int tr = m.r + hr[t], tc = m.c + hc[t];
						if (range(tr, tc) && a[tr][tc] == 0 && !visit[tr][tc][m.move + 1]) {
							visit[tr][tc][m.move + 1] = true;
							q.add(new Monkey(tr, tc, m.move + 1));
						}
					}
				}
			}
			cnt++;
		}
		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		int[][] a = new int[h][w];
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(bfs(a, k));
		br.close();

	}

}
