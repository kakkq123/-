import java.util.*;
import java.io.*;
import java.awt.Point;;

public class _9205_floyd {
	static int N;
	static int[][] dis;

	public static void floyd() {
		for (int k = 0; k < N + 2; k++) {
			for (int s = 0; s < N + 2; s++) {
				for (int d = 0; d < N + 2; d++) {
					if (s == d)
						continue;
					if (dis[s][d] > dis[s][k] + dis[k][d])
						dis[s][d] = dis[s][k] + dis[k][d];
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());
		for (int t = 1; t <= test; t++) {
			N = Integer.parseInt(br.readLine());
			int[][] a = new int[N + 2][2];
			st = new StringTokenizer(br.readLine());
			a[0][0] = Integer.parseInt(st.nextToken());
			a[0][1] = Integer.parseInt(st.nextToken());
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				a[i][0] = Integer.parseInt(st.nextToken());
				a[i][1] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			a[N + 1][0] = Integer.parseInt(st.nextToken());
			a[N + 1][1] = Integer.parseInt(st.nextToken());
			// 거리계산
			int INF = 2000000;
			dis = new int[N + 2][N + 2];
			for (int i = 0; i < N + 2; i++)
				Arrays.fill(dis[i], INF);

			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < N + 2; j++) {
					if (i == j)
						continue;
					int distance = Math.abs(a[i][0] - a[j][0]) + Math.abs(a[i][1] - a[j][1]);
					float bottle = (float)distance / 50;
					if (bottle <= 20)
						dis[i][j] = 1;
				}
			}
			floyd();
			if(dis[0][N+1] < INF)
				bw.append("happy\n");
			else
				bw.append("sad\n");
		}
		br.close();
		bw.close();
	}

}
