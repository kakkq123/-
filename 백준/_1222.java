import java.util.*;
import java.io.*;

public class Main _1222 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		// boolean[] team = new boolean[2000001];
		long[] a = new long[2000001];
		for (int i = 1; i <= N; i++)
			a[Integer.parseInt(st.nextToken())]++;
		br.close();

		long max = N; // 1 * N
		for (int i = 2; i <= 2000000; i++) {
			for (int j = i + i; j <= 2000000; j += i) {
				a[i] += a[j];
			}
		}

		for (int i = 1; i <= 2000000; i++)
			if (a[i] > 1) {
				//System.out.println(i + " " + a[i]);
				max = Math.max(max, a[i] * i);
			}

		System.out.println(max);
	}

}
