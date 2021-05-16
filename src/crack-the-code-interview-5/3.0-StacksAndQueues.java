// A LINKED LIST can be used to implement both a queue and a stack
// Queue: Insert at the end, remove from start
// Stack: Insert and remove at the start


// LinkedList implements Queue interface in Java
LinkedList<Integer> queue = new LinkedList();
queue.add(1);
queue.add(2);
queue.add(3);

// CAUTION!!! LinkedList has remove(), but List does NOT.
queue.remove();
queue.remove();
queue.remove();
// gives 1,2,3

