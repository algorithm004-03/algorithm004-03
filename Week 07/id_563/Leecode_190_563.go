func reverseBits(num uint32) (res uint32) {
	for i := 32; i > 0; i-- {
		res <<= 1
		res += num&1
		num >>= 1
	}
	return res
}