package leetcode

import "testing"

func TestQuickSort(t *testing.T) {
	type args struct {
		array []int
		begin int
		end   int
	}
	tests := []struct {
		name string
		args args
	}{
		{name: "test", args: args{array: []int{10, 28, 29, 12, 122, 3, 1, 2}, begin: 0, end: 7}},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			QuickSort(tt.args.array, tt.args.begin, tt.args.end)
			t.Logf("%v\n", tt.args.array)
		})
	}
}
