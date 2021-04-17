package interviews.facebook;

public class SquareRootDouble {
	
	public static void main(String[] args) {
		System.out.println(sqrt(63618734));
	}

	public static double sqrt(double n) {
		double x = n / 2;
		double fx = x * x - n;
		double tolerance = .00000000001;
		int i;
		
		for (i = 0; fx > tolerance; i++) {
			x = x - (fx / (2*x));
			fx = x * x - n; 
		}
		
		System.out.println("Iterations: " + i);
		
		return x;
	}
}
