class Solution {
  public String solution(String s) {
      String answer = "";
      String[] str = s.split("");
      int n = str.length;
      if(n % 2 == 0){
          answer =str[n / 2 -1]+str[n / 2];
      }else{
           answer =str[n / 2];
      }
      return answer;
  }
}
