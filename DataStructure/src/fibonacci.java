public class fibonacci{

	public static void calcFibonacci(int a,int b, int n){
		//a is start int 
		//b is 2nd int 
		//n is total numbers to calculate fibonacci
		//0 1 1 2 3 5 8
		if(n==0){
			return ;
		}
		  
		int c = a+b;
		System.out.print(c+" ");
		calcFibonacci(b,c,n-1);
		
		
		
	}

	public static void main(String args[]){
		System.out.print(0+" ");
		System.out.print(1+" ");
	calcFibonacci(0,1,9);
	}
}