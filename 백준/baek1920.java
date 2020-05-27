import java.util.Arrays;
import java.util.Scanner;
public class baek1920 {
	public static boolean check(int a, int b, int c , int[] arr) {
		int mid=(a+b)/2;
		if(c==arr[mid])
			return true;
		else if(c>arr[mid]) {
			a=mid+1;
			return check(a,b,c,arr);
		}else {
			b=mid-1;
			return check(a,b,c,arr);
		}
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int[] arr=new int[n];
		
		for(int i=0; i<n; i++)
			arr[i]=kb.nextInt();
		
		Arrays.sort(arr);//Á¤·Ä
		
		
		int m=kb.nextInt();
		int[] c=new int[m];
		for(int i=0; i<m; i++) {
			c[i]=kb.nextInt();
		}
		for(int i=0; i<m; i++) {
			if(check(0,n-1,c[i],arr))
				System.out.println(1);
			else
				System.out.println(0);
		}
	}

}
