import java.io.*;
import java.util.*;

public class 피자굽기_1756 {
	public static int find(int value, int a, int b, int[] arr) {
		if (a > b)
			return 0;
		if (a == b) {
			if (arr[a] >= value) {
				return a;
			}
			return 0;
		}
		if (b - a == 1) {
			if (arr[a] >= value) {
				if(arr[b]>=value) {
					return b;
				}
				return a;
			}
			return 0;
		}
		int mid = (a + b) / 2;
		if (value <= arr[mid])
			return find(value, mid, b, arr);
		else
			return find(value, a, mid - 1, arr);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] _d = new int[D + 2];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= D; i++)
			_d[i] = Integer.parseInt(st.nextToken());

		for (int i = 2; i <= D; i++) {
			_d[i] = Math.min(_d[i - 1], _d[i]);
		}

		int bottom = D + 1;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int t = Integer.parseInt(st.nextToken());
			bottom = find(t, 1, bottom - 1, _d);
		}
		System.out.println(bottom);

	}

}
