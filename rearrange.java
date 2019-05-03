
import java.util.Arrays;
import java.util.Scanner;

public class rearrange {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("문자열 두 개를 입력하세요.");
		String s1 = kb.next();
		String s2 = kb.next();

		// 모두 소문자로 변환
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();

		String[] as1 = s1.split("");
		String[] as2 = s2.split("");

		// 배열을 오름차순으로 정렬
		// [참고] 내림차순 : Arrays.sort(배열,Collections.reverseOrder())

		Arrays.sort(as1);
		Arrays.sort(as2);

		// 배열을 문자열로 변환
		s1=Arrays.toString(as1);
		s2=Arrays.toString(as2);


		if (s1.equals(s2))
			System.out.println("Yes");
		else
			System.out.println("No");

	}

}
