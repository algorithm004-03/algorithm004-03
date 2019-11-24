package leetcode

import (
	"reflect"
	"testing"
)

func TestConstructor(t *testing.T) {
	tests := []struct {
		name string
		want Trie
	}{
		// TODO: Add test cases.
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := Constructor(); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("Constructor() = %v, want %v", got, tt.want)
			}
		})
	}
}

func TestTrie_Insert(t *testing.T) {
	type fields struct {
		val      rune
		isEnd    bool
		children []Trie
	}
	type args struct {
		word string
	}
	tests := []struct {
		name   string
		fields fields
		args   args
	}{
		// TODO: Add test cases.
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			this := &Trie{
				val:      tt.fields.val,
				isEnd:    tt.fields.isEnd,
				children: tt.fields.children,
			}
			this.Insert(tt.args.word)
		})
	}
}

func TestTrie_Search(t *testing.T) {
	type fields struct {
		val      rune
		isEnd    bool
		children []Trie
	}
	type args struct {
		word string
	}
	tests := []struct {
		name   string
		fields fields
		args   args
		want   bool
	}{
		// TODO: Add test cases.
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			this := &Trie{
				val:      tt.fields.val,
				isEnd:    tt.fields.isEnd,
				children: tt.fields.children,
			}
			if got := this.Search(tt.args.word); got != tt.want {
				t.Errorf("Trie.Search() = %v, want %v", got, tt.want)
			}
		})
	}
}

func TestTrie_StartsWith(t *testing.T) {
	type fields struct {
		val      rune
		isEnd    bool
		children []Trie
	}
	type args struct {
		prefix string
	}
	tests := []struct {
		name   string
		fields fields
		args   args
		want   bool
	}{
		// TODO: Add test cases.
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			this := &Trie{
				val:      tt.fields.val,
				isEnd:    tt.fields.isEnd,
				children: tt.fields.children,
			}
			if got := this.StartsWith(tt.args.prefix); got != tt.want {
				t.Errorf("Trie.StartsWith() = %v, want %v", got, tt.want)
			}
		})
	}
}
