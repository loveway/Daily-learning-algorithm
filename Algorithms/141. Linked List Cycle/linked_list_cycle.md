
# 141. Linked List Cycle
Given a linked list, determine if it has a cycle in it.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If `pos` is `-1`, then there is no cycle in the linked list.

**Example 1:**
```
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the second node.
```
![](https://github.com/loveway/Daily-learning-algorithm/blob/master/Algorithms/141.%20Linked%20List%20Cycle/image/circularlinkedlist.png?raw=true)

**Example 2:**
```
Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the first node.
```
![](https://github.com/loveway/Daily-learning-algorithm/blob/master/Algorithms/141.%20Linked%20List%20Cycle/image/circularlinkedlist_test2.png?raw=true)


**Example 3:**
```
Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
```
![](https://github.com/loveway/Daily-learning-algorithm/blob/master/Algorithms/141.%20Linked%20List%20Cycle/image/circularlinkedlist_test3.png?raw=true)

**Follow up:** 
Can you solve it using *O(1)* (i.e. constant) memory?

# 92. 反转链表 II
反转从位置 *m* 到 *n* 的链表。请使用一趟扫描完成反转

**说明：** 1 ≤ m ≤ n ≤ 链表长度。

**示例：**
```
输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL
```

## 解法:
##### 方法一：
```swift
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public var val: Int
 *     public var next: ListNode?
 *     public init(_ val: Int) {
 *         self.val = val
 *         self.next = nil
 *     }
 * }
 */
class Solution {
    func reverseBetween(_ head: ListNode?, _ m: Int, _ n: Int) -> ListNode? {
        if head == nil || m > n {
            return nil
        }
        let res = ListNode(0)
        res.next = head
        var pre: ListNode? = res
        for _ in 0..<(m - 1) {
            pre = pre?.next
        }
        var current = pre?.next
        var mid: ListNode?
        for _ in 0...(n-m) {
            let tmp = current?.next
            current?.next = mid
            mid = current
            current = tmp
        }
        pre?.next?.next = current
        pre?.next = mid
        return res.next
    }
}
```
和直接反转链表相比主要就是要找到反转位置的前一个节点。
## 结果:
| 方法 | 时间复杂度（T(n)） | 空间复杂度（S(n)） | 执行用时(ms) | 内存消耗(MB) |
|:-------:|:-------:|:-------:|:-------:|:-------:|
| 方法一 |   O(n)  | O(1) |  20  | 20.43|

