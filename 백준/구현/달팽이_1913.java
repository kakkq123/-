import java.io.*;

public class Main {

	static int[][] a;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int v = Integer.parseInt(br.readLine());
		br.close();

		//
		a = new int[n][n];
		int sr = n / 2, sc = n / 2, dir = 0, move = 1, cnt = 0, N = n * n;
		int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };
		boolean turn = false;
		a[sr][sc] = 1;
		for (int i = 2; i <= N; i++) {
			sr += dr[dir];
			sc += dc[dir];
			a[sr][sc] = i;

			cnt++;
			if (move == cnt) {
				//MOVE + 1칸을 이동해야하는 경우
				if (turn) {
					move++;
					turn = false;
				}
				//단순히 방향만 바꾸고 MOVE만큼 이동해야하는 경우
				else {
					turn = true;
				}
				cnt = 0;
				dir = (dir + 1) % 4;
			} 
		}

		// print
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				bw.write(a[i][j] + " ");
			bw.newLine();
		}
		//해당값 위치 반환
		int r = 0, c = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (a[i][j] == v) {
					r = i+1;
					c = j+1;
					break;
				}
		bw.write(r + " " + c + "\n");
		bw.close();

	}

}
