import java.io.*;
import java.util.*;

public class Main {
	static int answer = 20000;
	static int[][][] cube = new int[5][5][5], copy = new int[5][5][5];
	static boolean[] f = new boolean[5];
	static int[] order = new int[5];
	static int[] dx = { -1, 1, 0, 0, 0, 0 }, dy = { 0, 0, -1, 1, 0, 0 }, dz = { 0, 0, 0, 0, -1, 1 };

	static class Pos {
		int z, x, y;

		public Pos(int z, int x, int y) {
			this.z = z;
			this.x = x;
			this.y = y;
		}

	}

	// 0은 참가자가 들어갈 수 없는 칸, 1은 참가자가 들어갈 수 있는 칸을 의미한다.
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int z = 0; z < 5; z++) {
			for (int x = 0; x < 5; x++) {
				st = new StringTokenizer(br.readLine());
				for (int y = 0; y < 5; y++) {
					cube[z][x][y] = Integer.parseInt(st.nextToken());
				}
			}
		}
		br.close();
		for (int a = 0; a < 4; a++) {
			rotate(0);
			for (int b = 0; b < 4; b++) {
				rotate(1);
				for (int c = 0; c < 4; c++) {
					rotate(2);
					for (int d = 0; d < 4; d++) {
						rotate(3);
						for (int e = 0; e < 4; e++) {
							rotate(4);
							stack_cube(0);
						}
					}
				}
			}
		}
		answer = answer == 20000 ? -1 : answer;
		System.out.println(answer);

	}

	private static void rotate(int floor) {
		int[][] tmp = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				tmp[j][4 - i] = cube[floor][i][j];
			}
		}
		cube[floor] = tmp;
	}

	private static void stack_cube(int floor) {
		if (floor == 5) {
			if (cube[order[0]][0][0] == 1 && cube[order[4]][4][4] == 1) {
				bfs(0, 0, 0);
			}
			return;
		}
		for (int i = 0; i < 5; i++) {
			if (!f[i]) {
				f[i] = true;
				order[floor] = i;
				stack_cube(floor + 1);
				f[i] = false;
			}
		}
	}

	private static void bfs(int z, int x, int y) {
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(new Pos(0, 0, 0));
		int dis = 0;
		boolean[][][] v = new boolean[5][5][5];
		v[z][x][y] = true;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Pos p = q.poll();
				if (p.x == 4 && p.y == 4 && p.z == 4) {
					answer = dis;
					return;
				}
				for (int d = 0; d < 6; d++) {
					int nx = p.x + dx[d], ny = p.y + dy[d], nz = p.z + dz[d];
					if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || nz < 0 || nz >= 5)
						continue;
					if (v[nz][nx][ny] || cube[order[nz]][nx][ny] == 0)
						continue;
					v[nz][nx][ny] = true;
					q.add(new Pos(nz, nx, ny));
				}
			}
			dis++;
			if (answer <= dis)
				return;
		}
	}

}
