spam = ['apples', 'bananas', 'tofu', 'cats']

def main():
    i=int(raw_input(" please enter your list: "))
        

def comma(List):
    count=0
    String=''
    while count < len(List)-1:
        String += List[count] + ', '
        count+=1
    return String + 'and ' + List[count]


print comma(spam)

i=int (raw_input("press enter to quit: "))

if __name__== '__main__':
    main()
