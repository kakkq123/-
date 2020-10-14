import java.io.*;
import java.util.*;

public class Main {
	static int R, C, K;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static char[][] map;

	static class Maze {
		int r, c, wall;

		public Maze(int r, int c, int wall) {
			this.r = r;
			this.c = c;
			this.wall = wall;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new char[R][C];
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
		boolean[][][] visit = new boolean[R][C][K + 1];
		visit[0][0][0] = true;
		int len = 0;

		while (!q.isEmpty()) {
			len++;
			int size = q.size();
			for (int s = 0; s < size; s++) {
				int r = q.peek().r, c = q.peek().c, wall = q.peek().wall;
				q.poll();
				if (r == R - 1 && c == C - 1)
					return len;
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d], nc = c + dc[d];
					if (nr < 0 || nr >= R || nc < 0 || nc >= C)
						continue;
					// 벽 O
					if (map[nr][nc] == '1' && wall < K && !visit[nr][nc][wall + 1]) {
						// 낮
						if (len % 2 == 1) {
							visit[nr][nc][wall + 1] = true;
							q.add(new Maze(nr, nc, wall + 1));
						}
						// 밤
						else {
							q.add(new Maze(r, c, wall));
						}
					}
					// 벽 X
					if (map[nr][nc] == '0' && !visit[nr][nc][wall]) {
						visit[nr][nc][wall] = true;
						q.add(new Maze(nr, nc, wall));
					}

				}
			}
		}
		return -1;
	}

}
