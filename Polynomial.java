package B07;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.Arrays;

public class Polynomial{
	double[] coefficients;
	int[] exponents;
	
	public Polynomial(){ // initialize as empty array 
		coefficients = new double[0];
		exponents = new int[0];
		
	}	
	public Polynomial(double[] a, int[] b){
		coefficients = a;
		exponents = b;
	}
	public Polynomial(File f){
		String[] poly = f.toString().split("((?=+)|(?=-))");
		coefficients = new double[poly.length];
		exponents = new int[poly.length];
		for(int i = 0; i< poly.length; i++){
			coefficients[i] = Double.parseDouble(poly[i].split("x",2)[0]); 
			exponents[i] = Integer.parseInt(poly[i].split("x",2)[1]);
		}

	}

	public Polynomial add(Polynomial a){
		boolean present = false;
		for(int i = 0; i < a.exponents.length; i++){
			present = false;
			for (int n = 0; n < exponents.length; n++){
				if(a.exponents[i] == exponents[n]){
					present = true;
					coefficients[n] += a.coefficients[i];
				}
			}
			if(!present){
				coefficients = Arrays.copyOf(coefficients, coefficients.length + 1);
				coefficients[coefficients.length-1]= a.coefficients[i];
				exponents = Arrays.copyOf(exponents, exponents.length + 1);
				exponents[exponents.length-1]= a.exponents[i];
			}
		}
		return new Polynomial(coefficients, exponents);
	}

	public double evaluate(double x){
		double sum = 0;
		for(int i = 0; i < coefficients.length; i++){
			sum += coefficients[i] * Math.pow(x, exponents[i]);
		}
		return sum;
	}

	boolean hasRoot(double root){
		int sum = 0;
		for(int i = 0; i < coefficients.length; i++){
			sum += coefficients[i] * Math.pow(root, exponents[i]);
		}

		if(sum == 0){
			return true;
		}
		return false;
	}

	public Polynomial multiply(Polynomial p){
		double[] coeff = new double[1];
		int[] exp = new int[1];
		Polynomial n = new Polynomial();
		Polynomial m;
		for (int i = 0; i<p.exponents.length; i++){
			for (int j = 0; j<exponents.length; j++){
				coeff[0] = coefficients[j]*p.coefficients[i];
				exp [0] = exponents[j]+p.exponents[i];
				m = new Polynomial(coeff, exp);
				n.add(m);
			}
        }
        return n;
	}

	public void saveToFile(String path){
		String poly= "";
		for(int i = 0; i < exponents.length; i++){
			if(coefficients[i] > 0){
				poly = poly+"+"+coefficients[i])+"x"+(exponents[i]);
			}
			else{
				poly = poly + (coefficients[i])+"x"+(exponents[i]);
			}
		}
		try {
			FileWriter mw = new FileWriter(path);
			mw.write(poly);
			mw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
