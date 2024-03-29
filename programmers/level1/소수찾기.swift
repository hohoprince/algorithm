import Foundation

func solution(_ n: Int) -> Int {
    var primes = [Bool](repeating: false, count: n + 1)
    var count = 0
    for i in 2...n {
        if !primes[i] {
            count += 1
        }
        for j in 1...n / i {
            primes[i * j] = true
        }
    }
    return count
}

let n = 10

print(solution(n))