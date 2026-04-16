func SumaCyfr(_ number: Int) -> Int {
    var suma = 0
    var liczba = number

    while (liczba > 0) {
        suma += liczba % 10
        liczba = liczba / 10
    }
    return suma
}

print(SumaCyfr(1234))