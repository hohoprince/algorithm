li = list(map(int, input().split(' ')))

asc = True
desc = True

for i in range(1, 8):
    if li[i] > li[i - 1]:
        desc = False
    elif li[i] < li[i - 1]:
        asc = False

if asc:
    print('ascending')
elif desc:
    print('descending')
else:
    print('mixed')
