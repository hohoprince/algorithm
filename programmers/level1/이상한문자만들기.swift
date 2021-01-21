func solution(_ s:String) -> String {
    var isOdd = true
    return String(s.map {
        if $0 == " " {
            isOdd = true
            return $0
        } else if isOdd {
            isOdd = false
            return Character($0.uppercased())
        } else {
            isOdd = true
            return Character($0.lowercased())
        }
    })
}

let s = "try hello world"

solution(s)

