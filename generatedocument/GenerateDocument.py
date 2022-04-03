def generateDocument(characters, document):
    sortedChars = sorted(characters)
    sortedDocument = sorted(document)

    for item in sortedDocument:
        if item in sortedChars:
            sortedChars.remove(item)
        else:
            return False

    return True


if __name__ == '__main__':
    print(generateDocument("helloworldO", "hello wOrld"))