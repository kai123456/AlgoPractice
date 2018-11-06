package ub.cse.algo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    
    private int _startNode;
    private int _endNode;
    private HashMap<Integer, ArrayList<Integer>> graph;
    public Solution(int startNode, int endNode, HashMap<Integer, ArrayList<Integer>> g){
        _startNode = startNode;
        _endNode = endNode;
        graph = g;
    }
    
    public ArrayList<Integer> outputPath(){
        /*
         * Find the smallest weighted path between _startNode and _endNode
         * The first number of graph's adjacency list is the weight of it's node
         */
        ArrayList<Integer> path = new ArrayList<Integer>();
        int n = graph.size();
        int[] w = new int[n];
        int[] p = new int[n];
        for(int i=0; i<n; i++){
        	w[i] = Integer.MAX_VALUE;
        	p[i] = -1;
        }
    	Queue<Integer> node = new LinkedList<Integer>();
    	node.add(_startNode);
    	w[_startNode] = 0;
    	while(!node.isEmpty()){
    		int current = node.poll();
    		for(int i : graph.get(current)){
    			if(i != graph.get(current).get(0)){
    				int weight = graph.get(current).get(0) + graph.get(i).get(0);
    				if(w[current] + weight < w[i]){
    					w[i] = w[current] + weight;
    					p[i] = current;
    					if(i != _endNode){
    						node.add(i);
    					}	
    				}
    			}
    		}
    	}
    	if(w[_endNode] != Integer.MAX_VALUE){
    		path.add(_endNode);
    		int temp = _endNode;
    		do{
    			path.add(p[temp]);
    			temp = p[temp];
    		}while(temp != _startNode);
    	}
    	Collections.reverse(path);
        return path;
    }
}

