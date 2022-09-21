from hashtable import HashTable
#https://stephenagrice.medium.com/how-to-implement-a-hash-table-in-python-1eb6c55019fd
if __name__ == '__main__':
    ht = HashTable()
    ht.insert('thor', 'good of thunder')
    ht.insert('thor', 'Odinson')

    print(ht.find('thor'))





    #         Bucket 1          |       Bucket 2   |
    #   thor -> good of thunder
    #   thor -> Odinson
    #
    #
    #
    #
    #

