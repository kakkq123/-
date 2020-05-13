import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static boolean[][] b = new boolean[101][101];
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, -1, 0, 1 };
	static ArrayList<Integer>[] a = new ArrayList[4];// = new ArrayList<Integer>();

	public static void dragon() {
		//드래곤 커브 10세대 모두 구해놓기
		//방향 0 - 3으로 시작하는 경우 모두 구해놓는다
		//N-1세대에서 (역순으로 ) + 1 해주면 90도 회전과 같음
		for (int i = 0; i < 4; i++) {
			a[i] = new ArrayList<Integer>();
			a[i].add(i);
			for (int j = 1; j <= 10; j++) {
				for (int k = a[i].size() - 1; k >= 0; k--) {
					a[i].add((a[i].get(k) + 1) % 4);
				}
			}
		}

	}

	public static void solve(int y, int x, int d, int g) {
		b[y][x] = true;
		int r = 1 << g;
		for (int i = 0; i < r; i++) {
			y += dy[a[d].get(i)];
			x += dx[a[d].get(i)];
			b[y][x] = true;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dragon();
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			solve(y, x, d, g);
		}
		br.close();
		int cnt = 0;
		for (int i = 0; i < 100; i++)
			for (int j = 0; j < 100; j++)
				if (b[i][j] && b[i + 1][j] && b[i][j + 1] && b[i + 1][j + 1])
					cnt++;
		System.out.println(cnt);
	}

}
