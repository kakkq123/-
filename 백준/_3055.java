//BFS
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class _3055 {
	static int r, c, answer = 2500;
	static boolean[][] visit;
	static char[][] map;
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	static Queue<Pos> q = new LinkedList<Pos>();

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static boolean range(int x, int y) {
		return x >= 0 && x < r && y >= 0 && y < c;
	}

	public static void bfs() {
		int time = 1;
		while (!q.isEmpty()) {
			//물 이동
			char[][] copy = new char[r][c];
			for (int i = 0; i < map.length; i++) {
				System.arraycopy(map[i], 0, copy[i], 0, map[0].length);
			}
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (map[i][j] == '*') {
						for (int k = 0; k < 4; k++) {
							int nr = i + dx[k];
							int nc = j + dy[k];
							if (range(nr, nc) && map[nr][nc] != 'D' && map[nr][nc] != 'X')
								copy[nr][nc] = '*';
						}
					}
				}
			}
			map = copy;
			// 고슴도치이동
			int q_size = q.size();
			for (int i = 0; i < q_size; i++) {
				int x = q.peek().x, y = q.peek().y;
				q.poll();
				for (int j = 0; j < 4; j++) {
					int nx = x + dx[j], ny = y + dy[j];
					if (!range(nx, ny) || visit[nx][ny] || map[nx][ny] == '*' || map[nx][ny] == 'X')
						continue;
					if (map[nx][ny] == 'D') {
						System.out.println(time);
						System.exit(0);
					}
					visit[nx][ny] = true;
					q.add(new Pos(nx, ny));
				}
			}
			time++;
		}
		System.out.println("KAKTUS");
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				if (map[i][j] == 'S')
					q.add(new Pos(i, j));
			}
		}
		visit = new boolean[r][c];
		bfs();
		br.close();
	}

}
