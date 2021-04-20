import hashlib

data = input()
print(hashlib.sha256(data.encode()).hexdigest())

