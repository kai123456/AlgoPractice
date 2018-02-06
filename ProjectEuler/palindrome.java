public class palindrome{

	public static void main(String[] args){
		
		int standBy = 0;
		int answer = 0;
		for(int i=100; i<1000; i++){
			for(int j=100; j<1000; j++){
				standBy = i * j;
				String check = Integer.toString(standBy);
				if(isPalindrome(check)){
					if(answer < standBy){
						answer = standBy;
					}
				}
			}
		}
		System.out.println(answer);
	}
	public static boolean isPalindrome(String s){
		String t = "";
		for(int i=s.length()-1; i>=0; i--){
			t += s.charAt(i);
		}
		if(s.equals(t)){
			return true;
		}
		return false;
	}
}