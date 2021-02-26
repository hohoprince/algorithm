import Foundation

func solution(_ skill:String, _ skill_trees:[String]) -> Int {
    var count = 0
    loof: for skillTree in skill_trees {
        var skillList = skill
        for s in skillTree {
            if skillList.contains(s) {
                if skillList.first == s {
                    skillList.removeFirst()
                } else {
                    continue loof
                }
            }
        }
        count += 1
    }
    return count
}

let skill = "CBD"
let skill_trees = ["BACDE", "CBADF", "AECB", "BDA"]

solution(skill, skill_trees)

