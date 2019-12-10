package leetcode

import "testing"

func Test_forceSearch(t *testing.T) {
	type args struct {
		a string
		b string
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{name: "a", args: args{a: "aebcdeabcfg", b: "abc"}, want: 6},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := forceSearch(tt.args.a, tt.args.b); got != tt.want {
				t.Errorf("forceSearch() = %v, want %v", got, tt.want)
			}
		})
	}
}
