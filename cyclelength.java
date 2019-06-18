import java.util.Scanner;
public class cyclelength {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int length=1;
		
		while(n!=1) {
			if(n%2==0)
				n=n/2;
			else
				n=n*3+1;
			length++;
			
		}
		System.out.printf("%d", length);
	}

}
