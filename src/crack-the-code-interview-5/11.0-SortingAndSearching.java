// Collections
List<Integer> l1 = Arrays.asList(11,101,0,20,5,100)

Collections.sort(l1) 
// Always sort before using binary search
Collections.binarySearch(l1, 11)
// Descendant order
Collections.sort(l1, (i1, i2) -> i2.compareTo(i1)) 

class Color {
    String name;
    public Color(String name) { this.name = name; }
}

List<Color> colors = Arrays.asList(
    new Color("blue"),
    new Color("red"),
    new Color("orange"),
    new Color("green"),
    new Color("yellow")
)

// Using a custom comparator
Collections.sort(colors, (c1, c2) -> c1.name.compareTo(c2.name));
Collections.binarySearch(colors, new Color("blue"), (c1, c2) -> c1.name.compareTo(c2.name))
Collections.binarySearch(colors, new Color("yellow"), (c1, c2) -> c1.name.compareTo(c2.name))
// you can explicitly define a comparator
Comparator<Color> c1 = (c1, c2) -> c1.name.compareTo(c2.name);
Collections.binarySearch(colors, new Color("yellow"), c1)

// ARRAYS special case with custom comparator (remember FB...)
int[][] i = {
{11, 200},
{101, 200000},
{0, 2},
{20, 2000},
{5, 20},
{100, 20000}
}

// If using Integer, do a1[0].compareTo(a2[0])
Arrays.sort(i, (a1, a2) -> Integer.compare(a1[0], a2[0]))

// CAUTION!! in this case key needs to be int[], not int
int[] key = {11}
Arrays.binarySearch(i, key, (a1, a2) -> Integer.compare(a1[0], a2[0]))

