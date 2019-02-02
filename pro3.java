import java.util.Scanner;

public class pro3 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int N, F, front, result, k, str_length;
		String back_s, front_s, str;

		do {
			System.out.println("N : 100보다 크거나 같고, 2,000,000,000보다 작거나 같은 자연수");
			N = kb.nextInt();
		} while (N < 100 || N > 2000000000);

		do {
			System.out.println("F : 100보다 작거나 같은 자연수");
			F = kb.nextInt();
		} while (F > 100 || F <= 0);

		System.out.printf("N : %d\n", N);
		System.out.printf("F : %d\n", F);

		front = N / 100;
		front_s = Integer.toString(front);
		back_s = "00";
		str = front_s + back_s;
		result = Integer.parseInt(str);

		k = result % F;
		if (k != 0)
			result += (F - k);
		
		str=Integer.toString(result);
		str_length=str.length();
		System.out.println(str.substring(str_length-2));
		
	}

}
