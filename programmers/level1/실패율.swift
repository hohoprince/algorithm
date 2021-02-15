import Foundation

func solution(_ N:Int, _ stages:[Int]) -> [Int] {
    var counts: [Int: Int] = [:]
    var arr: [(Int, Double)] = []
    var remain = stages.count
    
    stages.map { counts[$0] = (counts[$0] ?? 0) + 1 }
    
    Array(1...N).map {
        remain -= counts[$0 - 1] ?? 0
        arr.append(($0, Double(counts[$0] ?? 0) / Double(remain)))
    }
    return arr.sorted { $0.1 > $1.1 }.map { $0.0 }
}

let N = 5
let stages = [2, 1, 2, 6, 2, 4, 3, 3]

solution(N, stages)

