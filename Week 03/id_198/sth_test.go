package leetcode

import "testing"

func TestSlice(t *testing.T) {

	t.Logf("%v\n", []int(nil))
	t.Logf("%v", []int{})
	t.Logf("%v", make([]int, 0))
	t.Logf("%v", make([]int, 2))
	t.Logf("val=%v,len=%d,cap=%d", *new([]int), len(*new([]int)), cap(*new([]int)))
	t.Logf("val=%v,len=%d,cap=%d", *new([2]int), len(*new([2]int)), cap(*new([2]int)))
	t.Logf("[2]int{} => val=%v,len=%d,cap=%d", [2]int{}, len([2]int{}), cap([2]int{}))

	a := make([]int, 2)
	t.Logf("%#v => val=%v,len=%d,cap=%d", a, a, len(a), cap(a))
	a = append(a, 1)
	t.Logf("%#v => val=%v,len=%d,cap=%d", a, a, len(a), cap(a))
	a = append(a, 1)
	t.Logf("%#v => val=%v,len=%d,cap=%d", a, a, len(a), cap(a))
	a = append(a, 1)
	t.Logf("%#v => val=%v,len=%d,cap=%d", a, a, len(a), cap(a))

	a = nil
	t.Logf("%#v => val=%v,len=%d,cap=%d", a, a, len(a), cap(a))

	a = append(a, 1)
	t.Logf("%#v => val=%v,len=%d,cap=%d", a, a, len(a), cap(a))

	a = append(a, 1)
	t.Logf("%#v => val=%v,len=%d,cap=%d", a, a, len(a), cap(a))

	a = a[:0]
	t.Logf("%#v => val=%v,len=%d,cap=%d", a, a, len(a), cap(a))
}
