
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
##### 方法一：哈希表
```swift
class Solution {
    func containsNearbyDuplicate(_ nums: [Int], _ k: Int) -> Bool {
        var dic: Dictionary<Int, Int> = [:]
        for (i, num) in nums.enumerated() {
            if (dic[num] != nil) {
                if abs(dic[num]! - i) <= k {
                    return true
                }
            }
            dic[num] = i
        }
        return false
    }
}
```
这题需要注意的就是题目要看清***i 和 j 的差的绝对值最大为 k***，然后用 map 很简单。

## 结果:
| 方法 | 时间复杂度（T(n)） | 空间复杂度（S(n)） | 执行用时(ms) | 内存消耗(MB) |
|:-------:|:-------:|:-------:|:-------:|:-------:|
| 方法一 |   O(n)  | O(n) |  204  | 23.5 |

