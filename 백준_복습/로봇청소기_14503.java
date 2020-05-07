import java.io.*;
import java.util.*;

public class 로봇청소기_14503 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] a = new int[N][M];
		int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		a[r][c] = -1;// 청소
		int num = 0, cnt = 1;
		while (true) {
			d = (d + 3) % 4;
			num++;
			if (r + dr[d] >= 0 || r + dr[d] < N || c + dc[d] >= 0 || c + dc[d] < M) {
				if (a[r + dr[d]][c + dc[d]] == 0) {
					r += dr[d];
					c += dc[d];
					a[r][c] = -1; // 청소
					num = 0;
					cnt++;
				}
			}

			if (num == 4) {
				r -= dr[d];
				c -= dc[d];
				if (r < 0 || r >= N || c < 0 || c >= M || a[r][c] == 1) {
					break;
				}
				num = 0;
			}
		}
		bw.write(cnt + "\n");
		br.close();
		bw.close();
	}

}
