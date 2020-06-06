import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	static int N, M;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
	static char[][] a = new char[12][6];
	static Queue<Point> delete;
	static boolean[][] visit;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 12; i++) {
			String s = br.readLine();
			for (int j = 0; j < 6; j++) {
				a[i][j] = s.charAt(j);
			}
		}
		br.close();
		int answer = 0;
		do {
			flag = false;
			delete = new LinkedList<Point>();
			visit = new boolean[12][6];

			for (int r = 11; r >= 0; r--)
				for (int c = 0; c < 6; c++)
					if (a[r][c] != '.' && !visit[r][c])
						bfs(r, c, a[r][c]);

			if (flag) {
				clear();
				answer++;
			}

		} while (flag);
		System.out.println(answer);
	}

	private static boolean bfs(int r, int c, char comp) {
		Queue<Point> tmp = new LinkedList<Point>();
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(r, c));
		tmp.add(new Point(r, c));
		visit[r][c] = true;
		int cnt = 1;

		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < 4; d++) {
				int x = p.x + dx[d], y = p.y + dy[d];
				if (x < 0 || x >= 12 || y < 0 || y >= 6 || visit[x][y] || a[x][y] != comp)
					continue;
				visit[x][y] = true;
				q.add(new Point(x, y));
				tmp.add(new Point(x, y));
				cnt++;
			}
		}
		if (cnt >= 4) {
			delete.addAll(tmp);
			flag = true;
			return true;
		}
		return false;
	}

	private static void clear() {
		while (!delete.isEmpty()) {
			Point p = delete.poll();
			a[p.x][p.y] = '.';
		}
		for (int c = 0; c < 6; c++) {
			for (int r = 11; r >= 0; r--) {
				if (a[r][c] == '.') {
					int d = 0, nr = r;
					while (nr >= 0 && a[nr][c] == '.') {
						d++;
						nr--;
					}
					if (d > 0) {
						for (int k = nr; k >= 0; k--) {
							a[k + d][c] = a[k][c];
						}
						for (int k = 0; k < d; k++) {
							a[k][c] = '.';
						}
					}

				}
			}
		}
	}

}
