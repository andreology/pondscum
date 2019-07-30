
public class Rational 
{
	private int ratNum[] = new int[2];
	public Rational(int x, int y)
	{
		ratNum[0] = x;
		ratNum[1] = y;
		
	}
 
	public void inverse()
	{
		int temp =0;
		 temp =ratNum[0];
		 ratNum[0] = ratNum[1];
		 ratNum[1] = temp;
	}
	public Rational add(Rational x)
	{
		if (ratNum[0] == x.ratNum[0])
		{
			setNum(ratNum[0] + x.ratNum[0]);
		}
		else 
		{
			int temp;
			ratNum[0] = ratNum[0] * x.ratNum[1];
			temp = x.ratNum[0] * ratNum[1];
			ratNum[1] = ratNum[1] * x.ratNum[1];
			ratNum[0] = temp + ratNum[0];
		}
		return this;
	}
	public Rational multiply(Rational x)
	{
		setNum(ratNum[0] * x.ratNum[0]);
		setDen(ratNum[1] * x.ratNum[1]);
		return this;
	}
	public Rational multiply0(Rational x)
	{
		Rational temp = new Rational(1,1);
		temp.setNum(ratNum[0] * x.ratNum[0]);
		temp.setDen(ratNum[1] * x.ratNum[1]);
		return temp;
	}
	
	
	public Rational fractionReduce()
	{
		int x;
		int	y;
		int z;
		x = ratNum[0];
		y = ratNum[1];
		do
		{
			z = x % y;
			x = y;
			y = z;
		} while (z != 0);
		{
			ratNum[0] = ratNum[0] / x;
			ratNum[1] = ratNum[1] / x;
		}
		return this;
	}
	public void setNum(int x)
	{
		ratNum[0] = x;
	}
	public void setDen(int y)
	{
		ratNum[1] = y;
	
	}
	public int getNum()
	{
		return ratNum[0];
	}
	
	public int getDen()
	{
		return ratNum[1];
	}
}
