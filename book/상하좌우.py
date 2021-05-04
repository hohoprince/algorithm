n = int(input())
directions = input().split()

x, y = 1, 1

for direction in directions:
    if direction == 'U':
        if 1 <= x - 1 <= n:
            x -= 1
    elif direction == 'D':
        if 1 <= x + 1 <= n:
            x += 1
    elif direction == 'R':
        if 1 <= y + 1 <= n:
            y += 1
    else:
        if 1 <= y - 1 <= n:
            y -= 1
print(x, y)