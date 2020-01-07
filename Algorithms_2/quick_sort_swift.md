# Swift 实现快速排序
方法如下

```swift
func quick_sort(_ array: [Int]) -> [Int] {
    
    if array.count < 2 {
        return array
    }
    let pivot = array[0]
    var less: Array<Int> = []
    var greater: Array<Int> = []
    for i in 1 ... array.count - 1 {
        if array[i] <= pivot {
            less.append(array[i])
        } else {
            greater.append(array[i])
        }
    }
    return quick_sort(less) + [pivot] + quick_sort(greater)
}

var sortArray = [1, 56, 9, 3, 5, 67, 89, 123, 4, 6, 8]
print(quick_sort(sortArray))
```

输出

```swift
[1, 3, 4, 5, 6, 8, 9, 56, 67, 89, 123]
```

空间复杂度 O（log(n)），时间复杂度 O（nlogn）