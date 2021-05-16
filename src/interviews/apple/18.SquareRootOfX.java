/*
Newton's method
A function can be aproximated by a line close to x if (x - x0) is small enough.  
p = (x0, f(x0)), m = f'(x0)
m = (y - f(x0)) / (x - x0) = f'(x0)
for point (x1, 0)
(0 - f(x0)) / (x1 - x0) = f'(x0)
-f(x(0)/f'(x0) = x1 - x0
x1 = x0 - f(x0)/f'(x0)
*/
public int sqrt(int n) {
    // Caution!!! since n is int, divide by 2D (not 2) to get a double result.
    // Caution!!! use double instead of float for better precision.
    double x = n / 2D;
    double fx = x * x - n;
    double episilon = .0001;
        
    // Caution with Math.abs(fx)!!! without it fails every time fx becomes negative
    for (int i = 0; Math.abs(fx) > episilon; i++) {
        x = x - (fx / (2 * x));
        fx = x * x - n; 
    }
        
    // Caution!!! use round to get the closest int
    return (int) x;
}

