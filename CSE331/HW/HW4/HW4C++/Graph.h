#ifndef GRAPH_H
#define GRAPH_H

#include <vector>
#include <unordered_map>

using namespace std;

class Graph {
public:
    int startNode;
    unordered_map<int, vector<int>> graph;
    Graph(int graphStartNode, unordered_map<int, vector<int>> inputGraph) {
        startNode = graphStartNode;
        graph = inputGraph;
    }
};
#endif