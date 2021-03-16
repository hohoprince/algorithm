case = int(input())

for _ in range(case):
    n, m = list(map(int, input().split(' ')))
    q = list(map(int, input().split(' ')))
    q = [(idx, num) for idx, num in enumerate(q)]

    count = 0

    while True:
        if q[0][1] == max(q, key=lambda x: x[1])[1]:
            count += 1
            if q[0][0] == m:
                print(count)
                break
            else:
                q.pop(0)
        else:
            q.append(q.pop(0))
