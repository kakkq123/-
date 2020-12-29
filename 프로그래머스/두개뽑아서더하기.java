import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int i = 0; i < numbers.length - 1; i++)
            for(int j = i + 1; j < numbers.length; j++)
                set.add(numbers[i]+numbers[j]);
        int[] answer = new int[set.size()];
        
        int i = 0;
        for(Integer n : set){
            answer[i++] = n;
        }
        return answer;
    }
}
