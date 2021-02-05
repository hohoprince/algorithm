func solution(_ phone_number:String) -> String {
    let stars = String(repeating: "*", count: phone_number.count - 4)
    return stars + phone_number.suffix(4)
}

let phoneNumber = "01033334444"

solution(phoneNumber)

