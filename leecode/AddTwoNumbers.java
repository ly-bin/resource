/**
 * @author qb
 * @version 1.0.0
 * @description:
 * @date 2017-1-23 16:14
 */
public class AddTwoNumbers {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode origin = new ListNode(0);
        ListNode node = origin;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (carry != 0)
                sum += carry;
            carry = sum / 10;
            node.next = new ListNode(sum % 10);
            node = node.next;
        }
        if (carry != 0) {
            node.next = new ListNode(carry);
        }
        return origin.next;
    }
}
