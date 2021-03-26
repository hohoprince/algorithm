def solution(participant, completion):
    psum = 0
    csum = 0
    for p in participant:
        psum += p.__hash__()
    for c in completion:
        csum += c.__hash__()

    hashValue = psum - csum

    for p in participant:
        if p.__hash__() == hashValue:
            return p

participant = ["leo", "kiki", "eden"]
completion = ["eden", "kiki"]

print(solution(participant, completion))
