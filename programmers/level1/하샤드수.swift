func solution(_ x:Int) -> Bool {
    let sum: Int = String(x).map { Int(String($0))! }.reduce(0, +)
    return x.isMultiple(of: sum)
}

let x = 18

solution(x)

