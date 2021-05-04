n, m = map(int, input().split())

x, y, direction = map(int, input().split())

game_map = []
visit_map = [[0] * m for _ in range(n)]

for _ in range(n):
    game_map.append(list(map(int, input().split())))

dy = [0, 1, 0, -1]
dx = [-1, 0, 1, 0]

visit_map[x][y] = 1

turn_count = 0
result = 1


def turn_left():
    global direction
    direction = direction - 1 if direction - 1 >= 0 else 3


while True:
    turn_left()
    nx = x + dx[direction]
    ny = y + dy[direction]
    if visit_map[nx][ny] == 0 and game_map[nx][ny] == 0:
        x = nx
        y = ny
        visit_map[x][y] = 1
        result += 1
        turn_count = 0
        continue
    else:
        turn_count += 1
    if turn_count == 4:
        nx = x - dx[direction]
        ny = y - dy[direction]
        if game_map[nx][ny] == 0:
            x = nx
            y = ny
        else:
            break
        turn_count = 0
print(result)

'''
4 4
1 1 0
1 1 1 1
1 0 0 1
1 1 0 1
1 1 1 1
'''
