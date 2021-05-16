/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
*/

public int reverse(int x) {
    int rev = 0;
    
    while(x != 0){
        rev = rev * 10 + x % 10;
        
        x = x/10;
    }
 
    return rev;
}