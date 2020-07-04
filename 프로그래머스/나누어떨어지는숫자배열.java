import java.util.TreeSet;
class Solution {
  public int[] solution(int[] arr, int divisor) {
      int[] answer;
      TreeSet<Integer> num = new TreeSet<Integer>();
      for(int i=0; i<arr.length; i++){
          if(arr[i] % divisor == 0)
              num.add(arr[i]);
      }
      if(num.size() == 0){
          answer = new int[1];
          answer[0] = -1;
      }else{
          answer = new int[num.size()];
          int i=0;
          for(Integer number : num)
              answer[i++] = number;
      }
      return answer;
  }
}
