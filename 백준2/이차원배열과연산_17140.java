import java.io.*;
import java.util.*;

public class Main {
	static int R = 3, C = 3;
	static int[][] a = new int[101][101];

	/*
	 * 수의 등장 횟수가 커지는 순으로, 그러한 것이 여러가지면 수가 커지는 순으로 정렬한다. 그 다음에는 배열 A에 정렬된 결과를 다시 넣어야
	 * 한다. 정렬된 결과를 배열에 넣을 때는, 수와 등장 횟수를 모두 넣으며, 순서는 수가 먼저이다.
	 */

	static class Num implements Comparable<Num> {
		int num, cnt;

		public Num(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Num n) {
			if (this.cnt == n.cnt)
				return this.num < n.num ? -1 : 1;
			return this.cnt < n.cnt ? -1 : 1;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 3; j++)
				a[i][j] = Integer.parseInt(st.nextToken());
		}
		br.close();
		int ans = 0;
		while (ans < 101) {
			if (a[r][c] == k) {
				System.out.println(ans);
				return;
			}
			if (R >= C)
				R();
			else
				C();
			ans++;
		}
		System.out.println(-1);
	}

	private static void C() {
		int max_row = R;
		for (int i = 1; i <= C; i++) {
			int[] number = new int[101];
			PriorityQueue<Num> q = new PriorityQueue<Num>();
			for (int j = 1; j <= R; j++) {
				if (a[j][i] > 0) {
					number[a[j][i]]++;
					a[j][i] = 0;
				}
			}
			for (int j = 1; j <= 100; j++) {
				if (number[j] > 0) {
					q.add(new Num(j, number[j]));
				}
			}
			int len = q.size() * 2;
			max_row = Math.max(max_row, len);
			for (int j = 1; j <= len && j <= 100; j += 2) {
				a[j][i] = q.peek().num;
				a[j + 1][i] = q.peek().cnt;
				q.poll();
			}
		}
		R = max_row;
	}

	private static void R() {
		int max_col = C;
		for (int i = 1; i <= R; i++) {
			int[] number = new int[101];
			PriorityQueue<Num> q = new PriorityQueue<Num>();
			for (int j = 1; j <= C; j++) {
				if (a[i][j] > 0) {
					number[a[i][j]]++;
					a[i][j] = 0;
				}
			}
			for (int j = 1; j <= 100; j++) {
				if (number[j] > 0) {
					q.add(new Num(j, number[j]));
				}
			}
			int len = q.size() * 2;
			max_col = Math.max(max_col, len);
			for (int j = 1; j <= len && j <= 100; j += 2) {
				a[i][j] = q.peek().num;
				a[i][j + 1] = q.peek().cnt;
				q.poll();
			}
		}
		C = max_col;
	}

}
