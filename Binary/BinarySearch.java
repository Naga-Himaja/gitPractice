package MyPack;

public class BinarySearch {
	static int non_rec(int arr[],int ele, int low, int high)
	{
		int mid=-1;
		while(low<=high)
		{
			mid = (low+high)/2;    
			if(arr[mid]==ele)
				break;
			if(arr[mid]<ele)
				low = mid+1;
			else
				high = mid-1;
		}
		if(low<=high)
			return mid;		
		else
			return -1;
	}
	static int rec(int arr[],int ele, int low, int high)
	{
		int pos = -1;
		if(low<=high)
		{
			int mid = (low+high)/2;  
			if(arr[mid]==ele)
			{	
				//System.out.println("\n"+java.time.LocalTime.now());    
				return mid;
			}	
			else if(arr[mid]>ele)
				pos= rec(arr,ele,low,mid-1);
			else
				pos= rec(arr,ele,mid+1,high);
		}
		//System.out.println("\nTotal time : "+java.time.LocalTime.now());    
		return pos;
	}
}

