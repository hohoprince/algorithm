loc = input()
x = int(ord(loc[0])) - int(ord('a')) + 1
y = int(loc[1])

steps = [(2, 1), (2, -1), (-2, 1), (-2, -1),
         (1, 2), (1, -2), (-1, 2), (-1, -2)]

count = 0

for step in steps:
    nx = x + step[0]
    ny = y + step[1]

    if 1 <= nx <= 8 and 1 <= ny <= 8:
        count += 1

print(count)