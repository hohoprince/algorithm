func solution(_ n:Int64) -> Int64 {
    return Int64(String(Array(String(n)).sorted { $0 > $1 }))!
}

let n: Int64 = 118372

solution(n)

