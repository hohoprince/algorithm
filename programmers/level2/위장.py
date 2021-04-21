def solution(clothes):
    m = dict()
    for cloth in clothes:
        if cloth[1] not in m:
            m[cloth[1]] = 1
        else:
            m[cloth[1]] += 1

    result = 1
    for num in m.values():
        result *= num + 1
    result -= 1
    return result
