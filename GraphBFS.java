package graph_traversal;
import java.util.*;
public class GraphBFS {
	private int V;
	private LinkedList <Integer> adj[];
	@SuppressWarnings("unchecked")
	GraphBFS(int v)
	{
		V=v;
		adj = new LinkedList[V];
		for(int i=0;i<v;i++)
			adj[i] = new LinkedList<Integer>();
	}
	
	void addEdge(int v,int w)
	{
		adj[v].add(w);
	}
	void BFS(int s)
	{
		boolean [] visited = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[s] = true;
		queue.add(s);
		while(queue.size()!=0)
		{
			s = queue.poll();
			System.out.print(s+" ");
			Iterator<Integer> i = adj[s].iterator();
			while(i.hasNext())
			{
				int n = i.next();
				if(!visited[n])
				{
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of edges : ");
		int n = sc.nextInt();
		System.out.println("Enter edges : ");
		GraphBFS g = new GraphBFS(n);
		for(int i=0;i<n;i++)
		{
			int x = sc.nextInt();
			int y = sc.nextInt();
			g.addEdge(x, y);
		}
		System.out.print("Enter source vertex : ");
		int s = sc.nextInt();
		System.out.println("Following is Breadth First Search : ");
		g.BFS(s);
		sc.close();
	}
}

