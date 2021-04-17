package leetcode;

public class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        // Caution!! if node is the last node of the list, it can't be deleted without accessing the previous node.
        // It could be made a dummy node
        if (node == null || node.next == null) return;

        node.val = node.next.val;
        node.next = node.next.next;
    }
}
