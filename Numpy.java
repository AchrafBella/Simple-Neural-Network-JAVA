package pack;

public class Numpy {

	
	static double[] sigmoid_derive(double[] x, boolean derive) {
		
		double[] sigmoid_derive = new double[x.length];
		
		if(derive) {
			for(int i=0 ; i<x.length; i++)
				sigmoid_derive[i] = x[i]*(1.0 - x[i]);
			return sigmoid_derive;
		}
		
		for(int i=0 ; i<x.length; i++)
			sigmoid_derive[i] = 1/(1+Math.exp(- x[i] ));
		return sigmoid_derive;
	}
		
	static double[] dot(double[][] arg1, double[] arg2) {
		double[] value = new double[arg1.length];
	
		for(int i=0 ; i<arg1.length ; i++) {
			for(int j= 0 ; j<arg2.length ;j++)
			value[i] += arg1[i][j] * arg2[j];
		}
		return value;
	}
	
	static double[] erreur(double[] target, double[] output_layer) {
		double[] value = new double[target.length];

		for(int i=0 ; i<target.length ; i++) {
			value[i] = target[i] - output_layer[i];
		}
		return value;
	}
	
	static double[] modification(double[] erreur, double[] sigmoid) {
		double[] value = new double[erreur.length];

		for(int i=0 ; i<erreur.length ; i++) {
			value[i] = erreur[i] * sigmoid[i];
		}
		return value;	
	}
	
	static void update(double[] weights, double[][] input, double[] modification) {
		
		for(int i=0 ; i<weights.length ; i++) {
				for(int k = 0 ; k<input.length ; k++) {
				weights[i] += input[k][i] * modification[i];
				}
		}

	}
	
	static double means(double[] arg) {
		double value = 0 ;
		for(int i=0 ; i<arg.length ;i++) {
			value += arg[i];
		}
		
		return value/arg.length;
	}
	

	
}
