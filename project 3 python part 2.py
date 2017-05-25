# Finding mean, median, and standard deviation for a list of numbers

from math import sqrt
import itertools

def buildList():
    list = []     
    print ("Enter your numbers and then enter zero to signify end of list")
    
    xStr = int(raw_input("Enter a number: "))
    while xStr != 0:
        list.append(xStr)   
        xStr = int(raw_input("Enter a number ( or <Enter> to quit) >> "))
    list.sort()
    return list

def tally(list):
    s=0
    for num in list:
        b=list.count(num)
        if b >1:
            if num != s:
                print (num, "occurs", b)
                s=num
        else: None
        
    
def mean(list):
    sum = 0.0
    for num in list:
        sum = sum + num
    return sum / len(list)

def median(list):
    list.sort()
    size = len(list)
    midPos = size // 2
    if size % 2 == 0:
        median = (list[midPos] + list[midPos-1]) / 2.0
    else:
        median = list[midPos]
    return median
    
def standDev(list, xbar):
    sumdevSq = 0.0
    for num in list:
        dev = num - xbar
        sumdevSq = sumdevSq + dev * dev
    return sqrt(sumdevSq/(len(list)-1))
    



def main():
    print("This program computes mean, median, standard deviation and tally of numbers occuring more than once")

    data = buildList()
    xbar = mean(data)
    med = median(data)
    std = standDev(data, xbar)
    
    print("Mean ", xbar)
    print("Median ", med)
    print("Standard Deviation ", std)
    tally(data)
    n=int(raw_input("Press enter to quit "))
	
	

if __name__ == '__main__': main()
