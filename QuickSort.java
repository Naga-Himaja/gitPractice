package quicksorting;
import java.util.*;
public class QuickSort {
	static int pass;
	public static void quicksort(int arr[], int low, int high,int n)
	{
		if(low<high)
		{
			int j= partition(arr,low,high,n);
			quicksort(arr,low,j,n);
			quicksort(arr,j+1,high,n);
		}
	}
	static int partition (int arr[], int lb, int ub, int n)
	{
		int down  = lb, up= ub, temp, pivot=arr[lb];
		while(down<up)
		{
			while(arr[down] <= pivot && down < up)
				down++;
			while(arr[up]>pivot)
				up--;
			if(down<up)
			{
				temp = arr[down];
				arr[down] = arr[up];
				arr[up] = temp;
			}
		}
		arr[lb] =arr[up];
		arr[up] = pivot;
		System.out.println("Pass : "+(++pass));
		display(arr,n);
		return up;
	}
	static void display(int arr[], int n)
	{
		for(int i=0;i<n;i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of the array : ");
		int n= sc.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter "+n+" integer values : ");
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		System.out.println("Array before sorting is : ");
		display(arr,n);
		long start = System.nanoTime();
		quicksort(arr,0,n-1,n);
		long end =  System.nanoTime();
		System.out.println("Array after sorting : ");
		display(arr,n);
		System.out.println("Time taken in nano seconds : "+(end-start));
		sc.close();
	}
}









