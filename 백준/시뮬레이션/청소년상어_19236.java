import java.io.*;
import java.util.*;

public class Main2 {
	static class Fish {
		int r, c, dir;
		boolean live;

		public Fish() {
		}

		public Fish(int r, int c, int dir, boolean live) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.live = live;
		}
	}

	static int max;
	static int dx[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int dy[] = { 0, -1, -1, -1, 0, 1, 1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int[][] map = new int[4][4];
		Fish[] fish = new Fish[17];

		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				map[i][j] = num;
				fish[num] = new Fish(i, j, dir, true);
			}
		}
		br.close();

		int num = map[0][0];
		// 물고기 잡아먹음
		fish[num].live = false;
		max = num;
		map[0][0] = -1; // 상어!!

		dfs(0, 0, fish[num].dir, num, map, fish);

		bw.write(max + "\n");
		bw.close();
	}

	private static void dfs(int x, int y, int dir, int sum, int[][] origin_map, Fish[] origin_fish) {
		max = Math.max(max, sum);
		int[][] map = new int[4][4];
		Fish[] fish = new Fish[17];
		copy_map(map, origin_map);
		copy_fish(fish, origin_fish);
		//물고기 이동
		move_fish(map, fish);
		//상어 이동
		for (int i = 1; i <= 3; i++) {
			int nx = x + dx[dir] * i, ny = y + dy[dir] * i;
			if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4)
				break;
			if (map[nx][ny] == 0)
				continue;
			// 상어가 물고기 잡아 먹음
			int fish_num = map[nx][ny];
			fish[fish_num].live = false;
			map[x][y] = 0;
			map[nx][ny] = -1;
			// 상어 이동
			dfs(nx, ny, fish[fish_num].dir, sum + fish_num, map, fish);
			// 다시 복구
			fish[fish_num].live = true;
			map[x][y] = -1;
			map[nx][ny] = fish_num;
		}

	}

	private static void copy_fish(Fish[] fish, Fish[] origin_fish) {

		for (int i = 1; i <= 16; i++) {
			fish[i] = new Fish();
			fish[i].r = origin_fish[i].r;
			fish[i].c = origin_fish[i].c;
			fish[i].dir = origin_fish[i].dir;
			fish[i].live = origin_fish[i].live;
		}

	}

	private static void copy_map(int[][] map, int[][] origin_map) {
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				map[i][j] = origin_map[i][j];

	}


	private static void move_fish(int[][] map, Fish[] fish) {
		for (int i = 1; i <= 16; i++) {
			// 물고기가 죽었으면
			if (!fish[i].live)
				continue;
			int r = fish[i].r, c = fish[i].c;

			for (int k = 0; k < 8; k++) {
				int nr = r + dx[fish[i].dir], nc = c + dy[fish[i].dir];
				//자리를 바꿀 수 있다면
				if (nr >= 0 && nr < 4 && nc >= 0 && nc < 4 && map[nr][nc] != -1) {
					int fish_num = map[nr][nc];
					//이동하는 자리에 물고기가 존재한다면
					if (fish_num > 0) {
						fish[fish_num].r = r;
						fish[fish_num].c = c;
					}
					map[r][c] = fish_num;
					fish[i].r = nr;
					fish[i].c = nc;
					map[nr][nc] = i;
					break;
				}
				//45도 회전
				fish[i].dir = (fish[i].dir + 1) % 8;
			}
		}
	}

}
