//Recursion Code 
class mergeSort{
	//Time Complexity - O(nlogn)
	private static void conquer(int[] arr, int si, int ei, int mid){
		int mergedArr[] =new int [(ei-si)+1];
		int startIndex1= si;
		int startIndex2= mid+1; //compare first inden to second to merge smaller arrays
		int x =0; //index location of merged array
		
		while(startIndex1<=mid && startIndex2<=ei){
			if(arr[startIndex1] <= arr[startIndex2])
				mergedArr[x++]= arr[startIndex1++];  //increment here itself instead of next line
			else
				mergedArr[x++]= arr[startIndex2++];
		}
		//in case we still have one array which has elements pending, they are already sorted so just add them
		while(startIndex1<=mid ){
			mergedArr[x++]= arr[startIndex1++];
		}
		
		while( startIndex2<=ei){
			mergedArr[x++]= arr[startIndex2++];
		}
		
		//store new array inside old array 
		for(int i=0,j=si;i<mergedArr.length;i++,j++){
			arr[j] = mergedArr[i];		
		}
		
	}
	
	
	private static void divide(int[] arr, int si, int ei){
			int mid = si+(ei-si)/2;  //this will save us from memory issue in cas eint is too big , better than (si+ei)/2
			if(si>=ei)
				return;
			
			divide(arr,si,mid);
			divide(arr,mid+1,ei);
			conquer(arr,si,ei,mid);
	}
	
	public static void main (String args[]){
			int arr[] = {235,32,876,12,300,10,10};
			//sorted version [10,12,32,235,300,410,876]
			int n = arr.length;
			divide(arr,0,n-1);
			for(int i =0; i<n;i++){
				System.out.print(arr[i]+" ");
			}
			
	}
}