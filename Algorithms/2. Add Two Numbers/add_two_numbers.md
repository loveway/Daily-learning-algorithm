
# 2. Add Two Numbers
You are given two **non-empty** linked lists representing two non-negative integers. The digits are stored in **reverse order** and each of their nodes contain **a single digit**. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

**Example:**
```
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
```

# 2. 两数相加
给出两个 **非空** 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 **逆序** 的方式存储的，并且它们的每个节点只能存储 **一位** 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。


**示例：**
```
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
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
    func addTwoNumbers(_ l1: ListNode?, _ l2: ListNode?) -> ListNode? {
        var ll1 = l1, ll2 = l2;
        var res: ListNode? = ListNode(0)
        let pre = res
        var tmp = 0
        while ll1 != nil || ll2 != nil  {
            let x: Int = ll1 == nil ? 0 : ll1!.val
            let y: Int = ll2 == nil ? 0 : ll2!.val
            var sum = x + y + tmp
            tmp = sum / 10
            sum %= 10
            let mid = ListNode(sum)
            res?.next = mid
            res = mid
            ll1 = ll1?.next
            ll2 = ll2?.next
        }
        if tmp == 1 {
            let last = ListNode(1)
            res?.next = last
        }
        return pre?.next
    }
}
```
由题意可知，我们需要将链表中的每一位数相加然后向后进一位即可，即代码中的 `tmp` 这个变量，表示是不是需要向后进位，还需要注意的是 `sum = x + y + tmp` 来判断需不需要 `+1`，最后如果循环完毕 tmp 仍然为 1 ，说明需要增加一个新的节点来存储这个进位如下面这种情况
```
l1: [1, 9]
l2: [2, 1]
putput: [3, 0, 1]
```

## 结果:
| 方法 | 时间复杂度（T(n)） | 空间复杂度（S(n)） | 执行用时(ms) | 内存消耗(MB) |
|:-------:|:-------:|:-------:|:-------:|:-------:|
| 方法一 |   O(n)  | O(n |  76  | 20.7 |

