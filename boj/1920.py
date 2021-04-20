N = int(input())

arr = list(map(int, input().split(' ')))

m = {}

for num in arr:
    m[num] = 1

M = int(input())

arr2 = list(map(int, input().split(' ')))

for num in arr2:
    try:
        print(m[num])
    except:
        print(0)

