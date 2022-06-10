import java.util.*;

public class Prims 
{
	public static void main(String args[])
	{
		System.out.print("Enter number of vertices : ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w[][] = new int[n+1][n+1];
		int sol[] = new int[n+1];
		int i,j,k=0,s,min,sum=0,u=0,v=0,flag=0;
		for(i=1;i<=n;i++)
			sol[i] =0;
		System.out.println("Enter the weighted graph : ");
		for(i=1;i<=n;i++)
			for(j=1;j<=n;j++)
				w[i][j] = sc.nextInt();
		System.out.print("Enter the source vertex : ");
		s = sc.nextInt();
		sol[s]  = 1;
		k=1;
		while(k<n)
		{
			min = 99;
			for(i=1;i<=n;i++)
				for(j=1;j<=n;j++)
					if(sol[i]==1 && sol[j]==0)
						if(i!=j && min> w[i][j])
						{
							min = w[i][j];
							u=i;
							v=j;
						}
			sol[v] = 1;
			sum+=min;
			k++;
			System.out.println(u+"-->"+v+"="+min);
		}
		for(i=1;i<=n;i++)
			if(sol[i]==0)
			{
				flag=1;
				break;
			}
		if(flag==1)
			System.out.println("No spanning tree");
		else
			System.out.println("The cost of the minimum spanning tree is = "+sum);
		sc.close();
	}
}

