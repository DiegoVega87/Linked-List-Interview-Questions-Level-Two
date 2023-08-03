import java.util.List;

public class ReorderLinkedList {

    /*
    * Our startup is designing a fitness tracking app that records users' daily workouts. We need to group all the daily
    * workout data in a linked list. However, we want to reorder the linked list by first listing all the workout data
    * with odd indices and then the workout data with even indices. Can you help us design a function that takes the
    * head of the linked list as input and returns the reordered linked list? The first workout data will be considered
    * odd, the second even, the third odd continuing with the same pattern...
    *
    *
    * Example 1:
    *   Input: 1 -> 2 -> 3 -> 4 -> 5
    *   Output: 1 -> 3 -> 5 -> 2 -> 4
    *   Explanation: The odd-indexed nodes are [1,3,5] and the even-indexed nodes are [2,4]. We reorder the list by
    *   listing all the odd-indexed nodes first, followed by the even-indexed nodes.
    *
    * Example 2:
    *   Input: 2 -> 1 -> 3 -> 5 -> 6 -> 4 -> 7
    *   Output: 2 -> 3 -> 6 -> 7 -> 1 -> 5 -> 4
    *   Explanation: Explanation: The odd-indexed nodes are [2,3,6,7,1,5] and the even-indexed nodes are [1,5,4].
    *   We reorder the list by listing all the odd-indexed nodes first, followed by the even-indexed nodes.
     * */

    public ListNode reorderList(ListNode head){

        // If head is null or there is only one node, return it.
        if(head == null || head.next == null){
            return head;
        }

        // Separate the list into even and odd halves.
        ListNode evenHead = head.next;
        ListNode oddCurr = head;
        ListNode evenCurr = evenHead;

        // Connect the nodes with their corresponding halves.
        while(evenCurr != null && evenCurr.next != null){

            oddCurr.next = evenCurr.next;
            oddCurr = oddCurr.next;

            evenCurr.next = oddCurr.next;
            evenCurr = evenCurr.next;
        }

        // merge the halves.
        oddCurr.next = evenHead;

        return head;
    }
}
