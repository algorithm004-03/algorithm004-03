package leetcode

func reverseBits(num uint32) uint32 {

	var rt uint32
	rt = 0
	for i := 0; i < 32; i++ {
		//每次取最后一位追加到结果值，然后对结果进行移位
		rt = (rt << 1) + (num & 1)
		num = num >> 1
	}
	return rt
}
