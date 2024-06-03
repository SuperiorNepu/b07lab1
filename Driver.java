public class Driver {
	public static void main(String [] args) {
		
		Polynomial poly1 = new Polynomial();

       	double[] coefficients = {1.0, 2.0, 3.0};
        int[] exponents = {0, 1, 2};
        Polynomial poly2 = new Polynomial(coefficients, exponents);


        // Test evaluate method
        double value = poly2.evaluate(2.0);
        System.out.println("Evaluation of poly at x=2: " + value);

        // Test hasRoot method
        boolean hasRoot = poly2.hasRoot(1.0);
        System.out.println("poly2 has root at x=1: " + hasRoot);

        // Test multiply method
        Polynomial poly3 = poly2.multiply(poly1);

        // Test saveToFile method
        String outputFilePath = "outputPolynomial.txt";
        poly3.saveToFile(outputFilePath);
        System.out.println("Polynomial saved to file: " + outputFilePath);
    		
	}
}