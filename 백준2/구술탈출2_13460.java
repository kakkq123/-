import java.io.*;
import java.util.*;

public class 구술탈출2_13460 {
	static int N, M, hx, hy;
	static char[][] board;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };

	static class Beads {
		int rx, ry, bx, by;

		public Beads(int rx, int ry, int bx, int by) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
		}

	}

	public static int bfs(int x1, int y1, int x2, int y2) {
		Queue<Beads> q = new LinkedList<Beads>();
		q.add(new Beads(x1, y1, x2, y2));
		boolean[][][][] visit = new boolean[N][M][N][M];
		visit[x1][y1][x2][y2] = true;
		int time = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Beads b = q.poll();
				if (b.bx == hx && b.by == hy)
					continue;
				if (b.rx == hx && b.ry == hy)
					return time;
				for (int i = 0; i < 4; i++) {
					int rx = b.rx, ry = b.ry, bx = b.bx, by = b.by;
					int cr = 0, cb = 0;
					// RED
					while (board[rx + dx[i]][ry + dy[i]] != '#' && board[rx][ry] != 'O') {
						rx += dx[i];
						ry += dy[i];
						cr++;
					}
					// BLUE
					while (board[bx + dx[i]][by + dy[i]] != '#' && board[bx][by] != 'O') {
						bx += dx[i];
						by += dy[i];
						cb++;
					}
					if (rx == bx && ry == by) {
						if (rx == hx && ry == hy)
							continue;
						if (cr > cb) {
							rx -= dx[i];
							ry -= dy[i];
						} else {
							bx -= dx[i];
							by -= dy[i];
						}
					}
					if (visit[rx][ry][bx][by])
						continue;
					visit[rx][ry][bx][by] = true;
					q.add(new Beads(rx, ry, bx, by));
				}
			}
			if (time == 10)
				break;
			time++;
		}

		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		int rx = 0, ry = 0, bx = 0, by = 0;
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 'O') {
					hx = i;
					hy = j;
				} else if (board[i][j] == 'R') {
					board[i][j] = '.';
					rx = i;
					ry = j;
				} else if (board[i][j] == 'B') {
					board[i][j] = '.';
					bx = i;
					by = j;
				}
			}
		}
		bw.write(bfs(rx, ry, bx, by) + "\n");
		br.close();
		bw.close();
	}

}
