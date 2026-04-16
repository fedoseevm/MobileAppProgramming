import Foundation 


func ifPrime(_ x: Int) -> Bool {
    for i in 2...Int(sqrt(Double(x))) {
        if (x % i == 0) { return false }
    }
    return true
}

print(ifPrime(13))