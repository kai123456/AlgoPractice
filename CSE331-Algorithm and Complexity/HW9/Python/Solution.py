from math import sqrt


class Solution:

    def __init__(self, points):
        self.points = points

    def findClosestPair(self):
        self.points.sort(cmp=lambda x, y: cmp(x[0], y[0]))
        return self.get_distance(self.nearest_dot(self.points))

    def nearest_dot(self, s):
        len = s.__len__()
        left = s[0:len / 2]
        right = s[len / 2:]
        mid_x = (left[-1][0] + right[0][0]) / 2.0

        if left.__len__() > 2:
            lmin = self.nearest_dot(left)
        else:
            lmin = left
        if right.__len__() > 2:
            rmin = self.nearest_dot(right)
        else:
            rmin = right

        if lmin.__len__() > 1:
            dis_l = self.get_distance(lmin)
        else:
            dis_l = float("inf")
        if rmin.__len__() > 1:
            dis_2 = self.get_distance(rmin)
        else:
            dis_2 = float("inf")

        d = min(dis_l, dis_2)

        mid_min = []
        for i in left:
            if mid_x - i[0] <= d:
                for j in right:
                    if abs(i[0] - j[0]) <= d and abs(i[1] - j[1]) <= d:
                        if self.get_distance((i, j)) <= d:
                            mid_min.append([i, j])
        if mid_min:
            dic = []
            for i in mid_min:
                dic.append({self.get_distance(i): i})
            dic.sort(key=lambda x: x.keys())
            return (dic[0].values())[0]
        elif dis_l > dis_2:
            return rmin
        else:
            return lmin

    def get_distance(self, min):
        return sqrt((min[0][0] - min[1][0])**2 + (min[0][1] - min[1][1])**2)
