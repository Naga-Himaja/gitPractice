import java.util.Scanner;
public class Knapsack {
	static int max(int a, int b)
	{
		return (a>b)?a:b;
	}
	
	static int knapSack(int W, int wt[], int val[], int n)
	{
		int i,w;
		int k[][] = new int[n+1][W+1];
		for(i=0;i<=n;i++)
		{
			for(w=0;w<=W;w++)
			{
				if(i==0||w==0)
					k[i][w] = 0;
				else if(wt[i-1]<=w)
					k[i][w] = max(val[i-1]+k[i-1][w-wt[i-1]], k[i-1][w]);
				else
					k[i][w] = k[i-1][w];
			}
		}
		return k[n][W];
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the knapsack capacity : ");
		int n = sc.nextInt();
		int val[] = new int[n];
		int wt[] = new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.print("Enter the profit : " );
			val[i] = sc.nextInt();
			System.out.print("Enter the weight: ");
			wt[i] = sc.nextInt();
		}
		System.out.print("Enter the total weight : ");
		int W = sc.nextInt();
		System.out.print("Total profit is : ");
		System.out.println(knapSack(W, wt, val,n));
		sc.close();
	}
}

