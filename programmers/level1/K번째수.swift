import Foundation

func solution(_ array:[Int], _ commands:[[Int]]) -> [Int] {
    var result: [Int] = []
    commands.forEach { command in
        let i = command[0]
        let j = command[1]
        let k = command[2]
        let tmp = array[i - 1...j - 1].sorted()
        result.append(tmp[tmp.startIndex + k - 1])
    }
    return result
}

let array = [1, 5, 2, 6, 3, 7, 4]
let commands = [[2, 5, 3], [4, 4, 1], [1, 7, 3]]

print(solution(array, commands))