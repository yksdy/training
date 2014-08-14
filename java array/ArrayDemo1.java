public class ArrayDemo1 {

	public static void main(String[] args){
		int[] a = null;
		a = new int[3];
		a[0] = 32;
		a[1] = 30;
		a[2] = 23;
		int[] b = {2,3,4,6};
		for(int i = 0; i<a.length; i++){
			System.out.println("a["+i+"] = " + a[i]);
		}
		for(int i = 0; i<b.length; i++){
			System.out.println("b["+i+"] = " + b[i]);
		}	

		//variableParameter(a[1],b[0],b[2]);
		variableParameter(a);
	}
	
	//ke bian can shu   variable parameter
	public static void variableParameter(int ... x){
		for(int i = 0; i<x.length; i++){
			System.out.println("x["+i+"] = " + x[i]);
		}	
		// foreach
		for(int y:x){
			System.out.println("y = " + y);
		}	
		
	}
	
	
}
