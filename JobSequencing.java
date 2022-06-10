import java.util.*;
public class Job {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of jobs : ");
		int n = sc.nextInt();
		String a[] = new String[n];
		int b[] = new int[n];
		int c[] = new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.print("Enter the job : ");
			a[i] = sc.next();
			System.out.print("Enter the profit : ");
			b[i] = sc.nextInt();
			System.out.print("Enter the deadline : ");
			c[i] = sc.nextInt();
		}
		
		System.out.println("------Arranged order------");
		System.out.print("Jobs : ");
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");
		System.out.println();
		System.out.print("Profit : ");
		for(int i=0;i<n;i++)
			System.out.print(b[i]+" ");
		System.out.println();
		System.out.print("Deadline : ");
		for(int i=0;i<n;i++)
			System.out.print(c[i]+" ");
		System.out.println();
		for(int i=0;i<n-1;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(b[i]<b[j])
				{
					int temp = b[i];
					b[i] = b[j];
					b[j] = temp;
					
					temp = c[i];
					c[i] = c[j];
					c[j] = temp;
					
					String temp1 = a[i];
					a[i] = a[j];
					a[j] = temp1;
				}
			}
		}
		
		System.out.println();
		System.out.println("-------Sorted order-------");
		System.out.print("Jobs : ");
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");
		System.out.println();
		System.out.print("Profit : ");
		for(int i=0;i<n;i++)
			System.out.print(b[i]+" ");
		System.out.println();
		System.out.print("Deadline : ");
		for(int i=0;i<n;i++)
			System.out.print(c[i]+" ");
		System.out.println();
		
		int max = c[0];
		for(int i=0;i<n;i++)
			if(c[i]>max)
				max = c[i];
		String x[] = new String[max];
		int profit = 0;
		for(int i=0;i<n;i++)
		{
			int pp = c[i];
			pp = pp-1;
			if(x[pp] == null)
			{
				x[pp] = a[i];
				profit+=b[i];
			}
			else
			{
				while(pp!=-1)
				{
					if(x[pp] == null)
					{
						x[pp] = a[i];
						profit += b[i];
						break;
					}
					pp--;
				}
			}
		}
		
		for(int i=0;i<max;i++)
			System.out.print("---> "+x[i]);
		System.out.println();
		System.out.println("Total profit earned : "+profit);
		sc.close();
	}
}

