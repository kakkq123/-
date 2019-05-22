/*
 * OX 퀴즈
 * O가 연속적으로 나오면 차례대로 1,2,3..점을 얻으며
 * X 뒤에 O가 나오면 점수는 1로 초기화 되고 그 이후 O가 연속적으로 나오면 2,3...점을 얻는다
 * */
import java.util.Scanner;

public class quiz {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String str=kb.nextLine();
		int index=1, score=0;
		
		String[] s=str.split("");
		for(int i=0; i<s.length; i++) {
			if(s[i].equals("O")) {
				score+=index;
				index++;
			}
			else {
				index=1;
			}
		}
		System.out.printf("\n%d", score);

	}

}
