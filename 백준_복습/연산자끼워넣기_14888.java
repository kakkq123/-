import java.io.*;
import java.util.*;

public class 연산자끼워넣기_14888 {

	static int[] num, op = new int[4];
	static int N, MAX = Integer.MIN_VALUE, MIN = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			num[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++)
			op[i] = Integer.parseInt(st.nextToken());
		bfs(0, num[0], 0, 0, 0, 0);
		bw.write(MAX + "\n" + MIN + "\n");
		br.close();
		bw.close();
	}

	private static void bfs(int idx, int res, int a, int b, int c, int d) {
		if (idx == N - 1) {
			MIN = Math.min(MIN, res);
			MAX = Math.max(MAX, res);
			return;
		}
		if (a < op[0])
			bfs(idx + 1, res + num[idx + 1], a + 1, b, c, d);

		if (b < op[1])
			bfs(idx + 1, res - num[idx + 1], a, b + 1, c, d);

		if (c < op[2])
			bfs(idx + 1, res * num[idx + 1], a, b, c + 1, d);

		if (d < op[3])
			bfs(idx + 1, res / num[idx + 1], a, b, c, d + 1);

	}

}
