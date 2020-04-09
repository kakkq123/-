import java.util.*;
import java.io.*;

public class 역사_1613 {
	static int n, k, INF = 1000000;
	static int[][] d;

	public static void floyd() {
		for (int k = 1; k <= n; k++) {
			for (int start = 1; start <= n; start++) {
				for (int dest = 1; dest <= n; dest++) {
					if (start == dest)
						continue;
					if(d[start][dest] > d[start][k] + d[k][dest])
						d[start][dest] = d[start][k] + d[k][dest];
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		d = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(d[i], INF);
		}
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
			d[x][y] = 1;
		}
		floyd();
		int s = Integer.parseInt(br.readLine());
		for (int t = 0; t < s; t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
			if (d[x][y] < INF)
				bw.write(-1 + "\n");
			else if (d[y][x] < INF)
				bw.write(1 + "\n");
			else
				bw.write(0 + "\n");
		}
		br.close();
		bw.close();
	}

}
