import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class _2638 {
	static int n, m;
	static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };

	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void bfs(int[][] a) {
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(new Pos(0, 0));
		boolean[][] visit = new boolean[n][m];
		visit[0][0] = true;
		while (!q.isEmpty()) {
			Pos p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i], nc = p.c + dc[i];
				if (nr < 0 || nr >= n || nc < 0 || nc >= m || visit[nr][nc])
					continue;
				if (a[nr][nc] == 0) {
					visit[nr][nc] = true;
					q.add(new Pos(nr, nc));
				}
				if (a[nr][nc] >= 1)
					a[nr][nc]++;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] a = new int[n][m];
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				if (a[i][j] == 1)
					cnt++;
			}
		}
		int time = 0;
		while (cnt > 0) {
			time++;
			// 공기 접촉 확인
			bfs(a);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (a[i][j] >= 3) {
						a[i][j] = 0;
						cnt--;
					} else if (a[i][j] >= 2)
						a[i][j] = 1;
				}
			}
		}

		System.out.println(time);
		br.close();

	}

}
