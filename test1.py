def split(word):
    a = zip(*[word[i::3] for i in range(3)])
    a[:3]
    word = a
    return word





print(split('adonis'))
