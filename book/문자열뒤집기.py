nums = input()

count0 = 0
count1 = 0

now = nums[0]
if now == '1':
    count1 += 1
else:
    count0 += 1

for num in nums[1:]:
    if now != num:
        if num == '0':
            count0 += 1
        else:
            count1 += 1
    now = num
print(min(count0, count1))
