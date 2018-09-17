class Solution:

    def __init__(self, ip):
        """
            The constructor exists only to initialize variables. You do not need to change it.
            :param ip: input list that consists of n element from {A,B}
        """
        self.inputList = ip

    def outputSortedList(self, A, B, n):
        result = []
        count = 0
        while count < n:
            for i in self.inputList:
                if i == A:
                    result.append(i)
                elif self.inputList[i] == B:
                    result.append(i)
            count = count + 1

        return result
