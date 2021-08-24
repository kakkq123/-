import java.io.*;
import java.util.*;

public class Main {
	// 2805번
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(st.nextToken());
		br.close();

		Arrays.sort(a);		// 오름차순으로 정렬
		int result = 0;
		int left = 0, right = a[n - 1];
		while (left <= right) {
			int mid = (left + right) / 2;

			long sum = 0;
			for (int i = n - 1; i >= 0 && a[i] > mid; i--) {
				sum += a[i] - mid;
			}

			if (sum == m) {
				result = mid;
				break;
			} else if (sum > m) {
				result = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}

		}

		bw.write(result + "");
		bw.close();
	}

}
