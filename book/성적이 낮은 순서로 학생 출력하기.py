n = int(input())

li = []

for _ in range(n):
    name, score = input().split()
    li.append((name, int(score)))

li.sort(key=lambda x: x[1])

for s in li:
    print(s[0], end=' ')
