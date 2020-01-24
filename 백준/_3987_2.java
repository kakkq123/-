import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _3987_2 {
	static String[] d = { "U", "D", "R", "L" };
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, 1, -1 };
	static int n, m, pr, pc, max_time = 0, max_dir;
	static char[][] a;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		n = Integer.parseInt(st[0]);
		m = Integer.parseInt(st[1]);
		a = new char[n][m];
		for (int i = 0; i < n; i++) {
			a[i] = br.readLine().toCharArray();
		}
		st = br.readLine().split(" ");
		pr = Integer.parseInt(st[0]) - 1;
		pc = Integer.parseInt(st[1]) - 1;
		for (int i = 0; i < 4; i++)
			solve(i, i, pr, pc);

		System.out.println(d[max_dir] + "\n" + max_time);
		br.close();

	}

	public static boolean range(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < m;
	}

	public static void solve(int start_dir, int dir, int r, int c) {
		int time = 0;
		do {
			if (a[r][c] == '/') {
				if (dir == 0)
					dir = 2;
				else if (dir == 1)
					dir = 3;
				else if (dir == 2)
					dir = 0;
				else
					dir = 1;
			}
			if (a[r][c] == '\\') {
				if (dir == 0)
					dir = 3;
				else if (dir == 1)
					dir = 2;
				else if (dir == 2)
					dir = 1;
				else
					dir = 0;
			}
			r += dr[dir];
			c += dc[dir];
			time++;
			if (r == pr && c == pc && start_dir == dir) {
				System.out.println(d[dir] + "\n" + "Voyager");
				System.exit(0);
			}
		} while (range(r, c) && a[r][c] != 'C');

		if (time > max_time) {
			max_time = time;
			max_dir = start_dir;
		}
	}

}
