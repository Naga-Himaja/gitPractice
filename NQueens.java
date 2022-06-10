package backtracking;

import java.util.*;
public class N_Queen
{
	static int count=0;
	    public static boolean isSafe(char[][] mat, int r, int c)
	    {
	        for (int i = 0; i < r; i++)
	        {
	            if (mat[i][c] == 'Q') {
	                return false;
	            }
	        }
	 
	        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--)
	        {
	            if (mat[i][j] == 'Q') {
	                return false;
	            }
	        }
	 
	        for (int i = r, j = c; i >= 0 && j < mat.length; i--, j++)
	        {
	            if (mat[i][j] == 'Q') {
	                return false;
	            }
	        }
	 
	        return true;
	    }
	 
	    private static void printSolution(char[][] mat)
	    {
		for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat.length;j++)
                System.out.print(" "+mat[i][j]+" ");
            	System.out.println();
       		 }
	        count++;
	    }
	 
	    private static void nQueen(char[][] mat, int r)
	    {
	        if (r == mat.length)
	        {
	            printSolution(mat);
	            System.out.println("\n");
	            return;
	        }
	        for (int i = 0; i < mat.length; i++)
	        {
	            if (isSafe(mat, r, i))
	            {
	                mat[r][i] = 'Q'; 
	                nQueen(mat, r + 1);
	                mat[r][i] = '–';
	            }
	        }
	    }
	 
	    public static void main(String[] args)
	    {
	        int N;
		System.out.println("Enter no of Queens : ");
	        Scanner sc=new Scanner(System.in);
	        N=sc.nextInt();
	        char[][] mat = new char[N][N];
	        for (int i = 0; i < N; i++) {
	            Arrays.fill(mat[i], '–');
	        }
	 
	        nQueen(mat, 0);
	        System.out.println("Total number of solutions : "+count);
	        sc.close();
	    }
	}
