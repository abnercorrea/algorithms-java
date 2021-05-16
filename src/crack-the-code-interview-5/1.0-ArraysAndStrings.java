// String
isEmpty()
equalsIgnoreCase(String s)
toCharArray() //get char array of a String
charAt(int x) //get a char at the specific index
toUpperCase() // toLowerCase()
startsWith(String s) // endsWith(String s)
substring(int beginIndex) 
substring(int beginIndex, int endIndex)
indexOf(String s) // char also works
lastIndexOf(String s)
split(String s)
Integer.valueOf(String s)//string to integer
String.valueOf(int i)//integer to string
Arrays.toString(char[] a) // = new String(char[])
// StringBuffer is synchronized, StringBuilder is not.
append(String s) // accepts int, float, boolean, ...
length()
toString()

// Arrays
IntStream.range(min, max).toArray() // int[] containing min to max - 1
Arrays.stream(T[])
Arrays.copyOf(T[] original, int newLength)
Arrays.equals(T[] a, T[] b)
Arrays.fill(T[] a, int start, int end, T value) // end exclusive
Arrays.fill(T[] a, T value)
Arrays.setAll(a, i -> 2 * i + a[i])
// CAREFUL!!! do not use with primitives (int, float, ...)
Arrays.asList(T[])
System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)

// Collection
clear()
addAll(Collection)

// Collections
copy(List<? super T> dest, List<? extends T> src)
fill(List<? super T> list, T obj)
addAll(Collection<? super T>, T[])
swap(List<?> list, int i, int j)
replaceAll(List<T> list, T oldVal, T newVal)
reverse(List<?> list)
max(Collection<? extends T>)
min(Collection<? extends T>)
// Rotates the elements in the specified list by the specified distance.
rotate(List<?> list, int distance)
// Returns true if the two specified collections have no elements in common.
disjoint(Collection<?> c1, Collection<?> c2) 
