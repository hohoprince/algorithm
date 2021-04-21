case = int(input())


def find(name):
    if name == rel_group[name]:
        return name
    else:
        p = find(rel_group[name])
        rel_group[name] = p
        return rel_group[name]


for _ in range(case):
    rel_group = dict()
    number = dict()

    f = int(input())
    for _ in range(f):
        a, b = input().split(' ')
        if a not in rel_group:
            rel_group[a] = a
            number[a] = 1
        if b not in rel_group:
            rel_group[b] = b
            number[b] = 1
        a = find(a)
        b = find(b)
        if a != b:
            rel_group[b] = a
            number[a] += number[b]
        print(number[find(a)])

