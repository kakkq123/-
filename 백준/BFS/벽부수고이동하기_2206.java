import java.io.*;
import java.util.*;

public class Main {
	static int R, C;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, 1, -1 };
	static char[][] map;

	static class Maze {
		int r, c, cnt;

		public Maze(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C]; // 미로 문자
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++)
				map[i][j] = s.charAt(j);
		}
		br.close();
		bw.write(bfs() + "\n");
		bw.close();
	}

	private static int bfs() {
		Queue<Maze> q = new LinkedList<Maze>();
		q.add(new Maze(0, 0, 0));
		boolean[][][] visit = new boolean[R][C][2]; // 방문 체크
		visit[0][0][0] = true;

		int move_cnt = 0;
		while (!q.isEmpty()) {
			move_cnt++;
			int size = q.size();
			for (int s = 0; s < size; s++) {
				int r = q.peek().r, c = q.peek().c, cnt = q.peek().cnt;
				q.poll();
				if (r == R - 1 && c == C - 1)
					return move_cnt;
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d], nc = c + dc[d];
					if (nr < 0 || nr >= R || nc < 0 || nc >= C)
						continue;
					// 벽이 아니라면 그냥 이동
					if (map[nr][nc] == '0') {
						if (!visit[nr][nc][cnt]) {
							visit[nr][nc][cnt] = true;
							q.add(new Maze(nr, nc, cnt));
						}
					} // 벽이라면, 벽을 부시고 갈 수 있는가?
					else {
						if (cnt == 0 && !visit[nr][nc][1]) {
							visit[nr][nc][1] = true;
							q.add(new Maze(nr, nc, cnt + 1));
						}
					}
				}
			}
		}
		return -1;
	}

}
