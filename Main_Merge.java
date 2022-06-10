import java.util.*;
public class Main_Merge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of elements : ");
		int n= sc.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter "+n+" elements : ");
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		long start = System.nanoTime();
		MergeSort.splitAndMerge(arr, n, 0, n-1);
		long end = System.nanoTime();
		System.out.println("\nSorted array is : ");
		MergeSort.display(arr, n);
		System.out.print("Time taken for execution in Nano seconds : "+(end-start));
		sc.close();
	}
}

