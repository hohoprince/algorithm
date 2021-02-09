func solution(_ arr1:[[Int]], _ arr2:[[Int]]) -> [[Int]] {
    return zip(arr1, arr2).map { zip($0, $1).map { $0 + $1 } }
}

let arr1 = [[1,2],[2,3]]
let arr2 = [[3,4],[5,6]]

solution(arr1, arr2)

