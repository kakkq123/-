import java.io.*;
import java.util.*;
import java.awt.Point;

public class 단지번호붙이기_2667 {
	static int N;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	static boolean[][] visit;

	public static int bfs(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x, y));
		visit[x][y] = true;
		int cnt = 1;

		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visit[nx][ny])
					continue;
				visit[nx][ny] = true;
				if (map[nx][ny] == 1) {
					cnt++;
					q.add(new Point(nx, ny));
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++)
				map[i][j] = s.charAt(j) - '0';
		}
		br.close();

		visit = new boolean[N][N];
		ArrayList<Integer> a = new ArrayList<Integer>();
		int num = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					num++;
					a.add(bfs(i, j));
				}
			}
		}
		Collections.sort(a);
		bw.write(num + "\n");
		for (int number : a) {
			bw.write(number + "\n");
		}
		bw.close();
	}

}
