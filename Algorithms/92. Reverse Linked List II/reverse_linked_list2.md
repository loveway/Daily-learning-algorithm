
# 92. Reverse Linked List II
Reverse a linked list from position *m* to *n*. Do it in one-pass.

**note:** 1 ≤ *m* ≤ *n* ≤ length of list.

**Example:**
```
Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
```

# 92. 反转链表 II
反转从位置 *m* 到 *n* 的链表。请使用一趟扫描完成反转

**说明：** 1 ≤ *m* ≤ *n* ≤ 链表长度。

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

