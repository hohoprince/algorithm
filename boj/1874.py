n = int(input())

num = 1

result = []
s = []

for i in range(n):
    req = int(input())
    while num <= req:
        s.append(num)
        num += 1
        result.append('+')
    if s[-1] == req:
        s.pop()
        result.append('-')
    else:
        print('NO')
        exit(0)

print('\n'.join(result))
