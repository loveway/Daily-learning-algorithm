
# 35. Search Insert Position
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

**Example 1:**
```
Input: [1,3,5,6], 5
Output: 2
```
**Example 2:**
```
Input: [1,3,5,6], 2
Output: 1
```
**Example 3:**
```
Input: [1,3,5,6], 7
Output: 4
```
**Example 4:**
```
Input: [1,3,5,6], 0
Output: 0
```
# 35. 搜索插入位置
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

**示例 1:**
```
输入: [1,3,5,6], 5
输出: 2
```
**示例 2:**
```
输入: [1,3,5,6], 2
输出: 1
```
**示例 3:**
```
输入: [1,3,5,6], 7
输出: 4
```
**示例 4:**
```
输入: [1,3,5,6], 0
输出: 0
```
## 解法:
##### 方法一：暴力循环
```swift
func searchInsert(_ nums: [Int], _ target: Int) -> Int {
    if nums.count == 0 {
        return 0
    }
    for i in 0..<nums.count {
        if  nums[i] >= target  {//直接循环，如果 nums[i] >= target 说明 target 就在应该在 i 这个位置，直接返回 i
            return i
        }
    }
    return nums.count//如果循环完毕仍然没有返回结果，说明 target 应该插在最后，对应的 index 就是 nums.count
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
