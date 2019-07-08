
# 94. Binary Tree Inorder Traversal

Given a binary tree, return the *inorder traversal* of its nodes' values.

**Example:**
```
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
```
**Follow up:** Recursive solution is trivial, could you do it iteratively?
# 69. x 的平方根
实现 `int sqrt(int x)` 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

**示例 1:**
```
输入: 4
输出: 2
```
**示例 2:**
```
输入: 8
输出: 2
说明: 8 的平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
```
## 解法:
##### 方法一：内置函数法
```swift
func mySqrt(_ x: Int) -> Int {
    return Int(sqrt(Double(x)))
}
```
##### 方法二 ：二分法
```swift
func mySqrt(_ x: Int) -> Int {
    if x == 0 {
        return 0
    }
    var left = 0
    var right = x / 2 + 1//开平方以后的值肯定小于 x / 2 + 1
    var mid = 0
    var res = 0

    while left <= right {
        mid = (left + right) / 2
        res = mid * mid
        if res == x {
            return mid
        } else if res > x {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return right
}
```
##### 方法三 ：牛顿迭代法（牛顿-拉弗森方法）
```swift
func mySqrt(_ x: Int) -> Int {
    if x == 0 {
        return 0
    }
    var res = x
    while res * res > x {
       res = (res + x / res) / 2
    }
    return res
}
```
> 对于牛顿迭代法先前也是不了解，看到别人的解法中有这么一个觉得思路还是蛮好的，想了解的同学可以看看知乎上[如何通俗易懂地讲解牛顿迭代法求开方？数值分析？](https://www.zhihu.com/question/20690553/answer/146104283)这个回答，讲的还是很详细的。

## 结果:
| 方法 | 时间复杂度（T(n)） | 空间复杂度（S(n)） | 执行用时(ms) | 内存消耗(MB) |
|:-------:|:-------:|:-------:|:-------:|:-------:|
| 方法一 |   O(1)  | O(1) |  16  | 20.2 |
| 方法二 | O(logn) | O(1) |  16  | 20.4 |
| 方法三 |    -    | O(1) |  20  | 20.7 |
