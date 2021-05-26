n = int(input())
coins = list(map(int, input().split()))

coins.sort()

value = 1

for coin in coins:
    if value < coin:
        break
    value += coin

print(value)

