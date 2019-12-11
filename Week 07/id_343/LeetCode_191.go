func hammingWeight(num uint32) int {
    sum := 0
    for num > 0 {
        sum++
        num &= (num-1)
    }
    return sum
}
