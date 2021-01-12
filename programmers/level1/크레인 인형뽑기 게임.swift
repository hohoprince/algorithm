import Foundation

func solution(_ board: inout [[Int]], _ moves:[Int]) -> Int {
    var answer = 0
    var basket: [Int] = []

    moves.forEach { move in
        let col = move - 1
        for row in 0..<board.count {
            if board[row][col] != 0 {
                let num = board[row][col]
                board[row][col] = 0
                if !basket.isEmpty {
                    if basket.last == num {
                        basket.removeLast()
                        answer += 2
                        break
                    }
                }
                basket.append(num)
                break
            }
        }
    }
    
    return answer
}

var board = [[0,0,0,0,0],
            [0,0,1,0,3],
            [0,2,5,0,1],
            [4,2,4,4,2],
            [3,5,1,3,1]]

let moves = [1,5,3,5,1,2,1,4]

let answer = solution(&board, moves)
print (answer)