#include "HW4Utility.h"
#include "Solution.cpp"
#include "Graph.h"
#include <fstream>

class Driver;

int main(int argc, char** argv) {
    if(argc != 2) {
        printf("Please provide the input filename as the argument.\n");
        return 0;
    }
    HW4Utility Utility;
    Graph input = Utility.readFile(argv[1]);
    
    Solution s = Solution(input.startNode, input.graph);
    vector<int> studentSolution = s.outputDistances();
    cout << "Your solution " << endl;
    cout << "==========================================" << endl;
    cout << "[";
	for (int i = 0; i < studentSolution.size(); i++)
	{
        if(i == studentSolution.size()-1){
            cout << studentSolution[i];
        }
        else{
            cout << studentSolution[i] << ", ";
        }
        
	}  
    cout << "]" << endl;
    return 0;
}
