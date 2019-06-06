import java.util.Scanner;
public class baej2675 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int t = kb.nextInt();
		int r,i,j,k;
		String s;
		String[] str= new String[t];
		char[] c;
		
		for(i=0; i<t; i++) {
			r=kb.nextInt();
			s=kb.next();
			c=s.toCharArray();
			str[i]="";
			for(j=0; j<c.length; j++) {
				for(k=0; k<r; k++)
					str[i]+=c[j];
			}
	
		}
		for(i=0; i<t; i++)
			System.out.printf("%s\n",str[i]);

	}

}
