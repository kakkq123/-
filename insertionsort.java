import java.util.Scanner;
public class insertionsort {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("배열 크기 입력:");
		int n=kb.nextInt();
		int[] array=new int[n];
		int val,i,j;
		
		System.out.printf("정수 %d개 입력하세요:",n);
		for(i=0; i<n; i++) {
			array[i]=kb.nextInt();
		}
		
		//insertion_sort
		for(i=1; i<n; i++) {
			j=i-1;
			val=array[i];
			while(j>=0 && val<array[j]) {
				array[j+1]=array[j];
				j--;
			}
			array[j+1]=val;
			
		}
		
		System.out.println("**정렬**");
		for(i=0; i<n; i++) 
			System.out.printf("%d ",array[i]);
	}

}
