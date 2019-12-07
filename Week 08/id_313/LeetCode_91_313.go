package id_313

func numDecodings(s string) int {
	size := len(s)
	if size == 0 {
		return 0
	}
	m := make([]int, size+1)
	m[size] = 1
	if s[size-1] != '0' {
		m[size-1] = 1
	}

	for i := size - 2; i >= 0; i-- {
		switch cur := s[i]; cur {
		case '0':
			if s[i+1] == '0' || i == 0 {
				return 0
			}
			m[i] = 0
		case '1':
			m[i] = m[i+1] + m[i+2]
		case '2':
			if int(s[i+1]-'0') < 7 {
				m[i] = m[i+1] + m[i+2]
			} else {
				m[i] = m[i+1]
			}
		default:
			m[i] = m[i+1]
		}
	}
	return m[0]
}
