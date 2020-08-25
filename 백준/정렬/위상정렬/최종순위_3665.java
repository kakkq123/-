import java.util.*;
import java.io.*;

public class Main {
	static public void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int TEST = Integer.parseInt(br.readLine());
		for (int test = 0; test < TEST; test++) {
			int n = Integer.parseInt(br.readLine());

			int[] t = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				t[i] = Integer.parseInt(st.nextToken());
			}

			boolean[][] A = new boolean[n + 1][n + 1];
			int[] Degree = new int[n + 1], result = new int[n];
			Queue<Integer> q = new LinkedList<Integer>();

			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					A[t[i]][t[j]] = true;
				}
				Degree[t[i]] =  i;
			}
			
			
			int m = Integer.parseInt(br.readLine());
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (A[a][b]) {
					A[a][b] = false;
					A[b][a] = true;
					Degree[b]--;
					Degree[a]++;
				}
				else {
					A[b][a] = false;
					A[a][b] = true;
					Degree[a]--;
					Degree[b]++;
				}
			}
			
			for (int i = 1; i <= n; i++)
				if (Degree[i] == 0)
					q.add(i);

			boolean cycle = false, certain = true;
			for (int i = 0; i < n; i++) {
				// cycle 발생
				if (q.size() == 0) {
					cycle = true;
					break;
				}
				// 순서를 알 수 없음
				if (q.size() > 1) {
					certain = false;
					break;
				}
				int cur = q.poll();
				result[i] = cur;
				for (int next = 1; next <= n; next++) {
					if (A[cur][next]) {
						if (--Degree[next] == 0)
							q.add(next);
					}
				}
			}

			if (cycle)
				bw.write("IMPOSSIBLE");
			else if (!certain)
				bw.write("?");
			else {
				for (int i = 0; i < n; ++i)
					bw.write(result[i] + " ");
			}
			bw.newLine();

		}
		br.close();
		bw.close();

	}
}
