'''

@author: Adonis Peguero

Variation of hangman.py. Text output only.

'''

import random


def fileToStringList(filename):
    """
    filename is a file of strings,
    returns a list of strings, each string represents
    one line from filename
    """
    wordlist = []
    f = open(filename)
    for line in f:
        line = line.strip()
        wordlist.append(line)
    f.close()
    return wordlist


def getPossibleWords(wordlist, length):
    newList = []
    for x in range(len(wordlist)-1):
        if (len(wordlist[x]) == length):
            newList.append(wordlist[x])
    wordlist = newList
    return wordlist

    
    
   

    """
    returns a list of words from wordlist having a
    specified length
    """
    # TODO - write a list comprehension to return
    # only those words of the specified length
   


def displayGuess(wordList):
    '''
    wordList is a list of characters with letters correctly
    guessed and '_' for letters not quessed yet
    returns the list as a String
    '''
    
    return ' '.join(wordList)


def guessStart(word):
    '''
    returns a list of single characters '_' the
    same size as word
    '''
    return ['_'] * len(word)


def updateLetter(guessList, wordToGuess, letter):
    '''
    wordToGuess is the word the user is trying to guess.
    guessList is the word to guess as a list of characters, but
    only including the letters the user has guessed and showing
    the character '_' if a letter hasn't been guessed yet.
    letter is the current letter the user has guessed.

    Modify guessList to include letter in its proper locations if
    letter is in wordToGuess.

    For example, if the wordToGuess is "baloney" and so far only a and
    e have been guessed, then guessList is ['_','a','_','_','_','e','_']
    If letter is 'o', then guessList is modified to now be:
    ['_','a','_','o','_','e','_']

    '''
    # TODO: replace pass with code to modify guessList if letter is in
    #  the wordToGuess

    if letter in wordToGuess:
     guessList[wordToGuess.index(letter)] = letter
    if letter not in wordToGuess:
        return False 
    
   

def playGame(words):
    '''
    Play the game. Let the user know if they won or not.
    '''
    # setup for game
    lettersleft = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
    guessLength = int(raw_input("how many letters in word to guess? Must be 3 or greater "))
    misses = int(raw_input("How many Misses allowed?: "))
    wordsOfLength = getPossibleWords(words, guessLength)
    wordToGuess = random.choice(wordsOfLength)
    guessList = guessStart(wordToGuess)

    # start the guessing
    while True:
        if guessList.count('_') == 0:
            # all letters guessed
            break
        if misses == 0:
            break
        print ""
        
        print "guessed so far:", displayGuess(guessList)

        print "Chances left:", misses
        print "Letters not used: ", lettersleft
        
        letter = raw_input("guess a letter: (To guess the entire word press +): ")
        if letter == '+':
            letter = raw_input("Enter full  word: ")
            if letter == wordToGuess:
                print "You guessed the word, YOU WIN", wordToGuess
                quit()
            else:
                print "Incorrect, The word was ", wordToGuess, "You lose"
                quit()
            if letter in lettersleft:
              lettersleft.remove(letter)
              updateLetter(guessList, wordToGuess, letter)
              if updateLetter(guessList, wordToGuess, letter) is False:
                  misses = misses-1

                
         
            
            
    # game over
    if guessList.count('_') == 0:
        print "You win. You guessed the word", wordToGuess
    else:
        print "You lost, word was", wordToGuess


if __name__ == '__main__':
    words = fileToStringList('lowerwords.txt')
    playGame(words)
