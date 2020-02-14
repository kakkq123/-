import java.util.Scanner;

public class ¹®ÀÚ¿­Æø¹ß_9935 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String a = kb.next();
		String b = kb.next();
		char[] k=new char[b.length()], ans = new char[a.length()];
		for (int i = 0; i < b.length(); i++)
			k[i] = b.charAt(i);
		int len = b.length(), index=0;
		for (int i = 0; i < a.length(); i++) {
			ans[index++] = a.charAt(i);
			if (ans[index - 1] == k[len - 1]) {
				if (index < len)
					continue;
				boolean c = false;
				for (int j = 0; j < len; j++) {
					if (ans[index - 1 - j] != k[len - 1 - j]) {
						c = true;
						break;
					}
				}
				if (!c)
					index -= len;
			}
		}
		if (index == 0)
			System.out.println("FRULA");
		else {
			for (int i = 0; i <index; i++)
				System.out.print(ans[i]);
		}
		kb.close();
	}

}
