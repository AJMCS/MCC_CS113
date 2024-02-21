
public class Term
{
    private int exponent, coefficient;




    public Term()
    {
        setAll(1,1);
        this.exponent = 1;
        this.coefficient = 1;
    }

    public Term(int coefficient, int exponent)
    {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }



    public int getExponent()
    {
        return exponent;
    }

    public int getCoefficient()
    {
        return coefficient;
    }




    public void setExponent(int exponent)
    {
        this.exponent = exponent;
    }

    public void setCoefficient(int coefficient)
    {
        this.coefficient = coefficient;
    }

    public void setAll(int coefficient, int exponent)
    {
        this.exponent = exponent;
        this.coefficient = coefficient;
    }




    public string toString()
    {
        return "Complete this";
    }
    
}