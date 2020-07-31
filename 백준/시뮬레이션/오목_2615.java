import java.util.*;
import java.io.*;

public class Main {
	static int[][] board = new int[20][20];
	static int[] dr = { -1, 0, 1, 1 }, dc = { 1, 1, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		for (int i = 1; i < 20; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 20; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0, nr = 0, nc = 0;
		for (int c = 1; c < 20; c++) {
			for (int r = 1; r < 20; r++) {

				if (board[r][c] > 0) {

					for (int d = 0; d < 4; d++) {
						int cnt = 0, _r = r, _c = c;
						do {
							cnt++;
							_r += dr[d];
							_c += dc[d];
						} while (_r >= 1 && _r <= 19 && _c >= 1 && _c <= 19 && board[_r][_c] == board[r][c]);

						if (cnt == 5) {
							if (r - dr[d] >= 1 && c - dc[d] >= 1 && board[r - dr[d]][c - dc[d]] == board[r][c]) {
								continue;
							}
							answer = board[r][c];
							nr = r;
							nc = c;
							break;
						}
					}

				}

			}
		}
		if (answer == 0)
			bw.write(0 + "\n");
		else
			bw.write(answer + "\n" + nr + " " + nc + "\n");

		br.close();
		bw.close();
	}

}
