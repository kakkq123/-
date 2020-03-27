import java.util.LinkedList;
import java.util.Iterator;
public class Solution {
	public int[] solution(int []arr) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(arr[0]);
        int value=arr[0];
        for(int i=1 ; i< arr.length; i++){
            if(value == arr[i])
                continue;
            value=arr[i];
            list.add(value);
        }
        int[] answer= new int[list.size()];
        int i=0;
        for(Iterator<Integer> iter=list.iterator(); iter.hasNext();){
            answer[i++]=iter.next();
        }
        return answer;
	}
}
