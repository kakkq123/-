import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static char[][] map = new char[10][10];
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

	static public void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int rx = -1, ry = -1, bx = -1, by = -1, x = -1, y = -1;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'R') {
					rx = i;
					ry = j;
				} else if (map[i][j] == 'B') {
					bx = i;
					by = j;
				} else if (map[i][j] == 'O') {
					x = i;
					y = j;
				}
			}
		}
		br.close();
		bw.write(solve(rx, ry, bx, by, x, y) + "\n");
		bw.close();
	}

	private static int solve(int rx, int ry, int bx, int by, int x, int y) {
		int turn = 0;
		boolean[][][][] visit = new boolean[N][M][N][M];
		visit[rx][ry][bx][by] = true;
		Queue<Beads> q = new LinkedList<Beads>();
		q.add(new Beads(rx, ry, bx, by));

		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Beads b = q.poll();
				// 파란 구슬이 먼저 빠지면 아웃
				if (b.bx == x && b.by == y)
					continue;
				// 빨간 구슬이 들어가면 return
				if (b.rx == x && b.ry == y)
					return turn;
				// 4가지 방향으로 이동
				for (int d = 0; d < 4; d++) {
					int _rx = b.rx, _ry = b.ry;
					int _bx = b.bx, _by = b.by;
					int rnt = 0, bnt = 0;
					while (map[_rx + dx[d]][_ry + dy[d]] != '#') {
						rnt++;
						_rx += dx[d];
						_ry += dy[d];
						if (map[_rx][_ry] == 'O')
							break;
					}
					while (map[_bx + dx[d]][_by + dy[d]] != '#') {
						bnt++;
						_bx += dx[d];
						_by += dy[d];
						if (map[_bx][_by] == 'O')
							break;
					}
					// 구슬 위치 조정
					if (_rx == _bx && _ry == _by) {
						// 파랑구슬과 빨간 구슬이 함께 빠지는 경우
						if (_rx == x && _ry == y)
							continue;
						if (rnt > bnt) {
							_rx -= dx[d];
							_ry -= dy[d];
						} else {
							_bx -= dx[d];
							_by -= dy[d];
						}
					}
					//
					if (!visit[_rx][_ry][_bx][_by]) {
						visit[_rx][_ry][_bx][_by] = true;
						q.add(new Beads(_rx, _ry, _bx, _by));
					}

				}
			}
			if (turn == 10)
				break;
			turn++;
		}
		return -1;
	}

}
