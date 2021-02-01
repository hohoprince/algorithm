func solution(_ num:Int) -> Int {
    if num == 1 {
        return 0
    }
    
    var n = num
    
    for i in 1...500 {
        if n.isMultiple(of: 2) {
            n = n / 2
        } else {
            n = n * 3 + 1
        }
        if n == 1 {
            return i
        }
    }
    return -1
}


let n = 16

solution(n)

