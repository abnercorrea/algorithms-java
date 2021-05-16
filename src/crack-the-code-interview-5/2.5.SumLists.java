// time: O(n + m), space: O(1)  
public static Node sum(Node a, Node b) {
    if (a == null) return b;
    if (b == null) return a;
    
    // Caution!!! always initialize objects before using them. Otherwise you'll get compiler error: variable might not have been initiallized.
    Node rootC = null, c = null;
    boolean carry = false;
    
    while (a != null || b != null || carry) {
        int va = (a == null) ? 0 : a.value; 
        int vb = (b == null) ? 0 : b.value; 
        // Caution!!! the expression ((carry) ? 1 : 0) needs the outer parenthesis
        int vc = va + vb + ((carry) ? 1 : 0);
        carry = vc > 9;
        
        Node digit = new Node(carry ? vc - 10 : vc, null);
        
        if (rootC == null)
            rootC = digit;
        else
            c.next = digit;
        
        c = digit;
        if (a != null) a = a.next;
        if (b != null) b = b.next;
    }
    
    return rootC;    
}

//test    
Node a = new Node(9, 
new Node(3, 
new Node(4, null)));

Node b = new Node(7, 
new Node(8, 
new Node(6, null)));

printList(sum(a, b));
printList(sum(a, null));
printList(sum(a, null));
printList(sum(null, null));

//solution 
1-2-3
4-5-6
321 + 654 = 975 => 5-7-9

//debug
a: 9-3-4
b: 7-8-6
a=9,3,4,null
b=7,8,6,null
c=6,2,1,1
vc=16,12,11,1
carry=false,true,true,true,false
digit=6,2,1,1
result=6