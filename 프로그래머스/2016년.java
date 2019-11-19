class Solution {
  public String solution(int a, int b) {
      String answer = "";
      int[] month={0, 31, 29, 31, 30, 31, 30,31,31,30,31,30,31};
      int[] days={0,1,2,3,4,5,6};
      int r = b - 1;
      for(int i=1; i <= a-1; i++)
          r += month[i];
      r = r % 7;
      switch(r){
          case 0 :
              answer = "FRI";
              break;
          case 1 :
              answer = "SAT";
              break;
          case 2 :
              answer = "SUN";
              break;
          case 3 :
              answer = "MON";
              break;
          case 4 :
              answer = "TUE";
              break;
          case 5 :
              answer = "WED";
              break;
          case 6 :
              answer = "THU";
              break;     
      }
      
      return answer;
  }
}
