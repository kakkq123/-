import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n, k, min,temp;
		int[] a;
		n = kb.nextInt();
		a = new int[n];
		k=kb.nextInt();

		for (int i = 0; i < n; i++)
			a[i] = kb.nextInt();

		for (int i = 0; i < n - 1; i++) {
			min = i;
			for (int j = i + 1; j < n; j++) {
				if(a[j]<a[min])
					min=j;
			}
			temp=a[i];
			a[i]=a[min];
			a[min]=temp;

		}
		
		System.out.printf("%d",a[k-1]);
		
	}

}
