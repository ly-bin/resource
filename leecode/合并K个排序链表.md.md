#### 1、合并K个排序链表（困难）
> 1、描述：https://leetcode-cn.com/problems/merge-k-sorted-lists/

> 2、时间复杂度：O（n * log(k)）,n最大为所有俩表元素之和的一半，log(k)为k个元素归并排序的时间

> 3、空间复杂度：：O(1)，只需要三个变量

> 4、思路：1、多个链表可以使用两个链表合并的方法去合并；2、合并完两个链表可以使用归并的方法去再合并已合并的链表。

```
public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0 ){
            return null;
        }
        if (lists.length == 1){
            return lists[0];
        }

        return merge(lists,0,lists.length - 1);
    }

    private static ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

  // 合并两个链表1 该方法执行速度没有方法二（网上的方法）快
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode newHead = new ListNode(0);
        ListNode iteor = newHead;
        while (l1 != null && l2 != null){
            ListNode temp;
            if (l1.val > l2.val){
                temp = l2;
                l2 = l2.next;
            }else {
                temp = l1;
                l1 = l1.next;
            }
            temp.next = null;
            iteor.next = temp;
            iteor = iteor.next;
        }
        if (l1 != null){
            iteor.next = l1;
        }
        if (l2 != null){
            iteor.next = l2;
        }
        return newHead.next;
    }
    
    // 两个链表合并方法二
    private static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
```
