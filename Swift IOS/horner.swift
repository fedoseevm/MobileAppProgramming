func Horner(_ wsp: [Int], _ x: Int) -> Int {
    var wynik = 0
    for number in wsp {
        wynik = wynik * x + number
    }
    return wynik
}

print(Horner([2, 3, 4], 1))