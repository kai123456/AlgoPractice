#include <stdio.h>
#include <stdlib.h>
#include <string>
#include <vector>
#include <unordered_map>
#include <fstream>
#include <iostream>

using namespace std;
class Solution {
    private:
   	vector<int> m_outputDistances;
    unordered_map<int, vector<int> > graph;
    int start_node;

    public:
    Solution(int node, unordered_map<int, vector<int> > in_graph) {
        start_node = node;
        graph = in_graph;
    }

    vector<int> outputDistances() {
        queue<int> q;
        q.push_back(start_node);
        m_outputDistances.push(start_node, 0);
        while(!q.empty()){
            int current = q.pop();
            int dist = m_outputDistances.at(current) + 1;

        }

        return m_outputDistances;
    }
};