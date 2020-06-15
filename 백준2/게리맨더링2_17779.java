import java.io.*;
import java.util.*;

public class 게리맨더링2_17779 {
	static int N, MIN = 2000000;
	static int[][] a = new int[21][21];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++)
				a[i][j] = Integer.parseInt(st.nextToken());
		}
		br.close();

		for (int x = 1; x <= N - 2; x++) {
			for (int y = 2; y <= N - 1; y++) {
				for (int d1 = 1; d1 <= N; d1++) {
					for (int d2 = 1; d2 <= N; d2++) {
						if (x + d1 + d2 <= N && 1 + d1 <= y && y + d2 <= N) {
							solve(x, y, d1, d2);
						}
					}
				}
			}
		}

		bw.write(MIN + "\n");
		bw.close();
	}

	private static void solve(int x, int y, int d1, int d2) {
		int[] b = new int[5];
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				//1번 선거구
				if (r < x + d1 && c <= y && (r < x || c < y - r + x)) {
					b[0] += a[r][c];
				}
				//2번 선거구
				else if (r <= x + d2 && c > y && (r < x || c > y + r - x)) {
					b[1] += a[r][c];
				}
				//3번 선거구
				else if (r >= x + d1 && c < y - d1 + d2 && (r > x + d1 + d2 || c < (y - d1  - x - d1  + r))) {
					b[2] += a[r][c];
				}
				//4번 선거구
				else if (r > x + d2 && c >= y - d1 + d2 && (r > x + d1 + d2 || c > (y  + d2 + x + d2 - r))) {
					b[3] += a[r][c];
				}
				// 5
				else
					b[4] += a[r][c];
			}
		}
		Arrays.sort(b);
		MIN = Math.min(MIN, b[4] - b[0]);

	}

}
