package com.testing;

import java.util.Scanner;

public class CPlusProgramInJava {
	public static void printfPattern() {
		Scanner sc = new Scanner(System.in);
         
		System.out.println("How many rows you want in this pattern?");
         
        int rows = sc.nextInt();
         
        System.out.println("Here is your pattern....");
         
        for (int i = 1; i<= rows; i++) 
        {
            //Printing first half of the row
             
            for (int j = 1; j <= i; j++) 
            { 
                System.out.print(j); 
            }
             
            //Printing second half of the row 
             
            for (int j = i-1; j >= 1; j--)
            {
                System.out.print(j);
            }
             
            System.out.println();
        }
        sc.close();
	}
	
	public static void getStringNo() {
		int n =5,k = 1;
		for(int i=1;i<n;i++)
		{
			for(int j=i;j<n+2;j++)
			{
				if(j<n+i)
				{
					System.out.print(j);
					k=j;
				}
				else
					k--;
					System.out.print(k);
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args) {
		getStringNo();
		//printfPattern();
	}

}
