package quicksorting;
import java.util.*;
public class QuickSortUp {
	static int pass;
	public static void quicksort(int arr[], int low, int high,int n)
	{
		if(low<high)
		{
			int j= partition(arr,low,high,n);
			quicksort(arr,low,j-1,n);
			quicksort(arr,j+1,high,n);
		}
	}
	static int partition (int arr[], int lb, int ub, int n)
	{
		int down  = lb, up= ub, temp, pivot=arr[ub];
		while(down<up)
		{
			while(arr[down] < pivot && down < up)
				down++;
			while(arr[up]>=pivot &&up>lb)
				up--;
			if(down<up)
			{
				temp = arr[down];
				arr[down] = arr[up];
				arr[up] = temp;
			}
		}
		arr[ub] =arr[down];
		arr[down] = pivot;
		System.out.println("\nPass : "+(++pass)+" pivot: "+pivot);
		display(arr,n);
		return down;
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
		System.out.println("\nArray after sorting : ");
		display(arr,n);
		System.out.println("Time taken in nano seconds : "+(end-start));
		sc.close();
	}
}









