import java.util.Scanner;
import java.util.*;

public class pro6 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int N, i = 0, j, max, temp, length;
		String str;
		int[] array;

		N = kb.nextInt();
		
		str=Integer.toString(N);
		length=str.length();
		array = new int[length];

		String[] strArray = str.split("");

		for (i = 0; i < length; i++)
			array[i] = Integer.parseInt(strArray[i]);

		for (i = 0; i < length - 1; i++) {
			max = i;
			for (j = i + 1; j < length; j++)
				if (array[j] > array[max])
					max = j;

			temp = array[i];
			array[i] = array[max];
			array[max] = temp;
		}
		
		for (i = 0; i < length; i++) 
			System.out.printf("%d", array[i]);
		

	}

}
