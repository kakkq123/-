import java.util.Scanner;

public class 백준pro7 {

	public static int bridgeCase(int n, int m) {
		int result=1;
		
		for(int i=0,j=1;i<n;i++,j++) {
			result*=m;
			m--;
			result/=j;
		}
		
		return result;

	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int T, N, M;
		
		T = kb.nextInt();
		
		int[] res=new int[T];

		for (int i = 0; i < T; i++) {
			N = kb.nextInt();
			M = kb.nextInt();

			res[i] = bridgeCase(N, M);
		}

		for(int i=0;i<T;i++)
			System.out.printf("%d\n", res[i]);
	}

}
