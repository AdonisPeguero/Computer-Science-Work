def project4(mylist):
    counter = 0
    space = ''
    while counter < len(mylist)-1:
        space += mylist[counter] + ', '
        counter +=1
    return space + 'and ' + mylist[counter]
