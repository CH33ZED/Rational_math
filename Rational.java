/*Math  
Ziyan Lin
Ricky Wu
APCS1 pd9
HW33 -- Do You Even Add, Bro?
2015 11 18  

Instance variables for the numerator and denominator
Default constructor (no parameters)
Creates a new Rational with the value of 0/1
Constructor
takes 2 parameters, one for the numerator, one for the denominator
if an invalid denominator is attempted, should print a message and set the number to 0/1
toString
returns a string representation of the rational number (formatting of your choice)
floatValue
Returns a floating point value of the number
Uses the most precise floating point primitive
multiply
Takes 1 Rational object as a parameter and multiplies it by this Rational object
Does not return any value
Should modify this object and leave the parameter alone (see below for example)
Need not reduce the fraction
divide
Works the same as multiply, except the operation is division
add
Takes 1 Rational object (just like multiply) and adds it to the current rational number object
Need not reduce
subtract
Works the same as add, except the operation is subtraction
gcd
Returns the gcd of the numerator and denominator
Uses Euclid's algorithm (reuse your old code!)
Recall that in order for Euclid's algorithm to work, the first number must be greater than the second
reduce
Changes this Rational to one in reduced form (should use gcd)
Add a static gcd method that will take numerator and denominator inputs.
Add a method called compareTo that...
Takes a Rational as a parameter and compares it to the calling object
Returns 0 if the two numbers are equal
Returns a positive integer if the calling number is larger than the parameter
Returns a negative integer if the calling number is smaller than the parameter
*/

public class Rational{
    private int N;
    private int D;
    public Rational(){
        N = 0;
	D = 1;
    }
    public Rational(int a, int b){
        this();
        if (!(b==0)){
            N = a;
	    D = b;
        }
    }
    public String toString(){
        return N + "/" + D;
    }
    public void multiply(Rational b){
        N *= b.N;
	D *= b.D;	
    }
    public void divide(Rational b){
        N *= b.D;
	D *= b.N;
    }
    public float floatValue(){
	return N * (1.0f) / D;
    }

    public static int gcd(int a,int b){
	int remainder = a%b;
	if (remainder == 0){
	    return b;
	}
	return gcd(b,remainder);
    }
    
    public void reduce(){
	N = N/gcd(N,D);
	D = D/gcd(N,D);
    }
    public void add(Rational b){
	N = N*b.D + D*b.N;
	D *= b.D;
    }
    public void subtract(Rational b){
	N = N*b.D - D*b.N;  
	D *= b.D;
    }
    public int compareTo(Rational a){
        if (floatValue() == a.floatValue()){
           return 0;
        }
	if (floatValue() > a.floatValue()){
           return 1;
        }
        else{
           return -1;
        }
    }
    public static void main(String[] arg){
	Rational r = new Rational(1,2); //Stores the rational number 2/3
	Rational s = new Rational(2,3); //Stores the rational number 1/2
	Rational t = new Rational(9,18); //Stores the rational number 4/18
	r.add(s);  //Adds r to s, changes r to 7/6.  s remains 1/2
	t.reduce(); //Changes t to 2/9
        System.out.println(t.compareTo(s));
        System.out.println(r.compareTo(t));
    }
}
