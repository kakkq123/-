import java.util.Scanner;
public class brackets {
	public static char[] dp= new char[10000];
	public static int top=0;
	public static boolean isError=false;
	
	public static void insertBracket(char c) {
		if(top==10000)
			isError=true;
		dp[top]=c;
		top++;
	}
	
	public static void deleteBracket(char c) {
		if(top==0)
			isError=true;
		top--;
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String s=kb.nextLine();
		char[] carray=s.toCharArray();
		
		for(int i=0; i<carray.length; i++) {
			if(isError)
				break;
			if(carray[i]=='(')
				insertBracket(carray[i]);
			else if(carray[i]==')')
				deleteBracket(carray[i]);				
		}
		if(top==0 && isError==false)
			System.out.println("T");
		else
			System.out.println("F");
		

	}

}
