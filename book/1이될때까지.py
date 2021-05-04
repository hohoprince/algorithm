n, k = map(int, input().split())

result = 0

while True:
    num = (n // k) * k
    result += n - num
    n = num
    if n < k:
        break
    result += 1
    n //= k

result += n - 1
print(result)
