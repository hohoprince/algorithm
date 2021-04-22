N = int(input())
dotArr = []
for _ in range(N):
    x, y = map(int, input().split(' '))
    dotArr.append((x, y))
dotArr.sort(key=lambda x: (x[0], x[1]))
for dot in dotArr:
    print(dot[0], dot[1])
