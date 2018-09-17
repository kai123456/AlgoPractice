from Marriage import Marriage


class Solution:

    def __init__(self, number, women, men):
        """
        The constructor exists only to initialize variables. You do not need to change it.
        :param number: The number of members
        :param men: The preference list of men, as a dictionary.
        :param women: The preference list of the women, as a dictionary.
        """
        self.num = number
        self.men = men
        self.women = women
        self.count = 0
        self.stable_matchings = []

    def output_stable_matchings(self):
        """
        This method both computes and returns the stable matchings
        :return: the list of stable matchings
        """
        match = []
        for i in range(1, self.num + 1):
            match.append(Marriage(i, i))
        itertools.permutations(match, num)
        
        return self.stable_matchings
