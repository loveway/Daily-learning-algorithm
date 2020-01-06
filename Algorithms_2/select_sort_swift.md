# Swift 实现选择排序
方法如下

```swift
func selectSort(_ array: Array<Int>) -> Array<Int> {
    
    var selectArray = array
    for i in 0 ..< selectArray.count - 1 {
        var min = i
        for j in i + 1 ..< selectArray.count {

            if selectArray[j] < selectArray[min] {
                min = j
            }
        }
        if i != min {
            selectArray.swapAt(i, min)
        }
    }
    return selectArray
}

var array = [1, 3, 45, 56, 7, 2, 9, 32, 4]
print(selectSort(array))
```

输出

```swift
[1, 2, 3, 4, 7, 9, 32, 45, 56]
```

空间复杂度 O（n），时间复杂度 O（n²）