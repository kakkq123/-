import java.io.*;
import java.util.*;

public class 배열돌리기4_17406 {
	static int R, C, K, INF = 2000000, MIN = INF;
	static int[][] a, b, command = new int[6][3];
	static int[] t = new int[6];
	static boolean[] v = new boolean[6];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		a = new int[R][C];
		b = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++)
				a[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			command[i][0] = Integer.parseInt(st.nextToken()) - 1; // r
			command[i][1] = Integer.parseInt(st.nextToken()) - 1; // c
			command[i][2] = Integer.parseInt(st.nextToken()); // s
		}

		dfs(0);
		bw.write(MIN + "\n");
		br.close();
		bw.close();

	}

	private static void dfs(int n) {
		if (n == K) {
			for (int i = 0; i < R; i++)
				System.arraycopy(a[i], 0, b[i], 0, C);
			for (int i = 0; i < K; i++) {
				for (int s = command[t[i]][2]; s > 0; s--) {
					rotate(command[t[i]][0] - s, command[t[i]][1] - s, s * 2 + 1);
				}
			}
			cal();
			return;
		}
		for (int i = 0; i < K; i++) {
			if (!v[i]) {
				v[i] = true;
				t[n] = i;
				dfs(n + 1);
				v[i] = false;
			}
		}
	}

	private static void rotate(int r, int c, int s) {
		int[][] t = new int[4][s];
		// 위
		for (int i = 0; i < s; i++)
			t[0][i] = b[r][c + i];
		// 오
		for (int i = 0; i < s; i++) 
			t[1][i] = b[r + i][c + s - 1];
		// 아래
		for (int i = 0; i < s; i++) 
			t[2][i] = b[r + s - 1][c + i];
		// 왼
		for (int i = 0; i < s; i++)
			t[3][i] = b[r + i][c];
		
		// 위
		for (int i = 1; i < s; i++) 
			b[r][c + i] = t[0][i - 1];
		// 오
		for (int i = 1; i < s; i++) 
			b[r + i][c + s - 1] = t[1][i - 1];
		// 아래
		for (int i = 0; i < s - 1; i++) 
			b[r + s - 1][c + i] = t[2][i + 1];
		// 왼
		for (int i = 0; i < s - 1; i++) 
			b[r + i][c] = t[3][i + 1];

	}

	private static void cal() {
		for (int i = 0; i < R; i++) {
			int sum = 0;
			for (int j = 0; j < C; j++) {
				sum += b[i][j];
			}
			MIN = Math.min(MIN, sum);
		}
	}

}
