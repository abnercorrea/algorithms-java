// time: O(N), space: O(1)
public static Integer findKthToLast(Node head, int k) {
    if (head == null || k < 0) return null;
    
    for (Node fast = head; fast != null; fast = fast.next) { 
        if (k < 0) head = head.next;
        
        k--;
    }
    
    return (k < 0) ? head.value : null;
}

// Debug
1-2-3-null
k=3,2,1,0
fast=1,2,3,null
head=1

k=1,0,-1,-2
fast=1,2,3,null
head=1,2

// test
findKthToLast(list2, 0)
findKthToLast(list1, 3)
findKthToLast(list1, 9)
findKthToLast(list2, -1)
findKthToLast(null, 0)

