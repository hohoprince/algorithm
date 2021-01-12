import Foundation

func solution(_ n:Int, _ lost:[Int], _ reserve:[Int]) -> Int {
    var reserveList = reserve
    var lostList = lost
    
    let s = Set(reserveList).intersection(Set(lostList))
    
    s.forEach {
        reserveList.remove(at: reserveList.firstIndex(of: $0)!)
        lostList.remove(at: lostList.firstIndex(of: $0)!)
    }
    
    var count = n - lostList.count
    lostList.forEach {
        if reserveList.contains($0 - 1) {
            count += 1
            reserveList.remove(at: reserveList.firstIndex(of: $0 - 1)!)
        } else if reserveList.contains($0 + 1) {
            count += 1
            reserveList.remove(at: reserveList.firstIndex(of: $0 + 1)!)
        }
    }
    return count
}

let n = 5
let lost = [1, 2, 4, 5]
let reserve = [2, 3, 4]

solution(n, lost, reserve)

