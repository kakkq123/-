import java.util.*;
import java.io.*;

public class Main {
	static int[] visit;
	static ArrayList<Integer>[] a;

	static public void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		a = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++)
			a[i] = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++)
				if (Integer.parseInt(st.nextToken()) == 1)
					a[i].add(j);
		}

		visit = new int[n + 1];
		int number = 0;
		for (int i = 1; i <= n; i++) {
			if (visit[i] == 0)
				dfs(i, ++number);
		}

		
		boolean answer = true;
		st = new StringTokenizer(br.readLine());
		int city = visit[Integer.parseInt(st.nextToken())];
		for (int i = 1; i < m; i++) {
			if (visit[Integer.parseInt(st.nextToken())] != city) {
				answer = false;
				break;
			}
		}
		if (answer)
			bw.write("YES\n");
		else
			bw.write("NO\n");
		br.close();
		bw.close();

	}

	private static void dfs(int city, int number) {
		visit[city] = number;
		for (int next : a[city]) {
			if (visit[next] == 0)
				dfs(next, number);
		}
	}

}
