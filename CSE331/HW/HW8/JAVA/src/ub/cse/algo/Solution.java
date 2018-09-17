package ub.cse.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * For use in CSE 331
 */
public class Solution {

    private ArrayList<ArrayList<Integer>> adj_matrix;

    public Solution(ArrayList<ArrayList<Integer>> adj_matrix) {
        this.adj_matrix = adj_matrix;
    }


    public int[] outputEdges() {
      /*
       * Output the node ids of the smallest weighted path.
       */
    	int n = adj_matrix.size();
        int[] parent = new int[n];
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> q = new PriorityQueue<int[]>(n, new Comparator<int[]>(){

            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                return Integer.compare(adj_matrix.get(o1[0]).get(o1[1]), adj_matrix.get(o2[0]).get(o2[1]));
            }
            
        });
        int baba = -1;
        int min = 0;
        parent[min] = baba;
        int v = 0;
        while(v!=n){
            visited[min] = true;
            for(int i=0; i<n; i++){
                if(adj_matrix.get(min).get(i)!=-1 && visited[i]==false){
                    q.add(new int[]{min,i});
                }
            }
            int[] pair = q.poll();
            boolean check = visited[pair[1]];
            while(!q.isEmpty() && check == true){
                pair = q.poll();
                check = visited[pair[1]];
            }
            baba = pair[0];
            min = pair[1]; 
            parent[min] = baba;
            v++;
        }
        return parent;
    }
}
