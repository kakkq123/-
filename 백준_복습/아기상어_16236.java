import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	static int N, R, C, size = 2, time = 0, eat = 0;
	static int[][] a = new int[20][20];
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

	static class Fish implements Comparable<Fish> {
		int r, c, z;

		public Fish(int r, int c, int z) {
			this.r = r;
			this.c = c;
			this.z = z;
		}

		@Override
		public int compareTo(Fish f) {
			if (this.z == f.z) {
				if (this.r == f.r)
					return this.c < f.c ? -1 : 1;
				return this.r < f.r ? -1 : 1;

			}
			return this.z < f.z ? -1 : 1;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				if (a[i][j] == 9) {
					a[i][j] = 0;
					R = i;
					C = j;
				}
			}
		}
		br.close();

		while (true) {
			if (!solve())
				break;
		}
		System.out.println(time);
	}

	private static boolean solve() {
		PriorityQueue<Fish> q = new PriorityQueue<Fish>();
		q.add(new Fish(R, C, 0));
		boolean[][] v = new boolean[N][N];
		v[R][C] = true;
		while (!q.isEmpty()) {
			Fish f = q.poll();
			if (a[f.r][f.c] > 0 && a[f.r][f.c] < size) {
				a[f.r][f.c] = 0;
				time += f.z;
				eat++;
				if (eat == size) {
					eat = 0;
					size++;
				}
				R = f.r;
				C = f.c;
				return true;
			}
			for (int d = 0; d < 4; d++) {
				int x = f.r + dr[d], y = f.c + dc[d];
				if (x < 0 || x >= N || y < 0 || y >= N || v[x][y] || a[x][y] > size)
					continue;
				v[x][y] = true;
				q.add(new Fish(x, y, f.z + 1));
			}

		}
		return false;
	}

}
