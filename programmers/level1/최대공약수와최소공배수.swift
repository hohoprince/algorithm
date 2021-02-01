func solution(_ n:Int, _ m:Int) -> [Int] {
    let bigger = (n > m) ? n : m
    let smaller = (n < m) ? n : m
    var gcd = 0
    var lcm = 0
    
    for i in stride(from: smaller, through: 1, by: -1) {
        if bigger.isMultiple(of: i) && smaller.isMultiple(of: i) {
            gcd = i
            break
        }
    }
    
    for i in bigger...bigger * smaller {
        if i.isMultiple(of: smaller) && i.isMultiple(of: bigger) {
            lcm = i
            break
        }
    }
    
    return [gcd, lcm]
}

let n = 3
let m = 12

solution(n, m)

