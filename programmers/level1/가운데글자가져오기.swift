func solution(_ s:String) -> String {
    let endIndex = s.count / 2
    let charAry = Array(s)
    if s.count.isMultiple(of: 2) {
        return String(charAry[endIndex - 1...endIndex])
    } else {
        return String(charAry[endIndex])
    }
}

solution("abcde")

