import Foundation

func solution(_ new_id:String) -> String {
    var result = new_id.lowercased()
    
    do {
        var regex = try NSRegularExpression(pattern: "[^a-z0-9-_.]")
        result = regex.stringByReplacingMatches(in: result, range: NSRange(location: 0, length: result.count), withTemplate: "")
        regex = try NSRegularExpression(pattern: "[.]{2,}")
        result = regex.stringByReplacingMatches(in: result, range: NSRange(location: 0, length: result.count), withTemplate: ".")
    } catch {
        print(error.localizedDescription)
    }
    
    result = result.trimmingCharacters(in: ["."])
    
    if result == "" {
        result = "a"
    }
    
    if result.count >= 16 {
        result = String(result[result.startIndex...result.index(result.startIndex, offsetBy: 14)])
    }
    
    result = result.trimmingCharacters(in: ["."])
    
    if result.count <= 2 {
        let index = result.index(result.endIndex, offsetBy: -1)
        while result.count < 3 {
            result.append(result[index])
        }
    }
    
    return result
}

let new_id = "...!@BaT#*..y.abcdefghijklm"

solution(new_id)

