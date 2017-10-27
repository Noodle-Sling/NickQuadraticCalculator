package quadratic;

public class Quadratic {
	double a;
	double b;
	double c;
	double discr;
	double axOfSim;
	
	Quadratic(double[] a) {
		this.a = a[0];
		this.b = a[1];
		this.c = a[2];
		discr = this.b * this.b - (4.0 * this.a * this.c);
		axOfSim = -this.b / (2 * this.a);
	}
	
	Boolean isCalculable() {
		if (discr >= 0.0 && a >= 0.0) return true;
		return false;
	}
	
	double[] calculateRoots() {
		double[] roots = new double[2];
			roots[0] = (-b + Math.sqrt(b*b - 4*a*c)) / (2 * a);
			roots[1] = (-b - Math.sqrt(b*b - 4*a*c)) / (2 * a);
			return roots;
	}
	
	String printComplexRoots() {
		return -b + "/" + (2 * a) + " +/- " + "i[sqrt(" + (Math.abs(discr)) + ")/"  + (2 * a) + "]";
	}
}
