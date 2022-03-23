class optimisedFibonacci{
//this approach takes more time but less memory
public static int fib(int n){
if(n==0 || n==1) return n;
return fib(n-1) + fib(n-2);
}
//
public static void main(String args[]){
  int val =fib(9);
  System.out.println(val);
}
}