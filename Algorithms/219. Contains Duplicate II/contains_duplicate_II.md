
# 219. Contains Duplicate II
Given an array of integers and an integer *k*, find out whether there are two distinct indices *i* and *j* in the array such that **nums[i] = nums[j]** and the **absolute** difference between *i* and *j* is at most *k*.

**Example 1:**
```
Input: nums = [1,2,3,1], k = 3
Output: true
```

**Example 2:**
```
Input: nums = [1,0,1,1], k = 1
Output: true
```

**Example 3:**
```
Input: nums = [1,2,3,1,2,3], k = 2
Output: false
```

# 219. 存在重复元素 II
给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 *i*  和 *j* ，使得 **nums [i] = nums [j]**，并且 *i* 和 *j* 的差的绝对值最大为 *k*。

**示例 1：**
```
输入: nums = [1,2,3,1], k = 3
输出: true
```

**示例 2：**
```
输入: nums = [1,0,1,1], k = 1
输出: true
```

**示例 3：**
```
输入: nums = [1,2,3,1,2,3], k = 2
输出: false
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

