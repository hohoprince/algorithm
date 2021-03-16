li = list(map(int, input().split(' ')))
nums = list(map(int, input().split(' ')))

N = li[0]
M = li[1]

result = 0

for i in range(N - 2):
    for j in range(i + 1, N - 1):
        for k in range(j + 1, N):
            sum = nums[i] + nums[j] + nums[k]
            if M >= sum > result:
                result = sum
print(result)

