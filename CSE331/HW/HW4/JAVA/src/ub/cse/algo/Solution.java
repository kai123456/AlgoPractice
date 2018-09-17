package ub.cse.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	  private int startNode;
	  private HashMap<Integer, ArrayList<Integer>> graph;
	  public Solution(int node, HashMap<Integer, ArrayList<Integer>> g){
	    startNode = node;
	    graph = g;
	  }

	  public int[] outputDistances(){
		  int n = graph.size();
		  int[] result = new int[n];
		  for(int i=0; i<n; i++){
			  result[i] = -1;
		  }
		  Queue<Integer> node = new LinkedList<Integer>();
		  node.add(startNode);
		  result[startNode] = 0;
		  while(!node.isEmpty()){
			  int current = node.poll();
			  int dist = result[current] + 1;
			  for(int i : graph.get(current)){
				  if(result[i]==-1){
					  result[i] = dist;
					  node.add(i);
				  }
			  }
		  }
		  return result;
	  }
}
