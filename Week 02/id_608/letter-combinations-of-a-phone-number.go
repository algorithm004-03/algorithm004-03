package main

import (
	"fmt"
	"strconv"
)

func main1() {
	r := letterCombinations("23")
	fmt.Println(r)
}
func letterCombinations(digits string) []string {
	var outPut []string
	var maps = make(map[int]string)
	maps[2] = "abc"
	maps[3] = "def"
	maps[4] = "ghi"
	maps[5] = "jkl"
	maps[6] = "mno"
	maps[7] = "pqrs"
	maps[8] = "tuv"
	maps[9] = "wxyz"
	if len(digits) != 0 {
		backtrack("", digits, &outPut, maps)
	}
	return outPut
}

func backtrack(combination string, nextDigits string, outPut *[]string, maps map[int]string) {
	if len(nextDigits) == 0 {
		*outPut = append(*outPut, combination)
	} else {
		runeStr := []rune(nextDigits)
		digit, _ := strconv.Atoi(string(runeStr[0:1]))
		letters := maps[digit]
		letterRune := []rune(letters)
		for i := 0; i < len(letters); i++ {
			letter := letterRune[i : i+1]
			backtrack(combination+string(letter), string(runeStr[1:]), outPut, maps)
		}
	}
}
