func solution(_ s:String, _ n:Int) -> String {
    return String(s.map {
        var ascii = $0.asciiValue!
        switch ascii {
        case 65...90:
            ascii = ((ascii - 65) + UInt8(n)) % 26 + 65
        case 97...122:
            ascii = ((ascii - 97) + UInt8(n)) % 26 + 97
        default:
            ascii = 32
        }
        return Character(UnicodeScalar(ascii))
    })
}

let s = "a B z"
let n = 4
solution(s, 4)

