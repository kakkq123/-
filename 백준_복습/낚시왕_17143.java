import java.io.*;
import java.util.*;

public class 낚시왕 {
	static int R, C, M;
	static int[][][] a;
	// d가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		a = new int[R][C][3];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			a[r][c][0] = Integer.parseInt(st.nextToken()); // 속력
			a[r][c][1] = Integer.parseInt(st.nextToken()) - 1; // 방향
			a[r][c][2] = Integer.parseInt(st.nextToken()); // 크기

		}
		int ans = 0;
		for (int i = 0; i < C; i++) {
			ans += fishing(i);
			move();
		}
		System.out.println(ans);
	}

	private static void move() {
		int[][][] tmp = new int[R][C][3];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (a[r][c][2] > 0) {
					int _r = r, _c = c, s = a[r][c][0], d = a[r][c][1], z = a[r][c][2];
					if (d < 2) {
						for (int m = 0; m < s; m++) {
							if (_r == 0 && d == 0)
								d = 1;
							else if (_r == R - 1 && d == 1)
								d = 0;
							_r += dr[d];
						}
					} else {
						for (int m = 0; m < s; m++) {
							if (_c == 0 && d == 3)
								d = 2;
							else if (_c == C - 1 && d == 2)
								d = 3;
							_c += dc[d];
						}
					}
					if (tmp[_r][_c][2] < z) {
						tmp[_r][_c][0] = s;
						tmp[_r][_c][1] = d;
						tmp[_r][_c][2] = z;
					}
				}
			}
		}
		a = tmp;

	}

	private static int fishing(int c) {
		int ret = 0;
		for (int r = 0; r < R; r++) {
			if (a[r][c][2] > 0) {
				ret = a[r][c][2];
				a[r][c][0] = a[r][c][1] = a[r][c][2] = 0;
				break;
			}
		}
		return ret;
	}

}
