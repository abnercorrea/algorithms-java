package interviews.facebook;


public class PrintReversedLinkedList {

	public static void main(String[] args) {
		ListNode E = new ListNode(5, null);
		ListNode D = new ListNode(4, E);
		ListNode C = new ListNode(3, D);
		ListNode B = new ListNode(2, C);
		ListNode A = new ListNode(1, B);

		printReversedLinkedList(A);
		System.out.println();
		printReversedLinkedList(C);
	}

	public static void printReversedLinkedList(ListNode head) {
		if (head == null) {
			return;
		}
		
		printReversedLinkedList(head.next);
		
		System.out.print(head.value + " -> ");
	}
	
	static class ListNode {
		int value;
		
		ListNode next;
		
		public ListNode(int value, ListNode next) {
			this.value = value;
			this.next = next;
		}
	}
}
