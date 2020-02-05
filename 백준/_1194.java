import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class _1194 {
	static int n, m;
	static char[][] a;
	static Queue<Pos> q = new LinkedList<Pos>();

	static class Pos {
		int r, c, k;

		public Pos(int r, int c, int k) {
			this.r = r;
			this.c = c;
			this.k = k;
		}
	}

	public static int bfs() {
		int cnt = 0;
		int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };
		boolean[][][] visit = new boolean[n][m][64];
		visit[q.peek().r][q.peek().c][0] = true;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Pos p = q.poll();
				if (a[p.r][p.c] == '1') {
					return cnt;
				}
				for (int i = 0; i < 4; i++) {
					int nr = p.r + dr[i], nc = p.c + dc[i], key= p.k;
					if (nr < 0 || nr >= n || nc < 0 || nc >= m || visit[nr][nc][p.k] || a[nr][nc] == '#')
						continue;
					visit[nr][nc][p.k] = true;
					// door
					if (a[nr][nc] >= 'A' && a[nr][nc] <= 'F') {
						int num = a[nr][nc] - 'A';
						if ((p.k & (1 << num)) == 0) {
							continue;
						}
					}
					// key
					else if (a[nr][nc] >= 'a' && a[nr][nc] <= 'f') {
						int num = a[nr][nc] - 'a';
						key = key | (1 << num);
					}
					q.add(new Pos(nr, nc, key));
				}
			}
			cnt++;
		}
		return -1;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new char[n][m];
		for (int i = 0; i < n; i++) {
			a[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (a[i][j] == '0')
					q.add(new Pos(i, j, 0));
			}
		}
		System.out.println(bfs());

		br.close();

	}

}
