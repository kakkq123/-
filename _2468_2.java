import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class _2468_2 {
	static int[][] a;
	static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };
	static int n;
	static boolean[][] visit;

	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void bfs(Queue<Pos> q, int h) {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pos p = q.poll();
				for (int j = 0; j < 4; j++) {
					int r = p.r + dr[j], c = p.c + dc[j];
					if (r < 0 || r >= n || c < 0 || c >= n || a[r][c] <= h || visit[r][c])
						continue;
					visit[r][c] = true;
					q.add(new Pos(r, c));
				}
			}
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
			Queue<Pos> q = new LinkedList<Pos>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (a[i][j] > h && !visit[i][j]) {
						visit[i][j] = true;
						q.add(new Pos(i, j));
						bfs(q, h);
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
