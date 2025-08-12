package Problem_Solving.Recursion;

public class PowerOfX {

	public static void main(String[] args) {
		System.out.println(power(2, -5));
	}

	static float power(float x, int y)	{
		float temp;
		if( y == 0)
			return 1;
		temp = power(x, y/2);
//		System.out.println(temp);

		if (y%2 == 0)
			return temp*temp;
		else	{
			if(y > 0)
				return x * temp * temp;
			else
				return (temp * temp) / x;
		}
	}
}
