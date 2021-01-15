import Foundation

func solution(_ s:String) -> Bool {
    return s.lowercased().filter { $0 == "p"}.count ==  s.lowercased().filter { $0 == "y"}.count
}

let s = "Pyy"

print(solution(s))