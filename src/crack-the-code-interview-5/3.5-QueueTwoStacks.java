// pop: time: O(1), space: O(1)
// push: time: O(n), space: O(n)
class MyQueue {
    Stack<Integer> fifo = new Stack();
    Stack<Integer> temp = new Stack();
    
    public Integer pop() {
        return fifo.pop();
    }
    
    public void push(Integer i) {
        if (i == null) return;
        
        moveStack(fifo, temp);
        
        fifo.push(i);
        
        moveStack(temp, fifo);
    }
    
    private void moveStack(Stack<Integer> src, Stack<Integer> dst) {
        while (!src.isEmpty()) dst.push(src.pop());
    }
}

// test
MyQueue q1 = new MyQueue();

for (int i = 0; i < 10; i++) q1.push(i);

for (int i = 0; i < 10; i++) System.out.println(q1.pop());

// debug
fifo: 
temp: 

