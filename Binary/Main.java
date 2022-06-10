package MyPack;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter the number of elements : ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int []arr = new int[n];
		System.out.print("Enter "+n+" numbers : ");
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		System.out.println("Array before sorting : ");
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(arr[i]<arr[j])
				{
					int temp=arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println("\nArray after sorting : ");
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		System.out.println("\n1.Enter element\n2.Recursive\n3.Non Recursive\n4.Exit");
		System.out.print("Enter your option : ");
		int ch = sc.nextInt();
		int ele=0,pos=0;
		code : while(true)
		{
			switch(ch)
			{
			case 1: System.out.print("Enter your search element : ");
					ele = sc.nextInt(); break;
			case 2: long start = System.nanoTime();
					pos = BinarySearch.rec(arr,ele,0,n-1); 
					long end = System.nanoTime();
					System.out.println("Time taken to execute in recursion (Nano sec): "+(end-start));
					if(pos!=-1)
					System.out.println("Element found at index "+pos);
				else
					System.out.println("Element not found"); break;
			case 3: start =  System.nanoTime();
				pos = BinarySearch.non_rec(arr,ele,0,n-1);
				end = System.nanoTime();
				System.out.println("Time taken to execute in non recursive (Nano sec): "+(end-start));
				if(pos!=-1)
					System.out.println("Element found at index "+pos);
				else
					System.out.println("Element not found");
					break; 
			case 4: break code;
			}
			System.out.println("\n1.Enter element\n2.Recursive\n3.Non Recursive\n4.Exit");
			System.out.print("Enter your option : ");
			ch = sc.nextInt();
		}
		sc.close();
	}

}

