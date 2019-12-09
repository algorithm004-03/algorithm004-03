func myAtoi(str string) int {
    start, sign, total := 0, 1, 0
    for start < len(str) {
        if str[start] != ' ' {
            break
        }
        start++
    }
    if len(str) == start {
        return 0
    }
    first := str[start]
    
    if first == '-' {
        sign = -1
        start++
    } else if first == '+' {
        start++
    } else if first < '0' || first > '9' {
        return 0
    }

    for ; start < len(str); start++ {
        dig := int(str[start] - '0')
        if dig > 9 || dig < 0 {
            break  
        }
        if math.MaxInt32/10 < total || (math.MaxInt32/10 == total && math.MaxInt32%10 < dig){
            if sign > 0 {
                return math.MaxInt32
            } else {
                return math.MinInt32
            }
        }

        total = 10 * total + dig
    }

    return sign * total
}
