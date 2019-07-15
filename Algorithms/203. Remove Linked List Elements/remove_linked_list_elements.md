
# 203. Remove Linked List Elements
Remove all elements from a linked list of integers that have value  ***val*** .

**note:** 1 ≤ m ≤ n ≤ length of list.

**Example:**
```
Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
```

# 203. 移除链表元素
删除链表中等于给定值 ***val*** 的所有节点。

**说明：** 1 ≤ m ≤ n ≤ 链表长度。

**示例：**
```
输入: 1->2->6->3->4->5->6, val = 6
输出: 1->2->3->4->5
```

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
    func removeElements(_ head: ListNode?, _ val: Int) -> ListNode? {
        let pre = ListNode(0)
        pre.next = head;
        var current: ListNode? = pre
        while current?.next != nil {
            if current?.next?.val == val {
                current?.next = current?.next?.next
            } else {
                current = current?.next
            }
            if current?.val == val {
                current = current?.next
            }
        }
        return pre.next
    }
}
```
##### 方法二：新链表
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
    func removeElements(_ head: ListNode?, _ val: Int) -> ListNode? {
        var pre: ListNode? = ListNode(0)
        var tmp = pre
        var current = head
        while current != nil {
            if current?.val == val {
                current = current?.next
            } else {
                tmp?.next = current
                tmp = tmp?.next
                current = current?.next
            }
        }
        tmp?.next = nil//这里需要将最后一个指为 nil
        return pre?.next
    }
}
```
##### 方法三：递归
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
    func removeElements(_ head: ListNode?, _ val: Int) -> ListNode? {
        if head == nil {
            return head
        }
        head?.next = removeElements(head?.next, val)
        return head?.val == val ? head?.next : head;
    }
}
```

## 结果:
| 方法 | 时间复杂度（T(n)） | 空间复杂度（S(n)） | 执行用时(ms) | 内存消耗(MB) |
|:-------:|:-------:|:-------:|:-------:|:-------:|
| 方法一 |   O(n)  | O(n) |  104  | 22.9 |
| 方法二 |   O(n)  | O(n) |  100  | 22.3|
| 方法三 |   O(n)  | O(1) |  104  | 24.4 |
