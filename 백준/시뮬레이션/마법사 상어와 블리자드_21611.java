import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static int N, M, size;
	static long sum = 0;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
	static int[] dr, dc;


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		setDirection();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			removeBeads(d, s);
			bombBeads();
			magic();
			
		}
		
		bw.write(sum + "\n");
		br.close();
		bw.close();
	}

	private static void magic() {
		ArrayList<Point> beads = new ArrayList<Point>();
		int r = N / 2, c = N / 2 - 1, NUM = map[r][c], CNT = 1;
		for (int i = 2; i < size; i++) {
			r += dr[i];
			c += dc[i];
			if (NUM != map[r][c]) {
				beads.add(new Point(CNT, NUM));
				NUM = map[r][c];
				CNT = 0;
			}
			CNT++;
			if (map[r][c] == 0)
				break;
		}

		map = new int[N][N];
		int i = 0;
		r = N / 2;
		c = N / 2;
		for (Point bead : beads) {
			i++;
			if(i == size)
				break;
			r += dr[i];
			c += dc[i];
			map[r][c] = bead.x;

			i++;
			r += dr[i];
			c += dc[i];
			map[r][c] = bead.y;
			
		}

	}

	private static void bombBeads() {
		boolean flag = true;
		int r, c;
		int NUM = 0, CNT = 0;

		while (flag) {
			// 구슬 빈칸 없애기
			goBeads();
			
			r = N / 2;
			c = N / 2;
			flag = false;
			// 구슬 폭발
			for (int i = 1; i < size; i++) {
				r += dr[i];
				c += dc[i];
				if (NUM == map[r][c])
					CNT++;
				if (NUM != map[r][c]) {
					if (CNT >= 4) {
						sum += NUM * CNT;
						flag = true;
						int br = r, bc = c;
						for (int j = 0; j < CNT; j++) {
							br -= dr[i - j];
							bc -= dc[i - j];
							map[br][bc] = 0;
						}
						
					}

					NUM = map[r][c];
					CNT = 1;
				}
				if (map[r][c] == 0)
					break;
			}
		}

	}

	private static void goBeads() {
		ArrayList<Integer> beads = new ArrayList<Integer>();
		int r = N / 2, c = N / 2, dir = 0;
		for (int i = 1; i < size; i++) {
			r += dr[i];
			c += dc[i];
			if (map[r][c] > 0)
				beads.add(map[r][c]);
		}

		map = new int[N][N];
		r = N / 2;
		c = N / 2;
		for (Integer nextBeads : beads) {
			dir++;
			r += dr[dir];
			c += dc[dir];
			map[r][c] = nextBeads;
		}
	}

	private static void setDirection() {
		size = N * N;
		dr = new int[size];
		dc = new int[size];

		int[] tr = { 0, 1, 0, -1 }, ty = { -1, 0, 1, 0 };
		int len = 1, cnt = 1, dir = 0;
		int r = N / 2, c = N / 2;

		while (true) {
			for (int k = 0; k < 2; k++) {
				for (int i = 0; i < len; i++) {
					r += tr[dir];
					c += ty[dir];
					dr[cnt] = tr[dir];
					dc[cnt] = ty[dir];
					cnt++;
					if (r == 0 && c == 0)
						return;
				}
				dir = (dir + 1) % 4;
			}
			len++;
		}

	}

	private static void removeBeads(int d, int s) {
		int x = N / 2;
		int y = N / 2;

		for (int i = 0; i < s; i++) {
			x += dx[d];
			y += dy[d];
			if (x < 0 || x >= N || y < 0 || y >= N)
				break;
			map[x][y] = 0;
		}

	}

}
