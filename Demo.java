package pack;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		double[][] x_train = {{1,1,0,0}, {0,1,0,0}, {1,1,1,1},{0,0,1,1}} ;
		
		double[] w = {1,1,0,0};
		
		Neural_Network n = new Neural_Network(4, 1);
		
		n.fit(x_train, w, 10000);
		
		double[][] test = {{1,1,0,0}, {0,0,1,0}} ;
		
		double[] t = n.query(test);
		
		
		for(int i=0 ; i <t.length ; i++) {
			System.out.println(t[i]);
		}
		
		
		
		
		
		
	}
}
