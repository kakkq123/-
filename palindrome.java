import java.util.Scanner;

public class palindrome {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		String s=kb.nextLine();
		String reverse_s=new StringBuilder(s).reverse().toString();
		
		if(s.equals(reverse_s))
			System.out.println("Yes");
		else
			System.out.println("No");

	}

}
