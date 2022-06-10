import java.util.*;
public class KnapSack {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the total objects : ");
		int object = sc.nextInt();
		int []weight =  new int[object];
		int profit[] = new int[object];
		for(int i=0;i<object;i++)
		{
			System.out.print("\nEnter the profit : ");
			profit[i] = sc.nextInt();
			System.out.print("Enter the weight : ");
			weight[i] = sc.nextInt();
		}
		System.out.print("Enter the knapsack capacity : ");
		int m = sc.nextInt();
		double p_w[] = new double[object];
		for(int i=0;i<object;i++)
		{
			p_w[i] = (double)profit[i]/(double)weight[i];
		}
		System.out.println();
		System.out.println("----------------");
		System.out.println("----Data Set----");
		System.out.println("----------------");
		System.out.print("Objects ");
		for(int i=1;i<=object;i++)
			System.out.print(i+" ");
		System.out.println();
		System.out.print("Profit ");
		for(int i=0;i<object;i++)
			System.out.print(profit[i]+" ");
		System.out.println();
		System.out.print("Weight ");
		for(int i=0;i<object;i++)
			System.out.print(weight[i] +" ");
		System.out.println();
		System.out.print("P/W ");
		for(int i=0;i<object;i++)
			System.out.print(p_w[i]+" ");
		for(int i=0;i<object-1;i++)
		{
			for(int j=i+1;j<object;j++)
			{
				if(p_w[i]<p_w[j])
				{
					double temp = p_w[j];
					p_w[j] = p_w[i];
					p_w[i] = temp;
					
					int temp1 = profit[i];
					profit[i] = profit[j];
					profit[j] = temp1;
					
					int temp2 = weight[i];
					weight[i] = weight[j];
					weight[j] = temp2;
				}
			}
		}
		
		System.out.println();
		System.out.println("----------------");
		System.out.println("-After arranging-");
		System.out.println("----------------");
		System.out.print("Objects ");
		for(int i=1;i<=object;i++)
			System.out.print(i+" ");
		System.out.println();
		System.out.print("Profit ");
		for(int i=0;i<object;i++)
			System.out.print(profit[i]+" ");
		System.out.println();
		System.out.print("Weight ");
		for(int i=0;i<object;i++)
			System.out.print(weight[i]+" ");
		System.out.println();
		System.out.print("P/W ");
		for(int i=0;i<object;i++)
			System.out.print(p_w[i]+" ");
		System.out.println();
		int k=0;
		double sum=0;
		while(m>0)
		{
			if(weight[k]<m)
			{
				sum+=1*profit[k];
				m-=weight[k];
			}
			else
			{
				double x4 = m*profit[k];
				double x5 = weight[k];
				double x6 = x4/x5;
				sum+=x6; m=0;
			}
			k++;
		}
		System.out.println("Final profit is : "+sum);
		sc.close();
	}
	
}

