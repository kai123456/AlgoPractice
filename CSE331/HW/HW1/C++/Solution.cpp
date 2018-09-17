#include <iostream>
#include <stdio.h>
#include <string.h>
#include <string>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;

class Solution {
public:
	int n;
	map<int, vector<int>> men;
	map<int, vector<int>> women;
	vector<vector<pair<int, int>>> stableMatchings;
	Solution(int, map<int, vector<int>>, map<int, vector<int>>);
	vector<vector<pair<int, int>>> outputStableMatchings();
	bool is_stable(vector<pair<int, int>>);
};

/**
 * For use in CSE 331
 * Student Solution Stable Marriage Problem
 * Do not change the names of the classes or the functions. You can add other functions etc.
 */

Solution::Solution(int _n, map<int, vector<int>> _men, map<int, vector<int>> _women) {
/* Initialization: Do NOT change */
    n = _n;
    men = _men;
    women = _women;
}

vector<vector<pair<int,int>>> Solution::outputStableMatchings() {

/*This is the function you will need to implement. */
// Takes the preferences in the  map<int, vector<int>> men and women
// and outputs all the stable matchings as vector<vector<pair<int,int>>>

    printf("Implement me!\n");
    return {};
}

bool Solution::is_stable(vector<pair<int,int>> cur_match) {
	
/* This function could be useful to implement*/
    return false;
}
