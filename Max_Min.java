import java.util.*;
public class Max_Min {
	static int max,min;
	static void StraightMaxMin(int arr[], int n)
	{
		max = min = arr[0];
		for(int i=1;i<n;i++)
		{
			if(arr[i]>max)
				max=arr[i];
			else if(arr[i]<min)
				min=arr[i];
		}
	}
	
	static void RecurMaxMin(int arr[],int i, int j, Pair p)
	{
		if(i==j)
		{         
                p.max = arr[i]; 
                p.min = arr[j];
 
            return;
		}
		else if(i==j-1)
		{
			if(arr[i]<arr[j])
			{
				p.min = arr[i];
				p.max = arr[j];
			}
			else
			{
				p.min = arr[j];
				p.max = arr[i];
			}
		}
		else
		{
			int mid = (i+j)/2;
			Pair p1 = new Pair(arr[0],arr[0]);
			Pair p2 = new Pair(arr[0],arr[0]);
			RecurMaxMin(arr,i,mid,p1);
			RecurMaxMin(arr,mid+1,j,p2);
			if(p1.max>p2.max)
				p.max = p1.max;
			else
				p.max = p2.max;
			
			if(p1.min<p2.min)
				p.min = p1.min;
			else
				p.min = p2.min;
		}
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of elements : ");
		int n = sc.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter "+n+" elements : ");
		for(int i=0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		long starti = System.nanoTime();
		StraightMaxMin(arr, n);
		long endi = System.nanoTime();
		System.out.println("\nThe max is "+max+" and the min is "+min);
		System.out.println("Time for execution in iterative : "+(endi-starti));
		
		Pair p = new Pair(arr[0],arr[0]);
		long startr = System.nanoTime();
		RecurMaxMin(arr, 0, n-1,p);
		long endr = System.nanoTime();
		System.out.println("\nThe max is "+p.max+" and the min is "+p.min);
		System.out.println("Time for execution in recursive : "+(endr-startr));
		sc.close();
	}
}

