package leetcode

import "testing"

func Test_search(t *testing.T) {
	type args struct {
		nums []int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{name: "test1", args: args{nums: []int{4, 5, 6, 7, 0, 1, 2}}, want: 4},
		{name: "test2", args: args{nums: []int{7, 8, 1, 2, 3, 4, 5, 6}}, want: 2},
		{name: "test3", args: args{nums: []int{1, 2, 3, 4, 5, 6}}, want: -1},
		{name: "test4", args: args{nums: []int{5, 1, 2, 3, 4}}, want: 1},
		{name: "test5", args: args{nums: []int{1, 3}}, want: -1},
		{name: "test6", args: args{nums: []int{5, 1, 3}}, want: 1},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := searchRotatedIndex(tt.args.nums); got != tt.want {
				t.Errorf("search() = %v, want %v", got, tt.want)
			}
		})
	}
}
