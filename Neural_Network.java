package pack;

import java.util.ArrayList;
import java.util.Random;

public class Neural_Network {
	
	static Random r = new Random();
	
	private int input_nodes;
	private int output_nodes;
	
	private double[] weights1;
	
	double[][] input_layer;
	double[]   output_layer;
	
	double[]  error;
	double[]  modification;
	
	
	public Neural_Network(int input_nodes, int output_nodes) {
		super();
		this.input_nodes = input_nodes;
		this.output_nodes = output_nodes;
		
		this.weights1 = new double[this.input_nodes];
		
		for(int i=0 ; i<this.input_nodes; i++)
		this.weights1[i] = 2*r.nextFloat()-1;
	}
	
	public void fit(double[][] x_train, double[] y_train,int epochs) {
		
		for(int i=0 ; i<epochs ; i++) {
			this.input_layer  = x_train;
			this.output_layer = Numpy.sigmoid_derive(Numpy.dot(x_train, this.weights1), false);
			
			this.error         = Numpy.erreur(y_train, this.output_layer);
			//System.out.println(Numpy.means(this.error));
			this.modification  = Numpy.modification(this.error, Numpy.sigmoid_derive(this.output_layer,true));
			Numpy.update(this.weights1,this.input_layer, this.modification);
		}
		
	}
	
	public double[] query(double[][] test) {
		
		this.output_layer = Numpy.sigmoid_derive(Numpy.dot(test, this.weights1), false);
		
		return this.output_layer;
	}
	
	
	

}
