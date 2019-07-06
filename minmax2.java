import java.util.Scanner;

public class minmax2 {

 public static void main(String[] args) {
  Scanner kb = new Scanner(System.in);
  int number , min, max, i;
  min=max=kb.nextInt(); //우선 처음 입력 받은 정수를 min과 max변수에 저장
  for (i = 1; i < 10; i++) {
   number=kb.nextInt(); //숫자를 입력 
   if(max<number) //입력 받은 숫자와 현재 max값을 비교
    max=number;
   if(min>number) //입력 받은 숫자와 현재 min값을 비교
    min=number;
  }
  //최종 결과를 출력
  System.out.printf("%d %d", max, min);
 }

}
