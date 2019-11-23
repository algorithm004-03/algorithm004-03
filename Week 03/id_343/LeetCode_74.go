func searchMatrix(matrix [][]int, target int) bool {
    for _, v := range matrix {
        if len(v) == 0 {
            return false
        }
        if target == v[0] || target == v[len(v)-1] {
            return true
        }
        if target < v[len(v)-1] {
            return s(v, target)
        }
    }
    
    return false
}

func s(arr []int, target int) bool {
    l := len(arr)
    if l == 0 {
        return false
    }
    if l == 1 {
        return arr[0] == target
    }
    
    middle := (len(arr)-1)/2
    if arr[middle] > target {
        return s(arr[:middle], target)
    } else if (arr[middle] < target) {
        return s(arr[middle+1:], target)
    } else {
        return true
    }
}
