
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
    func isHappy(_ n: Int) -> Bool {
        var res = n
        var tmpSet = Set<Int>()
        while res != 1 {
            if tmpSet.contains(res) {
                return false
            }
            var tmp = 0
            tmpSet.insert(res)
            while res != 0 {
                tmp += (res % 10) * (res % 10)
                res /= 10
            }
            res = tmp;
        }
        return true
    }
}
```
##### 方法二：递归法
```swift
class Solution {
    func isHappy(_ n: Int) -> Bool {
        if n == 1 {
            return true
        }
        if n == 4 {
            return false
        }
        var res = 0
        var tmp = n
        while tmp != 0 {
            res += (tmp % 10) * (tmp % 10)
            tmp /= 10
        }
        return isHappy(res)
    }
}
```
这题的主要思路就是，所有不快乐数的数位平方和计算，最後都会进入 4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4 的循环中。只要知道这个规律，相信大家都会解出来！

## 结果:
| 方法 | 时间复杂度（T(n)） | 空间复杂度（S(n)） | 执行用时(ms) | 内存消耗(MB) |
|:-------:|:-------:|:-------:|:-------:|:-------:|
| 方法一 |   O(n)  | O(n |  76  | 20.7 |

