N = int(input())
personArr = []
for _ in range(N):
    age, name = input().split(" ")
    personArr.append((int(age), name))
personArr.sort(key=lambda x: x[0])
for person in personArr:
    print("%d %s" % (person[0], person[1]))
