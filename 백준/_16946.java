import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;

public class _16946 {
	static int n, m, index = 0;
	static int[][] map, num, s, a;
	static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };

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

	public static void solve(int r, int c) {
		int cnt = 1;
		Queue<Pos> q = new LinkedList<Pos>();
		Queue<Pos> t = new LinkedList<Pos>();
		q.add(new Pos(r, c));
		s[r][c] = index;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int nr = q.peek().r, nc = q.peek().c;
				t.add(q.poll());
				for (int j = 0; j < 4; j++) {
					int kr = nr + dr[j];
					int kc = nc + dc[j];
					if (range(kr, kc) && s[kr][kc] == 0 && map[kr][kc] == 0) {
						q.add(new Pos(kr, kc));
						s[kr][kc] = index;
						cnt++;
					}
				}
			}
		}
		while (!t.isEmpty()) {
			Pos p = t.poll();
			num[p.r][p.c] = cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		num = new int[n][m];
		a = new int[n][m];
		s = new int[n][m];
		LinkedList<Pos> wall = new LinkedList<Pos>();
		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(s[j]);
				if (map[i][j] == 1)
					wall.add(new Pos(i, j));
			}
		}
		br.close();
		// 벽 뿌시기
		while (!wall.isEmpty()) {
			Pos p = wall.poll();
			HashSet<Integer> h = new HashSet<Integer>();
			int cnt = 1;
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i], nc = p.c + dc[i];
				if (range(nr, nc) && map[nr][nc] == 0 && !h.contains(s[nr][nc])) {
					if (s[nr][nc] == 0) {
						index++;
						solve(nr, nc);
					}
					h.add(s[nr][nc]);
					cnt += num[nr][nc] % 10;
				}
			}
			a[p.r][p.c] = cnt % 10;
		}
		// print //
		/*	System.out.println()으로 출력했더니 시간초과가 났다
		 *	이 문제도 출력에 상당한 시간을 사용하는 것 같으니 BufferedWriter을 무조건 사용해야한다.
		 * */
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				bw.write(a[i][j] + "");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

}
