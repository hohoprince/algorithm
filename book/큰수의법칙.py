N, M, K = map(int, input().split())
nums = list(map(int, input().split()))

nums.sort()
max_num = nums[-1]
second_num = nums[-2]

sum = 0

while True:
    for i in range(K):
        if M == 0:
            break
        sum += max_num
        M -= 1
    if M == 0:
        break
    sum += second_num
    M -= 1

print(sum)