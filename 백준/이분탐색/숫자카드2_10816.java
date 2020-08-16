import java.io.*;
import java.util.*;

public class Main {
	static int[] a;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		// 오름차순 정렬
		Arrays.sort(a);

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int target = Integer.parseInt(st.nextToken());
			int upper = upper_bound(target, n); // target보다 큰 index반환
			int lower = lower_bound(target, n); // target보다 작은 index반환
			bw.write((upper - lower) + " ");
		}

		br.close();
		bw.close();
	}
  //이분탐색을 사용하여 경계값을 찾는다
	private static int lower_bound(int target, int n) {
		int min = 0, max = n, mid;
		while (min < max) {
			mid = (min + max) / 2;
			if (a[mid] >= target)
				max = mid;
			else
				min = mid + 1;
		}
		return min;
	}

	private static int upper_bound(int target, int n) {
		int min = 0, max = n, mid;
		while (min < max) {
			mid = (min + max) / 2;
			if (a[mid] <= target)
				min = mid + 1;
			else 
				max = mid;
		}
		return max;
	}

}
