func solution(_ arr:[Int]) -> [Int] {
    var newArr = arr
    newArr.remove(at: newArr.firstIndex(of: newArr.min()!)!)
    if newArr.isEmpty {
        return [-1]
    }
    return newArr
}

let arr = [4, 3, 2, 1]

solution(arr)

