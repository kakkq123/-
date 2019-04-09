import java.util.*;

public class pro9095 {

 

 static int[] sol=new int[1000];

 

 public static int ways(int n) {

  //1

  if(n==1)

   return 1;

  //1+1,2

  if(n==2)

   return 2;

  //1+1+1,1+2,2+1,3

  if(n==3)

   return 4;

  //이미 계산했으면 저장된 값을 return

  if(sol[n]!=0)

   return sol[n];

  

  return sol[n]=ways(n-1)+ways(n-2)+ways(n-3);

  

 }



 public static void main(String[] args) {



  Scanner kb =new Scanner(System.in);

  

  int n=kb.nextInt();  //몇개 테스트할지 n입력

  

  int[] caseNum =new int[n];

  //n개의 값을 받아 배열에 저장

  for(int i=0; i<n; i++) {

   caseNum[i]=kb.nextInt();

  }

  

  //차레대로 1,2,3 덧셈으로 표현할 수 있는 총 개수를 출력한다.

  for(int i=0; i<n; i++) {

   System.out.printf("%d\n", ways(caseNum[i]));

  }



 }



}

