import java.util.*;

public class bubbleSort {

	public static void main(String[] args) {
		int [] array = {8,5,6,2,4};
		int i,j,temp;
		int n=array.length; 
		//sort
		for(i=n-1;i>0;i--) 
			for(j=0;j<i;j++) 
				if(array[j]>array[j+1]) {
					temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
			
				}
			
		
		System.out.println("****result****");
		for(i=0; i<n; i++)
			System.out.printf("%d ", array[i]);

	}

}
