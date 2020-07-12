import java.io.*;
import java.util.*;

public class 수들의합2_2003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] a = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			a[i] = Integer.parseInt(st.nextToken());

		int sum = 0, start = 0, end = 0, result = 0;

		while (true) {
			if (sum >= M)
				sum -= a[start++];
			else if (end == N)
				break;
			else
				sum += a[end++];
			if (sum == M)
				result++;

		}
		bw.write(result + "\n");
		br.close();
		bw.close();
	}

}
