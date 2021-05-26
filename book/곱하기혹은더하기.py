nums = input()
num_list = list(map(int, nums))

result = num_list[0]

for num in num_list[1:]:
    if result < 2 or num < 2:
        result += num
    else:
        result *= num

print(result)
