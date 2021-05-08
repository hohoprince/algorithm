answer = 0


def solution(numbers, target):
    dfs(numbers, target, 0, 0)
    return answer


def dfs(numbers, target, index, val):
    global answer
    if index == len(numbers) and val == target:
        answer += 1
        return
    if index == len(numbers):
        return
    dfs(numbers, target, index + 1, val + numbers[index])
    dfs(numbers, target, index + 1, val - numbers[index])
