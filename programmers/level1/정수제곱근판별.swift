import Foundation

func solution(_ n:Int64) -> Int64 {
    let sqrtn = sqrt(Double(n))
    if sqrtn - Double(Int(sqrtn)) > 0 { // 제곱근이 아님
        return -1
    } else { // 나누어 떨어진 경우 제곱근
        return Int64((sqrtn + 1) * (sqrtn + 1))
    }
}

let n: Int64 = 121

solution(n)

