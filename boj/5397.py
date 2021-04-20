case = int(input())

for _ in range(case):
    key_log = input()

    password1 = []
    password2 = []

    for key in key_log:
        if key == '<':
            if len(password1) > 0:
                password2.append(password1.pop())
        elif key == '>':
            if len(password2) > 0:
                password1.append(password2.pop())
        elif key == '-':
            if len(password1) > 0:
                password1.pop()
        else:
            password1.append(key)

    print(''.join(password1) + ''.join(reversed(password2)))

