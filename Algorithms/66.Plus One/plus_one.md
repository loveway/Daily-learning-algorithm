
# 66. Plus One
Given a **non-empty** array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

**Example 1:**
```
Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
```
**Example 2:**
```
Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
```
# 66. 加一
给定一个由**整数**组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

**示例 1:**
```
输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
```
**示例 2:**
```
输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。
```
## 解法:
##### 方法一：
```swift
func plusOne(_ digits: [Int]) -> [Int] {
    
    let length = digits.count
    var add = 0
    var res: [Int] = []
    for i in stride(from: length - 1, through: 0, by: -1) {//index 倒序循环
        var num = digits[i]
        if i == length - 1 {
            num += 1//如果是数组最后一个元素直接 +1
        } else {
            num += add//不是最后一位直接加上这个 add
        }
        add = 0//这儿注意需要将 add 置为 0
        if num == 10 {//如果元素 +1 后为 10，也就是元素为 9 ，则将这个元素置为 0 ，然后 add == 1，继续下一次循环（也就是继续向前循环）
            num = 0
            add = 1
        }
        res.append(num)
    }
    res.reverse()//因为之前是倒序，所以这里需要 reverse 一下
    if add == 1 {//如果循环结束，add 仍然为 1，说明数组第一位为 9 ，则需要把第一位置为 0 同时在首位插入 1（进入这个逻辑则说明原数组 digits 是[9]、[9, 9]、[9, 9, 9] 元素全是 9 这样的数组）
        res.insert(1, at: 0)
    }
    return res
}
```
##### 方法二（简洁）：
```swift
func plusOne(_ digits: [Int]) -> [Int] {
    let length = digits.count
    var res = digits
    for i in (0..<length).reversed() {//index 倒序循环
        res[i] += 1//每一位直接 +1
        res[i] %= 10//对 10 取余
        if res[i] != 0 {//+1 后如果能不能被 10 整除，说明这一位不是 9，则 +1 后直接返回 res。如果能被 10 整除说明还需要向前循环一次
            return res
        }
    }
    res.insert(1, at: 0)//如果循环完毕还没有返回 res，说明原数组 digits 是[9]、[9, 9]、[9, 9, 9] 元素全是 9 这样的数组，则需要把第一位置为 0 同时在首位插入 1，改变元素组个数
    return res
}
```

## 结果:
| 方法 | 时间复杂度（T(n)） | 空间复杂度（S(n)） | 执行用时(ms) | 内存消耗(MB) |
|:-------:|:-------:|:-------:|:-------:|:-------:|
| 方法一 | O(n) | O(n) |  8   | 20.6 |
| 方法二 | O(n) | O(n) |  24  | 20.3 |
