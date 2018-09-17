from Match import Match

class Solution:
    
    def __init__(self, m, n, hospital_list, student_list, hosp_open_slots):
        """
            The constructor exists only to initialize variables. You do not need to change it.
            :param m: The number of hospitals
            :param n: The number of students
            :param hospital_list: The preference list of hospitals, as a dictionary.
            :param student_list: The preference list of the students, as a dictionary.
            :param hosp_open_slots: Open slots of each hospital
            """
        self.m = m
        self.n = n
        self.hospital_list = hospital_list
        self.student_list = student_list
        self.hosp_open_slots = hosp_open_slots

    def get_matches(self):
        
        return []
