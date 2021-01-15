func solution(_ s:String) -> Bool {
    return Int(s) != nil && s.count == 4 || s.count == 6
}

print(solution("1234"))