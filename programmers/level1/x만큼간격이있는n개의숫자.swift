func solution(_ x:Int, _ n:Int) -> [Int64] {
    var result: [Int64] = []
    for i in 1...n {
        result.append(Int64(x * i))
    }
    return result
}

let x = 2
let n = 5

solution(x, n)

