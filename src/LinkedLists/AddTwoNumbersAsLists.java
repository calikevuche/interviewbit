package LinkedLists;

/**
 * Created by OlehKa on 23.09.2016.
 */
public class AddTwoNumbersAsLists {

    public ListNode addTwoNumbers1(ListNode a, ListNode b) {
        int carry, value;
        carry = (a.val + b.val) / 10;
        value = (a.val + b.val) % 10;
        ListNode result = new ListNode(value);
        ListNode head = result;
        a = a.next;
        b = b.next;
        while (a != null && b != null) {
            value = (carry + a.val + b.val) % 10;
            carry = (carry + a.val + b.val) / 10;
            result.next = new ListNode(value);
            result = result.next;
            a = a.next;
            b = b.next;
        }
        if (a != null) {
            if (carry != 0) {
                while (a != null) {
                    value = (carry + a.val) % 10;
                    carry = (carry + a.val) / 10;
                    result.next = new ListNode(value);
                    result = result.next;
                    a = a.next;
                }
                if (carry != 0) {
                    result.next = new ListNode(carry);
                }
            } else {
                result.next = a;
            }
        } else {
            if (carry != 0) {
                while (b != null) {
                    value = (carry + b.val) % 10;
                    carry = (carry + b.val) / 10;
                    result.next = new ListNode(value);
                    result = result.next;
                    b = b.next;
                }
                if (carry != 0) {
                    result.next = new ListNode(carry);
                }
            } else {
                result.next = b;
            }
        }
        return head;
    }

    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        int carry, value;
        carry = (a.val + b.val) / 10;
        value = (a.val + b.val) % 10;
        ListNode result = new ListNode(value);
        ListNode head = result;
        a = a.next;
        b = b.next;
        while (a != null || b != null || carry != 0) {
            int sum = (a != null ? a.val : 0) + (b != null ? b.val : 0) + carry;
            value = sum % 10;
            carry = sum / 10;
            result.next = new ListNode(value);
            result = result.next;
            if (a != null) a = a.next;
            if (b != null) b = b.next;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
