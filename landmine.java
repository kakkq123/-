import java.util.Scanner;

public class landmine {

	public static int check(String[][] a, int i, int j) {
		int count = 0;
		if (i - 1 >= 0 && j - 1 >= 0 && a[i - 1][j - 1].equals("*"))
			count++;
		if (i - 1 >= 0 && a[i - 1][j].equals("*"))
			count++;
		if (i - 1 >= 0 &&j + 1 < a[0].length && a[i - 1][j+1].equals("*"))
			count++;
		if (j + 1 < a[0].length && a[i][j + 1].equals("*"))
			count++;
		if (i + 1 < a.length && j + 1 < a[0].length && a[i + 1][j + 1].equals("*"))
			count++;
		if (i + 1 < a.length && a[i+1][j].equals("*"))
			count++;
		if (i + 1 < a.length &&j - 1 >= 0 && a[i+1][j - 1].equals("*"))
			count++;
		if (j - 1 >= 0 && a[i][j -1].equals("*"))
			count++;
		
		return count;
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int m = kb.nextInt();
		int n = kb.nextInt();
		int i, j;

		String s;
		String[] sp;
		String[][] r = new String[m][n];

		for (i = 0; i < m; i++) {
			s = kb.next();
			System.out.println();
			sp = s.split("");
			for (j = 0; j < sp.length; j++) {
				r[i][j] = sp[j];
			}

		}

		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
				if (r[i][j].equals("*"))
					System.out.printf("*");
				else
					System.out.printf("%d", check(r, i, j));
			}
			System.out.println();
		}

	}

}
