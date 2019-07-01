
# 1. Two Sum
Given an array of integers, return **indices** of the two numbers such that they add up to a specific target.

You may assume that each input would have *exactly* one solution, and you may not use the same element twice.

**Example:**
```
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```
# 1. 两数之和
给定一个整数数组 `nums` 和一个目标值 `target`，请你在该数组中找出和为目标值的那**两个整数**，并返回他们的数组**下标**。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。


**示例:**
```
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```

## 解法:
##### 方法一：暴力破解法
```swift
func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
    if nums.count < 2 {
        return[]
    }
    for i in 0..<nums.count {
        for j in (i+1)..<nums.count {
            if nums[i] + nums[j] == target {
                return[i, j]
            }
        }
    }
    return []
}
```
##### 方法二：哈希表
```swift
func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
    if nums.count < 2 {
        return []
    }
    var tmpDic = [Int:Int]()
    for i in 0..<nums.count {
        let a = target - nums[i]
        if tmpDic.keys.contains(a) {
            return [i, tmpDic[a]!]
        }
        tmpDic[nums[i]] = i
    }
    return []
}
```
此外还有一种优化后时间更短的解法
##### 方法三：哈希表
```swift
func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
    if nums.count < 2 {
        return[]
    }
    var tmpDic = [Int: Int]()
    for (i, num) in nums.enumerated() {
        if let j = tmpDic[target - num] {
            return [j, i]
        }
        tmpDic[num] = i
    }
    return []
}
```
## 结果:
|方法| 时间复杂度 | 空间复杂度 | 执行用时(ms) | 内存消耗(MB) |
|:-------:|:-------:|:-------:|:-------:|:-------:|
| 方法一 | O(n2)| O(1) | 756 | 21.3 |
| 方法二 | O(n) | O(n) | 80  | 22.5 |
| 方法三 | O(n) | O(n) | 52  | 21.4 |