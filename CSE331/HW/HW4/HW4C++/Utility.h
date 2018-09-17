#ifndef UTILITY_H
#define UTILITY_H

#include <string>

template<class C>
class Utility {
public:
  virtual C readFile(std::string filename) = 0;
  
};

#endif