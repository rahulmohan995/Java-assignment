package abc;

class abc
{
	public static void main(String[] args) 
{
		int i, j, k;
		for(i=3;i>=1;i--)
		{
			for(j=3;j>i;j--)
			{
				System.out.print(" ");
			}
			for(k=1;k<(i*2);k++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		for(i=2; i<=3; i++)
		{
			for(j=2; j>=i; j--)
			{
				System.out.print(" ");
			}
			for(k=1; k<=(2*i-1); k++)
			{
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}