import java.util.*;
import java.io.*;
import java.awt.Point;

public class 유닛이동시키기_2194 {
	static int N, M, A, B, K, x1, x2, y1, y2;
	static boolean[][] a;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };

	public static boolean check(int x, int y, int d) {
		if (d == 0) {
			for (int i = 0; i < B; i++) {
				int ny = y + i;
				if (x < 1 || x > N || ny < 1 || ny > M || a[x][ny])
					return false;
			}

		} else if (d == 1) {
			x += A - 1;
			for (int i = 0; i < B; i++) {
				int ny = y + i;
				if (x < 1 || x > N || ny < 1 || ny > M || a[x][ny])
					return false;
			}
		} else if (d == 2) {
			for (int i = 0; i < A; i++) {
				int nx = x + i;
				if (nx < 1 || nx > N || y < 1 || y > M || a[nx][y])
					return false;
			}
		} else {
			y += B - 1;
			for (int i = 0; i < A; i++) {
				int nx = x + i;
				if (nx < 1 || nx > N || y < 1 || y > M || a[nx][y])
					return false;
			}
		}
		return true;
	}

	public static int bfs() {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x1, y1));
		boolean[][] visit = new boolean[N + 1][M + 1];
		visit[x1][y1] = true;
		int move = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Point p = q.poll();

				if (p.x == x2 && p.y == y2)
					return move;

				for (int d = 0; d < 4; d++) {
					int x = p.x + dx[d], y = p.y + dy[d];
					if (x < 1 || x > N || y < 1 || y > M || visit[x][y])
						continue;
					visit[x][y] = true;
					if (check(x, y, d))
						q.add(new Point(x, y));
				}
			}
			move++;
		}
		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		a = new boolean[N + 1][M + 1];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
			a[x][y] = true;
		}
		st = new StringTokenizer(br.readLine());
		x1 = Integer.parseInt(st.nextToken());
		y1 = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		x2 = Integer.parseInt(st.nextToken());
		y2 = Integer.parseInt(st.nextToken());
		br.close();
		System.out.println(bfs());

	}

}
