n = int(input())

members = list(map(int, input().split()))

members.sort()

result = 0
count = 0

for member in members:
    count += 1
    if count >= member:
        result += 1
        count = 0
print(result)
