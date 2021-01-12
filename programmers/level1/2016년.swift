let lastDays = [1: 31, 2: 29, 3: 31, 4: 30, 5: 31, 6: 30,
               7: 31, 8: 31, 9: 30, 10: 31, 11: 30, 12: 31]

let rest = [0: "THU", 1: "FRI", 2: "SAT", 3: "SUN", 4: "MON", 5: "TUE", 6: "WED"]

func solution(_ a:Int, _ b:Int) -> String {
    var sum = 0
    for month in 1..<a {
        sum += lastDays[month]!
    }
    sum += b
    return rest[sum % 7]!
}

let a = 5
let b = 24

solution(a, b)

