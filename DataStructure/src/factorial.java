public class factorial{
	
	public static int factorialFunc(int n){
		if(n==1 || n==0)
			return 1;
		
	return n*factorialFunc(n-1);
	}
	public static void main (String args[]){
		System.out.print(factorialFunc(0));
	}
}