func reverseOnlyLetters(S string) string {
    i, j := 0, len(S) - 1

    var res = []byte(S)

    for i < j {
        if !isWord(res[i]) {
            i++
            continue
        }
        if !isWord(res[j]) {
            j--
            continue
        }

        res[i], res[j] = res[j], res[i]
        i++
        j--
    }

    return string(res)
}

func isWord(s byte) bool {
    if (s >= 'a' && s <= 'z') || (s >= 'A' && s <= 'Z') {
        return true
    }

    return false
}
