#### 1、删除链表的倒数第N个节点（中等）
> 1、描述：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/

> 2、时间复杂度：O（n）,n为链表长度

> 3、空间复杂度：：O(1),只使用三个变量

> 4、思路：
>> 1、常规思路：先遍历确认列表长度m，再遍历一次找到m-n处的节点进行删除，时间复杂度也是O（n）,只是会多一次遍历（遍历的节点数为n）。

>> 2、一次遍历：双引用，先遍历链表的n个节点，移动单应用，即保证两个引用相距n个节点，这时再进行遍历，移动双引用，直到第一个移动的引用为空，此时第二个引用就是要删除的节点，

```
public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        ListNode itor = head;
        ListNode second = head;
        for (int i = 0; i < n; i++) {
            second = second.next;
            // 题目中假定给的n都是有效的，如果没有这个条件，可使用下面这个条件判断参数问题
//            if (second == null){
//                throw new RuntimeException("参数有误");
//            }
        }
        // 保存被删除节点的上一个节点
        ListNode delBeforNode = null;
        while (second != null) {
            second = second.next;
            delBeforNode = itor;
            itor = itor.next;
        }
        // 如果被删除节点的上一个节点为空，则证明删除的是头节点
        if (delBeforNode == null) {
            return head.next;
        }
        delBeforNode.next = itor.next;
        itor.next = null;
        return head;
    }
```
