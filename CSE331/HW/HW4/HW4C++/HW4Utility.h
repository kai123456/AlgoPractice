#ifndef HW4UTILITY_H_
#define HW4UTILITY_H_

#include "Utility.h"
#include "Graph.h"
#include <iostream>
#include <fstream>
#include <sstream>

using namespace std;

class HW4Utility: public Utility<Graph> {
public:
    HW4Utility(){};

    Graph readFile(std::string filename){
        
        fstream input(filename, ios_base::in);
        std::string start;
        int start_node;
        std::getline(input, start);
        start_node = atoi(start.c_str());
        std::string line;
        
        std::unordered_map<int, vector<int> > graph;
        int nodeCounter = 0;
        while(std::getline(input, line)){
            if(line != ""){
                std::istringstream iss(line);
                std::vector<int> neighbors;
                int node;
                while(iss >> node){
                    neighbors.push_back(node);
                }
                graph[nodeCounter] = neighbors;
            }
            else{
                std::vector<int> neighbors;
                graph[nodeCounter] = neighbors;
            }
            nodeCounter++;
        }
        input.close();
        Graph in_graph(start_node, graph);
        return in_graph;
    }
};
#endif
