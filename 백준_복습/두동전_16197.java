import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static char[][] a = new char[22][22];

	static class Beads {
		int r1, c1, r2, c2;

		public Beads(int r1, int c1, int r2, int c2) {
			this.r1 = r1;
			this.c1 = c1;
			this.r2 = r2;
			this.c2 = c2;
		}
	}

	// o: 동전
	// .: 빈 칸
	// #: 벽
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int x1 = 0, x2 = 0, y1 = 0, y2 = 0, t = 0;
		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			for (int j = 1; j <= M; j++) {
				a[i][j] = s.charAt(j - 1);
				if (a[i][j] == 'o') {
					if (t == 0) {
						x1 = i;
						y1 = j;
						t++;
					} else {
						x2 = i;
						y2 = j;
					}
				}
			}
		}
		br.close();
		System.out.println(bfs(x1, y1, x2, y2));

	}

	private static boolean check(int r, int c) {
		return r >= 1 && r <= N && c >= 1 && c <= M;
	}

	private static int bfs(int x1, int y1, int x2, int y2) {
		Queue<Beads> q = new LinkedList<Beads>();
		q.add(new Beads(x1, y1, x2, y2));
		int move = 0;
		boolean[][][][] v = new boolean[N + 2][M + 2][N + 2][M + 2];
		v[x1][y1][x2][y2] = true;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Beads b = q.poll();
				//모두 범위 밖에 벗어나면
				if (!check(b.r1, b.c1) && !check(b.r2, b.c2))
					continue;
				//한 구슬만 보드에 벗어나야함
				if ((check(b.r1, b.c1) && !check(b.r2, b.c2)) || (!check(b.r1, b.c1) && check(b.r2, b.c2)))
					return move;

				for (int d = 0; d < 4; d++) {
					int r1 = b.r1 + dr[d], c1 = b.c1 + dc[d];
					int r2 = b.r2 + dr[d], c2 = b.c2 + dc[d];
					
					if (r1 < 0 || r1 > N + 1 || c1 < 0 || c1 > M + 1 || r2 < 0 || r2 > N + 1 || c2 < 0 || c2 > M + 1)
						continue;
					//벽이면 이동 못함
					if (a[r1][c1] == '#') {
						r1 = b.r1;
						c1 = b.c1;
					}
					if (a[r2][c2] == '#') {
						r2 = b.r2;
						c2 = b.c2;
					}
					//이미 방문했다면
					if (v[r1][c1][r2][c2])
						continue;
					v[r1][c1][r2][c2] = true;
					q.add(new Beads(r1, c1, r2, c2));
				}
			}
			move++;
			if (move > 10)
				break;
		}
		return -1;
	}

}
