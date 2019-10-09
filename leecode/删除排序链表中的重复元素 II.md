#### 1、删除排序链表中的重复元素 II（中等）
> 1、描述：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/

> 2、时间复杂度：O(n)，

> 3、空间复杂度：O(1)。

> 4、思路：1、该题的主要解读点是：删除所有重复值的节点，等价于将所有不重复的节点按顺序链接即可。2、遍历链表，当前节点的值和下一个节点对比，如果不相同，则直接添加节点到结果链表中即可，如果相同，则继续遍历下第三个节点是否是和当前节点值相同，一直到不相同，continue下一次循环。

```
public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = null;
        ListNode iteNode = null;
        while (head != null){
            int val = head.val;
            // 如果当前节点和下一个节点值相同，则该节点不添加到结果链表中
            if (head.next != null && head.next.val == val){
                // 跳过当前节点自己与自己的对比
                head = head.next;
                // 跳过所有相同值的节点
                while (head != null && head.val == val){
                    head = head.next;
                }
                continue;
            }
            // 截取当前节点 head
            ListNode tempNode = head.next;
            head.next = null;
            // 设置结果链表的头节点和遍历节点
            if (newHead == null){
                newHead = head;
                iteNode = head;
            }else {
                // 添加无重复值的节点到结果链表的遍历节点
                iteNode.next = head;
                iteNode = iteNode.next;
            }
            head = tempNode;
        }
        // 返回结果链表的头节点
        return newHead;
    }
```

