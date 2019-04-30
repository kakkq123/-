/*
 * 입력받은 문자열을 "-"를 기준으로 나누어 
 * 첫글자로만 구성된 메모를 만드시오
 * */

import java.util.Scanner;

public class memo {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		String str = kb.nextLine();
		String[] token = str.split("-");
		String memo = "";

		for (int i = 0; i < token.length; i++) {
			memo += token[i].substring(0,1);
		}
	
		// 결과 출력
		System.out.println();
		System.out.printf("%s", memo);
	}

}
