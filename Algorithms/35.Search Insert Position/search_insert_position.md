
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
##### 方法二 ：二分法
```swift

```

## 结果:
| 方法 | 时间复杂度（T(n)） | 空间复杂度（S(n)） | 执行用时(ms) | 内存消耗(MB) |
|:-------:|:-------:|:-------:|:-------:|:-------:|
| 方法一 | O(n) | O(1) |  48  | 21.1 |
| 方法二 | O(log(n)) | O(1) |  52  | 21.8 |
