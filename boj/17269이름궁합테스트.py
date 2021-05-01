N, M = input().split()
name1, name2 = input().split()

alpha_num = [3, 2, 1, 2, 4, 3, 1, 3, 1, 1, 3, 1, 3, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1]

min_len = min(len(name1), len(name2))
alpha = ''

for i in range(min_len):
    alpha += name1[i] + name2[i]
alpha += name1[min_len:]
alpha += name2[min_len:]

number_list = [alpha_num[ord(i) - ord('A')] for i in alpha]

while len(number_list) != 2:
    for i in range(len(number_list) - 1):
        number_list[i] = (number_list[i] + number_list[i + 1]) % 10
    number_list.pop()

print(number_list[0] * 10 + number_list[1], end='%')
