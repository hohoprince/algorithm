import Foundation

func solution(_ n:Int) -> Int {
    let t = String(n, radix: 3)
    return Int(String(t.reversed()), radix: 3)!
}

solution(45)
