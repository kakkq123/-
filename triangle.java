import java.util.Scanner;
public class triangle {
	
	public static boolean check(int a, int b, int c) {
		if(a+b<=c || a+c<=b || b+c<=a)
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.printf("삼각형 세 변의 길이의 합: ");
		int n= kb.nextInt();
		int count=0;
		int t1,t2,t3,temp;
		for(int i=1; i<=n-2; i++) {
			t1=i;
			temp=n-i;
			for(int j=1; j<temp/2+1; j++) {
				t2=j;
				
				//중복제거
				if(t1>t2)
					continue;
				t3=temp-j;
				
				if(check(t1,t2,t3)) 
					count++;
				
			}
	
		}

		System.out.printf("만들 수 있는 삼각형 개수: %d", count);
	}

}
