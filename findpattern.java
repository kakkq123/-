import java.util.Scanner;
public class findpattern {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("패턴 입력:");
		String pattern=kb.next();
		String[] p=pattern.split("");
		int pattern_len=pattern.length();
		
		System.out.println("텍스트 입력:");
		String text=kb.next();
		String[] t=text.split("");
		int text_len=text.length();
		
		int last_index=text_len-pattern_len+1;
		int j;
		
		for(int i=0; i<last_index;i++) {
			j=0;
			while(p[j].equals(t[i+j])) {
				j++;
				if(j>=pattern_len) {
					System.out.printf("%d index부터 패턴이 맞습니다.",i);
					System.exit(0);
				}	
			}

			
		}
		
		System.out.println("패턴과 맞는 문자열이 없습니다.");
	}

}
