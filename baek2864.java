import java.util.Scanner;

public class baek2864 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		String[] s1 = kb.next().split("");
		String[] s2 = kb.next().split("");
		String min1 = "", max1 = "", min2 = "", max2 = "";
		int min, max;

		for (int i = 0; i < s1.length; i++) {
			if (s1[i].equals("5")) {
				max1 += "6";
				min1 +="5";
			}
			else if (s1[i].equals("6")) {
				max1+="6";
				min1 += "5";
			}
			else {
				max1 += s1[i];
				min1 += s1[i];
			}
		}

		for (int i = 0; i < s2.length; i++) {
			if (s2[i].equals("5")) {
				max2 += "6";
				min2 +="5";
			}
			else if (s2[i].equals("6")) {
				max2+="6";
				min2 += "5";
			}
			else {
				max2 += s2[i];
				min2 += s2[i];
			}
		}
	
		min = Integer.parseInt(min1) + Integer.parseInt(min2);
		max = Integer.parseInt(max1) + Integer.parseInt(max2);

		System.out.printf("%d %d", min, max);
	}

}
