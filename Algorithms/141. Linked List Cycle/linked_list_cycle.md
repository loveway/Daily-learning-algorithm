
# 141. Linked List Cycle
Given a linked list, determine if it has a cycle in it.

To represent a cycle in the given linked list, we use an integer `pos` which represents the position (0-indexed) in the linked list where tail connects to. If `pos` is `-1`, then there is no cycle in the linked list.

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

# 141. 环形链表
给定一个链表，判断链表中是否有环。

为了表示给定链表中的环，我们使用整数 `pos` 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 `pos` 是 `-1`，则在该链表中没有环。


**说明：** 1 ≤ m ≤ n ≤ 链表长度。

**示例 1：**
```
输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。
```
![](https://github.com/loveway/Daily-learning-algorithm/blob/master/Algorithms/141.%20Linked%20List%20Cycle/image/circularlinkedlist.png?raw=true)

**示例 2：**
```
输入：head = [1,2], pos = 0
输出：true
解释：链表中有一个环，其尾部连接到第一个节点。
```
![](https://github.com/loveway/Daily-learning-algorithm/blob/master/Algorithms/141.%20Linked%20List%20Cycle/image/circularlinkedlist_test2.png?raw=true)

**示例 3：**
```
输入：head = [1], pos = -1
输出：false
解释：链表中没有环。
```
![](https://github.com/loveway/Daily-learning-algorithm/blob/master/Algorithms/141.%20Linked%20List%20Cycle/image/circularlinkedlist_test3.png?raw=true)

## 解法:
##### 方法一：哈希表
```go
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func hasCycle(head *ListNode) bool {
	hash := make(map[*ListNode]int)
	for head != nil {
		if _, ok := hash[head]; ok {
			return true
		}
		hash[head] = head.Val
		head = head.Next
	}
	return false
}
```
这个方法就是遍历链表，然后比较哈希表里是否已经存在党当前便利的值，如果有则说明有环。

##### 方法二：双指针
```go
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func hasCycle(head *ListNode) bool {

	if head == nil {
		return false
	}
	fast := head.Next
	for fast != nil && head != nil && fast.Next != nil {
		if fast == head {
			return true
		}
		fast = fast.Next.Next
		head = head.Next
	}
	return false
}
```
这种解法的思路有两点：
* 如果不含有环，跑得快的那个指针最终会遇到 null，说明链表不含环。
* 如果含有环，快指针会超慢指针一圈，和慢指针相遇，说明链表含有环。

这里 [动画：使用快慢指针求解「环形链表」so easy！](https://leetcode-cn.com/problems/linked-list-cycle/solution/dong-hua-shi-yong-kuai-man-zhi-zhen-qiu-jie-huan-x/) 这个解答有个 gif 可以详细说明，如下

![](https://github.com/loveway/Daily-learning-algorithm/blob/master/Algorithms/141.%20Linked%20List%20Cycle/image/141LinkedListCycle.gif?raw=true)


##### 方法三：改值法
```go
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func hasCycle(head *ListNode) bool {

	for head != nil {
		if head.Val == 1008610010 {
			return true
		}
		head.Val = 1008610010
		head = head.Next
	}
	return false
}
```
这个方法是看见的比较有意思的解法，大家可以参考下。

## 结果:
| 方法 | 时间复杂度（T(n)） | 空间复杂度（S(n)） | 执行用时(ms) | 内存消耗(MB) |
|:-------:|:-------:|:-------:|:-------:|:-------:|
| 方法一 |   O(n)  | O(n) |  20  | 6.1|
| 方法二 |   O(n)  | O(1) |  16  | 3.8|
| 方法三 |   O(n)  | O(1) |  12  | 3.9|

