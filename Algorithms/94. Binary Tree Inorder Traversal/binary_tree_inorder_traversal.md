
# 94. Binary Tree Inorder Traversal

Given a binary tree, return the *inorder traversal* of its nodes' values.

**Example:**
```
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
```
**Follow up:** Recursive solution is trivial, could you do it iteratively?

# 94. 二叉树的中序遍历

给定一个二叉树，返回它的 *中序* 遍历。

**示例:**
```
输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
```
**进阶:** 递归算法很简单，你可以通过迭代算法完成吗？

## 解法:
#### 方法一：递归
```swift
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public var val: Int
 *     public var left: TreeNode?
 *     public var right: TreeNode?
 *     public init(_ val: Int) {
 *         self.val = val
 *         self.left = nil
 *         self.right = nil
 *     }
 * }
 */

class Solution {
    var res = [Int]()
    func inorderTraversal(_ root: TreeNode?) -> [Int] {
        guard root != nil else { return [] }
        inorderTraversal(root!.left)
        res.append(root!.val)
        inorderTraversal(root!.right)
        return res
    }
}
```
> 如果不清楚 [递归](https://zh.wikipedia.org/wiki/%E9%80%92%E5%BD%92) 的定义或者对递归还有疑问的童鞋可以看看 [彻底理解递归，从递归的本质说起！](https://blog.csdn.net/allenchenhh133/article/details/80291252) 这篇文章。
#### 方法二 ：迭代法
```swift
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public var val: Int
 *     public var left: TreeNode?
 *     public var right: TreeNode?
 *     public init(_ val: Int) {
 *         self.val = val
 *         self.left = nil
 *         self.right = nil
 *     }
 * }
 */

class Solution {
    func inorderTraversal(_ root: TreeNode?) -> [Int] {
        guard root != nil else { return [] }
        var res = [Int]()
        var currentNode = root
        var nodeStack = [TreeNode]()
        while !nodeStack.isEmpty || currentNode != nil {
            if currentNode != nil {
                nodeStack.append(currentNode!)
                currentNode = currentNode?.left
            } else {
                let tmp = nodeStack.popLast()
                res.append(tmp!.val)
                currentNode = tmp!.right
            }
        }
        return res
    }
}
```

这里的迭代法我来说一下流程，加入我们输入的 root 如下：
```
          1
        /   \
       2     3
      / \   /
     4   5 6
```
那么根据判断条件 currentNode 和 nodeStack 只要有一个不为空就继续循环，此时 currentNode 不为空，第一次循环结束 `nodeStack = [1], currentNode = 2` ，继续循环 1，2，4，当 currentNode 为空时可知此时 `nodeStack = [1, 2, 4]` 则进入 else 的循环，进入以后 `tmp = 4, nodeStack = [1, 2]` 继续循环，过程如下：

##### 1：进入 if 
```
currentNode =     1
                /   \
               2     3
              / \   /
             4   5 6
             
nodeStack =           1
                    /   \
            [      2     3    ]
                  / \   /
                 4   5 6 

res = []

currentNode =  2     
              / \   
             4   5
```
##### 2：进入 if 
```
currentNode =  2     
              / \   
             4   5
             
nodeStack =           1      
                    /   \       2 
            [      2     3 ,   / \       ]
                  / \   /     4   5
                 4   5 6 
                 
res = []

currentNode = 4
```
##### 3：进入 if 
```
currentNode = 4

nodeStack =           1      
                    /   \       2 
            [      2     3 ,   / \  , 4     ]
                  / \   /     4   5
                 4   5 6 
                 
res = []

currentNode = nil
```
##### 4：进入 else 
```
currentNode = nil

tmp = 4

nodeStack =           1      
                    /   \       2 
            [      2     3 ,   / \       ]
                  / \   /     4   5
                 4   5 6 

res = [4]

currentNode = nil
```
##### 5：进入 else
```
currentNode = nil

tmp =  2     
      / \   
     4   5

nodeStack =           1
                    /   \
            [      2     3    ]
                  / \   /
                 4   5 6 
                 
res = [4, 2]

currentNode = 5
```
##### 6：进入 if 
```
currentNode = 5

nodeStack =           1
                    /   \
            [      2     3 , 5   ]
                  / \   /
                 4   5 6 
                 
res = [4, 2]

currentNode = nil
```
##### 7：进入 else 
```
currentNode = nil

tmp = 5

nodeStack =           1
                    /   \
            [      2     3    ]
                  / \   /
                 4   5 6 
                 
res = [4, 2, 5]

currentNode = nil
```
##### 8：进入 else 
```
currentNode = nil

tmp =     1
        /   \
       2     3
      / \   /
     4   5 6

nodeStack = []
                 
res = [4, 2, 5, 1]

currentNode =    3
               /
              6
```
##### 9：进入 if  
```
currentNode =    3
               /
              6

nodeStack =      3
             [  /   ]
               6
                 
res = [4, 2, 5, 1]

currentNode = 6
```
##### 10：进入 if 
```
currentNode = 6

nodeStack =      3
             [  /  , 6  ]
               6
                 
res = [4, 2, 5, 1]

currentNode = nil
```
##### 11：进入 else  
```
currentNode = nil

tmp = 6

nodeStack =      3
             [  /   ]
               6
                 
res = [4, 2, 5, 1, 6]

currentNode = nil
```
##### 12：进入 else  
```
currentNode = nil

nodeStack =  3
            /   
           6

nodeStack = []
                 
res = [4, 2, 5, 1, 6, 3]

currentNode = nil
```
到这里就结束了，这里详细列出了整个过程，希望大家了解这种迭代法。


#### 方法三 ：莫里斯遍历 (Morris Traversal)（LeetCode 上官方的一中解法）
```swift
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public var val: Int
 *     public var left: TreeNode?
 *     public var right: TreeNode?
 *     public init(_ val: Int) {
 *         self.val = val
 *         self.left = nil
 *         self.right = nil
 *     }
 * }
 */
class Solution {
    func inorderTraversal(_ root: TreeNode?) -> [Int] {
        guard root != nil else { return [] }
        var res = [Int]()
        var currentNode = root
        var pre: TreeNode?
        while currentNode != nil {
            if currentNode!.left == nil {
                res.append(currentNode!.val)
                currentNode = currentNode!.right
            } else {
                pre = currentNode!.left
                while pre?.right != nil {
                    pre = pre?.right
                }
                pre?.right = currentNode
                let tmp = currentNode
                currentNode = currentNode?.left
                tmp?.left = nil
            }
        }
        return res
    }
}
```
> 关于莫里斯方法可以看看 [莫里斯方法解析](https://stackoverflow.com/questions/5502916/explain-morris-inorder-tree-traversal-without-using-stacks-or-recursion)，主要方法就是
>
> 1: 将当前节点 current 初始化为根节点
>
> 2: While current 不为空，
>
```
若current没有左子节点

    a. 将current添加到输出

    b. 进入右子树，亦即, current = current.right

否则

    a. 在current的左子树中，令current成为最右侧节点的右子节点

    b. 进入左子树，亦即，current = current.left

```
[线索二叉树](https://baike.baidu.com/item/%E7%BA%BF%E7%B4%A2%E4%BA%8C%E5%8F%89%E6%A0%91/10810037)
## 结果:
| 方法 | 时间复杂度（T(n)） | 空间复杂度（S(n)） | 执行用时(ms) | 内存消耗(MB) |
|:-------:|:-------:|:-------:|:-------:|:-------:|
| 方法一 |   O(n)  | O(n) |  8  | 21 |
| 方法二 |   O(n)  | O(n) |  12  | 20.4 |
| 方法三 |   O(n)  | O(n) |  12  | 20.5 |
