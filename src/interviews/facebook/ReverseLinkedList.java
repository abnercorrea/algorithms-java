package interviews.facebook;

public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode<Integer> c = new ListNode<>(3, null);
		ListNode<Integer> b = new ListNode<>(2, c);
		ListNode<Integer> a = new ListNode<>(1, b);
		
		printLinkedList(a);
		
		//a = reverseLinkedList(a);
		reverseLinkedList(a, null);
		
		printLinkedList(c);
	}

	public static <T> ListNode<T> reverseLinkedList(ListNode<T> list) {
		ListNode<T> prior = null, next = null;
		
		while (list != null) {
			next = list.next;
			list.next = prior;
			prior = list;
			list = next;
		}
		
		return prior;
	}

	public static <T> void reverseLinkedList(ListNode<T> list, ListNode<T> prior) {
		if (list == null)
			return;
		
		reverseLinkedList(list.next, list);
		
		list.next = prior;
	}

	private static <T> void printLinkedList(ListNode<T> head) {
		if (head == null) {
			System.out.println();

			return;
		}
		
		System.out.print(head.value);
		
		if (head.next != null)
			System.out.print("->");
		
		printLinkedList(head.next);
	}

	static class ListNode<T> {
		T value;
		
		ListNode<T> next;
		
		public ListNode(T value, ListNode<T> next) {
			this.value = value;
			this.next = next;
		}
	}
	
}
