#### 1、环形链表II（中等）
> 1、描述：https://leetcode-cn.com/problems/linked-list-cycle-ii/

> 2、时间复杂度：O(n)，

> 3、空间复杂度：O(1)。

> 4、思路：1、该题的主要解读点是：判断有环链表的方法，如果无环，直接返回，如果判断有环，则使用双引用法，first和second节点都是从head节点开始，first每次走一步，second每次走两步，当他们初次相遇时，second节点走过的节点是first的两倍，此时将first节点从头开始，second节点不变，但是每次也变成单步走，这样便在环的第一个节点相遇。


```
public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode firstNode = head;
        ListNode secondNode = head;
        do {
            if (secondNode == null || secondNode.next == null){
                return null;
            }
            firstNode = firstNode.next;
            secondNode = secondNode.next.next;
        }while (firstNode != secondNode);
        firstNode = head;
        while (firstNode != secondNode){
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        firstNode.next = null;
        return firstNode;

    }
```
