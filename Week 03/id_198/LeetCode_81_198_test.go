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
		want bool
	}{
		{name: "test1", args: args{nums: []int{1, 3, 1, 1, 1}, target: 3}, want: true},
		{name: "test2", args: args{nums: []int{1, 1, 3, 1}, target: 3}, want: true},
		{name: "test3", args: args{nums: []int{1, 1}, target: 0}, want: false},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := search(tt.args.nums, tt.args.target); got != tt.want {
				t.Errorf("search() = %v, want %v", got, tt.want)
			}
		})
	}
}
