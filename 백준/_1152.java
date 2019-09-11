import java.util.Scanner;

public class _1152 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String str = kb.nextLine();
		String[] s = str.split("");

		int i, count = 0;

		for (i = 0; i < s.length; i++) {
			if (s[i].equals(" ")) {
				if (i == 0)
					continue;
				count++;
			}
		}

		if(s[s.length-1].equals(" "))
			count--;
		count++;
		System.out.printf("%d", count);

	}

}
