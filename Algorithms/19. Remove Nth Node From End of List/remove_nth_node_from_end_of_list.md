
# 19. Remove Nth Node From End of List
Given a linked list, remove the *n*-th node from the end of list and return its head.

**Example:**
```
Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
```

**Note:**
* Given *n* will always be valid.

**Follow up:**
* Could you do this in one pass?

# 19. 删除链表的倒数第N个节点
给定一个链表，删除链表的倒数第 *n* 个节点，并且返回链表的头结点。

**示例:**
```
给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
```
**说明：**
* 给定的 *n* 保证是有效的。

**进阶：**
* 你能尝试使用一趟扫描实现吗？


## 解法:
##### 方法一：两次遍历
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
    func removeNthFromEnd(_ head: ListNode?, _ n: Int) -> ListNode? {
        
        var tmp: ListNode? = ListNode(0)
        tmp?.next = head
        var len = 0
        var current = head
        while current != nil {
            len += 1
            current = current?.next
        }
        len -= n
        current = tmp
        while len > 0 {
            current = current?.next
            len -= 1
        }
        current?.next = current?.next?.next
        return tmp?.next
    }
}
```
这种方法是先找到链表的节点数 length，然后 length - n 就是要删除的节点位置，时间复杂度是 O(leng)。
##### 方法二：双指针法
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
    func removeNthFromEnd(_ head: ListNode?, _ n: Int) -> ListNode? {

        var tmp: ListNode? = ListNode(0)
        tmp?.next = head
        var fast = tmp
        var slow = tmp
        for i in 0...n {
            fast = fast?.next
        }
        while fast != nil {
            slow = slow?.next
            fast = fast?.next
        }
        slow?.next = slow?.next?.next
        return tmp?.next
    }
}
```
这种方法是先让一个指针走 n 步，然后慢指针和快指针一起走，直到快指针走到最后，因为快慢指针之间的长度是 n ，所以慢指针所在的位置的下一个就是要删除的。使用 [LeetCode 上的一个解法](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/dong-hua-tu-jie-leetcode-di-19-hao-wen-ti-shan-chu/) 如下图详细说明

![](https://github.com/loveway/Daily-learning-algorithm/blob/master/Algorithms/19.%20Remove%20Nth%20Node%20From%20End%20of%20List/image/19_anwser.gif?raw=true)


## 结果:
| 方法 | 时间复杂度（T(n)） | 空间复杂度（S(n)） | 执行用时(ms) | 内存消耗(MB) |
|:-------:|:-------:|:-------:|:-------:|:-------:|
| 方法一 |   O(n)  | O(1) |  20  | 20.8 |
| 方法二 |   O(n)  | O(1) |  8  | 20.3 |
