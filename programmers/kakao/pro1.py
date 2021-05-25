def solution(s):
    strArr = ["zero", "one", "two", "three", "four", "five",
              "six", "seven", "eight", "nine"]
    for i in range(len(strArr)):
        s = s.replace(strArr[i], str(i))
    return int(s)
