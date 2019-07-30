//Andre Barajas
//CECS 328
//Spring 2018
//Assignment1PondScum
import java.util.*;
import java.io.*;
public class main 
{
	public static int m, n;
	public static String markedVariables[] = new String[100];
	public static int marked;
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner input = new Scanner(new File("sample.txt"));
		input.useDelimiter(",");
		getParameters(input);
		input.close();
		 input = new Scanner(new File("sample.txt"));
		input.useDelimiter(",");
		String[][] matrix = popArray(input);
		String[][] matrix0 = composeSystem(matrix);
		Rational[][] matrix1 = resultSig(matrix0);
		/* for(int i = 0; i < marked;i++)
		{
			for(int j = 0; j < marked+1; j++)
			{
				System.out.print(matrix0[i][j] + ", ");
			}
			System.out.println();
		}
		*/
		
		input.close();
	}
	public static Rational[][] resultSig(String[][] x)
	{
		Rational[][] system= new Rational[marked][marked+1];
		Rational[] sum = new Rational[marked+1];
		int g = 0;
		int counter  = 0;
		
		for(int i = 0; i <marked; i++)
		{
			for(int j = 0; j < (marked+1);j++)
			{
				int val = Integer.parseInt( x[i][j]);
				if(sum[j] == null)
				{
					sum[j]=new Rational(val, 1);
				}
				else
				{
					sum[j].add(new Rational(val,1));
				}
				//sum[j] = sum[j].add(sum[j]);
				
				//sum[j] += val;
			}
		}
		for(int i = 0;i <sum.length;i++)
		{
			if (i >0 && i <(sum.length-1))
			{
				sum[i].multiply(new Rational(-1,1)); 
				counter++;
			}
		} 
		for(int i =0; i<marked+1; i++) 
		{
			if(i >0)
			{
				Rational temp = new Rational(1, sum[0].getNum());
				sum[i].multiply(temp); 
			}
			
		}
		sum[0].setNum(1);
		
		
			Rational[] temp = new Rational[marked+1];
			//Starting at 1 since 0 has been computed
			for (int i = 1;i <=marked-1; i++)
			{
				for(int j =0; j<= marked;j++)
					{
						int val = Integer.parseInt(x[i][j]);
						temp[j]=new Rational(val, 1);
					}
			}
			//int sol = 
		Rational s, l;
			Rational[] array = new Rational[marked+1];
			//s = temp[0].multiply0(sum[1]);
			//l = temp[0].multiply0(sum[2]);
			
				for(int j= 0; j<=marked-1;j++)
				{
					
						 array[j] = temp[0].multiply0(sum[j+1]); //new Rational(s.getNum(), s.getDen());	
				
				}
				array[0].add(temp[1]);
				array[2].add(temp[2]);
				
			
		
			
		return system;
	}
	public static String[][] composeSystem(String[][] x) 
	{
		String[][] system= new String[marked][marked+1];
		int constants =0;
				for(int i = 0; i < marked;i++)
				{
					system[i][i] = "4";
					for(int z = 0; z < marked+1; z++)
					{
						if(system[i][z] == null)
						{
							system[i][z] = "-1";
						}
				    }
					int[] coor = new int[2];
					int l = 0;
					Scanner lineScan = new Scanner(markedVariables[i]);
					lineScan.useDelimiter(",");
					while(lineScan.hasNext())
					{
						coor[l++] = lineScan.nextInt();
					}
					int q = coor[0];
					int s = coor[1];
					if( x[q][s+1].charAt(0) == '!' ) {}
					else 
					{
						int val = Integer.parseInt(x[q][s+1]);
						constants += val;
					}
					if( x[q-1][s].charAt(0) == '!' ) {}
					else 
					{
						int val = Integer.parseInt(x[q-1][s]);
						constants += val;
					}
					if( x[q][s-1].charAt(0) == '!' ) {}
					else 
					{
						int val = Integer.parseInt(x[q][s-1]);
						constants += val;
					}
					if( x[q+1][s].charAt(0) == '!' ) {}
					else 
					{
						int val = Integer.parseInt(x[q+1][s]);
						constants += val;
					}
					system[i][marked] = String.valueOf(constants);
					constants =0;
					lineScan.close();
				}
		
		
	return system;
		
	}
	
	public static String[][] popArray(Scanner in) throws FileNotFoundException
	{
		String[][] matrix = new String[m][n];
		int i= 0;
		int j = 0;
		while(in.hasNextLine())
		{
			String line = in.nextLine();
			Scanner lineScan = new Scanner(line);
			lineScan.useDelimiter(",");
				while(lineScan.hasNext())
				{
					String element = lineScan.next();
					if(element.charAt(0) == '!')
					{
						markedVariables[marked++] = i +"," + j;
						matrix[i][j] = element;
					}
					else
					{
						matrix[i][j] = element;
					}
					j++;
				}
				lineScan.close();
				i++;
				j = 0;
		}
	
		in.close();
		return matrix;
	}
	
	public static void getParameters(Scanner in)
	{
		int column= 0;
		int row= 0;
		while(in.hasNextLine())
		{
			String line = in.nextLine();
			if(row ==0)
			{
				Scanner lineScan = new Scanner(line);
				lineScan.useDelimiter(",");
				while(lineScan.hasNext())
				{
					String element = lineScan.next();
					column++;
				}
				lineScan.close();
			}
			row++;
		}
		m = row;
		n = column;
	}
	
}


//434,134,852,573,474,372
//699,522,!592,814,25,439
//244,!249,!186,!152,!102,921
//369,151,624,!94,812,589
//387,821,221,663,864,93
