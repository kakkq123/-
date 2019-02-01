import java.util.Scanner;

public class pro2 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int M, N, k, min = -1;
		boolean action = true;
		int[] perfectSquare = new int[100];

		for (int i = 0; i < 100; i++)
			perfectSquare[i] = (i + 1) * (i + 1);

		int sum = 0;

		do {
			System.out.println("M : 10000이하의 자연수 값을 입력해주세요");
			M = kb.nextInt();
		} while (M > 10000 || M < 0);

		do {
			System.out.println("N : 10000이하의 자연수 값을 입력해주세요");
			N = kb.nextInt();
		} while (N > 10000 || N < M);

		for (k = 0; k < 100; k++) {
			if (M <= perfectSquare[k]) {
				min = perfectSquare[k];
				sum = min;
				break;
			}
		}

		for (int i = k + 1; i < 100; i++) {
			if (perfectSquare[k + 1] > N) {
				min = -1;
				action = false;
				break;
			} else if (perfectSquare[i] <= N)
				sum += perfectSquare[i];
			else
				break;
		}

		if (action)
			System.out.printf("%d\n%d", sum, min);
		else
			System.out.printf("%d", min);
	}

}
