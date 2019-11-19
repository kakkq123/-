class Solution {
    
    public boolean solution(String s) {
        boolean answer = true;
        if(!(s.length() == 4 || s.length() == 6) )
            return answer = false;
        
        char[] c = new char[s.length()];
        for(int i=0; i<c.length; i++)
            c[i] = s.charAt(i);
        
        for(int i=0 ; i< c.length; i++){
            int ascii = (int) c[i];
			if (ascii < 48 || ascii > 57) {
                answer = false;
                break;
            }
        }
         
        return answer;
    }
        
}
