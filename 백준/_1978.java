import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1978 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int count = n;
		for (int i = 0; i < n; i++) {
			int t = Integer.parseInt(st.nextToken());
			if (t == 1) {
				count--;
				continue;
			}
			int r = (int) Math.sqrt(t);
			for (int j = 2; j <= r; j++) {
				if (t % j == 0) {
					count--;
					break;
				}
			}
		}
		System.out.println(count);
		br.close();

	}

}
