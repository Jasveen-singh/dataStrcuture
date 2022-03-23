//QuickSort
class quickSort{
	//it will return us pivot ka new index 
	public static int partition(int[] arr,int low, int high){
		int pivot = arr[high]; // this flavor of sort uses last elem as pivot
		int idx = low-1;
		for(int i=low;i<high;i++)
		{
			if(arr[i] < pivot)
			{
				idx++;
				//SWAP
				int temp = arr[idx];
				arr[idx] = arr[i];
				arr[i] = temp;
			}
		}
		
		//now as all values smaller than pivot are till idx index so next should be pivot 
		idx++;
		int temp = arr[idx];
		arr[idx] = pivot;
		arr[high] = temp;
		return idx;
	}
	
	
	public static void quickSortFunc(int[] arr, int low, int high){
		if(low<high){
		//find pivot
		
		int pivotIdx=partition(arr,low,high);
		quickSortFunc(arr,low,pivotIdx-1);
		quickSortFunc(arr,pivotIdx+1,high);
		
		}
	}
	
	public static void main (String args[]){
		int[] arr = {234,10,32,46,5,865,12};
		quickSortFunc(arr, 0,arr.length-1);
		
		for(int i =0; i<arr.length;i++)
			System.out.print(arr[i]+" ");
	}
}