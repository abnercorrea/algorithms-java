// Caution!!! started implementing a SortedStack class... WRONG!!! the input is an unsorted stack tobe sorted.
// time: O(n^2), space: O(n)
public static void sort(Stack<Integer> stack) {
    if (stack == null || stack.isEmpty()) return;
    
    Stack<Integer> temp = new Stack();
    
    while (!stack.isEmpty()) temp.push(stack.pop());
    
    while (!temp.isEmpty()) {
        Integer i = temp.pop();
        int stackedTemp = 0;
        
        while (!stack.isEmpty() && stack.peek() > i) {
            stackedTemp++;
            temp.push(stack.pop());
        }
        
        stack.push(i);
        
        while (stackedTemp > 0) {
            stackedTemp--;
            stack.push(temp.pop());
        }
    }
}

// test
Stack<Integer> s = new Stack();
s.push(12);
s.push(14);
s.push(2);
s.push(5);
s.push(1);

sort(s);

while (!s.isEmpty()) System.out.println(s.pop());

for (int i = 100; i > 0; i--) s.push(i);

sort(s);

while (!s.isEmpty()) System.out.println(s.pop());

//debug
stack=14,12,5,2,1
temp=
i=1,5,2,14,12
stackedTemp=0,1,0,1,0

stack=1,2,3,4,5,6 
temp=6,5,4,3,2,1