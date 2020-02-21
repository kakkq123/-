import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class _2174 {
	static int a, b;
	static LinkedList<Pos> robot = new LinkedList<Pos>();
	static int[][] board;
	static String[] NWES = { "N", "E", "S", "W" };
	static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };

	static class Pos {
		int r, c, d;

		public Pos(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	public static void check(String s, int num, int r) {
		int nr = robot.get(num - 1).r, nc = robot.get(num - 1).c, nd = robot.get(num - 1).d;
		board[nr][nc] = 0;
		if (s.equals("L")) {
			r = r % 4;
			for (int i = 0; i < r; i++)
				nd = (nd + 3) % 4;
		} else if (s.equals("R")) {
			r = r % 4;
			for (int i = 0; i < r; i++)
				nd = (nd + 1) % 4;
		} else {
			for (int i = 0; i < r; i++) {
				nr += dr[nd];
				nc += dc[nd];
				if (nr <= 0 || nr > b || nc <= 0 || nc > a) {
					System.out.println("Robot " + num + " crashes into the wall");
					System.exit(0);
				}
				if (board[nr][nc] >= 1) {
					System.out.println("Robot " + num + " crashes into robot " + board[nr][nc]);
					System.exit(0);
				}
			}
		}
		robot.get(num - 1).r = nr;
		robot.get(num - 1).c = nc;
		robot.get(num - 1).d = nd;
		board[nr][nc] = num;
	}

	public static int find(String input) {
		for (int i = 0; i < NWES.length; i++)
			if (NWES[i].equals(input))
				return i;
		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken()); // x-c
		b = Integer.parseInt(st.nextToken()); // y-r
		board = new int[b + 1][a + 1];
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 로봇 개수
		int m = Integer.parseInt(st.nextToken()); // 명령어 개수
		// 초기 위치
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			robot.add(new Pos(b + 1 - r, c, find(s)));
			board[b + 1 - r][c] = i;
		}
		// 명령어 수행
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			int r = Integer.parseInt(st.nextToken());
			check(s, num, r);
		}
		System.out.println("OK");
		br.close();
	}

}
