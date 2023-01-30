def minNumberOfCoinsForChange(money, coins):

    arr = [0 for i in range(money + 1)]

    for selected_money in range(1, money + 1):
        for selected_coin in coins:
            if selected_coin <= selected_money:
                arr[selected_money] = selected_coin + arr[selected_money - 1]

    return arr



if __name__ == '__main__':
    print(minNumberOfCoinsForChange(7, [1,  5, 10]))