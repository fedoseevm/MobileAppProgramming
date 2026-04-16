func Euklides(_ a: Int,_ b: Int) -> Int {
    var x = a
    var y = b
    while (x != y) {
        if (x > y) {
            x = x - y
        }
        else {
            y = y - x
        }
    }
    return x
}

print(Euklides(12, 16))