import java.util.*;
import java.io.*;
import java.awt.Point;

public class 빙산_2573 {
	static int N, M;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	static LinkedList<Point> q = new LinkedList<Point>();

	public static int bfs() {
		Queue<Point> tmp = new LinkedList<Point>();
		tmp.add(q.get(0));
		int cnt = 1;
		boolean[][] visit = new boolean[N][M];
		visit[tmp.peek().x][tmp.peek().y] = true;
		while (!tmp.isEmpty()) {
			Point p = tmp.poll();
			for (int d = 0; d < 4; d++) {
				int nx = p.x + dx[d], ny = p.y + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visit[nx][ny])
					continue;
				visit[nx][ny] = true;
				if (map[nx][ny] > 0) {
					tmp.add(new Point(nx, ny));
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static void solve(int year) {
		for (Iterator<Point> iter = q.iterator(); iter.hasNext();) {
			Point p = iter.next();
			int cnt = 0;
			for (int d = 0; d < 4; d++) {
				int nx = p.x + dx[d], ny = p.y + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (map[nx][ny] <= 0 && map[nx][ny] != -year)
					cnt++;
			}
			map[p.x][p.y] -= cnt;
			if (map[p.x][p.y] <= 0) {
				map[p.x][p.y] = -year;
				iter.remove();
				continue;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0)
					q.add(new Point(i, j));
			}
		}
		int year = 0;
		while (!q.isEmpty()) {
			if (q.size() != bfs()) 
				break;
			year++;
			solve(year);
		}
		if (q.isEmpty())
			System.out.print(0);
		else
			System.out.print(year);
	}

}
