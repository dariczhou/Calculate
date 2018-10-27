/* This class contains methods that perform various math operations
 * @author Daric Zhou
 * @version 9/6/2018
 */
public class Calculate {
	//returns the square of the input 
	public static int square(int number) {
		int answer;
		answer=number*number;
		return answer;
	}	
	//returns the cube of the input
	public static int cube(int number) {
		int answer;
		answer=number*number*number;
		return answer;
	}
	//returns average of 2 doubles
	public static double average(double num1, double num2) {
		double sum = num1+num2;
		return sum/2;	
	}
	//returns avg of three doubles
	public static double average(double num1, double num2, double num3) {
		double sum=num1+num2+num3;
		return sum/3;
	}
	//returns the radians to degrees
	public static double toDegrees(double radian) {
		double degree;
		double pi;
		pi=3.14159;
		degree=radian*(180/pi);
		return degree;
	}
	//returns the angle measure to a radian
	public static double toRadians(double degree) {
		double radian;
		double pi;
		pi=3.14159;
		radian=degree*(pi/180);
		return radian;
	}
	//returns discriminant
	public static double discriminant(double a,double b, double c) {
		double dis;
		dis=(b*b)-(4*a*c);
		return dis;
	}
	//returns the improper fraction from a mixed number
	public static String toImproperFrac(int whole, int numerator, int denominator) {
		int newnum= (whole*denominator)+numerator;
		return newnum + "/" + denominator; 
	}
	//returns the mixed number from an improper fraction
	public static String toMixedNum(int numer, int denom) {
		int newnum= (numer%denom);
		int wholenum= (numer-newnum)/denom;
		return wholenum + "_" + newnum + "/" + denom;
	} 
	//returns a quadratic equation from its factored form
	public static String foil(int a, int b, int c, int d, String x) {
		int ac= a*c;
		int bd= b*d;
		int b1= (a*d)-(b*c);
		return ac + x + "^2" + b1 + x + bd;
	}
	//returns a boolean that determines whether 2 numbers are evenly divisible
	public static boolean isDivisibleBy(int num1, int num2) {
		boolean answer;
		if(num1%num2== 0) {
			if(num2 == 0) {
				throw new IllegalArgumentException("undefined");
			}
			answer=true;//evenly divisible by one another
				}else {
				return false;
			}
			return answer;	
		}
	//returns the absolute value of many rational number
	public static double absValue(double num) {
		double answer = 0;
		if(num < 0) {
			answer= -num;//whenever the number is negative, it gets canceled out by the negative in this statement
			}else answer= num;{//straightforward positive 
			}
		return answer;
	}
	//returns the maximum value out of 2 number
	public static double max(double a, double b) {
		if(a < b) {
			return b;
	}else return a;
	}	
	//returns the maximum of the overloaded variables, with an extra variable x as the overload
	public static double max(double x, double y, double z) {
		double max = 0;
	    if (x >= y) {
	        if (x >= z) {
	        max= x;
	        } else {
	        max= z;
	        }
	    } else if (y >= x) {
	        if (y >= z) {
	        max= y;
	        } else {
	        max= z;
	        }
	    }
	    return max;
	    }
	//returns the smaller value out of 2 numbers
	public static int min(int num1, int num2) {
		if(num1 < num2) {
				return num1;
		}else return num2;
	}	
	//returns the double that is rounded to two decimal places
	public static double round2(double number) {
		if(number > 0) {
			number += 0.005; 
			}else if (number == 0) {
			number = 0;
		}else {
			number -= 0.005;
		}
		number *= 100;
		double round= (int)number;
		round /= 100;
		return round;
	}
	//raises the inputed variable to the inputed exponent
	public static double exponent(double base, int exponent) {
		//precondition
		if(exponent<0) {
			throw new IllegalArgumentException("No negative exponents");
		}
		double answer = 1;
		if(exponent >= 0) {
			for(int i = 1; i<= exponent;i++) {
				answer *= base;
			}
		}else {
			answer= 1;
		}
		return answer;
	}
	//pre : number >= 0
	//returns the factorial of an integer
	public static int factorial(int number) {
		if(number < 0) {
			throw new IllegalArgumentException("negative number: " + number);
		}
		int factor = 1;
		for(int i = 2; i <= number; i++) {
			factor *= i;
		}
		return factor;
	}
	//this method determines whether or not the integer is prime
	public static boolean isPrime(int prime) {
		boolean returned=true;
		boolean answer;
			for(int i = 2; 2*i!=prime; i++) {
				if(answer = isDivisibleBy(prime, i)) { 
					answer= false;//the number is NOT prime
					return answer;
			}
		}
		return returned;
	}
	//this method gives the greatest common factor between two integers
	public static int gcf(int x, int y) {
		int gcf = 0;
		if (x>y) {
			for (int i = y; i >= 1; i--) {
				if(isDivisibleBy(x, i) && isDivisibleBy(y, i)) {
					return i;
				}
			}
		}else {
			   for(int j = x; j >=1; j--)
		        {
		            if(isDivisibleBy(x, j) && isDivisibleBy(y, j))
		            {
		                return j;
		            }
		       }
		}
		return gcf;  
	}
	//the method returns the approximated square root of a double variable
	public static double sqrt(double x) {
		//precondition : can't have a negative sqrt
		if(x < 0) {
			throw new IllegalArgumentException("undefined: cannot have negative sqrt");
		}
		double a=x;
		double error= (1e-3)*5; //tolerance of approximation
		x= a;
	     while ((x - a/x) > error*x) {
	            x = (a/x + x) / 2.0;
	            x= round2(x);
	     }
		return x;
	}
	//pre : if a is 0, you wont be able to use the quadratic equation since it would be undefined
	//this method uses the coeff2icients of the quadratic equation and returns a String of the roots to except in the discriminant
	public static String quadForm(double a, double b, double c) {
		double quadratic;
		String output = null;
		if(a==0) {
			throw new IllegalArgumentException("Can't divide by 0");
		}
			if(discriminant(a, b, c)<0) {//cannot have negative square roots
				throw new IllegalArgumentException("no real roots");
			}
			if(discriminant(a, b, c)==0) {
				quadratic=round2(-b+sqrt(discriminant(a,b,c)))/(2*a); 
				output= String.valueOf(quadratic);//converts double to string
				return output;
			} 
			if(discriminant(a, b, c)>0) {
				double quadratic2;
				quadratic=round2((-b+sqrt(discriminant(a,b,c)))/(2*a));
				quadratic2=round2((-b-sqrt(discriminant(a,b,c)))/(2*a));
				return quadratic + " and " + quadratic2;
			}
			return output;
			
	}
}




