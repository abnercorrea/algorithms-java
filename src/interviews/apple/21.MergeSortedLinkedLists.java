/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Analysis

The key to solve the problem is defining a fake head. Then compare the first elements from each list. Add the smaller one to the merged list. Finally, when one of them is empty, simply append it to the merged list, since it is already sorted.
*/

public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode p=head;
 
    ListNode p1=l1;
    ListNode p2=l2;
    while(p1!=null && p2!=null){
        if(p1.val < p2.val){
            p.next = p1;
            p1 = p1.next;
        }else{
            p.next = p2;
            p2 = p2.next;
        }
        p=p.next;
    }
 
    if(p1!=null){
        p.next = p1;
    }
 
    if(p2!=null){
        p.next = p2;
    }
 
    return head.next;
}
