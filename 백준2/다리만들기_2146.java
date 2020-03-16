import java.util.*;
import java.io.*;

public class 다리만들기_2146 {
	static int n;
	static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };
	static int[][] a;
	static boolean[][] visit;
	static ArrayList<Pos> outline = new ArrayList<Pos>();

	static class Pos {
		int r, c, value;

		public Pos(int r, int c, int value) {
			this.r = r;
			this.c = c;
			this.value = value;
		}
	}

	public static int cal(int r1, int c1, int r2, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2) - 1;
	}

	public static void dfs(int r, int c, int number) {
		boolean flag = false;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i], nc = c + dc[i];
			if (nr < 0 || nr >= n || nc < 0 || nc >= n || visit[nr][nc])
				continue;
			if (a[nr][nc] == 1) {
				a[nr][nc] = number;
				visit[nr][nc] = true;
				dfs(nr, nc, number);
			} else {
				flag = true;
			}
		}
		if (flag)
			outline.add(new Pos(r, c, number));
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		a = new int[n][n];
		visit = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				a[i][j] = Integer.parseInt(st.nextToken());
		}
		br.close();
		// 섬을 숫자로 분리
		int number = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 1) {
					visit[i][j] = true;
					a[i][j] = ++number;
					dfs(i, j, number);
				}
			}
		}
		int min = n * n;
		for (int i = 0; i < outline.size() - 1; i++) {
			for (int j = i + 1; j < outline.size(); j++) {
				if (outline.get(i).value == outline.get(j).value)
					continue;
				min = Math.min(min, cal(outline.get(i).r, outline.get(i).c, outline.get(j).r, outline.get(j).c));
			}
		}
		System.out.println(min);

	}

}
