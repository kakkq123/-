
import java.util.*;
public class sum100 {
	public static final int SIZE =9;

	public static void main(String[] args) {
		Scanner kb= new Scanner(System.in);
		int[] array =new int[SIZE];
		int sum=0;
	
		System.out.println("1이상 100미만인 9개 숫자 입력: ");
		for(int i=0; i<SIZE; i++) {
			array[i]=kb.nextInt();
			sum+=array[i];
		}
		
		int comp = sum-100;

		for(int i=0; i<SIZE-1; i++) {
			for(int j=i+1; j<SIZE; j++) {
				if((array[i]+array[j])==comp) {
					array[i]=-1;
					array[j]=-1;
					break;
				}
					
			}
		}
		

		System.out.println("\n***합이 100이 되는 7개의 숫자 출력***");
		for(int i=0; i<SIZE; i++)
			if(array[i]!=-1)
				System.out.printf("%d ", array[i]);

	}

}
