func solution(_ arr:[Int], _ divisor:Int) -> [Int] {
    let result = arr.filter { $0.isMultiple(of: divisor) }
    return result.count == 0 ? [-1] : result.sorted()
}

let arr = [2, 36, 1, 3]

let divisor = 1

solution(arr, divisor)

