package ub.cse.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

public class Solution {

    private HashMap<Integer, ArrayList<Integer>> graph;

    public Solution(HashMap<Integer, ArrayList<Integer>> graph) {
        this.graph = graph;
    }

    public ArrayList<Integer> findCycle() {
        ArrayList<Integer> cycle = new ArrayList<Integer>();
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int[] check  = new int[graph.size()];
        for(int i=0; i<graph.size(); i++){
            check[i] = -1;
        }
        Stack<Integer> search = new Stack<Integer>();
        search.push(0);
        check[0] = Integer.MAX_VALUE;
        boolean yes = false;
        int findIt = 0;
        while(!search.empty()){
            int top = search.pop();
            cycle.add(top);
            for(int i : graph.get(top)){
                if(i == check[top]){
                    continue;
                }
                if(check[i]==-1){
                    search.push(i);
                    check[i] = top;
                }else{
                    if(cycle.contains(check[i])){
                        yes = true;
                        findIt = i;
                        check[check[i]] = i;
                        check[i] = top;
                           break;
                       }else if(check[i]==check[top]){
                           yes = true;
                           findIt = i;
                           check[check[i]] = i;
                           check[i] = top;
                           break;
                       }
                   }
            }
            if(yes == true){
                int temp = findIt;
                do{
                    answer.add(check[findIt]);
                    findIt = check[findIt];
                }while(findIt != temp);
                break;
            }
        }
        return answer;
    }
}
