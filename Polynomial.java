public class Polynomial{
	double[] coefficients;

	public Polynomial(){
		coefficients = new double[1];
		coefficients[0] = 0;
	}	
	public Polynomial(double[] a){
		coefficients = a;
	}
	public Polynomial add(Polynomial a){
		if(a.coefficients.length <= coefficients.length){
			for(int i = 0; i < a.coefficients.length; i++){
				coefficients[i] += a.coefficients[i];
			}

			return new Polynomial(coefficients);
		}
		for(int i = 0; i < coefficients.length; i++){
			a.coefficients[i] += coefficients[i];
		}
		return new Polynomial(a.coefficients);

	}

	public double evaluate(double x){
		double sum = 0;
		for(int i = 0; i < coefficients.length; i++){
			sum += coefficients[i] * Math.pow(x, i);
		}
		return sum;
	}

	boolean hasRoot(double root){
		int sum = 0;
		for(int i = 0; i < coefficients.length; i++){
			sum += coefficients[i] * Math.pow(root, i);
		}

		if(sum == 0){
			return true;
		}
		return false;
	}
}