package main

import "fmt"

func relativeSortArray(arr1 []int, arr2 []int) []int {
    m := make(map[int]int)
    for i := 0; i < len(arr1); i++ {
        m[arr1[i]]++
    }
    ret := make([]int, 0, len(arr1))
    for i := 0; i < len(arr2); i++ {
        for m[arr2[i]] > 0 {
            ret = append(ret, arr2[i])
            m[arr2[i]]--
        }
    }
    for i := 0; i <= 1000; i++ {
        for m[i] > 0 {
            ret = append(ret, i)
            m[i]--
        }
    }
    return ret
}

func main()  {
    arr1  := []int{2,3,1,3,2,4,6,7,9,2,19}
    arr2  := []int{2,1,4,3,9,6}
    fmt.Println(relativeSortArray(arr1,arr2))
}