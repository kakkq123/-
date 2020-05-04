import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _13275 {
	static int[] a;

	public static void manachers(String s, int N) {
		a= new int[N];
		int r = 0, p = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i <= r) {
				a[i] = Math.min(a[2 * p - i], r - i);
			} else
				a[i] = 0;

			while (i - a[i] - 1 >= 0 && i + a[i] + 1 < N && s.charAt(i - a[i] - 1) == s.charAt(i + a[i] + 1)) { // 양 옆의
																												// 값 같은지																								// 비교
				a[i]++;
			}

			if (r < i + a[i]) {
				r = i + a[i];
				p = i;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();		
		StringBuilder str = new StringBuilder();
		//String을 사용하여 #문자열을 중간중간 넣어줬는데 시간초과가 난다.......
		//StringBuilder 사용해야함...
		for (int i = 0; i < s.length(); i++) {
			str.append("#");
			str.append(s.charAt(i));
		}
		str.append("#");
		s=str.toString();
		int N = s.length(), max = 0;
		br.close();
		manachers(s, N);
		for (int i = 0; i < N; i++) {
			max = Math.max(max, a[i]);
		}
		System.out.println(max);
	}

}
