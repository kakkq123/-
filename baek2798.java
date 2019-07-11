import java.util.Scanner;
public class baek2798 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int m=kb.nextInt();
		
		int[] p =new int[n];
		int sum, res=0;
		
		for (int i = 0; i < n; i++)
			p[i]=kb.nextInt();
		
		for (int i = 0; i < n-2; i++) {
			for (int j = i+1; j < n-1; j++) {
				for (int k = j+1; k < n; k++) {
					sum = p[i] + p[j] + p[k];
					if (sum <= m && res < sum)
						res = sum;
				}
			}
		}
		
		System.out.printf("%d", res);
	}

}
