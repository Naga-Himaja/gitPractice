import java.util.*;
public class Krushkals 
{
	int parent[];
	Krushkals(int n)
	{
		parent = new int[n+1];
	}
	int find (int m)
	{
		int p = m;
		while(parent[p]!=0)
			p=parent[p];
		return p;
	}
	
	void union(int i, int j)
	{
		if(i<=j)
			parent[i] = j;
		else
			parent[j] = i;
	}
	
	void krk(int [][]a, int n)
	{
		int u=0,v=0,min,k=0,i,j,sum=0;
		while(k<n-1)
		{
			min = 99;
			for(i=1;i<=n;i++)
				for(j=1;j<=n;j++)
					if(a[i][j]<min && i!=j)
					{
						min = a[i][j];
						u = i;
						v=j;
					}
			i=find(u);
			j=find(v);
			if(i!=j)
			{
				union(i,j);
				System.out.println("("+u+","+v+")"+"="+a[u][v]);
				sum+=a[u][v];
				k++;
			}
			a[u][v] = a[v][u] = 99;	
		}
		System.out.println("The cost of the minimum spanning tree is = "+sum);
	}
	
	public static void main(String args[])
	{
		int a[][],i,j;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of vertices : ");
		int n = sc.nextInt();
		a = new int[n+1][n+1];
		System.out.println("Enter the weighted matrix : ");
		for(i=1;i<=n;i++)
			for(j=1;j<=n;j++)
				a[i][j] = sc.nextInt();
		Krushkals k= new Krushkals(n);
		k.krk(a,n);
		sc.close();
}
}

