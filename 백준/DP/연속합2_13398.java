import java.io.*;
import java.util.*;

public class Main {

	static public void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		int[][] a = new int[n + 1][2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int max = a[1][0] = a[1][1] = k;
		for (int i = 2; i <= n; i++) {
			k = Integer.parseInt(st.nextToken());
			//연속합
			a[i][0] = Math.max(a[i - 1][0] + k, k);
			//건너
			a[i][1] = Math.max(a[i - 1][1] + k, a[i - 1][0]);
			max = Math.max(max, Math.max(a[i][0], a[i][1]));
		}

		bw.write(max + "\n");
		br.close();
		bw.close();
	}

}
