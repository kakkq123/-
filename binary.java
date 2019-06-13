import java.util.Scanner;
public class binary {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int q=0,r;
		int t=n;
		StringBuffer s= new StringBuffer();
		while(q!=1) {
			q=t/2;
			r=t%2;
			t=q;
			s.append(r);
		}
		s.append(q);
		
		System.out.println(s.reverse());
	}

}
