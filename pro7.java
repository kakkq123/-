import java.util.Scanner;

public class 백준1357 {

	static public int Rev(int x) {
		int value;
		String str;
		str=Integer.toString(x);
	
		str=(new StringBuffer(str)).reverse().toString();
		value=Integer.parseInt(str);
		
		return value;
		
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int X,Y;
		int res;
		
		X=kb.nextInt();
		Y=kb.nextInt();
		
		res=Rev(Rev(X)+Rev(Y));
		
		System.out.printf("%d",res);
	}

}
