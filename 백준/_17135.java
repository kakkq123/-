import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class _17135 {
	static int n, m, d, answer = 0, enemy_num, kill_num, copy_enemy_num;
	static int[][] map;
	static Deque<Pos> archer = new ArrayDeque<Pos>();

	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static boolean range(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < m;
	}

	public static int[][] attack(int r, int c, int[][] copy_map, Deque<Pos> delete) {
		int min = d + 1, mr = n + 1, mc = m;
		for (int i = r - d; i <= r + d; i++) {
			for (int j = c - d; j <= c + d; j++) {
				if (range(i, j)) {
					int dis = Math.abs(r - i) + Math.abs(c - j);
					if (dis <= d && dis <= min && copy_map[i][j] == 1) {
						if ((dis == min && j < mc) || dis < min) {
							mr = i;
							mc = j;
							min = dis;
						}
					}
				}
			}
		}
		// 적이 존재하고 거리 최솟값 + 가장 왼쪽인 적을 죽임
		if (mc != m) {
			delete.add(new Pos(mr, mc));
		}
		return copy_map;
	}

	public static void move() {
		int[][] copy_map = new int[n][m];
		for (int i = 0; i < map.length; i++) {
			System.arraycopy(map[i], 0, copy_map[i], 0, map[0].length);
		}
		copy_enemy_num = enemy_num;
		kill_num = 0;
		while (copy_enemy_num > 0) {
			// 궁수 공격
			Deque<Pos> delete = new ArrayDeque<Pos>();
			for (Pos a : archer) {
				copy_map = attack(a.r, a.c, copy_map, delete);
			}
			for (Pos d : delete) {
				if (copy_map[d.r][d.c] == 1) {
					kill_num++;
					copy_enemy_num--;
					copy_map[d.r][d.c] = 0;
				}
			}
			// 적 이동
			for (int i = n - 1; i >= 0; i--) {
				for (int j = 0; j < m; j++) {
					if (copy_map[i][j] == 0)
						continue;
					copy_map[i][j] = 0;
					if (i + 1 == n)
						copy_enemy_num--;
					else
						copy_map[i + 1][j] = 1;
				}
			}
		} // end of while
		answer = Math.max(answer, kill_num);
	}

	public static void dfs(int c) {
		// 게임 시작
		if (archer.size() == 3) {
			move();
			return;
		}
		// 궁수 놓기
		if (c == m)
			return;
		for (int j = c; j < m; j++) {
			archer.add(new Pos(n, j));
			dfs(j + 1);
			archer.pollLast();
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		// 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					enemy_num++;
			}
		}
		dfs(0);
		System.out.println(answer);
		br.close();

	}
}
