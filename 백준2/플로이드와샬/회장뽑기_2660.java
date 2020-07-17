import java.io.*;
import java.util.*;

public class 회장뽑기_2660 {
	static int[][] a = new int[50][50];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		final int INF = 2000000;
		for (int i = 0; i < n; i++)
			Arrays.fill(a[i], INF);

		while (true) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (x == -1 && y == -1)
				break;
			a[x - 1][y - 1] = a[y - 1][x - 1] = 1;
		}

		floyd(n);
		
		int min = n, cnt = 0;
		int[] p = new int[n];
		for (int s = 0; s < n; s++) {
			for (int d = 0; d < n; d++) {
				if (s == d)
					continue;
				p[s] = Math.max(p[s], a[s][d]);
			}
			min = Math.min(p[s], min);
		}

		for (int i = 0; i < n; i++) {
			if (min == p[i])
				cnt++;
		}
		bw.write(min + " " + cnt + "\n");
		for (int i = 0; i < n; i++) {
			if (min == p[i])
				bw.write((i + 1) + " ");
		}
		br.close();
		bw.close();
	}

	private static void floyd(int n) {
		for (int k = 0; k < n; k++) {
			for (int s = 0; s < n; s++) {
				for (int d = 0; d < n; d++) {
					if (s == d)
						continue;
					if (a[s][d] > a[s][k] + a[k][d])
						a[s][d] = a[s][k] + a[k][d];
				}
			}
		}
	}

}
