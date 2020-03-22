import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class _11053_LIS {

	public static int find(int s, int e, int value, int[] v) {
		while (e - s > 0) {
			int mid = (s + e) / 2;
			if (v[mid] < value)
				s = mid + 1;
			else
				e = mid;
		}
		return e;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()), index = 0;
		int[] a = new int[n + 1], v = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++)
			a[i] = Integer.parseInt(st.nextToken());
		br.close();

		v[0] = -1;
		for (int i = 1; i <= n; i++) {
			for (int b = 0; b <= index; b++)
			if (v[index] < a[i]) {
				v[++index] = a[i];
			} else {
				int tmp_index = find(0, index, a[i], v);
				v[tmp_index] = a[i];
			}
		}
		System.out.println(index);
	}

}
