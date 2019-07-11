
# 206. Reverse Linked List
Reverse a singly linked list.

**Example:**
```
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
```
**Follow up:**
A linked list can be reversed either iteratively or recursively. Could you implement both?


# 206. 反转链表
反转一个单链表。

**示例:**
```
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
```
**进阶:**
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

## 解法:
##### 方法一：迭代
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
    func reverseList(_ head: ListNode?) -> ListNode? {
        var pre: ListNode?
        var current = head
        while current != nil {
            let tmp = current?.next
            current?.next = pre
            pre = current
            current = tmp
        }
        return pre
    }
}
```
##### 方法二：递归
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
    func reverseList(_ head: ListNode?) -> ListNode? {

        if head == nil || head?.next == nil {
            return head
        }
        return reverse(head, head, head?.next)
    }
    
    func reverse(_ res: ListNode? ,_ first: ListNode? ,_ current: ListNode?) -> ListNode? {
        if current == nil {
            return res
        }
        first?.next = current?.next
        let tmp = current?.next
        current?.next = first
        return reverse(current, first, tmp)
    }
}
```

## 结果:
| 方法 | 时间复杂度（T(n)） | 空间复杂度（S(n)） | 执行用时(ms) | 内存消耗(MB) |
|:-------:|:-------:|:-------:|:-------:|:-------:|
| 方法一 |   O(n)  | O(1) |  40  | 21.4 |
| 方法二 |   O(n)  | O(n) |  36  | 22.3 |
