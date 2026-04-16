func rozpietoscTablicy(_ list: [Int]) -> Int {
    var min: Int = list[0]
    var max: Int = list[0]

    for item in list {
        if (item > max) {max = item}
        if (item < min) {min = item}
    }
    return max - min
}

print(rozpietoscTablicy([-1,2,3,4,5,6]))