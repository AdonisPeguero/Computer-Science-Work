

def equations(k):
    switcher = {
        1: 2*k-1,
        2: 2*k-1,
        3: 3*k+1,
        5: 3*k+1,
        4: 4*k-1,
        6: k-2,
        7: k-2,
        8: k-2,
        }
    return switcher.get(k, 0)
    

    
j = equations(9)

print j


