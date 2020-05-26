
/*
 * 다장조 입력받아 ascending, descending, mixed를 판별하시오
 * */

import java.util.Scanner;

public class ascdesmix {
	public static int conversion(String s) {
		int res = 0;
		switch (s) {
		case "c":
			res = 1;
			break;
		case "d":
			res = 2;
			break;
		case "e":
			res = 3;
			break;
		case "f":
			res = 4;
			break;
		case "g":
			res = 5;
			break;
		case "a":
			res = 6;
			break;
		case "b":
			res = 7;
			break;
		case "C":
			res = 8;
			break;

		}

		return res;
		
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String str = kb.nextLine();
		String[] str2 = str.split("");
		int[] r = new int[str2.length];
		
		int i;
		int check; // 0: ascending, 1: descending, 2: mixed

		r[0] = conversion(str2[0]);
		
		r[1] = conversion(str2[1]);
		
		if (r[0] > r[1])
			check = 1;
		else
			check = 0;

		for (i = 2; i < str2.length; i++) {
			r[i] = conversion(str2[i]);
			if ((r[i] > r[i - 1] && check == 1) || (r[i] < r[i - 1] && check == 0)) {
				check = 2;
				break;
			}
		}

		switch (check) {
		case 0:
			System.out.println("ascending");
			break;
		case 1:
			System.out.println("descending");
			break;
		default:
			System.out.println("mixed");
			break;

		}

	}

}
