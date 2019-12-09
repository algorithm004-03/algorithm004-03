package main

func reverseOnlyLetters(S string) string {
	var str,out string
	for i:=len(S)-1;i>=0;i--{
		if isLetter(S[i]) {
			str += string(S[i])
		}
	}

	for i,j:=0,0;i<len(S);i++ {
		if isLetter(S[i]) {
			out += string(str[j])
			j++
		} else {
			out += string(S[i])
		}
	}

	return out
}

func isLetter (str byte) bool{
	var out bool
	if (str >= 'a' && str <= 'z') || (str >= 'A' && str <= 'Z') {
		out = true
	}
	return out
}
