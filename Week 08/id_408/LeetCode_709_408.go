func toLowerCase(str string) string {
strRune := []rune(str)
for i := 0; i < len(strRune); i++ {
if strRune[i] >= 'A' && strRune[i] <= 'Z' {
strRune[i] = strRune[i] + 32
}
}
return string(strRune)

}
