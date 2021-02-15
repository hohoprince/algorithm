func solution(_ dartResult:String) -> Int {
    var scores: [Int] = []
    var index = -1
    var tmp = ""
    for c in dartResult {
        switch c {
        case "0"..."9":
            tmp += String(c)
        case "S":
            let num = Int(tmp)!
            tmp = ""
            index += 1
            scores.append(num)
        case "D":
            let num = Int(tmp)!
            tmp = ""
            index += 1
            scores.append(num * num)
        case "T":
            let num = Int(tmp)!
            tmp = ""
            index += 1
            scores.append(num * num * num)
        case "#":
            scores[index] = -scores[index]
        case "*":
            scores[index] = scores[index] * 2
            guard index != 0 else { break }
            scores[index - 1] = scores[index - 1] * 2
        default: break
        }
    }
    return scores.reduce(0, +)
}

let dartResult = "1S*2T*3S"

solution(dartResult)

