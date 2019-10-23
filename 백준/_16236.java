import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class _16236 {
	static PriorityQueue<Shark> shark = new PriorityQueue<Shark>();
	static int[][] a;
	static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };
	static int n, nr, nc, time = 0, eat = 0, shark_size = 2;
	static boolean[][] visit;

	static class Shark implements Comparable<Shark> {
		int r, c, dis;

		public Shark(int r, int c, int dis) {
			this.r = r;
			this.c = c;
			this.dis = dis;
		}

		@Override
		public int compareTo(Shark f) {
			if (this.dis == f.dis) {
				if (this.r == f.r)
					return this.c < f.c ? -1 : 1;
				return this.r < f.r ? -1 : 1;
			}
			return this.dis < f.dis ? -1 : 1;
		}
	}

	public static void shark_move() {
		while (!shark.isEmpty()) {
			int r = shark.peek().r;
			int c = shark.peek().c;
			int dis = shark.peek().dis;
			shark.poll();
			// 물고기 잡아 먹음
			if (a[r][c] <= 6 && a[r][c] > 0 && a[r][c] < shark_size) {
				eat++;
				a[r][c] = 0;
				if (eat == shark_size) {
					shark_size++;
					eat = 0;
				}
				time += dis;
				dis = 0;
				visit = new boolean[n][n];
				shark.clear();
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= n || nc < 0 || nc >= n || visit[nr][nc] || a[nr][nc] > shark_size)
					continue;
				visit[nr][nc] = true;
				shark.add(new Shark(nr, nc, dis + 1));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		a = new int[n][n];
		visit = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				if (a[i][j] == 9) {
					a[i][j] = 0;
					visit[i][j]=true;
					shark.add(new Shark(i, j, 0));
				}
			}
		}
		shark_move();
		System.out.println(time);
	}

}
