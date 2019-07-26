
# 217. Contains Duplicate
Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

**Example 1:**
```
Input: [1,2,3,1]
Output: true
```

**Example 2:**
```
Input: [1,2,3,4]
Output: false
```
**Example 3:**
```
Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
```

# 217. 存在重复元素
给定一个整数数组，判断是否存在重复元素。

如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。

**示例 1：**
```
输入: [1,2,3,1]
输出: true
```

**示例 2：**
```
输入: [1,2,3,4]
输出: false
```

**示例 3：**
```
输入: [1,1,1,3,3,4,3,2,4,2]
输出: true
```

## 解法:
##### 方法一：集合法
```swift
class Solution {
    func containsDuplicate(_ nums: [Int]) -> Bool {
        var saveSet = Set<Int>()
        for n in nums {
            if saveSet.contains(n) {
                return true
            }
            saveSet.insert(n)
        }
        return false
    }
}
```
##### 方法二：集合法简便写法
```swift
class Solution {
    func containsDuplicate(_ nums: [Int]) -> Bool {
        return Set(nums).count == nums.count ? false : true
    }
}
```
##### 方法三：排序法
```swift
class Solution {
    func containsDuplicate(_ nums: [Int]) -> Bool {
        if nums.count <= 1 {
            return false
        }
        var resNum = nums
        resNum.sort()
        for i in 0..<resNum.count - 1 {
            if resNum[i] == resNum[i+1] {
                return true
            }
        }
        return false
    }
}
```
其中第三种方法就是先排序，然后看相邻两个是不是有相同的，有相同的则说明是。

## 结果:
| 方法 | 时间复杂度（T(n)） | 空间复杂度（S(n)） | 执行用时(ms) | 内存消耗(MB) |
|:-------:|:-------:|:-------:|:-------:|:-------:|
| 方法一 |   O(n)  | O(n) |  288  | 21.8 |
| 方法二 |   O(1)  | O(n) |  328  | 22.1 |
| 方法三 |   O(n)  | O(1) |  252  | 21.6 |

