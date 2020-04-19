import java.util.*;
import java.io.*;
import java.awt.Point;

public class 불_5427 {
	static int w, h, sx, sy, time;
	static char[][] map;
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	static Queue<Point> fire;

	public static boolean bfs() {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(sx, sy));
		boolean[][] visit = new boolean[h][w];
		visit[sx][sy] = true;
		time = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			time++;
			// 불이 퍼짐~~~
			int fire_size = fire.size();
			for (int i = 0; i < fire_size; i++) {
				int x = fire.peek().x, y = fire.peek().y;
				fire.poll();
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d], ny = y + dy[d];
					if (nx < 0 || nx >= h || ny < 0 || ny >= w || visit[nx][ny])
						continue;
					visit[nx][ny] = true;
					if (map[nx][ny] == '.') {
						map[nx][ny] = '*';
						fire.add(new Point(nx, ny));
					}
				}
			}

			// 상근이 이동
			for (int s = 0; s < size; s++) {
				int x = q.peek().x, y = q.peek().y;
				q.poll();
				map[x][y] = '.';
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d], ny = y + dy[d];
					if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
						return true;
					}
					if (visit[nx][ny])
						continue;
					visit[nx][ny] = true;
					if (map[nx][ny] == '.') {
						map[nx][ny] = '@';
						q.add(new Point(nx, ny));
					}

				}
			}
		}
		return false;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());
		for (int t = 0; t < test; t++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			fire = new LinkedList<Point>();
			for (int i = 0; i < h; i++) {
				String s = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = s.charAt(j);
					if (map[i][j] == '@') {
						sx = i;
						sy = j;
					}
					if (map[i][j] == '*') {
						fire.add(new Point(i, j));
					}
				}
			}
			if (bfs())
				bw.write(time + "\n");
			else
				bw.write("IMPOSSIBLE\n");
		}
		br.close();
		bw.close();
	}

}
