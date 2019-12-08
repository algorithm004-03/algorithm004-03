package leetcode

import "testing"

func Test_search(t *testing.T) {
	type args struct {
		nums   []int
		target int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{name: "test1", args: args{nums: []int{4, 5, 6, 7, 0, 1, 2}, target: 3}, want: -1},
		{name: "test2", args: args{nums: []int{4, 5, 6, 7, 0, 1, 2}, target: 0}, want: 4},
		{name: "test3", args: args{nums: []int{4, 5, 6, 7, 0, 1, 2}, target: 1}, want: 5},
		{name: "test4", args: args{nums: []int{7, 8, 1, 2, 3, 4, 5, 6}, target: 2}, want: 3},
		{name: "test5", args: args{nums: []int{1, 2, 3, 4, 5, 6}, target: 4}, want: 3},
		{name: "test6", args: args{nums: []int{5, 1, 2, 3, 4}, target: 1}, want: 1},
		{name: "test7", args: args{nums: []int{1, 3}, target: 2}, want: -1},
		{name: "test7", args: args{nums: []int{5, 1, 3}, target: 2}, want: -1},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := search(tt.args.nums, tt.args.target); got != tt.want {
				t.Errorf("search() = %v, want %v", got, tt.want)
			}
		})
	}
}
