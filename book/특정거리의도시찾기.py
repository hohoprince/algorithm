from collections import deque

n, m, k, x = map(int, input().split())

graph = [[] for _ in range(n + 1)]

distance = [-1] * (n + 1)

distance[x] = 0

q = deque([x])

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)

while q:
    now = q.popleft()
    for city in graph[now]:
        if distance[city] == -1:
            q.append(city)
            distance[city] = distance[now] + 1

check = False

for i in range(n + 1):
    if distance[i] == k:
        print(i)
        check = True

if not check:
    print(-1)
