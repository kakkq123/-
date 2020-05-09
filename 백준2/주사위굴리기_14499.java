import java.util.*;
import java.io.*;

public class 주사위굴리기_14499 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] map = new int[20][20];
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		int[] dice = { 0, 0, 0, 0, 0, 0 };
		int[] dx = { 0, 0, 0, -1, 1 }, dy = { 0, 1, -1, 0, 0 };

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int d = Integer.parseInt(st.nextToken());
			x += dx[d];
			y += dy[d];
			if (x < 0 || x >= N || y < 0 || y >= M) {
				x -= dx[d];
				y -= dy[d];
				continue;
			}
			// 동
			if (d == 1) {
				int tmp = dice[0];
				dice[0] = dice[4];
				dice[4] = dice[2];
				dice[2] = dice[5];
				dice[5] = tmp;
			}
			// 서
			else if (d == 2) {
				int tmp = dice[0];
				dice[0] = dice[5];
				dice[5] = dice[2];
				dice[2] = dice[4];
				dice[4] = tmp;
			}
			// 북
			else if (d == 3) {
				int tmp = dice[0];
				dice[0] = dice[1];
				dice[1] = dice[2];
				dice[2] = dice[3];
				dice[3] = tmp;
			}
			// 남
			else {
				int tmp = dice[0];
				dice[0] = dice[3];
				dice[3] = dice[2];
				dice[2] = dice[1];
				dice[1] = tmp;
			}

			if (map[x][y] == 0) {
				map[x][y] = dice[2];
			} else {
				dice[2] = map[x][y];
				map[x][y] = 0;
			}
			bw.write(dice[0]+"\n");
		}

		br.close();
		bw.close();
	}

}
