import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14888 {
	static long min = 1000000000, max = -1000000000;
	static int[] arr;
	static int n;

	public static void cal(int index, long val, int a, int b, int c, int d) {
		if (index == n) {
			min = Math.min(min, val);
			max = Math.max(max, val);
			return;
		}
		if (a > 0) {
			cal(index + 1, val + (long)arr[index], a-1, b, c, d);
		}
		if (b > 0) {
			cal(index + 1, val -(long) arr[index], a, b-1, c, d);
		}
		if (c > 0) {
			cal(index + 1, val *(long) arr[index], a, b, c-1, d);
		}
		if (d > 0) {
			cal(index + 1, val / (long)arr[index], a, b, c, d-1);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken()); // +
		int b = Integer.parseInt(st.nextToken()); // -
		int c = Integer.parseInt(st.nextToken()); // /
		int d = Integer.parseInt(st.nextToken()); // *
		//
		cal(1, arr[0], a, b, c, d);
		//
		System.out.println(max + "\n" + min);
		br.close();
	}

}
