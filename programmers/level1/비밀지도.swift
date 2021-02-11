func solution(_ n:Int, _ arr1:[Int], _ arr2:[Int]) -> [String] {
    return zip(arr1, arr2).map {
        let tmp = String($0 | $1, radix: 2).map {
            $0 == "1" ? "#" : " "
        }.joined(separator: "")
        return String(repeating: " ", count: n - tmp.count) + tmp
    }
}

let n = 6
let arr1 = [46, 33, 33 ,22, 31, 50]
let arr2 = [27 ,56, 19, 14, 14, 10]

solution(n, arr1, arr2)
