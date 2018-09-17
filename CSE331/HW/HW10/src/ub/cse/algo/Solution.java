package ub.cse.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Solution {

    private int origin;
    private ArrayList<HashMap<Integer, Integer>> incoming_edges;
    private ArrayList<HashMap<Integer, Integer>> outgoing_edges;

    public Solution(int origin, ArrayList<HashMap<Integer, Integer>> incoming_edges, ArrayList<HashMap<Integer, Integer>> outgoing_edges){
        this.origin = origin;
        this.incoming_edges = incoming_edges;
        this.outgoing_edges = outgoing_edges;
    }

    public int[] outputShortestDistance(){
        /* Your code goes below */
    	int size = incoming_edges.size();
    	int[] distance = new int[size];
    	for(int i=0; i<size; i++){
    		distance[i] = 100000000;
    	}
    	distance[origin] = 0;
    	for(int i=0; i<size-1; i++){
    		for(int j=0; j<size; j++){
    			for(int k : outgoing_edges.get(j).keySet()){
    				distance[k] = Integer.min(distance[k], distance[j] + outgoing_edges.get(j).get(k));
    			}
    		}
    	}
        return distance;
    }
}
