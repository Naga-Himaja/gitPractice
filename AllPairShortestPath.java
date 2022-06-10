import java.util.*;
public class AllPairShortest {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of vertices : ");
		int n = sc.nextInt();
		int cost[][] = new int[n][n];
		int A[][]= new int[n][n];
		System.out.println("Enter cost adjacency matrix : ");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				cost[i][j] = sc.nextInt();
				A[i][j] = cost[i][j];
			}
		}
		for(int k=0;k<n;k++)
		{
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
				{
					int temp = A[i][k] + A[k][j];
					if(A[i][j]>temp)
						A[i][j] = temp;
				}
		}
		System.out.println("The shortest path matrix is : ");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				System.out.print(A[i][j]+" ");
			System.out.println();
		}
		
		sc.close();
	}
}

