func InsertionSort(_ list: [Int]) -> [Int] {
    var numbers: [Int] = list
    for i in 1..<numbers.count {
        var insert_index = i
        let current_value = numbers[i]
        numbers.remove(at: i)

        for j in stride(from: i - 1, through: 0, by: -1) {
            if (numbers[j] > current_value) {
                insert_index = j
            }
        }
        numbers.insert(current_value, at: insert_index)
    }
    return numbers
}

print(InsertionSort([64, 34, 25, 12, 22, 11, 90, 5]))