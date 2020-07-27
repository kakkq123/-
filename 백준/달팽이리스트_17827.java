import java.util.*;
import java.io.*;

public class Main {
	static public void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] a = new int[n + 1];

		for (int i = 1; i <= n; i++)
			a[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < m; i++) {
			int c = Integer.parseInt(br.readLine());
			if (c >= n) {
				c = V + ((c - V + 1) % (n - V + 1));
				bw.write(a[c] + "\n");
			} else
				bw.write(a[c + 1] + "\n");
		}
		br.close();
		bw.close();

	}

}
