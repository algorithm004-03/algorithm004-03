# NOTE
选择排序
运行时间：O(n^2)
示例代码：
找出数组中最小元素：
def findSmallest(arr):
    smallest = arr[0]
    smallest_index = 0
    for i in range(1, len(arr)):
        if arr[i] < smallest:
            smallest = arr[i]
            smallest_index = i
    return smallest_index

2.编写排序算法

def selectionSort(arr):
    newArry = []
    for i in range(len(arr)):
        smallest = findSmallest(arr)
        newArry.append(arr.pop(smallest)) #arr剔除一个值，newArry添加一个
    return newArry
完整运行：
def findSmallest(arr):
    smallest = arr[0]
    smallest_index = 0
    for i in range(1, len(arr)):
        if arr[i] < smallest:
            smallest = arr[i]
            smallest_index = i
    return smallest_index


def selectionSort(arr):
    newArry = []
    for i in range(len(arr)):
        smallest = findSmallest(arr)
        newArry.append(arr.pop(smallest))
    return newArry


print(selectionSort([5, 3, 6, 9, 9, 6, 9]))

  

