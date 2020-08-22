import java.util.*;
import java.io.*;

public class Main {

	static public void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] a = new ArrayList[n + 1];
		for (int i = 1; i <= n; ++i)
			a[i] = new ArrayList<Integer>();

		int[] Degree = new int[n + 1], result = new int[n + 1];
		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
			a[A].add(B);
			Degree[B]++;
		}

		for (int i = 1; i <= n; ++i)
			if (Degree[i] == 0)
				q.add(i);
		for (int i = 1; i <= n; ++i) {
			int cur = q.poll();
			result[i] = cur;

			for (int next : a[cur]) {
				if (--Degree[next] == 0)
					q.add(next);
			}
		}
		for (int i = 1; i <= n; ++i)
			bw.write(result[i] + " ");
		br.close();
		bw.close();

	}

}
