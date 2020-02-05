import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class _9328 {
	static int h, w;
	static char[][] map;
	static String key;

	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static int bfs() {
		int cnt = 0;
		int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };
		Queue<Pos> q = new LinkedList<Pos>();
		Queue<Pos>[] door = new LinkedList[26];
		for (int i = 0; i < 26; i++) {
			door[i] = new LinkedList<Pos>();
		}
		q.add(new Pos(0, 0));
		boolean[][] visit = new boolean[h + 2][w + 2];
		visit[0][0] = true;

		while (!q.isEmpty()) {
			Pos p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i], nc = p.c + dc[i];
				if (nr < 0 || nr >= h + 2 || nc < 0 || nc >= w + 2 || map[nr][nc] == '*' || visit[nr][nc])
					continue;
				visit[nr][nc] = true;
				// document
				if (map[nr][nc] == '$')
					cnt++;
				// key
				else if (map[nr][nc] >= 'a' && map[nr][nc] <= 'z') {
					String s =Character.toString(map[nr][nc]);
					if (!key.contains(s)) {
						key += s;
					}
					int num = map[nr][nc] - 'a';
					while (!door[num].isEmpty()) {
						q.add(door[num].poll());
					}
				}
				// door
				else if (map[nr][nc] >= 'A' && map[nr][nc] <= 'Z') {
					String tmp = Character.toString(map[nr][nc]).toLowerCase();
					if (!key.contains(tmp)) {
						door[map[nr][nc] - 'A'].add(new Pos(nr, nc));
						continue;
					}
				}
				q.add(new Pos(nr, nc));
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for (int t = 1; t <= test; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new char[h + 2][w + 2];
			// INPUT
			for (int i = 0; i <= w + 1; i++) {
				map[0][i] = '.';
			}
			for (int i = 1; i <= h; i++) {
				map[i][0] = '.';
				String s = br.readLine();
				for (int j = 1; j <= w; j++) {
					map[i][j] = s.charAt(j - 1);
				}
				map[i][w + 1] = '.';
			}
			for (int i = 0; i <= w + 1; i++) {
				map[h + 1][i] = '.';
			}
			key = br.readLine();
			System.out.println(bfs());
		}
		br.close();
	}

}
