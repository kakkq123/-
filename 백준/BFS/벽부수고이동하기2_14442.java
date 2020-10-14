import java.io.*;
import java.util.*;

public class Main {
	static int R, C, K;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
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
		int move_cnt = 0;

		while (!q.isEmpty()) {
			move_cnt++;
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Maze m = q.poll();
				//도착
				if (m.r == R - 1 && m.c == C - 1)
					return move_cnt;
				for (int d = 0; d < 4; d++) {
					int r = m.r + dr[d], c = m.c + dc[d];
					//테두리 벗어나면
					if (r < 0 || r >= R || c < 0 || c >= C)
						continue;
					// 벽
					if (map[r][c] == '1') {
						//벽을 K만큼 부술 수 있는가? 이미 지나온 길인가?
						if (m.cnt < K && !visit[r][c][m.cnt + 1]) {
							visit[r][c][m.cnt + 1] = true;
							q.add(new Maze(r, c, m.cnt + 1));
						}
					}
					// 빈칸
					else {
						//아직 방문하지 않는 곳인가
						if (!visit[r][c][m.cnt]) {
							visit[r][c][m.cnt] = true;
							q.add(new Maze(r, c, m.cnt));
						}
					}
				}
			}
		}
		return -1;
	}

}
