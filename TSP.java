import java.util.*;
public class TravellingSalesPerson {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int cost;
		System.out.print("Enter number of cities : ");
		int n = sc.nextInt();
		if(n<=1)
		{
			System.out.println("Path is not possible!");
			System.exit(0);
		}
		
		int c[][] = new int[n+1][n+1];
		int tour[] =new int[n+1];
		System.out.println("Enter the cost matrix : ");
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
				c[i][j] = sc.nextInt();
		
		for(int i=1;i<=n;i++)
			tour[i] = i;
		cost = tspdp(c,tour,1,n);
		System.out.println("The optimal tour is : ");
		for(int i=1;i<=n;i++)
			System.out.print(tour[i]+" -> ");
		System.out.println("1");
		System.out.println("Minimum Cost : "+cost);
		
		sc.close();
	}
	
	static int tspdp(int c[][], int tour[], int start,int n)
	{
		int mintour[] = new int[n+1], temp[] = new int[n+1], mincost = Integer.MAX_VALUE;
		int ccost;
		if(start == n-1)
		{
			return (c[tour[n-1]][tour[n]] + c[tour[n]][1]);
		}
		for(int i= start+1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
				temp[j] = tour[j];
			temp[start+1] = tour[i];
			temp[i] = tour[start+1];
			if((c[tour[start]][tour[i]] + (ccost = tspdp(c,temp, start+1,n))) < mincost)
			{
				mincost = c[tour[start]][tour[i]]+ccost;
				for(int k=1;k<=n;k++)
					mintour[k] = temp[k];
			}
		}
		for(int i=1;i<=n;i++)
			tour[i] = mintour[i];
		return mincost;
	}
	
}

