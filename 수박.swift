import Foundation

func solution(_ n:Int) -> String {
    var result = String(repeating: "수박", count: n / 2)
    if !n.isMultiple(of: 2) {
        result += "수"
    }
    return result
}

let n = 7

print(solution(n))
