def solution(phone_book):
    phone_book.sort()
    for first, second in zip(phone_book[:-1], phone_book[1:]):
        if second.startswith(first):
            return False
    return True
