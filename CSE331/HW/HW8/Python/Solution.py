import sys


class Solution:

    def __init__(self, graph):
        self.graph = graph

    def minKey(self, key, mstSet):
        min = sys.maxint
        for v in range(len(self.graph)):
            if key[v] < min and mstSet[v] == False:
                min_index = v
        return min_index

    def output_edges(self):
        ########### Output the node ids of the smallest weighted path #########
        v = len(self.graph)
        key = [sys.maxint] * v
        parent = [None] * v
        key[0] = 0
        mstSet = [False] * v
        parent[0] = -1

        for count in range(v):
            u =
        return []
