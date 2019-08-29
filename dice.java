import java.util.Scanner;

public class dice {
	static int[][] map = new int[22][22];
	static int n, m, k, x, y;
	static int[] dx = { 0, 0, 0, -1, 1 };
	static int[] dy = { 0, 1, -1, 0, 0 };

	public static boolean check(int x, int y) {
		if (x==0 || y==0 || x>n || y>m)
			return false;
		return true;
	}

	public static void change(int x, int y, int[] dice) {
		if (map[x][y] == 0) {
			map[x][y] = dice[6];
		} else {
			dice[6] = map[x][y];
			map[x][y] = 0;
		}
	}

	public static void solve(int x, int y, int[] dice) {
		int dir, tmp;
		Scanner kb = new Scanner(System.in);
		for (int i = 1; i <= k; i++) {
			dir = kb.nextInt();
			x += dx[dir];
			y += dy[dir];
			if (!check(x, y)) {
				x -= dx[dir];
				y -= dy[dir];
				continue;
			}

			if (dir == 1) {
				tmp = dice[3];
				dice[3] = dice[1];
				dice[1] = dice[4];
				dice[4] = dice[6];
				dice[6] = tmp;
			} else if (dir == 2) {
				tmp = dice[1];
				dice[1] = dice[3];
				dice[3] = dice[6];
				dice[6] = dice[4];
				dice[4] = tmp;
			} else if (dir == 3) {
				tmp = dice[1];
				dice[1] = dice[5];
				dice[5] = dice[6];
				dice[6] = dice[2];
				dice[2] = tmp;
			} else if (dir == 4) {
				tmp = dice[1];
				dice[1] = dice[2];
				dice[2] = dice[6];
				dice[6] = dice[5];
				dice[5] = tmp;
			}
			change(x, y, dice);
			System.out.println(dice[1]);
		}

	}

	public static void main(String[] args) throws Exception {
		Scanner kb = new Scanner(System.in);
		int[] dice = { 0, 0, 0, 0, 0, 0, 0 };
		n = kb.nextInt(); // 세로
		m = kb.nextInt();// 가로
		x = kb.nextInt() + 1; // 주사위 x
		y = kb.nextInt() + 1;// 주사위 y
		k = kb.nextInt();// 명령

		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= m; j++)
				map[i][j] = kb.nextInt();

		solve(x, y, dice);

		kb.close();
	}
}
