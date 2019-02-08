
import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
    	int n = in.nextInt();
    	int forbidden = in.nextInt();
      long ans = (long)Math.pow(2, n);
      LinkedList<String> str = new LinkedList<String>();
      String first = in.next();
      ans -= (long)Math.pow(2, n-first.length());
      str.add(first);
      for(int j=1; j<forbidden; j++){  // all other forbidden sequences
        String s = in.next(); 
        for(int k=0; k<str.size(); k++){ // compare each sequences with new one
          String st = str.get(k);
          if(st.length() > s.length()){
            if(s.equals(st.substring(0, s.length()))){
              ans += (long)Math.pow(2, n-st.length());
            }
          }else if(st.length() < s.length()){
            if(st.equals(s.substring(0, st.length()))){
              break;
            }
          }
          if(k == str.size()-1){
            ans -= (long)Math.pow(2, n-s.length());
          }
        }
        str.add(s);
      }
    	System.out.println("Case #" + i + ": " + ans);
    }
  }
}