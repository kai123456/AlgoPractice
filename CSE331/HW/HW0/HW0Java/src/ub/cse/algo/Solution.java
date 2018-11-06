package ub.cse.algo;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<String> _inputList;
    public Solution(List<String> list){
        _inputList = list;
    }

    public List<String> outputSortedList(String a, String b, int n){
        List<String> l = new ArrayList<String>();
        if(n>0){
        	for(int i=0; i<n; i++){
        		if(_inputList.get(i).equals(a) && a!=null){ 
        			l.add(0,a);
        		}else if(_inputList.get(i).equals(b) && b!=null){
        			l.add(b);
        		}
        	 }
        }
        return l;
    }

    // List outputList = new ArrayList();
        
    // int countB = Collections.frequency(_inputList, B);
    // int countA = n - countB;
    // List listOfB = Collections.nCopies(countB, B);
    // List listOfA = Collections.nCopies(countA, A);
        
    // outputList.addAll(listOfA);
    // outputList.addAll(listOfB);
    // return outputList;
}
