import Foundation

func solution(_ numbers:[Int], _ hand:String) -> String {
    struct Key {
        let name: String
        let x: Int
        let y: Int
    }
    
    let keys = [Key(name: "0", x: 1, y: 3),
                Key(name: "1", x: 0, y: 0),
                Key(name: "2", x: 1, y: 0),
                Key(name: "3", x: 2, y: 0),
                Key(name: "4", x: 0, y: 1),
                Key(name: "5", x: 1, y: 1),
                Key(name: "6", x: 2, y: 1),
                Key(name: "7", x: 0, y: 2),
                Key(name: "8", x: 1, y: 2),
                Key(name: "9", x: 2, y: 2),
    ]
    
    
    var left = Key(name: "*", x: 0, y: 3)
    var right = Key(name: "#", x: 2, y: 3)
    
    return String(numbers.map {
        switch $0 {
        case 1, 4, 7:
            left = keys[$0]
            return "L"
        case 3, 6, 9:
            right = keys[$0]
            return "R"
        case 2, 5, 8, 0:
            if abs(keys[$0].x - left.x) + abs(keys[$0].y - left.y) ==
                abs(keys[$0].x - right.x) + abs(keys[$0].y - right.y) {
                if hand == "right" {
                    right = keys[$0]
                    return "R"
                } else {
                    left = keys[$0]
                    return "L"
                }
            } else if abs(keys[$0].x - left.x) + abs(keys[$0].y - left.y) >
                        abs(keys[$0].x - right.x) + abs(keys[$0].y - right.y) {
                right = keys[$0]
                return "R"
            } else {
                left = keys[$0]
                return "L"
            }
        default:
            return " "
        }
    })
}

let numbers = [7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]
let hand = "left"

solution(numbers, hand)

