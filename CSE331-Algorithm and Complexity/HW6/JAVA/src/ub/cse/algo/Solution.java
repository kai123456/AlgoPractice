package ub.cse.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    
    private int _n_rallies;
    private ArrayList<int[]> _rallies;
    
    public Solution (int n_rallies, ArrayList<int[]> rallies){
        _n_rallies = n_rallies;
        _rallies = rallies;
    }
    
    /**
     * You should fill this in on your own. Rallies is list of tuples, in the form (rally duration, rally deadline).
     * Your output should also be a list of tuples, of the form (rally id, start time of rally). If no possible
     * schedule exists, you should return an empty list.
     * @return
     */
    public ArrayList<int[]> getSchedule(){
        ArrayList<int[]> schedule = new ArrayList<int[]>();
        ArrayList<int[]> sortList = new ArrayList<int[]>();
        sortList.addAll(_rallies);
        Collections.sort(sortList, new Comparator<int[]>() {
        	@Override
            public int compare(int[] a, int[] b) {
            	return Integer.compare(a[a.length-1], b[b.length-1]);
            }
        });
        int start = 0;
        for(int[] j : sortList){
        	schedule.add(new int[]{_rallies.indexOf(j),start});
        	start = start + j[0];
        	if(start > j[1]){
        		return new ArrayList<int[]>();
        	}
        }
        System.out.println("IMPLEMENT ME!");
        return schedule;
    }
}
