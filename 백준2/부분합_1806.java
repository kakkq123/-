import java.io.*;
import java.util.*;

public class 부분합_1806 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int[] a = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			a[i] = Integer.parseInt(st.nextToken());
		br.close();

		int start = -1, end = -1, sum = 0, len = N + 1;
		while (start <= end) {
			if (sum < S) {
				if(end + 1 == N)
					break;
				sum += a[++end];
			}
			else {
				len = Math.min(len, end - start); // len의 최소 길이 업데이트
				sum -= a[++start];
			}
		}

		len = len == N + 1 ? 0 : len;
		System.out.println(len);
	}

}
