
# 83. Remove Duplicates from Sorted List
Given a sorted linked list, delete all duplicates such that each element appear only *once*.

**Example 1:**
```
Input: 1->1->2
Output: 1->2
```

**Example 2:**
```
Input: 1->1->2->3->3
Output: 1->2->3
```

# 83. 删除排序链表中的重复元素
给定一个排序链表，删除所有重复的元素，使得每个元素只出现*一次*。

**示例 1:**
```
输入: 1->1->2
输出: 1->2
```
**示例 2:**
```
输入: 1->1->2->3->3
输出: 1->2->3
```

## 解法:
##### 方法一：双指针暴力循环
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
    func deleteDuplicates(_ head: ListNode?) -> ListNode? {
        let tmp: ListNode? = ListNode(0)
        tmp?.next = head
        var fast = tmp
        var current = tmp
        while current != nil {
            current = current?.next
            fast = current
            while fast?.next != nil {
                if fast?.next?.val == current?.val {
                    fast?.next = fast?.next?.next
                } else {
                    fast = fast?.next
                }
            }
        }
        return tmp?.next
    }
}
```
这种方法是比较暴力的，如果是 [1, 1, 2, 1, 3] 这样的链表这个方法是可行的，但是由于题目给定的是排序链表，所以这个方法太耗时了，不是最优解。
##### 方法二：直接判定
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
    func deleteDuplicates(_ head: ListNode?) -> ListNode? {

        var tmp = head
        while tmp != nil && tmp?.next != nil {
            if tmp?.val == tmp?.next?.val {
                tmp?.next = tmp?.next?.next
            } else {
                tmp = tmp?.next
            }
        }
        return head
    }
}
```
由于是有序数组，所以直接判定当前节点和下一个节点的 val 是否相等即可。

## 结果:
| 方法 | 时间复杂度（T(n)） | 空间复杂度（S(n)） | 执行用时(ms) | 内存消耗(MB) |
|:-------:|:-------:|:-------:|:-------:|:-------:|
| 方法一 |   O(n²)  | O(1) |  268  | 20.4 |
| 方法二 |   O(n)  | O(1) |  72  | 20.7 |
