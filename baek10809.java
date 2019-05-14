import java.util.Scanner;

public class baek10809 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int[] alphabet = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
				-1, -1, -1 };

		String str = kb.nextLine();
		str = str.toLowerCase(); // 소문자로 변환
		char[] c = str.toCharArray(); // char 배열로 변환
		
		//저장
		for(int i=0; i<c.length; i++) {
			if(alphabet[c[i]-97]!=-1)
				continue;
			alphabet[c[i]-97]=i;
		}
		//출력
		for(int i=0; i<alphabet.length; i++) {
			System.out.printf("%d ",alphabet[i]);
		}

	}

}
