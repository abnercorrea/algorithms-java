public ListNode<T> reverseLinkedList(ListNode<T> node) {
	ListNode<T> prev = null, next = null;
	
	while (node != null) {
		next = node.next;
		node.next = prev;
		prev = node;
		node = next;
	}
	
	return prev;
}
