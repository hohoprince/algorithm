r, c = map(int, input().split())

result = 0

for _ in range(r):
     nums = list(map(int, input().split()))
     min_num = min(nums)
     result = max(result, min_num)

print(result)