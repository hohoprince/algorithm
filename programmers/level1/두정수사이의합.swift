func solution(_ a:Int, _ b:Int) -> Int64 {
    let n = Int64(abs(a - b) + 1)
    return (Int64(a) + Int64(b)) * n / 2
}

solution(3, 3)
