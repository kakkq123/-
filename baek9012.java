import java.util.Scanner;

public class baek9012{
	static char[] stack = new char[50];
	static int top;
	
	public static boolean checkVPS(String s) {
		char[] carray = s.toCharArray();
		top = -1;
		for (int i = 0; i < carray.length; i++) {
			if (carray[i] == '(') {
				if (!insertBracket(carray[i]))
					return false;
			}

			else if (carray[i] == ')') {
				if (!deleteBracket())
					return false;
			}
		}

		if (top == -1)
			return true;

		return false;
	}

	public static boolean insertBracket(char c) {
		if (top >= 10000) {
			return false;
		}
		top++;
		stack[top] = c;
		return true;
	}

	public static boolean deleteBracket() {
		if (top < 0) {
			return false;
		}
		top--;
		return true;
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int t = kb.nextInt();
		kb.nextLine();
		String s;
		
		for (int i = 0; i < t; i++) {
			s = kb.nextLine();
			if (checkVPS(s))
				System.out.println("Yes");
			else
				System.out.println("NO");
		}

	}

}