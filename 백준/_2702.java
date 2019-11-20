import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2702 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int tmp = a * b;
			if (a < b) {
				int t = a;
				a = b;
				b = t;
			}
			while (b != 0) {
				int r = a % b;
				a = b;
				b = r;
			}
			System.out.println(tmp / a + " " + a);
		}

		br.close();

	}

}
