def solution(number, k):
    index = 0
    count = 0
    while True:
        if count == k:
            break
        if index == len(number) - 1:
            number = number[:-1]
            index -= 1
            count += 1
            continue
        if number[index] < number[index + 1]:
            number = number[:index] + number[index + 1:]
            count += 1
            if index > 0:
                index -= 1
        else:
            index += 1
    return number


k = 4
number = '222222'

print(solution(number, k))
