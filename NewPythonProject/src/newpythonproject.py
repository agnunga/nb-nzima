# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

__author__ = "agunga"
__date__ = "$May 6, 2017 3:19:51 PM$"

if __name__ == "__main__":
    print "Hello World"
print(1258 * 256);

def olooPrinter():
    njugus = "Njuguna"
    return njugus + " another Oloo Jade"
print (olooPrinter())
print (__date__)

total = 0
for i in 1, 3, 7:
   total = total + i
   print(total)
   
   def is_isogram(word):
    if type(word) != str:
        raise TypeError('Argument should be a string')

    elif word == "":
      return (word, False)
    else:
        word = word.lower()
        for char in word:
            if word.count(char) > 1:
                return (word, False)
            else:
                return (word, True) 
        

a = 1
while a:
    a += 23
    print a
             
            