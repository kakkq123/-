import java.util.*;
import java.io.*;
import java.awt.Point;

public class 수영장만들기_1113 {
	static int n, m;
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	static int[][] a;

	public static int bfs(int r, int c, int h) {
		Queue<Point> q = new LinkedList<Point>();
		Queue<Point> s = new LinkedList<Point>();
		q.add(new Point(r, c));
		s.add(new Point(r, c));

		a[r][c]++;
		int cnt = 1;

		while (!q.isEmpty()) {
			int x = q.peek().x, y = q.peek().y;
			q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i], ny = y + dy[i];
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || a[nx][ny] < h) {
					while (!s.isEmpty()) {
						int sx = s.peek().x, sy = s.peek().y;
						s.poll();
						a[sx][sy] -= 2;
					}
					return 0;
				}
				if (a[nx][ny] == h) {
					q.add(new Point(nx, ny));
					s.add(new Point(nx, ny));
					a[nx][ny]++;
					cnt++;
				}
			}
		}
		return cnt;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new int[n][m];

		int max = 0;
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				a[i][j] = s.charAt(j) - '0';
				max = Math.max(max, a[i][j]);
			}
		}
		br.close();

		int cnt = 0;
		for (int h = 1; h < max; h++) {
			for (int i = 1; i < n - 1; i++)
				for (int j = 1; j < m - 1; j++)
					if (a[i][j] == h)
						cnt += bfs(i, j, h);
		}
		System.out.println(cnt);
	}

}
