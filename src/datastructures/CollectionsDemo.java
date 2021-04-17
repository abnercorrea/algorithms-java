package datastructures;

import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class CollectionsDemo {

	public static void main(String[] args) {
		// Queue
		System.out.println();
		System.out.println("QUEUE");
		System.out.println("---------------------------------------------------------------------------------");
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		
		queue.addAll(Arrays.asList(5,6,7,8,9,10,11,12,13));
		
		System.out.println("Queue: " + queue);

		System.out.println("Pool: " + queue.poll());
		System.out.println("Peek: " + queue.peek());
		System.out.println("Pool: " + queue.poll());

		System.out.println("Queue: " + queue);

		queue.retainAll(Arrays.asList(3,5,7,9,11,13));
		
		System.out.println("Queue.retainAll(Arrays.asList(3,5,7,9,11,13)): " + queue);

		queue.removeAll(Arrays.asList(11,13));
		
		System.out.println("Queue.removeAll(Arrays.asList(11,13)): " + queue);

		// Stack
		System.out.println();
		System.out.println("STACK");
		System.out.println("---------------------------------------------------------------------------------");
		
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 1; i < 50; i+= 2) {
			stack.push(i);
		}
		
		System.out.println("Stack: " + stack);
		
		System.out.println("Pop: " + stack.pop());
		System.out.println("Peek: " + stack.peek());
		System.out.println("Pop: " + stack.pop());
		
		System.out.println("Stack: " + stack);
		
		for (int i = 2; i < 50; i+= 2) {
			stack.push(i);
		}
		
		System.out.println("Stack: " + stack);
		System.out.println("Pop: " + stack.pop());

		// Deque
		System.out.println();
		System.out.println("DEQUE");
		System.out.println("---------------------------------------------------------------------------------");

		Deque<Integer> deque = new LinkedList<>();
		
		deque.push(1);
		deque.push(10);
		deque.push(100);
		deque.push(1000);
		
		System.out.println("Deque:" + deque);
		
		System.out.println("Pop: " + deque.pop());
		System.out.println("Peek first: " + deque.peekFirst());
		System.out.println("Peek last: " + deque.peekLast());
		
		System.out.println("Deque:" + deque);
		
		deque.addAll(Arrays.asList(3,5,7,9,11,13,15));
		
		System.out.println("Deque:" + deque);
		
		System.out.println("Poll first: " + deque.pollFirst());
		System.out.println("Poll last: " + deque.pollLast());
		
		System.out.println("Deque:" + deque);
		
		// PriorityQueue (Heap)
		System.out.println();
		System.out.println("PriorityQueue (Heap)");
		System.out.println("---------------------------------------------------------------------------------");
		
		LinkedList<Integer> numbers = new LinkedList<>();

		// Adds random numbers...
		populateRandomNumbers(numbers, 50, 100);
		
		PriorityQueue<Integer> heap = new PriorityQueue<>(numbers.size()); // sets initial capacity
		
		System.out.println("Numbers: " + numbers);
		
		// heap.addAll(numbers); // could be done, but requires O(n) extra space... BAD!

		// better space wise... removes from list, adds into heap
		while (!numbers.isEmpty()) {
			heap.add(numbers.removeLast()); // removes last element from list to prevent shifting
		}
		
		System.out.println("Heap: " + heap);

		int[] numbersDesc = new int[heap.size()];
		
		// HEAPSORT!!! removes from heap, adds into list. Due to heap nature, final list is ordered
		for (int i = heap.size() - 1, number = 0; !heap.isEmpty(); i--) {
			number = heap.poll();
			
			numbers.add(number); 
			numbersDesc[i] = number; // Adds from end to beginning...  descendant order
		}
		
		System.out.println("Sorted... this was HEAPSORT in action!");
		System.out.println("Numbers: " + numbers);
		System.out.println("Numbers (descendant): " + Arrays.toString(numbersDesc));
		System.out.println("Heap: " + heap);
		
		// Set
		System.out.println();
		System.out.println("Set");
		System.out.println("---------------------------------------------------------------------------------");
	
		Set<Integer> numberSet = new HashSet<>();

		populateRandomNumbers(numberSet, 20, 100);
		
		System.out.println("Set: " + numberSet);
		System.out.println("Contains 11: " + numberSet.contains(11));
		System.out.println("Adding 10: " + numberSet.add(10));
		System.out.println("Adding 10: " + numberSet.add(10));
		System.out.println("Adding 11: " + numberSet.add(11));
		System.out.println("Set: " + numberSet);
		System.out.println("Contains 11: " + numberSet.contains(11));
		
		
		// Set
		System.out.println();
		System.out.println("Linked Hash Set");
		System.out.println("---------------------------------------------------------------------------------");
	
		numberSet = new LinkedHashSet<>();

		populateRandomNumbers(numberSet, 20, 100);
		
		System.out.println("Set: " + numberSet);
		System.out.println("Contains 11: " + numberSet.contains(11));
		System.out.println("Adding 10: " + numberSet.add(10));
		System.out.println("Adding 10: " + numberSet.add(10));
		System.out.println("Adding 11: " + numberSet.add(11));
		System.out.println("Set: " + numberSet);
		System.out.println("Contains 11: " + numberSet.contains(11));

		
	}

	@SuppressWarnings("unchecked")
	public static <T extends Number> void populateRandomNumbers(Collection<T> numbers, int size, int max) {
		for (int i = 0; i < size; i++) {
			Integer number = Math.round((float)Math.random() * max);
			
			numbers.add((T)number);
		}
	}

}
