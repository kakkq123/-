import java.util.Scanner;
public class baek10828 {

	static int index=-1;
	static int[] stack=new int[10000];
	static String ans="";
	public static void push(int n) {
		index++;
		stack[index]=n;
	}
	
	public static int pop() {
		if(index<0) {
			ans+="-1\n";
			return 0;
		}
		ans+=stack[index]+"\n";
		index--;
		return 1;
	}
	
	public static void isEmpty() {
		if(index>=0)
			ans+="0\n";
		else
			ans+="1\n";

	}
	
	public static void top() {
		if(index<0)
			ans+="-1\n";
		else
			ans+=stack[index]+"\n";

	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		String[] s;

		
		for(int i=0; i<=n; i++) {
			s=kb.nextLine().split(" ");
			if(s[0].equals("push"))
				push(Integer.parseInt(s[1]));
			else if(s[0].equals("top"))
				top();
			else if(s[0].equals("size"))
				ans+=index+1+"\n";
			else if(s[0].equals("empty"))
				isEmpty();
			else if(s[0].equals("pop"))
				pop();

		}
		System.out.printf("%s", ans);
	}

}
