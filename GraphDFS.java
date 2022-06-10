import java.util.*;
public class GraphDFS
{
	private int V;
	private LinkedList <Integer> adj[];
	@SuppressWarnings("unchecked")
	GraphDFS(int v)
	{
		V = v;
		adj = new LinkedList [v+1];
		for (int i=0;i<V;i++)
			adj[i] = new LinkedList<Integer>();
	}
	void addEdge(int v, int w)
	{
		adj[v].add(w);
	}
	void DFSUtil(int v, boolean visited[])
	{
		visited[v] = true;
		System.out.print(v + " ");
		Iterator <Integer> i = adj[v].iterator();
		while(i.hasNext())
		{
			int n = i.next();
			if(!visited[n])
				DFSUtil(n, visited);
		}
	}
	
	void DFS(int v)
	{
		boolean visited[] = new boolean[V+1];
		DFSUtil(v,visited);
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of edges : " );
		int n = sc.nextInt();
		System.out.println("Enter the edges : ");
		GraphDFS g = new GraphDFS(n);
		for(int i=1;i<=n;i++)
		{
			int x = sc.nextInt();
			int y = sc.nextInt();
			g.addEdge(x, y);
		}
		System.out.print("Enter the source vertex : ");
		int s = sc.nextInt();
		System.out.println("Following is the Depth First Search : ");
		g.DFS(s);
		sc.close();
	}
}

