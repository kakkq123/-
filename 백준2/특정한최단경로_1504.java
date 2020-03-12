import java.util.*;
import java.io.*;

//1번 정점에서 N번 정점으로 최단 거리
public class 특정한최단경로_1504 {
	static int n, INF = 10000;
	static int[][] d;

	public static void floyd() {
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (d[i][j] > d[i][k] + d[k][j]) {
						d[j][i] = d[i][j] = d[i][k] + d[k][j];
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		//이중 포문으로 값을 초기화하는 것보다 훨 빠름
		d = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(d[i], INF);
		}
		//자기 자신으로 가는 길 0으로 안하면 x, y의 값이 1 또는 N일 때 값이 이상하게 출력됨!
		for (int i = 1; i <= n; i++)
			d[i][i] = 0;
		//
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()),
					c = Integer.parseInt(st.nextToken());
			d[a][b] = d[b][a] = c;
		}
		//
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());

		floyd();
		if (d[1][x] == INF || d[x][y] == INF || d[y][n] == INF)
			bw.write(-1 + "\n");
		else
			bw.write(Math.min(d[1][x] + d[x][y] + d[y][n], d[1][y] + d[y][x] + d[x][n]) + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

}
