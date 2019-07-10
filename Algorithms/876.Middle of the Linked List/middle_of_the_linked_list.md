
# 876. Middle of the Linked List
Given a non-empty, singly linked list with head node `head`, return a middle node of linked list.

If there are two middle nodes, return the second middle node.



**Example 1:**
```
Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
```
**Example 2:**
```
Input: [1,2,3,4,5,6]
Output: Node 4 from this list (Serialization: [4,5,6])
Since the list has two middle nodes with values 3 and 4, we return the second one.
```
**Note:**
* The number of nodes in the given list will be between `1` and `100`.

# 876. 链表的中间结点
给定一个带有头结点 `head` 的非空单链表，返回链表的中间结点。

如果有两个中间结点，则返回第二个中间结点。

**示例 1:**
```
输入：[1,2,3,4,5]
输出：此列表中的结点 3 (序列化形式：[3,4,5])
返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
注意，我们返回了一个 ListNode 类型的对象 ans，这样：
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
```
**示例 2:**
```
输入：[1,2,3,4,5,6]
输出：此列表中的结点 4 (序列化形式：[4,5,6])
由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
```
**提示：**
* 给定链表的结点数介于 `1` 和 `100` 之间。


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
