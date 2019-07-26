
# 202. Happy Number
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

**Example:**
```
Input: 19
Output: true
Explanation: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
```

# 202. 快乐数
编写一个算法来判断一个数是不是“快乐数”。

一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。

**示例：**
```
输入: 19
输出: true
解释: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
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

