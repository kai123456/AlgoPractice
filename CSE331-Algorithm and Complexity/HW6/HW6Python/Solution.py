class Solution:

    def __init__(self, listOfRallies):
        self.rallies = listOfRallies

    def getSchedule(self):
        ################# YOUR CODE GOES HERE ##################
        schedule = []
        position = {}
        # print self.rallies
        for i in range(len(self.rallies)):
            position[self.rallies[i]] = i
        self.rallies = sorted(
            self.rallies, key=lambda tup: tup[1])
        start = 0
        for k in range(len(self.rallies)):
            schedule.append((position[self.rallies[k]], start))
            start = start + self.rallies[k][0]
            if start > self.rallies[k][1]:
                return []
        # print position
        # self.rallies
        return schedule
