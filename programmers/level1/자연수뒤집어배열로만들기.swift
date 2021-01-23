func solution(_ n:Int64) -> [Int] {
    return String(n).map { Int(String($0))! }.reversed()
}

let n: Int64 = 12345

solution(n)

