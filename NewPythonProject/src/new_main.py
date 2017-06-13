#! /usr/bin/python

# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

__author__ = "agunga"
__date__ = "$Jun 5, 2017 9:04:39 AM$"

#if __name__ == "__main__":
#    print "Hello World";
#    
#numbers = []
#for i in range(2000, 3201):
#    if (i%7 == 0) and (i%5 != 0):
#        numbers.append(str(i))
#print ','.join(numbers)
#
#number = int(raw_input())
#my_dictionary = dict()
#for i in range(1, number+1):
#    my_dictionary[i] = i*i
#print my_dictionary

values = raw_input()
my_list = values.split(",")
my_tuple = tuple(my_list)
print my_list
print my_tuple