from hashtable import HashTable

if __name__ == '__main__':
    ht = HashTable()
    ht.insert('thor', 'good of thunder')
    ht.insert('thor', 'Odinson')

    print(ht.find('thor'))





    #         Bucket 1          |       Bucket 2
    #   thor -> good of thunder
    #   thor -> Odinson
    #
    #
    #
    #
    #

