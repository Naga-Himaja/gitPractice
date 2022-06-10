
public class MergeSort {
	static int count;
	static void display(int arr[], int n)
	{
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	static void merge(int arr[], int n, int low, int mid, int high)
	{
		int i=low, h=low, j = mid+1, k, temp[] = new int[n];
		while(h<=mid && j<=high)
		{
			if(arr[h]<= arr[j])
				temp[i++] = arr[h++];
			else
				temp[i++] = arr[j++];
		}
		if(h>mid)
		{
			for(k=j;k<=high; k++)
				temp[i++] = arr[k];
		}
		else
		{
			for(k=low;k<=mid;k++)
				temp[i++] = arr[k];
		}
		for(k=low;k<=high;k++)
			arr[k] = temp[k];
		System.out.println("Pass "+(++count)+" : ");
		display(arr,n);
	}
	
	static void splitAndMerge(int arr[], int n, int low, int high)
	{
		if(low<high)
		{
			int mid = (low+high)/2;
			splitAndMerge(arr,n,low,mid);
			splitAndMerge(arr,n,mid+1,high);
			merge(arr,n,low,mid,high);
		}
	}
}

