import java.util.List;

public class LinkedListAddition {
    /*
    * As part of a startup, we are building a financial application that requires adding two non-negative numbers
    * represented as linked lists. The two linked lists are non-empty and represent the digits of each number in
    * reverse order. We need you to write a function that takes in these two linked lists and returns their sum as
    * another linked list in the same format.
    *
    * Example 1:
    *   l1: 2 -> 4 -> 3
    *   l2: 5 -> 6 -> 4
    *   Output: 7 -> 0 -> 8
    *   Explanation: 342 + 465 = 807
    *
    * Example 2:
    *   l1: 9 -> 9 -> 9 -> 9
    *   l2: 9 -> 9 -> 9
    *   Output: 8 -> 9 -> 9 -> 0 -> 1
    *   Explanation: 9999 + 999 = 10998
    *
    * */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        int carry = 0;
        while(l1 != null || l2 != null){

            int x = (l1 == null) ? 0 : l1.val;
            int y = (l2 == null) ? 0: l2.val;

            int sum = carry + x + y;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;

            if(l1 !=null){
                l1 = l1.next;
            }

            if(l2 != null){
                l2 = l2.next;
            }
        }

        if(carry != 0){
            curr.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
