package ub.cse.algo;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * For use in CSE 331 HW1.
 * This is the class you will be editing and turning in. It will be timed against our implementation
 * NOTE that if you declare this file to be in a package, it will not compile in Autolab
 */

public class Solution {
	private int _nHospital;
	private int _nStudent;

    // The following represent the preference list of hospitals and students.
    // The KEY represents the integer representation of a given hospital or student.
    // The VALUE is a list, from most preferred to least.
    // For hospital, first element of the list is number of available slots
	private HashMap<Integer, ArrayList<Integer>> _hospitalList;
	private HashMap<Integer, ArrayList<Integer>> _studentList;
    
    
    /**
     * The constructor simply sets up the necessary data structures.
     * The grader for the homework will first call this class and pass the necessary variables.
     * There is no need to edit this constructor.
     * @param m Number of hospitals
     * @param n Number of students
     * @param A map linking each hospital with its preference list
     * @param A map linking each student with their preference list
     * @return
     */
	public Solution(int m, int n, HashMap<Integer, ArrayList<Integer>> hospitalList, HashMap<Integer, ArrayList<Integer>> studentList) {
		_nHospital = m;
		_nStudent = n;
		_hospitalList = hospitalList;
		_studentList = studentList;
	}
    
    /**
     * This method must be filled in by you. You may add other methods and subclasses as you see fit,
     * but they must remain within the HW1_Student_Solution class.
     * @return Your stable matches
     */
	public ArrayList<Match> getMatches() {
		ArrayList<Match> mt = new ArrayList<Match>();
        int[] sList = new int[_nStudent]; 
        for(int i=0; i<_nStudent; i++){
        	sList[i] = 0;
        }  
        HashMap<Integer, ArrayList<Integer>> hList = forSlot();  //HashMap of h's slot and its value(0 for now), Integer=numOfSlot, ArrayList=to save s for match
        int studentPrefList = 0; //int availableSlot = 0;
        while(studentPrefList < _nHospital /*|| availableSlot < totalSlots(_nHospital, _hospitalList)*/){  //while there is hospital student haven't check
            for(int i=0; i<_nStudent; i++){  //loop through all the students
                if(sList[i] == 0){  //if current student is free
                    int currentS = i+1;  //current student
                    int sCurrentPrefh = _studentList.get(currentS).get(studentPrefList);  //current student 1st pref hospital
                    if(_hospitalList.get(sCurrentPrefh).get(0) > hList.get(sCurrentPrefh).size()){  //if there is slot available
                        sList[i] = sCurrentPrefh;
                        hList.get(sCurrentPrefh).add(currentS);
                        //availableSlot++;
                    }else{
                    	for(int j=0; j<hList.get(sCurrentPrefh).size(); j++){
                    		if(sList[i] == 0){
                    			int hCurrentMatch = hList.get(sCurrentPrefh).get(j);
                                if(_hospitalList.get(sCurrentPrefh).indexOf(hCurrentMatch) > _hospitalList.get(sCurrentPrefh).indexOf(currentS)){
                                    break;
                                }else{
                                    sList[i] = sCurrentPrefh;
                                    sList[hCurrentMatch-1] = 0;
                                    hList.get(sCurrentPrefh).remove(j);
                                    hList.get(sCurrentPrefh).add(currentS); 
                                }
                    		}
                    	}
//                    	int hCurrentMatch = hList.get(sCurrentPrefh).get(0);
//                        if(_hospitalList.get(sCurrentPrefh).indexOf(hCurrentMatch) > _hospitalList.get(sCurrentPrefh).indexOf(currentS)){
//                            sList[i] = 0;
//                        }else{
//                            sList[i] = sCurrentPrefh;
//                            sList[hCurrentMatch-1] = 0;
//                            hList.get(sCurrentPrefh).remove(0);
//                            hList.get(sCurrentPrefh).add(currentS); 
//                        }
                    }
                }
            }
            studentPrefList++;
        }
        
        for(int s=1; s<=_nHospital; s++){
        	for(int h=0; h<hList.get(s).size(); h++){
        		mt.add(new Match(s, hList.get(s).get(h)));
        	}
        } 
        System.out.println(mt.size());
        		
        // Returns an empty ArrayList for now
        return mt;
	}
	
	public HashMap<Integer, ArrayList<Integer>> forSlot(){
		HashMap<Integer, ArrayList<Integer>> forSlot = new HashMap<Integer, ArrayList<Integer>>();
		for(int i=1; i<=_nHospital; i++){
			forSlot.put(i, new ArrayList<Integer>());
		}
		return forSlot;
	}
	public int totalSlots(int nHospital, HashMap<Integer, ArrayList<Integer>> hospitalList){
		int n = 0;
		for(int i=1; i<=nHospital; i++){
			n += hospitalList.get(i).get(0);
		}
		return n;
	}
}