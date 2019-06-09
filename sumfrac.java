import java.util.Scanner;

public class sumfrac {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		float res=0;
		for(int i=1; i<=n; i++) {
			
			res+=(float)1/i;
		}
		
		System.out.printf("%.2f", res);
		kb.close();
	}

}
