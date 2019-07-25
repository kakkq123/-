import java.util.Scanner;

public class baek2231 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		String s; // 문자열로 변환
		String[] st;
		int tmp, k;

		for (int i = 1; i <= n; i++) {
			s = String.valueOf(i); // 문자열로 변환
			st = s.split(""); // 한단어로 쪼개기
			k = tmp = i;

			for (int j = 0; j < s.length(); j++)
				tmp += Integer.parseInt(st[j]);

			// 분해합을 더함

			// 분해합과 n값과 같다면
			if (tmp == n) {
				System.out.println(k);
				System.exit(0);
			}

		}
		System.out.println(0);

	}

}
