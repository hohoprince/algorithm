def solution(number, k):
    answer = list(number)
    for _ in range(k):
        isRemoved = False
        for first, second in zip(answer[:-1], answer[1:]):
            if first < second:
                answer.remove(first)
                isRemoved = True
                break
        if not isRemoved:
            answer = answer[:-1]

    return "".join(answer)
