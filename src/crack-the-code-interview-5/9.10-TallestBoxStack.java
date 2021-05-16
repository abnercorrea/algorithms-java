class Box {
    int h, w, d;    

    public Box(int h, int w, int d) {
        this.h = h; this.w = w; this.d = d;
    }
    
    public boolean canBeAbove(Box bottom) {
        return bottom == null || (h < bottom.h && w < bottom.w && d < bottom.d);
    }
}

public static int stackHeight(List<Box> boxes) {
    if (boxes == null) return 0;
    
    int h = 0;
    for (Box b : boxes) h += b.h;
    
    return h;
}

// CAUTION!!! use ArrayList instead of List since clone will be used
public static ArrayList<Box> tallestStack(Box[] boxes, Box bottom, Map<Box, ArrayList<Box>> cache) {
    if (boxes == null) return null;
    
    // Dynamic programming
    // CAUTION!!! if looking for a key, use containsKey
    if (bottom != null && cache.containsKey(bottom)) return cache.get(bottom);
    
    ArrayList<Box> maxStack = null;
    int maxHeight = 0;
    
    for (int i = 0; i < boxes.length; i++) 
        if (boxes[i].canBeAbove(bottom)) {
            ArrayList<Box> newStack = tallestStack(boxes, boxes[i], cache);
            int newHeight = stackHeight(newStack);
            
            if (newHeight > maxHeight) {
                maxHeight = newHeight;
                maxStack = newStack;
            }
        }
    
    if (maxStack == null) maxStack = new ArrayList();
    if (bottom != null) maxStack.add(0, bottom);
    // DP
    // CAUTION!! its put, and NOT add
    cache.put(bottom, maxStack);
    
    return (ArrayList<Box>) maxStack.clone();   
}

public static List<Box> tallestStack(Box[] boxes) {
    return tallestStack(boxes, null, new HashMap());    
}

// test
Box[] boxes1 = {
    new Box(1,1,1),
    new Box(2,2,2),
    new Box(3,3,3),
    new Box(4,4,4),
    new Box(10,10,10)
}
    
Box[] boxes2 = {
    new Box(1,1,1),
    new Box(2,2,2),
    new Box(15,1,3),
    new Box(4,4,4)
}
    
stackHeight(tallestStack(boxes1))
stackHeight(tallestStack(boxes2))
stackHeight(tallestStack(null))

// ALGORITHM
n boxes: 1 to n
tallest stack is the tallest among:
tallest stack with box 1 at the bottom
tallest stack with box 2 at the bottom
...
tallest stack with box n at the bottom

tallest stack with box 1 at the bottom:
if box 2 can be above box 1,  tallest stack with box 2 at the bottom
if box 3 can be above box 1,  tallest stack with box 3 at the bottom
...
if box n can be above box 1,  tallest stack with box n at the bottom



// My attempt... overcomplicated things... clearly
// algorithm t()
// max stack height
1 box - t(1) = return box.h
2 boxes - t(1, 2) = if can stack boxes 
            return t(1) + t(2)
          else
            return max(t(1), t(2))
3 boxes - t(1,2,3) = if can stack boxes 
            return t(1, 2) + t(3)
          else
            return max(t(1,2), t(1,3), t(3))
4 boxes - t(1,2,3,4) = if can stack boxes 
            return t(1,2,3) + t(4)
          else
            return max(t(1,2,3), t(1,2,4), t(1,4), t(2,4), t(4))
n boxes - t(1,2,3,...,n) = if can stack boxes 
            return t({1,2,3,...,n-1}) + t(n)
          else
            return max(t({1,...,n}, 1), t({1,...,n}, 2), ..., t({1,...,n}, n))

// can stack s()
// if sorted by height. (h)
1 box - s(1) = true
2 boxes = s(1, 2) = b1.w <= b2.w && b1.d <= b2.d
3 boxes = s(2, 3)
4 boxes = s(3, 4)


//  
