n = int(input())

c = list(map(int, input().split()))

d = [0] * 100

d[0] = c[0]

d[1] = max(c[0], c[1])

for i in range(2, n):
    d[i] = max(d[i - 1], d[i - 2] + c[i])
print(d[n - 1])


