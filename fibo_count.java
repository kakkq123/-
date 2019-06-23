import java.util.Scanner;

public class fibo_count {
	static int[] dp0, dp1;

	public static int fibo(int n,int i) {
		if (n == 0) {
			dp0[i]++;
			return 1;
		}
		if (n == 1) {
			dp1[i]++;
			return 1;
		}
		return fibo(n - 1,i) + fibo(n - 2,i);
	}


	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int t = kb.nextInt();
		dp0 = new int[t];
		dp1 = new int[t];
		int test, i;

		for (i = 0; i < t; i++) {
			test = kb.nextInt();
			fibo(test,i);
			
		}

		for (i = 0; i < t; i++) {
			System.out.printf("%d %d\n", dp0[i], dp1[i]);
		}

	}

}
