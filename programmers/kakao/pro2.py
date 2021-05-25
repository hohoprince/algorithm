from collections import deque

def solution(places):
    answer = []
    for place in places:
        c_place = []
        o_place = []
        for p in place:
            c_place.append(list(p))
            o_place.append(list(p))

        results = []
        for i in range(5):
            for j in range(5):
                results.append(bfs(c_place, i, j))
                c_place = o_place
        if 0 in results:
            answer.append(0)
        else:
            answer.append(1)
    return answer

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(place, ox, oy):
    if place[ox][oy] != 'P':
        return 1
    queue = deque()
    queue.append((ox, oy))
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= 5 or ny >= 5:
                continue
            if place[nx][ny] == 'X':
                continue
            if place[nx][ny] == 'O':
                if place[x][y] == 'P':
                    place[nx][ny] = 1
                else:
                    place[nx][ny] = place[x][y] + 1
                queue.append((nx, ny))
            if place[nx][ny] == 'P' and (nx, ny) != (ox, oy):
                if place[x][y] == 'P':
                    return 0
                if int(place[x][y]) < 2:
                    return 0
    return 1
