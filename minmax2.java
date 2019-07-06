import java.util.Scanner;

public class minmax2 {

 public static void main(String[] args) {
  Scanner kb = new Scanner(System.in);
  int number , min, max, i;
  min=max=kb.nextInt();
  for (i = 1; i < 10; i++) {
   number=kb.nextInt();
   if(max<number)
    max=number;
   if(min>number)
    min=number;
  }
  System.out.printf("%d %d", max, min);
 }

}
