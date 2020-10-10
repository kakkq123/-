import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K;
	static int[][][] map = new int[20][20][2], priority;
	static int[][] cur;
	static int[] shark_dir;
	static PriorityQueue<Shark> shark = new PriorityQueue<Shark>();

	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

	static class Shark implements Comparable<Shark> {
		int r, c, number, dir;

		public Shark(int r, int c, int number, int dir) {
			this.r = r;
			this.c = c;
			this.number = number;
			this.dir = dir;
		}

		public int compareTo(Shark s) {
			return s.number - this.number;
		}
	}

	static public void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j][0] = Integer.parseInt(st.nextToken()); // 상어의 숫자
				if (map[i][j][0] > 0)
					map[i][j][1] = K; // 상어 냄새
			}
		}
		// 각 상어들의 현재 방향
		shark_dir = new int[M + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++)
			shark_dir[i] = Integer.parseInt(st.nextToken()) - 1;

		// 각 상어들의 우선순위
		priority = new int[M + 1][4][4];
		for (int i = 1; i <= M; i++) {
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 4; k++) {
					int d = Integer.parseInt(st.nextToken()) - 1;
					priority[i][j][k] = d;
				}
			}
		}
		br.close();

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (map[i][j][0] > 0)
					shark.add(new Shark(i, j, map[i][j][0], shark_dir[map[i][j][0]]));

		bw.write(solve() + "\n");
		bw.close();
	}

	private static int solve() {
		for (int time = 1; time <= 100; time++) {
			int size = shark.size();
			cur = new int[N][N];
			for (int i = 0; i < size; i++) {
				Shark s = shark.poll();
				blank_find(s.r, s.c, s.number, s.dir);
			}
			reflect();
			decrease();
			if (shark.size() == 1)
				return time;
		}
		return -1;
	}

	private static void reflect() {
		for (int i = 0; i < N; i++) 
			for (int j = 0; j < N; j++) 
				if (cur[i][j] > 0) {
					map[i][j][0] = cur[i][j];
					map[i][j][1] = K + 1;
					shark.add(new Shark(i, j, map[i][j][0], shark_dir[map[i][j][0]]));
				}		
	}

	private static void decrease() {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				// 상어가 있으면
				if (map[i][j][0] > 0) {
					map[i][j][1]--;
					if (map[i][j][1] == 0)
						map[i][j][0] = 0;
				}

			}

	}

	private static void blank_find(int r, int c, int num, int dir) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[priority[num][dir][d]], nc = c + dc[priority[num][dir][d]];
			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				continue;
			if (map[nr][nc][1] == 0) {
				cur[nr][nc] = num;
				shark_dir[num] = priority[num][dir][d];
				return;
			}
		}
		smell_find(r, c, num, dir);

	}


	private static void smell_find(int r, int c, int num, int dir) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[priority[num][dir][d]], nc = c + dc[priority[num][dir][d]];
			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				continue;
			if (map[nr][nc][0] == num) {
				cur[nr][nc] = num;
				shark_dir[num] = priority[num][dir][d];
				return;
			}
		}

	}

}
