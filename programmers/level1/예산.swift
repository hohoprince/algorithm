import Foundation

func solution(_ d:[Int], _ budget:Int) -> Int {
    let sorted = d.sorted()
    var remain = budget
    var count = 0
    for c in sorted {
        remain -= c
        if remain >= 0 {
            count += 1
        } else {
            break
        }
    }
    
    return count
}

let d = [1, 3, 2, 5, 4]

let budget = 9

solution(d, budget)

