import java.io.*;
import java.util.*;

/* 다리의 양 끝은 섬과 인접한 바다 위에 있어야 하고,
 * 한 다리의 방향이 중간에 바뀌면 안된다.
 * 또, 다리의 길이는 2 이상이어야 한다.*/

public class 다리만들기2_17472 {
	static int N, M, island = 0;
	static int[][] a, dis = new int[7][7];
	static boolean[][][] outline = new boolean[10][10][4];
	static boolean[][] visit = new boolean[10][10];
	static ArrayList<Pos>[] b = new ArrayList[7];
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	// static HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();

	static class Pos implements Comparable<Pos> {
		int r, c, d;

		public Pos(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}

		@Override
		public int compareTo(Pos p) {
			return this.d < p.d ? -1 : 1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		a = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// b는 섬의 경계선들을 저장함, 섬의 최대 개수는 6개
		for (int i = 1; i <= 6; i++)
			b[i] = new ArrayList<Pos>();
		// 경계선 찾기 + 섬 나누기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (a[i][j] == 1 && !visit[i][j]) {
					a[i][j] = ++island;
					dfs(i, j);
				}
			}
		}
		// 다리 가능한지 체크
		for (int i = 1; i <= island; i++)
			Arrays.fill(dis[i], 100);
		for (int i = 1; i <= island; i++) {
			for (Pos p : b[i]) {
				int len = 0, nr = p.r, nc = p.c;
				while (true) {
					nr += dr[p.d];
					nc += dc[p.d];
					if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
						break;
					}
					if (a[nr][nc] > 0) {
						if (len > 1 && dis[a[nr][nc]][a[p.r][p.c]] > len)
							dis[a[nr][nc]][i] = dis[i][a[nr][nc]] = len;
						break;
					}
					len++;
				}

			}
		}
		
		int[] set = new int[island + 1];
		for (int i = 1; i <= island; i++)
			set[i] = i;
		PriorityQueue<Pos> q = new PriorityQueue<Pos>();
		for (int i = 1; i < island; i++) {
			for (int j = i + 1; j <= island; j++) {
				if (dis[i][j] != 100)
					q.add(new Pos(i, j, dis[i][j]));
			}
		}
		int total_len = 0;
		while (!q.isEmpty()) {
			Pos e = q.poll();
			if (set[e.r] != set[e.c]) {
				total_len += e.d;
				if (set[e.r] < set[e.c]) {
					update(set, set[e.r], set[e.c]);
					set[e.c] = set[e.r];
				} else {
					update(set, set[e.c], set[e.r]);
					set[e.r] = set[e.c];
				}
			}
		}
		int t = set[1];
		boolean flag = false;
		for (int i = 2; i <= island; i++) {
			if (set[i] != t) {
				flag = true;
				break;
			}
		}
		if (flag)
			bw.write(-1 + "\n");
		else
			bw.write(total_len + "\n");
		bw.close();
	}

	private static void update(int[] set, int u, int k) {
		for (int i = 1; i <= island; i++) {
			if (set[i] == k)
				set[i] = u;
		}
	}

	private static void dfs(int r, int c) {
		visit[r][c]=true;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d], nc = c + dc[d];
			if (nr < 0 || nr >= N || nc < 0 || nc >= M || visit[nr][nc])
				continue;
			
			if (a[nr][nc] == 0 ) {
				b[island].add(new Pos(r, c, d));
				continue;
			}
			if (a[nr][nc] == 1) {
				a[nr][nc] = island;
				dfs(nr, nc);
			}
		}

	}

}
