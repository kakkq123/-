import java.util.Scanner;

public class maxmin {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int[] number = new int[10];
		int min, max, i;

		for (i = 0; i < 10; i++) {
			number[i] = kb.nextInt();
		}
		
		min = max = number[0];
		
		for (i = 1; i < 10; i++) {
			if(max<number[i])
				max=number[i];
			if(min>number[i])
				min=number[i];
		}
		System.out.printf("%d %d", max, min);
	}

}
