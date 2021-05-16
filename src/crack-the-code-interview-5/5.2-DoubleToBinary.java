// Questions:
// - Should the 2 characters "0." be counted towards the limit of 32 characters?

public static String doubleToBinary(double n) {
    if (n < 0 || n > 1) return "ERROR";
    if (n == 1.0) return "1";
     
    StringBuffer binary = new StringBuffer("0.");
    
    for (double f = 0.5; n > 0 && binary.length() < 33; f /= 2.0) {
        if (n >= f) {
            binary.append("1");
            n -= f;
        }
        else binary.append("0");   
    }        

    return (binary.length() < 33) ? binary.toString() : "ERROR";
}

decimal: 0.625
binary: 0.101

double n = 0.625,.125
double f = 1,.5

