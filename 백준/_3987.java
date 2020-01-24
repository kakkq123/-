import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3987 {
	static String[] d = { "U", "D", "R", "L" };
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, 1, -1 }, x = { 2, 3, 0, 1 }, y = { 3, 2, 1, 0 };
	static int n, m, pr, pc, max_time = 0, max_dir;
	static char[][] a;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new char[n][m];
		for (int i = 0; i < n; i++) {
			a[i] = br.readLine().toCharArray();
		}
		st = new StringTokenizer(br.readLine());
		pr = Integer.parseInt(st.nextToken()) - 1;
		pc = Integer.parseInt(st.nextToken()) - 1;
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
			if (a[r][c] == '/')
				dir = x[dir];
			if (a[r][c] == '\\')
				dir = y[dir];
			r += dr[dir];
			c += dc[dir];
			time++;
			if(r == pr && c == pc && start_dir == dir) {
				System.out.println(d[dir] + "\n" + "Voyager");
				System.exit(0);
			}
		} while (range(r, c) && a[r][c] != 'C');
		
		if(time > max_time) {
			max_time = time;
			max_dir = start_dir;
		}
	}

}
